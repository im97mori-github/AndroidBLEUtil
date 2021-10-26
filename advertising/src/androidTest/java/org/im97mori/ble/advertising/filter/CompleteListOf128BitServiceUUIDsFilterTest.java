package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDsAndroid;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompleteListOf128BitServiceUUIDsFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[18];
        expectData[0] = 17;
        expectData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;
        expectData[12] = 0x00;
        expectData[13] = 0x00;
        expectData[14] = 0x00;
        expectData[15] = 0x00;
        expectData[16] = 0x00;
        expectData[17] = 0x00;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter(CompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[18];
        actualData[0] = 17;
        actualData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[2] = 0x00;
        actualData[3] = 0x00;
        actualData[4] = 0x00;
        actualData[5] = 0x00;
        actualData[6] = 0x00;
        actualData[7] = 0x00;
        actualData[8] = 0x00;
        actualData[9] = 0x00;
        actualData[10] = 0x00;
        actualData[11] = 0x00;
        actualData[12] = 0x00;
        actualData[13] = 0x00;
        actualData[14] = 0x00;
        actualData[15] = 0x00;
        actualData[16] = 0x00;
        actualData[17] = 0x00;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[18];
        expectData[0] = 17;
        expectData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;
        expectData[12] = 0x00;
        expectData[13] = 0x00;
        expectData[14] = 0x00;
        expectData[15] = 0x00;
        expectData[16] = 0x00;
        expectData[17] = 0x00;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter(CompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[36];
        expectData[0] = 17;
        expectData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;
        expectData[12] = 0x00;
        expectData[13] = 0x00;
        expectData[14] = 0x00;
        expectData[15] = 0x00;
        expectData[16] = 0x00;
        expectData[17] = 0x00;
        expectData[18] = 17;
        expectData[19] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[20] = 0x00;
        expectData[21] = 0x00;
        expectData[22] = 0x00;
        expectData[23] = 0x00;
        expectData[24] = 0x00;
        expectData[25] = 0x00;
        expectData[26] = 0x00;
        expectData[27] = 0x00;
        expectData[28] = 0x00;
        expectData[29] = 0x00;
        expectData[30] = 0x00;
        expectData[31] = 0x00;
        expectData[32] = 0x00;
        expectData[33] = 0x00;
        expectData[34] = 0x00;
        expectData[35] = 0x00;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter(
                new CompleteListOf128BitServiceUUIDsAndroid(expectData, 0, expectData.length / 2 - 1)
                , new CompleteListOf128BitServiceUUIDsAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[36];
        actualData[0] = 17;
        actualData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[2] = 0x00;
        actualData[3] = 0x00;
        actualData[4] = 0x00;
        actualData[5] = 0x00;
        actualData[6] = 0x00;
        actualData[7] = 0x00;
        actualData[8] = 0x00;
        actualData[9] = 0x00;
        actualData[10] = 0x00;
        actualData[11] = 0x00;
        actualData[12] = 0x00;
        actualData[13] = 0x00;
        actualData[14] = 0x00;
        actualData[15] = 0x00;
        actualData[16] = 0x00;
        actualData[17] = 0x00;
        actualData[18] = 17;
        actualData[19] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[20] = 0x00;
        actualData[21] = 0x00;
        actualData[22] = 0x00;
        actualData[23] = 0x00;
        actualData[24] = 0x00;
        actualData[25] = 0x00;
        actualData[26] = 0x00;
        actualData[27] = 0x00;
        actualData[28] = 0x00;
        actualData[29] = 0x00;
        actualData[30] = 0x00;
        actualData[31] = 0x00;
        actualData[32] = 0x00;
        actualData[33] = 0x00;
        actualData[34] = 0x00;
        actualData[35] = 0x00;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter(
                new CompleteListOf128BitServiceUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[36];
        expectData[0] = 17;
        expectData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;
        expectData[12] = 0x00;
        expectData[13] = 0x00;
        expectData[14] = 0x00;
        expectData[15] = 0x00;
        expectData[16] = 0x00;
        expectData[17] = 0x00;
        expectData[18] = 17;
        expectData[19] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[20] = 0x00;
        expectData[21] = 0x00;
        expectData[22] = 0x00;
        expectData[23] = 0x00;
        expectData[24] = 0x00;
        expectData[25] = 0x00;
        expectData[26] = 0x00;
        expectData[27] = 0x00;
        expectData[28] = 0x00;
        expectData[29] = 0x00;
        expectData[30] = 0x00;
        expectData[31] = 0x00;
        expectData[32] = 0x00;
        expectData[33] = 0x00;
        expectData[34] = 0x00;
        expectData[35] = 0x00;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter(
                new CompleteListOf128BitServiceUUIDsAndroid(expectData, 0, expectData.length / 2 - 1)
                , new CompleteListOf128BitServiceUUIDsAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_201() {
        byte[] expectData = new byte[34];
        expectData[0] = 33;
        expectData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;
        expectData[12] = 0x00;
        expectData[13] = 0x00;
        expectData[14] = 0x00;
        expectData[15] = 0x00;
        expectData[16] = 0x00;
        expectData[17] = 0x00;
        expectData[18] = 0x00;
        expectData[19] = 0x00;
        expectData[20] = 0x00;
        expectData[21] = 0x00;
        expectData[22] = 0x00;
        expectData[23] = 0x00;
        expectData[24] = 0x00;
        expectData[25] = 0x00;
        expectData[26] = 0x00;
        expectData[27] = 0x00;
        expectData[28] = 0x00;
        expectData[29] = 0x00;
        expectData[30] = 0x00;
        expectData[31] = 0x00;
        expectData[32] = 0x00;
        expectData[33] = 0x00;

        byte[] actualData = new byte[18];
        actualData[0] = 16;
        actualData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[2] = 0x00;
        actualData[3] = 0x00;
        actualData[4] = 0x00;
        actualData[5] = 0x00;
        actualData[6] = 0x00;
        actualData[7] = 0x00;
        actualData[8] = 0x00;
        actualData[9] = 0x00;
        actualData[10] = 0x00;
        actualData[11] = 0x00;
        actualData[12] = 0x00;
        actualData[13] = 0x00;
        actualData[14] = 0x00;
        actualData[15] = 0x00;
        actualData[16] = 0x00;
        actualData[17] = 0x00;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter(
                new CompleteListOf128BitServiceUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_202() {
        byte[] actualData = new byte[34];
        actualData[0] = 33;
        actualData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        actualData[2] = 0x00;
        actualData[3] = 0x00;
        actualData[4] = 0x00;
        actualData[5] = 0x00;
        actualData[6] = 0x00;
        actualData[7] = 0x00;
        actualData[8] = 0x00;
        actualData[9] = 0x00;
        actualData[10] = 0x00;
        actualData[11] = 0x00;
        actualData[12] = 0x00;
        actualData[13] = 0x00;
        actualData[14] = 0x00;
        actualData[15] = 0x00;
        actualData[16] = 0x00;
        actualData[17] = 0x00;
        actualData[18] = 0x00;
        actualData[19] = 0x00;
        actualData[20] = 0x00;
        actualData[21] = 0x00;
        actualData[22] = 0x00;
        actualData[23] = 0x00;
        actualData[24] = 0x00;
        actualData[25] = 0x00;
        actualData[26] = 0x00;
        actualData[27] = 0x00;
        actualData[28] = 0x00;
        actualData[29] = 0x00;
        actualData[30] = 0x00;
        actualData[31] = 0x00;
        actualData[32] = 0x00;
        actualData[33] = 0x00;

        byte[] expectData = new byte[18];
        expectData[0] = 16;
        expectData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;
        expectData[12] = 0x00;
        expectData[13] = 0x00;
        expectData[14] = 0x00;
        expectData[15] = 0x00;
        expectData[16] = 0x00;
        expectData[17] = 0x00;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter(
                new CompleteListOf128BitServiceUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_203() {
        byte[] expectData = new byte[34];
        expectData[0] = 33;
        expectData[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        expectData[2] = 0x00;
        expectData[3] = 0x00;
        expectData[4] = 0x00;
        expectData[5] = 0x00;
        expectData[6] = 0x00;
        expectData[7] = 0x00;
        expectData[8] = 0x00;
        expectData[9] = 0x00;
        expectData[10] = 0x00;
        expectData[11] = 0x00;
        expectData[12] = 0x00;
        expectData[13] = 0x00;
        expectData[14] = 0x00;
        expectData[15] = 0x00;
        expectData[16] = 0x00;
        expectData[17] = 0x00;
        expectData[18] = 0x00;
        expectData[19] = 0x00;
        expectData[20] = 0x00;
        expectData[21] = 0x00;
        expectData[22] = 0x00;
        expectData[23] = 0x00;
        expectData[24] = 0x00;
        expectData[25] = 0x00;
        expectData[26] = 0x00;
        expectData[27] = 0x00;
        expectData[28] = 0x00;
        expectData[29] = 0x00;
        expectData[30] = 0x00;
        expectData[31] = 0x00;
        expectData[32] = 0x00;
        expectData[33] = 0x00;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteListOf128BitServiceUUIDsFilter(
                new CompleteListOf128BitServiceUUIDsAndroid(expectData, 0, expectData.length - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
