package org.im97mori.ble.characteristic.u2ae7;

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

@SuppressWarnings("NewClassNamingConvention")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class Cie13_3_1995ColorRenderingIndexAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;
        //@formatter:on

        Cie13_3_1995ColorRenderingIndexAndroid result = new Cie13_3_1995ColorRenderingIndexAndroid(data);
        assertEquals(BLEUtils.createSInt8(data, 0), result.getColorRenderingIndex());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;
        //@formatter:on

        Cie13_3_1995ColorRenderingIndexAndroid result = new Cie13_3_1995ColorRenderingIndexAndroid(data);
        assertEquals(BLEUtils.createSInt8(data, 0), result.getColorRenderingIndex());
    }

    @Test
    public void test_constructor_00101() {
        int colorRenderingIndex = Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;

        Cie13_3_1995ColorRenderingIndexAndroid result = new Cie13_3_1995ColorRenderingIndexAndroid(colorRenderingIndex);
        assertEquals(colorRenderingIndex, result.getColorRenderingIndex());
    }

    @Test
    public void test_constructor_00102() {
        int colorRenderingIndex = Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;

        Cie13_3_1995ColorRenderingIndexAndroid result = new Cie13_3_1995ColorRenderingIndexAndroid(colorRenderingIndex);
        assertEquals(colorRenderingIndex, result.getColorRenderingIndex());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;
        //@formatter:on

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Cie13_3_1995ColorRenderingIndexAndroid result2 = Cie13_3_1995ColorRenderingIndexAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getColorRenderingIndex(), result1.getColorRenderingIndex());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;
        //@formatter:on

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Cie13_3_1995ColorRenderingIndexAndroid result2 = Cie13_3_1995ColorRenderingIndexAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getColorRenderingIndex(), result1.getColorRenderingIndex());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;
        //@formatter:on

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;
        //@formatter:on

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;
        //@formatter:on

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(data);
        Cie13_3_1995ColorRenderingIndexAndroid result2 = Cie13_3_1995ColorRenderingIndexAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;
        //@formatter:on

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(data);
        Cie13_3_1995ColorRenderingIndexAndroid result2 = Cie13_3_1995ColorRenderingIndexAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
