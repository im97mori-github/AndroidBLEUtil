package org.im97mori.ble.characteristic.u2af8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FixedString8AndroidTest {

    @Test
    public void test_constructor_00001() {
        String fixedString = "01234567";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString8Android result1 = new FixedString8Android(bluetoothGattCharacteristic);
        assertEquals(fixedString, result1.getFixedString());
    }

    @Test
    public void test_constructor_00002() {
        String fixedString = "01234567 ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString8Android result1 = new FixedString8Android(bluetoothGattCharacteristic);
        assertEquals(fixedString.substring(0, 8), result1.getFixedString());
    }

    @Test
    public void test_constructor_00003() {
        String fixedString = "0123456";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        assertThrows(IndexOutOfBoundsException.class, (
        ) -> new FixedString8Android(bluetoothGattCharacteristic));
    }

    @Test
    public void test_constructor_00101() {
        String fixedString = "01234567";

        FixedString8Android result1 = new FixedString8Android(fixedString);
        assertEquals(fixedString, result1.getFixedString());
    }

    @Test
    public void test_constructor_00102() {
        String fixedString = "01234567 ";

        FixedString8Android result1 = new FixedString8Android(fixedString);
        assertEquals(fixedString.substring(0, 8), result1.getFixedString());
    }

    @Test
    public void test_constructor_00103() {
        String fixedString = "0123456";

        assertThrows(IndexOutOfBoundsException.class, (
        ) -> new FixedString8Android(fixedString));
    }

    @Test
    public void test_parcelable_00001() {
        String fixedString = "01234567";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString8Android result1 = new FixedString8Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FixedString8Android result2 = FixedString8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFixedString(), result1.getFixedString());
    }

    @Test
    public void test_parcelable_00002() {
        String fixedString = "01234567 ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString8Android result1 = new FixedString8Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FixedString8Android result2 = FixedString8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFixedString(), result1.getFixedString());
    }

    @Test
    public void test_parcelable_00101() {
        String fixedString = "01234567";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString8Android result1 = new FixedString8Android(bluetoothGattCharacteristic);
        assertArrayEquals(fixedString.getBytes(), result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        String fixedString = "01234567 ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString8Android result1 = new FixedString8Android(bluetoothGattCharacteristic);
        assertArrayEquals(fixedString.substring(0, 8).getBytes(), result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        String fixedString = "01234567";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString8Android result1 = new FixedString8Android(bluetoothGattCharacteristic);
        FixedString8Android result2 = FixedString8Android.CREATOR.createFromByteArray(fixedString.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        String fixedString = "01234567 ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString8Android result1 = new FixedString8Android(bluetoothGattCharacteristic);
        FixedString8Android result2 = FixedString8Android.CREATOR.createFromByteArray(fixedString.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
