package org.im97mori.ble.profile.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallbackInterface;
import org.im97mori.ble.characteristic.u2a00.DeviceName;
import org.im97mori.ble.characteristic.u2a01.Appearance;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlag;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddress;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeatures;
import org.im97mori.ble.profile.central.db.BaseBondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.service.gap.central.GenericAttributeService;
import org.im97mori.ble.service.gatt.central.GenericAccessService;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

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
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);


        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.mGenericAccessService);
        assertNotNull(baseAbstractCentralProfile.mGenericAttributeService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        baseAbstractCentralProfile.quit();
        assertNull(baseAbstractCentralProfile.mGenericAccessService);
        assertNull(baseAbstractCentralProfile.mGenericAttributeService);
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

    @Test
    public void test_isDeviceNameCharacteristicWritable_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_isDeviceNameCharacteristicWritable_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isDeviceNameCharacteristicWritable());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isAppearanceCharacteristicWritable_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_isAppearanceCharacteristicWritable_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isAppearanceCharacteristicWritable());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isPeripheralPreferredConnectionParametersCharacteristicSupporeted_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isPeripheralPreferredConnectionParametersCharacteristicSupporeted());
    }

    @Test
    public void test_isPeripheralPreferredConnectionParametersCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isPeripheralPreferredConnectionParametersCharacteristicSupporeted());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isCentralAddressResolutionCharacteristicSupporeted_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isCentralAddressResolutionCharacteristicSupporeted());
    }

    @Test
    public void test_isCentralAddressResolutionCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isCentralAddressResolutionCharacteristicSupporeted());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isResolvablePrivateAddressOnlyCharacteristicSupporeted_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isResolvablePrivateAddressOnlyCharacteristicSupporeted());
    }

    @Test
    public void test_isResolvablePrivateAddressOnlyCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isResolvablePrivateAddressOnlyCharacteristicSupporeted());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isReconnectionAddressCharacteristicSupporeted_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isReconnectionAddressCharacteristicSupporeted());
    }

    @Test
    public void test_isReconnectionAddressCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isReconnectionAddressCharacteristicSupporeted());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicSupporeted_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isPeripheralPrivacyFlagCharacteristicSupporeted());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isPeripheralPrivacyFlagCharacteristicSupporeted());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicWritable_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicWritable_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isPeripheralPrivacyFlagCharacteristicWritable());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isServiceChangedCharacteristicSupporeted_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isServiceChangedCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isServiceChangedCharacteristicSupporeted());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isClientSupportedFeaturesCharacteristicSupporeted_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_isClientSupportedFeaturesCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isClientSupportedFeaturesCharacteristicSupporeted());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isDatabaseHashCharacteristicSupporeted_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_isDatabaseHashCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.isDatabaseHashCharacteristicSupporeted());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getDeviceName_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getDeviceName());
    }

    @Test
    public void test_getDeviceName_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getDeviceName());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_setDeviceName_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.setDeviceName(new DeviceName("")));
    }

    @Test
    public void test_setDeviceName_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isDeviceNameCharacteristicWritable() {
                            return true;
                        }

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.setDeviceName(new DeviceName("")));
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getAppearance_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getAppearance());
    }

    @Test
    public void test_getAppearance_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getAppearance());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_setAppearance_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.setAppearance(new Appearance(new byte[]{0, 1})));
    }

    @Test
    public void test_setAppearance_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isAppearanceCharacteristicWritable() {
                            return true;
                        }

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.setAppearance(new Appearance(new byte[]{0, 1})));
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getPeripheralPreferredConnectionParameters_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getPeripheralPreferredConnectionParameters());
    }

    @Test
    public void test_getPeripheralPreferredConnectionParameters_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isPeripheralPreferredConnectionParametersCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getPeripheralPreferredConnectionParameters());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getCentralAddressResolutionParameters_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getCentralAddressResolutionParameters());
    }

    @Test
    public void test_getCentralAddressResolutionParameters_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isCentralAddressResolutionCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getCentralAddressResolutionParameters());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getResolvablePrivateAddressOnly_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getResolvablePrivateAddressOnly());
    }

    @Test
    public void test_getResolvablePrivateAddressOnly_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isResolvablePrivateAddressOnlyCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getResolvablePrivateAddressOnly());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_setReconnectionAddress_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.setReconnectionAddress(new ReconnectionAddress(new byte[]{0, 1, 2, 3, 4, 5})));
    }

    @Test
    public void test_setReconnectionAddress_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isReconnectionAddressCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.setReconnectionAddress(new ReconnectionAddress(new byte[]{0, 1, 2, 3, 4, 5})));
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getPeripheralPrivacyFlag_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getPeripheralPrivacyFlag());
    }

    @Test
    public void test_getPeripheralPrivacyFlag_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isPeripheralPrivacyFlagCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getPeripheralPrivacyFlag());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_setPeripheralPrivacyFlag_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.setPeripheralPrivacyFlag(new PeripheralPrivacyFlag(new byte[]{0})));
    }

    @Test
    public void test_setPeripheralPrivacyFlag_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isPeripheralPrivacyFlagCharacteristicWritable() {
                            return true;
                        }

                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mGenericAttributeService == null) {
                    mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.setPeripheralPrivacyFlag(new PeripheralPrivacyFlag(new byte[]{0})));
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getServiceChangedClientCharacteristicConfiguration_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getServiceChangedClientCharacteristicConfiguration());
    }

    @Test
    public void test_getServiceChangedClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isServiceChangedCharacteristicSupporeted() {
                                return true;
                            }

                            @Override
                            public synchronized boolean isStarted() {
                                return true;
                            }

                        };
                    }
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getServiceChangedClientCharacteristicConfiguration());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_startServiceChangedIndication_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.startServiceChangedIndication());
    }

    @Test
    public void test_startServiceChangedIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isServiceChangedCharacteristicSupporeted() {
                                return true;
                            }

                            @Override
                            public synchronized boolean isStarted() {
                                return true;
                            }

                        };
                    }
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.startServiceChangedIndication());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_stopServiceChangedIndication_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.stopServiceChangedIndication());
    }

    @Test
    public void test_stopServiceChangedIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isServiceChangedCharacteristicSupporeted() {
                                return true;
                            }

                            @Override
                            public synchronized boolean isStarted() {
                                return true;
                            }

                        };
                    }
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.stopServiceChangedIndication());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getClientSupportedFeatures_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getClientSupportedFeatures());
    }

    @Test
    public void test_getClientSupportedFeatures_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isClientSupportedFeaturesCharacteristicSupporeted() {
                                return true;
                            }

                            @Override
                            public synchronized boolean isStarted() {
                                return true;
                            }

                        };
                    }
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getClientSupportedFeatures());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_setClientSupportedFeatures_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.setClientSupportedFeatures(new ClientSupportedFeatures(new byte[]{})));
    }

    @Test
    public void test_setClientSupportedFeatures_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isClientSupportedFeaturesCharacteristicSupporeted() {
                                return true;
                            }

                            @Override
                            public synchronized boolean isStarted() {
                                return true;
                            }

                        };
                    }
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.setClientSupportedFeatures(new ClientSupportedFeatures(new byte[]{})));
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHash_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getDatabaseHash());
    }

    @Test
    public void test_getDatabaseHash_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isDatabaseHashCharacteristicSupporeted() {
                                return true;
                            }

                            @Override
                            public synchronized boolean isStarted() {
                                return true;
                            }

                        };
                    }
                }
            }
        };
        baseAbstractCentralProfile.connect(MOCK_DEVICE);
        assertNotNull(baseAbstractCentralProfile.getDatabaseHash());
        baseAbstractCentralProfile.disconnect();
    }

}
