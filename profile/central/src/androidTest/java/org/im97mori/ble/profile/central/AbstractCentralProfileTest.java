package org.im97mori.ble.profile.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallbackInterface;
import org.im97mori.ble.profile.central.db.BaseBondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AbstractCentralProfileTest {

    @Test
    public void test_addHistory_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.addHistory(bluetoothDevice));
    }

    @Test
    public void test_addHistory_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public BondedDeviceDatabaseHelper getDatabaseHelper() {
                return new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
            }
        };
        assertNotNull(baseAbstractCentralProfile.addHistory(bluetoothDevice));
    }

    @Test
    public void test_removeHistory_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.removeHistory(bluetoothDevice));
    }

    @Test
    public void test_clearHistory_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.clearHistory();
    }

    @Test
    public void test_clearHistory_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        final BaseBondedDeviceDatabaseHelper baseBondedDeviceDatabaseHelper = new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
        baseBondedDeviceDatabaseHelper.clearHistory();
        assertNotEquals(-1, baseBondedDeviceDatabaseHelper.addHistory(bluetoothDevice));
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public BondedDeviceDatabaseHelper getDatabaseHelper() {
                return baseBondedDeviceDatabaseHelper;
            }
        };
        baseAbstractCentralProfile.clearHistory();
        assertTrue(baseBondedDeviceDatabaseHelper.getBondedDevices().isEmpty());
    }

    @Test
    public void test_syncBondedDevice_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.syncBondedDevice();
    }

    @Test
    public void test_syncBondedDevice_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        final BaseBondedDeviceDatabaseHelper baseBondedDeviceDatabaseHelper = new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
        baseBondedDeviceDatabaseHelper.clearHistory();
        assertNotEquals(-1, baseBondedDeviceDatabaseHelper.addHistory(bluetoothDevice));
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public BondedDeviceDatabaseHelper getDatabaseHelper() {
                return baseBondedDeviceDatabaseHelper;
            }
        };
        baseAbstractCentralProfile.syncBondedDevice();
        assertTrue(baseBondedDeviceDatabaseHelper.getBondedDevices().isEmpty());
    }

    @Test
    public void test_getBondedDevices_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getBondedDevices());
    }

    @Test
    public void test_getBondedDevices_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        final BaseBondedDeviceDatabaseHelper baseBondedDeviceDatabaseHelper = new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
        baseBondedDeviceDatabaseHelper.clearHistory();
        assertNotEquals(-1, baseBondedDeviceDatabaseHelper.addHistory(bluetoothDevice));
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public BondedDeviceDatabaseHelper getDatabaseHelper() {
                return baseBondedDeviceDatabaseHelper;
            }
        };

        Set<BluetoothDevice> bluetoothDeviceSet = baseAbstractCentralProfile.getBondedDevices();
        assertNotNull(bluetoothDeviceSet);
        assertEquals(1, bluetoothDeviceSet.size());
        assertEquals(bluetoothDevice, bluetoothDeviceSet.iterator().next());
    }

    @Test
    public void test_start_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.bondDevice(bluetoothDevice, BondTask.TIMEOUT_MILLIS, null));
        baseAbstractCentralProfile.start();
        assertNotNull(baseAbstractCentralProfile.bondDevice(bluetoothDevice, BondTask.TIMEOUT_MILLIS, null));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_isConnected_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertFalse(baseAbstractCentralProfile.isConnected());
    }

    @Test
    public void test_isConnected_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(mockBLEConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertFalse(baseAbstractCentralProfile.isConnected());
        assertNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));
        assertTrue(baseAbstractCentralProfile.isConnected());
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_connect_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        BLEConnectionHolder.clearInstance();
        assertNotNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_connect_00002() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        BLEConnectionHolder.clearInstance();
        assertNotNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(mockBLEConnection, true);
        assertNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_connect_00003() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        BLEConnectionHolder.clearInstance();
        assertNotNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return false;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(mockBLEConnection, true);
        assertNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_disconnect_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_disconnect_00002() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        BLEConnectionHolder.clearInstance();
        assertNotNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(mockBLEConnection, true);
        assertNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));
        assertEquals(MockBLEConnection.MOCK_DEVICE, baseAbstractCentralProfile.getCurrentBluetoothDevice());
        baseAbstractCentralProfile.disconnect();
        assertNull(baseAbstractCentralProfile.getCurrentBluetoothDevice());
    }

    @Test
    public void test_quit_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_getCurrentBluetoothDevice_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getCurrentBluetoothDevice());
    }

    @Test
    public void test_getCurrentBluetoothDevice_00002() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        BLEConnectionHolder.clearInstance();
        assertNotNull(baseAbstractCentralProfile.connect(MockBLEConnection.MOCK_DEVICE));
        assertEquals(MockBLEConnection.MOCK_DEVICE, baseAbstractCentralProfile.getCurrentBluetoothDevice());
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_scanDevice_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.scanDevice(new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {

            }

            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {

            }

            @Override
            public void onScanFailed(int errorCode) {

            }
        }, null).build(), ScanTask.TIMEOUT_MILLIS, null));
    }

    @Test
    public void test_scanDevice_00002() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.start();
        assertNotNull(baseAbstractCentralProfile.scanDevice(new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {

            }

            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {

            }

            @Override
            public void onScanFailed(int errorCode) {

            }
        }, null).build(), ScanTask.TIMEOUT_MILLIS, null));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_bondDevice_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.bondDevice(MockBLEConnection.MOCK_DEVICE, ScanTask.TIMEOUT_MILLIS, null));
    }

    @Test
    public void test_bondDevice_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:FF";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        assertEquals(BluetoothDevice.BOND_NONE, bluetoothDevice.getBondState());

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.start();
        assertNotNull(baseAbstractCentralProfile.bondDevice(bluetoothDevice, ScanTask.TIMEOUT_MILLIS, null));
        baseAbstractCentralProfile.quit();
    }

}
