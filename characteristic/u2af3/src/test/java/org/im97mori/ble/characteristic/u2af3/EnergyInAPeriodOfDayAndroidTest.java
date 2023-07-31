package org.im97mori.ble.characteristic.u2af3;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.EnergyUtils;
import org.im97mori.ble.characteristic.core.TimeDecihour8Utils;
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
public class EnergyInAPeriodOfDayAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result = new EnergyInAPeriodOfDayAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getEnergyValue());
        assertEquals(BLEUtils.createUInt8(data, 3), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 4), result.getEndTime());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result = new EnergyInAPeriodOfDayAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getEnergyValue());
        assertEquals(BLEUtils.createUInt8(data, 3), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 4), result.getEndTime());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result = new EnergyInAPeriodOfDayAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getEnergyValue());
        assertEquals(BLEUtils.createUInt8(data, 3), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 4), result.getEndTime());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result = new EnergyInAPeriodOfDayAndroid(data);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getEnergyValue());
        assertEquals(BLEUtils.createUInt8(data, 3), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 4), result.getEndTime());
    }

    @Test
    public void test_constructor_00101() {
        int energyValue = EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        int startTime = TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        int endTime = TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;

        EnergyInAPeriodOfDayAndroid result = new EnergyInAPeriodOfDayAndroid(energyValue, startTime, endTime);
        assertEquals(energyValue, result.getEnergyValue());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00102() {
        int energyValue = EnergyUtils.ENERGY_VALUE_MINIMUM;
        int startTime = (int) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        int endTime = (int) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;

        EnergyInAPeriodOfDayAndroid result = new EnergyInAPeriodOfDayAndroid(energyValue, startTime, endTime);
        assertEquals(energyValue, result.getEnergyValue());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00103() {
        int energyValue = EnergyUtils.ENERGY_VALUE_MAXIMUM;
        int startTime = (int) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        int endTime = (int) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;

        EnergyInAPeriodOfDayAndroid result = new EnergyInAPeriodOfDayAndroid(energyValue, startTime, endTime);
        assertEquals(energyValue, result.getEnergyValue());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00104() {
        int energyValue = 1;
        int startTime = 2;
        int endTime = 3;

        EnergyInAPeriodOfDayAndroid result = new EnergyInAPeriodOfDayAndroid(energyValue, startTime, endTime);
        assertEquals(energyValue, result.getEnergyValue());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnergyInAPeriodOfDayAndroid result2 = EnergyInAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getEnergyValue(), result1.getEnergyValue());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnergyInAPeriodOfDayAndroid result2 = EnergyInAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getEnergyValue(), result1.getEnergyValue());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnergyInAPeriodOfDayAndroid result2 = EnergyInAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getEnergyValue(), result1.getEnergyValue());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnergyInAPeriodOfDayAndroid result2 = EnergyInAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getEnergyValue(), result1.getEnergyValue());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
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
        data[ 4] = 0x05;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        EnergyInAPeriodOfDayAndroid result2 = EnergyInAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MINIMUM;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        EnergyInAPeriodOfDayAndroid result2 = EnergyInAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 16);
        data[ 3] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        data[ 4] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_MAXIMUM;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        EnergyInAPeriodOfDayAndroid result2 = EnergyInAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
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
        data[ 4] = 0x05;
        //@formatter:on

        EnergyInAPeriodOfDayAndroid result1 = new EnergyInAPeriodOfDayAndroid(data);
        EnergyInAPeriodOfDayAndroid result2 = EnergyInAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
