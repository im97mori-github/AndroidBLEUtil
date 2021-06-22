package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.SlaveConnectionIntervalRangeAndroid;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SlaveConnectionIntervalRangeTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new SlaveConnectionIntervalRangeFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        expectData[2] = (byte) 0xff;
        expectData[3] = (byte) 0xff;
        expectData[4] = (byte) 0xff;
        expectData[5] = (byte) 0xff;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new SlaveConnectionIntervalRangeFilter(SlaveConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        actualData[2] = (byte) 0xff;
        actualData[3] = (byte) 0xff;
        actualData[4] = (byte) 0xff;
        actualData[5] = (byte) 0xff;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new SlaveConnectionIntervalRangeFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        expectData[2] = (byte) 0xff;
        expectData[3] = (byte) 0xff;
        expectData[4] = (byte) 0xff;
        expectData[5] = (byte) 0xff;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new SlaveConnectionIntervalRangeFilter(SlaveConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[12];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        expectData[2] = (byte) 0xff;
        expectData[3] = (byte) 0xff;
        expectData[4] = (byte) 0xff;
        expectData[5] = (byte) 0xff;
        expectData[6] = 5;
        expectData[7] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        expectData[8] = (byte) 0xff;
        expectData[9] = (byte) 0xff;
        expectData[10] = (byte) 0xff;
        expectData[11] = (byte) 0xff;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new SlaveConnectionIntervalRangeFilter(
                new SlaveConnectionIntervalRangeAndroid(expectData, 0, expectData.length / 2 - 1)
                , new SlaveConnectionIntervalRangeAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[12];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        actualData[2] = (byte) 0xff;
        actualData[3] = (byte) 0xff;
        actualData[4] = (byte) 0xff;
        actualData[5] = (byte) 0xff;
        actualData[6] = 5;
        actualData[7] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        actualData[8] = (byte) 0xff;
        actualData[9] = (byte) 0xff;
        actualData[10] = (byte) 0xff;
        actualData[11] = (byte) 0xff;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new SlaveConnectionIntervalRangeFilter(
                new SlaveConnectionIntervalRangeAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[12];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        expectData[2] = (byte) 0xff;
        expectData[3] = (byte) 0xff;
        expectData[4] = (byte) 0xff;
        expectData[5] = (byte) 0xff;
        expectData[6] = 5;
        expectData[7] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        expectData[8] = (byte) 0xff;
        expectData[9] = (byte) 0xff;
        expectData[10] = (byte) 0xff;
        expectData[11] = (byte) 0xff;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new SlaveConnectionIntervalRangeFilter(
                new SlaveConnectionIntervalRangeAndroid(expectData, 0, expectData.length / 2 - 1)
                , new SlaveConnectionIntervalRangeAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
