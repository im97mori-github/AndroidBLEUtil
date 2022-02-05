package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ServiceData128BitUUIDAndroid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ServiceData128BitUUIDFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(new ArrayList<ServiceData128BitUUIDAndroid>(), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[18];
        expectData[0] = 17;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        expectData[2] = 0x01;
        expectData[3] = 0x02;
        expectData[4] = 0x03;
        expectData[5] = 0x04;
        expectData[6] = 0x05;
        expectData[7] = 0x06;
        expectData[8] = 0x07;
        expectData[9] = 0x08;
        expectData[10] = 0x09;
        expectData[11] = 0x0a;
        expectData[12] = 0x0b;
        expectData[13] = 0x0c;
        expectData[14] = 0x0d;
        expectData[15] = 0x0e;
        expectData[16] = 0x0f;
        expectData[17] = 0x10;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(expectData), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[18];
        actualData[0] = 17;
        actualData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        actualData[2] = 0x01;
        actualData[3] = 0x02;
        actualData[4] = 0x03;
        actualData[5] = 0x04;
        actualData[6] = 0x05;
        actualData[7] = 0x06;
        actualData[8] = 0x07;
        actualData[9] = 0x08;
        actualData[10] = 0x09;
        actualData[11] = 0x0a;
        actualData[12] = 0x0b;
        actualData[13] = 0x0c;
        actualData[14] = 0x0d;
        actualData[15] = 0x0e;
        actualData[16] = 0x0f;
        actualData[17] = 0x10;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(new ArrayList<ServiceData128BitUUIDAndroid>(), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[18];
        expectData[0] = 17;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        expectData[2] = 0x01;
        expectData[3] = 0x02;
        expectData[4] = 0x03;
        expectData[5] = 0x04;
        expectData[6] = 0x05;
        expectData[7] = 0x06;
        expectData[8] = 0x07;
        expectData[9] = 0x08;
        expectData[10] = 0x09;
        expectData[11] = 0x0a;
        expectData[12] = 0x0b;
        expectData[13] = 0x0c;
        expectData[14] = 0x0d;
        expectData[15] = 0x0e;
        expectData[16] = 0x0f;
        expectData[17] = 0x10;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(expectData), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[36];
        expectData[0] = 17;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        expectData[2] = 0x01;
        expectData[3] = 0x02;
        expectData[4] = 0x03;
        expectData[5] = 0x04;
        expectData[6] = 0x05;
        expectData[7] = 0x06;
        expectData[8] = 0x07;
        expectData[9] = 0x08;
        expectData[10] = 0x09;
        expectData[11] = 0x0a;
        expectData[12] = 0x0b;
        expectData[13] = 0x0c;
        expectData[14] = 0x0d;
        expectData[15] = 0x0e;
        expectData[16] = 0x0f;
        expectData[17] = 0x10;
        expectData[18] = 17;
        expectData[19] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        expectData[20] = 0x11;
        expectData[21] = 0x12;
        expectData[22] = 0x13;
        expectData[23] = 0x14;
        expectData[24] = 0x15;
        expectData[25] = 0x16;
        expectData[26] = 0x17;
        expectData[27] = 0x18;
        expectData[28] = 0x19;
        expectData[29] = 0x1a;
        expectData[30] = 0x1b;
        expectData[31] = 0x1c;
        expectData[32] = 0x1d;
        expectData[33] = 0x1e;
        expectData[34] = 0x1f;
        expectData[35] = 0x20;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(
                Arrays.asList(new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length / 2 - 1)
                        , new ServiceData128BitUUIDAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1))
                , null
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[36];
        actualData[0] = 17;
        actualData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        actualData[2] = 0x01;
        actualData[3] = 0x02;
        actualData[4] = 0x03;
        actualData[5] = 0x04;
        actualData[6] = 0x05;
        actualData[7] = 0x06;
        actualData[8] = 0x07;
        actualData[9] = 0x08;
        actualData[10] = 0x09;
        actualData[11] = 0x0a;
        actualData[12] = 0x0b;
        actualData[13] = 0x0c;
        actualData[14] = 0x0d;
        actualData[15] = 0x0e;
        actualData[16] = 0x0f;
        actualData[17] = 0x10;
        actualData[18] = 17;
        actualData[19] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        actualData[20] = 0x11;
        actualData[21] = 0x12;
        actualData[22] = 0x13;
        actualData[23] = 0x14;
        actualData[24] = 0x15;
        actualData[25] = 0x16;
        actualData[26] = 0x17;
        actualData[27] = 0x18;
        actualData[28] = 0x19;
        actualData[29] = 0x1a;
        actualData[30] = 0x1b;
        actualData[31] = 0x1c;
        actualData[32] = 0x1d;
        actualData[33] = 0x1e;
        actualData[34] = 0x1f;
        actualData[35] = 0x20;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(
                new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length - 1), null
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[36];
        expectData[0] = 17;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        expectData[2] = 0x01;
        expectData[3] = 0x02;
        expectData[4] = 0x03;
        expectData[5] = 0x04;
        expectData[6] = 0x05;
        expectData[7] = 0x06;
        expectData[8] = 0x07;
        expectData[9] = 0x08;
        expectData[10] = 0x09;
        expectData[11] = 0x0a;
        expectData[12] = 0x0b;
        expectData[13] = 0x0c;
        expectData[14] = 0x0d;
        expectData[15] = 0x0e;
        expectData[16] = 0x0f;
        expectData[17] = 0x10;
        expectData[18] = 17;
        expectData[19] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        expectData[20] = 0x11;
        expectData[21] = 0x12;
        expectData[22] = 0x13;
        expectData[23] = 0x14;
        expectData[24] = 0x15;
        expectData[25] = 0x16;
        expectData[26] = 0x17;
        expectData[27] = 0x18;
        expectData[28] = 0x19;
        expectData[29] = 0x1a;
        expectData[30] = 0x1b;
        expectData[31] = 0x1c;
        expectData[32] = 0x1d;
        expectData[33] = 0x1e;
        expectData[34] = 0x1f;
        expectData[35] = 0x20;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(
                Arrays.asList(new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length / 2 - 1)
                        , new ServiceData128BitUUIDAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1))
                , null
        );
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_201() {
        byte[] additionalData = new byte[32];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;
        additionalData[18] = 19;
        additionalData[19] = 20;
        additionalData[20] = 21;
        additionalData[21] = 22;
        additionalData[22] = 23;
        additionalData[23] = 24;
        additionalData[24] = 25;
        additionalData[25] = 26;
        additionalData[26] = 27;
        additionalData[27] = 28;
        additionalData[28] = 29;
        additionalData[29] = 30;
        additionalData[30] = 31;
        additionalData[31] = 32;

        byte[] expectData = new byte[34];
        expectData[0] = 33;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = new byte[18];
        actualData[0] = 17;
        actualData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, actualData, 2, additionalData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length - 1), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_202() {
        byte[] additionalData = new byte[32];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;
        additionalData[18] = 19;
        additionalData[19] = 20;
        additionalData[20] = 21;
        additionalData[21] = 22;
        additionalData[22] = 23;
        additionalData[23] = 24;
        additionalData[24] = 25;
        additionalData[25] = 26;
        additionalData[26] = 27;
        additionalData[27] = 28;
        additionalData[28] = 29;
        additionalData[29] = 30;
        additionalData[30] = 31;
        additionalData[31] = 32;

        byte[] actualData = new byte[34];
        actualData[0] = 33;
        actualData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, actualData, 2, additionalData.length);

        byte[] expectData = new byte[18];
        expectData[0] = 17;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length - 1), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_203() {
        byte[] additionalData = new byte[32];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;
        additionalData[18] = 19;
        additionalData[19] = 20;
        additionalData[20] = 21;
        additionalData[21] = 22;
        additionalData[22] = 23;
        additionalData[23] = 24;
        additionalData[24] = 25;
        additionalData[25] = 26;
        additionalData[26] = 27;
        additionalData[27] = 28;
        additionalData[28] = 29;
        additionalData[29] = 30;
        additionalData[30] = 31;
        additionalData[31] = 32;

        byte[] expectData = new byte[34];
        expectData[0] = 33;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length - 1), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_301() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(expectData), new byte[0]);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_303() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_304() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[18] = 19;

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_305() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_306() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[18] = 19;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_307() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[18] = 19;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_401() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[3];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length - 1), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_402() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(Collections.singletonList(new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length - 1)), Collections.singletonList(bitmask));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_403() {
        byte[] additionalData = new byte[18];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;
        additionalData[6] = 7;
        additionalData[7] = 8;
        additionalData[8] = 9;
        additionalData[9] = 10;
        additionalData[10] = 11;
        additionalData[11] = 12;
        additionalData[12] = 13;
        additionalData[13] = 14;
        additionalData[14] = 15;
        additionalData[15] = 16;
        additionalData[16] = 17;
        additionalData[17] = 18;

        byte[] expectData = new byte[20];
        expectData[0] = 19;
        expectData[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[18] = 19;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData128BitUUIDFilter(Collections.singletonList(new ServiceData128BitUUIDAndroid(expectData, 0, expectData.length - 1)), Arrays.asList(bitmask, bitmask));
        assertFalse(filter.isMatched(result));
    }
}
