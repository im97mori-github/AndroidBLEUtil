package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.ADVERTISING_INTERVAL_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.ADVERTISING_INTERVAL_LONG_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.APPEARANCE_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.BIG_INFO_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LOCAL_NAME_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.FLAGS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INDOOR_POSITIONING_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.LE_SUPPORTED_FEATURES_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.PUBLIC_TARGET_ADDRESS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.RANDOM_TARGET_ADDRESS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.SHORTENED_LOCAL_NAME_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.TX_POWER_LEVEL_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.URI_DATA_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import androidx.annotation.NonNull;

import org.im97mori.ble.TransportDiscoveryServiceUtils;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.AdvertisingIntervalAndroid;
import org.im97mori.ble.advertising.AdvertisingIntervalLongAndroid;
import org.im97mori.ble.advertising.AppearanceAndroid;
import org.im97mori.ble.advertising.BigInfoAndroid;
import org.im97mori.ble.advertising.ChannelMapUpdateIndicationAndroid;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.CompleteListOf16BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.CompleteListOf32BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.CompleteLocalNameAndroid;
import org.im97mori.ble.advertising.EncryptedDataAndroid;
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
import org.im97mori.ble.advertising.PeriodicAdvertisingResponseTimingInformation;
import org.im97mori.ble.advertising.PeriodicAdvertisingResponseTimingInformationAndroid;
import org.im97mori.ble.advertising.PeripheralConnectionIntervalRangeAndroid;
import org.im97mori.ble.advertising.PublicTargetAddressAndroid;
import org.im97mori.ble.advertising.RandomTargetAddressAndroid;
import org.im97mori.ble.advertising.ServiceData128BitUUIDAndroid;
import org.im97mori.ble.advertising.ServiceData16BitUUIDAndroid;
import org.im97mori.ble.advertising.ServiceData32BitUUIDAndroid;
import org.im97mori.ble.advertising.ShortenedLocalNameAndroid;
import org.im97mori.ble.advertising.TransportDiscoveryDataAndroid;
import org.im97mori.ble.advertising.TxPowerLevelAndroid;
import org.im97mori.ble.advertising.UniformResourceIdentifierAndroid;
import org.im97mori.ble.constants.AppearanceValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("ConstantConditions")
public class AbstractFilteredCallbackBuilderTest {

    private static class MockFilteredCallbackBuilder extends AbstractFilteredCallbackBuilder<List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>>> {

        @Override
        @NonNull
        public List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> build() {
            return mFilterList;
        }

        public AdvertisingDataParser getAdvertisingDataParser() {
            return mAdvertisingDataParser;
        }
    }

