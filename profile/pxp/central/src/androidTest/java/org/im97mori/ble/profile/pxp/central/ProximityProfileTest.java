package org.im97mori.ble.profile.pxp.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
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
import org.im97mori.ble.characteristic.u2a06.AlertLevelAndroid;
import org.im97mori.ble.profile.pxp.central.db.ProximityProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ias.central.ImmediateAlertService;
import org.im97mori.ble.service.lls.central.LinkLossService;
import org.im97mori.ble.service.tps.central.TxPowerService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.IMMEDIATE_ALERT_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.LINK_LOSS_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.TX_POWER_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class ProximityProfileTest {

    @Test
    public void test_findProximityProfileDevices_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.findProximityProfileDevices(null));
    }

    @Test
    public void test_findProximityProfileDevices_00002() {
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
        assertNotNull(proximityProfile.findProximityProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        proximityProfile.quit();
    }

    @Test
    public void test_hasImmediateAlertService_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.hasImmediateAlertService());
    }

    @Test
    public void test_hasImmediateAlertService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.mImmediateAlertService = new ImmediateAlertService(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), proximityProfile.mProximityProfileCallback, null);
        assertNotNull(proximityProfile.hasImmediateAlertService());
    }

    @Test
    public void test_hasTxPowerService_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.hasTxPowerService());
    }

    @Test
    public void test_hasTxPowerService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        proximityProfile.mTxPowerService = new TxPowerService(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), proximityProfile.mProximityProfileCallback, null);
        assertNotNull(proximityProfile.hasTxPowerService());
    }

    @Test
    public void test_getAlertLevel_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.getAlertLevel());
    }

    @Test
    public void test_getAlertLevel_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLinkLossService == null) {
                    mLinkLossService = new LinkLossService(mBLEConnection, mProximityProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mImmediateAlertService == null) {
                    mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mProximityProfileCallback, null);
                }
                if (mTxPowerService == null) {
                    mTxPowerService = new TxPowerService(mBLEConnection, mProximityProfileCallback, null);
                }
            }
        };
        proximityProfile.connect(MOCK_DEVICE);
        assertNotNull(proximityProfile.getAlertLevel());
        proximityProfile.disconnect();
    }

    @Test
    public void test_setLinkLossServiceAlertLevel_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.setLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
    }

    @Test
    public void test_setLinkLossServiceAlertLevel_00002() {
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

        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLinkLossService == null) {
                    mLinkLossService = new LinkLossService(mBLEConnection, mProximityProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mImmediateAlertService == null) {
                    mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mProximityProfileCallback, null);
                }
                if (mTxPowerService == null) {
                    mTxPowerService = new TxPowerService(mBLEConnection, mProximityProfileCallback, null);
                }
            }
        };
        proximityProfile.connect(MOCK_DEVICE);
        assertNotNull(proximityProfile.setLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
        proximityProfile.disconnect();
    }

    @Test
    public void test_setImmediateAlertServiceAlertLevel_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.setImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
    }

    @Test
    public void test_setImmediateAlertServiceAlertLevel_00002() {
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

        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLinkLossService == null) {
                    mLinkLossService = new LinkLossService(mBLEConnection, mProximityProfileCallback, null);
                }
                if (mImmediateAlertService == null) {
                    mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mProximityProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mTxPowerService == null) {
                    mTxPowerService = new TxPowerService(mBLEConnection, mProximityProfileCallback, null);
                }
            }
        };
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(IMMEDIATE_ALERT_SERVICE, 0)), null);
        assertNotNull(proximityProfile.setImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)));
        proximityProfile.disconnect();
    }

    @Test
    public void test_getTxPowerLevel_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertNull(proximityProfile.getTxPowerLevel());
    }

    @Test
    public void test_getTxPowerLevel_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLinkLossService == null) {
                    mLinkLossService = new LinkLossService(mBLEConnection, mProximityProfileCallback, null);
                }
                if (mImmediateAlertService == null) {
                    mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mProximityProfileCallback, null);
                }
                if (mTxPowerService == null) {
                    mTxPowerService = new TxPowerService(mBLEConnection, mProximityProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(TX_POWER_SERVICE, 0)), null);
        assertNotNull(proximityProfile.getTxPowerLevel());
        proximityProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        assertTrue(proximityProfile.getDatabaseHelper() instanceof ProximityProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        proximityProfile.connect(MOCK_DEVICE);
        assertNotNull(proximityProfile.mLinkLossService);
        assertNotNull(proximityProfile.mImmediateAlertService);
        assertNotNull(proximityProfile.mTxPowerService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        ProximityProfile proximityProfile = new ProximityProfile(ApplicationProvider.getApplicationContext(), new BaseProximityProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.quit();
        assertNull(proximityProfile.mLinkLossService);
        assertNull(proximityProfile.mImmediateAlertService);
        assertNull(proximityProfile.mTxPowerService);
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        final BluetoothDevice originalBluetoothDevice = MOCK_DEVICE;
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
        proximityProfile.connect(MOCK_DEVICE);
        proximityProfile.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        proximityProfile.quit();
        assertFalse(isCalled.get());
    }

}
