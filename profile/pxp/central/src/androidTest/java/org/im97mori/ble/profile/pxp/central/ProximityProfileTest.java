package org.im97mori.ble.profile.pxp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
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
import org.im97mori.ble.characteristic.u2a06.AlertLevelAndroid;
import org.im97mori.ble.profile.pxp.central.db.ProximityProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ias.central.ImmediateAlertService;
import org.im97mori.ble.service.lls.central.LinkLossService;
import org.im97mori.ble.service.tps.central.TxPowerService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.IMMEDIATE_ALERT_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.LINK_LOSS_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.TX_POWER_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class ProximityProfileTest extends AbstractCentralTest {

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
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertTrue(proximityProfile.createFilteredScanCallback() instanceof ProximityProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertTrue(proximityProfile.createFilteredLeScanCallback() instanceof ProximityProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        proximityProfile.start();
        assertNotNull(proximityProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        proximityProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasImmediateAlertService_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.hasImmediateAlertService());
    }

    @Test
    @RequiresDevice
    public void test_hasImmediateAlertService_00002() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(proximityProfile.hasImmediateAlertService());
        proximityProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasImmediateAlertService_00003() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = proximityProfile.hasImmediateAlertService();
        proximityProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasImmediateAlertService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(IMMEDIATE_ALERT_SERVICE, 0);

        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = proximityProfile.hasImmediateAlertService();
        proximityProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasTxPowerService_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.hasTxPowerService());
    }

    @Test
    @RequiresDevice
    public void test_hasTxPowerService_00002() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(proximityProfile.hasTxPowerService());
        proximityProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasTxPowerService_00003() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = proximityProfile.hasTxPowerService();
        proximityProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasTxPowerService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(TX_POWER_SERVICE, 0);

        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = proximityProfile.hasTxPowerService();
        proximityProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_getAlertLevel_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.getAlertLevel());
    }

    @Test
    @RequiresDevice
    public void test_getAlertLevel_00002() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLinkLossService == null) {
                    mLinkLossService = new LinkLossService(mBLEConnection, mProximityProfileCallback, null) {
                        @Override
                        public synchronized Integer getAlertLevel() {
                            return 1;
                        }
                    };
                }
            }
        };
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(proximityProfile.getAlertLevel());
        proximityProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setLinkLossServiceAlertLevel_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.setLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
    }

    @Test
    @RequiresDevice
    public void test_setLinkLossServiceAlertLevel_00002() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLinkLossService == null) {
                    mLinkLossService = new LinkLossService(mBLEConnection, mProximityProfileCallback, null) {
                        @Override
                        public synchronized Integer setAlertLevel(@NonNull AlertLevel alertLevel) {
                            return 1;
                        }
                    };
                }
            }
        };
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(proximityProfile.setLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
        proximityProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setImmediateAlertServiceAlertLevel_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.setImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
    }

    @Test
    @RequiresDevice
    public void test_setImmediateAlertServiceAlertLevel_00002() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mImmediateAlertService == null) {
                    mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mProximityProfileCallback, null) {
                        @Override
                        public synchronized Integer setAlertLevel(@NonNull AlertLevel alertLevel) {
                            return 1;
                        }
                    };
                }
            }
        };
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(proximityProfile.setImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
        proximityProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTxPowerLevel_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.getTxPowerLevel());
    }

    @Test
    @RequiresDevice
    public void test_getTxPowerLevel_00002() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mTxPowerService == null) {
                    mTxPowerService = new TxPowerService(mBLEConnection, mProximityProfileCallback, null) {
                        @Override
                        public synchronized Integer getTxPowerLevel() {
                            return 1;
                        }
                    };
                }
            }
        };
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(proximityProfile.getTxPowerLevel());
        proximityProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertTrue(proximityProfile.getDatabaseHelper() instanceof ProximityProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(proximityProfile.mLinkLossService);
        assertNotNull(proximityProfile.mImmediateAlertService);
        assertNotNull(proximityProfile.mTxPowerService);
        assertTrue(atomicBoolean.get());
        proximityProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.quit();
        assertNull(proximityProfile.mLinkLossService);
        assertNull(proximityProfile.mImmediateAlertService);
        assertNull(proximityProfile.mTxPowerService);
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = LINK_LOSS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AlertLevelAndroid alertLevelAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, alertLevelAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AlertLevelAndroid alertLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = LINK_LOSS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AlertLevelAndroid alertLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = IMMEDIATE_ALERT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AlertLevelAndroid alertLevelAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, alertLevelAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AlertLevelAndroid alertLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = IMMEDIATE_ALERT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AlertLevelAndroid alertLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = LINK_LOSS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = LINK_LOSS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = IMMEDIATE_ALERT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = IMMEDIATE_ALERT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = LINK_LOSS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = LINK_LOSS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onLinkLossServiceAlertLevelWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = IMMEDIATE_ALERT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = IMMEDIATE_ALERT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        BaseProximityProfileCallback baseProximityProfileCallback = new BaseProximityProfileCallback() {
            @Override
            public void onImmediateAlertServiceAlertLevelWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), baseProximityProfileCallback);
        proximityProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

}
