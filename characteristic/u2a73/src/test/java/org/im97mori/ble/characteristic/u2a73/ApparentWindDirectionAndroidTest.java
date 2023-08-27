package org.im97mori.ble.characteristic.u2a73;

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
public class ApparentWindDirectionAndroidTest extends TestBase {

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

        ApparentWindDirectionAndroid result1 = new ApparentWindDirectionAndroid(data);
        assertEquals(0x0201, result1.getApparentWindDirection());
        assertEquals(ApparentWindDirection.APPARENT_WIND_DIRECTION_RESOLUTION * 0x0201, result1.getApparentWindDirectionDegrees(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int apparentWindDirection = 1;

        ApparentWindDirectionAndroid result1 = new ApparentWindDirectionAndroid(apparentWindDirection);
        assertEquals(apparentWindDirection, result1.getApparentWindDirection());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ApparentWindDirectionAndroid result1 = new ApparentWindDirectionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ApparentWindDirectionAndroid result2 = ApparentWindDirectionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getApparentWindDirection(), result2.getApparentWindDirection());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ApparentWindDirectionAndroid result1 = new ApparentWindDirectionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ApparentWindDirectionAndroid result1 = new ApparentWindDirectionAndroid(data);
        ApparentWindDirectionAndroid result2 = ApparentWindDirectionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
