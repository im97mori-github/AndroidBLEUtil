package org.im97mori.ble.characteristic.u2a8f;

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
public class HipCircumferenceAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        HipCircumferenceAndroid result1 = new HipCircumferenceAndroid(data);
        assertEquals(0x0201, result1.getHipCircumference());
        assertEquals(HipCircumference.HIP_CIRCUMFERENCE_RESOLUTION * 0x0201, result1.getHipCircumferenceMeters(), 0);
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0xff;
        data[ 1] = (byte) 0xff;
        //@formatter:on

        HipCircumferenceAndroid result1 = new HipCircumferenceAndroid(data);
        assertEquals(0xffff, result1.getHipCircumference());
        assertEquals(HipCircumference.HIP_CIRCUMFERENCE_RESOLUTION * 0xffff, result1.getHipCircumferenceMeters(), 0);
    }

    @Test
    public void test_constructor003() {
        int hipCircumference = 1;

        HipCircumferenceAndroid result1 = new HipCircumferenceAndroid(hipCircumference);
        assertEquals(hipCircumference, result1.getHipCircumference());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        HipCircumferenceAndroid result1 = new HipCircumferenceAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HipCircumferenceAndroid result2 = HipCircumferenceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getHipCircumference(), result1.getHipCircumference());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        HipCircumferenceAndroid result1 = new HipCircumferenceAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        HipCircumferenceAndroid result1 = new HipCircumferenceAndroid(data);
        HipCircumferenceAndroid result2 = HipCircumferenceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
