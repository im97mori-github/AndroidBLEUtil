package org.im97mori.ble.characteristic.u2aaf;

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
public class LongitudeAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        LongitudeAndroid result1 = new LongitudeAndroid(data);
        assertEquals(0x04030201, result1.getLongitude());
    }

    @Test
    public void test_constructor_00002() {
        int longitude = 1;

        LongitudeAndroid result1 = new LongitudeAndroid(longitude);
        assertEquals(longitude, result1.getLongitude());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        LongitudeAndroid result1 = new LongitudeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LongitudeAndroid result2 = LongitudeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLongitude(), result2.getLongitude());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        LongitudeAndroid result1 = new LongitudeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        LongitudeAndroid result1 = new LongitudeAndroid(data);
        LongitudeAndroid result2 = LongitudeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
