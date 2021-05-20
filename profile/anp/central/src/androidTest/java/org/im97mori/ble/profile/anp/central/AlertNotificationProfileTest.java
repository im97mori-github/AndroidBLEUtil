package org.im97mori.ble.profile.anp.central;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a44.AlertNotificationControlPoint;
import org.im97mori.ble.profile.anp.central.db.AlertNotificationProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ans.AlertNotificationCategoryIdUtils;
import org.im97mori.ble.service.ans.central.AlertNotificationService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AlertNotificationProfileTest extends AbstractCentralTest {

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
    public void test_findAlertNotificationProfileDevices_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.findAlertNotificationProfileDevices(null));
    }

    @Test
    public void test_findLocationAndNavigationProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        alertNotificationProfile.start();
        assertNotNull(alertNotificationProfile.findAlertNotificationProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        alertNotificationProfile.quit();
    }

    @Test
    public void test_getSupportedNewAlertCategory_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.getSupportedNewAlertCategory());
    }

    @Test
    public void test_getSupportedNewAlertCategory_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer getSupportedNewAlertCategory() {
                            return 1;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.getSupportedNewAlertCategory());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_getNewAlertClientCharacteristicConfiguration_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.getNewAlertClientCharacteristicConfiguration());
    }

    @Test
    public void test_getNewAlertClientCharacteristicConfiguration_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer getNewAlertClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.getNewAlertClientCharacteristicConfiguration());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_startNewAlertNotification_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.startNewAlertNotification());
    }

    @Test
    public void test_startNewAlertNotification_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer startNewAlertNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.startNewAlertNotification());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_stopNewAlertNotification_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.stopNewAlertNotification());
    }

    @Test
    public void test_stopNewAlertNotification_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopNewAlertNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.stopNewAlertNotification());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_getSupportedUnreadAlertCategory_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.getSupportedUnreadAlertCategory());
    }

    @Test
    public void test_getSupportedUnreadAlertCategory_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer getSupportedUnreadAlertCategory() {
                            return 1;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.getSupportedUnreadAlertCategory());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_getUnreadAlertStatusClientCharacteristicConfiguration_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.getUnreadAlertStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getUnreadAlertStatusClientCharacteristicConfiguration_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer getUnreadAlertStatusClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.getUnreadAlertStatusClientCharacteristicConfiguration());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_startUnreadAlertStatusNotification_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.startUnreadAlertStatusNotification());
    }

    @Test
    public void test_startUnreadAlertStatusNotification_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer startUnreadAlertStatusNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.startUnreadAlertStatusNotification());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_stopUnreadAlertStatusNotification_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.stopUnreadAlertStatusNotification());
    }

    @Test
    public void test_stopUnreadAlertStatusNotification_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopUnreadAlertStatusNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.stopUnreadAlertStatusNotification());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_setAlertNotificationControlPoint_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        AlertNotificationControlPoint alertNotificationControlPoint = new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION, AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL);
        assertNull(alertNotificationProfile.setAlertNotificationControlPoint(alertNotificationControlPoint));
    }

    @Test
    public void test_setAlertNotificationControlPoint_00002() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public synchronized Integer setAlertNotificationControlPoint(@NonNull AlertNotificationControlPoint alertNotificationControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        AlertNotificationControlPoint alertNotificationControlPoint = new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION, AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL);
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.setAlertNotificationControlPoint(alertNotificationControlPoint));
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertTrue(alertNotificationProfile.getDatabaseHelper() instanceof AlertNotificationProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(alertNotificationProfile.mAlertNotificationService);
        assertTrue(atomicBoolean.get());
        alertNotificationProfile.quit();
    }

    @Test
    public void test_quit_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        alertNotificationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        alertNotificationProfile.quit();
        assertNull(alertNotificationProfile.mAlertNotificationService);
    }

}
