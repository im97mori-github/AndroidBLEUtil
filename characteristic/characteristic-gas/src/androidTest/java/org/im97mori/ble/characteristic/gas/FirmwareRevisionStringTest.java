package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FirmwareRevisionStringTest {

    @Test
    public void test1() {
        String firmwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionString firmwareRevisionString = new FirmwareRevisionString(bluetoothGattCharacteristic);
        assertEquals(firmwareRevision, firmwareRevisionString.getFirmwareRevision());
    }

    @Test
    public void test2() {
        String firmwareRevision = "99.99";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionString firmwareRevisionString = new FirmwareRevisionString(bluetoothGattCharacteristic);
        assertEquals(firmwareRevision, firmwareRevisionString.getFirmwareRevision());
    }

    @Test
    public void test3() {
        String firmwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionString result1 = new FirmwareRevisionString(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FirmwareRevisionString result2 = FirmwareRevisionString.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFirmwareRevision(), result1.getFirmwareRevision());
    }

    @Test
    public void test4() {
        String firmwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionString result1 = new FirmwareRevisionString(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FirmwareRevisionString result2 = FirmwareRevisionString.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getFirmwareRevision(), result2.getFirmwareRevision());
    }

    @Test
    public void test5() {
        String firmwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionString result1 = new FirmwareRevisionString(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(firmwareRevision.getBytes(), resultData);
    }

    @Test
    public void test6() {
        String firmwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionString result1 = new FirmwareRevisionString(bluetoothGattCharacteristic);
        FirmwareRevisionString result2 = FirmwareRevisionString.CREATOR.createFromByteArray(firmwareRevision.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
