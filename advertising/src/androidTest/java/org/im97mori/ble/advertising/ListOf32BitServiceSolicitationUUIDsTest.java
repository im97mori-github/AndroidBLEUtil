package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.im97mori.ble.constants.DataType.LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unused", "IntegerMultiplicationImplicitCastToLong"})
public class ListOf32BitServiceSolicitationUUIDsTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 5;
        data[7] = 6;
        data[8] = 7;
        data[9] = 8;
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
    public void test_constructor_1_00001() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00007() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00008() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(1, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getUuidList().size());
    }

    @Test
    public void test_constructor_1_00009() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertEquals(9, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(UUID.fromString("04030201-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
        assertEquals(UUID.fromString("08070605-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(1));
    }

    @Test
    public void test_constructor_1_00101() {
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid();
        assertEquals(1, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getUuidList().size());
    }

    @Test
    public void test_constructor_1_00102() {
        UUID uuid1 = UUID.randomUUID();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuid1);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(uuid1, result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00103() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuid1, uuid2);
        assertEquals(9, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(uuid1, result1.getUuidList().get(0));
        assertEquals(uuid2, result1.getUuidList().get(1));
    }

    @Test
    public void test_constructor_1_00104() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(Arrays.asList(uuid1, uuid2));
        assertEquals(9, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(uuid1, result1.getUuidList().get(0));
        assertEquals(uuid2, result1.getUuidList().get(1));
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00005() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00006() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00007() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00008() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(1, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getUuidList().size());
    }

    @Test
    public void test_constructor_2_00009() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0);
        assertEquals(9, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(UUID.fromString("04030201-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
        assertEquals(UUID.fromString("08070605-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(1));
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_3_00002() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_3_00003() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_3_00004() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_3_00005() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_3_00006() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_3_00007() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(5, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_3_00008() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(1, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getUuidList().size());
    }

    @Test
    public void test_constructor_3_00009() {
        byte[] data = getData();

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 2; i < data[0] + 1; i += 4) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target |= (data[i + 2] & 0xff) << 16;
            target |= (data[i + 3] & 0xff) << 24;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(uuidList);
        assertEquals(9, result1.getLength());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(UUID.fromString("04030201-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
        assertEquals(UUID.fromString("08070605-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(1));
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        ListOf32BitServiceSolicitationUUIDsAndroid result1 = new ListOf32BitServiceSolicitationUUIDsAndroid(data, 0, data[0]);
        ListOf32BitServiceSolicitationUUIDsAndroid result2 = ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
