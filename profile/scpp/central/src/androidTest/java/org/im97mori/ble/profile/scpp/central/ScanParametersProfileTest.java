package org.im97mori.ble.profile.scpp.central;

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
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.profile.scpp.central.db.ScanParametersProfileBondedDatabaseHelper;
import org.im97mori.ble.service.scps.central.ScanParametersService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ScanParametersProfileTest extends AbstractCentralTest {

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
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertTrue(scanParametersProfile.createFilteredScanCallback() instanceof ScanParametersProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertTrue(scanParametersProfile.createFilteredLeScanCallback() instanceof ScanParametersProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertNull(scanParametersProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        scanParametersProfile.start();
        assertNotNull(scanParametersProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        scanParametersProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_isScanRefreshCharacteristicSupported_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertNull(scanParametersProfile.isScanRefreshCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isScanRefreshCharacteristicSupported_00002() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID) {

            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null);
                }
            }
        };
        scanParametersProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(scanParametersProfile.isScanRefreshCharacteristicSupported());
        scanParametersProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setScanIntervalWindow_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertNull(scanParametersProfile.setScanIntervalWindow(new ScanIntervalWindow(new byte[4])));
    }

    @Test
    @RequiresDevice
    public void test_setScanIntervalWindow_00002() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null) {
                        @Override
                        public synchronized Integer setScanIntervalWindow(@NonNull ScanIntervalWindow scanIntervalWindow) {
                            return 1;
                        }
                    };
                }
            }
        };
        scanParametersProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(scanParametersProfile.setScanIntervalWindow(new ScanIntervalWindow(new byte[4])));
        scanParametersProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getScanRefreshClientCharacteristicConfiguration_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertNull(scanParametersProfile.getScanRefreshClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getScanRefreshClientCharacteristicConfiguration_00002() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null) {
                        @Override
                        public synchronized Integer getScanRefreshClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        scanParametersProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(scanParametersProfile.getScanRefreshClientCharacteristicConfiguration());
        scanParametersProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startScanRefreshNotification_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertNull(scanParametersProfile.startScanRefreshNotification());
    }

    @Test
    @RequiresDevice
    public void test_startScanRefreshNotification_00002() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null) {
                        @Override
                        public synchronized Integer startScanRefreshNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        scanParametersProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(scanParametersProfile.startScanRefreshNotification());
        scanParametersProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopScanRefreshNotification_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertNull(scanParametersProfile.stopScanRefreshNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopScanRefreshNotification_00002() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null) {
                        @Override
                        public synchronized Integer stopScanRefreshNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        scanParametersProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(scanParametersProfile.stopScanRefreshNotification());
        scanParametersProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        assertTrue(scanParametersProfile.getDatabaseHelper() instanceof ScanParametersProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        scanParametersProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(scanParametersProfile.mScanParametersService);
        assertTrue(atomicBoolean.get());
        scanParametersProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback(), BASE_UUID);
        scanParametersProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        scanParametersProfile.quit();
        assertNull(scanParametersProfile.mScanParametersService);
    }

}
