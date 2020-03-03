package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.TransportDiscoveryServiceUtils;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.AdvertisingInterval;
import org.im97mori.ble.advertising.AdvertisingIntervalAndroid;
import org.im97mori.ble.advertising.AppearanceAndroid;
import org.im97mori.ble.advertising.ChannelMapUpdateIndicationAndroid;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.CompleteListOf16BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.CompleteListOf32BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.CompleteLocalNameAndroid;
import org.im97mori.ble.advertising.FlagsAndroid;
import org.im97mori.ble.advertising.IncompleteListOf128BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.IncompleteListOf16BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.IncompleteListOf32BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.IndoorPositioningAndroid;
import org.im97mori.ble.advertising.LeSupportedFeaturesAndroid;
import org.im97mori.ble.advertising.ListOf128BitServiceSolicitationUUIDsAndroid;
import org.im97mori.ble.advertising.ListOf16BitServiceSolicitationUUIDsAndroid;
import org.im97mori.ble.advertising.ListOf32BitServiceSolicitationUUIDsAndroid;
import org.im97mori.ble.advertising.ManufacturerSpecificDataAndroid;
import org.im97mori.ble.advertising.PublicTargetAddressAndroid;
import org.im97mori.ble.advertising.RandomTargetAddressAndroid;
import org.im97mori.ble.advertising.ServiceData128BitUUIDAndroid;
import org.im97mori.ble.advertising.ServiceData16BitUUIDAndroid;
import org.im97mori.ble.advertising.ServiceData32BitUUIDAndroid;
import org.im97mori.ble.advertising.ShortenedLocalNameAndroid;
import org.im97mori.ble.advertising.SlaveConnectionIntervalRangeAndroid;
import org.im97mori.ble.advertising.TransportDiscoveryDataAndroid;
import org.im97mori.ble.advertising.TxPowerLevelAndroid;
import org.im97mori.ble.advertising.UniformRsourceIdentifierAndroid;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.im97mori.ble.BLEConstants.APPEARANCE_VALUE_MAP;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_ADVERTISING_INTERVAL;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_APPEARANCE;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LOCAL_NAME;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_FLAGS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INDOOR_POSITIONING;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LE_SUPPORTED_FEATURES;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_PUBLIC_TARGET_ADDRESS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_RANDOM_TARGET_ADDRESS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SHORTENED_LOCAL_NAME;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TX_POWER_LEVEL;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AbstractFilteredCallbackBuilderTest {

    private static class MockFilteredCallbackBuilder extends AbstractFilteredCallbackBuilder<List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>>> {

        @Override
        @NonNull
        public List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> build() {
            return mFilterList;
        }
    }

    @Test
    public void addFilterTest_001() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        };
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFilter(filter).build();
        assertEquals(1, result.size());
        assertEquals(filter, result.get(0));
    }

    @Test
    public void addFilter2Test_001() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
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
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFilters(filter1, filter2).build();
        assertEquals(2, result.size());
        assertEquals(filter1, result.get(0));
        assertEquals(filter2, result.get(1));
    }

    @Test
    public void addFilter2Test_002() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
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
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFilters(Arrays.asList(filter1, filter2)).build();
        assertEquals(2, result.size());
        assertEquals(filter1, result.get(0));
        assertEquals(filter2, result.get(1));
    }

    @Test
    public void clearFilterTest_001() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        };
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFilter(filter).clearFilter().build();
        assertTrue(result.isEmpty());
    }

    @Test
    public void setAdvertisingDataParserTest_001() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        builder.setAdvertisingDataParser(parser);
        assertEquals(parser, builder.mAdvertisingDataParser);
    }

    @Test
    public void setAdvertisingDataParserTest_002() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        builder.setAdvertisingDataParser(parser).setAdvertisingDataParser(null);
        assertNull(builder.mAdvertisingDataParser);
    }

    @Test
    public void addAdvertisingIntervalFilterTest_001() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x01;
        data[3] = 0x02;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAdvertisingIntervalFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AdvertisingIntervalFilter);
    }

    @Test
    public void addAdvertisingIntervalFilterTest_002() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x01;
        data[3] = 0x02;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAdvertisingIntervalFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AdvertisingIntervalFilter);
    }

    @Test
    public void addAdvertisingIntervalFilterTest_003() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x01;
        data[3] = 0x02;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAdvertisingIntervalFilter(AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AdvertisingIntervalFilter);
    }

    @Test
    public void addAppearanceFilterTest_001() {
        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAppearanceFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AppearanceFilter);
    }

    @Test
    public void addAppearanceFilterTest_002() {
        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAppearanceFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AppearanceFilter);
    }

    @Test
    public void addAppearanceFilterTest_003() {
        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAppearanceFilter(AppearanceAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AppearanceFilter);
    }

    @Test
    public void addChannelMapUpdateIndicationFilterTest_001() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111110;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addChannelMapUpdateIndicationFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ChannelMapUpdateIndicationFilter);
    }

    @Test
    public void addChannelMapUpdateIndicationFilterTest_002() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111110;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addChannelMapUpdateIndicationFilter(data, 0, 8).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ChannelMapUpdateIndicationFilter);
    }

    @Test
    public void addChannelMapUpdateIndicationFilterTest_003() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111110;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addChannelMapUpdateIndicationFilter(ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ChannelMapUpdateIndicationFilter);
    }

    @Test
    public void addCompleteListOf16BitServiceUUIDsFilterTest_001() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf16BitServiceUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf16BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf16BitServiceUUIDsFilterTest_002() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf16BitServiceUUIDsFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf16BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf16BitServiceUUIDsFilterTest_003() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf16BitServiceUUIDsFilter(CompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf16BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf16BitServiceUUIDsFilterTest_004() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf16BitServiceUUIDsFilter(Collections.singletonList(CompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf16BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf32BitServiceUUIDsFilterTest_001() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf32BitServiceUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf32BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf32BitServiceUUIDsFilterTest_002() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf32BitServiceUUIDsFilter(data, 0, 5).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf32BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf32BitServiceUUIDsFilterTest_003() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf32BitServiceUUIDsFilter(CompleteListOf32BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf32BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf32BitServiceUUIDsFilterTest_004() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf32BitServiceUUIDsFilter(Collections.singletonList(CompleteListOf32BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf32BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf128BitServiceUUIDsFilterTest_001() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf128BitServiceUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf128BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf128BitServiceUUIDsFilterTest_002() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf128BitServiceUUIDsFilter(data, 0, 17).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf128BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf128BitServiceUUIDsFilterTest_003() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf128BitServiceUUIDsFilter(CompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf128BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteListOf128BitServiceUUIDsFilterTest_004() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteListOf128BitServiceUUIDsFilter(Collections.singletonList(CompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteListOf128BitServiceUUIDsFilter);
    }

    @Test
    public void addCompleteLocalNameFilterTest_001() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteLocalNameFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteLocalNameFilter);
    }

    @Test
    public void addCompleteLocalNameFilterTest_002() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteLocalNameFilter(data, 0, data[0]).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteLocalNameFilter);
    }

    @Test
    public void addCompleteLocalNameFilterTest_003() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteLocalNameFilter(CompleteLocalNameAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteLocalNameFilter);
    }

    @Test
    public void addFlagsFilterTest_001() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFlagsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof FlagsFilter);
    }

    @Test
    public void addFlagsFilterTest_002() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFlagsFilter(data, 0, 2).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof FlagsFilter);
    }

    @Test
    public void addFlagsFilterTest_003() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFlagsFilter(FlagsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof FlagsFilter);
    }

    @Test
    public void addIncompleteListOf16BitServiceUUIDsFilterTest_001() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf16BitServiceUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf16BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf16BitServiceUUIDsFilterTest_002() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf16BitServiceUUIDsFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf16BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf16BitServiceUUIDsFilterTest_003() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf16BitServiceUUIDsFilter(IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf16BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf16BitServiceUUIDsFilterTest_004() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf16BitServiceUUIDsFilter(Collections.singletonList(IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf16BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf32BitServiceUUIDsFilterTest_001() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf32BitServiceUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf32BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf32BitServiceUUIDsFilterTest_002() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf32BitServiceUUIDsFilter(data, 0, 5).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf32BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf32BitServiceUUIDsFilterTest_003() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf32BitServiceUUIDsFilter(IncompleteListOf32BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf32BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf32BitServiceUUIDsFilterFilterTest_004() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf32BitServiceUUIDsFilter(Collections.singletonList(IncompleteListOf32BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf32BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf128BitServiceUUIDsFilterTest_001() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf128BitServiceUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf128BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf128BitServiceUUIDsFilterTest_002() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf128BitServiceUUIDsFilter(data, 0, 17).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf128BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf128BitServiceUUIDsFilterTest_003() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf128BitServiceUUIDsFilter(IncompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf128BitServiceUUIDsFilter);
    }

    @Test
    public void addIncompleteListOf128BitServiceUUIDsFilterTest_004() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIncompleteListOf128BitServiceUUIDsFilter(Collections.singletonList(IncompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IncompleteListOf128BitServiceUUIDsFilter);
    }

    @Test
    public void addIndoorPositioningFilterTest_001() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_INDOOR_POSITIONING;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIndoorPositioningFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IndoorPositioningFilter);
    }

    @Test
    public void addIndoorPositioningFilterTest_002() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_INDOOR_POSITIONING;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIndoorPositioningFilter(data, 0, 1).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IndoorPositioningFilter);
    }

    @Test
    public void addIndoorPositioningFilterTest_003() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_INDOOR_POSITIONING;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IndoorPositioningFilter);
    }

    @Test
    public void addLeSupportedFeaturesFilterTest_001() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addLeSupportedFeaturesFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof LeSupportedFeaturesFilter);
    }

    @Test
    public void addLeSupportedFeaturesFilterTest_002() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addLeSupportedFeaturesFilter(data, 0, data[0]).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof LeSupportedFeaturesFilter);
    }

    @Test
    public void addLeSupportedFeaturesFilterTest_003() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addLeSupportedFeaturesFilter(LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof LeSupportedFeaturesFilter);
    }

    @Test
    public void addListOf16BitServiceSolicitationUUIDsFilterTest_001() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf16BitServiceSolicitationUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf16BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf16BitServiceSolicitationUUIDsFilterTest_002() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf16BitServiceSolicitationUUIDsFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf16BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf16BitServiceSolicitationUUIDsFilterTest_003() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf16BitServiceSolicitationUUIDsFilter(ListOf16BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf16BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf16BitServiceSolicitationUUIDsFilterTest_004() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf16BitServiceSolicitationUUIDsFilter(Collections.singletonList(ListOf16BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf16BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf32BitServiceSolicitationUUIDsFilterTest_001() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf32BitServiceSolicitationUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf32BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf32BitServiceSolicitationUUIDsFilterTest_002() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf32BitServiceSolicitationUUIDsFilter(data, 0, 5).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf32BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf32BitServiceSolicitationUUIDsFilterTest_003() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf32BitServiceSolicitationUUIDsFilter(ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf32BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf32BitServiceSolicitationUUIDsFilterTest_004() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf32BitServiceSolicitationUUIDsFilter(Collections.singletonList(ListOf32BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf32BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf128BitServiceSolicitationUUIDsFilterTest_001() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf128BitServiceSolicitationUUIDsFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf128BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf128BitServiceSolicitationUUIDsFilterTest_002() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf128BitServiceSolicitationUUIDsFilter(data, 0, 17).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf128BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf128BitServiceSolicitationUUIDsFilterTest_003() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf128BitServiceSolicitationUUIDsFilter(ListOf128BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf128BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addListOf128BitServiceSolicitationUUIDsFilterTest_004() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addListOf128BitServiceSolicitationUUIDsFilter(Collections.singletonList(ListOf128BitServiceSolicitationUUIDsAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ListOf128BitServiceSolicitationUUIDsFilter);
    }

    @Test
    public void addManufacturerSpecificDataFilterTest_001() {
        // google
        int companyId = 0x000000E0;

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addManufacturerSpecificDataFilter(data, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ManufacturerSpecificDataFilter);
    }

    @Test
    public void addManufacturerSpecificDataFilterTest_002() {
        // google
        int companyId = 0x000000E0;

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addManufacturerSpecificDataFilter(data, 0, 3, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ManufacturerSpecificDataFilter);
    }

    @Test
    public void addManufacturerSpecificDataFilterTest_003() {
        // google
        int companyId = 0x000000E0;

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addManufacturerSpecificDataFilter(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ManufacturerSpecificDataFilter);
    }

    @Test
    public void addManufacturerSpecificDataFilterTest_004() {
        // google
        int companyId = 0x000000E0;

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) ((companyId >> 8) & 0x0000ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addManufacturerSpecificDataFilter(Collections.singletonList(ManufacturerSpecificDataAndroid.CREATOR.createFromByteArray(data)), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ManufacturerSpecificDataFilter);
    }

    @Test
    public void addPublicTargetAddressFilterTest_001() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPublicTargetAddressFilter(data, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PublicTargetAddressFilter);
    }

    @Test
    public void addPublicTargetAddressFilterTest_002() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPublicTargetAddressFilter(data, 0, 7, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PublicTargetAddressFilter);
    }

    @Test
    public void addPublicTargetAddressFilterTest_003() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPublicTargetAddressFilter(PublicTargetAddressAndroid.CREATOR.createFromByteArray(data), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PublicTargetAddressFilter);
    }

    @Test
    public void addRandomTargetAddressFilterTest_001() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addRandomTargetAddressFilter(data, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof RandomTargetAddressFilter);
    }

    @Test
    public void addRandomTargetAddressFilterTest_002() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addRandomTargetAddressFilter(data, 0, 7, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof RandomTargetAddressFilter);
    }

    @Test
    public void addRandomTargetAddressFilterTest_003() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addRandomTargetAddressFilter(RandomTargetAddressAndroid.CREATOR.createFromByteArray(data), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof RandomTargetAddressFilter);
    }

    @Test
    public void addServiceData16BitUUIDFilterTest_001() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData16BitUUIDFilter(data, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData16BitUUIDFilter);
    }

    @Test
    public void addServiceData16BitUUIDFilterTest_002() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData16BitUUIDFilter(data, 0, 3, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData16BitUUIDFilter);
    }

    @Test
    public void addServiceData16BitUUIDFilterTest_003() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData16BitUUIDFilter(ServiceData16BitUUIDAndroid.CREATOR.createFromByteArray(data), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData16BitUUIDFilter);
    }

    @Test
    public void addServiceData16BitUUIDFilterTest_004() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData16BitUUIDFilter(Collections.singletonList(ServiceData16BitUUIDAndroid.CREATOR.createFromByteArray(data)), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData16BitUUIDFilter);
    }

    @Test
    public void addServiceData32BitUUIDFilterTest_001() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData32BitUUIDFilter(data, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData32BitUUIDFilter);
    }

    @Test
    public void addServiceData32BitUUIDFilterTest_002() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData32BitUUIDFilter(data, 0, 5, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData32BitUUIDFilter);
    }

    @Test
    public void addServiceData32BitUUIDFilterTest_003() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData32BitUUIDFilter(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData32BitUUIDFilter);
    }

    @Test
    public void addServiceData32BitUUIDFilterTest_004() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData32BitUUIDFilter(Collections.singletonList(ServiceData32BitUUIDAndroid.CREATOR.createFromByteArray(data)), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData32BitUUIDFilter);
    }

    @Test
    public void addServiceData128BitUUIDFilterTest_001() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData128BitUUIDFilter(data, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData128BitUUIDFilter);
    }

    @Test
    public void addServiceData128BitUUIDFilterTest_002() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData128BitUUIDFilter(data, 0, 17, null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData128BitUUIDFilter);
    }

    @Test
    public void addServiceData128BitUUIDFilterTest_003() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData128BitUUIDFilter(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(data), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData128BitUUIDFilter);
    }

    @Test
    public void addServiceData128BitUUIDFilterTest_004() {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;
        data[6] = 0x00;
        data[7] = 0x00;
        data[8] = 0x00;
        data[9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = 0x00;
        data[17] = 0x00;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addServiceData128BitUUIDFilter(Collections.singletonList(ServiceData128BitUUIDAndroid.CREATOR.createFromByteArray(data)), null).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ServiceData128BitUUIDFilter);
    }

    @Test
    public void addShortenedLocalNameFilterTest_001() {
        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addShortenedLocalNameFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ShortenedLocalNameFilter);
    }

    @Test
    public void addShortenedLocalNameFilterTest_002() {
        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addShortenedLocalNameFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ShortenedLocalNameFilter);
    }

    @Test
    public void addShortenedLocalNameFilterTest_003() {
        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addShortenedLocalNameFilter(ShortenedLocalNameAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ShortenedLocalNameFilter);
    }

    @Test
    public void addSlaveConnectionIntervalRangeFilterTest_001() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addSlaveConnectionIntervalRangeFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof SlaveConnectionIntervalRangeFilter);
    }

    @Test
    public void addSlaveConnectionIntervalRangeFilterTest_002() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addSlaveConnectionIntervalRangeFilter(data, 0, 5).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof SlaveConnectionIntervalRangeFilter);
    }

    @Test
    public void addSlaveConnectionIntervalRangeFilterTest_003() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addSlaveConnectionIntervalRangeFilter(SlaveConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof SlaveConnectionIntervalRangeFilter);
    }

    @Test
    public void addSlaveConnectionIntervalRangeFilterTest_004() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addSlaveConnectionIntervalRangeFilter(Collections.singletonList(SlaveConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof SlaveConnectionIntervalRangeFilter);
    }

    @Test
    public void addTransportDiscoveryDataFilterTest_001() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addTransportDiscoveryDataFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof TransportDiscoveryDataFilter);
    }

    @Test
    public void addTransportDiscoveryDataFilterTest_002() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addTransportDiscoveryDataFilter(data, 0, 1).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof TransportDiscoveryDataFilter);
    }

    @Test
    public void addTransportDiscoveryDataFilterTest_003() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addTransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof TransportDiscoveryDataFilter);
    }

    @Test
    public void addTxPowerLevelFilterTest_001() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addTxPowerLevelFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof TxPowerLevelFilter);
    }

    @Test
    public void addTxPowerLevelFilterTest_002() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addTxPowerLevelFilter(data, 0, 1).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof TxPowerLevelFilter);
    }

    @Test
    public void addTxPowerLevelFilterTest_003() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addTxPowerLevelFilter(TxPowerLevelAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof TxPowerLevelFilter);
    }

    @Test
    public void addTxPowerLevelFilterTest_004() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addTxPowerLevelFilter(Collections.singletonList(TxPowerLevelAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof TxPowerLevelFilter);
    }

    @Test
    public void addUniformRsourceIdentifierTest_001() {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addUniformRsourceIdentifier(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof UniformRsourceIdentifierFilter);
    }

    @Test
    public void addUniformRsourceIdentifierTest_002() {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addUniformRsourceIdentifier(data, 0, data[0]).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof UniformRsourceIdentifierFilter);
    }

    @Test
    public void addUniformRsourceIdentifierTest_003() {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addUniformRsourceIdentifier(UniformRsourceIdentifierAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof UniformRsourceIdentifierFilter);
    }

    @Test
    public void addUniformRsourceIdentifierTest_004() {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addUniformRsourceIdentifier(Collections.singletonList(UniformRsourceIdentifierAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof UniformRsourceIdentifierFilter);
    }

}
