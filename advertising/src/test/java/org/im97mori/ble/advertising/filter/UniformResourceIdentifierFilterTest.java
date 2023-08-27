package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.URI_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.UniformResourceIdentifierAndroid;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class UniformResourceIdentifierFilterTest extends TestBase {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformResourceIdentifierFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] expectData = new byte[utf8data.length + 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformResourceIdentifierFilter(UniformResourceIdentifierAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] actualData = new byte[utf8data.length + 2];
        actualData[0] = (byte) (utf8data.length + 1);
        actualData[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, actualData, 2, utf8data.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformResourceIdentifierFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] expectData = new byte[utf8data.length + 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformResourceIdentifierFilter(UniformResourceIdentifierAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] expectData = new byte[(utf8data.length + 2) * 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);
        System.arraycopy(expectData, 0, expectData, utf8data.length + 2, expectData.length / 2);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformResourceIdentifierFilter(
                new UniformResourceIdentifierAndroid(expectData, 0, expectData.length / 2 - 1)
                , new UniformResourceIdentifierAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] actualData = new byte[(utf8data.length + 2) * 2];
        actualData[0] = (byte) (utf8data.length + 1);
        actualData[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, actualData, 2, utf8data.length);
        System.arraycopy(actualData, 0, actualData, utf8data.length + 2, actualData.length / 2);

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformResourceIdentifierFilter(
                new UniformResourceIdentifierAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] expectData = new byte[(utf8data.length + 2) * 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);
        System.arraycopy(expectData, 0, expectData, utf8data.length + 2, expectData.length / 2);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new UniformResourceIdentifierFilter(
                new UniformResourceIdentifierAndroid(expectData, 0, expectData.length / 2 - 1)
                , new UniformResourceIdentifierAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
