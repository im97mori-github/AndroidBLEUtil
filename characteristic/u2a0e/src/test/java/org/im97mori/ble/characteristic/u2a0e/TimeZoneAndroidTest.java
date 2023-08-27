package org.im97mori.ble.characteristic.u2a0e;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.TimeZoneUtils;
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
public class TimeZoneAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN;
        //@formatter:on

        TimeZoneAndroid result1 = new TimeZoneAndroid(data);
        assertEquals(TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN, result1.getTimeZone());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = -48;
        //@formatter:on

        TimeZoneAndroid result1 = new TimeZoneAndroid(data);
        assertEquals(-48, result1.getTimeZone());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 56;
        //@formatter:on

        TimeZoneAndroid result1 = new TimeZoneAndroid(data);
        assertEquals(56, result1.getTimeZone());
    }

    @Test
    public void test_constructor_00101() {
        int timeZone = 1;

        TimeZoneAndroid result1 = new TimeZoneAndroid(timeZone);
        assertEquals(timeZone, result1.getTimeZone());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeZoneAndroid result1 = new TimeZoneAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeZoneAndroid result2 = TimeZoneAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeZone(), result1.getTimeZone());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeZoneAndroid result1 = new TimeZoneAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeZoneAndroid result1 = new TimeZoneAndroid(data);
        TimeZoneAndroid result2 = TimeZoneAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
