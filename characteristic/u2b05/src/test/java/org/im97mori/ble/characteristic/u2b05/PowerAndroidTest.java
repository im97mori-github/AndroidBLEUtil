package org.im97mori.ble.characteristic.u2b05;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.PowerUtils;
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
public class PowerAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        PowerAndroid result = new PowerAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getPower());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        PowerAndroid result = new PowerAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getPower());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        PowerAndroid result = new PowerAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getPower());
    }

    @Test
    public void test_constructor_00101() {
        int power = PowerUtils.POWER_VALUE_IS_NOT_KNOWN;

        PowerAndroid result = new PowerAndroid(power);
        assertEquals(power, result.getPower());
    }

    @Test
    public void test_constructor_00102() {
        int power = 0;

        PowerAndroid result = new PowerAndroid(power);
        assertEquals(power, result.getPower());
    }

    @Test
    public void test_constructor_00103() {
        int power = 16777214;

        PowerAndroid result = new PowerAndroid(power);
        assertEquals(power, result.getPower());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PowerAndroid result2 = PowerAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getPower(), result1.getPower());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PowerAndroid result2 = PowerAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getPower(), result1.getPower());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PowerAndroid result2 = PowerAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getPower(), result1.getPower());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        PowerAndroid result2 = PowerAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        PowerAndroid result2 = PowerAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        PowerAndroid result1 = new PowerAndroid(data);
        PowerAndroid result2 = PowerAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
