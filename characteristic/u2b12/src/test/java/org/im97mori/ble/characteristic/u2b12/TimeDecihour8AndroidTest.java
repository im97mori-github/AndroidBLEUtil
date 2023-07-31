package org.im97mori.ble.characteristic.u2b12;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.EnergyUtils;
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
public class TimeDecihour8AndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        TimeDecihour8Android result = new TimeDecihour8Android(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getTimeDecihour8());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        //@formatter:on

        TimeDecihour8Android result = new TimeDecihour8Android(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getTimeDecihour8());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        //@formatter:on

        TimeDecihour8Android result = new TimeDecihour8Android(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getTimeDecihour8());
    }

    @Test
    public void test_constructor_00101() {
        int timeDecihour8 = EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;

        TimeDecihour8Android result = new TimeDecihour8Android(timeDecihour8);
        assertEquals(timeDecihour8, result.getTimeDecihour8());
    }

    @Test
    public void test_constructor_00102() {
        int timeDecihour8 = EnergyUtils.ENERGY_VALUE_MINIMUM;

        TimeDecihour8Android result = new TimeDecihour8Android(timeDecihour8);
        assertEquals(timeDecihour8, result.getTimeDecihour8());
    }

    @Test
    public void test_constructor_00103() {
        int timeDecihour8 = EnergyUtils.ENERGY_VALUE_MAXIMUM;

        TimeDecihour8Android result = new TimeDecihour8Android(timeDecihour8);
        assertEquals(timeDecihour8, result.getTimeDecihour8());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeDecihour8Android result2 = TimeDecihour8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeDecihour8(), result1.getTimeDecihour8());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeDecihour8Android result2 = TimeDecihour8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeDecihour8(), result1.getTimeDecihour8());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeDecihour8Android result2 = TimeDecihour8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeDecihour8(), result1.getTimeDecihour8());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        TimeDecihour8Android result2 = TimeDecihour8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        TimeDecihour8Android result2 = TimeDecihour8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        //@formatter:on

        TimeDecihour8Android result1 = new TimeDecihour8Android(data);
        TimeDecihour8Android result2 = TimeDecihour8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
