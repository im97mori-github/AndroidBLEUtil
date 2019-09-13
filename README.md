# Simple Advertising data parser and BLE Connection for Android

## Prerequire
### Central feature
minSdkVersion 18
### Peripheral feature
minSdkVersion 21

## Download
project/build.gradle

    repositories {
        google()
        jcenter()
        maven { url "https://github.com/im97mori-github/maven/raw/master" }
    }

project/module/build.gradle

    dependencies {
        implementation 'org.im97mori:ble:0.2.2' // central feature
        implementation 'org.im97mori:ble_peripheral:0.1.2' // peripheral feature
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

### BLE Connection(central)
Every connection has one [Handler](https://developer.android.com/reference/android/os/Handler)(aka worker thread).  
Request and response processing is queing as a task and processed in order within the handler.  
Therefore, only one task is always executed for the peripheral, and continuous request issuance that can not be processed by the peripheral is suppressed.  
The task is always queinged with a timeout value to prevent the remaining tasks that are not processing complete.    

#### Asynchronous
Begin connection

    public class CentralSampleActivity extends Activity implements BLECallback {
    
        private BLEConnection mBleConnection;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    
            Intent intent = getIntent();
            BluetoothDevice bluetoothDevice = intent.getParcelableExtra("device");
    
            mBleConnection = new BLEConnection(this, target, mBLECallbackSample);
            mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
        }

On success

    @Override
    public void onBLEConnected(long taskId, BluetoothDevice bluetoothDevice, Bundle argument);
        // Success!
    }

On fail

    @Override
    public void onBLEConnectFailed(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument);
        // Failed
    }

On timeout(default 50sec)

    @Override
    public void onBLEConnectTimeout(BluetoothDevice bluetoothDevice) {onBLEConnectTimeout(long taskId, BluetoothDevice bluetoothDevice, Bundle argument);
        // Timeout
    }

Finish connection(release Handler)

    @Override
    protected void onDestroy() {
        mBleConnection.quit();
        super.onDestroy();
    }
 
Read characteristic
 
    @Override
    public void onBLEConnected(long taskId, BluetoothDevice bluetoothDevice, Bundle argument);
        // create read task
        mBleConnection.createReadCharacteristicTask(BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE
                , BLEConstants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC
                , ReadCharacteristicTask.TIMEOUT_MILLIS);
    }
    
    // read success
    @Override
    public void onCharacteristicReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument);
        if (BLEConstants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
            DeviceName deviceName = DeviceName.CREATOR.createFromByteArray(values);
            System.out.println(deviceName.getName());
        }
    }

Write characteristic
 
    @Override
    public void onBLEConnected(long taskId, BluetoothDevice bluetoothDevice, Bundle argument);
        mBleConnection.createWriteCharacteristicTask(UUID.fromString("your writable characteristic's service uuid")
                , UUID.fromString(" your writable charcteristic uuid")
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return new byte[]{0x00, 0x00, 0x00, 0x00, 0x00};
                    }
                }
                , WriteCharacteristicTask.TIMEOUT_MILLIS);
    }
    
    // write success
    @Override
    public onCharacteristicWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument);
        if (UUID.fromString(" your writable charcteristic uuid").equals(characteristicUUID)) {
            // create your data class from byte arrays
            
            // or BluetoothGattCharacteristic instance
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(characteristicUUID, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
        }
    }