    @Test
    public void addFilterTest_001() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = advertisingDataParseResult -> false;
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFilter(filter).build();
        assertEquals(1, result.size());
        assertEquals(filter, result.get(0));
    }

    @Test
    public void addFilter2Test_001() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = advertisingDataParseResult -> false;
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = advertisingDataParseResult -> false;
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFilters(filter1, filter2).build();
        assertEquals(2, result.size());
        assertEquals(filter1, result.get(0));
        assertEquals(filter2, result.get(1));
    }

    @Test
    public void addFilter2Test_002() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter1 = advertisingDataParseResult -> false;
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter2 = advertisingDataParseResult -> false;
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFilters(Arrays.asList(filter1, filter2)).build();
        assertEquals(2, result.size());
        assertEquals(filter1, result.get(0));
        assertEquals(filter2, result.get(1));
    }

    @Test
    public void clearFilterTest_001() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = advertisingDataParseResult -> false;
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addFilter(filter).clearFilter().build();
        assertTrue(result.isEmpty());
    }

    @Test
    public void setAdvertisingDataParserTest_001() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        builder.setAdvertisingDataParser(parser);
        assertEquals(parser, builder.getAdvertisingDataParser());
    }

    @Test
    public void setAdvertisingDataParserTest_002() {
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        builder.setAdvertisingDataParser(parser).setAdvertisingDataParser(null);
        assertNull(builder.getAdvertisingDataParser());
    }

    @Test
    public void addAdvertisingIntervalFilterTest_001() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
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
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
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
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[2] = 0x01;
        data[3] = 0x02;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAdvertisingIntervalFilter(AdvertisingIntervalAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AdvertisingIntervalFilter);
    }

    @Test
    public void addAdvertisingIntervalLongFilterTest_001() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x01;
        data[3] = 0x02;
        data[4] = 0x03;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAdvertisingIntervalLongFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AdvertisingIntervalLongFilter);
    }

    @Test
    public void addAdvertisingIntervalLongFilterTest_002() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x01;
        data[3] = 0x02;
        data[4] = 0x03;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAdvertisingIntervalLongFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AdvertisingIntervalLongFilter);
    }

    @Test
    public void addAdvertisingIntervalLongFilterTest_003() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x01;
        data[3] = 0x02;
        data[4] = 0x03;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAdvertisingIntervalLongFilter(AdvertisingIntervalLongAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AdvertisingIntervalLongFilter);
    }

    @Test
    public void addAppearanceFilterTest_001() {
        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAppearanceFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AppearanceFilter);
    }

    @Test
    public void addAppearanceFilterTest_002() {
        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAppearanceFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AppearanceFilter);
    }

    @Test
    public void addAppearanceFilterTest_003() {
        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addAppearanceFilter(AppearanceAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AppearanceFilter);
    }

    @Test
    public void addBigInfoFilterTest_001() {
        byte[] data = new byte[35];
        data[0] = 34;
        data[1] = BIG_INFO_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00000000;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data[9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addBigInfoFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof BigInfoFilter);
    }

    @Test
    public void addBigInfoFilterTest_002() {
        byte[] data = new byte[35];
        data[0] = 34;
        data[1] = BIG_INFO_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00000000;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data[9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addBigInfoFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof BigInfoFilter);
    }

    @Test
    public void addBigInfoFilterTest_003() {
        byte[] data = new byte[35];
        data[0] = 34;
        data[1] = BIG_INFO_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00000000;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data[9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addBigInfoFilter(BigInfoAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof BigInfoFilter);
    }

    @Test
    public void addChannelMapUpdateIndicationFilterTest_001() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
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
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
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
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteLocalNameFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteLocalNameFilter);
    }

    @Test
    public void addCompleteLocalNameFilterTest_002() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addCompleteLocalNameFilter(data, 0, data[0]).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof CompleteLocalNameFilter);
    }

    @Test
    public void addCompleteLocalNameFilterTest_003() {
        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
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
        data[1] = FLAGS_DATA_TYPE;
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
        data[1] = FLAGS_DATA_TYPE;
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
        data[1] = FLAGS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[1] = INDOOR_POSITIONING_DATA_TYPE;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIndoorPositioningFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IndoorPositioningFilter);
    }

    @Test
    public void addIndoorPositioningFilterTest_002() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = INDOOR_POSITIONING_DATA_TYPE;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIndoorPositioningFilter(data, 0, 1).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IndoorPositioningFilter);
    }

    @Test
    public void addIndoorPositioningFilterTest_003() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = INDOOR_POSITIONING_DATA_TYPE;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addIndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof IndoorPositioningFilter);
    }

    @Test
    public void addLeSupportedFeaturesFilterTest_001() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addShortenedLocalNameFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ShortenedLocalNameFilter);
    }

    @Test
    public void addShortenedLocalNameFilterTest_002() {
        String name = "shortened local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addShortenedLocalNameFilter(data, 0, 3).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ShortenedLocalNameFilter);
    }

    @Test
    public void addShortenedLocalNameFilterTest_003() {
        String name = "shortened local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addShortenedLocalNameFilter(ShortenedLocalNameAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof ShortenedLocalNameFilter);
    }

    @Test
    public void addPeripheralConnectionIntervalRangeFilterTest_001() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPeripheralConnectionIntervalRangeFilter(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PeripheralConnectionIntervalRangeFilter);
    }

    @Test
    public void addPeripheralConnectionIntervalRangeFilterTest_002() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPeripheralConnectionIntervalRangeFilter(data, 0, 5).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PeripheralConnectionIntervalRangeFilter);
    }

    @Test
    public void addPeripheralConnectionIntervalRangeFilterTest_003() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPeripheralConnectionIntervalRangeFilter(PeripheralConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PeripheralConnectionIntervalRangeFilter);
    }

    @Test
    public void addPeripheralConnectionIntervalRangeFilterTest_004() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPeripheralConnectionIntervalRangeFilter(Collections.singletonList(PeripheralConnectionIntervalRangeAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PeripheralConnectionIntervalRangeFilter);
    }

    @Test
    public void addTransportDiscoveryDataFilterTest_001() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
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
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
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
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
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
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
        data[2] = -127;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addTxPowerLevelFilter(Collections.singletonList(TxPowerLevelAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof TxPowerLevelFilter);
    }

    @Test
    public void addUniformResourceIdentifierTest_001() {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addUniformResourceIdentifier(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof UniformResourceIdentifierFilter);
    }

    @Test
    public void addUniformResourceIdentifierTest_002() {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addUniformResourceIdentifier(data, 0, data[0]).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof UniformResourceIdentifierFilter);
    }

    @Test
    public void addUniformResourceIdentifierTest_003() {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addUniformResourceIdentifier(UniformResourceIdentifierAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof UniformResourceIdentifierFilter);
    }

    @Test
    public void addUniformResourceIdentifierTest_004() {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addUniformResourceIdentifier(Collections.singletonList(UniformResourceIdentifierAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof UniformResourceIdentifierFilter);
    }

    @Test
    public void addEncryptedData_001() {
        byte[] data = new byte[12];
        data[0] = 11;
        data[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 5;
        data[7] = 6;
        data[8] = 7;
        data[9] = 8;
        data[10] = 9;
        data[11] = 10;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addEncryptedData(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof EncryptedDataFilter);
    }

    @Test
    public void addEncryptedData_002() {
        byte[] data = new byte[12];
        data[0] = 11;
        data[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 5;
        data[7] = 6;
        data[8] = 7;
        data[9] = 8;
        data[10] = 9;
        data[11] = 10;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addEncryptedData(data, 0, 11).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof EncryptedDataFilter);
    }

    @Test
    public void addEncryptedData_003() {
        byte[] data = new byte[12];
        data[0] = 11;
        data[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 5;
        data[7] = 6;
        data[8] = 7;
        data[9] = 8;
        data[10] = 9;
        data[11] = 10;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addEncryptedData(EncryptedDataAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof EncryptedDataFilter);
    }

    @Test
    public void addEncryptedData_004() {
        byte[] data = new byte[12];
        data[0] = 11;
        data[1] = ENCRYPTED_ADVERTISING_DATA_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 5;
        data[7] = 6;
        data[8] = 7;
        data[9] = 8;
        data[10] = 9;
        data[11] = 10;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addEncryptedData(Collections.singletonList(EncryptedDataAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof EncryptedDataFilter);
    }

    @Test
    public void addPeriodicAdvertisingResponseTimingInformation_001() {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 0x01;
        data[7] = 0x06;
        data[8] = 0x01;
        data[9] = 0x02;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPeriodicAdvertisingResponseTimingInformation(data).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PeriodicAdvertisingResponseTimingInformationFilter);
    }

    @Test
    public void addPeriodicAdvertisingResponseTimingInformation_002() {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 0x01;
        data[7] = 0x06;
        data[8] = 0x01;
        data[9] = 0x02;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPeriodicAdvertisingResponseTimingInformation(data, 0, 9).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PeriodicAdvertisingResponseTimingInformationFilter);
    }

    @Test
    public void addPeriodicAdvertisingResponseTimingInformation_003() {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 0x01;
        data[7] = 0x06;
        data[8] = 0x01;
        data[9] = 0x02;
        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPeriodicAdvertisingResponseTimingInformation(PeriodicAdvertisingResponseTimingInformationAndroid.CREATOR.createFromByteArray(data)).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PeriodicAdvertisingResponseTimingInformationFilter);
    }

    @Test
    public void addPeriodicAdvertisingResponseTimingInformation_004() {
        byte[] data = new byte[10];
        data[0] = 9;
        data[1] = PERIODIC_ADVERTISING_RESPONSE_TIMING_INFORMATION_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data[6] = 0x01;
        data[7] = 0x06;
        data[8] = 0x01;
        data[9] = 0x02;

        MockFilteredCallbackBuilder builder = new MockFilteredCallbackBuilder();
        List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> result = builder.addPeriodicAdvertisingResponseTimingInformation(Collections.singletonList(PeriodicAdvertisingResponseTimingInformationAndroid.CREATOR.createFromByteArray(data))).build();
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof PeriodicAdvertisingResponseTimingInformationFilter);
    }
}
