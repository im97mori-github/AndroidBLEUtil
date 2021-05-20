package org.im97mori.ble.profile.htp.central;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.profile.htp.central.db.HealthThermometerProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.hts.central.HealthThermometerService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HealthThermometerProfileTest extends AbstractCentralTest {

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
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getSystemId() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.getSystemId());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isTemperatureTypeCharacteristicSupported_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isTemperatureTypeCharacteristicSupported());
    }

    @Test
    public void test_isTemperatureTypeCharacteristicSupported_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.isTemperatureTypeCharacteristicSupported());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isIntermediateTemperatureCharacteristicSupported_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isIntermediateTemperatureCharacteristicSupported());
    }

    @Test
    public void test_isIntermediateTemperatureCharacteristicSupported_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.isIntermediateTemperatureCharacteristicSupported());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicSupported_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isMeasurementIntervalCharacteristicSupported());
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicSupported_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.isMeasurementIntervalCharacteristicSupported());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicIndicateSupported_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isMeasurementIntervalCharacteristicIndicateSupported());
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicIndicateSupported_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.isMeasurementIntervalCharacteristicIndicateSupported());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicWriteSupported_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.isMeasurementIntervalCharacteristicWriteSupported());
    }

    @Test
    public void test_isMeasurementIntervalCharacteristicWriteSupported_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.isMeasurementIntervalCharacteristicWriteSupported());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getTemperatureMeasurementClientCharacteristicConfiguration_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getTemperatureMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTemperatureMeasurementClientCharacteristicConfiguration_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getTemperatureMeasurementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.getTemperatureMeasurementClientCharacteristicConfiguration());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_startTemperatureMeasurementIndication_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.startTemperatureMeasurementIndication());
    }

    @Test
    public void test_startTemperatureMeasurementIndication_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer startTemperatureMeasurementIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.startTemperatureMeasurementIndication());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_stopHeartRateMeasurementIndication_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.stopHeartRateMeasurementIndication());
    }

    @Test
    public void test_stopHeartRateMeasurementIndication_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer stopHeartRateMeasurementIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.stopHeartRateMeasurementIndication());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getTemperatureType_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getTemperatureType());
    }

    @Test
    public void test_getTemperatureType_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getTemperatureType() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getIntermediateTemperatureClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.getIntermediateTemperatureClientCharacteristicConfiguration());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_startIntermediateTemperatureNotification_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.startIntermediateTemperatureNotification());
    }

    @Test
    public void test_startIntermediateTemperatureNotification_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer startIntermediateTemperatureNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.startIntermediateTemperatureNotification());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_stopIntermediateTemperaturNotification_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.stopIntermediateTemperaturNotification());
    }

    @Test
    public void test_stopIntermediateTemperaturNotification_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer stopIntermediateTemperaturNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.stopIntermediateTemperaturNotification());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getMeasurementInterval_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getMeasurementInterval());
    }

    @Test
    public void test_getMeasurementInterval_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getMeasurementInterval() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer setMeasurementInterval(@NonNull MeasurementInterval measurementInterval) {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getMeasurementIntervalClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.getMeasurementIntervalClientCharacteristicConfiguration());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_startMeasurementIntervalInidication_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.startMeasurementIntervalInidication());
    }

    @Test
    public void test_startMeasurementIntervalInidication_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer startMeasurementIntervalInidication() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.startMeasurementIntervalInidication());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_stopMeasurementIntervalInidication_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.stopMeasurementIntervalInidication());
    }

    @Test
    public void test_stopMeasurementIntervalInidication_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer stopMeasurementIntervalInidication() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.stopMeasurementIntervalInidication());
        healthThermometerProfile.disconnect();
    }

    @Test
    public void test_getMeasurementIntervalValidRange_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        assertNull(healthThermometerProfile.getMeasurementIntervalValidRange());
    }

    @Test
    public void test_getMeasurementIntervalValidRange_00002() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHealthThermometerService == null) {
                    mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null) {
                        @Override
                        public synchronized Integer getMeasurementIntervalValidRange() {
                            return 1;
                        }
                    };
                }
            }
        };
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(healthThermometerProfile.mDeviceInformationService);
        assertNotNull(healthThermometerProfile.mHealthThermometerService);
        assertTrue(atomicBoolean.get());
        healthThermometerProfile.quit();
    }

    @Test
    public void test_quit_00001() {
        HealthThermometerProfile healthThermometerProfile = new HealthThermometerProfile(ApplicationProvider.getApplicationContext(), new BaseHealthThermometerProfileCallback());
        healthThermometerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        healthThermometerProfile.quit();
        assertNull(healthThermometerProfile.mDeviceInformationService);
        assertNull(healthThermometerProfile.mHealthThermometerService);
    }

}
