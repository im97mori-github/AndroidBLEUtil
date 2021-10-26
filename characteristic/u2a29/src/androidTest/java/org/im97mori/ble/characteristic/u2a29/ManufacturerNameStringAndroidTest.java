package org.im97mori.ble.characteristic.u2a29;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ManufacturerNameStringAndroidTest {

    @Test
    public void test_constructor001() {
        String manufactureName = "OMRON";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(manufactureName.getBytes());

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(bluetoothGattCharacteristic);
        assertEquals(manufactureName, result1.getManufacturerName());
    }

    @Test
    public void test_constructor002() {
        String manufactureName = "OMRON";

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(manufactureName);
        assertEquals(manufactureName, result1.getManufacturerName());
    }

    @Test
    public void test_parcelable001() {
        String manufactureName = "OMRON";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(manufactureName.getBytes());

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerNameStringAndroid result2 = ManufacturerNameStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getManufacturerName(), result2.getManufacturerName());
    }

    @Test
    public void test_parcelable002() {
        String manufactureName = "OMRON";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(manufactureName.getBytes());

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(manufactureName.getBytes(), resultData);
    }

    @Test
    public void test_parcelable003() {
        String manufactureName = "OMRON";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(manufactureName.getBytes());

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(bluetoothGattCharacteristic);
        ManufacturerNameStringAndroid result2 = ManufacturerNameStringAndroid.CREATOR.createFromByteArray(manufactureName.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
