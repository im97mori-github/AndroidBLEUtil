package org.im97mori.ble.characteristic.u2b03;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
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
public class PerceivedLightnessAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM;
        data[ 1] = (byte) (PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM >> 8);
        //@formatter:on

        PerceivedLightnessAndroid result = new PerceivedLightnessAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getPerceivedLightness());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM;
        data[ 1] = (byte) (PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM >> 8);
        //@formatter:on

        PerceivedLightnessAndroid result = new PerceivedLightnessAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getPerceivedLightness());
    }

    @Test
    public void test_constructor_00101() {
        int luminousIntensity = PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM;

        PerceivedLightnessAndroid result = new PerceivedLightnessAndroid(luminousIntensity);
        assertEquals(luminousIntensity, result.getPerceivedLightness());
    }

    @Test
    public void test_constructor_00102() {
        int luminousIntensity = PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM;

        PerceivedLightnessAndroid result = new PerceivedLightnessAndroid(luminousIntensity);
        assertEquals(luminousIntensity, result.getPerceivedLightness());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM;
        data[ 1] = (byte) (PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM >> 8);
        //@formatter:on

        PerceivedLightnessAndroid result1 = new PerceivedLightnessAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PerceivedLightnessAndroid result2 = PerceivedLightnessAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getPerceivedLightness(), result1.getPerceivedLightness());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM;
        data[ 1] = (byte) (PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM >> 8);
        //@formatter:on

        PerceivedLightnessAndroid result1 = new PerceivedLightnessAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PerceivedLightnessAndroid result2 = PerceivedLightnessAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getPerceivedLightness(), result1.getPerceivedLightness());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM;
        data[ 1] = (byte) (PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM >> 8);
        //@formatter:on

        PerceivedLightnessAndroid result1 = new PerceivedLightnessAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM;
        data[ 1] = (byte) (PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM >> 8);
        //@formatter:on

        PerceivedLightnessAndroid result1 = new PerceivedLightnessAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM;
        data[ 1] = (byte) (PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MINIMUM >> 8);
        //@formatter:on

        PerceivedLightnessAndroid result1 = new PerceivedLightnessAndroid(data);
        PerceivedLightnessAndroid result2 = PerceivedLightnessAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM;
        data[ 1] = (byte) (PerceivedLightness.PERCEIVED_LIGHTNESS_VALUE_MAXIMUM >> 8);
        //@formatter:on

        PerceivedLightnessAndroid result1 = new PerceivedLightnessAndroid(data);
        PerceivedLightnessAndroid result2 = PerceivedLightnessAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
