package org.im97mori.ble.characteristic.u2a23;

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
public class SystemIdAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        SystemIdAndroid result1 = new SystemIdAndroid(data);
        assertEquals(0x0504030201L, result1.getManufacturerIdentifier());
        assertEquals(0x080706, result1.getOrganizationallyUniqueIdentifier());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = (byte) 0xff;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = (byte) 0xff;
        //@formatter:on

        SystemIdAndroid result1 = new SystemIdAndroid(data);
        assertEquals(0xff04030201L, result1.getManufacturerIdentifier());
        assertEquals(0xff0706, result1.getOrganizationallyUniqueIdentifier());
    }

    @Test
    public void test_constructor003() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;

        SystemIdAndroid result1 = new SystemIdAndroid(manufacturerIdentifier, organizationallyUniqueIdentifier);
        assertEquals(manufacturerIdentifier, result1.getManufacturerIdentifier());
        assertEquals(organizationallyUniqueIdentifier, result1.getOrganizationallyUniqueIdentifier());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        SystemIdAndroid result1 = new SystemIdAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SystemIdAndroid result2 = SystemIdAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getManufacturerIdentifier(), result1.getManufacturerIdentifier());
        assertEquals(result2.getOrganizationallyUniqueIdentifier(), result1.getOrganizationallyUniqueIdentifier());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        SystemIdAndroid result1 = new SystemIdAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        SystemIdAndroid result1 = new SystemIdAndroid(data);
        SystemIdAndroid result2 = SystemIdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
