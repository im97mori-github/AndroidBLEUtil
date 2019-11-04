package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ChannelMapUpdateIndication;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChannelMapUpdateIndicationTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ChannelMapUpdateIndicationFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[9];
        expectData[0] = 8;
        expectData[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        expectData[2] = (byte) 0b11111110;
        expectData[3] = (byte) 0b11111111;
        expectData[4] = (byte) 0b11111111;
        expectData[5] = (byte) 0b11111111;
        expectData[6] = (byte) 0b11111111;
        expectData[7] = 0b00000000;
        expectData[8] = 0b00000000;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ChannelMapUpdateIndicationFilter(ChannelMapUpdateIndication.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[9];
        actualData[0] = 8;
        actualData[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        actualData[2] = (byte) 0b11111110;
        actualData[3] = (byte) 0b11111111;
        actualData[4] = (byte) 0b11111111;
        actualData[5] = (byte) 0b11111111;
        actualData[6] = (byte) 0b11111111;
        actualData[7] = 0b00000000;
        actualData[8] = 0b00000000;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ChannelMapUpdateIndicationFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[9];
        expectData[0] = 8;
        expectData[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        expectData[2] = (byte) 0b11111110;
        expectData[3] = (byte) 0b11111111;
        expectData[4] = (byte) 0b11111111;
        expectData[5] = (byte) 0b11111111;
        expectData[6] = (byte) 0b11111111;
        expectData[7] = 0b00000000;
        expectData[8] = 0b00000000;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ChannelMapUpdateIndicationFilter(ChannelMapUpdateIndication.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

}
