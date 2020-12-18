package org.im97mori.ble.profile.cpp.central;

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
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.profile.cpp.central.db.CyclingPowerProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.cps.central.CyclingPowerService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_VECTOR_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CYCLING_POWER_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CyclingPowerProfileTest {

    @Test
    public void test_findCyclingPowerProfileDevices_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.findCyclingPowerProfileDevices(null));
    }

    @Test
    public void test_findCyclingPowerProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        cyclingPowerProfile.start();
        assertNotNull(cyclingPowerProfile.findCyclingPowerProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        cyclingPowerProfile.quit();
    }

    @Test
    public void test_hasDeviceInformationService_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasDeviceInformationService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.mDeviceInformationService = new DeviceInformationService(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), cyclingPowerProfile.mCyclingPowerProfileCallback, null);
        assertNotNull(cyclingPowerProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasBatteryService_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.hasBatteryService());
    }

    @Test
    public void test_hasBatteryService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.mBatteryService = new BatteryService(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), cyclingPowerProfile.mCyclingPowerProfileCallback, null);
        assertNotNull(cyclingPowerProfile.hasBatteryService());
    }

    @Test
    public void test_isCyclingPowerControlPointCharacteristicSupporeted_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.isCyclingPowerControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_isCyclingPowerControlPointCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.isCyclingPowerControlPointCharacteristicSupporeted());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_isCyclingPowerVectorCharacteristicSupporeted_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.isCyclingPowerVectorCharacteristicSupporeted());
    }

    @Test
    public void test_isCyclingPowerVectorCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.isCyclingPowerVectorCharacteristicSupporeted());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getCyclingPowerFeature_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getCyclingPowerFeature());
    }

    @Test
    public void test_getCyclingPowerFeature_00002() {
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

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.getCyclingPowerFeature());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getCyclingPowerMeasurementClientCharacteristicConfiguration_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getCyclingPowerMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCyclingPowerMeasurementClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.getCyclingPowerMeasurementClientCharacteristicConfiguration());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startCyclingPowerMeasurementNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startCyclingPowerMeasurementNotification());
    }

    @Test
    public void test_startCyclingPowerMeasurementNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.startCyclingPowerMeasurementNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopCyclingPowerMeasurementNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopCyclingPowerMeasurementNotification());
    }

    @Test
    public void test_stopCyclingPowerMeasurementNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.stopCyclingPowerMeasurementNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getSensorLocation_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getSensorLocation());
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

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.getSensorLocation());
        cyclingPowerProfile.disconnect();
    }


    @Test
    public void test_setCyclingPowerControlPoint_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0})));
    }

    @Test
    public void test_setCyclingPowerControlPoint_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.mCyclingPowerService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0})));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getCyclingPowerControlPointClientCharacteristicConfiguration_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getCyclingPowerControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCyclingPowerControlPointClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isCyclingPowerControlPointCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.mCyclingPowerService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.getCyclingPowerControlPointClientCharacteristicConfiguration());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startCyclingPowerControlPointIndication_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startCyclingPowerControlPointIndication());
    }

    @Test
    public void test_startCyclingPowerControlPointIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.mCyclingPowerService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.startCyclingPowerControlPointIndication());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopCyclingPowerControlPointIndication_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopCyclingPowerControlPointIndication());
    }

    @Test
    public void test_stopCyclingPowerControlPointIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.mCyclingPowerService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.stopCyclingPowerControlPointIndication());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getCyclingPowerVectorClientCharacteristicConfiguration_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getCyclingPowerVectorClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCyclingPowerVectorClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isCyclingPowerControlPointCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.mCyclingPowerService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.getCyclingPowerVectorClientCharacteristicConfiguration());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startCyclingPowerVectorNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startCyclingPowerVectorNotification());
    }

    @Test
    public void test_startCyclingPowerVectorNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.mCyclingPowerService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.startCyclingPowerVectorNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopCyclingPowerVectorNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopCyclingPowerVectorNotification());
    }

    @Test
    public void test_stopCyclingPowerVectorNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.mCyclingPowerService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.stopCyclingPowerVectorNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.hasManufacturerNameString());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_hasModelNumberString_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.hasModelNumberString());
    }

    @Test
    public void test_hasModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.hasModelNumberString());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getManufacturerNameString());
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

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null) {

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
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.getManufacturerNameString());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getModelNumberString());
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

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null) {

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
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.getModelNumberString());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCount_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelCount());
    }

    @Test
    public void test_getBatteryLevelCount_00002() {
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

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(BATTERY_SERVICE, 0)), null);
        assertNotNull(cyclingPowerProfile.getBatteryLevelCount());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevel_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevel());
    }

    @Test
    public void test_getBatteryLevel_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, 0, 0));

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.getBatteryLevel());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevel_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevel(0));
    }

    @Test
    public void test_getBatteryLevel_00102() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, 0, 0));

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.getBatteryLevel(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_isBatteryLevelNotificatable_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.isBatteryLevelNotificatable());
    }

    @Test
    public void test_isBatteryLevelNotificatable_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.isBatteryLevelNotificatable());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_isBatteryLevelNotificatable_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00102() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.isBatteryLevelNotificatable(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelCharacteristicPresentationFormat());
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.getBatteryLevelCharacteristicPresentationFormat());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.getBatteryLevelCharacteristicPresentationFormat(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelClientCharacteristicConfiguration());
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.getBatteryLevelClientCharacteristicConfiguration());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.getBatteryLevelClientCharacteristicConfiguration(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startBatteryLevelNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startBatteryLevelNotification());
    }

    @Test
    public void test_startBatteryLevelNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.startBatteryLevelNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startBatteryLevelNotification_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startBatteryLevelNotification(0));
    }

    @Test
    public void test_startBatteryLevelNotification_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.startBatteryLevelNotification(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopBatteryLevelNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopBatteryLevelNotification());
    }

    @Test
    public void test_stopBatteryLevelNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.stopBatteryLevelNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopBatteryLevelNotification_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopBatteryLevelNotification(0));
    }

    @Test
    public void test_stopBatteryLevelNotification_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingPowerProfile.stopBatteryLevelNotification(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertTrue(cyclingPowerProfile.getDatabaseHelper() instanceof CyclingPowerProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        cyclingPowerProfile.connect(MOCK_DEVICE);
        assertNotNull(cyclingPowerProfile.mCyclingPowerService);
        assertNotNull(cyclingPowerProfile.mDeviceInformationService);
        assertNotNull(cyclingPowerProfile.mBatteryService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        cyclingPowerProfile.connect(MOCK_DEVICE);
        cyclingPowerProfile.quit();
        assertNull(cyclingPowerProfile.mCyclingPowerService);
        assertNull(cyclingPowerProfile.mDeviceInformationService);
        assertNull(cyclingPowerProfile.mBatteryService);
    }

}
