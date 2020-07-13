package org.im97mori.ble.profile.blp.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.profile.blp.central.db.BloodPressureProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bls.central.BloodPressureService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

// TODO
public class BloodPressureProfileTest {

    @Test
    public void test_findBloodPressureProfileDevices_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.findBloodPressureProfileDevices(null));
    }

    @Test
    public void test_findBloodPressureProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        bloodPressureProfile.start();
        assertNotNull(bloodPressureProfile.findBloodPressureProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        bloodPressureProfile.quit();
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.hasManufacturerNameString());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_hasModelNumberString_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.hasModelNumberString());
    }

    @Test
    public void test_hasModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.hasModelNumberString());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getManufacturerNameString());
    }

    @Test
    public void test_getManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null) {

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
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.getManufacturerNameString());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getModelNumberString());
    }

    @Test
    public void test_getModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null) {

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
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.getModelNumberString());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_isIntermediateCuffPressureSupported_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.isIntermediateCuffPressureSupported());
    }

    @Test
    public void test_isIntermediateCuffPressureSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.isIntermediateCuffPressureSupported());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_getBloodPressureMeasurementClientCharacteristicConfiguration_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getBloodPressureMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getBloodPressureMeasurementClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.getBloodPressureMeasurementClientCharacteristicConfiguration());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_startBloodPressureMeasurementIndication_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.startBloodPressureMeasurementIndication());
    }

    @Test
    public void test_startBloodPressureMeasurementIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.startBloodPressureMeasurementIndication());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_stopBloodPressureMeasurementIndication_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.stopBloodPressureMeasurementIndication());
    }

    @Test
    public void test_stopBloodPressureMeasurementIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.stopBloodPressureMeasurementIndication());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_getIntermediateCuffPressureClientCharacteristicConfiguration_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getIntermediateCuffPressureClientCharacteristicConfiguration());
    }

    @Test
    public void test_getIntermediateCuffPressureClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.getIntermediateCuffPressureClientCharacteristicConfiguration());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_startIntermediateCuffPressureNotification_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.startIntermediateCuffPressureNotification());
    }

    @Test
    public void test_startIntermediateCuffPressureNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.startIntermediateCuffPressureNotification());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_stopIntermediateCuffPressureNotification_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.stopIntermediateCuffPressureNotification());
    }

    @Test
    public void test_stopIntermediateCuffPressureNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.stopIntermediateCuffPressureNotification());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_getBloodPressureFeature_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getBloodPressureFeature());
    }

    @Test
    public void test_getBloodPressureFeature_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null);
                }
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.getBloodPressureFeature());
        bloodPressureProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertTrue(bloodPressureProfile.getDatabaseHelper() instanceof BloodPressureProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()){
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.mDeviceInformationService);
        assertNotNull(bloodPressureProfile.mBloodPressureService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        bloodPressureProfile.connect(MOCK_DEVICE);
        bloodPressureProfile.quit();
        assertNull(bloodPressureProfile.mDeviceInformationService);
        assertNull(bloodPressureProfile.mBloodPressureService);
    }

}
