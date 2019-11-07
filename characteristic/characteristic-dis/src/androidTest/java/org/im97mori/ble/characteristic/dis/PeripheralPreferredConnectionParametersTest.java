package org.im97mori.ble.characteristic.dis;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PeripheralPreferredConnectionParametersTest {

    @Test
    public void test1() {
        byte[] data = new byte[8];
        data[0] = (byte) (0x10 & 0xff);
        data[1] = (byte) (0x00 & 0xff);
        data[2] = (byte) (0x20 & 0xff);
        data[3] = (byte) (0x00 & 0xff);
        data[4] = (byte) (0x04 & 0xff);
        data[5] = (byte) (0x00 & 0xff);
        data[6] = (byte) (0x90 & 0xff);
        data[7] = (byte) (0x01 & 0xff);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPreferredConnectionParameters peripheralPreferredConnectionParameters = new PeripheralPreferredConnectionParameters(bluetoothGattCharacteristic);
        assertEquals(0x0010, peripheralPreferredConnectionParameters.getMinimumConnectionInterval());
        assertEquals(20, peripheralPreferredConnectionParameters.getMinimumConnectionIntervalMillis(), 0);
        assertEquals(0x0020, peripheralPreferredConnectionParameters.getMaximumConnectionInterval());
        assertEquals(40, peripheralPreferredConnectionParameters.getMaximumConnectionIntervalMillis(), 0);
        assertEquals(4, peripheralPreferredConnectionParameters.getSlaveLatency(), 0);
        assertEquals(0x0190, peripheralPreferredConnectionParameters.getConnectionSupervisionTimeoutMultiplier());
        assertEquals(4000, peripheralPreferredConnectionParameters.getConnectionSupervisionTimeoutMultiplierMillis(), 0);
    }

    @Test
    public void test2() {
        byte[] data = new byte[8];
        data[0] = (byte) (0x10 & 0xff);
        data[1] = (byte) (0x00 & 0xff);
        data[2] = (byte) (0x20 & 0xff);
        data[3] = (byte) (0x00 & 0xff);
        data[4] = (byte) (0x04 & 0xff);
        data[5] = (byte) (0x00 & 0xff);
        data[6] = (byte) (0x90 & 0xff);
        data[7] = (byte) (0x01 & 0xff);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPreferredConnectionParameters result1 = new PeripheralPreferredConnectionParameters(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PeripheralPreferredConnectionParameters result2 = PeripheralPreferredConnectionParameters.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getMinimumConnectionInterval(), result2.getMinimumConnectionInterval());
        assertEquals(result1.getMaximumConnectionInterval(), result2.getMaximumConnectionInterval());
        assertEquals(result1.getSlaveLatency(), result2.getSlaveLatency(), 0);
        assertEquals(result1.getConnectionSupervisionTimeoutMultiplier(), result2.getConnectionSupervisionTimeoutMultiplier());
    }

    @Test
    public void test3() {
        byte[] data = new byte[8];
        data[0] = (byte) (0x10 & 0xff);
        data[1] = (byte) (0x00 & 0xff);
        data[2] = (byte) (0x20 & 0xff);
        data[3] = (byte) (0x00 & 0xff);
        data[4] = (byte) (0x04 & 0xff);
        data[5] = (byte) (0x00 & 0xff);
        data[6] = (byte) (0x90 & 0xff);
        data[7] = (byte) (0x01 & 0xff);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPreferredConnectionParameters result1 = new PeripheralPreferredConnectionParameters(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test4() {
        byte[] data = new byte[8];
        data[0] = (byte) (0x10 & 0xff);
        data[1] = (byte) (0x00 & 0xff);
        data[2] = (byte) (0x20 & 0xff);
        data[3] = (byte) (0x00 & 0xff);
        data[4] = (byte) (0x04 & 0xff);
        data[5] = (byte) (0x00 & 0xff);
        data[6] = (byte) (0x90 & 0xff);
        data[7] = (byte) (0x01 & 0xff);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPreferredConnectionParameters result1 = new PeripheralPreferredConnectionParameters(bluetoothGattCharacteristic);
        PeripheralPreferredConnectionParameters result2 = PeripheralPreferredConnectionParameters.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
