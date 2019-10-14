package org.im97mori.ble.ad;

import android.os.Parcel;

import org.junit.Test;

import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ServiceData128BitUUIDTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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

        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("7f7f7f7f-7f7f-7f7f-7f7f-7f7f7f7f7f7f"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("7f000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-00000000007f"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("ffffffff-ffff-ffff-ffff-ffffffffffff"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("ff000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-0000000000ff"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest8() {
        byte[] additionalData = new byte[1];
        additionalData[0] = 0;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest9() {
        byte[] additionalData = new byte[1];
        additionalData[0] = 127;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest10() {
        byte[] additionalData = new byte[1];
        additionalData[0] = (byte) 0b11111111;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest11() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 0;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest12() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 127;
        additionalData[1] = 127;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest13() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 127;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest14() {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest15() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest16() {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);
        ServiceData128BitUUID result = new ServiceData128BitUUID(data, 0, data[0]);
        assertEquals(17 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest17() {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[18 + additionalData.length];
        data[0] = (byte) (17 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
        data[17] = 0;

        System.arraycopy(additionalData, 0, data, 18, additionalData.length);

        ServiceData128BitUUID result1 = new ServiceData128BitUUID(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData128BitUUID result2 = ServiceData128BitUUID.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void constructTest18() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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

        ServiceData128BitUUID result1 = new ServiceData128BitUUID(data, 0, data[0]);
        ServiceData128BitUUID result2 = ServiceData128BitUUID.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertEquals(result1.getAdditionalServiceData().length, result2.getAdditionalServiceData().length);
    }
}
