package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.PeriodicAdvertisingResponseTimingInformationAndroid;
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
public class PeriodicAdvertisingResponseTimingInformationFilterTest extends TestBase {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeriodicAdvertisingResponseTimingInformationFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[10];
        expectData[0] = 9;
        expectData[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = 4;
        expectData[6] = 0x01;
        expectData[7] = 0x06;
        expectData[8] = 0x01;
        expectData[9] = 0x02;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeriodicAdvertisingResponseTimingInformationFilter(PeriodicAdvertisingResponseTimingInformationAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[10];
        actualData[0] = 9;
        actualData[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        actualData[2] = 1;
        actualData[3] = 2;
        actualData[4] = 3;
        actualData[5] = 4;
        actualData[6] = 0x01;
        actualData[7] = 0x06;
        actualData[8] = 0x01;
        actualData[9] = 0x02;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeriodicAdvertisingResponseTimingInformationFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[10];
        expectData[0] = 9;
        expectData[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = 4;
        expectData[6] = 0x01;
        expectData[7] = 0x06;
        expectData[8] = 0x01;
        expectData[9] = 0x02;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeriodicAdvertisingResponseTimingInformationFilter(PeriodicAdvertisingResponseTimingInformationAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[20];
        expectData[0] = 9;
        expectData[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = 4;
        expectData[6] = 0x01;
        expectData[7] = 0x06;
        expectData[8] = 0x01;
        expectData[9] = 0x02;
        expectData[10] = 9;
        expectData[11] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        expectData[12] = 1;
        expectData[13] = 2;
        expectData[14] = 3;
        expectData[15] = 4;
        expectData[16] = 0x01;
        expectData[17] = 0x06;
        expectData[18] = 0x01;
        expectData[19] = 0x02;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeriodicAdvertisingResponseTimingInformationFilter(
                new PeriodicAdvertisingResponseTimingInformationAndroid(expectData, 0, expectData.length / 2 - 1)
                , new PeriodicAdvertisingResponseTimingInformationAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[20];
        actualData[0] = 9;
        actualData[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        actualData[2] = 1;
        actualData[3] = 2;
        actualData[4] = 3;
        actualData[5] = 4;
        actualData[6] = 0x01;
        actualData[7] = 0x06;
        actualData[8] = 0x01;
        actualData[9] = 0x02;
        actualData[10] = 9;
        actualData[11] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        actualData[12] = 1;
        actualData[13] = 2;
        actualData[14] = 3;
        actualData[15] = 4;
        actualData[16] = 0x01;
        actualData[17] = 0x06;
        actualData[18] = 0x01;
        actualData[19] = 0x02;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeriodicAdvertisingResponseTimingInformationFilter(
                new PeriodicAdvertisingResponseTimingInformationAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[20];
        expectData[0] = 9;
        expectData[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = 4;
        expectData[6] = 0x01;
        expectData[7] = 0x06;
        expectData[8] = 0x01;
        expectData[9] = 0x02;
        expectData[10] = 9;
        expectData[11] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        expectData[12] = 1;
        expectData[13] = 2;
        expectData[14] = 3;
        expectData[15] = 4;
        expectData[16] = 0x01;
        expectData[17] = 0x06;
        expectData[18] = 0x01;
        expectData[19] = 0x02;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeriodicAdvertisingResponseTimingInformationFilter(
                new PeriodicAdvertisingResponseTimingInformationAndroid(expectData, 0, expectData.length / 2 - 1)
                , new PeriodicAdvertisingResponseTimingInformationAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
