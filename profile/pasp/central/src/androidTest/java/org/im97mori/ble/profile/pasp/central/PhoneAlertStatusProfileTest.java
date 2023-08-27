package org.im97mori.ble.profile.pasp.central;

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
import org.im97mori.ble.characteristic.u2a40.RingerControlPoint;
import org.im97mori.ble.profile.pasp.central.db.PhoneAlertStatusProfileBondedDatabaseHelper;
import org.im97mori.ble.service.pass.central.PhoneAlertStatusService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PhoneAlertStatusProfileTest extends AbstractCentralTest {

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
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertTrue(phoneAlertStatusProfile.createFilteredScanCallback() instanceof PhoneAlertStatusProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertTrue(phoneAlertStatusProfile.createFilteredLeScanCallback() instanceof PhoneAlertStatusProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        phoneAlertStatusProfile.start();
        assertNotNull(phoneAlertStatusProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        phoneAlertStatusProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_getAlertStatus_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.getAlertStatus());
    }

    @Test
    @RequiresDevice
    public void test_getAlertStatus_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer getAlertStatus() {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.getAlertStatus());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getAlertStatusClientCharacteristicConfiguration_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.getAlertStatusClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getAlertStatusClientCharacteristicConfiguration_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer getAlertStatusClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.getAlertStatusClientCharacteristicConfiguration());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startAlertStatusNotification_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.startAlertStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_startAlertStatusNotification_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer startAlertStatusNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.startAlertStatusNotification());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopAlertStatusNotification_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.stopAlertStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopAlertStatusNotification_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer stopAlertStatusNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.stopAlertStatusNotification());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getRingerSetting_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.getRingerSetting());
    }

    @Test
    @RequiresDevice
    public void test_getRingerSetting_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer getRingerSetting() {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.getRingerSetting());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getRingerSettingClientCharacteristicConfiguration_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.getRingerSettingClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRingerSettingClientCharacteristicConfiguration_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer getRingerSettingClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.getRingerSettingClientCharacteristicConfiguration());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startRingerSettingNotification_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.startRingerSettingNotification());
    }

    @Test
    @RequiresDevice
    public void test_startRingerSettingNotification_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer startRingerSettingNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.startRingerSettingNotification());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopRingerSettingNotification_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.stopRingerSettingNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopRingerSettingNotification_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer stopRingerSettingNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.stopRingerSettingNotification());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setRingerControlPoint_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.setRingerControlPoint(new RingerControlPoint(1)));
    }

    @Test
    @RequiresDevice
    public void test_setRingerControlPoint_00002() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized Integer setRingerControlPoint(@NonNull RingerControlPoint ringerControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.setRingerControlPoint(new RingerControlPoint(1)));
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertTrue(phoneAlertStatusProfile.getDatabaseHelper() instanceof PhoneAlertStatusProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(phoneAlertStatusProfile.mPhoneAlertStatusService);
        assertTrue(atomicBoolean.get());
        phoneAlertStatusProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        phoneAlertStatusProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        phoneAlertStatusProfile.quit();
        assertNull(phoneAlertStatusProfile.mPhoneAlertStatusService);
    }

}
