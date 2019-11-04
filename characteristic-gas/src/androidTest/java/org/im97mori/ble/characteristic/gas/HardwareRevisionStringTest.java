package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEConstants;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HardwareRevisionStringTest {

    @Test
    public void test1() {
        String hardwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionString hardwareRevisionString = new HardwareRevisionString(bluetoothGattCharacteristic);
        assertEquals(hardwareRevision, hardwareRevisionString.getHardwareRevision());
    }

    @Test
    public void test2() {
        String hardwareRevision = "99.99";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionString hardwareRevisionString = new HardwareRevisionString(bluetoothGattCharacteristic);
        assertEquals(hardwareRevision, hardwareRevisionString.getHardwareRevision());
    }

    @Test
    public void test3() {
        String hardwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionString result1 = new HardwareRevisionString(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HardwareRevisionString result2 = HardwareRevisionString.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getHardwareRevision(), result1.getHardwareRevision());
    }

    @Test
    public void test4() {
        String hardwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionString result1 = new HardwareRevisionString(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HardwareRevisionString result2 = HardwareRevisionString.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getHardwareRevision(), result2.getHardwareRevision());
    }

    @Test
    public void test5() {
        String hardwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionString result1 = new HardwareRevisionString(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(hardwareRevision.getBytes(), resultData);
    }

    @Test
    public void test6() {
        String hardwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionString result1 = new HardwareRevisionString(bluetoothGattCharacteristic);
        HardwareRevisionString result2 = HardwareRevisionString.CREATOR.createFromByteArray(hardwareRevision.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
