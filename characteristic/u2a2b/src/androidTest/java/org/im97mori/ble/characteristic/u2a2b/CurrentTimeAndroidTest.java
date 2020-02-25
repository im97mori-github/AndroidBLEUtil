package org.im97mori.ble.characteristic.u2a2b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CurrentTimeAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) DateTimeUtils.YEAR_IS_NOT_KNOWN;
        data[ 1] = (byte) (DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8);
        data[ 2] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 3] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = CurrentTime.DAY_OF_WEEK_IS_NOT_KNOWN;
        data[ 8] = CurrentTime.FRACTIONS_256_NOT_SUPPORTED;
        data[ 9] = CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(DateTimeUtils.YEAR_IS_NOT_KNOWN, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_IS_NOT_KNOWN, result1.getMonth());
        assertEquals(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN, result1.getDay());
        assertEquals(0x00, result1.getHours());
        assertEquals(0x00, result1.getMinutes());
        assertEquals(0x00, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_IS_NOT_KNOWN, result1.getDayOfWeek());
        assertTrue(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertFalse(result1.isDayOfWeekSunday());
        assertEquals(CurrentTime.FRACTIONS_256_NOT_SUPPORTED, result1.getFractions256());
        assertTrue(result1.isFractions256Supported());
        assertEquals(0d, result1.getFractions256WithUnit(), 0);
        assertEquals(0L, result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertTrue(result1.isAdjustReasonNoManualTimeUpdate());
        assertFalse(result1.isAdjustReasonManualTimeUpdate());
        assertTrue(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonNoChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonNoChangeOfDst());
        assertFalse(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 1582;
        data[ 1] = (byte) (1582 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JANUARY;
        data[ 3] = 1;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_MONDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(1582, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JANUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_MONDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertTrue(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertFalse(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertFalse(result1.isAdjustReasonNoManualTimeUpdate());
        assertTrue(result1.isAdjustReasonManualTimeUpdate());
        assertTrue(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonNoChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonNoChangeOfDst());
        assertFalse(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_TUESDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_TUESDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertTrue(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertFalse(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertTrue(result1.isAdjustReasonNoManualTimeUpdate());
        assertFalse(result1.isAdjustReasonManualTimeUpdate());
        assertFalse(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonNoChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonNoChangeOfDst());
        assertFalse(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_MARCH;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_WEDNESDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_WEDNESDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertTrue(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertFalse(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertFalse(result1.isAdjustReasonNoManualTimeUpdate());
        assertTrue(result1.isAdjustReasonManualTimeUpdate());
        assertFalse(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonNoChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonNoChangeOfDst());
        assertFalse(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_APRIL;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_THURSDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_THURSDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertTrue(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertFalse(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertTrue(result1.isAdjustReasonNoManualTimeUpdate());
        assertFalse(result1.isAdjustReasonManualTimeUpdate());
        assertTrue(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonNoChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonNoChangeOfDst());
        assertFalse(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_MAY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_FRIDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_FRIDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertTrue(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertFalse(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertFalse(result1.isAdjustReasonNoManualTimeUpdate());
        assertTrue(result1.isAdjustReasonManualTimeUpdate());
        assertTrue(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonNoChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonNoChangeOfDst());
        assertFalse(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JUNE;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SATURDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SATURDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertTrue(result1.isDayOfWeekSaturday());
        assertFalse(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertTrue(result1.isAdjustReasonNoManualTimeUpdate());
        assertFalse(result1.isAdjustReasonManualTimeUpdate());
        assertFalse(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonNoChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonNoChangeOfDst());
        assertFalse(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JULY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertFalse(result1.isAdjustReasonNoManualTimeUpdate());
        assertTrue(result1.isAdjustReasonManualTimeUpdate());
        assertFalse(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonNoChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonNoChangeOfDst());
        assertFalse(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_AUGUST;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertTrue(result1.isAdjustReasonNoManualTimeUpdate());
        assertFalse(result1.isAdjustReasonManualTimeUpdate());
        assertTrue(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonNoChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonNoChangeOfDst());
        assertTrue(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor010() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertFalse(result1.isAdjustReasonNoManualTimeUpdate());
        assertTrue(result1.isAdjustReasonManualTimeUpdate());
        assertTrue(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonNoChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonNoChangeOfDst());
        assertTrue(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor011() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_OCTOBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertTrue(result1.isAdjustReasonNoManualTimeUpdate());
        assertFalse(result1.isAdjustReasonManualTimeUpdate());
        assertFalse(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonNoChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonNoChangeOfDst());
        assertTrue(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor012() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertFalse(result1.isAdjustReasonNoManualTimeUpdate());
        assertTrue(result1.isAdjustReasonManualTimeUpdate());
        assertFalse(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonNoChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonNoChangeOfDst());
        assertTrue(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor013() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertTrue(result1.isAdjustReasonNoManualTimeUpdate());
        assertFalse(result1.isAdjustReasonManualTimeUpdate());
        assertTrue(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonNoChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonNoChangeOfDst());
        assertTrue(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor014() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertFalse(result1.isAdjustReasonNoManualTimeUpdate());
        assertTrue(result1.isAdjustReasonManualTimeUpdate());
        assertTrue(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonNoChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonNoChangeOfDst());
        assertTrue(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor015() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_NO_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertTrue(result1.isAdjustReasonNoManualTimeUpdate());
        assertFalse(result1.isAdjustReasonManualTimeUpdate());
        assertFalse(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonNoChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonNoChangeOfDst());
        assertTrue(result1.isAdjustReasonChangeOfDst());
    }

    @Test
    public void test_constructor016() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = CurrentTime.DAY_OF_WEEK_SUNDAY;
        data[ 8] = (byte) 255;
        data[ 9] = CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                | CurrentTime.ADJUST_REASON_CHANGE_OF_DST;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(CurrentTime.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
        assertFalse(result1.isDayOfWeekNotKnown());
        assertFalse(result1.isDayOfWeekMonday());
        assertFalse(result1.isDayOfWeekTuesday());
        assertFalse(result1.isDayOfWeekWednesday());
        assertFalse(result1.isDayOfWeekThursday());
        assertFalse(result1.isDayOfWeekFriday());
        assertFalse(result1.isDayOfWeekSaturday());
        assertTrue(result1.isDayOfWeekSunday());
        assertEquals(255, result1.getFractions256());
        assertFalse(result1.isFractions256Supported());
        assertEquals(CurrentTime.FRACTIONS_256_UNIT * 255, result1.getFractions256WithUnit(), 0);
        assertEquals((long) (CurrentTime.FRACTIONS_256_UNIT * 255 * 1000L), result1.getFractions256Millis());
        assertEquals(CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_TIME_ZONE
                        | CurrentTime.ADJUST_REASON_CHANGE_OF_DST
                , result1.getAdjustReason());
        assertFalse(result1.isAdjustReasonNoManualTimeUpdate());
        assertTrue(result1.isAdjustReasonManualTimeUpdate());
        assertFalse(result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertTrue(result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertFalse(result1.isAdjustReasonNoChangeOfTimeZone());
        assertTrue(result1.isAdjustReasonChangeOfTimeZone());
        assertFalse(result1.isAdjustReasonNoChangeOfDst());
        assertTrue(result1.isAdjustReasonChangeOfDst());
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

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CurrentTimeAndroid result2 = CurrentTimeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getYear(), result1.getYear());
        assertEquals(result2.getMonth(), result1.getMonth());
        assertEquals(result2.getDay(), result1.getDay());
        assertEquals(result2.getHours(), result1.getHours());
        assertEquals(result2.getMinutes(), result1.getMinutes());
        assertEquals(result2.getSeconds(), result1.getSeconds());
        assertEquals(result2.getDayOfWeek(), result1.getDayOfWeek());
        assertEquals(result2.isDayOfWeekNotKnown(), result1.isDayOfWeekNotKnown());
        assertEquals(result2.isDayOfWeekMonday(), result1.isDayOfWeekMonday());
        assertEquals(result2.isDayOfWeekTuesday(), result1.isDayOfWeekTuesday());
        assertEquals(result2.isDayOfWeekWednesday(), result1.isDayOfWeekWednesday());
        assertEquals(result2.isDayOfWeekThursday(), result1.isDayOfWeekThursday());
        assertEquals(result2.isDayOfWeekFriday(), result1.isDayOfWeekFriday());
        assertEquals(result2.isDayOfWeekSaturday(), result1.isDayOfWeekSaturday());
        assertEquals(result2.isDayOfWeekSunday(), result1.isDayOfWeekSunday());
        assertEquals(result2.getFractions256(), result1.getFractions256());
        assertEquals(result2.isFractions256Supported(), result1.isFractions256Supported());
        assertEquals(result2.getFractions256WithUnit(), result1.getFractions256WithUnit(), 0);
        assertEquals(result2.getFractions256Millis(), result1.getFractions256Millis());
        assertEquals(result2.getAdjustReason(), result1.getAdjustReason());
        assertEquals(result2.isAdjustReasonNoManualTimeUpdate(), result1.isAdjustReasonNoManualTimeUpdate());
        assertEquals(result2.isAdjustReasonManualTimeUpdate(), result1.isAdjustReasonManualTimeUpdate());
        assertEquals(result2.isAdjustReasonNoExternalReferenceTimeUpdate(), result1.isAdjustReasonNoExternalReferenceTimeUpdate());
        assertEquals(result2.isAdjustReasonExternalReferenceTimeUpdate(), result1.isAdjustReasonExternalReferenceTimeUpdate());
        assertEquals(result2.isAdjustReasonNoChangeOfTimeZone(), result1.isAdjustReasonNoChangeOfTimeZone());
        assertEquals(result2.isAdjustReasonChangeOfTimeZone(), result1.isAdjustReasonChangeOfTimeZone());
        assertEquals(result2.isAdjustReasonNoChangeOfDst(), result1.isAdjustReasonNoChangeOfDst());
        assertEquals(result2.isAdjustReasonChangeOfDst(), result1.isAdjustReasonChangeOfDst());
    }


    @Test
    public void test_parcelable002() {
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

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
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

        CurrentTimeAndroid result1 = new CurrentTimeAndroid(bluetoothGattCharacteristic);
        CurrentTimeAndroid result2 = CurrentTimeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
