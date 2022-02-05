package org.im97mori.ble.characteristic.u2a0f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DstOffsetUtils;
import org.im97mori.ble.characteristic.core.TimeZoneUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class LocalTimeInformationAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN;
        data[ 1] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN, result1.getTimeZone());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) -48;
        data[ 1] = DstOffsetUtils.DST_OFFSET_STANDARD_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(-48, result1.getTimeZone());
        assertEquals(DstOffsetUtils.DST_OFFSET_STANDARD_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 56;
        data[ 1] = DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(56, result1.getTimeZone());
        assertEquals(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 56;
        data[ 1] = DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(56, result1.getTimeZone());
        assertEquals(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 56;
        data[ 1] = DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(56, result1.getTimeZone());
        assertEquals(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor006() {
        int timeZone = 1;
        int dstOffset = 2;

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(timeZone, dstOffset);
        assertEquals(timeZone, result1.getTimeZone());
        assertEquals(dstOffset, result1.getDstOffset());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocalTimeInformationAndroid result2 = LocalTimeInformationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeZone(), result1.getTimeZone());
        assertEquals(result2.getDstOffset(), result1.getDstOffset());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformationAndroid result1 = new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        LocalTimeInformationAndroid result2 = LocalTimeInformationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
