package org.im97mori.ble.characteristic.u2a01;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AppearanceAndroidTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ((Appearance.CATEGORY_UNKNOWN) & 0xff);
        data[ 1] = (byte) ((Appearance.CATEGORY_UNKNOWN >> 8) & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
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

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
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

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AppearanceAndroid result2 = AppearanceAndroid.CREATOR.createFromParcel(parcel);

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

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ((0x000007CF) & 0xff);
        data[ 1] = (byte) ((0x000007CF >> 8) & 0xff);
        //@formatter:off

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
        AppearanceAndroid result2 = AppearanceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
