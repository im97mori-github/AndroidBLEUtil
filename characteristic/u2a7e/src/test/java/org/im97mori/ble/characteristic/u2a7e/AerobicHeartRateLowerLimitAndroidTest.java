package org.im97mori.ble.characteristic.u2a7e;

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
public class AerobicHeartRateLowerLimitAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        AerobicHeartRateLowerLimitAndroid result1 = new AerobicHeartRateLowerLimitAndroid(data);
        assertEquals(0x00, result1.getAerobicHeartRateLowerLimit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AerobicHeartRateLowerLimitAndroid result1 = new AerobicHeartRateLowerLimitAndroid(data);
        assertEquals(0xff, result1.getAerobicHeartRateLowerLimit());
    }

    @Test
    public void test_constructor003() {
        int aerobicHeartRateLowerLimit = 1;

        AerobicHeartRateLowerLimitAndroid result1 = new AerobicHeartRateLowerLimitAndroid(aerobicHeartRateLowerLimit);
        assertEquals(aerobicHeartRateLowerLimit, result1.getAerobicHeartRateLowerLimit());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AerobicHeartRateLowerLimitAndroid result1 = new AerobicHeartRateLowerLimitAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AerobicHeartRateLowerLimitAndroid result2 = AerobicHeartRateLowerLimitAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAerobicHeartRateLowerLimit(), result1.getAerobicHeartRateLowerLimit());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AerobicHeartRateLowerLimitAndroid result1 = new AerobicHeartRateLowerLimitAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AerobicHeartRateLowerLimitAndroid result1 = new AerobicHeartRateLowerLimitAndroid(data);
        AerobicHeartRateLowerLimitAndroid result2 = AerobicHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
