package org.im97mori.ble.characteristic.u2ae1;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.TimeExponential8Utils;
import org.im97mori.ble.characteristic.core.VoltageUtils;
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
public class AverageVoltageAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(data);
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getVoltageValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getVoltageValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getVoltageValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getVoltageValue());
        assertEquals(0x03, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00101() {
        int voltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(voltageValue, timeExponential8);
        assertEquals(voltageValue, result1.getVoltageValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00102() {
        int voltageValue = 0x0201;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(voltageValue, timeExponential8);
        assertEquals(voltageValue, result1.getVoltageValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00103() {
        int voltageValue = 0x0201;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(voltageValue, timeExponential8);
        assertEquals(voltageValue, result1.getVoltageValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00104() {
        int voltageValue = 0x0201;
        int timeExponential8 = 0x03;

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(voltageValue, timeExponential8);
        assertEquals(voltageValue, result1.getVoltageValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AverageVoltageAndroid result2 = AverageVoltageAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getVoltageValue(), result1.getVoltageValue());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        AverageVoltageAndroid result1 = new AverageVoltageAndroid(data);
        AverageVoltageAndroid result2 = AverageVoltageAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
