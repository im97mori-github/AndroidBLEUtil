package org.im97mori.ble.characteristic.u2bd9;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class SulfurHexafluorideConcentrationAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        //noinspection DataFlowIssue
        data[ 0] = (byte) BLEUtils.SFLOAT_NRES;
        data[ 1] = (byte) (BLEUtils.SFLOAT_NRES >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[2];
        data[ 0] = (byte) BLEUtils.SFLOAT_NAN;
        data[ 1] = (byte) (BLEUtils.SFLOAT_NAN >> 8);
        data_00003 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        assertEquals(BLEUtils.createSfloat(data, 0), result1.getSulfurHexafluorideConcentration().getSfloat(), 0);
        assertFalse(result1.isNres());
        assertFalse(result1.isNan());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        assertTrue(result1.isNres());
        assertFalse(result1.isNan());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        assertFalse(result1.isNres());
        assertTrue(result1.isNan());
    }

    @Test
    public void test_constructor_00101() {
        double sulfurHexafluorideConcentration = 1d;
        IEEE_11073_20601_SFLOAT sfloat = new IEEE_11073_20601_SFLOAT(sulfurHexafluorideConcentration);

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(sfloat);
        assertEquals(sulfurHexafluorideConcentration, result1.getSulfurHexafluorideConcentration().getSfloat(), 0);
        assertFalse(result1.isNres());
        assertFalse(result1.isNan());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SulfurHexafluorideConcentrationAndroid result2 = SulfurHexafluorideConcentrationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSulfurHexafluorideConcentration().getSfloat(), result2.getSulfurHexafluorideConcentration().getSfloat(), 0);
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SulfurHexafluorideConcentrationAndroid result2 = SulfurHexafluorideConcentrationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSulfurHexafluorideConcentration().getSfloat(), result2.getSulfurHexafluorideConcentration().getSfloat(), 0);
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SulfurHexafluorideConcentrationAndroid result2 = SulfurHexafluorideConcentrationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSulfurHexafluorideConcentration().getSfloat(), result2.getSulfurHexafluorideConcentration().getSfloat(), 0);
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        SulfurHexafluorideConcentrationAndroid result2 = SulfurHexafluorideConcentrationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        SulfurHexafluorideConcentrationAndroid result2 = SulfurHexafluorideConcentrationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        SulfurHexafluorideConcentrationAndroid result1 = new SulfurHexafluorideConcentrationAndroid(data);
        SulfurHexafluorideConcentrationAndroid result2 = SulfurHexafluorideConcentrationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
