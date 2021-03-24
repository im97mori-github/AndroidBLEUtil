package org.im97mori.ble.profile.cscp.central;

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
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.profile.cscp.central.db.CyclingSpeedAndCadenceProfileBondedDatabaseHelper;
import org.im97mori.ble.service.cscs.central.CyclingSpeedAndCadenceService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CyclingSpeedAndCadenceProfileTest {

    @Test
    public void test_findCyclingSpeedAndCadenceProfileDevices_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.findCyclingSpeedAndCadenceProfileDevices(null));
    }

    @Test
    public void test_findCyclingSpeedAndCadenceProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        cyclingSpeedAndCadenceProfile.start();
        assertNotNull(cyclingSpeedAndCadenceProfile.findCyclingSpeedAndCadenceProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        cyclingSpeedAndCadenceProfile.quit();
    }

    @Test
    public void test_hasDeviceInformationService_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasDeviceInformationService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.mDeviceInformationService = new DeviceInformationService(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceProfileCallback, null);
        assertNotNull(cyclingSpeedAndCadenceProfile.hasDeviceInformationService());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getCSCFeature_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getCSCFeature());
    }

    @Test
    public void test_getCSCFeature_00002() {
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

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.getCSCFeature());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getCSCMeasurementClientCharacteristicConfiguration_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getCSCMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCSCMeasurementClientCharacteristicConfiguration_00002() {
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

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.getCSCMeasurementClientCharacteristicConfiguration());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_startCSCMeasurementNotification_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.startCSCMeasurementNotification());
    }

    @Test
    public void test_startCSCMeasurementNotification_00002() {
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

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.startCSCMeasurementNotification());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_stopCSCMeasurementNotification_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.stopCSCMeasurementNotification());
    }

    @Test
    public void test_stopCSCMeasurementNotification_00002() {
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

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.stopCSCMeasurementNotification());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getSensorLocation_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getSensorLocation());
    }

    @Test
    public void test_getSensorLocation_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.getSensorLocation());
        cyclingSpeedAndCadenceProfile.disconnect();
    }


    @Test
    public void test_setSCControlPoint_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS})));
    }

    @Test
    public void test_setSCControlPoint_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS})));
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_startSCControlPointIndication_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.startSCControlPointIndication());
    }

    @Test
    public void test_startSCControlPointIndication_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.startSCControlPointIndication());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_stopSCControlPointIndication_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.stopSCControlPointIndication());
    }

    @Test
    public void test_stopSCControlPointIndication_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.stopSCControlPointIndication());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.hasManufacturerNameString());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_hasModelNumberString_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.hasModelNumberString());
    }

    @Test
    public void test_hasModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.hasModelNumberString());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getManufacturerNameString());
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

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {

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
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.getManufacturerNameString());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getModelNumberString());
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

        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {

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
            }
        };
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.getModelNumberString());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertTrue(cyclingSpeedAndCadenceProfile.getDatabaseHelper() instanceof CyclingSpeedAndCadenceProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService);
        assertNotNull(cyclingSpeedAndCadenceProfile.mDeviceInformationService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        cyclingSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        cyclingSpeedAndCadenceProfile.quit();
        assertNull(cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService);
        assertNull(cyclingSpeedAndCadenceProfile.mDeviceInformationService);
    }

}
