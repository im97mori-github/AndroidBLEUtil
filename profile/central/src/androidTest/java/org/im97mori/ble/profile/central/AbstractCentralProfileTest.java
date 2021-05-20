package org.im97mori.ble.profile.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
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
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AbstractCentralProfileTest extends AbstractCentralTest {

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
    public void test_addHistory_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
    }

    @Test
    public void test_addHistory_00002() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public BondedDeviceDatabaseHelper getDatabaseHelper() {
                return new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
            }
        };
        assertNotNull(baseAbstractCentralProfile.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
    }

    @Test
    public void test_removeHistory_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.removeHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
    }

    @Test
    public void test_clearHistory_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.clearHistory();
    }

    @Test
    public void test_clearHistory_00002() {
        final BaseBondedDeviceDatabaseHelper baseBondedDeviceDatabaseHelper = new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
        baseBondedDeviceDatabaseHelper.clearHistory();
        assertNotEquals(-1, baseBondedDeviceDatabaseHelper.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
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
        final BaseBondedDeviceDatabaseHelper baseBondedDeviceDatabaseHelper = new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
        baseBondedDeviceDatabaseHelper.clearHistory();
        assertNotEquals(-1, baseBondedDeviceDatabaseHelper.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
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
        final BaseBondedDeviceDatabaseHelper baseBondedDeviceDatabaseHelper = new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
        baseBondedDeviceDatabaseHelper.clearHistory();
        assertNotEquals(-1, baseBondedDeviceDatabaseHelper.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public BondedDeviceDatabaseHelper getDatabaseHelper() {
                return baseBondedDeviceDatabaseHelper;
            }
        };

        Set<BluetoothDevice> bluetoothDeviceSet = baseAbstractCentralProfile.getBondedDevices();
        assertNotNull(bluetoothDeviceSet);
        assertEquals(1, bluetoothDeviceSet.size());
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, bluetoothDeviceSet.iterator().next());
    }

    @Test
    public void test_start_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.bondDevice(BLETestUtilsAndroid.MOCK_DEVICE_0, BondTask.TIMEOUT_MILLIS, null));
        baseAbstractCentralProfile.start();
        assertNotNull(baseAbstractCentralProfile.bondDevice(BLETestUtilsAndroid.MOCK_DEVICE_0, BondTask.TIMEOUT_MILLIS, null));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_isConnected_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertFalse(baseAbstractCentralProfile.isConnected());
    }

    @Test
    public void test_isConnected_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertFalse(baseAbstractCentralProfile.isConnected());
        assertNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertTrue(baseAbstractCentralProfile.isConnected());
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_connect_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNotNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_connect_00002() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        BLEConnectionHolder.clearInstance();
        assertNotNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));

        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        assertNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_connect_00003() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        BLEConnectionHolder.clearInstance();
        assertNotNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));

        MOCK_BLE_CONNECTION.setConnected(false);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        assertNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));
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
        assertNotNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));

        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        assertNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, baseAbstractCentralProfile.getCurrentBluetoothDevice());
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.mGenericAccessService);
        assertNotNull(baseAbstractCentralProfile.mGenericAttributeService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        assertNotNull(baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, baseAbstractCentralProfile.getCurrentBluetoothDevice());
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
        assertNull(baseAbstractCentralProfile.bondDevice(BLETestUtilsAndroid.MOCK_DEVICE_0, ScanTask.TIMEOUT_MILLIS, null));
    }

    @Test
    public void test_bondDevice_00002() {
        assertEquals(BluetoothDevice.BOND_NONE, BLETestUtilsAndroid.MOCK_DEVICE_0.getBondState());

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.start();
        assertNotNull(baseAbstractCentralProfile.bondDevice(BLETestUtilsAndroid.MOCK_DEVICE_0, ScanTask.TIMEOUT_MILLIS, null));
        baseAbstractCentralProfile.quit();
    }

    @Test
    public void test_isDeviceNameCharacteristicWritable_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_isDeviceNameCharacteristicWritable_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isAppearanceCharacteristicWritable());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isPeripheralPreferredConnectionParametersCharacteristicSupported_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_isPeripheralPreferredConnectionParametersCharacteristicSupported_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isPeripheralPreferredConnectionParametersCharacteristicSupported());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isCentralAddressResolutionCharacteristicSupported_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_isCentralAddressResolutionCharacteristicSupported_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isCentralAddressResolutionCharacteristicSupported());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isResolvablePrivateAddressOnlyCharacteristicSupported_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_isResolvablePrivateAddressOnlyCharacteristicSupported_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isResolvablePrivateAddressOnlyCharacteristicSupported());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isReconnectionAddressCharacteristicSupported_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_isReconnectionAddressCharacteristicSupported_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isReconnectionAddressCharacteristicSupported());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicSupported_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicSupported_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isPeripheralPrivacyFlagCharacteristicSupported());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicWritable_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicWritable_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isPeripheralPrivacyFlagCharacteristicWritable());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isServiceChangedCharacteristicSupported_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isServiceChangedCharacteristicSupported());
    }

    @Test
    public void test_isServiceChangedCharacteristicSupported_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isServiceChangedCharacteristicSupported());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isClientSupportedFeaturesCharacteristicSupported_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    public void test_isClientSupportedFeaturesCharacteristicSupported_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isClientSupportedFeaturesCharacteristicSupported());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_isDatabaseHashCharacteristicSupported_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.isDatabaseHashCharacteristicSupported());
    }

    @Test
    public void test_isDatabaseHashCharacteristicSupported_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.isDatabaseHashCharacteristicSupported());
        baseAbstractCentralProfile.disconnect();
    }

    @Test
    public void test_getDeviceName_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.getDeviceName());
    }

    @Test
    public void test_getDeviceName_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isPeripheralPreferredConnectionParametersCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isCentralAddressResolutionCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isResolvablePrivateAddressOnlyCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isReconnectionAddressCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null) {

                        @Override
                        public boolean isPeripheralPrivacyFlagCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isServiceChangedCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isServiceChangedCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isServiceChangedCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isClientSupportedFeaturesCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isClientSupportedFeaturesCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(1);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);

        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mGenericAccessService == null) {
                    mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
                    if (mGenericAttributeService == null) {
                        mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null) {

                            @Override
                            public boolean isDatabaseHashCharacteristicSupported() {
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
        baseAbstractCentralProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(baseAbstractCentralProfile.getDatabaseHash());
        baseAbstractCentralProfile.disconnect();
    }

}
