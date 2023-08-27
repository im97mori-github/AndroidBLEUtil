package org.im97mori.ble.characteristic.u2a79;

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
public class WindChillAndroidTest extends TestBase {

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

        WindChillAndroid result1 = new WindChillAndroid(data);
        assertEquals(0x01, result1.getWindChill());
    }

    @Test
    public void test_constructor_00002() {
        int windChill = 1;

        WindChillAndroid result1 = new WindChillAndroid(windChill);
        assertEquals(windChill, result1.getWindChill());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        WindChillAndroid result1 = new WindChillAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WindChillAndroid result2 = WindChillAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getWindChill(), result2.getWindChill());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        WindChillAndroid result1 = new WindChillAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        WindChillAndroid result1 = new WindChillAndroid(data);
        WindChillAndroid result2 = WindChillAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
