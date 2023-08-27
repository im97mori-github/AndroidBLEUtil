package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.APPEARANCE_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.AppearanceAndroid;
import org.im97mori.ble.constants.AppearanceValues;
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
public class AppearanceFilterTest extends TestBase {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AppearanceFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = APPEARANCE_DATA_TYPE;
        expectData[2] = (byte) (key & 0x00ff);
        expectData[3] = (byte) ((key >> 8) & 0x00ff);

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AppearanceFilter(AppearanceAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] actualData = new byte[4];
        actualData[0] = 3;
        actualData[1] = APPEARANCE_DATA_TYPE;
        actualData[2] = (byte) (key & 0x00ff);
        actualData[3] = (byte) ((key >> 8) & 0x00ff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AppearanceFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = APPEARANCE_DATA_TYPE;
        expectData[2] = (byte) (key & 0x00ff);
        expectData[3] = (byte) ((key >> 8) & 0x00ff);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AppearanceFilter(AppearanceAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }
}
