package org.im97mori.ble.advertising;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.im97mori.ble.constants.DataType.SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.UUID;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings({"unused", "IntegerMultiplicationImplicitCastToLong"})
public class ServiceData32BitUUIDAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 127;
        data[3] = 127;
        data[4] = 127;
        data[5] = 127;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = 127;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 127;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = (byte) 0b11111111;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] additionalData = new byte[1];
        additionalData[0] = 0;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] additionalData = new byte[1];
        additionalData[0] = 127;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] additionalData = new byte[1];
        additionalData[0] = (byte) 0b11111111;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00010 = data;
    }

    private static final byte[] data_00011;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 0;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00011 = data;
    }

    private static final byte[] data_00012;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 127;
        additionalData[1] = 127;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00012 = data;
    }

    private static final byte[] data_00013;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 127;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00013 = data;
    }

    private static final byte[] data_00014;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00014 = data;
    }

    private static final byte[] data_00015;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00015 = data;
    }

    private static final byte[] data_00016;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        data_00016 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_1_00007() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_1_00008() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_1_00009() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_1_00010() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_1_00011() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_1_00012() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_1_00013() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_1_00014() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_1_00015() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_1_00016() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_2_00005() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_2_00006() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_2_00007() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_2_00008() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00009() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00010() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00011() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00012() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00013() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00014() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00015() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_2_00016() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_3_00002() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_3_00003() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_3_00004() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_3_00005() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_3_00006() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_3_00007() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(5, result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(0, result1.getAdditionalServiceData().length);
    }

    @Test
    public void test_constructor_3_00008() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00009() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00010() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00011() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00012() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00013() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00014() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00015() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_constructor_3_00016() {
        byte[] data = getData();

        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target |= (data[4] & 0xff) << 16;
        target |= (data[5] & 0xff) << 24;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        byte[] additionalServiceData = new byte[data[0] - 5];
        System.arraycopy(data, 6, additionalServiceData, 0, data[0] - 5);
        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(uuid, additionalServiceData);
        assertEquals(data[0], result1.getLength());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuid());
        assertEquals(data[0] - 5, result1.getAdditionalServiceData().length);
        assertArrayEquals(Arrays.copyOfRange(data, 6, data.length), result1.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00011() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00012() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00013() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00014() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00015() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_1_00016() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00011() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00012() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00013() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00014() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00015() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00016() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00011() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00012() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00013() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00014() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00015() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00016() {
        byte[] data = getData();

        ServiceData32BitUUIDAndroid result1 = new ServiceData32BitUUIDAndroid(data, 0, data[0]);
        ServiceData32BitUUIDAndroid result2 = ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
