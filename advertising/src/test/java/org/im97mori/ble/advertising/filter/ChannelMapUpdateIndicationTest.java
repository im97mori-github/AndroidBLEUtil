package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ChannelMapUpdateIndicationAndroid;
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
public class ChannelMapUpdateIndicationTest extends TestBase {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ChannelMapUpdateIndicationFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[9];
        expectData[0] = 8;
        expectData[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        expectData[2] = (byte) 0b11111110;
        expectData[3] = (byte) 0b11111111;
        expectData[4] = (byte) 0b11111111;
        expectData[5] = (byte) 0b11111111;
        expectData[6] = (byte) 0b11111111;
        expectData[7] = 0b00000000;
        expectData[8] = 0b00000000;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ChannelMapUpdateIndicationFilter(ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[9];
        actualData[0] = 8;
        actualData[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        actualData[2] = (byte) 0b11111110;
        actualData[3] = (byte) 0b11111111;
        actualData[4] = (byte) 0b11111111;
        actualData[5] = (byte) 0b11111111;
        actualData[6] = (byte) 0b11111111;
        actualData[7] = 0b00000000;
        actualData[8] = 0b00000000;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ChannelMapUpdateIndicationFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[9];
        expectData[0] = 8;
        expectData[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        expectData[2] = (byte) 0b11111110;
        expectData[3] = (byte) 0b11111111;
        expectData[4] = (byte) 0b11111111;
        expectData[5] = (byte) 0b11111111;
        expectData[6] = (byte) 0b11111111;
        expectData[7] = 0b00000000;
        expectData[8] = 0b00000000;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ChannelMapUpdateIndicationFilter(ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

}
