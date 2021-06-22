package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_RANDOM_TARGET_ADDRESS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class RandomTargetAddressTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] address = new byte[6];
        address[0] = 127;
        address[1] = 127;
        address[2] = 127;
        address[3] = 127;
        address[4] = 127;
        address[5] = 127;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 127;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] address = new byte[6];
        address[0] = 127;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] address = new byte[6];
        address[0] = (byte) 0b11111111;
        address[1] = (byte) 0b11111111;
        address[2] = (byte) 0b11111111;
        address[3] = (byte) 0b11111111;
        address[4] = (byte) 0b11111111;
        address[5] = (byte) 0b11111111;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = (byte) 0b11111111;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] address = new byte[6];
        address[0] = (byte) 0b11111111;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);
        System.arraycopy(address, 0, data, 2, address.length);
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] address1 = new byte[6];
        address1[0] = 0x00;
        address1[1] = 0x01;
        address1[2] = 0x02;
        address1[3] = 0x03;
        address1[4] = 0x04;
        address1[5] = 0x05;

        byte[] address2 = new byte[6];
        address2[0] = 0x06;
        address2[1] = 0x07;
        address2[2] = 0x08;
        address2[3] = 0x09;
        address2[4] = 0x0a;
        address2[5] = 0x0b;

        byte[] data = new byte[14];
        data[0] = 13;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address1, 0, data, 2, address1.length);
        System.arraycopy(address2, 0, data, 8, address2.length);
        data_00009 = data;
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

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(7, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(1, result1.getAddressList().size());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getAddressList().get(0));
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(7, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(1, result1.getAddressList().size());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getAddressList().get(0));
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(7, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(1, result1.getAddressList().size());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getAddressList().get(0));
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(7, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(1, result1.getAddressList().size());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getAddressList().get(0));
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(7, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(1, result1.getAddressList().size());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getAddressList().get(0));
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(7, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(1, result1.getAddressList().size());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getAddressList().get(0));
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(7, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(1, result1.getAddressList().size());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getAddressList().get(0));
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(1, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(0, result1.getAddressList().size());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertEquals(13, result1.getLength());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result1.getDataType());
        assertEquals(2, result1.getAddressList().size());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 8), result1.getAddressList().get(0));
        assertArrayEquals(Arrays.copyOfRange(data, 8, 14), result1.getAddressList().get(1));
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getAddressList().toArray(), result2.getAddressList().toArray());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        RandomTargetAddressAndroid result1 = new RandomTargetAddressAndroid(data, 0, data[0]);
        RandomTargetAddressAndroid result2 = RandomTargetAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
