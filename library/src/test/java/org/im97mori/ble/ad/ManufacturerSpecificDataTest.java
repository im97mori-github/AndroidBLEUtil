package org.im97mori.ble.ad;

import org.junit.Test;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
import static org.im97mori.ble.ad.AdvertisingDataConstants.COMPANY_MAPPING;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ManufacturerSpecificDataTest {

    @Test
    public void constructTest1() {
        // google
        int companyId = 0x000000E0;

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(0, result.getManufacturerSpecificData().length);
    }

    @Test
    public void constructTest2() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[1];
        additionalData[0] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }

    @Test
    public void constructTest3() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[1];
        additionalData[0] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }

    @Test
    public void constructTest4() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[1];
        additionalData[0] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }

    @Test
    public void constructTest5() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }

    @Test
    public void constructTest6() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[2];
        additionalData[0] = 127;
        additionalData[1] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }

    @Test
    public void constructTest7() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = 127;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }

    @Test
    public void constructTest8() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }

    @Test
    public void constructTest9() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[2];
        additionalData[0] = 0;
        additionalData[1] = (byte) 0b11111111;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }

    @Test
    public void constructTest10() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);
        ManufacturerSpecificData result = new ManufacturerSpecificData(data, 0, data[0]);
        assertEquals(3 + additionalData.length, result.getLength());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getDataType());
        assertEquals(companyId, result.getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(companyId), result.getCompanyName());
        assertEquals(additionalData.length, result.getManufacturerSpecificData().length);
        assertArrayEquals(additionalData, result.getManufacturerSpecificData());
    }
}
