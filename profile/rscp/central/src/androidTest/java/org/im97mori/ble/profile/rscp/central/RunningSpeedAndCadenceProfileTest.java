package org.im97mori.ble.profile.rscp.central;

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
import org.im97mori.ble.profile.rscp.central.db.RunningSpeedAndCadenceProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.rscs.central.RunningSpeedAndCadenceService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RunningSpeedAndCadenceProfileTest {

    @Test
    public void test_findRunningSpeedAndCadenceProfileDevices_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.findRunningSpeedAndCadenceProfileDevices(null));
    }

    @Test
    public void test_findRunningSpeedAndCadenceProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        runningSpeedAndCadenceProfile.start();
        assertNotNull(runningSpeedAndCadenceProfile.findRunningSpeedAndCadenceProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        runningSpeedAndCadenceProfile.quit();
    }

    @Test
    public void test_hasDeviceInformationService_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasDeviceInformationService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.mDeviceInformationService = new DeviceInformationService(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceProfileCallback, null);
        assertNotNull(runningSpeedAndCadenceProfile.hasDeviceInformationService());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getRSCFeature_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getRSCFeature());
    }

    @Test
    public void test_getRSCFeature_00002() {
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

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.getRSCFeature());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getRSCMeasurementClientCharacteristicConfiguration_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getRSCMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRSCMeasurementClientCharacteristicConfiguration_00002() {
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

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.getRSCMeasurementClientCharacteristicConfiguration());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_startRSCMeasurementNotification_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.startRSCMeasurementNotification());
    }

    @Test
    public void test_startRSCMeasurementNotification_00002() {
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

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.startRSCMeasurementNotification());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_stopRSCMeasurementNotification_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.stopRSCMeasurementNotification());
    }

    @Test
    public void test_stopRSCMeasurementNotification_00002() {
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

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.stopRSCMeasurementNotification());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getSensorLocation_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getSensorLocation());
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(runningSpeedAndCadenceProfile.getSensorLocation());
        runningSpeedAndCadenceProfile.disconnect();
    }


    @Test
    public void test_setSCControlPoint_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS})));
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(runningSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS})));
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration());
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(runningSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_startSCControlPointIndication_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.startSCControlPointIndication());
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(runningSpeedAndCadenceProfile.startSCControlPointIndication());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_stopSCControlPointIndication_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.stopSCControlPointIndication());
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(runningSpeedAndCadenceProfile.stopSCControlPointIndication());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.hasManufacturerNameString());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_hasModelNumberString_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.hasModelNumberString());
    }

    @Test
    public void test_hasModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.hasModelNumberString());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getManufacturerNameString());
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

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {

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
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.getManufacturerNameString());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getModelNumberString());
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

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {

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
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.getModelNumberString());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertTrue(runningSpeedAndCadenceProfile.getDatabaseHelper() instanceof RunningSpeedAndCadenceProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        assertNotNull(runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService);
        assertNotNull(runningSpeedAndCadenceProfile.mDeviceInformationService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        runningSpeedAndCadenceProfile.connect(MOCK_DEVICE);
        runningSpeedAndCadenceProfile.quit();
        assertNull(runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService);
        assertNull(runningSpeedAndCadenceProfile.mDeviceInformationService);
    }

}
