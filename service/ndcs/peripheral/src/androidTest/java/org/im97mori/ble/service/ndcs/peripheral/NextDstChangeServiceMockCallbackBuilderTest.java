package org.im97mori.ble.service.ndcs.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_WITH_DST_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.NEXT_DST_CHANGE_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.characteristic.u2a11.TimeWithDst;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class NextDstChangeServiceMockCallbackBuilderTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
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
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
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
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addTimeWithDst_00001() {
        TimeWithDst timeWithDst = new TimeWithDst(new byte[]{0, 1, 2, 3, 4, 5, 6, 7});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            NextDstChangeServiceMockCallback currentTimeServiceMockCallback = new NextDstChangeServiceMockCallback.Builder<>()
                    .addTimeWithDst(timeWithDst)
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
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
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addTimeWithDst_00101() {
        TimeWithDst timeWithDst = new TimeWithDst(new byte[]{0, 1, 2, 3, 4, 5, 6, 7});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            NextDstChangeServiceMockCallback currentTimeServiceMockCallback = new NextDstChangeServiceMockCallback.Builder<>()
                    .addTimeWithDst(BluetoothGatt.GATT_SUCCESS, 0, timeWithDst.getBytes())
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
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
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
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

