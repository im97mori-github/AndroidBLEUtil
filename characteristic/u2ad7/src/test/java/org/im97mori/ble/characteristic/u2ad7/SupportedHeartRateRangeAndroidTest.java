package org.im97mori.ble.characteristic.u2ad7;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class SupportedHeartRateRangeAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(data);
        assertEquals(0x01, result1.getMinimumHeartRate());
        assertEquals(0x02, result1.getMaximumHeartRate());
        assertEquals(0x03, result1.getMinimumIncrement());
    }

    @Test
    public void test_constructor_00002() {
        int minimumHeartRate = 1;
        int maximumHeartRate = 2;
        int minimumIncrement = 3;

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(minimumHeartRate, maximumHeartRate, minimumIncrement);
        assertEquals(minimumHeartRate, result1.getMinimumHeartRate());
        assertEquals(maximumHeartRate, result1.getMaximumHeartRate());
        assertEquals(minimumIncrement, result1.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedHeartRateRangeAndroid result2 = SupportedHeartRateRangeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMinimumHeartRate(), result2.getMinimumHeartRate());
        assertEquals(result1.getMaximumHeartRate(), result2.getMaximumHeartRate());
        assertEquals(result1.getMinimumIncrement(), result2.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(data);
        SupportedHeartRateRangeAndroid result2 = SupportedHeartRateRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
