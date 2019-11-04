package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import java.util.UUID;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.junit.Assert.assertEquals;

public class IncompleteListOf32BitServiceUUIDsTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 127;
        data[3] = 127;
        data[4] = 127;
        data[5] = 127;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = 127;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 127;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = (byte) 0b11111111;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(1, result.getUuidList().size());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest8() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(1, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(0, result.getUuidList().size());
    }

    @Test
    public void constructTest9() {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 5;
        data[7] = 6;
        data[8] = 7;
        data[9] = 8;
        IncompleteListOf32BitServiceUUIDs result = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        assertEquals(9, result.getLength());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getDataType());
        assertEquals(2, result.getUuidList().size());
        assertEquals(UUID.fromString("04030201-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(0));
        assertEquals(UUID.fromString("08070605-0000-1000-8000-00805F9B34FB"), result.getUuidList().get(1));
    }

    @Test
    public void constructTest10() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;

        IncompleteListOf32BitServiceUUIDs result1 = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf32BitServiceUUIDs result2 = IncompleteListOf32BitServiceUUIDs.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuidList().size(), result2.getUuidList().size());
        assertEquals(result1.getUuidList().get(0), result2.getUuidList().get(0));
    }
    @Test
    public void constructTest11() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        IncompleteListOf32BitServiceUUIDs result1 = new IncompleteListOf32BitServiceUUIDs(data, 0, data[0]);
        IncompleteListOf32BitServiceUUIDs result2 = IncompleteListOf32BitServiceUUIDs.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuidList().size(), result2.getUuidList().size());
        assertEquals(result1.getUuidList().get(0), result2.getUuidList().get(0));
    }

}
