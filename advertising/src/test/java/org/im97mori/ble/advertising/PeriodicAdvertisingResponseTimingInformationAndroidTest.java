package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("unused")
public class PeriodicAdvertisingResponseTimingInformationAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 0x01;
        data[7] = 0x06;
        data[8] = 0x01;
        data[9] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = (byte) 0x80;
        data[7] = (byte) 0xff;
        data[8] = (byte) 0xfe;
        data[9] = (byte) 0xff;
        data_00002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data, 0,
                data[0]);
        assertEquals(9, result1.getLength());
        assertEquals(PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 6), result1.getRspAa());
        assertEquals(BLEUtils.createUInt8(data, 6), result1.getNumSubevents());
        assertEquals(BLEUtils.createUInt8(data, 7), result1.getSubeventInterval());
        assertEquals(
                BLEUtils.createUInt8(data, 7)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.SUBEVENT_INTERVAL_UNIT_MILLIS,
                result1.getSubeventIntervalMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 8), result1.getResponseSlotDelay());
        assertEquals(
                BLEUtils.createUInt8(data, 8)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_DELAY_UNIT_MILLIS,
                result1.getResponseSlotDelayMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 9), result1.getResponseSlotSpacing());
        assertEquals(
                BLEUtils.createUInt8(data, 9)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_SPACING_UNIT_MILLIS,
                result1.getResponseSlotSpacingMillis(), 0);
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data, 0,
                data[0]);
        assertEquals(9, result1.getLength());
        assertEquals(PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 6), result1.getRspAa());
        assertEquals(BLEUtils.createUInt8(data, 6), result1.getNumSubevents());
        assertEquals(BLEUtils.createUInt8(data, 7), result1.getSubeventInterval());
        assertEquals(
                BLEUtils.createUInt8(data, 7)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.SUBEVENT_INTERVAL_UNIT_MILLIS,
                result1.getSubeventIntervalMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 8), result1.getResponseSlotDelay());
        assertEquals(
                BLEUtils.createUInt8(data, 8)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_DELAY_UNIT_MILLIS,
                result1.getResponseSlotDelayMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 9), result1.getResponseSlotSpacing());
        assertEquals(
                BLEUtils.createUInt8(data, 9)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_SPACING_UNIT_MILLIS,
                result1.getResponseSlotSpacingMillis(), 0);
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data,
                0);
        assertEquals(9, result1.getLength());
        assertEquals(PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 6), result1.getRspAa());
        assertEquals(BLEUtils.createUInt8(data, 6), result1.getNumSubevents());
        assertEquals(BLEUtils.createUInt8(data, 7), result1.getSubeventInterval());
        assertEquals(
                BLEUtils.createUInt8(data, 7)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.SUBEVENT_INTERVAL_UNIT_MILLIS,
                result1.getSubeventIntervalMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 8), result1.getResponseSlotDelay());
        assertEquals(
                BLEUtils.createUInt8(data, 8)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_DELAY_UNIT_MILLIS,
                result1.getResponseSlotDelayMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 9), result1.getResponseSlotSpacing());
        assertEquals(
                BLEUtils.createUInt8(data, 9)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_SPACING_UNIT_MILLIS,
                result1.getResponseSlotSpacingMillis(), 0);
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data,
                0);
        assertEquals(9, result1.getLength());
        assertEquals(PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 6), result1.getRspAa());
        assertEquals(BLEUtils.createUInt8(data, 6), result1.getNumSubevents());
        assertEquals(BLEUtils.createUInt8(data, 7), result1.getSubeventInterval());
        assertEquals(
                BLEUtils.createUInt8(data, 7)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.SUBEVENT_INTERVAL_UNIT_MILLIS,
                result1.getSubeventIntervalMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 8), result1.getResponseSlotDelay());
        assertEquals(
                BLEUtils.createUInt8(data, 8)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_DELAY_UNIT_MILLIS,
                result1.getResponseSlotDelayMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 9), result1.getResponseSlotSpacing());
        assertEquals(
                BLEUtils.createUInt8(data, 9)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_SPACING_UNIT_MILLIS,
                result1.getResponseSlotSpacingMillis(), 0);
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        byte[] rspAa = new byte[4];
        System.arraycopy(data, 2, rspAa, 0, 4);
        int numSubevents = BLEUtils.createUInt8(data, 6);
        int subeventInterval = BLEUtils.createUInt8(data, 7);
        int responseSlotDelay = BLEUtils.createUInt8(data, 8);
        int responseSlotSpacing = BLEUtils.createUInt8(data, 9);

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(rspAa,
                numSubevents, subeventInterval, responseSlotDelay, responseSlotSpacing);
        assertEquals(9, result1.getLength());
        assertEquals(PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 6), result1.getRspAa());
        assertEquals(BLEUtils.createUInt8(data, 6), result1.getNumSubevents());
        assertEquals(BLEUtils.createUInt8(data, 7), result1.getSubeventInterval());
        assertEquals(
                BLEUtils.createUInt8(data, 7)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.SUBEVENT_INTERVAL_UNIT_MILLIS,
                result1.getSubeventIntervalMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 8), result1.getResponseSlotDelay());
        assertEquals(
                BLEUtils.createUInt8(data, 8)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_DELAY_UNIT_MILLIS,
                result1.getResponseSlotDelayMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 9), result1.getResponseSlotSpacing());
        assertEquals(
                BLEUtils.createUInt8(data, 9)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_SPACING_UNIT_MILLIS,
                result1.getResponseSlotSpacingMillis(), 0);
    }

    @Test
    public void test_constructor_3_00002() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data,
                0);
        assertEquals(9, result1.getLength());
        assertEquals(PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 6), result1.getRspAa());
        assertEquals(BLEUtils.createUInt8(data, 6), result1.getNumSubevents());
        assertEquals(BLEUtils.createUInt8(data, 7), result1.getSubeventInterval());
        assertEquals(
                BLEUtils.createUInt8(data, 7)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.SUBEVENT_INTERVAL_UNIT_MILLIS,
                result1.getSubeventIntervalMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 8), result1.getResponseSlotDelay());
        assertEquals(
                BLEUtils.createUInt8(data, 8)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_DELAY_UNIT_MILLIS,
                result1.getResponseSlotDelayMillis(), 0);
        assertEquals(BLEUtils.createUInt8(data, 9), result1.getResponseSlotSpacing());
        assertEquals(
                BLEUtils.createUInt8(data, 9)
                        * PeriodicAdvertisingResponseTimingInformationAndroid.RESPONSE_SLOT_SPACING_UNIT_MILLIS,
                result1.getResponseSlotSpacingMillis(), 0);
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PeriodicAdvertisingResponseTimingInformationAndroid result2 = PeriodicAdvertisingResponseTimingInformationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getRspAa(), result2.getRspAa());
        assertEquals(result1.getNumSubevents(), result2.getNumSubevents());
        assertEquals(result1.getSubeventInterval(), result2.getSubeventInterval());
        assertEquals(result1.getResponseSlotDelay(), result2.getResponseSlotDelay());
        assertEquals(result1.getResponseSlotSpacing(), result2.getResponseSlotSpacing());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PeriodicAdvertisingResponseTimingInformationAndroid result2 = PeriodicAdvertisingResponseTimingInformationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getNumSubevents(), result2.getNumSubevents());
        assertEquals(result1.getSubeventInterval(), result2.getSubeventInterval());
        assertEquals(result1.getResponseSlotDelay(), result2.getResponseSlotDelay());
        assertEquals(result1.getResponseSlotSpacing(), result2.getResponseSlotSpacing());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data, 0, data[0]);
        PeriodicAdvertisingResponseTimingInformationAndroid result2 = PeriodicAdvertisingResponseTimingInformationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        PeriodicAdvertisingResponseTimingInformationAndroid result1 = new PeriodicAdvertisingResponseTimingInformationAndroid(data, 0, data[0]);
        PeriodicAdvertisingResponseTimingInformationAndroid result2 = PeriodicAdvertisingResponseTimingInformationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
