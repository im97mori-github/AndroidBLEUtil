package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.COMPANY_MAPPING;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

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
    public void constructTest11() {
        // google
        int companyId = 0x000000E0;

        byte[] additionalData = new byte[2];
        additionalData[0] = (byte) 0b11111111;
        additionalData[1] = 0;

        byte[] data = new byte[4 + additionalData.length];
        data[0] = (byte) (3 + additionalData.length);
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

        System.arraycopy(additionalData, 0, data, 4, additionalData.length);

        ManufacturerSpecificData result1 = new ManufacturerSpecificData(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerSpecificData result2 = ManufacturerSpecificData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

    @Test
    public void constructTest12() {
        // google
        int companyId = 0x000000E0;

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

        ManufacturerSpecificData result1 = new ManufacturerSpecificData(data, 0, data[0]);
        ManufacturerSpecificData result2 = ManufacturerSpecificData.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getCompanyIdentifier(), result2.getCompanyIdentifier());
        assertArrayEquals(result1.getManufacturerSpecificData(), result2.getManufacturerSpecificData());
    }

}
