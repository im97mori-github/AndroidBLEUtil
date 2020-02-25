package org.im97mori.ble.characteristic.u2a27;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HardwareRevisionStringAndroidTest {

    @Test
    public void test_constructor001() {
        String hardwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(bluetoothGattCharacteristic);
        assertEquals(hardwareRevision, result1.getHardwareRevision());
    }

    @Test
    public void test_constructor002() {
        String hardwareRevision = "99.99";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(bluetoothGattCharacteristic);
        assertEquals(hardwareRevision, result1.getHardwareRevision());
    }

    @Test
    public void test_parcelable001() {
        String hardwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HardwareRevisionStringAndroid result2 = HardwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getHardwareRevision(), result1.getHardwareRevision());
    }

    @Test
    public void test_parcelable002() {
        String hardwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HardwareRevisionStringAndroid result2 = HardwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getHardwareRevision(), result2.getHardwareRevision());
    }

    @Test
    public void test_parcelable003() {
        String hardwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(hardwareRevision.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String hardwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(hardwareRevision.getBytes(StandardCharsets.UTF_8));

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(bluetoothGattCharacteristic);
        HardwareRevisionStringAndroid result2 = HardwareRevisionStringAndroid.CREATOR.createFromByteArray(hardwareRevision.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
