package org.im97mori.ble.characteristic.u2a05;

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
public class ServiceChangedAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(data);
        assertEquals(0x0201, result1.getStartOfAffectedAttributeHandleRange());
        assertEquals(0x0403, result1.getEndOfAffectedAttributeHandleRange());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0xff;
        data[ 2] = 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(data);
        assertEquals(0xff01, result1.getStartOfAffectedAttributeHandleRange());
        assertEquals(0xff03, result1.getEndOfAffectedAttributeHandleRange());
    }

    @Test
    public void test_constructor003() {
        int startOfAffectedAttributeHandleRange = 1;
        int endOfAffectedAttributeHandleRange = 2;

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(startOfAffectedAttributeHandleRange, endOfAffectedAttributeHandleRange);
        assertEquals(startOfAffectedAttributeHandleRange, result1.getStartOfAffectedAttributeHandleRange());
        assertEquals(endOfAffectedAttributeHandleRange, result1.getEndOfAffectedAttributeHandleRange());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceChangedAndroid result2 = ServiceChangedAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getStartOfAffectedAttributeHandleRange(), result1.getStartOfAffectedAttributeHandleRange());
        assertEquals(result2.getEndOfAffectedAttributeHandleRange(), result1.getEndOfAffectedAttributeHandleRange());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(data);
        ServiceChangedAndroid result2 = ServiceChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
