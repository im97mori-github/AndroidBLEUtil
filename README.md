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
        implementation 'org.im97mori:ble:0.5.17' // central feature
        implementation 'org.im97mori:ble_peripheral:0.2.20' // peripheral feature
    }

## Features
### Advertising data parsing
It analyzes Advertising data byte array delivered from [LeScanCallback](https://developer.android.com/reference/android/bluetooth/BluetoothAdapter.LeScanCallback.html#onLeScan(android.bluetooth.BluetoothDevice,%20int,%20byte[])) or [ScanCallback](https://developer.android.com/reference/android/bluetooth/le/ScanCallback#onScanResult(int,%2520android.bluetooth.le.ScanResult)) as data class according to type defined in BLE5.1.

#### Jelly Bean(API 18)
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

Or software filtering callback.

ex) Callback only when Advertising data Shortend local name is "DeviceName".
 
#### Jelly Bean(API 18)
    BluetoothAdapter.getDefaultAdapter().startLeScan(new FilteredLeScanCallback.Builder().addShortenedLocalNameFilter(new byte[]{
            11 // length of data
            , 8 // Shortened Local Name Data Type
            , 68 // D
            , 101 // e
            , 118 // v
            , 105 // i
            , 99 // c
            , 101 // e
            , 78 // N
            , 97 // a
            , 109 // m
            , 101 // e
    }).build());

#### Lolipop(API 21)
    BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner().startScan(new FilteredScanCallback.Builder().addShortenedLocalNameFilter(new byte[]{
                    11 // length of data
                    , 8 // Shortened Local Name Data Type
                    , 68 // D
                    , 101 // e
                    , 118 // v
                    , 105 // i
                    , 99 // c
                    , 101 // e
                    , 78 // N
                    , 97 // a
                    , 109 // m
                    , 101 // e
            }
    ).build());
}

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
    
            mBleConnection = BLEConnectionHolder.getInstance(this, target);
            mBleConnection.attach(mBLECallbackSample);
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

