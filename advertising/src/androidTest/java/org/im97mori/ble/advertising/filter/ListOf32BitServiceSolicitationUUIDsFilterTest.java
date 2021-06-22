package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ListOf32BitServiceSolicitationUUIDsAndroid;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListOf32BitServiceSolicitationUUIDsFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter(ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        actualData[2] = 0x00;
        actualData[3] = 0x00;
        actualData[4] = 0x00;
        actualData[5] = 0x00;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter(ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[12];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 5;
        expectData[7] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter(
                new ListOf32BitServiceSolicitationUUIDsAndroid(expectData, 0, expectData.length / 2 - 1)
                , new ListOf32BitServiceSolicitationUUIDsAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[12];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        actualData[2] = 0x00;
        actualData[3] = 0x00;
        actualData[4] = 0x00;
        actualData[5] = 0x00;
        actualData[6] = 5;
        actualData[7] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        actualData[8] = 0x00;
        actualData[9] = 0x00;
        actualData[10] = 0x00;
        actualData[11] = 0x00;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter(
                new ListOf32BitServiceSolicitationUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[12];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 5;
        expectData[7] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter(
                new ListOf32BitServiceSolicitationUUIDsAndroid(expectData, 0, expectData.length / 2 - 1)
                , new ListOf32BitServiceSolicitationUUIDsAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_201() {
        byte[] expectData = new byte[10];
        expectData[0] = 9;
        expectData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;

        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        actualData[2] = 0x00;
        actualData[3] = 0x00;
        actualData[4] = 0x00;
        actualData[5] = 0x00;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter(
                new ListOf32BitServiceSolicitationUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_202() {
        byte[] actualData = new byte[10];
        actualData[0] = 9;
        actualData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        actualData[2] = 0x00;
        actualData[3] = 0x00;
        actualData[4] = 0x00;
        actualData[5] = 0x00;
        actualData[6] = 0x00;
        actualData[7] = 0x00;
        actualData[8] = 0x00;
        actualData[9] = 0x00;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter(
                new ListOf32BitServiceSolicitationUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_203() {
        byte[] expectData = new byte[10];
        expectData[0] = 9;
        expectData[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ListOf32BitServiceSolicitationUUIDsFilter(
                new ListOf32BitServiceSolicitationUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
