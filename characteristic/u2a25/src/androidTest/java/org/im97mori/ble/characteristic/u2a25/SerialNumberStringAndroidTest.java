package org.im97mori.ble.characteristic.u2a25;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SerialNumberStringAndroidTest {

    @Test
    public void test_constructor001() {
        String serialNumber = "0000MY0000";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(bluetoothGattCharacteristic);
        assertEquals(serialNumber, result1.getSerialNumber());
    }

    @Test
    public void test_constructor002() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(bluetoothGattCharacteristic);
        assertEquals(serialNumber, result1.getSerialNumber());
    }

    @Test
    public void test_constructor003() {
        String serialNumber = "39Z9MY9999";

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(serialNumber);
        assertEquals(serialNumber, result1.getSerialNumber());
    }

    @Test
    public void test_parcelable001() {
        String serialNumber = "0000MY0000";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SerialNumberStringAndroid result2 = SerialNumberStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getSerialNumber(), result2.getSerialNumber());
    }

    @Test
    public void test_parcelable002() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SerialNumberStringAndroid result2 = SerialNumberStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getSerialNumber(), result2.getSerialNumber());
    }

    @Test
    public void test_parcelable003() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(serialNumber.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(bluetoothGattCharacteristic);
        SerialNumberStringAndroid result2 = SerialNumberStringAndroid.CREATOR.createFromByteArray(serialNumber.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
