package org.im97mori.ble.profile.wsp.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.profile.wsp.central.db.WeightScaleProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.bcs.central.BodyCompositionService;
import org.im97mori.ble.service.cts.central.CurrentTimeService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.uds.central.UserDataService;
import org.im97mori.ble.service.wss.central.WeightScaleService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BODY_COMPOSITION_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CURRENT_TIME_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.USER_DATA_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class WeightScaleProfileTest {

    @Test
    public void test_findWeightScaleProfileDevices_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.findWeightScaleProfileDevices(null));
    }

    @Test
    public void test_findBloodPressureProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        weightScaleProfile.start();
        assertNotNull(weightScaleProfile.findWeightScaleProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        weightScaleProfile.quit();
    }

    @Test
    public void test_hasBodyCompositionService_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasBodyCompositionService());
    }

    @Test
    public void test_hasBodyCompositionService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized boolean isConnected() {
                return true;
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        weightScaleProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(BODY_COMPOSITION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY)), null);
        assertNotNull(weightScaleProfile.hasBodyCompositionService());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_hasUserDataService_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasUserDataService());
    }

    @Test
    public void test_hasUserDataService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized boolean isConnected() {
                return true;
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        weightScaleProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(USER_DATA_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY)), null);
        assertNotNull(weightScaleProfile.hasUserDataService());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_hasBatteryService_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasBatteryService());
    }

    @Test
    public void test_hasBatteryService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized boolean isConnected() {
                return true;
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        weightScaleProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY)), null);
        assertNotNull(weightScaleProfile.hasBatteryService());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_hasCurrentTimeService_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasCurrentTimeService());
    }

    @Test
    public void test_hasCurrentTimeService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized boolean isConnected() {
                return true;
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        weightScaleProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(CURRENT_TIME_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY)), null);
        assertNotNull(weightScaleProfile.hasCurrentTimeService());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getWeightScaleFeature_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getWeightScaleFeature());
    }

    @Test
    public void test_getWeightScaleFeature_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getWeightScaleFeature());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getWeightMeasurementClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getWeightMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getWeightMeasurementClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getWeightMeasurementClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_startWeightMeasurementIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startWeightMeasurementIndication());
    }

    @Test
    public void test_startWeightMeasurementIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.startWeightMeasurementIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_stopWeightMeasurementIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopWeightMeasurementIndication());
    }

    @Test
    public void test_stopWeightMeasurementIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.stopWeightMeasurementIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_hasSystemId_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasSystemId());
    }

    @Test
    public void test_hasSystemId_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean hasPnpId() {
                            return true;
                        }

                    };
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.hasSystemId());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getManufacturerNameString());
    }

    @Test
    public void test_getManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean hasManufacturerNameString() {
                            return true;
                        }

                    };
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getManufacturerNameString());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getModelNumberString());
    }

    @Test
    public void test_getModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean hasModelNumberString() {
                            return true;
                        }

                    };
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getModelNumberString());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getSystemId_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getSystemId());
    }

    @Test
    public void test_getSystemId_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean hasSystemId() {
                            return true;
                        }

                    };
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getSystemId());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBodyCompositionFeature_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBodyCompositionFeature());
    }

    @Test
    public void test_getBodyCompositionFeature_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getBodyCompositionFeature());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isAgeCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isAgeCharacteristicSupported());
    }

    @Test
    public void test_isAgeCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isAgeCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isDateOfBirthCharacteristicSupported());
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isDateOfBirthCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isFirstNameCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isFirstNameCharacteristicSupported());
    }

    @Test
    public void test_isFirstNameCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isFirstNameCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isHeightCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isHeightCharacteristicSupported());
    }

    @Test
    public void test_isHeightCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isHeightCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isGenderCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isGenderCharacteristicSupported());
    }

    @Test
    public void test_isGenderCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isGenderCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isDatabaseChangeIncrementCharacteristicNotifySupported());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getAge_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getAge());
    }

    @Test
    public void test_getAge_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isAgeCharacteristicSupported() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getAge());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setAge_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setAge(new Age(1)));
    }

    @Test
    public void test_setAge_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isAgeCharacteristicSupported() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setAge(new Age(1)));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getDateOfBirth_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getDateOfBirth());
    }

    @Test
    public void test_getDateOfBirth_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isDateOfBirthCharacteristicSupported() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getDateOfBirth());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setDateOfBirth_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setDateOfBirth(new DateOfBirth(0, 0, 0)));
    }

    @Test
    public void test_setDateOfBirth_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isDateOfBirthCharacteristicSupported() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setDateOfBirth(new DateOfBirth(0, 0, 0)));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getFirstName_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getFirstName());
    }

    @Test
    public void test_getFirstName_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isFirstNameCharacteristicSupported() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getFirstName());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setFirstName_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setFirstName(new FirstName("")));
    }

    @Test
    public void test_setFirstName_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isFirstNameCharacteristicSupported() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setFirstName(new FirstName("")));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getHeight_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getHeight());
    }

    @Test
    public void test_getHeight_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isHeightCharacteristicSupported() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getHeight());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setHeight_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setHeight(new Height(0)));
    }

    @Test
    public void test_setHeight_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isHeightCharacteristicSupported() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setHeight(new Height(0)));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getGender_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getGender());
    }

    @Test
    public void test_getGender_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isGenderCharacteristicSupported() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getGender());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setGender_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setGender(new Gender(0)));
    }

    @Test
    public void test_setGender_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isGenderCharacteristicSupported() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setGender(new Gender(0)));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getDatabaseChangeIncrement_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getDatabaseChangeIncrement());
    }

    @Test
    public void test_getDatabaseChangeIncrement_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getDatabaseChangeIncrement());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setDatabaseChangeIncrement_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setDatabaseChangeIncrement(new DatabaseChangeIncrement(0)));
    }

    @Test
    public void test_setDatabaseChangeIncrement_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setDatabaseChangeIncrement(new DatabaseChangeIncrement(0)));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getDatabaseChangeIncrementClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_startDatabaseChangeIncrementNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_startDatabaseChangeIncrementNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.startDatabaseChangeIncrementNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_stopDatabaseChangeIncrementNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_stopDatabaseChangeIncrementNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.stopDatabaseChangeIncrementNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getUserIndex_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getUserIndex());
    }

    @Test
    public void test_getUserIndex_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getUserIndex());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getRegisteredUserClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getRegisteredUserClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRegisteredUserClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getRegisteredUserClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }


    @Test
    public void test_startRegisteredUserIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startRegisteredUserIndication());
    }

    @Test
    public void test_startRegisteredUserIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.startRegisteredUserIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_stopRegisteredUserIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopRegisteredUserIndication());
    }

    @Test
    public void test_stopRegisteredUserIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.stopRegisteredUserIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setUserControlPoint_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setUserControlPoint(new UserControlPoint(0, 0, 0, 0, 0, 0)));
    }

    @Test
    public void test_setUserControlPoint_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setUserControlPoint(new UserControlPoint(0, 0, 0, 0, 0, 0)));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getUserControlPointClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getUserControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getUserControlPointClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getUserControlPointClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_startUserControlPointIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startUserControlPointIndication());
    }

    @Test
    public void test_startUserControlPointIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.startUserControlPointIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_stopUserControlPointIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopUserControlPointIndication());
    }

    @Test
    public void test_stopUserControlPointIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.stopUserControlPointIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBodyCompositionMeasurementClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBodyCompositionMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getBodyCompositionMeasurementClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getBodyCompositionMeasurementClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_startBodyCompositionMeasurementIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startBodyCompositionMeasurementIndication());
    }

    @Test
    public void test_startBodyCompositionMeasurementIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.startBodyCompositionMeasurementIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_stopBodyCompositionMeasurementIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopBodyCompositionMeasurementIndication());
    }

    @Test
    public void test_stopBodyCompositionMeasurementIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.stopBodyCompositionMeasurementIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCount_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelCount());
    }

    @Test
    public void test_getBatteryLevelCount_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getBatteryLevelCount());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevel_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevel());
    }

    @Test
    public void test_getBatteryLevel_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        weightScaleProfile.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(weightScaleProfile.getBatteryLevel());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevel_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevel(0));
    }

    @Test
    public void test_getBatteryLevel_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getBatteryLevel(0));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isBatteryLevelNotificatable_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isBatteryLevelNotificatable());
    }

    @Test
    public void test_isBatteryLevelNotificatable_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ));
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isBatteryLevelNotificatable());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isBatteryLevelNotificatable_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ));
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isBatteryLevelNotificatable(0));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelCharacteristicPresentationFormat());
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getBatteryLevelCharacteristicPresentationFormat());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getBatteryLevelCharacteristicPresentationFormat(0));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelClientCharacteristicConfiguration());
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getBatteryLevelClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getBatteryLevelClientCharacteristicConfiguration(0));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_startBatteryLevelNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startBatteryLevelNotification());
    }

    @Test
    public void test_startBatteryLevelNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.startBatteryLevelNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_startBatteryLevelNotification_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startBatteryLevelNotification(0));
    }

    @Test
    public void test_startBatteryLevelNotification_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.startBatteryLevelNotification(0));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_stopBatteryLevelNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopBatteryLevelNotification());
    }

    @Test
    public void test_stopBatteryLevelNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.stopBatteryLevelNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_stopBatteryLevelNotification_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopBatteryLevelNotification(0));
    }

    @Test
    public void test_stopBatteryLevelNotification_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                    BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY);
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                    mBatteryService.onDiscoverServiceSuccess(0, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.stopBatteryLevelNotification(0));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isCurrentTimeCharacteristicWritable_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_isCurrentTimeCharacteristicWritable_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isCurrentTimeCharacteristicWritable());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isLocalTimeInformationCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicWritable_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicWritable_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isLocalTimeInformationCharacteristicWritable());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_isReferenceTimeInformationCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    public void test_isReferenceTimeInformationCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.isReferenceTimeInformationCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getCurrentTime_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getCurrentTime());
    }

    @Test
    public void test_getCurrentTime_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getCurrentTime());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setCurrentTime_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setCurrentTime(new CurrentTime(new byte[10])));
    }

    @Test
    public void test_setCurrentTime_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isCurrentTimeCharacteristicWritable() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setCurrentTime(new CurrentTime(new byte[10])));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getCurrentTimeClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getCurrentTimeClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCurrentTimeClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getCurrentTimeClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_startCurrentTimeNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startCurrentTimeNotification());
    }

    @Test
    public void test_startCurrentTimeNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.startCurrentTimeNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_stopCurrentTimeNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopCurrentTimeNotification());
    }

    @Test
    public void test_stopCurrentTimeNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.stopCurrentTimeNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getLocalTimeInformation_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getLocalTimeInformation());
    }

    @Test
    public void test_getLocalTimeInformation_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isLocalTimeInformationCharacteristicSupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getLocalTimeInformation());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_setLocalTimeInformation_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setLocalTimeInformation(new LocalTimeInformation(new byte[2])));
    }

    @Test
    public void test_setLocalTimeInformation_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isLocalTimeInformationCharacteristicSupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.setLocalTimeInformation(new LocalTimeInformation(new byte[2])));
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getReferenceTimeInformation_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getReferenceTimeInformation());
    }

    @Test
    public void test_getReferenceTimeInformation_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
                }
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public boolean isReferenceTimeInformationCharacteristicSupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.getReferenceTimeInformation());
        weightScaleProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertTrue(weightScaleProfile.getDatabaseHelper() instanceof WeightScaleProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        weightScaleProfile.connect(MOCK_DEVICE);
        assertNotNull(weightScaleProfile.mWeightScaleService);
        assertNotNull(weightScaleProfile.mDeviceInformationService);
        assertNotNull(weightScaleProfile.mUserDataService);
        assertNotNull(weightScaleProfile.mBodyCompositionService);
        assertNotNull(weightScaleProfile.mBatteryService);
        assertNotNull(weightScaleProfile.mCurrentTimeService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        weightScaleProfile.connect(MOCK_DEVICE);
        weightScaleProfile.quit();
        assertNull(weightScaleProfile.mWeightScaleService);
        assertNull(weightScaleProfile.mDeviceInformationService);
        assertNull(weightScaleProfile.mUserDataService);
        assertNull(weightScaleProfile.mBodyCompositionService);
        assertNull(weightScaleProfile.mBatteryService);
        assertNull(weightScaleProfile.mCurrentTimeService);
    }

}
