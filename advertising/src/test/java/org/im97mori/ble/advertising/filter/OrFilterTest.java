package org.im97mori.ble.advertising.filter;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class OrFilterTest {

    @Test
    public void test_001() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = advertisingDataParseResult -> false;
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter<>(filter);
        assertFalse(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_002() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = advertisingDataParseResult -> true;
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter<>(filter);
        assertTrue(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_003() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = advertisingDataParseResult -> false;
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = advertisingDataParseResult -> false;
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter<>(filter1, filter2);
        assertFalse(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_004() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = advertisingDataParseResult -> true;
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = advertisingDataParseResult -> false;
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter<>(filter1, filter2);
        assertTrue(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_005() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = advertisingDataParseResult -> true;
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = advertisingDataParseResult -> true;
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter<>(filter1, filter2);
        assertTrue(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_006() {
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter<>();
        assertTrue(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }
}
