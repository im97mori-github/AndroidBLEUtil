package org.im97mori.ble.ad.filter;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.ServiceData16BitUUID;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServiceData16BitUUIDFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(new ArrayList<ServiceData16BitUUID>(), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        expectData[2] = 1;
        expectData[3] = 2;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(expectData), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[4];
        actualData[0] = 3;
        actualData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        actualData[2] = 1;
        actualData[3] = 2;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(new ArrayList<ServiceData16BitUUID>(), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        expectData[2] = 1;
        expectData[3] = 2;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(expectData), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[8];
        expectData[0] = 3;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        expectData[6] = 3;
        expectData[7] = 4;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(
                Arrays.asList(new ServiceData16BitUUID(expectData, 0, expectData.length / 2 - 1)
                        , new ServiceData16BitUUID(expectData, expectData.length / 2, expectData.length / 2 - 1))
                , null
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] actualData = new byte[8];
        actualData[0] = 3;
        actualData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        actualData[2] = 1;
        actualData[3] = 2;
        actualData[4] = 3;
        actualData[5] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        actualData[6] = 3;
        actualData[7] = 4;

        byte[] expectData = Arrays.copyOf(actualData, actualData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(
                new ServiceData16BitUUID(expectData, 0, expectData.length - 1), null
        );
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[8];
        expectData[0] = 3;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        expectData[2] = 1;
        expectData[3] = 2;
        expectData[4] = 3;
        expectData[5] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        expectData[6] = 3;
        expectData[7] = 4;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(
                Arrays.asList(new ServiceData16BitUUID(expectData, 0, expectData.length / 2 - 1)
                        , new ServiceData16BitUUID(expectData, expectData.length / 2, expectData.length / 2 - 1))
                , null
        );
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_201() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = new byte[4];
        actualData[0] = 3;
        actualData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, actualData, 2, additionalData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(new ServiceData16BitUUID(expectData, 0, expectData.length - 1), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_202() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, actualData, 2, additionalData.length);

        byte[] expectData = new byte[4];
        expectData[0] = 3;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length / 2);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(new ServiceData16BitUUID(expectData, 0, expectData.length - 1), null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_203() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(new ServiceData16BitUUID(expectData, 0, expectData.length - 1), null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_301() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(expectData), new byte[0]);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_303() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_304() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[4] = 5;

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_305() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(expectData), bitmask);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_306() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[4] = 5;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(expectData), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_307() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[4] = 5;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(expectData), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_401() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[3];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(new ServiceData16BitUUID(expectData, 0, expectData.length - 1), bitmask);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_402() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        byte[] bitmask = new byte[2];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(Collections.singletonList(new ServiceData16BitUUID(expectData, 0, expectData.length - 1)), Collections.singletonList(bitmask));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_403() {
        byte[] additionalData = new byte[4];
        additionalData[0] = 1;
        additionalData[1] = 2;
        additionalData[2] = 3;
        additionalData[3] = 4;

        byte[] expectData = new byte[6];
        expectData[0] = 5;
        expectData[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        System.arraycopy(additionalData, 0, expectData, 2, additionalData.length);

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        expectData[4] = 5;

        byte[] bitmask = new byte[2];
        Arrays.fill(bitmask, (byte) 0xff);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new ServiceData16BitUUIDFilter(Collections.singletonList(new ServiceData16BitUUID(expectData, 0, expectData.length - 1)), Arrays.asList(bitmask, bitmask));
        assertFalse(filter.isMatched(result));
    }
}
