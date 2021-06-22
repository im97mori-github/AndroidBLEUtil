package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ServiceData32BitUUIDAndroid;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServiceData32BitUUIDFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(new ArrayList<ServiceData32BitUUIDAndroid>(), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        expectData[2] = 0x01;
        expectData[3] = 0x02;
        expectData[4] = 0x03;
        expectData[5] = 0x04;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(expectData), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        actualData[2] = 0x01;
        actualData[3] = 0x02;
        actualData[4] = 0x03;
        actualData[5] = 0x04;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(new ArrayList<ServiceData32BitUUIDAndroid>(), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        expectData[2] = 0x01;
        expectData[3] = 0x02;
        expectData[4] = 0x03;
        expectData[5] = 0x04;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(expectData), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[12];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        expectData[2] = 0x01;
        expectData[3] = 0x02;
        expectData[4] = 0x03;
        expectData[5] = 0x04;
        expectData[6] = 5;
        expectData[7] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        expectData[8] = 0x05;
        expectData[9] = 0x06;
        expectData[10] = 0x07;
        expectData[11] = 0x08;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(
                Arrays.asList(new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length / 2 - 1)
                        , new ServiceData32BitUUIDAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1))
                , null
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[12];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        actualData[2] = 0x01;
        actualData[3] = 0x02;
        actualData[4] = 0x03;
        actualData[5] = 0x04;
        actualData[6] = 5;
        actualData[7] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        actualData[8] = 0x05;
        actualData[9] = 0x06;
        actualData[10] = 0x07;
        actualData[11] = 0x08;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(
                new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length - 1), null
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[12];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        expectData[2] = 0x01;
        expectData[3] = 0x02;
        expectData[4] = 0x03;
        expectData[5] = 0x04;
        expectData[6] = 5;
        expectData[7] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        expectData[8] = 0x05;
        expectData[9] = 0x06;
        expectData[10] = 0x07;
        expectData[11] = 0x08;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(
                Arrays.asList(new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length / 2 - 1)
                        , new ServiceData32BitUUIDAndroid(expectData, expectData.length / 2, expectData.length / 2 - 1))
                , null
        );
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_201() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, actualData, 2, additionalData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length - 1), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_202() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] actualData = new byte[8];
        actualData[0] = 7;
        actualData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, actualData, 2, additionalData.length);

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length - 1), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_203() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length - 1), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_301() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(expectData), new byte[0]);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_303() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_304() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[6] = 7;

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_305() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_306() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[6] = 7;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_307() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[6] = 7;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(expectData), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_401() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[3];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length - 1), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_402() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(Collections.singletonList(new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length - 1)), Collections.singletonList(bitmask));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_403() {
        byte[] additionalData = new byte[6];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;
        additionalData[4] = 5;
        additionalData[5] = 6;

        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[6] = 7;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData32BitUUIDFilter(Collections.singletonList(new ServiceData32BitUUIDAndroid(expectData, 0, expectData.length - 1)), Arrays.asList(bitmask, bitmask));
        assertFalse(filter.isMatched(result));
    }
}
