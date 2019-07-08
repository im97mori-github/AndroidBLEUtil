package org.im97mori.ble.ad;

import org.junit.Test;

import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ServiceData16BitUUIDTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 127;
        data[3] = 127;
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00007f7f-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 127;
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00007f00-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 127;
        data[3] = 0;
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("0000ffff-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = (byte) 0b11111111;
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("0000ff00-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest8() {
        byte[] additionalData = new byte[1];
        additionalData[0] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest9() {
        byte[] additionalData = new byte[1];
        additionalData[0] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest10() {
        byte[] additionalData = new byte[1];
        additionalData[0] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest11() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest12() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 127;
        additionalData[1] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest13() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest14() {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest15() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest16() {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ServiceData16BitUUID result = new ServiceData16BitUUID(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }
}
