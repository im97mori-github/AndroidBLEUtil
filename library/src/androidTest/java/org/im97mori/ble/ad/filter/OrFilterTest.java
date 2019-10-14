package org.im97mori.ble.ad.filter;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class OrFilterTest {

    @Test
    public void test_001() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        };
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter<>(new AdvertisingDataFilter[]{filter});
        assertFalse(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_002() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return true;
            }
        };
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter(new AdvertisingDataFilter[]{filter});
        assertTrue(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_003() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        };
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        };
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter(new AdvertisingDataFilter[]{filter1, filter2});
        assertFalse(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_004() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return true;
            }
        };
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        };
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter(new AdvertisingDataFilter[]{filter1, filter2});
        assertTrue(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_005() {
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return true;
            }
        };
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return true;
            }
        };
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter(new AdvertisingDataFilter[]{filter1, filter2});
        assertTrue(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }

    @Test
    public void test_006() {
        OrFilter<AdvertisingDataParser.AdvertisingDataParseResult> orFilter = new OrFilter(new AdvertisingDataFilter[]{});
        assertTrue(orFilter.isMatched(new AdvertisingDataParser.Builder(true).build().parse(new byte[0])));
    }
}
