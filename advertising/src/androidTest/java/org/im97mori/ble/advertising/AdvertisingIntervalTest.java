package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.advertising.AdvertisingInterval.ADVERTISING_INTERVAL_UNIT_MILLIS;
import static org.im97mori.ble.constants.DataType.ADVERTISING_INTERVAL_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class AdvertisingIntervalTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[2] = 0x7f;
        data[3] = 0x7f;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x7f;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[2] = 0x7f;
        data[3] = 0x00;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[2] = 0;
        data[3] = (byte) 0b11111111;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        data_00007 = data;
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

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getAdvertisingInterval());
        assertEquals(0 * ADVERTISING_INTERVAL_UNIT_MILLIS, result1.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result1.getDataType());
        assertEquals(0x7f7f, result1.getAdvertisingInterval());
        assertEquals(0x7f7f * ADVERTISING_INTERVAL_UNIT_MILLIS, result1.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result1.getDataType());
        assertEquals(0x7f00, result1.getAdvertisingInterval());
        assertEquals(0x7f00 * ADVERTISING_INTERVAL_UNIT_MILLIS, result1.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result1.getDataType());
        assertEquals(0x007f, result1.getAdvertisingInterval());
        assertEquals(0x007f * ADVERTISING_INTERVAL_UNIT_MILLIS, result1.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result1.getDataType());
        assertEquals(0xffff, result1.getAdvertisingInterval());
        assertEquals(0xffff * ADVERTISING_INTERVAL_UNIT_MILLIS, result1.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result1.getDataType());
        assertEquals(0xff00, result1.getAdvertisingInterval());
        assertEquals(0xff00 * ADVERTISING_INTERVAL_UNIT_MILLIS, result1.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result1.getDataType());
        assertEquals(0x00ff, result1.getAdvertisingInterval());
        assertEquals(0x00ff * ADVERTISING_INTERVAL_UNIT_MILLIS, result1.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAdvertisingInterval(), result2.getAdvertisingInterval());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAdvertisingInterval(), result2.getAdvertisingInterval());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAdvertisingInterval(), result2.getAdvertisingInterval());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAdvertisingInterval(), result2.getAdvertisingInterval());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAdvertisingInterval(), result2.getAdvertisingInterval());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAdvertisingInterval(), result2.getAdvertisingInterval());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAdvertisingInterval(), result2.getAdvertisingInterval());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        AdvertisingIntervalAndroid result1 = new AdvertisingIntervalAndroid(data, 0, data[0]);
        AdvertisingIntervalAndroid result2 = AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
