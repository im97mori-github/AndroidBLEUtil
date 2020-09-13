package org.im97mori.ble.profile.htp.central;

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
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.profile.htp.central.db.HealthThermometerProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.hts.central.HealthThermometerService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HealthThermometerProfileTest {

    @Test
    public void test_findHealthThermometerProfileDevices_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.findHealthThermometerProfileDevices(null));
    }

    @Test
    public void test_findHealthThermometerProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        healthThermometerProfile.start();
        assertNotNull(healthThermometerProfile.findHealthThermometerProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        healthThermometerProfile.quit();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getManufacturerNameString());
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null) {

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
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
            }
        };
        healthThermometerProfile.connect(MOCK_DEVICE);
        healthThermometerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(healthThermometerProfile.getManufacturerNameString());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getModelNumberString());
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null) {

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
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
            }
        };
        healthThermometerProfile.connect(MOCK_DEVICE);
        healthThermometerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(healthThermometerProfile.getModelNumberString());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getSystemId_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getSystemId());
    }

    @Test
    public void test_getSystemId_00002() {
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null) {

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
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
            }
        };
        healthThermometerProfile.connect(MOCK_DEVICE);
        healthThermometerProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(healthThermometerProfile.getSystemId());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isTemperatureTypeCharacteristicSupporeted_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isTemperatureTypeCharacteristicSupporeted());
    }

    @Test
    public void test_isTemperatureTypeCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.isTemperatureTypeCharacteristicSupporeted());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isIntermediateTemperatureCharacteristicSupporeted_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isIntermediateTemperatureCharacteristicSupporeted());
    }

    @Test
    public void test_isIntermediateTemperatureCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.isIntermediateTemperatureCharacteristicSupporeted());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicSupporeted_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isMeasurementIntervalCharacteristicSupporeted());
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.isMeasurementIntervalCharacteristicSupporeted());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicIndicateSupporeted_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isMeasurementIntervalCharacteristicIndicateSupporeted());
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicIndicateSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.isMeasurementIntervalCharacteristicIndicateSupporeted());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicWriteSupporeted_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isMeasurementIntervalCharacteristicWriteSupporeted());
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicWriteSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.isMeasurementIntervalCharacteristicWriteSupporeted());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getTemperatureMeasurementClientCharacteristicConfiguration_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getTemperatureMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTemperatureMeasurementClientCharacteristicConfiguration_00002() {
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.getTemperatureMeasurementClientCharacteristicConfiguration());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_startTemperatureMeasurementIndication_00001() {
        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(heartRateProfile.startTemperatureMeasurementIndication());
    }

    @Test
    public void test_startTemperatureMeasurementIndication_00002() {
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

        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.startTemperatureMeasurementIndication());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_stopHeartRateMeasurementIndication_00001() {
        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(heartRateProfile.stopHeartRateMeasurementIndication());
    }

    @Test
    public void test_stopHeartRateMeasurementIndication_00002() {
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

        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        heartRateProfile.connect(MOCK_DEVICE);
        assertNotNull(heartRateProfile.stopHeartRateMeasurementIndication());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_getTemperatureType_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getTemperatureType());
    }

    @Test
    public void test_getTemperatureType_00002() {
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isTemperatureTypeCharacteristicSupporeted() {
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
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.getTemperatureType());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getIntermediateTemperatureClientCharacteristicConfiguration_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getIntermediateTemperatureClientCharacteristicConfiguration());
    }

    @Test
    public void test_getIntermediateTemperatureClientCharacteristicConfiguration_00002() {
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isIntermediateTemperatureCharacteristicSupporeted() {
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
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.getIntermediateTemperatureClientCharacteristicConfiguration());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_startIntermediateTemperatureNotification_00001() {
        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(heartRateProfile.startIntermediateTemperatureNotification());
    }

    @Test
    public void test_startIntermediateTemperatureNotification_00002() {
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

        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isIntermediateTemperatureCharacteristicSupporeted() {
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
        assertNotNull(heartRateProfile.startIntermediateTemperatureNotification());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_stopIntermediateTemperaturNotification_00001() {
        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(heartRateProfile.stopIntermediateTemperaturNotification());
    }

    @Test
    public void test_stopIntermediateTemperaturNotification_00002() {
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

        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isIntermediateTemperatureCharacteristicSupporeted() {
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
        assertNotNull(heartRateProfile.stopIntermediateTemperaturNotification());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_getMeasurementInterval_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getMeasurementInterval());
    }

    @Test
    public void test_getMeasurementInterval_00002() {
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isMeasurementIntervalCharacteristicSupporeted() {
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
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.getMeasurementInterval());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_setMeasurementInterval_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.setMeasurementInterval(new MeasurementInterval(0)));
    }

    @Test
    public void test_setMeasurementInterval_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isMeasurementIntervalCharacteristicWriteSupporeted() {
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
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.setMeasurementInterval(new MeasurementInterval(0)));
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getMeasurementIntervalClientCharacteristicConfiguration_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getMeasurementIntervalClientCharacteristicConfiguration());
    }

    @Test
    public void test_getMeasurementIntervalClientCharacteristicConfiguration_00002() {
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isMeasurementIntervalCharacteristicIndicateSupporeted() {
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
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.getMeasurementIntervalClientCharacteristicConfiguration());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_startMeasurementIntervalInidication_00001() {
        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(heartRateProfile.startMeasurementIntervalInidication());
    }

    @Test
    public void test_startMeasurementIntervalInidication_00002() {
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

        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isMeasurementIntervalCharacteristicIndicateSupporeted() {
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
        assertNotNull(heartRateProfile.startMeasurementIntervalInidication());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_stopMeasurementIntervalInidication_00001() {
        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(heartRateProfile.stopMeasurementIntervalInidication());
    }

    @Test
    public void test_stopMeasurementIntervalInidication_00002() {
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

        HealthThermometerProfile heartRateProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isMeasurementIntervalCharacteristicIndicateSupporeted() {
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
        assertNotNull(heartRateProfile.stopMeasurementIntervalInidication());
        heartRateProfile.disconnect();
    }

    @Test
    public void test_getMeasurementIntervalValidRange_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getMeasurementIntervalValidRange());
    }

    @Test
    public void test_getMeasurementIntervalValidRange_00002() {
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

        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
                }
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {

                        @Override
                        public boolean isMeasurementIntervalCharacteristicWriteSupporeted() {
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
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.getMeasurementIntervalValidRange());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertTrue(healthThermometerProfile.getDatabaseHelper() instanceof HealthThermometerProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        healthThermometerProfile.connect(MOCK_DEVICE);
        assertNotNull(healthThermometerProfile.mDeviceInformationService);
        assertNotNull(healthThermometerProfile.mHealthThermometerService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        healthThermometerProfile.connect(MOCK_DEVICE);
        healthThermometerProfile.quit();
        assertNull(healthThermometerProfile.mDeviceInformationService);
        assertNull(healthThermometerProfile.mHealthThermometerService);
    }

}
