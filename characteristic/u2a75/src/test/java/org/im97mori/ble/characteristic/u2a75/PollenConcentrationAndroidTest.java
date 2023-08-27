package org.im97mori.ble.characteristic.u2a75;

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
public class PollenConcentrationAndroidTest extends TestBase {

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

        PollenConcentrationAndroid result1 = new PollenConcentrationAndroid(data);
        assertEquals(0x030201, result1.getPollenConcentration());
    }

    @Test
    public void test_constructor_00002() {
        int pollenConcentration = 1;

        PollenConcentrationAndroid result1 = new PollenConcentrationAndroid(pollenConcentration);
        assertEquals(pollenConcentration, result1.getPollenConcentration());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        PollenConcentrationAndroid result1 = new PollenConcentrationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PollenConcentrationAndroid result2 = PollenConcentrationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPollenConcentration(), result2.getPollenConcentration());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        PollenConcentrationAndroid result1 = new PollenConcentrationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        PollenConcentrationAndroid result1 = new PollenConcentrationAndroid(data);
        PollenConcentrationAndroid result2 = PollenConcentrationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
