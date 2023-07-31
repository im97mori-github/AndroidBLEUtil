package org.im97mori.ble.characteristic.u2b09;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.Percentage8Utils;
import org.im97mori.ble.characteristic.core.VoltageUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class RelativeValueInAVoltageRangeAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 3] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result = new RelativeValueInAVoltageRangeAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt16(data, 1), result.getMinimumVoltage());
        assertEquals(BLEUtils.createUInt16(data, 3), result.getMaximumVoltage());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_MINIMUM;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result = new RelativeValueInAVoltageRangeAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt16(data, 1), result.getMinimumVoltage());
        assertEquals(BLEUtils.createUInt16(data, 3), result.getMaximumVoltage());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_MAXIMUM;
        data[ 1] = (byte) 65408;
        data[ 2] = (byte) (65408 >> 8);
        data[ 3] = (byte) 65408;
        data[ 4] = (byte) (65408 >> 8);
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result = new RelativeValueInAVoltageRangeAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt16(data, 1), result.getMinimumVoltage());
        assertEquals(BLEUtils.createUInt16(data, 3), result.getMaximumVoltage());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x04;
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result = new RelativeValueInAVoltageRangeAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt16(data, 1), result.getMinimumVoltage());
        assertEquals(BLEUtils.createUInt16(data, 3), result.getMaximumVoltage());
    }

    @Test
    public void test_constructor_00101() {
        int relativeValue = Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        int minimumVoltage = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        int maximumVoltage = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;

        RelativeValueInAVoltageRangeAndroid result = new RelativeValueInAVoltageRangeAndroid(relativeValue, minimumVoltage, maximumVoltage);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(minimumVoltage, result.getMinimumVoltage());
        assertEquals(maximumVoltage, result.getMaximumVoltage());
    }

    @Test
    public void test_constructor_00102() {
        int relativeValue = (int) Percentage8Utils.PERCENTAGE_8_VALUE_MINIMUM;
        int minimumVoltage = 0;
        int maximumVoltage = 0;

        RelativeValueInAVoltageRangeAndroid result = new RelativeValueInAVoltageRangeAndroid(relativeValue, minimumVoltage, maximumVoltage);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(minimumVoltage, result.getMinimumVoltage());
        assertEquals(maximumVoltage, result.getMaximumVoltage());
    }

    @Test
    public void test_constructor_00103() {
        int relativeValue = (int) Percentage8Utils.PERCENTAGE_8_VALUE_MAXIMUM;
        int minimumVoltage = 65408;
        int maximumVoltage = 65408;

        RelativeValueInAVoltageRangeAndroid result = new RelativeValueInAVoltageRangeAndroid(relativeValue, minimumVoltage, maximumVoltage);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(minimumVoltage, result.getMinimumVoltage());
        assertEquals(maximumVoltage, result.getMaximumVoltage());
    }

    @Test
    public void test_constructor_00104() {
        int relativeValue = 1;
        int minimumVoltage = 2;
        int maximumVoltage = 3;

        RelativeValueInAVoltageRangeAndroid result = new RelativeValueInAVoltageRangeAndroid(relativeValue, minimumVoltage, maximumVoltage);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(minimumVoltage, result.getMinimumVoltage());
        assertEquals(maximumVoltage, result.getMaximumVoltage());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 3] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInAVoltageRangeAndroid result2 = RelativeValueInAVoltageRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getMinimumVoltage(), result1.getMinimumVoltage());
        assertEquals(result2.getMaximumVoltage(), result1.getMaximumVoltage());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_MINIMUM;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInAVoltageRangeAndroid result2 = RelativeValueInAVoltageRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getMinimumVoltage(), result1.getMinimumVoltage());
        assertEquals(result2.getMaximumVoltage(), result1.getMaximumVoltage());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_MAXIMUM;
        data[ 1] = (byte) 65408;
        data[ 2] = (byte) (65408 >> 8);
        data[ 3] = (byte) 65408;
        data[ 4] = (byte) (65408 >> 8);
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInAVoltageRangeAndroid result2 = RelativeValueInAVoltageRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getMinimumVoltage(), result1.getMinimumVoltage());
        assertEquals(result2.getMaximumVoltage(), result1.getMaximumVoltage());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x04;
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInAVoltageRangeAndroid result2 = RelativeValueInAVoltageRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getMinimumVoltage(), result1.getMinimumVoltage());
        assertEquals(result2.getMaximumVoltage(), result1.getMaximumVoltage());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 3] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_MINIMUM;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_MAXIMUM;
        data[ 1] = (byte) 65408;
        data[ 2] = (byte) (65408 >> 8);
        data[ 3] = (byte) 65408;
        data[ 4] = (byte) (65408 >> 8);
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x04;
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 3] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        RelativeValueInAVoltageRangeAndroid result2 = RelativeValueInAVoltageRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_MINIMUM;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        RelativeValueInAVoltageRangeAndroid result2 = RelativeValueInAVoltageRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_MAXIMUM;
        data[ 1] = (byte) 65408;
        data[ 2] = (byte) (65408 >> 8);
        data[ 3] = (byte) 65408;
        data[ 4] = (byte) (65408 >> 8);
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        RelativeValueInAVoltageRangeAndroid result2 = RelativeValueInAVoltageRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x04;
        //@formatter:on

        RelativeValueInAVoltageRangeAndroid result1 = new RelativeValueInAVoltageRangeAndroid(data);
        RelativeValueInAVoltageRangeAndroid result2 = RelativeValueInAVoltageRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
