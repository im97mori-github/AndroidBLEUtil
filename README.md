# Simple Advertising data parser and BLE Connection for Android

## Prerequire
minSdkVersion 19

## Download
project/build.gradle

    repositories {
        google()
        jcenter()
        maven { url "https://github.com/im97mori-github/maven/raw/master" }
    }

project/module/build.gradle

    dependencies {
        implementation 'org.im97mori:ble:0.1.0'
    }

## Features
### Advertising data parsing
It analyzes Advertising data byte array delivered from [LeScanCallback](https://developer.android.com/reference/android/bluetooth/BluetoothAdapter.LeScanCallback.html#onLeScan(android.bluetooth.BluetoothDevice,%20int,%20byte[])) or [ScanCallback](https://developer.android.com/reference/android/bluetooth/le/ScanCallback#onScanResult(int,%2520android.bluetooth.le.ScanResult)) as data class according to type defined in BLE5.1.

#### Kitkat(API 19)
    class TestLeScanCallback implements BluetoothAdapter.LeScanCallback {
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
            AdvertisingDataParser parser = builder.build();

            AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(scanRecord);

#### Lolipop(API 21)
    class TestScanCallback extends ScanCallback {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            ScanRecord scanRecord = result.getScanRecord();
            if (scanRecord != null) {
                AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
                AdvertisingDataParser parser = builder.build();

                AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(scanRecord.getBytes());

All analysis results are included in AdvertisingDataParseResult.

### BLE Connection
Every connection has one [Handler](https://developer.android.com/reference/android/os/Handler)(aka worker thread).
Request and response processing is queing as a task and processed in order within the handler.
Therefore, only one task is always executed for the peripheral, and continuous request issuance that can not be processed by the peripheral is suppressed.
The task is always queinged with a timeout value to prevent the remaining tasks that are not processing complete.  

Begin connection

    public class MainActivity extends Activity implements BLECallback {
    
        private BLEConnection bleConnection;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    
            Intent intent = getIntent();
            BluetoothDevice bluetoothDevice = intent.getParcelableExtra("device");
    
            bleConnection = new BLEConnection(this, bluetoothDevice, this);
            bleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
        }

On success

    @Override
    public void onBLEConnected(BluetoothDevice bluetoothDevice) {
        // Success!
    }

On fail(or timeout, default 50sec)

    @Override
    public void onBLEConnectTimeout(BluetoothDevice bluetoothDevice) {
        // Fail or timeout
    }

Finish connection(release Handler)

    @Override
    protected void onDestroy() {
        bleConnection.quit();
        super.onDestroy();
    }
 
Read characteristic
 
    @Override
    public void onBLEConnected(BluetoothDevice bluetoothDevice) {
        // create read task
        bleConnection.createReadCharacteristicTask(
                BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE
                , BLEConstants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC
                , ReadCharacteristicTask.TIMEOUT_MILLIS
        );
    }
    
    // read success
    @Override
    public void onCharacteristicReadSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values) {
        if (BLEConstants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
            DeviceName deviceName = DeviceName.CREATOR.createFromByteArray(values);
            System.out.println(deviceName.getName());
        }
    }

Write characteristic
 
    @Override
    public void onBLEConnected(BluetoothDevice bluetoothDevice) {
        bleConnection.createWriteCharacteristicTask(
                UUID.fromString("your writable characteristic's service uuid")
                , UUID.fromString(" your writable charcteristic uuid")
                // your data class
                , new AbstractCharacteristic() {
                
                    // return byte array for BluetoothGattCharacteristic.setValue();
                    @Override
                    public byte[] getBytes() {
                        return new byte[0];
                    }
                }
                , WriteCharacteristicTask.TIMEOUT_MILLIS
        );
    }
    
    // write success
    @Override
    public void onCharacteristicReadSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values) {
        if (UUID.fromString(" your writable charcteristic uuid").equals(characteristicUUID)) {
            // create your data class from byte arrays
            
            // or BluetoothGattCharacteristic instance
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UUID.fromString(" your writable charcteristic uuid"), 0, 0);
            bluetoothGattCharacteristic.setValue(values);
        }
    }
