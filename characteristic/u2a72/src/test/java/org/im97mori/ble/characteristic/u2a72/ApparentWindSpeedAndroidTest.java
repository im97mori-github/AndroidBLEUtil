package org.im97mori.ble.characteristic.u2a72;

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
public class ApparentWindSpeedAndroidTest extends TestBase {

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

        ApparentWindSpeedAndroid result1 = new ApparentWindSpeedAndroid(data);
        assertEquals(0x0201, result1.getApparentWindSpeed());
        assertEquals(ApparentWindSpeed.APPARENT_WIND_SPEED_RESOLUTION * 0x0201, result1.getApparentWindSpeedMetersPerSecond(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int apparentWindSpeed = 1;

        ApparentWindSpeedAndroid result1 = new ApparentWindSpeedAndroid(apparentWindSpeed);
        assertEquals(apparentWindSpeed, result1.getApparentWindSpeed());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ApparentWindSpeedAndroid result1 = new ApparentWindSpeedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ApparentWindSpeedAndroid result2 = ApparentWindSpeedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getApparentWindSpeed(), result2.getApparentWindSpeed());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ApparentWindSpeedAndroid result1 = new ApparentWindSpeedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ApparentWindSpeedAndroid result1 = new ApparentWindSpeedAndroid(data);
        ApparentWindSpeedAndroid result2 = ApparentWindSpeedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
