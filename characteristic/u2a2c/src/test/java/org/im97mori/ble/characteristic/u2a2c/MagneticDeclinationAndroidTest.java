package org.im97mori.ble.characteristic.u2a2c;

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
public class MagneticDeclinationAndroidTest extends TestBase {

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

        MagneticDeclinationAndroid result1 = new MagneticDeclinationAndroid(data);
        assertEquals(0x0201, result1.getMagneticDeclination());
        assertEquals(MagneticDeclination.MAGNETIC_DECLINATION_RESOLUTION * 0x0201, result1.getMagneticDeclinationDegrees(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int magneticDeclination = 1;

        MagneticDeclinationAndroid result1 = new MagneticDeclinationAndroid(magneticDeclination);
        assertEquals(magneticDeclination, result1.getMagneticDeclination());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        MagneticDeclinationAndroid result1 = new MagneticDeclinationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MagneticDeclinationAndroid result2 = MagneticDeclinationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMagneticDeclination(), result2.getMagneticDeclination());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        MagneticDeclinationAndroid result1 = new MagneticDeclinationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        MagneticDeclinationAndroid result1 = new MagneticDeclinationAndroid(data);
        MagneticDeclinationAndroid result2 = MagneticDeclinationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
