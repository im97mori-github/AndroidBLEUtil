package org.im97mori.ble.characteristic.u2a82;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class AnaerobicHeartRateUpperLimitAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        AnaerobicHeartRateUpperLimitAndroid result1 = new AnaerobicHeartRateUpperLimitAndroid(data);
        assertEquals(0x00, result1.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AnaerobicHeartRateUpperLimitAndroid result1 = new AnaerobicHeartRateUpperLimitAndroid(data);
        assertEquals(0xff, result1.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    public void test_constructor003() {
        int anaerobicHeartRateUpperLimit = 1;

        AnaerobicHeartRateUpperLimitAndroid result1 = new AnaerobicHeartRateUpperLimitAndroid(anaerobicHeartRateUpperLimit);
        assertEquals(anaerobicHeartRateUpperLimit, result1.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AnaerobicHeartRateUpperLimitAndroid result1 = new AnaerobicHeartRateUpperLimitAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnaerobicHeartRateUpperLimitAndroid result2 = AnaerobicHeartRateUpperLimitAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAnaerobicHeartRateUpperLimit(), result1.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AnaerobicHeartRateUpperLimitAndroid result1 = new AnaerobicHeartRateUpperLimitAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AnaerobicHeartRateUpperLimitAndroid result1 = new AnaerobicHeartRateUpperLimitAndroid(data);
        AnaerobicHeartRateUpperLimitAndroid result2 = AnaerobicHeartRateUpperLimitAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
