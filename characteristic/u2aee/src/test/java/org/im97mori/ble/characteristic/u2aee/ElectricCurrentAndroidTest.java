package org.im97mori.ble.characteristic.u2aee;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.ElectricCurrentUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/** @noinspection DataFlowIssue*/
@SuppressWarnings({"PointlessBitwiseExpression"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ElectricCurrentAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(data);
        assertEquals(ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN, result.getCurrent());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0;
        data[ 1] = (byte) (0 >> 8);
        //@formatter:on

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCurrent());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCurrent());
    }

    @Test
    public void test_constructor_00101() {
        int current = ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(current);
        assertEquals(current, result.getCurrent());
    }

    @Test
    public void test_constructor_00102() {
        int current = 0;

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(current);
        assertEquals(current, result.getCurrent());
    }

    @Test
    public void test_constructor_00103() {
        int current = 65534;

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(current);
        assertEquals(current, result.getCurrent());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrent(), result1.getCurrent());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0;
        data[ 1] = (byte) (0 >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrent(), result1.getCurrent());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrent(), result1.getCurrent());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0;
        data[ 1] = (byte) (0 >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0;
        data[ 1] = (byte) (0 >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(data);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
