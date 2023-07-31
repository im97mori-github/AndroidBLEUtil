package org.im97mori.ble.characteristic.u2b13;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.TimeExponential8Utils;
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
public class TimeExponential8AndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        TimeExponential8Android result1 = new TimeExponential8Android(data);
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS, result1.getTimeExponential8());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        TimeExponential8Android result1 = new TimeExponential8Android(data);
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE, result1.getTimeExponential8());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        TimeExponential8Android result1 = new TimeExponential8Android(data);
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN, result1.getTimeExponential8());
    }

    @Test
    public void test_constructor_00101() {
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;

        TimeExponential8Android result1 = new TimeExponential8Android(timeExponential8);
        assertEquals(timeExponential8, result1.getTimeExponential8());
    }

    @Test
    public void test_constructor_00102() {
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;

        TimeExponential8Android result1 = new TimeExponential8Android(timeExponential8);
        assertEquals(timeExponential8, result1.getTimeExponential8());
    }

    @Test
    public void test_constructor_00103() {
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;

        TimeExponential8Android result1 = new TimeExponential8Android(timeExponential8);
        assertEquals(timeExponential8, result1.getTimeExponential8());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeExponential8Android result1 = new TimeExponential8Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeExponential8Android result2 = TimeExponential8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeExponential8(), result1.getTimeExponential8());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeExponential8Android result1 = new TimeExponential8Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeExponential8Android result1 = new TimeExponential8Android(data);
        TimeExponential8Android result2 = TimeExponential8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
