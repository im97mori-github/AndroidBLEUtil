package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_TX_POWER_LEVEL;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class TxPowerLevelTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = 127;
        data_00002 = data;
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

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(DATA_TYPE_TX_POWER_LEVEL, result1.getDataType());
        assertEquals(-127, result1.getTxPowerLevel());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(DATA_TYPE_TX_POWER_LEVEL, result1.getDataType());
        assertEquals(127, result1.getTxPowerLevel());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TxPowerLevelAndroid result2 = TxPowerLevelAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTxPowerLevel(), result2.getTxPowerLevel());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TxPowerLevelAndroid result2 = TxPowerLevelAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTxPowerLevel(), result2.getTxPowerLevel());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data, 0, data[0]);
        TxPowerLevelAndroid result2 = TxPowerLevelAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data, 0, data[0]);
        TxPowerLevelAndroid result2 = TxPowerLevelAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
