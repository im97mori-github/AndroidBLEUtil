package org.im97mori.ble.profile.blp.central;

import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.profile.blp.central.db.BloodPressureProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bls.central.BloodPressureService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BloodPressureProfileTest extends AbstractCentralTest {

    @Override
    public void setup() {
        super.setup();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
    }

    @Override
    public void tearDown() {
        super.tearDown();
        BLEConnection bleConnection = BLEConnectionHolder.getInstance(BLETestUtilsAndroid.MOCK_DEVICE_0);
        if (bleConnection instanceof MockBLEConnection) {
            ((MockBLEConnection) bleConnection).quitTaskHandler();
        }
        BLEConnectionHolder.clearInstance();
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_createFilteredScanCallback_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertTrue(bloodPressureProfile.createFilteredScanCallback() instanceof BloodPressureProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertTrue(bloodPressureProfile.createFilteredLeScanCallback() instanceof BloodPressureProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
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
        assertNotNull(bloodPressureProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        bloodPressureProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.hasDeviceInformationService());
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.hasDeviceInformationService());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00003() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = bloodPressureProfile.hasDeviceInformationService();
        bloodPressureProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);

        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        bloodPressureProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = bloodPressureProfile.hasDeviceInformationService();
        bloodPressureProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }


    @Test
    @RequiresDevice
    public void test_hasSystemId_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.hasSystemId());
    }

    @Test
    @RequiresDevice
    public void test_hasSystemId_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.hasSystemId());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }

                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.getManufacturerNameString());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.getModelNumberString());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getSystemId_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getSystemId());
    }

    @Test
    @RequiresDevice
    public void test_getSystemId_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer getSystemId() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.getSystemId());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isIntermediateCuffPressureSupported_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.isIntermediateCuffPressureSupported());
    }

    @Test
    @RequiresDevice
    public void test_isIntermediateCuffPressureSupported_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.isIntermediateCuffPressureSupported());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBloodPressureMeasurementClientCharacteristicConfiguration_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getBloodPressureMeasurementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getBloodPressureMeasurementClientCharacteristicConfiguration_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer getBloodPressureMeasurementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.getBloodPressureMeasurementClientCharacteristicConfiguration());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startBloodPressureMeasurementIndication_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.startBloodPressureMeasurementIndication());
    }

    @Test
    @RequiresDevice
    public void test_startBloodPressureMeasurementIndication_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer startBloodPressureMeasurementIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.startBloodPressureMeasurementIndication());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopBloodPressureMeasurementIndication_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.stopBloodPressureMeasurementIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopBloodPressureMeasurementIndication_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBloodPressureMeasurementIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.stopBloodPressureMeasurementIndication());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIntermediateCuffPressureClientCharacteristicConfiguration_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getIntermediateCuffPressureClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getIntermediateCuffPressureClientCharacteristicConfiguration_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer getIntermediateCuffPressureClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.getIntermediateCuffPressureClientCharacteristicConfiguration());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startIntermediateCuffPressureNotification_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.startIntermediateCuffPressureNotification());
    }

    @Test
    @RequiresDevice
    public void test_startIntermediateCuffPressureNotification_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer startIntermediateCuffPressureNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.startIntermediateCuffPressureNotification());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopIntermediateCuffPressureNotification_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.stopIntermediateCuffPressureNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopIntermediateCuffPressureNotification_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer stopIntermediateCuffPressureNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.stopIntermediateCuffPressureNotification());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBloodPressureFeature_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertNull(bloodPressureProfile.getBloodPressureFeature());
    }

    @Test
    @RequiresDevice
    public void test_getBloodPressureFeature_00002() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBloodPressureService == null) {
                    mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null) {
                        @Override
                        public synchronized Integer getBloodPressureFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.getBloodPressureFeature());
        bloodPressureProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        assertTrue(bloodPressureProfile.getDatabaseHelper() instanceof BloodPressureProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(bloodPressureProfile.mDeviceInformationService);
        assertNotNull(bloodPressureProfile.mBloodPressureService);
        assertTrue(atomicBoolean.get());
        bloodPressureProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        BloodPressureProfile bloodPressureProfile = new BloodPressureProfile(ApplicationProvider.getApplicationContext(), new BaseBloodPressureProfileCallback());
        bloodPressureProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        bloodPressureProfile.quit();
        assertNull(bloodPressureProfile.mDeviceInformationService);
        assertNull(bloodPressureProfile.mBloodPressureService);
    }

}
