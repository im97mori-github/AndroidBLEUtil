package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CharacteristicAggregateFormatTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicAggregateFormat result = new CharacteristicAggregateFormat(bluetoothGattDescriptor);
        assertArrayEquals(value, result.getListOfHandles());
        assertEquals(value.length / 2, result.getSize());
        assertEquals((value[0] & 0xff) | ((value[1] & 0xff) << 8), result.getHandle(0));
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicAggregateFormat result = new CharacteristicAggregateFormat(bluetoothGattDescriptor);
        assertArrayEquals(value, result.getListOfHandles());
        assertEquals(value.length / 2, result.getSize());
        assertEquals((value[0] & 0xff) | ((value[1] & 0xff) << 8), result.getHandle(0));
        assertEquals((value[2] & 0xff) | ((value[3] & 0xff) << 8), result.getHandle(1));
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicAggregateFormat result1 = new CharacteristicAggregateFormat(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicAggregateFormat result2 = CharacteristicAggregateFormat.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getListOfHandles(), result2.getListOfHandles());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicAggregateFormat result1 = new CharacteristicAggregateFormat(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicAggregateFormat result1 = new CharacteristicAggregateFormat(bluetoothGattDescriptor);
        CharacteristicAggregateFormat result2 = CharacteristicAggregateFormat.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
