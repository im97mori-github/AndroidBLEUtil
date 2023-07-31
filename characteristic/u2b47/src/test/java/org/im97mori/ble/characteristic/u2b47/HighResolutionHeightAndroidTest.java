package org.im97mori.ble.characteristic.u2b47;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
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
public class HighResolutionHeightAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        HighResolutionHeightAndroid result1 = new HighResolutionHeightAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getHeight());
        assertEquals(BLEUtils.createUInt16(data, 0) * HighResolutionHeight.HEIGHT_RESOLUTION, result1.getHeightMeter(),
                0);
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        HighResolutionHeightAndroid result1 = new HighResolutionHeightAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighResolutionHeightAndroid result2 = HighResolutionHeightAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHeight(), result2.getHeight());
    }

    @Test
    public void test_constructor_00101() {
        int height = 1;

        HighResolutionHeightAndroid result1 = new HighResolutionHeightAndroid(height);
        assertEquals(height, result1.getHeight());
        assertEquals(height * HighResolutionHeight.HEIGHT_RESOLUTION, result1.getHeightMeter(), 0);
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        HighResolutionHeightAndroid result1 = new HighResolutionHeightAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        HighResolutionHeightAndroid result1 = new HighResolutionHeightAndroid(data);
        HighResolutionHeightAndroid result2 = HighResolutionHeightAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
