package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.IncompleteListOf16BitServiceUUIDsAndroid;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IncompleteListOf16BitServiceUUIDsFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter(IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[4];
        actualData[0] = 3;
        actualData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[2] = 0;
        actualData[3] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter(IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[8];
        expectData[0] = 3;
        expectData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;
        expectData[4] = 3;
        expectData[5] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[6] = 0;
        expectData[7] = 0;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter(
                new IncompleteListOf16BitServiceUUIDsAndroid(expectData, 0, expectData.length / 2 - 1)
                , new IncompleteListOf16BitServiceUUIDsAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[8];
        actualData[0] = 3;
        actualData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[2] = 0;
        actualData[3] = 0;
        actualData[4] = 3;
        actualData[5] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[6] = 0;
        actualData[7] = 0;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter(
                new IncompleteListOf16BitServiceUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[8];
        expectData[0] = 3;
        expectData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;
        expectData[4] = 3;
        expectData[5] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[6] = 0;
        expectData[7] = 0;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter(
                new IncompleteListOf16BitServiceUUIDsAndroid(expectData, 0, expectData.length / 2 - 1)
                , new IncompleteListOf16BitServiceUUIDsAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_201() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;
        expectData[4] = 0;
        expectData[5] = 0;

        byte[] actualData = new byte[4];
        actualData[0] = 3;
        actualData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[2] = 0;
        actualData[3] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter(
                new IncompleteListOf16BitServiceUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_202() {
        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[2] = 0;
        actualData[3] = 0;
        actualData[4] = 0;
        actualData[5] = 0;

        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter(
                new IncompleteListOf16BitServiceUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_203() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;
        expectData[4] = 0;
        expectData[5] = 0;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IncompleteListOf16BitServiceUUIDsFilter(
                new IncompleteListOf16BitServiceUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
