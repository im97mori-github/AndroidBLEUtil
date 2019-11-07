package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SerialNumberStringTest {

    @Test
    public void test1() {
        String serialNumber = "0000MY0000";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString serialNumberString = new SerialNumberString(bluetoothGattCharacteristic);
        assertEquals(serialNumber, serialNumberString.getSerialNumber());
    }

    @Test
    public void test2() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString serialNumberString = new SerialNumberString(bluetoothGattCharacteristic);
        assertEquals(serialNumber, serialNumberString.getSerialNumber());
    }

    @Test
    public void test3() {
        String serialNumber = "0000MY0000";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
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

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
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

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString result1 = new SerialNumberString(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(serialNumber.getBytes(), resultData);
    }

    @Test
    public void test6() {
        String serialNumber = "39Z9MY9999";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(serialNumber.getBytes(StandardCharsets.UTF_8));

        SerialNumberString result1 = new SerialNumberString(bluetoothGattCharacteristic);
        SerialNumberString result2 = SerialNumberString.CREATOR.createFromByteArray(serialNumber.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
