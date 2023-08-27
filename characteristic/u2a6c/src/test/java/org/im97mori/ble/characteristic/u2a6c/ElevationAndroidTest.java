package org.im97mori.ble.characteristic.u2a6c;

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
public class ElevationAndroidTest extends TestBase {

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

        ElevationAndroid result1 = new ElevationAndroid(data);
        assertEquals(0x030201, result1.getElevation());
        assertEquals(Elevation.ELEVATION_RESOLUTION * 0x030201, result1.getElevationMeters(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int elevation = 1;

        ElevationAndroid result1 = new ElevationAndroid(elevation);
        assertEquals(elevation, result1.getElevation());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ElevationAndroid result1 = new ElevationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ElevationAndroid result2 = ElevationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getElevation(), result2.getElevation());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ElevationAndroid result1 = new ElevationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ElevationAndroid result1 = new ElevationAndroid(data);
        ElevationAndroid result2 = ElevationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
