package org.im97mori.ble.ad;

import org.junit.Test;

import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.junit.Assert.assertEquals;

public class CompleteListOf32BitServiceUUIDsTest {

    @Test
    public void constructTest() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 127;
        data[3] = 127;
        data[4] = 127;
        data[5] = 127;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = 127;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 127;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = (byte) 0b11111111;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest8() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(1, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(0, result.getUuidList().size());
    }

    @Test
    public void constructTest9() {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 5;
        data[7] = 6;
        data[8] = 7;
        data[9] = 8;
        CompleteListOf32BitServiceUUIDs result = new CompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(9, result.getLength());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(2, result.getUuidList().size());
        assertEquals(UUID.fromString("04030201-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
        assertEquals(UUID.fromString("08070605-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(1));
    }
}
