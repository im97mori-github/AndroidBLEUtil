package org.im97mori.ble.characteristic.u2ae0;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.ElectricCurrentUtils;
import org.im97mori.ble.characteristic.core.TimeExponential8Utils;
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
public class AverageCurrentAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(data);
        assertEquals(ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN, result1.getElectricCurrentValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(data);
        assertEquals(0x0100, result1.getElectricCurrentValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(data);
        assertEquals(0x0100, result1.getElectricCurrentValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(data);
        assertEquals(0x0100, result1.getElectricCurrentValue());
        assertEquals(0x02, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00101() {
        int electricCurrentValue = ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(electricCurrentValue, timeExponential8);
        assertEquals(electricCurrentValue, result1.getElectricCurrentValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00102() {
        int electricCurrentValue = 0x01;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(electricCurrentValue, timeExponential8);
        assertEquals(electricCurrentValue, result1.getElectricCurrentValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00103() {
        int electricCurrentValue = 0x01;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(electricCurrentValue, timeExponential8);
        assertEquals(electricCurrentValue, result1.getElectricCurrentValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00104() {
        int electricCurrentValue = 0x01;
        int timeExponential8 = 0x02;

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(electricCurrentValue, timeExponential8);
        assertEquals(electricCurrentValue, result1.getElectricCurrentValue());
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

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AverageCurrentAndroid result2 = AverageCurrentAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getElectricCurrentValue(), result1.getElectricCurrentValue());
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

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(data);
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

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(data);
        AverageCurrentAndroid result2 = AverageCurrentAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
