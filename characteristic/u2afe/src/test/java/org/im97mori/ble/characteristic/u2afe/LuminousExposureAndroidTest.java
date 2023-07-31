package org.im97mori.ble.characteristic.u2afe;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class LuminousExposureAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        LuminousExposureAndroid result = new LuminousExposureAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousExposure());
        assertTrue(result.isLuminousExposureValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 16);
        //@formatter:on

        LuminousExposureAndroid result = new LuminousExposureAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(BLEUtils.createUInt24(data, 0) * LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 16);
        //@formatter:on

        LuminousExposureAndroid result = new LuminousExposureAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(BLEUtils.createUInt24(data, 0) * LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 1;
        data[ 1] = (byte) (1 >> 8);
        data[ 2] = (byte) (1 >> 16);
        //@formatter:on

        LuminousExposureAndroid result = new LuminousExposureAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(BLEUtils.createUInt24(data, 0) * LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777213;
        data[ 1] = (byte) (16777213 >> 8);
        data[ 2] = (byte) (16777213 >> 16);
        //@formatter:on

        LuminousExposureAndroid result = new LuminousExposureAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(BLEUtils.createUInt24(data, 0) * LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00101() {
        int luminousExposure = LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN;

        LuminousExposureAndroid result = new LuminousExposureAndroid(luminousExposure);
        assertEquals(luminousExposure, result.getLuminousExposure());
        assertTrue(result.isLuminousExposureValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int luminousExposure = (int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);

        LuminousExposureAndroid result = new LuminousExposureAndroid(luminousExposure);
        assertEquals(luminousExposure, result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(luminousExposure * LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00103() {
        int luminousExposure = (int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);

        LuminousExposureAndroid result = new LuminousExposureAndroid(luminousExposure);
        assertEquals(luminousExposure, result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(luminousExposure * LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00104() {
        int luminousExposure = 16777216;

        LuminousExposureAndroid result = new LuminousExposureAndroid(luminousExposure);
        assertEquals(luminousExposure, result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00105() {
        int luminousExposure = 1;

        LuminousExposureAndroid result = new LuminousExposureAndroid(luminousExposure);
        assertEquals(luminousExposure, result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(luminousExposure * LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00106() {
        int luminousExposure = 16777213;

        LuminousExposureAndroid result = new LuminousExposureAndroid(luminousExposure);
        assertEquals(luminousExposure, result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(luminousExposure * LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_constructor_00107() {
        int luminousExposure = -1;

        LuminousExposureAndroid result = new LuminousExposureAndroid(luminousExposure);
        assertEquals(luminousExposure, result.getLuminousExposure());
        assertFalse(result.isLuminousExposureValueIsNotKnown());
        assertEquals(LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM, result.getLuminousExposureLumenHour(), 0);
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousExposure(), result1.getLuminousExposure());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousExposure(), result1.getLuminousExposure());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousExposure(), result1.getLuminousExposure());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 1;
        data[ 1] = (byte) (1 >> 8);
        data[ 2] = (byte) (1 >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousExposure(), result1.getLuminousExposure());
    }

    @Test
    public void test_parcelable_00005() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777213;
        data[ 1] = (byte) (16777213 >> 8);
        data[ 2] = (byte) (16777213 >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousExposure(), result1.getLuminousExposure());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 1;
        data[ 1] = (byte) (1 >> 8);
        data[ 2] = (byte) (1 >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00105() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777213;
        data[ 1] = (byte) (16777213 >> 8);
        data[ 2] = (byte) (16777213 >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MINIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousExposure.LUMINOUS_EXPOSURE_VALUE_MAXIMUM / LuminousExposure.LUMINOUS_EXPOSURE_VALUE_UNIT)) >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 1;
        data[ 1] = (byte) (1 >> 8);
        data[ 2] = (byte) (1 >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00205() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777213;
        data[ 1] = (byte) (16777213 >> 8);
        data[ 2] = (byte) (16777213 >> 16);
        //@formatter:on

        LuminousExposureAndroid result1 = new LuminousExposureAndroid(data);
        LuminousExposureAndroid result2 = LuminousExposureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
