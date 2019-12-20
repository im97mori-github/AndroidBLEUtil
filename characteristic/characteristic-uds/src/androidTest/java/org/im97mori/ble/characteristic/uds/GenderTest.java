package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GenderTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_MALE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Gender result1 = new Gender(bluetoothGattCharacteristic);
        assertEquals(Gender.GENDER_MALE, result1.getGender());
        assertTrue(result1.isGenderMale());
        assertFalse(result1.isGenderFemale());
        assertFalse(result1.isGenderUnspecified());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_FEMALE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Gender result1 = new Gender(bluetoothGattCharacteristic);
        assertEquals(Gender.GENDER_FEMALE, result1.getGender());
        assertFalse(result1.isGenderMale());
        assertTrue(result1.isGenderFemale());
        assertFalse(result1.isGenderUnspecified());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_UNSPECIFIED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Gender result1 = new Gender(bluetoothGattCharacteristic);
        assertEquals(Gender.GENDER_UNSPECIFIED, result1.getGender());
        assertFalse(result1.isGenderMale());
        assertFalse(result1.isGenderFemale());
        assertTrue(result1.isGenderUnspecified());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_FEMALE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Gender result1 = new Gender(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Gender result2 = Gender.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getGender(), result1.getGender());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_FEMALE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Gender result1 = new Gender(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_FEMALE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Gender result1 = new Gender(bluetoothGattCharacteristic);
        Gender result2 = Gender.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
