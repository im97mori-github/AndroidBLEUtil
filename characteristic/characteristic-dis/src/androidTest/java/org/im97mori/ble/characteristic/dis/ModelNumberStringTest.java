package org.im97mori.ble.characteristic.dis;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ModelNumberStringTest {

    @Test
    public void test1() {
        String modelNumber = "2JCIE-BU01";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(modelNumber.getBytes(StandardCharsets.UTF_8));

        ModelNumberString modelNumberString = new ModelNumberString(bluetoothGattCharacteristic);
        assertEquals(modelNumber, modelNumberString.getModelNumber());
    }

    @Test
    public void test2() {
        String modelNumber = "2JCIE-BU01";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(modelNumber.getBytes(StandardCharsets.UTF_8));

        ModelNumberString result1 = new ModelNumberString(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ModelNumberString result2 = ModelNumberString.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getModelNumber(), result2.getModelNumber());
    }


    @Test
    public void test3() {
        String modelNumber = "2JCIE-BU01";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(modelNumber.getBytes(StandardCharsets.UTF_8));

        ModelNumberString result1 = new ModelNumberString(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(modelNumber.getBytes(), resultData);
    }

    @Test
    public void test4() {
        String modelNumber = "2JCIE-BU01";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(modelNumber.getBytes(StandardCharsets.UTF_8));

        ModelNumberString result1 = new ModelNumberString(bluetoothGattCharacteristic);
        ModelNumberString result2 = ModelNumberString.CREATOR.createFromByteArray(modelNumber.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
