package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.COMPLETE_LOCAL_NAME_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.CompleteLocalNameAndroid;
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
public class CompleteLocalNameFilterTest extends TestBase {

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
        byte[] utf8data = name.getBytes();
        byte[] expectData = new byte[utf8data.length + 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteLocalNameFilter(CompleteLocalNameAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] actualData = new byte[utf8data.length + 2];
        actualData[0] = (byte) (utf8data.length + 1);
        actualData[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        System.arraycopy(utf8data, 0, actualData, 2, utf8data.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteLocalNameFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] expectData = new byte[utf8data.length + 2];
        expectData[0] = (byte) (utf8data.length + 1);
        expectData[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        System.arraycopy(utf8data, 0, expectData, 2, utf8data.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new CompleteLocalNameFilter(CompleteLocalNameAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }
}
