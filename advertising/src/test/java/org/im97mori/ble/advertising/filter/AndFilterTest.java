package org.im97mori.ble.advertising.filter;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class AndFilterTest extends TestBase {

    @Test
    public void test_001() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = advertisingDataParseResult -> false;
        AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> andFilter = new AndFilter<>(filter);
        assertFalse(andFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_002() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = advertisingDataParseResult -> true;
        AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> andFilter = new AndFilter<>(filter);
        assertTrue(andFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_003() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = advertisingDataParseResult -> false;
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = advertisingDataParseResult -> false;
        AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> andFilter = new AndFilter<>(filter1, filter2);
        assertFalse(andFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_004() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = advertisingDataParseResult -> true;
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = advertisingDataParseResult -> false;
        AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> andFilter = new AndFilter<>(filter1, filter2);
        assertFalse(andFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_005() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = advertisingDataParseResult -> true;
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = advertisingDataParseResult -> true;
        AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> andFilter = new AndFilter<>(filter1, filter2);
        assertTrue(andFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_006() {
        AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> andFilter = new AndFilter<>();
        assertTrue(andFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }
}
