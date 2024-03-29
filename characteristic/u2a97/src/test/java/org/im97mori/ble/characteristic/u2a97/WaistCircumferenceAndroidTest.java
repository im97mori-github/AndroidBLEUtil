package org.im97mori.ble.characteristic.u2a97;

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
public class WaistCircumferenceAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        WaistCircumferenceAndroid result1 = new WaistCircumferenceAndroid(data);
        assertEquals(0x0201, result1.getWaistCircumference());
        assertEquals(WaistCircumference.WAIST_CIRCUMFERENCE_RESOLUTION * 0x0201, result1.getWaistCircumferenceMeters(), 0);
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0xff;
        data[ 1] = (byte) 0xff;
        //@formatter:on

        WaistCircumferenceAndroid result1 = new WaistCircumferenceAndroid(data);
        assertEquals(0xffff, result1.getWaistCircumference());
        assertEquals(WaistCircumference.WAIST_CIRCUMFERENCE_RESOLUTION * 0xffff, result1.getWaistCircumferenceMeters(), 0);
    }

    @Test
    public void test_constructor003() {
        int waistCircumference = 1;

        WaistCircumferenceAndroid result1 = new WaistCircumferenceAndroid(waistCircumference);
        assertEquals(waistCircumference, result1.getWaistCircumference());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        WaistCircumferenceAndroid result1 = new WaistCircumferenceAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WaistCircumferenceAndroid result2 = WaistCircumferenceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getWaistCircumference(), result1.getWaistCircumference());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        WaistCircumferenceAndroid result1 = new WaistCircumferenceAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        WaistCircumferenceAndroid result1 = new WaistCircumferenceAndroid(data);
        WaistCircumferenceAndroid result2 = WaistCircumferenceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
