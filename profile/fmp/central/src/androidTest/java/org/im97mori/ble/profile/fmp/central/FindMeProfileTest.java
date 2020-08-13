package org.im97mori.ble.profile.fmp.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.profile.fmp.central.db.FindMeProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ias.central.ImmediateAlertService;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FindMeProfileTest {

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
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FindMeProfile findMeProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mImmediateAlertService == null) {
                    mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mFindMeProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        findMeProfile.connect(MOCK_DEVICE);
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
        FindMeProfile bloodPressureProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        bloodPressureProfile.connect(MOCK_DEVICE);
        assertNotNull(bloodPressureProfile.mImmediateAlertService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        FindMeProfile bloodPressureProfile = new FindMeProfile(ApplicationProvider.getApplicationContext(), new BaseFindMeProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        bloodPressureProfile.connect(MOCK_DEVICE);
        bloodPressureProfile.quit();
        assertNull(bloodPressureProfile.mImmediateAlertService);
    }

}
