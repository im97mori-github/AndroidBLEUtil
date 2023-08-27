package org.im97mori.ble.characteristic.u2b19;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.VoltageUtils;
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
public class VoltageSpecificationAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getMinimumVoltageValue());
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getTypicalVoltageValue());
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getMaximumVoltageValue());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        assertEquals(0, result1.getMinimumVoltageValue());
        assertEquals(0, result1.getTypicalVoltageValue());
        assertEquals(0, result1.getMaximumVoltageValue());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 65408;
        data[ 1] = (byte) (65408 >> 8);
        data[ 2] = (byte) 65408;
        data[ 3] = (byte) (65408 >> 8);
        data[ 4] = (byte) 65408;
        data[ 5] = (byte) (65408 >> 8);
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        assertEquals(65408, result1.getMinimumVoltageValue());
        assertEquals(65408, result1.getTypicalVoltageValue());
        assertEquals(65408, result1.getMaximumVoltageValue());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getMinimumVoltageValue());
        assertEquals(BLEUtils.createUInt16(data, 2), result1.getTypicalVoltageValue());
        assertEquals(BLEUtils.createUInt16(data, 4), result1.getMaximumVoltageValue());
    }

    @Test
    public void test_constructor_00101() {
        int minimumVoltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        int typicalVoltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        int maximumVoltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(minimumVoltageValue, typicalVoltageValue, maximumVoltageValue);
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(typicalVoltageValue, result1.getTypicalVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
    }

    @Test
    public void test_constructor_00102() {
        int minimumVoltageValue = 0;
        int typicalVoltageValue = 0;
        int maximumVoltageValue = 0;

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(minimumVoltageValue, typicalVoltageValue, maximumVoltageValue);
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(typicalVoltageValue, result1.getTypicalVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
    }

    @Test
    public void test_constructor_00103() {
        int minimumVoltageValue = 65408;
        int typicalVoltageValue = 65408;
        int maximumVoltageValue = 65408;

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(minimumVoltageValue, typicalVoltageValue, maximumVoltageValue);
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(typicalVoltageValue, result1.getTypicalVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
    }

    @Test
    public void test_constructor_00104() {
        int minimumVoltageValue = 1;
        int typicalVoltageValue = 2;
        int maximumVoltageValue = 3;

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(minimumVoltageValue, typicalVoltageValue, maximumVoltageValue);
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(typicalVoltageValue, result1.getTypicalVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageSpecificationAndroid result2 = VoltageSpecificationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getTypicalVoltageValue(), result1.getTypicalVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageSpecificationAndroid result2 = VoltageSpecificationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getTypicalVoltageValue(), result1.getTypicalVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 65408;
        data[ 1] = (byte) (65408 >> 8);
        data[ 2] = (byte) 65408;
        data[ 3] = (byte) (65408 >> 8);
        data[ 4] = (byte) 65408;
        data[ 5] = (byte) (65408 >> 8);
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageSpecificationAndroid result2 = VoltageSpecificationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getTypicalVoltageValue(), result1.getTypicalVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageSpecificationAndroid result2 = VoltageSpecificationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getTypicalVoltageValue(), result1.getTypicalVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 65408;
        data[ 1] = (byte) (65408 >> 8);
        data[ 2] = (byte) 65408;
        data[ 3] = (byte) (65408 >> 8);
        data[ 4] = (byte) 65408;
        data[ 5] = (byte) (65408 >> 8);
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        VoltageSpecificationAndroid result2 = VoltageSpecificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        VoltageSpecificationAndroid result2 = VoltageSpecificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 65408;
        data[ 1] = (byte) (65408 >> 8);
        data[ 2] = (byte) 65408;
        data[ 3] = (byte) (65408 >> 8);
        data[ 4] = (byte) 65408;
        data[ 5] = (byte) (65408 >> 8);
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        VoltageSpecificationAndroid result2 = VoltageSpecificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        VoltageSpecificationAndroid result1 = new VoltageSpecificationAndroid(data);
        VoltageSpecificationAndroid result2 = VoltageSpecificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
