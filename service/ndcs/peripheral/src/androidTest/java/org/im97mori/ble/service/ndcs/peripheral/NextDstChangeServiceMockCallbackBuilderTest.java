package org.im97mori.ble.service.ndcs.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a11.TimeWithDst;
import org.im97mori.ble.test.peripheral.MockBLEServerConnection;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_WITH_DST_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.NEXT_DST_CHANGE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class NextDstChangeServiceMockCallbackBuilderTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new NextDstChangeServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time with DST data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new NextDstChangeServiceMockCallback.Builder<>()
                    .addTimeWithDst(new TimeWithDst(new byte[8]))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addTimeWithDst_00001() {
        TimeWithDst timeWithDst = new TimeWithDst(new byte[]{0, 1, 2, 3, 4, 5, 6, 7});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            NextDstChangeServiceMockCallback currentTimeServiceMockCallback = new NextDstChangeServiceMockCallback.Builder<>()
                    .addTimeWithDst(timeWithDst)
                    .build();
            currentTimeServiceMockCallback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(NEXT_DST_CHANGE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TIME_WITH_DST_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TIME_WITH_DST_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(timeWithDst.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addTimeWithDst_00101() {
        TimeWithDst timeWithDst = new TimeWithDst(new byte[]{0, 1, 2, 3, 4, 5, 6, 7});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            NextDstChangeServiceMockCallback currentTimeServiceMockCallback = new NextDstChangeServiceMockCallback.Builder<>()
                    .addTimeWithDst(BluetoothGatt.GATT_SUCCESS, 0, timeWithDst.getBytes())
                    .build();
            currentTimeServiceMockCallback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(NEXT_DST_CHANGE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TIME_WITH_DST_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TIME_WITH_DST_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(timeWithDst.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeTimeWithDst_00001() {
        TimeWithDst timeWithDst = new TimeWithDst(new byte[]{0, 1, 2, 3, 4, 5, 6, 7});

        Exception exception = null;
        try {
            new NextDstChangeServiceMockCallback.Builder<>()
                    .addTimeWithDst(timeWithDst)
                    .removeTimeWithDst()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time with DST data", exception.getMessage());
    }

}

