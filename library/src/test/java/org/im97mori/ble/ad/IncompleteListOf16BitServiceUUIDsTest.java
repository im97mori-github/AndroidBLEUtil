package org.im97mori.ble.ad;

import org.junit.Test;

import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.junit.Assert.assertEquals;

public class IncompleteListOf16BitServiceUUIDsTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 127;
        data[3] = 127;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("00007f7f-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 127;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("00007f00-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 127;
        data[3] = 0;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("0000ffff-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = (byte) 0b11111111;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("0000ff00-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest8() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(1, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(0, result.getUuidList().size());
    }

    @Test
    public void constructTest9() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        IncompleteListOf16BitServiceUUIDs result = new IncompleteListOf16BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(2, result.getUuidList().size());
        assertEquals(UUID.fromString("00000201-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
        assertEquals(UUID.fromString("00000403-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(1));
    }
}
