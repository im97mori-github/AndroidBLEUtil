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
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EnvironmentalSensingProfileNonMethaneVolatileOrganicCompoundsConcentrationTest extends AbstractCentralTest {

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
    public void test_getNonMethaneVolatileOrganicCompoundsConcentration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentration());
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentration(0));
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startNonMethaneVolatileOrganicCompoundsConcentrationNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startNonMethaneVolatileOrganicCompoundsConcentrationNotification());
    }

    @Test
    @RequiresDevice
    public void test_startNonMethaneVolatileOrganicCompoundsConcentrationNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startNonMethaneVolatileOrganicCompoundsConcentrationNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startNonMethaneVolatileOrganicCompoundsConcentrationNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startNonMethaneVolatileOrganicCompoundsConcentrationNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startNonMethaneVolatileOrganicCompoundsConcentrationNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_startNonMethaneVolatileOrganicCompoundsConcentrationNotification_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startNonMethaneVolatileOrganicCompoundsConcentrationNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startNonMethaneVolatileOrganicCompoundsConcentrationNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopNonMethaneVolatileOrganicCompoundsConcentrationNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopNonMethaneVolatileOrganicCompoundsConcentrationNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopNonMethaneVolatileOrganicCompoundsConcentrationNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopNonMethaneVolatileOrganicCompoundsConcentrationNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopNonMethaneVolatileOrganicCompoundsConcentrationNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_stopNonMethaneVolatileOrganicCompoundsConcentrationNotification_00102() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement_00002() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 0));
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0));
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[]{0})));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[]{0})));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationValidRange());
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationValidRange());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(0));
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCount());
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCount_00002() {

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
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable());
    }

    @Test
    @RequiresDevice
    public void test_isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable(0));
    }

    @Test
    @RequiresDevice
    public void test_isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0));
    }

    @Test
    @RequiresDevice
    public void test_getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(0));
    }

    @Test
    @RequiresDevice
    public void test_hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(0));
        environmentalSensingProfile.disconnect();
    }

}
