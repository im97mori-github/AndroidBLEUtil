package org.im97mori.ble.characteristic.u2ac2;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
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
public class ObjectLastModifiedAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) DateTimeUtils.YEAR_IS_NOT_KNOWN;
        data[ 1] = (byte) (DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8);
        data[ 2] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 3] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(DateTimeUtils.YEAR_IS_NOT_KNOWN, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_IS_NOT_KNOWN, result1.getMonth());
        assertEquals(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN, result1.getDay());
        assertEquals(0x00, result1.getHours());
        assertEquals(0x00, result1.getMinutes());
        assertEquals(0x00, result1.getSeconds());

    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 1582;
        data[ 1] = (byte) (1582 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JANUARY;
        data[ 3] = 1;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(1582, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JANUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_MARCH;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_APRIL;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00006() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_MAY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00007() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JUNE;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00008() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JULY;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00009() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_AUGUST;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00010() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00011() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_OCTOBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00012() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00013() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00014() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00015() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00016() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        data[ 4] = 23;
        data[ 5] = 59;
        data[ 6] = 59;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());

    }

    @Test
    public void test_constructor_00017() {
        int year = 1;
        int month = 2;
        int day = 3;
        int hours = 4;
        int minutes = 5;
        int seconds = 6;

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(year, month, day, hours, minutes, seconds);
        assertEquals(year, result1.getYear());
        assertEquals(month, result1.getMonth());
        assertEquals(day, result1.getDay());
        assertEquals(hours, result1.getHours());
        assertEquals(minutes, result1.getMinutes());
        assertEquals(seconds, result1.getSeconds());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectLastModifiedAndroid result2 = ObjectLastModifiedAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getYear(), result1.getYear());
        assertEquals(result2.getMonth(), result1.getMonth());
        assertEquals(result2.getDay(), result1.getDay());
        assertEquals(result2.getHours(), result1.getHours());
        assertEquals(result2.getMinutes(), result1.getMinutes());
        assertEquals(result2.getSeconds(), result1.getSeconds());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        //@formatter:on

        ObjectLastModifiedAndroid result1 = new ObjectLastModifiedAndroid(data);
        ObjectLastModifiedAndroid result2 = ObjectLastModifiedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
