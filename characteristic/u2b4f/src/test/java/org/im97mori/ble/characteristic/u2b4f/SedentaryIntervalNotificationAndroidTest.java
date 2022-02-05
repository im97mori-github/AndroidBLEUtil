package org.im97mori.ble.characteristic.u2b4f;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class SedentaryIntervalNotificationAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data_00002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getSedentaryIntervalNotification());
        assertFalse(result1.isSedentaryIntervalNotification());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getSedentaryIntervalNotification());
        assertTrue(result1.isSedentaryIntervalNotification());
    }

    @Test
    public void test_constructor_00101() {
        int sedentaryIntervalNotification = 1;

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(sedentaryIntervalNotification);
        assertEquals(sedentaryIntervalNotification, result1.getSedentaryIntervalNotification());
        assertFalse(result1.isSedentaryIntervalNotification());
    }

    @Test
    public void test_constructor_00102() {
        int sedentaryIntervalNotification = 0;

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(sedentaryIntervalNotification);
        assertEquals(sedentaryIntervalNotification, result1.getSedentaryIntervalNotification());
        assertTrue(result1.isSedentaryIntervalNotification());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SedentaryIntervalNotificationAndroid result2 = SedentaryIntervalNotificationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSedentaryIntervalNotification(), result2.getSedentaryIntervalNotification());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SedentaryIntervalNotificationAndroid result2 = SedentaryIntervalNotificationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSedentaryIntervalNotification(), result2.getSedentaryIntervalNotification());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        SedentaryIntervalNotificationAndroid result2 = SedentaryIntervalNotificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SedentaryIntervalNotificationAndroid result1 = new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        SedentaryIntervalNotificationAndroid result2 = SedentaryIntervalNotificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
