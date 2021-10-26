package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.CompanyUUID.COMPANY_MAPPING_128;
import static org.im97mori.ble.constants.DataType.MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"ConstantConditions", "unused"})
public class ManufacturerSpecificDataTest {

    // google
    private static final int COMPANY_ID = 0x000000E0;

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] additionalData = new byte[1];
        additionalData[0] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] additionalData = new byte[1];
        additionalData[0] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] additionalData = new byte[1];
        additionalData[0] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 127;
        additionalData[1] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (COMPANY_ID & 0x0000ff);
        data[3] = (byte) ((COMPANY_ID >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        data_00010 = data;
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

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_constructor_00010() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(COMPANY_ID, result1.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(COMPANY_ID)), result1.getCompanyName());
        assertEquals(data[0] - 3, result1.getManufacturerSpecificData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        ManufacturerSpecificDataAndroid result1 = new ManufacturerSpecificDataAndroid(data, 0, data[0]);
        ManufacturerSpecificDataAndroid result2 = ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
