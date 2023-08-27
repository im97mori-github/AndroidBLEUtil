package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.EncryptedDataAndroid;
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
public class EncryptedDataFilterTest extends TestBase {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new EncryptedDataFilter();
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[12];
        expectData[0] = 11;
        expectData[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = 4;
        expectData[6] = 5;
        expectData[7] = 6;
        expectData[8] = 7;
        expectData[9] = 8;
        expectData[10] = 9;
        expectData[11] = 10;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new EncryptedDataFilter(EncryptedDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[12];
        actualData[0] = 11;
        actualData[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        actualData[2] = 1;
        actualData[3] = 2;
        actualData[4] = 3;
        actualData[5] = 4;
        actualData[6] = 5;
        actualData[7] = 6;
        actualData[8] = 7;
        actualData[9] = 8;
        actualData[10] = 9;
        actualData[11] = 10;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new EncryptedDataFilter();
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[12];
        expectData[0] = 11;
        expectData[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = 4;
        expectData[6] = 5;
        expectData[7] = 6;
        expectData[8] = 7;
        expectData[9] = 8;
        expectData[10] = 9;
        expectData[11] = 10;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new EncryptedDataFilter(EncryptedDataAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[24];
        expectData[0] = 11;
        expectData[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = 4;
        expectData[6] = 5;
        expectData[7] = 6;
        expectData[8] = 7;
        expectData[9] = 8;
        expectData[10] = 9;
        expectData[11] = 10;
        expectData[12] = 11;
        expectData[13] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        expectData[14] = 1;
        expectData[15] = 2;
        expectData[16] = 3;
        expectData[17] = 4;
        expectData[18] = 5;
        expectData[19] = 6;
        expectData[20] = 7;
        expectData[21] = 8;
        expectData[22] = 9;
        expectData[23] = 10;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new EncryptedDataFilter(
                new EncryptedDataAndroid(expectData, 0, expectData.length / 2 - 1)
                , new EncryptedDataAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[24];
        actualData[0] = 11;
        actualData[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        actualData[2] = 1;
        actualData[3] = 2;
        actualData[4] = 3;
        actualData[5] = 4;
        actualData[6] = 5;
        actualData[7] = 6;
        actualData[8] = 7;
        actualData[9] = 8;
        actualData[10] = 9;
        actualData[11] = 10;
        actualData[12] = 11;
        actualData[13] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        actualData[14] = 1;
        actualData[15] = 2;
        actualData[16] = 3;
        actualData[17] = 4;
        actualData[18] = 5;
        actualData[19] = 6;
        actualData[20] = 7;
        actualData[21] = 8;
        actualData[22] = 9;
        actualData[23] = 10;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new EncryptedDataFilter(
                new EncryptedDataAndroid(expectData, 0, expectData.length - 1)
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[24];
        expectData[0] = 11;
        expectData[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = 4;
        expectData[6] = 5;
        expectData[7] = 6;
        expectData[8] = 7;
        expectData[9] = 8;
        expectData[10] = 9;
        expectData[11] = 10;
        expectData[12] = 11;
        expectData[13] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        expectData[14] = 1;
        expectData[15] = 2;
        expectData[16] = 3;
        expectData[17] = 4;
        expectData[18] = 5;
        expectData[19] = 6;
        expectData[20] = 7;
        expectData[21] = 8;
        expectData[22] = 9;
        expectData[23] = 10;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new EncryptedDataFilter(
                new EncryptedDataAndroid(expectData, 0, expectData.length / 2 - 1)
                , new EncryptedDataAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1)
        );
        assertTrue(filter.isMatched(result));
    }

}
