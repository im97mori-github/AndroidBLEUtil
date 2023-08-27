package org.im97mori.ble.characteristic.u2a78;

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
public class RainfallAndroidTest extends TestBase {

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

        RainfallAndroid result1 = new RainfallAndroid(data);
        assertEquals(0x0201, result1.getRainfall());
        assertEquals(Rainfall.RAINFALL_RESOLUTION * 0x0201, result1.getRainfallMilliMeters(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int rainfall = 1;

        RainfallAndroid result1 = new RainfallAndroid(rainfall);
        assertEquals(rainfall, result1.getRainfall());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        RainfallAndroid result1 = new RainfallAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RainfallAndroid result2 = RainfallAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRainfall(), result2.getRainfall());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        RainfallAndroid result1 = new RainfallAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        RainfallAndroid result1 = new RainfallAndroid(data);
        RainfallAndroid result2 = RainfallAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
