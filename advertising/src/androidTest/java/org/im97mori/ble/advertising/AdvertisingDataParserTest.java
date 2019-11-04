package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.APPEARANCE_VALUE_MAP;
import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.im97mori.ble.BLEConstants.COMPANY_MAPPING;
import static org.im97mori.ble.BLEConstants.URI_SCHEME_NAME_STRING_MAPPING;
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
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TX_POWER_LEVEL;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AdvertisingDataParserTest {

    @Test
    public void builderTest0001() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[0];

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0002() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNotNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0003() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0004() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0005() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0006() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0007() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0008() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0009() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNotNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0010() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNotNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0011() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNotNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0012() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNotNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0013() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNotNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0014() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNotNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0015() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0016() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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
        data[17] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0017() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNotNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0018() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNotNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0019() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNotNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0020() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNotNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0021() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNotNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0022() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNotNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0023() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x00;
        data[3] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNotNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0024() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNotNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0025() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNotNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0026() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0102() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS).include(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS).build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNotNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0103() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0104() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        builder.include(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0105() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0106() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        builder.include(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0107() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0108() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SHORTENED_LOCAL_NAME);
        builder.include(DATA_TYPE_SHORTENED_LOCAL_NAME);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0109() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_COMPLETE_LOCAL_NAME);
        builder.include(DATA_TYPE_COMPLETE_LOCAL_NAME);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNotNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0110() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_FLAGS);
        builder.include(DATA_TYPE_FLAGS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNotNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0111() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA);
        builder.include(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNotNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0112() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_TX_POWER_LEVEL);
        builder.include(DATA_TYPE_TX_POWER_LEVEL);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNotNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0113() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE);
        builder.include(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNotNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0114() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS);
        builder.include(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNotNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0115() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS);
        builder.include(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0116() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS);
        builder.include(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

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
        data[17] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0117() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SERVICE_DATA_16_BIT_UUID);
        builder.include(DATA_TYPE_SERVICE_DATA_16_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNotNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0118() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SERVICE_DATA_32_BIT_UUID);
        builder.include(DATA_TYPE_SERVICE_DATA_32_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNotNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0119() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SERVICE_DATA_128_BIT_UUID);
        builder.include(DATA_TYPE_SERVICE_DATA_128_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNotNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0120() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_APPEARANCE);
        builder.include(DATA_TYPE_APPEARANCE);
        AdvertisingDataParser parser = builder.build();

        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNotNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0121() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_PUBLIC_TARGET_ADDRESS);
        builder.include(DATA_TYPE_PUBLIC_TARGET_ADDRESS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNotNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0122() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_RANDOM_TARGET_ADDRESS);
        builder.include(DATA_TYPE_RANDOM_TARGET_ADDRESS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNotNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0123() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_ADVERTISING_INTERVAL);
        builder.include(DATA_TYPE_ADVERTISING_INTERVAL);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x00;
        data[3] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNotNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0124() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER);
        builder.include(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER);
        AdvertisingDataParser parser = builder.build();

        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNotNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0125() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_LE_SUPPORTED_FEATURES);
        builder.include(DATA_TYPE_LE_SUPPORTED_FEATURES);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNotNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0126() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);
        builder.include(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);
        AdvertisingDataParser parser = builder.build();

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
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0202() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0203() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0204() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0205() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0206() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0207() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0208() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SHORTENED_LOCAL_NAME);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0209() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_COMPLETE_LOCAL_NAME);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0210() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_FLAGS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0211() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0212() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_TX_POWER_LEVEL);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0213() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0214() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0215() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0216() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

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
        data[17] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0217() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SERVICE_DATA_16_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0218() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SERVICE_DATA_32_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0219() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_SERVICE_DATA_128_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0220() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_APPEARANCE);
        AdvertisingDataParser parser = builder.build();

        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0221() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_PUBLIC_TARGET_ADDRESS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0222() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_RANDOM_TARGET_ADDRESS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0223() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_ADVERTISING_INTERVAL);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x00;
        data[3] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0224() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER);
        AdvertisingDataParser parser = builder.build();

        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0225() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_LE_SUPPORTED_FEATURES);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0226() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);
        AdvertisingDataParser parser = builder.build();

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
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0301() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[0];

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0302() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0303() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0304() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0305() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0306() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0307() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0308() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0309() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0310() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0311() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0312() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0313() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0314() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0315() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0316() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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
        data[17] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0317() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0318() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0319() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0320() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0321() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0322() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0323() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x00;
        data[3] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0324() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0325() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0326() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0402() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0403() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0404() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0405() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0406() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        builder.exclude(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0407() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        builder.exclude(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0408() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SHORTENED_LOCAL_NAME);
        builder.exclude(DATA_TYPE_SHORTENED_LOCAL_NAME);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0409() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_COMPLETE_LOCAL_NAME);
        builder.exclude(DATA_TYPE_COMPLETE_LOCAL_NAME);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0410() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_FLAGS);
        builder.exclude(DATA_TYPE_FLAGS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0411() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA);
        builder.exclude(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0412() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_TX_POWER_LEVEL);
        builder.exclude(DATA_TYPE_TX_POWER_LEVEL);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0413() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE);
        builder.exclude(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0414() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS);
        builder.exclude(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0415() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS);
        builder.exclude(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0416() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS);
        builder.exclude(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

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
        data[17] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0417() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SERVICE_DATA_16_BIT_UUID);
        builder.exclude(DATA_TYPE_SERVICE_DATA_16_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0418() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SERVICE_DATA_32_BIT_UUID);
        builder.exclude(DATA_TYPE_SERVICE_DATA_32_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0419() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SERVICE_DATA_128_BIT_UUID);
        builder.exclude(DATA_TYPE_SERVICE_DATA_128_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0420() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_APPEARANCE);
        builder.exclude(DATA_TYPE_APPEARANCE);
        AdvertisingDataParser parser = builder.build();

        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0421() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_PUBLIC_TARGET_ADDRESS);
        builder.exclude(DATA_TYPE_PUBLIC_TARGET_ADDRESS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0422() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_RANDOM_TARGET_ADDRESS);
        builder.exclude(DATA_TYPE_RANDOM_TARGET_ADDRESS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0423() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_ADVERTISING_INTERVAL);
        builder.exclude(DATA_TYPE_ADVERTISING_INTERVAL);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x00;
        data[3] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0424() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER);
        builder.exclude(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER);
        AdvertisingDataParser parser = builder.build();

        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0425() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_LE_SUPPORTED_FEATURES);
        builder.exclude(DATA_TYPE_LE_SUPPORTED_FEATURES);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0426() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);
        builder.exclude(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);
        AdvertisingDataParser parser = builder.build();

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
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }


    @Test
    public void builderTest0502() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNotNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0503() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0504() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0505() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0506() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0507() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0508() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SHORTENED_LOCAL_NAME);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0509() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_COMPLETE_LOCAL_NAME);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNotNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0510() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_FLAGS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNotNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0511() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (companyId & 0x0000ff);
        data[3] = (byte) (companyId & (0x0000ff >> 8));

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNotNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0512() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_TX_POWER_LEVEL);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNotNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0513() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNotNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0514() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNotNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0515() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0516() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS);
        AdvertisingDataParser parser = builder.build();

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
        data[17] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0517() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SERVICE_DATA_16_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 0;
        data[3] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNotNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0518() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SERVICE_DATA_32_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;
        data[5] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNotNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0519() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_SERVICE_DATA_128_BIT_UUID);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNotNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0520() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_APPEARANCE);
        AdvertisingDataParser parser = builder.build();

        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNotNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0521() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_PUBLIC_TARGET_ADDRESS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNotNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0522() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_RANDOM_TARGET_ADDRESS);
        AdvertisingDataParser parser = builder.build();

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

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNotNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0523() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_ADVERTISING_INTERVAL);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x00;
        data[3] = 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNotNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0524() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER);
        AdvertisingDataParser parser = builder.build();

        int schemeKey = 0x000016;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNotNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0525() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_LE_SUPPORTED_FEATURES);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNotNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0526() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);
        AdvertisingDataParser parser = builder.build();

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
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(1, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0600() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[190];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;

        data[38] = 17;
        data[39] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;

        data[56] = 2;
        data[57] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        data[58] = 'a';

        data[59] = 3;
        data[60] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = DATA_TYPE_FLAGS;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = DATA_TYPE_TX_POWER_LEVEL;
        data[72] = -127;

        data[73] = 5;
        data[74] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[91] = 0x00;
        data[92] = 0x00;
        data[93] = 0x00;
        data[94] = 0x00;
        data[95] = 0x00;
        data[96] = 0x00;
        data[97] = 0x00;
        data[98] = 0x00;
        data[99] = 0x00;
        data[100] = 0x00;
        data[101] = 0x00;
        data[102] = 0x00;
        data[103] = 0x00;
        data[104] = 0x00;
        data[105] = 0x00;
        data[106] = 0x00;

        data[107] = 3;
        data[108] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[119] = 0x00;
        data[120] = 0x00;
        data[121] = 0x00;
        data[122] = 0x00;
        data[123] = 0x00;
        data[124] = 0x00;
        data[125] = 0x00;
        data[126] = 0x00;
        data[127] = 0x00;
        data[128] = 0x00;
        data[129] = 0x00;
        data[130] = 0x00;
        data[131] = 0x00;
        data[132] = 0x00;
        data[133] = 0x00;
        data[134] = 0x00;

        data[135] = 3;
        data[136] = DATA_TYPE_APPEARANCE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        data[161] = 0x16;
        data[162] = '/';
        data[163] = '/';
        data[164] = 'i';
        data[165] = 'm';
        data[166] = '9';
        data[167] = '7';
        data[168] = 'm';
        data[169] = 'o';
        data[170] = 'r';
        data[171] = 'i';
        data[172] = '.';
        data[173] = 'o';
        data[174] = 'r';
        data[175] = 'g';
        data[176] = '/';

        data[177] = 2;
        data[178] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[179] = 0b00000001;

        data[180] = 8;
        data[181] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[182] = (byte) 0b11111110;
        data[183] = (byte) 0b11111111;
        data[184] = (byte) 0b11111111;
        data[185] = (byte) 0b11111111;
        data[186] = (byte) 0b11111111;
        data[187] = 0b00000000;
        data[188] = 0b00000000;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(25, result.getResultList().size());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getResultList().get(0).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getResultList().get(1).getDataType());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getResultList().get(2).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getResultList().get(3).getDataType());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS, result.getResultList().get(4).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS, result.getResultList().get(5).getDataType());
        assertEquals(DATA_TYPE_SHORTENED_LOCAL_NAME, result.getResultList().get(6).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LOCAL_NAME, result.getResultList().get(7).getDataType());
        assertEquals(DATA_TYPE_FLAGS, result.getResultList().get(8).getDataType());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getResultList().get(9).getDataType());
        assertEquals(DATA_TYPE_TX_POWER_LEVEL, result.getResultList().get(10).getDataType());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result.getResultList().get(11).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(12).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(13).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(14).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getResultList().get(15).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getResultList().get(16).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getResultList().get(17).getDataType());
        assertEquals(DATA_TYPE_APPEARANCE, result.getResultList().get(18).getDataType());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getResultList().get(19).getDataType());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result.getResultList().get(20).getDataType());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getResultList().get(21).getDataType());
        assertEquals(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER, result.getResultList().get(22).getDataType());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getResultList().get(23).getDataType());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getResultList().get(24).getDataType());
        assertNotNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getShortenedLocalName());
        assertNotNull(result.getCompleteLocalName());
        assertNotNull(result.getFlags());
        assertNotNull(result.getManufacturerSpecificData());
        assertNotNull(result.getTxPowerLevel());
        assertNotNull(result.getSlaveConnectionIntervalRange());
        assertNotNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNotNull(result.getServiceData16BitUUID());
        assertNotNull(result.getServiceData32BitUUID());
        assertNotNull(result.getServiceData128BitUUID());
        assertNotNull(result.getAppearance());
        assertNotNull(result.getPublicTargetAddress());
        assertNotNull(result.getRandomTargetAddress());
        assertNotNull(result.getAdvertisingInterval());
        assertNotNull(result.getUniformRsourceIdentifier());
        assertNotNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0601() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[190];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;

        data[38] = 17;
        data[39] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;

        data[56] = 2;
        data[57] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        data[58] = 'a';

        data[59] = 3;
        data[60] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = DATA_TYPE_FLAGS;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = DATA_TYPE_TX_POWER_LEVEL;
        data[72] = -127;

        data[73] = 5;
        data[74] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[91] = 0x00;
        data[92] = 0x00;
        data[93] = 0x00;
        data[94] = 0x00;
        data[95] = 0x00;
        data[96] = 0x00;
        data[97] = 0x00;
        data[98] = 0x00;
        data[99] = 0x00;
        data[100] = 0x00;
        data[101] = 0x00;
        data[102] = 0x00;
        data[103] = 0x00;
        data[104] = 0x00;
        data[105] = 0x00;
        data[106] = 0x00;

        data[107] = 3;
        data[108] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[119] = 0x00;
        data[120] = 0x00;
        data[121] = 0x00;
        data[122] = 0x00;
        data[123] = 0x00;
        data[124] = 0x00;
        data[125] = 0x00;
        data[126] = 0x00;
        data[127] = 0x00;
        data[128] = 0x00;
        data[129] = 0x00;
        data[130] = 0x00;
        data[131] = 0x00;
        data[132] = 0x00;
        data[133] = 0x00;
        data[134] = 0x00;

        data[135] = 3;
        data[136] = DATA_TYPE_APPEARANCE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        data[161] = 0x16;
        data[162] = '/';
        data[163] = '/';
        data[164] = 'i';
        data[165] = 'm';
        data[166] = '9';
        data[167] = '7';
        data[168] = 'm';
        data[169] = 'o';
        data[170] = 'r';
        data[171] = 'i';
        data[172] = '.';
        data[173] = 'o';
        data[174] = 'r';
        data[175] = 'g';
        data[176] = '/';

        data[177] = 8;
        data[178] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[179] = (byte) 0b11111110;
        data[180] = (byte) 0b11111111;
        data[181] = (byte) 0b11111111;
        data[182] = (byte) 0b11111111;
        data[183] = (byte) 0b11111111;
        data[184] = 0b00000000;
        data[185] = 0b00000000;

        data[186] = 2;
        data[187] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[188] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(25, result.getResultList().size());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getResultList().get(0).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getResultList().get(1).getDataType());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getResultList().get(2).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getResultList().get(3).getDataType());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS, result.getResultList().get(4).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS, result.getResultList().get(5).getDataType());
        assertEquals(DATA_TYPE_SHORTENED_LOCAL_NAME, result.getResultList().get(6).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LOCAL_NAME, result.getResultList().get(7).getDataType());
        assertEquals(DATA_TYPE_FLAGS, result.getResultList().get(8).getDataType());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getResultList().get(9).getDataType());
        assertEquals(DATA_TYPE_TX_POWER_LEVEL, result.getResultList().get(10).getDataType());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result.getResultList().get(11).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(12).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(13).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(14).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getResultList().get(15).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getResultList().get(16).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getResultList().get(17).getDataType());
        assertEquals(DATA_TYPE_APPEARANCE, result.getResultList().get(18).getDataType());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getResultList().get(19).getDataType());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result.getResultList().get(20).getDataType());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getResultList().get(21).getDataType());
        assertEquals(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER, result.getResultList().get(22).getDataType());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getResultList().get(23).getDataType());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getResultList().get(24).getDataType());
        assertNotNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getShortenedLocalName());
        assertNotNull(result.getCompleteLocalName());
        assertNotNull(result.getFlags());
        assertNotNull(result.getManufacturerSpecificData());
        assertNotNull(result.getTxPowerLevel());
        assertNotNull(result.getSlaveConnectionIntervalRange());
        assertNotNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNotNull(result.getServiceData16BitUUID());
        assertNotNull(result.getServiceData32BitUUID());
        assertNotNull(result.getServiceData128BitUUID());
        assertNotNull(result.getAppearance());
        assertNotNull(result.getPublicTargetAddress());
        assertNotNull(result.getRandomTargetAddress());
        assertNotNull(result.getAdvertisingInterval());
        assertNotNull(result.getUniformRsourceIdentifier());
        assertNotNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0602() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.excludeAll().includeAll().build();

        byte[] data = new byte[190];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;

        data[38] = 17;
        data[39] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;

        data[56] = 2;
        data[57] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        data[58] = 'a';

        data[59] = 3;
        data[60] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = DATA_TYPE_FLAGS;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = DATA_TYPE_TX_POWER_LEVEL;
        data[72] = -127;

        data[73] = 5;
        data[74] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[91] = 0x00;
        data[92] = 0x00;
        data[93] = 0x00;
        data[94] = 0x00;
        data[95] = 0x00;
        data[96] = 0x00;
        data[97] = 0x00;
        data[98] = 0x00;
        data[99] = 0x00;
        data[100] = 0x00;
        data[101] = 0x00;
        data[102] = 0x00;
        data[103] = 0x00;
        data[104] = 0x00;
        data[105] = 0x00;
        data[106] = 0x00;

        data[107] = 3;
        data[108] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[119] = 0x00;
        data[120] = 0x00;
        data[121] = 0x00;
        data[122] = 0x00;
        data[123] = 0x00;
        data[124] = 0x00;
        data[125] = 0x00;
        data[126] = 0x00;
        data[127] = 0x00;
        data[128] = 0x00;
        data[129] = 0x00;
        data[130] = 0x00;
        data[131] = 0x00;
        data[132] = 0x00;
        data[133] = 0x00;
        data[134] = 0x00;

        data[135] = 3;
        data[136] = DATA_TYPE_APPEARANCE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        data[161] = 0x16;
        data[162] = '/';
        data[163] = '/';
        data[164] = 'i';
        data[165] = 'm';
        data[166] = '9';
        data[167] = '7';
        data[168] = 'm';
        data[169] = 'o';
        data[170] = 'r';
        data[171] = 'i';
        data[172] = '.';
        data[173] = 'o';
        data[174] = 'r';
        data[175] = 'g';
        data[176] = '/';

        data[177] = 8;
        data[178] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[179] = (byte) 0b11111110;
        data[180] = (byte) 0b11111111;
        data[181] = (byte) 0b11111111;
        data[182] = (byte) 0b11111111;
        data[183] = (byte) 0b11111111;
        data[184] = 0b00000000;
        data[185] = 0b00000000;

        data[186] = 2;
        data[187] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[188] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(25, result.getResultList().size());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getResultList().get(0).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result.getResultList().get(1).getDataType());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getResultList().get(2).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result.getResultList().get(3).getDataType());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS, result.getResultList().get(4).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS, result.getResultList().get(5).getDataType());
        assertEquals(DATA_TYPE_SHORTENED_LOCAL_NAME, result.getResultList().get(6).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LOCAL_NAME, result.getResultList().get(7).getDataType());
        assertEquals(DATA_TYPE_FLAGS, result.getResultList().get(8).getDataType());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result.getResultList().get(9).getDataType());
        assertEquals(DATA_TYPE_TX_POWER_LEVEL, result.getResultList().get(10).getDataType());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result.getResultList().get(11).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(12).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(13).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result.getResultList().get(14).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result.getResultList().get(15).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result.getResultList().get(16).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result.getResultList().get(17).getDataType());
        assertEquals(DATA_TYPE_APPEARANCE, result.getResultList().get(18).getDataType());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getResultList().get(19).getDataType());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result.getResultList().get(20).getDataType());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getResultList().get(21).getDataType());
        assertEquals(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER, result.getResultList().get(22).getDataType());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getResultList().get(23).getDataType());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getResultList().get(24).getDataType());
        assertNotNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNotNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNotNull(result.getShortenedLocalName());
        assertNotNull(result.getCompleteLocalName());
        assertNotNull(result.getFlags());
        assertNotNull(result.getManufacturerSpecificData());
        assertNotNull(result.getTxPowerLevel());
        assertNotNull(result.getSlaveConnectionIntervalRange());
        assertNotNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNotNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNotNull(result.getServiceData16BitUUID());
        assertNotNull(result.getServiceData32BitUUID());
        assertNotNull(result.getServiceData128BitUUID());
        assertNotNull(result.getAppearance());
        assertNotNull(result.getPublicTargetAddress());
        assertNotNull(result.getRandomTargetAddress());
        assertNotNull(result.getAdvertisingInterval());
        assertNotNull(result.getUniformRsourceIdentifier());
        assertNotNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0603() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.excludeAll();
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[190];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;

        data[38] = 17;
        data[39] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;

        data[56] = 2;
        data[57] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        data[58] = 'a';

        data[59] = 3;
        data[60] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = DATA_TYPE_FLAGS;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = DATA_TYPE_TX_POWER_LEVEL;
        data[72] = -127;

        data[73] = 5;
        data[74] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[91] = 0x00;
        data[92] = 0x00;
        data[93] = 0x00;
        data[94] = 0x00;
        data[95] = 0x00;
        data[96] = 0x00;
        data[97] = 0x00;
        data[98] = 0x00;
        data[99] = 0x00;
        data[100] = 0x00;
        data[101] = 0x00;
        data[102] = 0x00;
        data[103] = 0x00;
        data[104] = 0x00;
        data[105] = 0x00;
        data[106] = 0x00;

        data[107] = 3;
        data[108] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[119] = 0x00;
        data[120] = 0x00;
        data[121] = 0x00;
        data[122] = 0x00;
        data[123] = 0x00;
        data[124] = 0x00;
        data[125] = 0x00;
        data[126] = 0x00;
        data[127] = 0x00;
        data[128] = 0x00;
        data[129] = 0x00;
        data[130] = 0x00;
        data[131] = 0x00;
        data[132] = 0x00;
        data[133] = 0x00;
        data[134] = 0x00;

        data[135] = 3;
        data[136] = DATA_TYPE_APPEARANCE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        data[161] = 0x16;
        data[162] = '/';
        data[163] = '/';
        data[164] = 'i';
        data[165] = 'm';
        data[166] = '9';
        data[167] = '7';
        data[168] = 'm';
        data[169] = 'o';
        data[170] = 'r';
        data[171] = 'i';
        data[172] = '.';
        data[173] = 'o';
        data[174] = 'r';
        data[175] = 'g';
        data[176] = '/';

        data[177] = 8;
        data[178] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[179] = (byte) 0b11111110;
        data[180] = (byte) 0b11111111;
        data[181] = (byte) 0b11111111;
        data[182] = (byte) 0b11111111;
        data[183] = (byte) 0b11111111;
        data[184] = 0b00000000;
        data[185] = 0b00000000;

        data[186] = 2;
        data[187] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[188] = 0b00000001;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(0, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0604() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 3;
        data[5] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[6] = 0;
        data[7] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertEquals(2, result.getIncompleteListOf16BitServiceUUIDsList().size());
        assertEquals(result.getIncompleteListOf16BitServiceUUIDs(), result.getIncompleteListOf16BitServiceUUIDsList().get(1));
        assertEquals(BASE_UUID, result.getIncompleteListOf16BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0605() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 3;
        data[5] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[6] = 0;
        data[7] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertEquals(2, result.getCompleteListOf16BitServiceUUIDsList().size());
        assertEquals(result.getCompleteListOf16BitServiceUUIDs(), result.getCompleteListOf16BitServiceUUIDsList().get(1));
        assertEquals(BASE_UUID, result.getCompleteListOf16BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0606() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 5;
        data[7] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[8] = 0;
        data[9] = 0;
        data[10] = 0;
        data[11] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertEquals(2, result.getIncompleteListOf32BitServiceUUIDsList().size());
        assertEquals(result.getIncompleteListOf32BitServiceUUIDs(), result.getIncompleteListOf32BitServiceUUIDsList().get(1));
        assertEquals(BASE_UUID, result.getIncompleteListOf32BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0607() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 5;
        data[7] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[8] = 0;
        data[9] = 0;
        data[10] = 0;
        data[11] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertEquals(2, result.getCompleteListOf32BitServiceUUIDsList().size());
        assertEquals(result.getCompleteListOf32BitServiceUUIDs(), result.getCompleteListOf32BitServiceUUIDsList().get(1));
        assertEquals(BASE_UUID, result.getCompleteListOf32BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0608() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[36];
        data[0] = 17;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 1;
        data[7] = 1;
        data[8] = 1;
        data[9] = 1;
        data[10] = 1;
        data[11] = 1;
        data[12] = 1;
        data[13] = 1;
        data[14] = 1;
        data[15] = 1;
        data[16] = 1;
        data[17] = 1;
        data[18] = 17;
        data[19] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[20] = 0;
        data[21] = 0;
        data[22] = 0;
        data[23] = 0;
        data[24] = 0;
        data[25] = 0;
        data[26] = 0;
        data[27] = 0;
        data[28] = 0;
        data[29] = 0;
        data[30] = 0;
        data[31] = 0;
        data[32] = 0;
        data[33] = 0;
        data[34] = 0;
        data[35] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertEquals(2, result.getIncompleteListOf128BitServiceUUIDsList().size());
        assertEquals(result.getIncompleteListOf128BitServiceUUIDs(), result.getIncompleteListOf128BitServiceUUIDsList().get(1));
        assertEquals(new UUID(0, 0), result.getIncompleteListOf128BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0609() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[36];
        data[0] = 17;
        data[1] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 1;
        data[7] = 1;
        data[8] = 1;
        data[9] = 1;
        data[10] = 1;
        data[11] = 1;
        data[12] = 1;
        data[13] = 1;
        data[14] = 1;
        data[15] = 1;
        data[16] = 1;
        data[17] = 1;
        data[18] = 17;
        data[19] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[20] = 0;
        data[21] = 0;
        data[22] = 0;
        data[23] = 0;
        data[24] = 0;
        data[25] = 0;
        data[26] = 0;
        data[27] = 0;
        data[28] = 0;
        data[29] = 0;
        data[30] = 0;
        data[31] = 0;
        data[32] = 0;
        data[33] = 0;
        data[34] = 0;
        data[35] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertEquals(2, result.getCompleteListOf128BitServiceUUIDsList().size());
        assertEquals(result.getCompleteListOf128BitServiceUUIDs(), result.getCompleteListOf128BitServiceUUIDsList().get(1));
        assertEquals(new UUID(0, 0), result.getCompleteListOf128BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0610() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[2] = (byte) (0x000000E0 & 0x0000ff);
        data[3] = (byte) (0x000000E0 & (0x0000ff >> 8));
        data[4] = 3;
        data[5] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[6] = (byte) (0x00000008 & 0x0000ff);
        data[7] = (byte) (0x00000008 & (0x0000ff >> 8));

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertEquals(2, result.getManufacturerSpecificDataList().size());
        assertEquals(result.getManufacturerSpecificData(), result.getManufacturerSpecificDataList().get(1));
        assertEquals(0x00000008, result.getManufacturerSpecificData().getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING.get(0x00000008), result.getManufacturerSpecificData().getCompanyName());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0611() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;
        data[3] = 2;
        data[4] = DATA_TYPE_TX_POWER_LEVEL;
        data[5] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertEquals(2, result.getTxPowerLevelList().size());
        assertEquals(result.getTxPowerLevel(), result.getTxPowerLevelList().get(1));
        assertEquals(0, result.getTxPowerLevel().getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0612() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;
        data[6] = 5;
        data[7] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[8] = (byte) 0x06;
        data[9] = (byte) 0x00;
        data[10] = (byte) 0x06;
        data[11] = (byte) 0x00;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertEquals(2, result.getSlaveConnectionIntervalRangeList().size());
        assertEquals(result.getSlaveConnectionIntervalRange(), result.getSlaveConnectionIntervalRangeList().get(1));
        assertTrue(result.getSlaveConnectionIntervalRange().hasMaximum());
        assertEquals(0d, 0x0006 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getSlaveConnectionIntervalRange().getMaximumValueMillis());
        assertTrue(result.getSlaveConnectionIntervalRange().hasMinimum());
        assertEquals(0d, 0x0006 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getSlaveConnectionIntervalRange().getMinimumValueMillis());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0613() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 3;
        data[5] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[6] = 0;
        data[7] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertEquals(2, result.getListOf16BitServiceSolicitationUUIDsList().size());
        assertEquals(result.getListOf16BitServiceSolicitationUUIDs(), result.getListOf16BitServiceSolicitationUUIDsList().get(1));
        assertEquals(BASE_UUID, result.getListOf16BitServiceSolicitationUUIDs().getUuidList().get(0));
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0614() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 5;
        data[7] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[8] = 0;
        data[9] = 0;
        data[10] = 0;
        data[11] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertEquals(2, result.getListOf32BitServiceSolicitationUUIDsList().size());
        assertEquals(result.getListOf32BitServiceSolicitationUUIDs(), result.getListOf32BitServiceSolicitationUUIDsList().get(1));
        assertEquals(BASE_UUID, result.getListOf32BitServiceSolicitationUUIDs().getUuidList().get(0));
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0615() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[36];
        data[0] = 17;
        data[1] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 1;
        data[7] = 1;
        data[8] = 1;
        data[9] = 1;
        data[10] = 1;
        data[11] = 1;
        data[12] = 1;
        data[13] = 1;
        data[14] = 1;
        data[15] = 1;
        data[16] = 1;
        data[17] = 1;
        data[18] = 17;
        data[19] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[20] = 0;
        data[21] = 0;
        data[22] = 0;
        data[23] = 0;
        data[24] = 0;
        data[25] = 0;
        data[26] = 0;
        data[27] = 0;
        data[28] = 0;
        data[29] = 0;
        data[30] = 0;
        data[31] = 0;
        data[32] = 0;
        data[33] = 0;
        data[34] = 0;
        data[35] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertEquals(2, result.getListOf128BitServiceSolicitationUUIDsList().size());
        assertEquals(result.getListOf128BitServiceSolicitationUUIDs(), result.getListOf128BitServiceSolicitationUUIDsList().get(1));
        assertEquals(new UUID(0, 0), result.getListOf128BitServiceSolicitationUUIDs().getUuidList().get(0));
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0616() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[2] = 1;
        data[3] = 1;
        data[4] = 3;
        data[5] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[6] = 0;
        data[7] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertEquals(2, result.getServiceData16BitUUIDList().size());
        assertEquals(result.getServiceData16BitUUID(), result.getServiceData16BitUUIDList().get(1));
        assertEquals(BASE_UUID, result.getServiceData16BitUUID().getUuid());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0617() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 5;
        data[7] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[8] = 0;
        data[9] = 0;
        data[10] = 0;
        data[11] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertEquals(2, result.getServiceData32BitUUIDList().size());
        assertEquals(result.getServiceData32BitUUID(), result.getServiceData32BitUUIDList().get(1));
        assertEquals(BASE_UUID, result.getServiceData32BitUUID().getUuid());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0618() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[36];
        data[0] = 17;
        data[1] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 1;
        data[7] = 1;
        data[8] = 1;
        data[9] = 1;
        data[10] = 1;
        data[11] = 1;
        data[12] = 1;
        data[13] = 1;
        data[14] = 1;
        data[15] = 1;
        data[16] = 1;
        data[17] = 1;
        data[18] = 17;
        data[19] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[20] = 0;
        data[21] = 0;
        data[22] = 0;
        data[23] = 0;
        data[24] = 0;
        data[25] = 0;
        data[26] = 0;
        data[27] = 0;
        data[28] = 0;
        data[29] = 0;
        data[30] = 0;
        data[31] = 0;
        data[32] = 0;
        data[33] = 0;
        data[34] = 0;
        data[35] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertEquals(2, result.getServiceData128BitUUIDList().size());
        assertEquals(result.getServiceData128BitUUID(), result.getServiceData128BitUUIDList().get(1));
        assertEquals(new UUID(0, 0), result.getServiceData128BitUUID().getUuid());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getUniformRsourceIdentifier());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0619() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[23];
        data[0] = 10;
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        data[2] = 0x16;
        data[3] = '/';
        data[4] = '/';
        data[5] = 'i';
        data[6] = 'm';
        data[7] = 'o';
        data[8] = 'r';
        data[9] = 'i';
        data[10] = '/';
        data[11] = 11;
        data[12] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        data[13] = (byte) 0xc2;
        data[14] = (byte) 0xb9;
        data[15] = '/';
        data[16] = '/';
        data[17] = 'i';
        data[18] = 'm';
        data[19] = 'o';
        data[20] = 'r';
        data[21] = 'i';
        data[22] = '/';

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertNull(result.getCompleteListOf16BitServiceUUIDs());
        assertNull(result.getIncompleteListOf32BitServiceUUIDs());
        assertNull(result.getCompleteListOf32BitServiceUUIDs());
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getSlaveConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertEquals(2, result.getUniformRsourceIdentifierList().size());
        assertEquals(result.getUniformRsourceIdentifier(), result.getUniformRsourceIdentifierList().get(1));
        assertEquals(URI.create(URI_SCHEME_NAME_STRING_MAPPING.get(0xb9) + new String(data, 15, 8)), result.getUniformRsourceIdentifier().getUri());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
    }

    @Test
    public void builderTest0620() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[190];
        data[0] = 3;
        data[1] = DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;

        data[38] = 17;
        data[39] = DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;

        data[56] = 2;
        data[57] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        data[58] = 'a';

        data[59] = 3;
        data[60] = DATA_TYPE_COMPLETE_LOCAL_NAME;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = DATA_TYPE_FLAGS;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = DATA_TYPE_TX_POWER_LEVEL;
        data[72] = -127;

        data[73] = 5;
        data[74] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
        data[91] = 0x00;
        data[92] = 0x00;
        data[93] = 0x00;
        data[94] = 0x00;
        data[95] = 0x00;
        data[96] = 0x00;
        data[97] = 0x00;
        data[98] = 0x00;
        data[99] = 0x00;
        data[100] = 0x00;
        data[101] = 0x00;
        data[102] = 0x00;
        data[103] = 0x00;
        data[104] = 0x00;
        data[105] = 0x00;
        data[106] = 0x00;

        data[107] = 3;
        data[108] = DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
        data[119] = 0x00;
        data[120] = 0x00;
        data[121] = 0x00;
        data[122] = 0x00;
        data[123] = 0x00;
        data[124] = 0x00;
        data[125] = 0x00;
        data[126] = 0x00;
        data[127] = 0x00;
        data[128] = 0x00;
        data[129] = 0x00;
        data[130] = 0x00;
        data[131] = 0x00;
        data[132] = 0x00;
        data[133] = 0x00;
        data[134] = 0x00;

        data[135] = 3;
        data[136] = DATA_TYPE_APPEARANCE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = DATA_TYPE_RANDOM_TARGET_ADDRESS;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        data[161] = 0x16;
        data[162] = '/';
        data[163] = '/';
        data[164] = 'i';
        data[165] = 'm';
        data[166] = '9';
        data[167] = '7';
        data[168] = 'm';
        data[169] = 'o';
        data[170] = 'r';
        data[171] = 'i';
        data[172] = '.';
        data[173] = 'o';
        data[174] = 'r';
        data[175] = 'g';
        data[176] = '/';

        data[177] = 2;
        data[178] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[179] = 0b00000001;

        data[180] = 8;
        data[181] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[182] = (byte) 0b11111110;
        data[183] = (byte) 0b11111111;
        data[184] = (byte) 0b11111111;
        data[185] = (byte) 0b11111111;
        data[186] = (byte) 0b11111111;
        data[187] = 0b00000000;
        data[188] = 0b00000000;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);
        Parcel parcel = Parcel.obtain();
        result.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingDataParser.AdvertisingDataParseResult result2 = AdvertisingDataParser.AdvertisingDataParseResult.CREATOR.createFromParcel(parcel);

        assertNotNull(result2);
        assertNotNull(result2.getResultList());
        assertEquals(25, result2.getResultList().size());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result2.getResultList().get(0).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS, result2.getResultList().get(1).getDataType());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result2.getResultList().get(2).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS, result2.getResultList().get(3).getDataType());
        assertEquals(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS, result2.getResultList().get(4).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS, result2.getResultList().get(5).getDataType());
        assertEquals(DATA_TYPE_SHORTENED_LOCAL_NAME, result2.getResultList().get(6).getDataType());
        assertEquals(DATA_TYPE_COMPLETE_LOCAL_NAME, result2.getResultList().get(7).getDataType());
        assertEquals(DATA_TYPE_FLAGS, result2.getResultList().get(8).getDataType());
        assertEquals(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA, result2.getResultList().get(9).getDataType());
        assertEquals(DATA_TYPE_TX_POWER_LEVEL, result2.getResultList().get(10).getDataType());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result2.getResultList().get(11).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS, result2.getResultList().get(12).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS, result2.getResultList().get(13).getDataType());
        assertEquals(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS, result2.getResultList().get(14).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_16_BIT_UUID, result2.getResultList().get(15).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_32_BIT_UUID, result2.getResultList().get(16).getDataType());
        assertEquals(DATA_TYPE_SERVICE_DATA_128_BIT_UUID, result2.getResultList().get(17).getDataType());
        assertEquals(DATA_TYPE_APPEARANCE, result2.getResultList().get(18).getDataType());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result2.getResultList().get(19).getDataType());
        assertEquals(DATA_TYPE_RANDOM_TARGET_ADDRESS, result2.getResultList().get(20).getDataType());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result2.getResultList().get(21).getDataType());
        assertEquals(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER, result2.getResultList().get(22).getDataType());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result2.getResultList().get(23).getDataType());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result2.getResultList().get(24).getDataType());
        assertNotNull(result2.getIncompleteListOf16BitServiceUUIDs());
        assertNotNull(result2.getCompleteListOf16BitServiceUUIDs());
        assertNotNull(result2.getIncompleteListOf32BitServiceUUIDs());
        assertNotNull(result2.getCompleteListOf32BitServiceUUIDs());
        assertNotNull(result2.getIncompleteListOf128BitServiceUUIDs());
        assertNotNull(result2.getCompleteListOf128BitServiceUUIDs());
        assertNotNull(result2.getShortenedLocalName());
        assertNotNull(result2.getCompleteLocalName());
        assertNotNull(result2.getFlags());
        assertNotNull(result2.getManufacturerSpecificData());
        assertNotNull(result2.getTxPowerLevel());
        assertNotNull(result2.getSlaveConnectionIntervalRange());
        assertNotNull(result2.getListOf16BitServiceSolicitationUUIDs());
        assertNotNull(result2.getListOf32BitServiceSolicitationUUIDs());
        assertNotNull(result2.getListOf128BitServiceSolicitationUUIDs());
        assertNotNull(result2.getServiceData16BitUUID());
        assertNotNull(result2.getServiceData32BitUUID());
        assertNotNull(result2.getServiceData128BitUUID());
        assertNotNull(result2.getAppearance());
        assertNotNull(result2.getPublicTargetAddress());
        assertNotNull(result2.getRandomTargetAddress());
        assertNotNull(result2.getAdvertisingInterval());
        assertNotNull(result2.getUniformRsourceIdentifier());
        assertNotNull(result2.getLeSupportedFeatures());
        assertNotNull(result2.getChannelMapUpdateIndication());
    }
}
