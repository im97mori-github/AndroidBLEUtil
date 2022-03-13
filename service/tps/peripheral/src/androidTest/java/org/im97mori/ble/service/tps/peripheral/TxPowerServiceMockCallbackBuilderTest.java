package org.im97mori.ble.service.tps.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.u2a07.TxPowerLevel;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.TX_POWER_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class TxPowerServiceMockCallbackBuilderTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
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
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addTxPowerLevel_00002() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        TxPowerServiceMockCallback callback = new TxPowerServiceMockCallback.Builder<>().addTxPowerLevel(txPowerLevel.getTxPower()).build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(TX_POWER_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), txPowerLevel.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addTxPowerLevel_00003() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> builder = new TxPowerServiceMockCallback.Builder<>();
        builder.addTxPowerLevel(txPowerLevel);
        TxPowerServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(TX_POWER_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), txPowerLevel.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addTxPowerLevel_00004() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> builder = new TxPowerServiceMockCallback.Builder<>();
        builder.addTxPowerLevel(txPowerLevel.getBytes());
        TxPowerServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(TX_POWER_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), txPowerLevel.getBytes());
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addTxPowerLevel_00005() {
        TxPowerLevel txPowerLevel = new TxPowerLevel(1);
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> builder = new TxPowerServiceMockCallback.Builder<>();
        builder.addTxPowerLevel(0, 0, txPowerLevel.getBytes());
        TxPowerServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(TX_POWER_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), txPowerLevel.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
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
