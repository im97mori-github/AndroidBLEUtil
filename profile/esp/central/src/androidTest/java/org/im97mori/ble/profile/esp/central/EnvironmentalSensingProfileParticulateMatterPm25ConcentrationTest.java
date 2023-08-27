package org.im97mori.ble.profile.esp.central;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.service.ess.central.EnvironmentalSensingService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EnvironmentalSensingProfileParticulateMatterPm25ConcentrationTest extends AbstractCentralTest {

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
    public void test_getParticulateMatterPm25Concentration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25Concentration());
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25Concentration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25Concentration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25Concentration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25Concentration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25Concentration(0));
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25Concentration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25Concentration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25Concentration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startParticulateMatterPm25ConcentrationNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    public void test_startParticulateMatterPm25ConcentrationNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startParticulateMatterPm25ConcentrationNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startParticulateMatterPm25ConcentrationNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startParticulateMatterPm25ConcentrationNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startParticulateMatterPm25ConcentrationNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_startParticulateMatterPm25ConcentrationNotification_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startParticulateMatterPm25ConcentrationNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startParticulateMatterPm25ConcentrationNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopParticulateMatterPm25ConcentrationNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopParticulateMatterPm25ConcentrationNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopParticulateMatterPm25ConcentrationNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopParticulateMatterPm25ConcentrationNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopParticulateMatterPm25ConcentrationNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopParticulateMatterPm25ConcentrationNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_stopParticulateMatterPm25ConcentrationNotification_00102() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopParticulateMatterPm25ConcentrationNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopParticulateMatterPm25ConcentrationNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00002() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0));
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicUserDescription(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicUserDescription());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicUserDescription(0));
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicUserDescription(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicUserDescription(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setParticulateMatterPm25ConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[]{0})));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setParticulateMatterPm25ConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[]{0})));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationValidRange_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationValidRange());
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationValidRange_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationValidRange(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationValidRange());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationValidRange_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationValidRange(0));
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationValidRange_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationValidRange(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationValidRange(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCount());
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCount_00002() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_canParticulateMatterPm25ConcentrationNotify_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.canParticulateMatterPm25ConcentrationNotify());
    }

    @Test
    @RequiresDevice
    public void test_canParticulateMatterPm25ConcentrationNotify_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.canParticulateMatterPm25ConcentrationNotify());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_canParticulateMatterPm25ConcentrationNotify_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.canParticulateMatterPm25ConcentrationNotify(0));
    }

    @Test
    @RequiresDevice
    public void test_canParticulateMatterPm25ConcentrationNotify_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.canParticulateMatterPm25ConcentrationNotify(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0));
    }

    @Test
    @RequiresDevice
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicValidRange());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicValidRange(0));
    }

    @Test
    @RequiresDevice
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicValidRange(0));
        environmentalSensingProfile.disconnect();
    }

}
