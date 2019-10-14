package org.im97mori.ble.ad;

import android.os.Parcel;

import org.junit.Test;

import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.junit.Assert.assertEquals;

public class ListOf128BitServiceSolicitationUUIDsTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 127;
        data[3] = 127;
        data[4] = 127;
        data[5] = 127;
        data[6] = 127;
        data[7] = 127;
        data[8] = 127;
        data[9] = 127;
        data[10] = 127;
        data[11] = 127;
        data[12] = 127;
        data[13] = 127;
        data[14] = 127;
        data[15] = 127;
        data[16] = 127;
        data[17] = 127;
        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("7f7f7f7f-7f7f-7f7f-7f7f-7f7f7f7f7f7f"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        data[6] = 0;
        data[7] = 0;
        data[8] = 0;
        data[9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data[15] = 0;
        data[16] = 0;
        data[17] = 127;
        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("7f000000-0000-0000-0000-000000000000"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 127;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        data[6] = 0;
        data[7] = 0;
        data[8] = 0;
        data[9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data[15] = 0;
        data[16] = 0;
        data[17] = 0;
        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-00000000007f"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b11111111;
        data[8] = (byte) 0b11111111;
        data[9] = (byte) 0b11111111;
        data[10] = (byte) 0b11111111;
        data[11] = (byte) 0b11111111;
        data[12] = (byte) 0b11111111;
        data[13] = (byte) 0b11111111;
        data[14] = (byte) 0b11111111;
        data[15] = (byte) 0b11111111;
        data[16] = (byte) 0b11111111;
        data[17] = (byte) 0b11111111;
        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("ffffffff-ffff-ffff-ffff-ffffffffffff"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        data[6] = 0;
        data[7] = 0;
        data[8] = 0;
        data[9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data[15] = 0;
        data[16] = 0;
        data[17] = (byte) 0b11111111;
        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("ff000000-0000-0000-0000-000000000000"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        data[6] = 0;
        data[7] = 0;
        data[8] = 0;
        data[9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data[15] = 0;
        data[16] = 0;
        data[17] = 0;
        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-0000000000ff"), result.getUuidList().get(0));
    }

    @Test
    public void constructTest8() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(1, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(0, result.getUuidList().size());
    }

    @Test
    public void constructTest9() {
        byte[] data = new byte[34];
        data[0] = 33;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x01;
        data[3] = 0x02;
        data[4] = 0x03;
        data[5] = 0x04;
        data[6] = 0x05;
        data[7] = 0x06;
        data[8] = 0x07;
        data[9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        data[30] = 0x1d;
        data[31] = 0x1e;
        data[32] = 0x1f;
        data[33] = 0x20;
        ListOf128BitServiceSolicitationUUIDs result = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        assertEquals(33, result.getLength());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getDataType());
        assertEquals(2, result.getUuidList().size());
        assertEquals(UUID.fromString("100f0e0d-0c0b-0a09-0807-060504030201"), result.getUuidList().get(0));
        assertEquals(UUID.fromString("201f1e1d-1c1b-1a19-1817-161514131211"), result.getUuidList().get(1));
    }

    @Test
    public void constructTest10() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x01;
        data[3] = 0x02;
        data[4] = 0x03;
        data[5] = 0x04;
        data[6] = 0x05;
        data[7] = 0x06;
        data[8] = 0x07;
        data[9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;

        ListOf128BitServiceSolicitationUUIDs result1 = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListOf128BitServiceSolicitationUUIDs result2 = ListOf128BitServiceSolicitationUUIDs.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuidList().size(), result2.getUuidList().size());
        assertEquals(result1.getUuidList().get(0), result2.getUuidList().get(0));
    }

    @Test
    public void constructTest11() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        ListOf128BitServiceSolicitationUUIDs result1 = new ListOf128BitServiceSolicitationUUIDs(data, 0, data[0]);
        ListOf128BitServiceSolicitationUUIDs result2 = ListOf128BitServiceSolicitationUUIDs.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuidList().size(), result2.getUuidList().size());
        assertEquals(result1.getUuidList().get(0), result2.getUuidList().get(0));
    }

}
