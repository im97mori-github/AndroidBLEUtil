package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.UniformRsourceIdentifierAndroid;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniformRsourceIdentifierFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformRsourceIdentifierFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] expectData = new byte[utf8data.length + 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformRsourceIdentifierFilter(UniformRsourceIdentifierAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] actualData = new byte[utf8data.length + 2];
        actualData[0] = (byte) (utf8data.length + 1);
        actualData[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, actualData, 2, utf8data.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformRsourceIdentifierFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] expectData = new byte[utf8data.length + 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformRsourceIdentifierFilter(UniformRsourceIdentifierAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] expectData = new byte[(utf8data.length + 2) * 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);
        System.arraycopy(expectData, 0, expectData, utf8data.length + 2, expectData.length / 2);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformRsourceIdentifierFilter(
                new UniformRsourceIdentifierAndroid(expectData, 0, expectData.length / 2 - 1)
                , new UniformRsourceIdentifierAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] actualData = new byte[(utf8data.length + 2) * 2];
        actualData[0] = (byte) (utf8data.length + 1);
        actualData[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, actualData, 2, utf8data.length);
        System.arraycopy(actualData, 0, actualData, utf8data.length + 2, actualData.length / 2);

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformRsourceIdentifierFilter(
                new UniformRsourceIdentifierAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] expectData = new byte[(utf8data.length + 2) * 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);
        System.arraycopy(expectData, 0, expectData, utf8data.length + 2, expectData.length / 2);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformRsourceIdentifierFilter(
                new UniformRsourceIdentifierAndroid(expectData, 0, expectData.length / 2 - 1)
                , new UniformRsourceIdentifierAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