#### Synchronous
Begin connection to finish connection

    public class MainActivity extends Activity {
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            new Thread() {
                    @Override
                    public void run() {
                        Intent intent = getIntent();
                        BluetoothDevice target = intent.getParcelableExtra("device");
                        BLESyncConnection bleSyncConnection = new BLESyncConnection(MainActivity.this, target);
                        BLESyncConnection.BLEResult result = bleSyncConnection.connect(ConnectTask.TIMEOUT_MILLIS, ConnectTask.TIMEOUT_MILLIS, null);
                        if (BLESyncConnection.BLEResult.RESULT_SUCCESS == result.getResultCode()) {
                            // Success!
                            
                            // finish
                            result = bleSyncConnection.quit();
                        } else if (BLESyncConnection.BLEResult.RESULT_FAILED == result.getResultCode()) {
                            // Failed
                        } else if (BLESyncConnection.BLEResult.RESULT_TIMEOUT == result.getResultCode()) {
                            // Timeout
                        }
                    }
            }.start();

Read characteristic

    result = bleSyncConnection.createReadCharacteristicTask(BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE
        , BLEConstants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC
        , ReadCharacteristicTask.TIMEOUT_MILLIS
        , ReadCharacteristicTask.TIMEOUT_MILLIS
        , null);
    if (BLESyncConnection.BLEResult.RESULT_SUCCESS == result.getResultCode()) {
        DeviceName deviceName = DeviceName.CREATOR.createFromByteArray(result.getValues());
        System.out.println(deviceName.getName());
    }

Instant read characteristic with connected BLEConnection

        if (bleConnection == null || !bleConnection.isConnected()) return;

        BLESyncConnection.BLEResult result = BLESyncConnection.createReadCharacteristicTask(
                bleConnection
                , BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE
                , BLEConstants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , null);
        if (BLESyncConnection.BLEResult.RESULT_SUCCESS == result.getResultCode()) {
            DeviceName deviceName = DeviceName.CREATOR.createFromByteArray(result.getValues());
            System.out.println(deviceName.getName());
        }

### BLE Connection(peripheral)
This is experimental feature.

Feature list
- Start / Stop Gatt server from peripheral
- Advertising with Incomplete List of 128-bit Service Class UUIDs for find, bonding, connect from central
- Mock peripheral's response
  - Change characteristic / descriptor / notification / indication response from central
  - Change response and Service / Characteristic / Descriptor setting from peripheral

#### Start / Stop Gatt server from peripheral

    public class PeripheralSampleActivity extends BaseActivity {
    
        private BLEServerConnection mBLEServerConnection;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            
            mBLEServerConnection = new BLEServerConnection(this, new BLECallbackSample(this));
            mBLEServerConnection.start();
        }
        
        @Override
        protected void onDestroy() {
            mBLEServerConnection.quit();
            super.onDestroy();
        }

#### Advertising with Incomplete List of 128-bit Service Class UUIDs for find, bonding, connect from central
Advertising automaticaly start when gatt server started.  
Advertising data include custom "00000000-a087-4fa3-add4-3b8a7d5d491f" Incomplete List of 128-bit Service Class UUIDs.

#### Mock peripheral's response
Gatt server has Custom Service UUID "00000000-a087-4fa3-add4-3b8a7d5d491f" and writable characteristic "00000001-a087-4fa3-add4-3b8a7d5d491f" for change response from central.

Example1(Characteristic response change from central)

    final String newMessage = UUID.randomUUID().toString();
    BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
            MOCK_CONTROL_SERVICE_UUID                                   // <-- Custom Service UUID for mock response
            , MOCK_CONTROL_CHARACTERISTIC_UUID                          // <-- Custom Characteristic UUID for mock response
            , new MockControl(DEFAULT_SERVICE_UUID                      // <-- Mock target Service UUID
                    , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT // <-- Mock target Characteristic UUID
                    , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID           // <-- Mock type Characterisitic read response (or notification / indication response)
                    , MockControl.TARGET_TYPE_CHARACTERISTIC            // <-- Mock target Characterisitic (or descritpor / notification / indication / clear mock)
                    , BluetoothGatt.GATT_SUCCESS                        // <-- Mock response status
                    , newMessage.getBytes())                            // <-- Mock response value byte array
            , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
            , WriteCharacteristicTask.TIMEOUT_MILLIS
            , DateUtils.MINUTE_IN_MILLIS
            , null);

Example1(All setting change from peripheral)


    public class PeripheralSampleActivity extends BaseActivity implements View.OnClickListener {
    
        private BLEServerConnection mBLEServerConnection;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            
            mBLEServerConnection = new BLEServerConnection(this, new BLECallbackSample(this));
            mBLEServerConnection.start();
        }
        
        @Override
        public void onClick(View v) {
            mBLEServerConnection.updateServerCallback(new BLEServerCallback() {
                @Override
                public void onServerStarted() {
                    
                }
    
                ...
    
                @Override
                public void onMockUpdated(BluetoothDevice device, MockControl mockControl) {
    
                }
            });
        }
        
        @Override
        protected void onDestroy() {
            mBLEServerConnection.quit();
            super.onDestroy();
        }

**Warning** change peripheral's service / characteristic / descriptor setting after bonded, central's 
[BluetoothGattCallback#onConnectionStateChange](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html#onConnectionStateChange(android.bluetooth.BluetoothGatt,%20int,%20int)) return 133 error.  
if you change peripheral's service / characteristic / descriptor setting, need re-bonding.