package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.TX_POWER_LEVEL_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.TxPowerLevelAndroid;
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
public class TxPowerLevelFilterTest extends TestBase {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[3];
        expectData[0] = 2;
        expectData[1] = TX_POWER_LEVEL_DATA_TYPE;
        expectData[2] = -127;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(TxPowerLevelAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[3];
        actualData[0] = 2;
        actualData[1] = TX_POWER_LEVEL_DATA_TYPE;
        actualData[2] = -127;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[3];
        expectData[0] = 2;
        expectData[1] = TX_POWER_LEVEL_DATA_TYPE;
        expectData[2] = -127;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(TxPowerLevelAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[6];
        expectData[0] = 2;
        expectData[1] = TX_POWER_LEVEL_DATA_TYPE;
        expectData[2] = -127;
        expectData[3] = 2;
        expectData[4] = TX_POWER_LEVEL_DATA_TYPE;
        expectData[5] = -127;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(
                new TxPowerLevelAndroid(expectData, 0, expectData.length / 2 - 1)
                , new TxPowerLevelAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[6];
        actualData[0] = 2;
        actualData[1] = TX_POWER_LEVEL_DATA_TYPE;
        actualData[2] = -127;
        actualData[3] = 2;
        actualData[4] = TX_POWER_LEVEL_DATA_TYPE;
        actualData[5] = -127;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(
                new TxPowerLevelAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[6];
        expectData[0] = 2;
        expectData[1] = TX_POWER_LEVEL_DATA_TYPE;
        expectData[2] = -127;
        expectData[3] = 2;
        expectData[4] = TX_POWER_LEVEL_DATA_TYPE;
        expectData[5] = -127;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TxPowerLevelFilter(
                new TxPowerLevelAndroid(expectData, 0, expectData.length / 2 - 1)
                , new TxPowerLevelAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
