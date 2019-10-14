package org.im97mori.ble.ad.filter;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.CompleteLocalName;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LOCAL_NAME;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompleteLocalNameFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteLocalNameFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] expectData = new byte[utf8data.length + 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteLocalNameFilter(CompleteLocalName.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] actualData = new byte[utf8data.length + 2];
        actualData[0] = (byte) (utf8data.length + 1);
        actualData[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, actualData, 2, utf8data.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteLocalNameFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] expectData = new byte[utf8data.length + 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteLocalNameFilter(CompleteLocalName.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }
}
