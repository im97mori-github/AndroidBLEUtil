package org.im97mori.ble.ad.filter;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.Appearance;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.im97mori.ble.BLEConstants.APPEARANCE_VALUE_MAP;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_APPEARANCE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ApearanceFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AppearanceFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = DATA_TYPE_APPEARANCE;
        expectData[2] = (byte) (key & 0x00ff);
        expectData[3] = (byte) ((key >> 8) & 0x00ff);

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AppearanceFilter(Appearance.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] actualData = new byte[4];
        actualData[0] = 3;
        actualData[1] = DATA_TYPE_APPEARANCE;
        actualData[2] = (byte) (key & 0x00ff);
        actualData[3] = (byte) ((key >> 8) & 0x00ff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AppearanceFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = DATA_TYPE_APPEARANCE;
        expectData[2] = (byte) (key & 0x00ff);
        expectData[3] = (byte) ((key >> 8) & 0x00ff);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AppearanceFilter(Appearance.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }
}
