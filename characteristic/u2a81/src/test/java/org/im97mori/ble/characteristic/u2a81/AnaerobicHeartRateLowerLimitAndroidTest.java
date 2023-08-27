package org.im97mori.ble.characteristic.u2a81;

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
public class AnaerobicHeartRateLowerLimitAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        AnaerobicHeartRateLowerLimitAndroid result1 = new AnaerobicHeartRateLowerLimitAndroid(data);
        assertEquals(0x00, result1.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AnaerobicHeartRateLowerLimitAndroid result1 = new AnaerobicHeartRateLowerLimitAndroid(data);
        assertEquals(0xff, result1.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_constructor003() {
        int anaerobicHeartRateLowerLimit = 1;

        AnaerobicHeartRateLowerLimitAndroid result1 = new AnaerobicHeartRateLowerLimitAndroid(anaerobicHeartRateLowerLimit);
        assertEquals(anaerobicHeartRateLowerLimit, result1.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AnaerobicHeartRateLowerLimitAndroid result1 = new AnaerobicHeartRateLowerLimitAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnaerobicHeartRateLowerLimitAndroid result2 = AnaerobicHeartRateLowerLimitAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAnaerobicHeartRateLowerLimit(), result1.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AnaerobicHeartRateLowerLimitAndroid result1 = new AnaerobicHeartRateLowerLimitAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AnaerobicHeartRateLowerLimitAndroid result1 = new AnaerobicHeartRateLowerLimitAndroid(data);
        AnaerobicHeartRateLowerLimitAndroid result2 = AnaerobicHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
