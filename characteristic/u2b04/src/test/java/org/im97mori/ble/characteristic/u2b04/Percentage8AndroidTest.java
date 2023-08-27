package org.im97mori.ble.characteristic.u2b04;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.Percentage8Utils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class Percentage8AndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        Percentage8Android result = new Percentage8Android(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getPercentage8());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        Percentage8Android result = new Percentage8Android(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getPercentage8());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xc8;
        //@formatter:on

        Percentage8Android result = new Percentage8Android(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getPercentage8());
    }

    @Test
    public void test_constructor_00101() {
        int percentage8 = Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;

        Percentage8Android result = new Percentage8Android(percentage8);
        assertEquals(percentage8, result.getPercentage8());
    }

    @Test
    public void test_constructor_00102() {
        int percentage8 = 0;

        Percentage8Android result = new Percentage8Android(percentage8);
        assertEquals(percentage8, result.getPercentage8());
    }

    @Test
    public void test_constructor_00103() {
        int percentage8 = 200;

        Percentage8Android result = new Percentage8Android(percentage8);
        assertEquals(percentage8, result.getPercentage8());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xc8;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Percentage8Android result2 = Percentage8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getPercentage8(), result1.getPercentage8());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Percentage8Android result2 = Percentage8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getPercentage8(), result1.getPercentage8());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xc8;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Percentage8Android result2 = Percentage8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getPercentage8(), result1.getPercentage8());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xc8;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xc8;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xc8;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        Percentage8Android result2 = Percentage8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        Percentage8Android result2 = Percentage8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xc8;
        //@formatter:on

        Percentage8Android result1 = new Percentage8Android(data);
        Percentage8Android result2 = Percentage8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
