package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.PeripheralConnectionIntervalRangeAndroid;
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
public class PeripheralConnectionIntervalRangeTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeripheralConnectionIntervalRangeFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        expectData[2] = (byte) 0xff;
        expectData[3] = (byte) 0xff;
        expectData[4] = (byte) 0xff;
        expectData[5] = (byte) 0xff;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeripheralConnectionIntervalRangeFilter(PeripheralConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        actualData[2] = (byte) 0xff;
        actualData[3] = (byte) 0xff;
        actualData[4] = (byte) 0xff;
        actualData[5] = (byte) 0xff;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeripheralConnectionIntervalRangeFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        expectData[2] = (byte) 0xff;
        expectData[3] = (byte) 0xff;
        expectData[4] = (byte) 0xff;
        expectData[5] = (byte) 0xff;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeripheralConnectionIntervalRangeFilter(PeripheralConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[12];
        expectData[0] = 5;
        expectData[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        expectData[2] = (byte) 0xff;
        expectData[3] = (byte) 0xff;
        expectData[4] = (byte) 0xff;
        expectData[5] = (byte) 0xff;
        expectData[6] = 5;
        expectData[7] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        expectData[8] = (byte) 0xff;
        expectData[9] = (byte) 0xff;
        expectData[10] = (byte) 0xff;
        expectData[11] = (byte) 0xff;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeripheralConnectionIntervalRangeFilter(
                new PeripheralConnectionIntervalRangeAndroid(expectData, 0, expectData.length / 2 - 1)
                , new PeripheralConnectionIntervalRangeAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[12];
        actualData[0] = 5;
        actualData[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        actualData[2] = (byte) 0xff;
        actualData[3] = (byte) 0xff;
        actualData[4] = (byte) 0xff;
        actualData[5] = (byte) 0xff;
        actualData[6] = 5;
        actualData[7] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        actualData[8] = (byte) 0xff;
        actualData[9] = (byte) 0xff;
        actualData[10] = (byte) 0xff;
        actualData[11] = (byte) 0xff;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeripheralConnectionIntervalRangeFilter(
                new PeripheralConnectionIntervalRangeAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[12];
        expectData[0] = 5;
        expectData[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        expectData[2] = (byte) 0xff;
        expectData[3] = (byte) 0xff;
        expectData[4] = (byte) 0xff;
        expectData[5] = (byte) 0xff;
        expectData[6] = 5;
        expectData[7] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        expectData[8] = (byte) 0xff;
        expectData[9] = (byte) 0xff;
        expectData[10] = (byte) 0xff;
        expectData[11] = (byte) 0xff;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new PeripheralConnectionIntervalRangeFilter(
                new PeripheralConnectionIntervalRangeAndroid(expectData, 0, expectData.length / 2 - 1)
                , new PeripheralConnectionIntervalRangeAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
