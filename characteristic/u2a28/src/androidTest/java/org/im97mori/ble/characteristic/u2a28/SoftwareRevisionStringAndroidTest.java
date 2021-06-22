package org.im97mori.ble.characteristic.u2a28;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SoftwareRevisionStringAndroidTest {

    @Test
    public void test_constructor001() {
        String softwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(softwareRevision.getBytes(StandardCharsets.UTF_8));

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(bluetoothGattCharacteristic);
        assertEquals(softwareRevision, result1.getSoftwareRevision());
    }

    @Test
    public void test_constructor002() {
        String softwareRevision = "99.99";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(softwareRevision.getBytes(StandardCharsets.UTF_8));

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(bluetoothGattCharacteristic);
        assertEquals(softwareRevision, result1.getSoftwareRevision());
    }

    @Test
    public void test_constructor003() {
        String softwareRevision = "99.99";

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(softwareRevision);
        assertEquals(softwareRevision, result1.getSoftwareRevision());
    }

    @Test
    public void test_parcelable001() {
        String firmwareRevision = "00.00";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(firmwareRevision.getBytes(StandardCharsets.UTF_8));

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SoftwareRevisionStringAndroid result2 = SoftwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getSoftwareRevision(), result1.getSoftwareRevision());
    }

    @Test
    public void test_parcelable002() {
        String softwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(softwareRevision.getBytes(StandardCharsets.UTF_8));

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SoftwareRevisionStringAndroid result2 = SoftwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getSoftwareRevision(), result2.getSoftwareRevision());
    }

    @Test
    public void test_parcelable003() {
        String softwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(softwareRevision.getBytes(StandardCharsets.UTF_8));

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(softwareRevision.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String softwareRevision = "12.34";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(softwareRevision.getBytes(StandardCharsets.UTF_8));

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(bluetoothGattCharacteristic);
        SoftwareRevisionStringAndroid result2 = SoftwareRevisionStringAndroid.CREATOR.createFromByteArray(softwareRevision.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
