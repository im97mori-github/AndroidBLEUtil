package org.im97mori.ble.profile.hrp.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
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
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.profile.hrp.central.db.HeartRateProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.hrs.central.HeartRateService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HeartRateProfileTest {

    @Test
    public void test_findHeartRateProfileDevices_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.findHeartRateProfileDevices(null));
    }

    @Test
    public void test_findHeartRateProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        heartRateProfile.start();
        assertNotNull(heartRateProfile.findHeartRateProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        heartRateProfile.quit();
    }

    @Test
    public void test_hasDeviceInformationService_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasDeviceInformationService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.hasDeviceInformationService());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_hasDeviceInformationService_00101() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        int taskId = 1;
        List<BluetoothGattService> serviceList = new ArrayList<>();

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        Boolean hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertFalse(hasDeviceInformationService);
        heartRateProfile.disconnect();
    }

    @Test
    public void test_hasDeviceInformationService_00102() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        int taskId = 1;
        List<BluetoothGattService> serviceList = new ArrayList<>();
        serviceList.add(new BluetoothGattService(GENERIC_ACCESS_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY));

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        Boolean hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertFalse(hasDeviceInformationService);
        heartRateProfile.disconnect();
    }

    @Test
    public void test_hasDeviceInformationService_00103() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        int taskId = 1;
        List<BluetoothGattService> serviceList = new ArrayList<>();
        serviceList.add(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY));

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        Boolean hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertTrue(hasDeviceInformationService);
        heartRateProfile.disconnect();
    }

    @Test
    public void test_hasDeviceInformationService_00104() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        int taskId = 1;
        List<BluetoothGattService> serviceList = new ArrayList<>();
        serviceList.add(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY));

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        Boolean hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertTrue(hasDeviceInformationService);
        heartRateProfile.disconnect();
        hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertFalse(hasDeviceInformationService);
    }

    @Test
    public void test_hasDeviceInformationService_00105() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        int taskId = 1;
        List<BluetoothGattService> serviceList = new ArrayList<>();
        serviceList.add(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY));

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        Boolean hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertTrue(hasDeviceInformationService);
        heartRateProfile.disconnect();
        hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertFalse(hasDeviceInformationService);

        serviceList.clear();
        serviceList.add(new BluetoothGattService(GENERIC_ACCESS_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY));
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertFalse(hasDeviceInformationService);
        heartRateProfile.disconnect();
    }

    @Test
    public void test_hasDeviceInformationService_00106() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        int taskId = 1;
        List<BluetoothGattService> serviceList = new ArrayList<>();
        serviceList.add(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY));

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        Boolean hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertTrue(hasDeviceInformationService);
        heartRateProfile.disconnect();
        hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        serviceList.clear();
        serviceList.add(new BluetoothGattService(GENERIC_ACCESS_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY));
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertFalse(hasDeviceInformationService);
        heartRateProfile.disconnect();

        serviceList.clear();
        serviceList.add(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY));
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(taskId, MOCK_DEVICE, serviceList, null);
        hasDeviceInformationService = heartRateProfile.hasDeviceInformationService();
        assertNotNull(hasDeviceInformationService);
        assertTrue(hasDeviceInformationService);
        heartRateProfile.disconnect();
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(heartRateProfile.hasManufacturerNameString());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.getManufacturerNameString());
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

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null) {

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
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null);
                }
            }
        };
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(heartRateProfile.getManufacturerNameString());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_isBodySensorLocationCharacteristicSupporeted_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.isBodySensorLocationCharacteristicSupporeted());
    }

    @Test
    public void test_isBodySensorLocationCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null);
                }
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isBodySensorLocationCharacteristicSupporeted() {
                            return true;
                        }

                    };
                }
            }
        };
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.isBodySensorLocationCharacteristicSupporeted());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_isHeartRateControlPointCharacteristicSupporeted_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.isHeartRateControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_isHeartRateControlPointCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null);
                }
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isHeartRateControlPointCharacteristicSupporeted() {
                            return true;
                        }

                    };
                }
            }
        };
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.isHeartRateControlPointCharacteristicSupporeted());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_getHeartRateMeasurementClientCharacteristicConfiguration_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.getHeartRateMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getHeartRateMeasurementClientCharacteristicConfiguration_00002() {
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

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null);
                }
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.getHeartRateMeasurementClientCharacteristicConfiguration());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_startHeartRateMeasurementNotification_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.startHeartRateMeasurementNotification());
    }

    @Test
    public void test_startHeartRateMeasurementNotification_00002() {
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

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null);
                }
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.startHeartRateMeasurementNotification());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_stopHeartRateMeasurementNotification_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.stopHeartRateMeasurementNotification());
    }

    @Test
    public void test_stopHeartRateMeasurementNotification_00002() {
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

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null);
                }
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.stopHeartRateMeasurementNotification());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_getBodySensorLocation_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.getBodySensorLocation());
    }

    @Test
    public void test_getBodySensorLocation_00002() {
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

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null);
                }
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {

                        @Override
                        public boolean isBodySensorLocationCharacteristicSupporeted() {
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
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.getBodySensorLocation());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_setHeartRateControlPoint_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.setHeartRateControlPoint(new HeartRateControlPoint(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED)));
    }

    @Test
    public void test_setHeartRateControlPoint_00002() {
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

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null);
                }
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {

                        @Override
                        public boolean isHeartRateControlPointCharacteristicSupporeted() {
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
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.setHeartRateControlPoint(new HeartRateControlPoint(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED)));
        heartRateProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertTrue(heartRateProfile.getDatabaseHelper() instanceof HeartRateProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.mDeviceInformationService);
        assertNotNull(heartRateProfile.mHeartRateService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        heartRateProfile.connect(MOCK_DEVICE);
        heartRateProfile.quit();
        assertNull(heartRateProfile.mDeviceInformationService);
        assertNull(heartRateProfile.mHeartRateService);
    }

}
