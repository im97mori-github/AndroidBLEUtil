package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AppearanceTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ((Appearance.CATEGORY_UNKNOWN) & 0xff);
        data[ 1] = (byte) ((Appearance.CATEGORY_UNKNOWN >> 8) & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Appearance result1 = new Appearance(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategory());
        assertEquals(Appearance.CATEGORY_UNKNOWN, result1.getCategoryUint16());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ((0x000007CF) & 0xff);
        data[ 1] = (byte) ((0x000007CF >> 8) & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Appearance result1 = new Appearance(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategory());
        assertEquals(0x000007CF, result1.getCategoryUint16());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ((0x000007CF) & 0xff);
        data[ 1] = (byte) ((0x000007CF >> 8) & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Appearance result1 = new Appearance(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Appearance result2 = Appearance.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getCategory(), result2.getCategory());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ((0x000007CF) & 0xff);
        data[ 1] = (byte) ((0x000007CF >> 8) & 0xff);
        //@formatter:off

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Appearance result1 = new Appearance(bluetoothGattCharacteristic);
        Appearance result2 = Appearance.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
