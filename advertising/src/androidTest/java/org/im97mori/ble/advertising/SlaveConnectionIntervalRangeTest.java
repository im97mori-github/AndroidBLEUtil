package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unused")
public class SlaveConnectionIntervalRangeTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0x00;
        data[3] = (byte) 0x00;
        data[4] = (byte) 0x00;
        data[5] = (byte) 0x00;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0x06;
        data[3] = (byte) 0x00;
        data[4] = (byte) 0x06;
        data[5] = (byte) 0x00;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0x80;
        data[3] = (byte) 0x0c;
        data[4] = (byte) 0x80;
        data[5] = (byte) 0x0c;
        data_00004 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result1.getDataType());
        assertFalse(result1.hasMinimum());
        assertFalse(result1.hasMaximum());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result1.getDataType());
        assertTrue(result1.hasMinimum());
        assertTrue(result1.hasMaximum());
        assertEquals(0, result1.getMinimumValue());
        assertEquals(0, result1.getMaximumValue());
        assertEquals(0 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result1.getMinimumValueMillis(), 0);
        assertEquals(0 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result1.getMaximumValueMillis(), 0);
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result1.getDataType());
        assertTrue(result1.hasMinimum());
        assertTrue(result1.hasMaximum());
        assertEquals(0x0006, result1.getMinimumValue());
        assertEquals(0x0006, result1.getMaximumValue());
        assertEquals(0x0006 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result1.getMinimumValueMillis(), 0);
        assertEquals(0x0006 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result1.getMaximumValueMillis(), 0);
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result1.getDataType());
        assertTrue(result1.hasMinimum());
        assertTrue(result1.hasMaximum());
        assertEquals(0x0c80, result1.getMinimumValue());
        assertEquals(0x0c80, result1.getMaximumValue());
        assertEquals(0x0c80 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result1.getMinimumValueMillis(), 0);
        assertEquals(0x0c80 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result1.getMaximumValueMillis(), 0);
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SlaveConnectionIntervalRangeAndroid result2 = SlaveConnectionIntervalRangeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getMinimumValue(), result2.getMinimumValue());
        assertEquals(result1.getMaximumValue(), result2.getMaximumValue());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SlaveConnectionIntervalRangeAndroid result2 = SlaveConnectionIntervalRangeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getMinimumValue(), result2.getMinimumValue());
        assertEquals(result1.getMaximumValue(), result2.getMaximumValue());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SlaveConnectionIntervalRangeAndroid result2 = SlaveConnectionIntervalRangeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getMinimumValue(), result2.getMinimumValue());
        assertEquals(result1.getMaximumValue(), result2.getMaximumValue());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SlaveConnectionIntervalRangeAndroid result2 = SlaveConnectionIntervalRangeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getMinimumValue(), result2.getMinimumValue());
        assertEquals(result1.getMaximumValue(), result2.getMaximumValue());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        SlaveConnectionIntervalRangeAndroid result2 = SlaveConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        SlaveConnectionIntervalRangeAndroid result2 = SlaveConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        SlaveConnectionIntervalRangeAndroid result2 = SlaveConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        SlaveConnectionIntervalRangeAndroid result1 = new SlaveConnectionIntervalRangeAndroid(data, 0, data[0]);
        SlaveConnectionIntervalRangeAndroid result2 = SlaveConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
