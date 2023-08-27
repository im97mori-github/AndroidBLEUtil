package org.im97mori.ble.characteristic.u2a7a;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class HeatIndexAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        HeatIndexAndroid result1 = new HeatIndexAndroid(data);
        assertEquals(0x01, result1.getHeatIndex());
    }

    @Test
    public void test_constructor_00002() {
        int heatIndex = 1;

        HeatIndexAndroid result1 = new HeatIndexAndroid(heatIndex);
        assertEquals(heatIndex, result1.getHeatIndex());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        HeatIndexAndroid result1 = new HeatIndexAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeatIndexAndroid result2 = HeatIndexAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHeatIndex(), result2.getHeatIndex());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        HeatIndexAndroid result1 = new HeatIndexAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        HeatIndexAndroid result1 = new HeatIndexAndroid(data);
        HeatIndexAndroid result2 = HeatIndexAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
