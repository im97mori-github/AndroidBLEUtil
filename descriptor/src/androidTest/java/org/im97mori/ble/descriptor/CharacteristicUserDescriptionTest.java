package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CharacteristicUserDescriptionTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        String text = "abced";
        byte[] value = text.getBytes();
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicUserDescription result = new CharacteristicUserDescription(bluetoothGattDescriptor);
        assertEquals(text, result.getUserDescription());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        String text = "abced";
        byte[] value = text.getBytes();
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicUserDescription result1 = new CharacteristicUserDescription(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicUserDescription result2 = CharacteristicUserDescription.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getUserDescription(), result2.getUserDescription());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        String text = "abced";
        byte[] value = text.getBytes();
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicUserDescription result1 = new CharacteristicUserDescription(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        String text = "abced";
        byte[] value = text.getBytes();
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CharacteristicUserDescription result1 = new CharacteristicUserDescription(bluetoothGattDescriptor);
        CharacteristicUserDescription result2 = CharacteristicUserDescription.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
