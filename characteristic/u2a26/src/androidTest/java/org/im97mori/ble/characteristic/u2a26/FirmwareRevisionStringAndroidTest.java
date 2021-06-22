package org.im97mori.ble.characteristic.u2a26;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FirmwareRevisionStringAndroidTest {

    @Test
    public void test_constructor001() {
        String firmwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(bluetoothGattCharacteristic);
        assertEquals(firmwareRevision, result1.getFirmwareRevision());
    }

    @Test
    public void test_constructor002() {
        String firmwareRevision = "99.99";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(bluetoothGattCharacteristic);
        assertEquals(firmwareRevision, result1.getFirmwareRevision());
    }

    @Test
    public void test_constructor003() {
        String firmwareRevision = "99.99";

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(firmwareRevision);
        assertEquals(firmwareRevision, result1.getFirmwareRevision());
    }

    @Test
    public void test_parcelable001() {
        String firmwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FirmwareRevisionStringAndroid result2 = FirmwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFirmwareRevision(), result1.getFirmwareRevision());
    }

    @Test
    public void test_parcelable002() {
        String firmwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FirmwareRevisionStringAndroid result2 = FirmwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getFirmwareRevision(), result2.getFirmwareRevision());
    }

    @Test
    public void test_parcelable003() {
        String firmwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(firmwareRevision.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String firmwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(bluetoothGattCharacteristic);
        FirmwareRevisionStringAndroid result2 = FirmwareRevisionStringAndroid.CREATOR.createFromByteArray(firmwareRevision.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
