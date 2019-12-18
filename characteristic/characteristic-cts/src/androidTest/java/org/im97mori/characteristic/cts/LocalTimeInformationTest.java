package org.im97mori.characteristic.cts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocalTimeInformationTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN;
        data[ 1] = (byte) LocalTimeInformation.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformation result1 = new LocalTimeInformation(bluetoothGattCharacteristic);
        assertEquals(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, result1.getTimeZone());
        assertTrue(result1.isTimeZoneNotKnown());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, result1.getTimeZoneOffsetMin());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN * 1000L, result1.getTimeZoneOffsetMillis());
        assertEquals(LocalTimeInformation.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
        assertFalse(result1.isDstOffsetStandardTime());
        assertFalse(result1.isDstOffsetHalfAnHourDaylightTime());
        assertFalse(result1.isDstOffsetDaylightTime());
        assertFalse(result1.isDstOffsetDoubleDaylightTime());
        assertTrue(result1.isDstNotKnown());
        assertEquals(LocalTimeInformation.DST_OFFSET_UNIT * LocalTimeInformation.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffsetMin());
        assertEquals(LocalTimeInformation.DST_OFFSET_UNIT * LocalTimeInformation.DST_OFFSET_IS_NOT_KNOWN * 1000L, result1.getDstOffsetMillis());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) -48;
        data[ 1] = LocalTimeInformation.DST_OFFSET_STANDARD_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformation result1 = new LocalTimeInformation(bluetoothGattCharacteristic);
        assertEquals(-48, result1.getTimeZone());
        assertFalse(result1.isTimeZoneNotKnown());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * -48, result1.getTimeZoneOffsetMin());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * -48 * 1000L, result1.getTimeZoneOffsetMillis());
        assertEquals(LocalTimeInformation.DST_OFFSET_STANDARD_TIME, result1.getDstOffset());
        assertTrue(result1.isDstOffsetStandardTime());
        assertFalse(result1.isDstOffsetHalfAnHourDaylightTime());
        assertFalse(result1.isDstOffsetDaylightTime());
        assertFalse(result1.isDstOffsetDoubleDaylightTime());
        assertFalse(result1.isDstNotKnown());
        assertEquals(0, result1.getDstOffsetMin());
        assertEquals(0, result1.getDstOffsetMillis());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 56;
        data[ 1] = LocalTimeInformation.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformation result1 = new LocalTimeInformation(bluetoothGattCharacteristic);
        assertEquals(56, result1.getTimeZone());
        assertFalse(result1.isTimeZoneNotKnown());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * 56, result1.getTimeZoneOffsetMin());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * 56 * 1000L, result1.getTimeZoneOffsetMillis());
        assertEquals(LocalTimeInformation.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME, result1.getDstOffset());
        assertFalse(result1.isDstOffsetStandardTime());
        assertTrue(result1.isDstOffsetHalfAnHourDaylightTime());
        assertFalse(result1.isDstOffsetDaylightTime());
        assertFalse(result1.isDstOffsetDoubleDaylightTime());
        assertFalse(result1.isDstNotKnown());
        assertEquals(LocalTimeInformation.DST_OFFSET_UNIT * LocalTimeInformation.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME, result1.getDstOffsetMin());
        assertEquals(LocalTimeInformation.DST_OFFSET_UNIT * LocalTimeInformation.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME * 1000L, result1.getDstOffsetMillis());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 56;
        data[ 1] = LocalTimeInformation.DST_OFFSET_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformation result1 = new LocalTimeInformation(bluetoothGattCharacteristic);
        assertEquals(56, result1.getTimeZone());
        assertFalse(result1.isTimeZoneNotKnown());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * 56, result1.getTimeZoneOffsetMin());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * 56 * 1000L, result1.getTimeZoneOffsetMillis());
        assertEquals(LocalTimeInformation.DST_OFFSET_DAYLIGHT_TIME, result1.getDstOffset());
        assertFalse(result1.isDstOffsetStandardTime());
        assertFalse(result1.isDstOffsetHalfAnHourDaylightTime());
        assertTrue(result1.isDstOffsetDaylightTime());
        assertFalse(result1.isDstOffsetDoubleDaylightTime());
        assertFalse(result1.isDstNotKnown());
        assertEquals(LocalTimeInformation.DST_OFFSET_UNIT * LocalTimeInformation.DST_OFFSET_DAYLIGHT_TIME, result1.getDstOffsetMin());
        assertEquals(LocalTimeInformation.DST_OFFSET_UNIT * LocalTimeInformation.DST_OFFSET_DAYLIGHT_TIME * 1000L, result1.getDstOffsetMillis());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 56;
        data[ 1] = LocalTimeInformation.DST_OFFSET_DOUBLE_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformation result1 = new LocalTimeInformation(bluetoothGattCharacteristic);
        assertEquals(56, result1.getTimeZone());
        assertFalse(result1.isTimeZoneNotKnown());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * 56, result1.getTimeZoneOffsetMin());
        assertEquals(LocalTimeInformation.TIME_ZONE_UNIT * 56 * 1000L, result1.getTimeZoneOffsetMillis());
        assertEquals(LocalTimeInformation.DST_OFFSET_DOUBLE_DAYLIGHT_TIME, result1.getDstOffset());
        assertFalse(result1.isDstOffsetStandardTime());
        assertFalse(result1.isDstOffsetHalfAnHourDaylightTime());
        assertFalse(result1.isDstOffsetDaylightTime());
        assertTrue(result1.isDstOffsetDoubleDaylightTime());
        assertFalse(result1.isDstNotKnown());
        assertEquals(LocalTimeInformation.DST_OFFSET_UNIT * LocalTimeInformation.DST_OFFSET_DOUBLE_DAYLIGHT_TIME, result1.getDstOffsetMin());
        assertEquals(LocalTimeInformation.DST_OFFSET_UNIT * LocalTimeInformation.DST_OFFSET_DOUBLE_DAYLIGHT_TIME * 1000L, result1.getDstOffsetMillis());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocalTimeInformation result1 = new LocalTimeInformation(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocalTimeInformation result2 = LocalTimeInformation.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeZone(), result1.getTimeZone());
        assertEquals(result2.isTimeZoneNotKnown(), result1.isTimeZoneNotKnown());
        assertEquals(result2.getTimeZoneOffsetMin(), result1.getTimeZoneOffsetMin());
        assertEquals(result2.getTimeZoneOffsetMillis(), result1.getTimeZoneOffsetMillis());
        assertEquals(result2.getDstOffset(), result1.getDstOffset());
        assertEquals(result2.isDstOffsetStandardTime(), result1.isDstOffsetStandardTime());
        assertEquals(result2.isDstOffsetHalfAnHourDaylightTime(), result1.isDstOffsetHalfAnHourDaylightTime());
        assertEquals(result2.isDstOffsetDaylightTime(), result1.isDstOffsetDaylightTime());
        assertEquals(result2.isDstOffsetDoubleDaylightTime(), result1.isDstOffsetDoubleDaylightTime());
        assertEquals(result2.isDstNotKnown(), result1.isDstNotKnown());
        assertEquals(result2.getDstOffsetMin(), result1.getDstOffsetMin());
        assertEquals(result2.getDstOffsetMillis(), result1.getDstOffsetMillis());
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

        LocalTimeInformation result1 = new LocalTimeInformation(bluetoothGattCharacteristic);
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

        LocalTimeInformation result1 = new LocalTimeInformation(bluetoothGattCharacteristic);
        LocalTimeInformation result2 = LocalTimeInformation.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
