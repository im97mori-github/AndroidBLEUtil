package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.ADVERTISING_INTERVAL_LONG_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.AdvertisingIntervalLongAndroid;
import org.junit.Test;

import java.util.Arrays;

public class AdvertisingIntervalLongFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AdvertisingIntervalLongFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[5];
        expectData[0] = 4;
        expectData[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;
        expectData[4] = 0;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AdvertisingIntervalLongFilter(AdvertisingIntervalLongAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[5];
        actualData[0] = 4;
        actualData[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        actualData[2] = 0;
        actualData[3] = 0;
        actualData[4] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AdvertisingIntervalLongFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[5];
        expectData[0] = 4;
        expectData[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        expectData[2] = 0;
        expectData[3] = 0;
        expectData[4] = 0;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AdvertisingIntervalLongFilter(AdvertisingIntervalLongAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }
}
