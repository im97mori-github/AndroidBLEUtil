package org.im97mori.ble.service.tps.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a07.TxPowerLevel;
import org.im97mori.ble.test.peripheral.MockBLEServerConnection;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.TX_POWER_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TxPowerServiceMockCallbackBuilderTest {

    @Test
    public void test_addTxPowerLevel_00001() {
        Exception exception = null;
        try {
            new TxPowerServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Tx Power Level data", exception.getMessage());
    }

    @Test
    public void test_addTxPowerLevel_00002() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        TxPowerServiceMockCallback callback = new TxPowerServiceMockCallback.Builder<>().addTxPowerLevel(txPowerLevel.getTxPower()).build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(TX_POWER_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), txPowerLevel.getBytes());
    }

    @Test
    public void test_addTxPowerLevel_00003() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> builder = new TxPowerServiceMockCallback.Builder<>();
        builder.addTxPowerLevel(txPowerLevel);
        TxPowerServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(TX_POWER_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), txPowerLevel.getBytes());
    }

    @Test
    public void test_addTxPowerLevel_00004() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> builder = new TxPowerServiceMockCallback.Builder<>();
        builder.addTxPowerLevel(txPowerLevel.getBytes());
        TxPowerServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(TX_POWER_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), txPowerLevel.getBytes());
    }


    @Test
    public void test_addTxPowerLevel_00005() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> builder = new TxPowerServiceMockCallback.Builder<>();
        builder.addTxPowerLevel(0, 0, txPowerLevel.getBytes());
        TxPowerServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(TX_POWER_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), txPowerLevel.getBytes());
    }

    @Test
    public void test_removeTxPowerLevel_00001() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        Exception exception = null;
        try {
            new TxPowerServiceMockCallback.Builder<>()
                    .addTxPowerLevel(txPowerLevel)
                    .removeTxPowerLevel()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Tx Power Level data", exception.getMessage());
    }

}
