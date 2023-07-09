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

public class EnvironmentalSensingProfileTrueWindDirectionTest extends AbstractCentralTest {

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
    public void test_getTrueWindDirection_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirection());
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirection_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirection(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirection());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirection_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirection(0));
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirection_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirection(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirection(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startTrueWindDirectionNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startTrueWindDirectionNotification());
    }

    @Test
    @RequiresDevice
    public void test_startTrueWindDirectionNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startTrueWindDirectionNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startTrueWindDirectionNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startTrueWindDirectionNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startTrueWindDirectionNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_startTrueWindDirectionNotification_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startTrueWindDirectionNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startTrueWindDirectionNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopTrueWindDirectionNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopTrueWindDirectionNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopTrueWindDirectionNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopTrueWindDirectionNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopTrueWindDirectionNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopTrueWindDirectionNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopTrueWindDirectionNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_stopTrueWindDirectionNotification_00102() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopTrueWindDirectionNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopTrueWindDirectionNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingMeasurement_00002() {

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionEnvironmentalSensingMeasurement(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingMeasurement());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingMeasurement_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingMeasurement_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionEnvironmentalSensingMeasurement(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingMeasurement(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingTriggerSetting_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 0));
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingTriggerSetting_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setTrueWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionEnvironmentalSensingTriggerSetting_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionEnvironmentalSensingTriggerSetting_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setTrueWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionEnvironmentalSensingConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionEnvironmentalSensingConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setTrueWindDirectionEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setTrueWindDirectionEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND)));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionCharacteristicUserDescription(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionCharacteristicUserDescription());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionCharacteristicUserDescription(0));
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionCharacteristicUserDescription(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionCharacteristicUserDescription(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setTrueWindDirectionCharacteristicUserDescription(new CharacteristicUserDescription(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setTrueWindDirectionCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setTrueWindDirectionCharacteristicUserDescription(new CharacteristicUserDescription(new byte[]{0})));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.setTrueWindDirectionCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setTrueWindDirectionCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer setTrueWindDirectionCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.setTrueWindDirectionCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[]{0})));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionValidRange_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionValidRange());
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionValidRange_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionValidRange(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionValidRange());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionValidRange_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionValidRange(0));
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionValidRange_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionValidRange(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionValidRange(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionCount());
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCount_00002() {

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
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isTrueWindDirectionNotificatable_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.isTrueWindDirectionNotificatable());
    }

    @Test
    @RequiresDevice
    public void test_isTrueWindDirectionNotificatable_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.isTrueWindDirectionNotificatable());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isTrueWindDirectionNotificatable_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.isTrueWindDirectionNotificatable(0));
    }

    @Test
    @RequiresDevice
    public void test_isTrueWindDirectionNotificatable_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.isTrueWindDirectionNotificatable(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(0));
    }

    @Test
    @RequiresDevice
    public void test_getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicCharacteristicUserDescription_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicCharacteristicUserDescription_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicCharacteristicUserDescription());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicCharacteristicUserDescription_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicCharacteristicUserDescription_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicCharacteristicUserDescription(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicValidRange_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicValidRange_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicValidRange());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicValidRange_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicValidRange(0));
    }

    @Test
    @RequiresDevice
    public void test_hasTrueWindDirectionCharacteristicValidRange_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasTrueWindDirectionCharacteristicValidRange(0));
        environmentalSensingProfile.disconnect();
    }

}
