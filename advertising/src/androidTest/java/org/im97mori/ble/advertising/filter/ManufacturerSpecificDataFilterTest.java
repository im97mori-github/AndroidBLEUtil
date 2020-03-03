package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ManufacturerSpecificDataAndroid;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ManufacturerSpecificDataFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(new ArrayList<ManufacturerSpecificDataAndroid>(), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        int companyId = 0x0000F0E0;

        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        expectData[2] = (byte) (companyId & 0x0000ff);
        expectData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(expectData), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        int companyId = 0x0000F0E0;

        byte[] actualData = new byte[4];
        actualData[0] = 3;
        actualData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        actualData[2] = (byte) (companyId & 0x0000ff);
        actualData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(new ArrayList<ManufacturerSpecificDataAndroid>(), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        int companyId = 0x0000F0E0;

        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        expectData[2] = (byte) (companyId & 0x0000ff);
        expectData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(expectData), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        int companyId = 0x0000F0E0;

        byte[] expectData = new byte[8];
        expectData[0] = 3;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        expectData[2] = (byte) (companyId & 0x0000ff);
        expectData[3] = (byte) ((companyId >> 8) & 0x0000ff);
        expectData[4] = 3;
        expectData[5] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        expectData[6] = (byte) (companyId & 0x0000ff);
        expectData[7] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(
                Arrays.asList(new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length / 2 - 1)
                        , new ManufacturerSpecificDataAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1))
                , null
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        int companyId = 0x0000F0E0;

        byte[] actualData = new byte[8];
        actualData[0] = 3;
        actualData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        actualData[2] = (byte) (companyId & 0x0000ff);
        actualData[3] = (byte) ((companyId >> 8) & 0x0000ff);
        actualData[4] = 3;
        actualData[5] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        actualData[6] = (byte) (companyId & 0x0000ff);
        actualData[7] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(
                new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length - 1), null
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        int companyId = 0x0000F0E0;

        byte[] expectData = new byte[8];
        expectData[0] = 3;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        expectData[2] = (byte) (companyId & 0x0000ff);
        expectData[3] = (byte) ((companyId >> 8) & 0x0000ff);
        expectData[4] = 3;
        expectData[5] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        expectData[6] = (byte) (companyId & 0x0000ff);
        expectData[7] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(
                Arrays.asList(new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length / 2 - 1)
                        , new ManufacturerSpecificDataAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1))
                , null
        );
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_201() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = new byte[4];
        actualData[0] = 3;
        actualData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, actualData, 2, specificData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length - 1), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_202() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, actualData, 2, specificData.length);

        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length - 1), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_203() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length - 1), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_301() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(expectData), new byte[0]);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_303() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_304() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[4] = 1;

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_305() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_306() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[4] = 1;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_307() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[4] = 1;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_401() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[3];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length - 1), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_402() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(Collections.singletonList(new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length - 1)), Collections.singletonList(bitmask));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_403() {
        int companyId = 0x0000F0E0;

        byte[] specificData = new byte[4];
        specificData[0] = (byte) (companyId & 0x0000ff);
        specificData[1] = (byte) ((companyId >> 8) & 0x0000ff);
        specificData[2] = (byte) (companyId & 0x0000ff);
        specificData[3] = (byte) ((companyId >> 8) & 0x0000ff);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        System.arraycopy(specificData, 0, expectData, 2, specificData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[4] = 1;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ManufacturerSpecificDataFilter(Collections.singletonList(new ManufacturerSpecificDataAndroid(expectData, 0, expectData.length - 1)), Arrays.asList(bitmask, bitmask));
        assertFalse(filter.isMatched(result));
    }
}
