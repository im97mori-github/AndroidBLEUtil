package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEConstants;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ManufacturerNameStringTest {

    @Test
    public void test1() {
        String manufactureName = "OMRON";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(manufactureName.getBytes(StandardCharsets.UTF_8));

        ManufacturerNameString manufacturerNameString = new ManufacturerNameString(bluetoothGattCharacteristic);
        assertEquals(manufactureName, manufacturerNameString.getManufactureName());
    }

    @Test
    public void test2() {
        String manufactureName = "OMRON";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(manufactureName.getBytes(StandardCharsets.UTF_8));

        ManufacturerNameString result1 = new ManufacturerNameString(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerNameString result2 = ManufacturerNameString.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getManufactureName(), result2.getManufactureName());
    }

    @Test
    public void test3() {
        String manufactureName = "OMRON";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(manufactureName.getBytes(StandardCharsets.UTF_8));

        ManufacturerNameString result1 = new ManufacturerNameString(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(manufactureName.getBytes(), resultData);
    }

    @Test
    public void test4() {
        String manufactureName = "OMRON";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(manufactureName.getBytes(StandardCharsets.UTF_8));

        ManufacturerNameString result1 = new ManufacturerNameString(bluetoothGattCharacteristic);
        ManufacturerNameString result2 = ManufacturerNameString.CREATOR.createFromByteArray(manufactureName.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
