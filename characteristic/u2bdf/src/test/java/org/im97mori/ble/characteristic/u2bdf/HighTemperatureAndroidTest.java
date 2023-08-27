package org.im97mori.ble.characteristic.u2bdf;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class HighTemperatureAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = (byte) 0xde;
        data[ 1] = (byte) 0xfd;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        data[ 0] = (byte) 0xff;
        data[ 1] = (byte) 0x7f;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[2];
        data[ 0] = (byte) HighTemperature.HIGH_TEMPERATURE_VALUE_IS_NOT_VALID;
        data[ 1] = (byte) (HighTemperature.HIGH_TEMPERATURE_VALUE_IS_NOT_VALID >> 8);
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[2];
        //noinspection DataFlowIssue
        data[ 0] = (byte) HighTemperature.HIGH_TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (HighTemperature.HIGH_TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        data_00004 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.geHighTemperature());
        assertEquals(BLEUtils.createSInt16(data, 0) * HighTemperature.HIGH_TEMPERATURE_RESOLUTION,
                result1.geHighTemperatureDegreeCelsius(), 0);
        assertFalse(result1.isValueIsNotValid());
        assertFalse(result1.isValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.geHighTemperature());
        assertEquals(BLEUtils.createSInt16(data, 0) * HighTemperature.HIGH_TEMPERATURE_RESOLUTION,
                result1.geHighTemperatureDegreeCelsius(), 0);
        assertFalse(result1.isValueIsNotValid());
        assertFalse(result1.isValueIsNotKnown());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        assertTrue(result1.isValueIsNotValid());
        assertFalse(result1.isValueIsNotKnown());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        assertFalse(result1.isValueIsNotValid());
        assertTrue(result1.isValueIsNotKnown());
    }

    @Test
    public void test_constructor_00101() {
        int highTemperature = (int) (-273 / HighTemperature.HIGH_TEMPERATURE_RESOLUTION);

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(highTemperature);
        assertEquals(highTemperature, result1.geHighTemperature());
        assertEquals(highTemperature * HighTemperature.HIGH_TEMPERATURE_RESOLUTION,
                result1.geHighTemperatureDegreeCelsius(), 0);
        assertFalse(result1.isValueIsNotValid());
        assertFalse(result1.isValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int highTemperature = (int) (16383.5 / HighTemperature.HIGH_TEMPERATURE_RESOLUTION);

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(highTemperature);
        assertEquals(highTemperature, result1.geHighTemperature());
        assertEquals(highTemperature * HighTemperature.HIGH_TEMPERATURE_RESOLUTION,
                result1.geHighTemperatureDegreeCelsius(), 0);
        assertFalse(result1.isValueIsNotValid());
        assertFalse(result1.isValueIsNotKnown());
    }

    @Test
    public void test_constructor_00103() {
        HighTemperatureAndroid result1 = new HighTemperatureAndroid(HighTemperature.HIGH_TEMPERATURE_VALUE_IS_NOT_VALID);
        assertTrue(result1.isValueIsNotValid());
        assertFalse(result1.isValueIsNotKnown());
    }

    @Test
    public void test_constructor_00104() {
        HighTemperatureAndroid result1 = new HighTemperatureAndroid(HighTemperature.HIGH_TEMPERATURE_VALUE_IS_NOT_KNOWN);
        assertFalse(result1.isValueIsNotValid());
        assertTrue(result1.isValueIsNotKnown());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighTemperatureAndroid result2 = HighTemperatureAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.geHighTemperature(), result2.geHighTemperature());
        assertEquals(result1.isValueIsNotValid(), result2.isValueIsNotValid());
        assertEquals(result1.isValueIsNotKnown(), result2.isValueIsNotKnown());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighTemperatureAndroid result2 = HighTemperatureAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.geHighTemperature(), result2.geHighTemperature());
        assertEquals(result1.isValueIsNotValid(), result2.isValueIsNotValid());
        assertEquals(result1.isValueIsNotKnown(), result2.isValueIsNotKnown());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighTemperatureAndroid result2 = HighTemperatureAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.geHighTemperature(), result2.geHighTemperature());
        assertEquals(result1.isValueIsNotValid(), result2.isValueIsNotValid());
        assertEquals(result1.isValueIsNotKnown(), result2.isValueIsNotKnown());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighTemperatureAndroid result2 = HighTemperatureAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.geHighTemperature(), result2.geHighTemperature());
        assertEquals(result1.isValueIsNotValid(), result2.isValueIsNotValid());
        assertEquals(result1.isValueIsNotKnown(), result2.isValueIsNotKnown());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        HighTemperatureAndroid result2 = HighTemperatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        HighTemperatureAndroid result2 = HighTemperatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        HighTemperatureAndroid result2 = HighTemperatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        HighTemperatureAndroid result1 = new HighTemperatureAndroid(data);
        HighTemperatureAndroid result2 = HighTemperatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
