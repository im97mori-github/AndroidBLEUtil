package org.im97mori.ble.characteristic.u2af5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FixedString16AndroidTest {

    @Test
    public void test_constructor_00001() {
        String fixedString = "0123456789abcdef";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString16Android result1 = new FixedString16Android(bluetoothGattCharacteristic);
        assertEquals(fixedString, result1.getFixedString());
    }

    @Test
    public void test_constructor_00002() {
        String fixedString = "0123456789abcdef ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString16Android result1 = new FixedString16Android(bluetoothGattCharacteristic);
        assertEquals(fixedString.substring(0, 16), result1.getFixedString());
    }

    @Test
    public void test_constructor_00003() {
        String fixedString = "0123456789abcde";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        assertThrows(IndexOutOfBoundsException.class, (
        ) -> new FixedString16Android(bluetoothGattCharacteristic));
    }

    @Test
    public void test_constructor_00101() {
        String fixedString = "0123456789abcdef";

        FixedString16Android result1 = new FixedString16Android(fixedString);
        assertEquals(fixedString, result1.getFixedString());
    }

    @Test
    public void test_constructor_00102() {
        String fixedString = "0123456789abcdef ";

        FixedString16Android result1 = new FixedString16Android(fixedString);
        assertEquals(fixedString.substring(0, 16), result1.getFixedString());
    }

    @Test
    public void test_constructor_00103() {
        String fixedString = "0123456789abcde";

        assertThrows(IndexOutOfBoundsException.class, (
        ) -> new FixedString16Android(fixedString));
    }

    @Test
    public void test_parcelable_00001() {
        String fixedString = "0123456789abcdef";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString16Android result1 = new FixedString16Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FixedString16Android result2 = FixedString16Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFixedString(), result1.getFixedString());
    }

    @Test
    public void test_parcelable_00002() {
        String fixedString = "0123456789abcdef ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString16Android result1 = new FixedString16Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FixedString16Android result2 = FixedString16Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFixedString(), result1.getFixedString());
    }

    @Test
    public void test_parcelable_00101() {
        String fixedString = "0123456789abcdef";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString16Android result1 = new FixedString16Android(bluetoothGattCharacteristic);
        assertArrayEquals(fixedString.getBytes(), result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        String fixedString = "0123456789abcdef ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString16Android result1 = new FixedString16Android(bluetoothGattCharacteristic);
        assertArrayEquals(fixedString.substring(0, 16).getBytes(), result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        String fixedString = "0123456789abcdef";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString16Android result1 = new FixedString16Android(bluetoothGattCharacteristic);
        FixedString16Android result2 = FixedString16Android.CREATOR.createFromByteArray(fixedString.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        String fixedString = "0123456789abcdef ";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(fixedString.getBytes());

        FixedString16Android result1 = new FixedString16Android(bluetoothGattCharacteristic);
        FixedString16Android result2 = FixedString16Android.CREATOR.createFromByteArray(fixedString.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
