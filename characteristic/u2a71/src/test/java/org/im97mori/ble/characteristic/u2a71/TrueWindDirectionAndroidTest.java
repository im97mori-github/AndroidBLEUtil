package org.im97mori.ble.characteristic.u2a71;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
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
public class TrueWindDirectionAndroidTest extends TestBase {

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

        TrueWindDirectionAndroid result1 = new TrueWindDirectionAndroid(data);
        assertEquals(0x0201, result1.getTrueWindDirection());
        assertEquals(TrueWindDirection.TRUE_WIND_DIRECTION_RESOLUTION * 0x0201, result1.getTrueWindDirectionDegrees(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int trueWindDirection = 1;

        TrueWindDirectionAndroid result1 = new TrueWindDirectionAndroid(trueWindDirection);
        assertEquals(trueWindDirection, result1.getTrueWindDirection());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        TrueWindDirectionAndroid result1 = new TrueWindDirectionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrueWindDirectionAndroid result2 = TrueWindDirectionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getTrueWindDirection(), result2.getTrueWindDirection());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        TrueWindDirectionAndroid result1 = new TrueWindDirectionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        TrueWindDirectionAndroid result1 = new TrueWindDirectionAndroid(data);
        TrueWindDirectionAndroid result2 = TrueWindDirectionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
