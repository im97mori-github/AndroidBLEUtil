package org.im97mori.ble.characteristic.u2a58;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class AnalogAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor301() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor302() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor401() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor402() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor501() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor502() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_constructor601() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getAnalog());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable011() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable012() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable013() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getAnalog(), result2.getAnalog());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x02;
        //@formatter:on

        AnalogAndroid result1 = new AnalogAndroid(data);
        AnalogAndroid result2 = AnalogAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
