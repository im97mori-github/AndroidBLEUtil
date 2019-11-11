package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PeripheralPreferredConnectionParametersTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) (0x10 & 0xff);
        data[ 1] = (byte) (0x00 & 0xff);
        data[ 2] = (byte) (0x20 & 0xff);
        data[ 3] = (byte) (0x00 & 0xff);
        data[ 4] = (byte) (0x04 & 0xff);
        data[ 5] = (byte) (0x00 & 0xff);
        data[ 6] = (byte) (0x90 & 0xff);
        data[ 7] = (byte) (0x01 & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPreferredConnectionParameters result1 = new PeripheralPreferredConnectionParameters(bluetoothGattCharacteristic);
        assertEquals(0x0010, result1.getMinimumConnectionInterval());
        assertEquals(20, result1.getMinimumConnectionIntervalMillis(), 0);
        assertEquals(0x0020, result1.getMaximumConnectionInterval());
        assertEquals(40, result1.getMaximumConnectionIntervalMillis(), 0);
        assertEquals(4, result1.getSlaveLatency(), 0);
        assertEquals(0x0190, result1.getConnectionSupervisionTimeoutMultiplier());
        assertEquals(4000, result1.getConnectionSupervisionTimeoutMultiplierMillis(), 0);
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) (0x10 & 0xff);
        data[ 1] = (byte) (0x00 & 0xff);
        data[ 2] = (byte) (0x20 & 0xff);
        data[ 3] = (byte) (0x00 & 0xff);
        data[ 4] = (byte) (0x04 & 0xff);
        data[ 5] = (byte) (0x00 & 0xff);
        data[ 6] = (byte) (0x90 & 0xff);
        data[ 7] = (byte) (0x01 & 0xff);
        //@formatter:on

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
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) (0x10 & 0xff);
        data[ 1] = (byte) (0x00 & 0xff);
        data[ 2] = (byte) (0x20 & 0xff);
        data[ 3] = (byte) (0x00 & 0xff);
        data[ 4] = (byte) (0x04 & 0xff);
        data[ 5] = (byte) (0x00 & 0xff);
        data[ 6] = (byte) (0x90 & 0xff);
        data[ 7] = (byte) (0x01 & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPreferredConnectionParameters result1 = new PeripheralPreferredConnectionParameters(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) (0x10 & 0xff);
        data[ 1] = (byte) (0x00 & 0xff);
        data[ 2] = (byte) (0x20 & 0xff);
        data[ 3] = (byte) (0x00 & 0xff);
        data[ 4] = (byte) (0x04 & 0xff);
        data[ 5] = (byte) (0x00 & 0xff);
        data[ 6] = (byte) (0x90 & 0xff);
        data[ 7] = (byte) (0x01 & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPreferredConnectionParameters result1 = new PeripheralPreferredConnectionParameters(bluetoothGattCharacteristic);
        PeripheralPreferredConnectionParameters result2 = PeripheralPreferredConnectionParameters.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
