package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.LeSupportedFeaturesAndroid;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_LE_SUPPORTED_FEATURES;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeSupportedFeaturesTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new LeSupportedFeaturesFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[3];
        expectData[0] = 2;
        expectData[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        expectData[2] = 0b00000001;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new LeSupportedFeaturesFilter(LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[3];
        actualData[0] = 2;
        actualData[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        actualData[2] = 0b00000001;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new LeSupportedFeaturesFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[3];
        expectData[0] = 2;
        expectData[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        expectData[2] = 0b00000001;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new LeSupportedFeaturesFilter(LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

}
