package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.ad.AdvertisingDataConstants;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SerialNumberStringTest {

    @Test
    public void test1() {
        String serialNumber = "0000MY0000";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AdvertisingDataConstants.BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString serialNumberString = new SerialNumberString(bluetoothGattCharacteristic);
        assertEquals(serialNumber, serialNumberString.getSerialNumber());
    }

    @Test
    public void test2() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AdvertisingDataConstants.BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString serialNumberString = new SerialNumberString(bluetoothGattCharacteristic);
        assertEquals(serialNumber, serialNumberString.getSerialNumber());
    }

    @Test
    public void test3() {
        String serialNumber = "0000MY0000";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AdvertisingDataConstants.BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString result1 = new SerialNumberString(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SerialNumberString result2 = SerialNumberString.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getSerialNumber(), result2.getSerialNumber());
    }

    @Test
    public void test4() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AdvertisingDataConstants.BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString result1 = new SerialNumberString(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SerialNumberString result2 = SerialNumberString.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getSerialNumber(), result2.getSerialNumber());
    }

    @Test
    public void test5() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AdvertisingDataConstants.BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString result1 = new SerialNumberString(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(serialNumber.getBytes(), resultData);
    }
}
