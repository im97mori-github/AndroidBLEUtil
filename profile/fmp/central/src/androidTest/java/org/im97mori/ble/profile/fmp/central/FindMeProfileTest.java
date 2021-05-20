package org.im97mori.ble.profile.fmp.central;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.profile.fmp.central.db.FindMeProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ias.central.ImmediateAlertService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FindMeProfileTest extends AbstractCentralTest {

    @Test
    public void test_findFindMeProfileDevices_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        assertNull(findMeProfile.findFindMeProfileDevices(null));
    }

    @Test
    public void test_findFindMeProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        findMeProfile.start();
        assertNotNull(findMeProfile.findFindMeProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        findMeProfile.quit();
    }

    @Test
    public void test_setAlertLevel_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        assertNull(findMeProfile.setAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
    }

    @Test
    public void test_setAlertLevel_00002() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mImmediateAlertService == null) {
                    mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mFindMeProfileCallback, null) {
                        @Override
                        public synchronized Integer setAlertLevel(@NonNull AlertLevel alertLevel) {
                            return 1;
                        }
                    };
                }
            }
        };
        findMeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(findMeProfile.setAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
        findMeProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        assertTrue(findMeProfile.getDatabaseHelper() instanceof FindMeProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        findMeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(findMeProfile.mImmediateAlertService);
        assertTrue(atomicBoolean.get());
        findMeProfile.quit();
    }

    @Test
    public void test_quit_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        findMeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        findMeProfile.quit();
        assertNull(findMeProfile.mImmediateAlertService);
    }

}
