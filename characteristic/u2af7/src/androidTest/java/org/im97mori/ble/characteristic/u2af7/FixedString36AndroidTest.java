package org.im97mori.ble.characteristic.u2af7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FixedString36AndroidTest {

    @Test
    public void test_constructor_00001() {
        String fixedString = "012345678901234567890123456789012345";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString36Android result1 = new FixedString36Android(bluetoothGattCharacteristic);
        assertEquals(fixedString, result1.getFixedString());
    }

    @Test
    public void test_constructor_00002() {
        String fixedString = "012345678901234567890123456789012345 ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString36Android result1 = new FixedString36Android(bluetoothGattCharacteristic);
        assertEquals(fixedString.substring(0, 36), result1.getFixedString());
    }

    @Test
    public void test_constructor_00003() {
        String fixedString = "01234567890123456789012345678901234";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        assertThrows(IndexOutOfBoundsException.class, (
        ) -> new FixedString36Android(bluetoothGattCharacteristic));
    }

    @Test
    public void test_constructor_00101() {
        String fixedString = "012345678901234567890123456789012345";

        FixedString36Android result1 = new FixedString36Android(fixedString);
        assertEquals(fixedString, result1.getFixedString());
    }

    @Test
    public void test_constructor_00102() {
        String fixedString = "012345678901234567890123456789012345 ";

        FixedString36Android result1 = new FixedString36Android(fixedString);
        assertEquals(fixedString.substring(0, 36), result1.getFixedString());
    }

    @Test
    public void test_constructor_00103() {
        String fixedString = "01234567890123456789012345678901234";

        assertThrows(IndexOutOfBoundsException.class, (
        ) -> new FixedString36Android(fixedString));
    }

    @Test
    public void test_parcelable_00001() {
        String fixedString = "012345678901234567890123456789012345";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString36Android result1 = new FixedString36Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FixedString36Android result2 = FixedString36Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFixedString(), result1.getFixedString());
    }

    @Test
    public void test_parcelable_00002() {
        String fixedString = "012345678901234567890123456789012345 ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString36Android result1 = new FixedString36Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FixedString36Android result2 = FixedString36Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFixedString(), result1.getFixedString());
    }

    @Test
    public void test_parcelable_00101() {
        String fixedString = "012345678901234567890123456789012345";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString36Android result1 = new FixedString36Android(bluetoothGattCharacteristic);
        assertArrayEquals(fixedString.getBytes(), result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        String fixedString = "012345678901234567890123456789012345 ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString36Android result1 = new FixedString36Android(bluetoothGattCharacteristic);
        assertArrayEquals(fixedString.substring(0, 36).getBytes(), result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        String fixedString = "012345678901234567890123456789012345";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString36Android result1 = new FixedString36Android(bluetoothGattCharacteristic);
        FixedString36Android result2 = FixedString36Android.CREATOR.createFromByteArray(fixedString.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        String fixedString = "012345678901234567890123456789012345 ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString36Android result1 = new FixedString36Android(bluetoothGattCharacteristic);
        FixedString36Android result2 = FixedString36Android.CREATOR.createFromByteArray(fixedString.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
