package org.im97mori.ble.characteristic.u2ae6;

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

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ChromaticityInCctAndDuvValuesAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        ChromaticityToleranceAndroid result = new ChromaticityToleranceAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getChromaticityTolerance());
        assertEquals(BLEUtils.createUInt8(data, 0) * ChromaticityTolerance.CHROMATICITY_VALUE_UNIT, result.getChromaticityToleranceWithUnit(), 0);
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        ChromaticityToleranceAndroid result = new ChromaticityToleranceAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getChromaticityTolerance());
        assertEquals(BLEUtils.createUInt8(data, 0) * ChromaticityTolerance.CHROMATICITY_VALUE_UNIT, result.getChromaticityToleranceWithUnit(), 0);
    }

    @Test
    public void test_constructor_00101() {
        int chromaticityTolerance = 0;

        ChromaticityToleranceAndroid result = new ChromaticityToleranceAndroid(chromaticityTolerance);
        assertEquals(chromaticityTolerance, result.getChromaticityTolerance());
        assertEquals(chromaticityTolerance * ChromaticityTolerance.CHROMATICITY_VALUE_UNIT, result.getChromaticityToleranceWithUnit(), 0);
    }

    @Test
    public void test_constructor_00102() {
        int chromaticityTolerance = 255;

        ChromaticityToleranceAndroid result = new ChromaticityToleranceAndroid(chromaticityTolerance);
        assertEquals(chromaticityTolerance, result.getChromaticityTolerance());
        assertEquals(chromaticityTolerance * ChromaticityTolerance.CHROMATICITY_VALUE_UNIT, result.getChromaticityToleranceWithUnit(), 0);
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticityToleranceAndroid result2 = ChromaticityToleranceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getChromaticityTolerance(), result1.getChromaticityTolerance());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticityToleranceAndroid result2 = ChromaticityToleranceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getChromaticityTolerance(), result1.getChromaticityTolerance());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(data);
        ChromaticityToleranceAndroid result2 = ChromaticityToleranceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(data);
        ChromaticityToleranceAndroid result2 = ChromaticityToleranceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
