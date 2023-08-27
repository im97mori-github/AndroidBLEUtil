package org.im97mori.ble.characteristic.u2a6f;

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
public class HumidityAndroidTest extends TestBase {

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

        HumidityAndroid result1 = new HumidityAndroid(data);
        assertEquals(0x0201, result1.getHumidity());
        assertEquals(Humidity.HUMIDITY_RESOLUTION * 0x0201, result1.getHumidityPercent(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int humidity = 1;

        HumidityAndroid result1 = new HumidityAndroid(humidity);
        assertEquals(humidity, result1.getHumidity());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        HumidityAndroid result1 = new HumidityAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HumidityAndroid result2 = HumidityAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHumidity(), result2.getHumidity());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        HumidityAndroid result1 = new HumidityAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        HumidityAndroid result1 = new HumidityAndroid(data);
        HumidityAndroid result2 = HumidityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
