package org.im97mori.ble.characteristic.u2a7f;

import android.os.Build;
import android.os.Parcel;

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
public class AerobicThresholdAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(data);
        assertEquals(0x00, result1.getAerobicThreshold());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(data);
        assertEquals(0xff, result1.getAerobicThreshold());
    }

    @Test
    public void test_constructor003() {
        int aerobicThreshold = 1;

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(aerobicThreshold);
        assertEquals(aerobicThreshold, result1.getAerobicThreshold());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AerobicThresholdAndroid result2 = AerobicThresholdAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAerobicThreshold(), result1.getAerobicThreshold());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(data);
        AerobicThresholdAndroid result2 = AerobicThresholdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
