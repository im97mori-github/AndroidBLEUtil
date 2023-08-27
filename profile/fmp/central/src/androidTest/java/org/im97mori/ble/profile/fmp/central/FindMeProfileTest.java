package org.im97mori.ble.profile.fmp.central;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.profile.fmp.central.db.FindMeProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ias.central.ImmediateAlertService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class FindMeProfileTest extends AbstractCentralTest {

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
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        assertTrue(findMeProfile.createFilteredScanCallback() instanceof FindMeProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        assertTrue(findMeProfile.createFilteredLeScanCallback() instanceof FindMeProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        assertNull(findMeProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
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
        assertNotNull(findMeProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        findMeProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_setAlertLevel_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        assertNull(findMeProfile.setAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
    }

    @Test
    @RequiresDevice
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
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        assertTrue(findMeProfile.getDatabaseHelper() instanceof FindMeProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
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
    @RequiresDevice
    public void test_quit_00001() {
        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        findMeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        findMeProfile.quit();
        assertNull(findMeProfile.mImmediateAlertService);
    }

}
