package org.im97mori.ble.characteristic.u2b14;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TimeHour24AndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        TimeHour24Android result = new TimeHour24Android(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getTimeHour24());
        assertTrue(result.isTimeHour24ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_MINIMUM;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MINIMUM >> 16);
        //@formatter:on

        TimeHour24Android result = new TimeHour24Android(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getTimeHour24());
        assertFalse(result.isTimeHour24ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM >> 16);
        //@formatter:on

        TimeHour24Android result = new TimeHour24Android(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getTimeHour24());
        assertFalse(result.isTimeHour24ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00101() {
        int timeHour24 = TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN;

        TimeHour24Android result = new TimeHour24Android(timeHour24);
        assertEquals(timeHour24, result.getTimeHour24());
        assertTrue(result.isTimeHour24ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int timeHour24 = TimeHour24.TIME_HOUR_24_VALUE_MINIMUM;

        TimeHour24Android result = new TimeHour24Android(timeHour24);
        assertEquals(timeHour24, result.getTimeHour24());
        assertFalse(result.isTimeHour24ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00103() {
        int timeHour24 = TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM;

        TimeHour24Android result = new TimeHour24Android(timeHour24);
        assertEquals(timeHour24, result.getTimeHour24());
        assertFalse(result.isTimeHour24ValueIsNotKnown());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeHour24Android result2 = TimeHour24Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeHour24(), result1.getTimeHour24());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_MINIMUM;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MINIMUM >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeHour24Android result2 = TimeHour24Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeHour24(), result1.getTimeHour24());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeHour24Android result2 = TimeHour24Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeHour24(), result1.getTimeHour24());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_MINIMUM;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MINIMUM >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        TimeHour24Android result2 = TimeHour24Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_MINIMUM;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MINIMUM >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        TimeHour24Android result2 = TimeHour24Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM;
        data[ 1] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (TimeHour24.TIME_HOUR_24_VALUE_MAXIMUM >> 16);
        //@formatter:on

        TimeHour24Android result1 = new TimeHour24Android(data);
        TimeHour24Android result2 = TimeHour24Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
