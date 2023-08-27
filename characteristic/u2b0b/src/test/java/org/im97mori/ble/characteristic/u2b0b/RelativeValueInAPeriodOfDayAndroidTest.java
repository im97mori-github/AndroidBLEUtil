package org.im97mori.ble.characteristic.u2b0b;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.Percentage8Utils;
import org.im97mori.ble.characteristic.core.TimeDecihour8Utils;
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
public class RelativeValueInAPeriodOfDayAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result = new RelativeValueInAPeriodOfDayAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getEndTime());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result = new RelativeValueInAPeriodOfDayAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getEndTime());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) 240;
        data[ 2] = (byte) 240;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result = new RelativeValueInAPeriodOfDayAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getEndTime());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result = new RelativeValueInAPeriodOfDayAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getEndTime());
    }

    @Test
    public void test_constructor_00101() {
        int relativeValue = Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        int startTime = TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        int endTime = TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;

        RelativeValueInAPeriodOfDayAndroid result = new RelativeValueInAPeriodOfDayAndroid(relativeValue, startTime, endTime);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00102() {
        int relativeValue = 0;
        int startTime = 0;
        int endTime = 0;

        RelativeValueInAPeriodOfDayAndroid result = new RelativeValueInAPeriodOfDayAndroid(relativeValue, startTime, endTime);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00103() {
        int relativeValue = 200;
        int startTime = 240;
        int endTime = 240;

        RelativeValueInAPeriodOfDayAndroid result = new RelativeValueInAPeriodOfDayAndroid(relativeValue, startTime, endTime);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00104() {
        int relativeValue = 1;
        int startTime = 2;
        int endTime = 3;

        RelativeValueInAPeriodOfDayAndroid result = new RelativeValueInAPeriodOfDayAndroid(relativeValue, startTime, endTime);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInAPeriodOfDayAndroid result2 = RelativeValueInAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInAPeriodOfDayAndroid result2 = RelativeValueInAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) 240;
        data[ 2] = (byte) 240;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInAPeriodOfDayAndroid result2 = RelativeValueInAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInAPeriodOfDayAndroid result2 = RelativeValueInAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) 240;
        data[ 2] = (byte) 240;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        RelativeValueInAPeriodOfDayAndroid result2 = RelativeValueInAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        RelativeValueInAPeriodOfDayAndroid result2 = RelativeValueInAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) 240;
        data[ 2] = (byte) 240;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        RelativeValueInAPeriodOfDayAndroid result2 = RelativeValueInAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        RelativeValueInAPeriodOfDayAndroid result1 = new RelativeValueInAPeriodOfDayAndroid(data);
        RelativeValueInAPeriodOfDayAndroid result2 = RelativeValueInAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
