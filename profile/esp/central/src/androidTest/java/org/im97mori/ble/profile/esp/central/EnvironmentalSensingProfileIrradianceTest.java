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

public class EnvironmentalSensingProfileIrradianceTest extends AbstractCentralTest {

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
    public void test_getIrradiance_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradiance());
    }

    @Test
    @RequiresDevice
    public void test_getIrradiance_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradiance(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradiance());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradiance_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradiance(0));
    }

    @Test
    @RequiresDevice
    public void test_getIrradiance_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradiance(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradiance(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startIrradianceNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startIrradianceNotification());
    }

    @Test
    @RequiresDevice
    public void test_startIrradianceNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startIrradianceNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startIrradianceNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startIrradianceNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startIrradianceNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_startIrradianceNotification_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startIrradianceNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startIrradianceNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopIrradianceNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopIrradianceNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopIrradianceNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopIrradianceNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopIrradianceNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopIrradianceNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopIrradianceNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_stopIrradianceNotification_00102() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopIrradianceNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopIrradianceNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingMeasurement_00002() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceEnvironmentalSensingMeasurement(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingMeasurement());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingMeasurement_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingMeasurement_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceEnvironmentalSensingMeasurement(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingMeasurement(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingTriggerSetting());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingTriggerSetting_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingTriggerSetting(0, 0));
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingTriggerSetting_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingTriggerSetting(0, 0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setIrradianceEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setIrradianceEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setIrradianceEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceEnvironmentalSensingTriggerSetting_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setIrradianceEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceEnvironmentalSensingTriggerSetting_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setIrradianceEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setIrradianceEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceEnvironmentalSensingConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceEnvironmentalSensingConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceEnvironmentalSensingConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setIrradianceEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setIrradianceEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setIrradianceEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setIrradianceEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setIrradianceEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setIrradianceEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceCharacteristicUserDescription(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceCharacteristicUserDescription());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceCharacteristicUserDescription(0));
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceCharacteristicUserDescription(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceCharacteristicUserDescription(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setIrradianceCharacteristicUserDescription(new CharacteristicUserDescription(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setIrradianceCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setIrradianceCharacteristicUserDescription(new CharacteristicUserDescription(new byte[]{0})));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setIrradianceCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setIrradianceCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setIrradianceCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setIrradianceCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[]{0})));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceValidRange_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceValidRange());
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceValidRange_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceValidRange(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceValidRange());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceValidRange_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceValidRange(0));
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceValidRange_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceValidRange(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceValidRange(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceCount());
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCount_00002() {

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
        assertNotNull(environmentalSensingProfile.getIrradianceCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_canIrradianceNotify_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.canIrradianceNotify());
    }

    @Test
    @RequiresDevice
    public void test_canIrradianceNotify_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.canIrradianceNotify());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_canIrradianceNotify_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.canIrradianceNotify(0));
    }

    @Test
    @RequiresDevice
    public void test_canIrradianceNotify_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.canIrradianceNotify(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicEnvironmentalSensingMeasurement_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingMeasurement());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicEnvironmentalSensingMeasurement_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicEnvironmentalSensingMeasurement_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingMeasurement(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(0));
    }

    @Test
    @RequiresDevice
    public void test_getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasIrradianceCharacteristicCharacteristicUserDescription());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasIrradianceCharacteristicCharacteristicUserDescription(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicValidRange_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicValidRange_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasIrradianceCharacteristicValidRange());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicValidRange_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasIrradianceCharacteristicValidRange(0));
    }

    @Test
    @RequiresDevice
    public void test_hasIrradianceCharacteristicValidRange_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasIrradianceCharacteristicValidRange(0));
        environmentalSensingProfile.disconnect();
    }

}
