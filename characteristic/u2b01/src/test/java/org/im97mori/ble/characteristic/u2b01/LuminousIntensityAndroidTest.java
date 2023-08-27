package org.im97mori.ble.characteristic.u2b01;

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
public class LuminousIntensityAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        LuminousIntensityAndroid result = new LuminousIntensityAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getLuminousIntensity());
        assertTrue(result.isLuminousFluxValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM >> 8);
        //@formatter:on

        LuminousIntensityAndroid result = new LuminousIntensityAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getLuminousIntensity());
        assertFalse(result.isLuminousFluxValueIsNotKnown());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM >> 8);
        //@formatter:on

        LuminousIntensityAndroid result = new LuminousIntensityAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getLuminousIntensity());
        assertFalse(result.isLuminousFluxValueIsNotKnown());
    }

    @Test
    public void test_constructor_00101() {
        int luminousIntensity = LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN;

        LuminousIntensityAndroid result = new LuminousIntensityAndroid(luminousIntensity);
        assertEquals(luminousIntensity, result.getLuminousIntensity());
        assertTrue(result.isLuminousFluxValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int luminousIntensity = LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM;

        LuminousIntensityAndroid result = new LuminousIntensityAndroid(luminousIntensity);
        assertEquals(luminousIntensity, result.getLuminousIntensity());
        assertFalse(result.isLuminousFluxValueIsNotKnown());
    }

    @Test
    public void test_constructor_00103() {
        int luminousIntensity = LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM;

        LuminousIntensityAndroid result = new LuminousIntensityAndroid(luminousIntensity);
        assertEquals(luminousIntensity, result.getLuminousIntensity());
        assertFalse(result.isLuminousFluxValueIsNotKnown());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousIntensityAndroid result2 = LuminousIntensityAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousIntensity(), result1.getLuminousIntensity());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousIntensityAndroid result2 = LuminousIntensityAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousIntensity(), result1.getLuminousIntensity());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousIntensityAndroid result2 = LuminousIntensityAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousIntensity(), result1.getLuminousIntensity());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        LuminousIntensityAndroid result2 = LuminousIntensityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MINIMUM >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        LuminousIntensityAndroid result2 = LuminousIntensityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM;
        data[ 1] = (byte) (LuminousIntensity.LUMINOUS_INTENSITY_VALUE_MAXIMUM >> 8);
        //@formatter:on

        LuminousIntensityAndroid result1 = new LuminousIntensityAndroid(data);
        LuminousIntensityAndroid result2 = LuminousIntensityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
