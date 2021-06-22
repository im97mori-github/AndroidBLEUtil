package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.TxPowerLevelAndroid;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_TX_POWER_LEVEL;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TxPowerLevelFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[3];
        expectData[0] = 2;
        expectData[1] = DATA_TYPE_TX_POWER_LEVEL;
        expectData[2] = -127;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(TxPowerLevelAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[3];
        actualData[0] = 2;
        actualData[1] = DATA_TYPE_TX_POWER_LEVEL;
        actualData[2] = -127;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[3];
        expectData[0] = 2;
        expectData[1] = DATA_TYPE_TX_POWER_LEVEL;
        expectData[2] = -127;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(TxPowerLevelAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[6];
        expectData[0] = 2;
        expectData[1] = DATA_TYPE_TX_POWER_LEVEL;
        expectData[2] = -127;
        expectData[3] = 2;
        expectData[4] = DATA_TYPE_TX_POWER_LEVEL;
        expectData[5] = -127;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(
                new TxPowerLevelAndroid(expectData, 0, expectData.length / 2 - 1)
                , new TxPowerLevelAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[6];
        actualData[0] = 2;
        actualData[1] = DATA_TYPE_TX_POWER_LEVEL;
        actualData[2] = -127;
        actualData[3] = 2;
        actualData[4] = DATA_TYPE_TX_POWER_LEVEL;
        actualData[5] = -127;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(
                new TxPowerLevelAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[6];
        expectData[0] = 2;
        expectData[1] = DATA_TYPE_TX_POWER_LEVEL;
        expectData[2] = -127;
        expectData[3] = 2;
        expectData[4] = DATA_TYPE_TX_POWER_LEVEL;
        expectData[5] = -127;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(
                new TxPowerLevelAndroid(expectData, 0, expectData.length / 2 - 1)
                , new TxPowerLevelAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
