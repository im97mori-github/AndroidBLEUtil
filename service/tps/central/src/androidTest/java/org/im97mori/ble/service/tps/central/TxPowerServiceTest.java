package org.im97mori.ble.service.tps.central;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.characteristic.u2a07.TxPowerLevel;
import org.im97mori.ble.characteristic.u2a07.TxPowerLevelAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.TX_POWER_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class TxPowerServiceTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = TX_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TxPowerLevel(1).getBytes();
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TxPowerLevelAndroid txPowerLevelAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, txPowerLevelAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TxPowerLevel(1).getBytes();
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TxPowerLevelAndroid txPowerLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = TX_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TxPowerLevel(1).getBytes();
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TxPowerLevelAndroid txPowerLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = TX_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = TX_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = TX_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TX_POWER_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = TX_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockTxPowerServiceCallback mockTxPowerServiceCallback = new MockTxPowerServiceCallback() {

            @Override
            public void onTxPowerLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        TxPowerService txPowerService = new TxPowerService(MOCK_BLE_CONNECTION, mockTxPowerServiceCallback, null);
        txPowerService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_getTxPowerLevel_000001() {
        TxPowerService linkLossService = new TxPowerService(MOCK_BLE_CONNECTION, new MockTxPowerServiceCallback(), null);

        assertNull(linkLossService.getTxPowerLevel());
    }

    @Test
    @RequiresDevice
    public void test_getTxPowerLevel_000002() {
        TxPowerService linkLossService = new TxPowerService(MOCK_BLE_CONNECTION, new MockTxPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(linkLossService.getTxPowerLevel());
    }

    @Test
    @RequiresDevice
    public void test_getTxPowerLevel_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        TxPowerService linkLossService = new TxPowerService(MOCK_BLE_CONNECTION, new MockTxPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = linkLossService.getTxPowerLevel();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
