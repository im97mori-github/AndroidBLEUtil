package org.im97mori.ble.characteristic.u2b16;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.TimeSecond16Utils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TimeSecond16AndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        TimeSecond16Android result = new TimeSecond16Android(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getTimeSecond16());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM >> 8);
        //@formatter:on

        TimeSecond16Android result = new TimeSecond16Android(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getTimeSecond16());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM >> 8);
        //@formatter:on

        TimeSecond16Android result = new TimeSecond16Android(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getTimeSecond16());
    }

    @Test
    public void test_constructor_00101() {
        int timeSecond16 = TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;

        TimeSecond16Android result = new TimeSecond16Android(timeSecond16);
        assertEquals(timeSecond16, result.getTimeSecond16());
    }

    @Test
    public void test_constructor_00102() {
        int timeSecond16 = TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;

        TimeSecond16Android result = new TimeSecond16Android(timeSecond16);
        assertEquals(timeSecond16, result.getTimeSecond16());
    }

    @Test
    public void test_constructor_00103() {
        int timeSecond16 = TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;

        TimeSecond16Android result = new TimeSecond16Android(timeSecond16);
        assertEquals(timeSecond16, result.getTimeSecond16());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeSecond16Android result2 = TimeSecond16Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeSecond16(), result1.getTimeSecond16());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeSecond16Android result2 = TimeSecond16Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeSecond16(), result1.getTimeSecond16());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeSecond16Android result2 = TimeSecond16Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeSecond16(), result1.getTimeSecond16());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        TimeSecond16Android result2 = TimeSecond16Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        TimeSecond16Android result2 = TimeSecond16Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        data[ 1] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM >> 8);
        //@formatter:on

        TimeSecond16Android result1 = new TimeSecond16Android(data);
        TimeSecond16Android result2 = TimeSecond16Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