or detach callback(keep connection and Handler in BLEConnectionHolder)

    @Override
    protected void onDestroy() {
        mBleConnection.detach(mBLECallbackSample);
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
  - ~~Change characteristic / descriptor / notification / indication response from central~~(not available now)
  - Change response and Service / Characteristic / Descriptor setting from peripheral

#### Start / Stop Gatt server from peripheral

    public class PeripheralSampleActivity extends BaseActivity {
    
        private BLEServerConnection mBLEServerConnection;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            
            mBLEServerConnection = new BLEServerConnection(this);
            mBLEServerConnection.attach(new BLECallbackSample(this));
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
Example(All setting change from peripheral)


    public class PeripheralSampleActivity extends BaseActivity implements View.OnClickListener {
    
        private BLEServerConnection mBLEServerConnection;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            
            mBLEServerConnection = new BLEServerConnection(this);
            mBLEServerConnection.attach(new BLECallbackSample(this));
        }
        
        @Override
        public void onClick(View v) {
            mBLEServerConnection.start();
            mBLEServerConnection.startAdvertising();
        }
        
        @Override
        protected void onDestroy() {
            mBLEServerConnection.quit();
            super.onDestroy();
        }
    }
    
    public class BLECallbackSample extends BaseMockCallback implements BLECallback {
    
        BLECallbackSample(SampleCallback sampleCallback) {
            super(new SampleMockData.Builder().build(), true);
            mSampleCallback = sampleCallback;
        }
        
        ...
    }
    
    public class SampleMockData extends MockData {
    
        public static final UUID SAMPLE_PRIMARY_SERVICE_1 = UUID.fromString("00000001-a087-4fa3-add4-3b8a7d5d4921");
    
        public static final UUID SAMPLE_READABLE_CHARACTERISTIC = UUID.fromString("00000010-a087-4fa3-add4-3b8a7d5d4921");
    
        public static final UUID SAMPLE_READABLE_DESCRIPTOR = UUID.fromString("00000100-a087-4fa3-add4-3b8a7d5d4921");
    
        public static final UUID SAMPLE_WRITABLE_CHARACTERISTIC = UUID.fromString("00000020-a087-4fa3-add4-3b8a7d5d4921");
    
        public static final UUID SAMPLE_WRITABLE_DESCRIPTOR = UUID.fromString("00000200-a087-4fa3-add4-3b8a7d5d4921");
    
        public static final UUID SAMPLE_NOTIFICATABLE_CHARACTERISTIC = UUID.fromString("00000030-a087-4fa3-add4-3b8a7d5d4921");
    
        public static final UUID SAMPLE_INDICATABLE_CHARACTERISTIC = UUID.fromString("00000040-a087-4fa3-add4-3b8a7d5d4921");
    
        public static final UUID SAMPLE_WRITE_CHARACTERISTIC_RELIABLE = UUID.fromString("00000050-a087-4fa3-add4-3b8a7d5d4921");
    
        public static final UUID SAMPLE_PRIMARY_SERVICE_2 = UUID.fromString("00000002-a087-4fa3-add4-3b8a7d5d4922");
    
        public static final UUID SAMPLE_READABLE_CHARACTERISTIC_2 = UUID.fromString("00000060-a087-4fa3-add4-3b8a7d5d4921");
    
    
        public static class Builder {
    
            private final List<ServiceData> mServiceDataList = new LinkedList<>();
    
            public Builder() {
                ServiceData serviceData;
                CharacteristicData characteristicData;
                List<CharacteristicData> characteristicDataList;
                DescriptorData descriptorData;
                List<DescriptorData> descriptorDataList;
    
                characteristicDataList = new LinkedList<>();
                descriptorDataList = new LinkedList<>();
                descriptorData = new DescriptorData();
                descriptorData.uuid = SAMPLE_READABLE_DESCRIPTOR;
                descriptorData.permission = BluetoothGattDescriptor.PERMISSION_READ;
                descriptorData.responseCode = BluetoothGatt.GATT_SUCCESS;
                descriptorData.delay = 0;
                descriptorData.data = SAMPLE_READABLE_DESCRIPTOR.toString().getBytes();
                descriptorDataList.add(descriptorData);
                characteristicData = new CharacteristicData();
                characteristicData.uuid = SAMPLE_READABLE_CHARACTERISTIC;
                characteristicData.property = BluetoothGattCharacteristic.PROPERTY_READ;
                characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_READ;
                characteristicData.descriptorDataList = descriptorDataList;
                characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
                characteristicData.delay = 0;
                characteristicData.data = SAMPLE_READABLE_CHARACTERISTIC.toString().getBytes();
                characteristicDataList.add(characteristicData);
    
                descriptorDataList = new LinkedList<>();
                descriptorData = new DescriptorData();
                descriptorData.uuid = SAMPLE_WRITABLE_DESCRIPTOR;
                descriptorData.permission = BluetoothGattDescriptor.PERMISSION_WRITE;
                descriptorData.responseCode = BluetoothGatt.GATT_SUCCESS;
                descriptorData.delay = 0;
                descriptorData.data = null;
                descriptorDataList.add(descriptorData);
                characteristicData = new CharacteristicData();
                characteristicData.uuid = SAMPLE_WRITABLE_CHARACTERISTIC;
                characteristicData.property = BluetoothGattCharacteristic.PROPERTY_WRITE;
                characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_WRITE;
                characteristicData.descriptorDataList = descriptorDataList;
                characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
                characteristicData.delay = 0;
                characteristicData.data = null;
                characteristicDataList.add(characteristicData);
    
                descriptorDataList = new LinkedList<>();
                descriptorData = new DescriptorData();
                descriptorData.uuid = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
                descriptorData.permission = BluetoothGattDescriptor.PERMISSION_WRITE;
                descriptorData.responseCode = BluetoothGatt.GATT_SUCCESS;
                descriptorData.delay = 0;
                descriptorData.data = null;
                descriptorDataList.add(descriptorData);
                characteristicData = new CharacteristicData();
                characteristicData.uuid = SAMPLE_NOTIFICATABLE_CHARACTERISTIC;
                characteristicData.property = BluetoothGattCharacteristic.PROPERTY_NOTIFY;
                characteristicData.permission = 0;
                characteristicData.descriptorDataList = descriptorDataList;
                characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
                characteristicData.delay = 0;
                characteristicData.data = SAMPLE_NOTIFICATABLE_CHARACTERISTIC.toString().getBytes();
                characteristicDataList.add(characteristicData);
    
                descriptorDataList = new LinkedList<>();
                descriptorData = new DescriptorData();
                descriptorData.uuid = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
                descriptorData.permission = BluetoothGattDescriptor.PERMISSION_WRITE;
                descriptorData.responseCode = BluetoothGatt.GATT_SUCCESS;
                descriptorData.delay = 0;
                descriptorData.data = null;
                descriptorDataList.add(descriptorData);
                characteristicData = new CharacteristicData();
                characteristicData.uuid = SAMPLE_INDICATABLE_CHARACTERISTIC;
                characteristicData.property = BluetoothGattCharacteristic.PROPERTY_INDICATE;
                characteristicData.permission = 0;
                characteristicData.descriptorDataList = descriptorDataList;
                characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
                characteristicData.delay = 0;
                characteristicData.data = SAMPLE_INDICATABLE_CHARACTERISTIC.toString().getBytes();
                characteristicDataList.add(characteristicData);
    
                descriptorDataList = new LinkedList<>();
                characteristicData = new CharacteristicData();
                characteristicData.uuid = SAMPLE_WRITE_CHARACTERISTIC_RELIABLE;
                characteristicData.property = BluetoothGattCharacteristic.PROPERTY_WRITE;
                characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_WRITE;
                characteristicData.descriptorDataList = descriptorDataList;
                characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
                characteristicData.delay = 0;
                characteristicData.data = null;
                characteristicDataList.add(characteristicData);
                serviceData = new ServiceData();
                serviceData.uuid = SAMPLE_PRIMARY_SERVICE_1;
                serviceData.type = BluetoothGattService.SERVICE_TYPE_PRIMARY;
                serviceData.characteristicDataList = characteristicDataList;
                mServiceDataList.add(serviceData);
    
                characteristicDataList = new LinkedList<>();
                characteristicData = new CharacteristicData();
                characteristicData.uuid = SAMPLE_READABLE_CHARACTERISTIC_2;
                characteristicData.property = BluetoothGattCharacteristic.PROPERTY_READ;
                characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_READ;
                characteristicData.descriptorDataList = descriptorDataList;
                characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
                characteristicData.delay = 0;
                characteristicData.data = SAMPLE_READABLE_CHARACTERISTIC_2.toString().getBytes();
                characteristicDataList.add(characteristicData);
                characteristicData = new CharacteristicData();
                characteristicData.uuid = SAMPLE_READABLE_CHARACTERISTIC_2;
                characteristicData.property = BluetoothGattCharacteristic.PROPERTY_READ;
                characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_READ;
                characteristicData.descriptorDataList = descriptorDataList;
                characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
                characteristicData.delay = 0;
                characteristicData.data = SAMPLE_READABLE_CHARACTERISTIC_2.toString().getBytes();
                characteristicDataList.add(characteristicData);
                serviceData = new ServiceData();
                serviceData.uuid = SAMPLE_PRIMARY_SERVICE_2;
                serviceData.type = BluetoothGattService.SERVICE_TYPE_PRIMARY;
                serviceData.characteristicDataList = characteristicDataList;
                mServiceDataList.add(serviceData);
            }
    
            public SampleMockData build() {
                SampleMockData sampleMockData = new SampleMockData();
                sampleMockData.serviceDataList = mServiceDataList;
                return sampleMockData;
            }
        }
    
    }

**Warning** change peripheral's service / characteristic / descriptor setting after bonded, central's 
[BluetoothGattCallback#onConnectionStateChange](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html#onConnectionStateChange(android.bluetooth.BluetoothGatt,%20int,%20int)) return 133 error.  
if you change peripheral's service / characteristic / descriptor setting, need re-bonding.