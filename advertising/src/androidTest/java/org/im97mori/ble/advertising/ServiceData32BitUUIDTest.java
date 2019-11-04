package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import java.util.UUID;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ServiceData32BitUUIDTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 127;
        data[3] = 127;
        data[4] = 127;
        data[5] = 127;
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("7f7f7f7f-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = 127;
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("7f000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 127;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("ffffffff-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = (byte) 0b11111111;
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("ff000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(0, result.getAdditionalServiceData().length);
    }

    @Test
    public void constructTest8() {
        byte[] additionalData = new byte[1];
        additionalData[0] = 0;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest9() {
        byte[] additionalData = new byte[1];
        additionalData[0] = 127;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest10() {
        byte[] additionalData = new byte[1];
        additionalData[0] = (byte) 0b11111111;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest11() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 0;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest12() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 127;
        additionalData[1] = 127;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest13() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 127;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest14() {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest15() {
        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest16() {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);
        ServiceData32BitUUID result = new ServiceData32BitUUID(data, 0, data[0]);
        assertEquals(5 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getDataType());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result.getUuid());
        assertEquals(additionalData.length, result.getAdditionalServiceData().length);
        assertArrayEquals(additionalData, result.getAdditionalServiceData());
    }

    @Test
    public void constructTest17() {
        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[6 + additionalData.length];
        data[0] = (byte) (5 + additionalData.length);
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        System.arraycopy(additionalData, 0, data, 6, additionalData.length);

        ServiceData32BitUUID result1 = new ServiceData32BitUUID(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData32BitUUID result2 = ServiceData32BitUUID.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getAdditionalServiceData(), result2.getAdditionalServiceData());
    }

    @Test
    public void constructTest18() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        ServiceData32BitUUID result1 = new ServiceData32BitUUID(data, 0, data[0]);
        ServiceData32BitUUID result2 = ServiceData32BitUUID.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertEquals(result1.getAdditionalServiceData().length, result2.getAdditionalServiceData().length);
    }

}
