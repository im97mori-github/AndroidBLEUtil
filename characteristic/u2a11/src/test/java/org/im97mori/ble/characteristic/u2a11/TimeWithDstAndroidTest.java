package org.im97mori.ble.characteristic.u2a11;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.im97mori.ble.characteristic.core.DstOffsetUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TimeWithDstAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) DateTimeUtils.YEAR_IS_NOT_KNOWN;
        data[ 1] = (byte) (DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8);
        data[ 2] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 3] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = DstOffsetUtils.DST_OFFSET_STANDARD_TIME;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(DateTimeUtils.YEAR_IS_NOT_KNOWN, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_IS_NOT_KNOWN, result1.getMonth());
        assertEquals(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN, result1.getDay());
        assertEquals(0x00, result1.getHours());
        assertEquals(0x00, result1.getMinutes());
        assertEquals(0x00, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_STANDARD_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 1582;
        data[ 1] = (byte) (1582 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JANUARY;
        data[ 3] = 1;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(1582, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JANUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_MARCH;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_APRIL;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_MAY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JUNE;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JULY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_AUGUST;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor010() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor011() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_OCTOBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor012() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor013() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor014() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor015() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor016() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        data[ 7] = (byte) DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
        assertEquals(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, result1.getDstOffset());
    }

    @Test
    public void test_constructor017() {
        int year = 1;
        int month = 2;
        int day = 3;
        int hours = 4;
        int minutes = 5;
        int seconds = 6;
        int dstOffset = 7;

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(year, month, day, hours, minutes, seconds, dstOffset);
        assertEquals(year, result1.getYear());
        assertEquals(month, result1.getMonth());
        assertEquals(day, result1.getDay());
        assertEquals(hours, result1.getHours());
        assertEquals(minutes, result1.getMinutes());
        assertEquals(seconds, result1.getSeconds());
        assertEquals(dstOffset, result1.getDstOffset());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeWithDstAndroid result2 = TimeWithDstAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getYear(), result1.getYear());
        assertEquals(result2.getMonth(), result1.getMonth());
        assertEquals(result2.getDay(), result1.getDay());
        assertEquals(result2.getHours(), result1.getHours());
        assertEquals(result2.getMinutes(), result1.getMinutes());
        assertEquals(result2.getSeconds(), result1.getSeconds());
        assertEquals(result2.getDstOffset(), result1.getDstOffset());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        TimeWithDstAndroid result1 = new TimeWithDstAndroid(data);
        TimeWithDstAndroid result2 = TimeWithDstAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
