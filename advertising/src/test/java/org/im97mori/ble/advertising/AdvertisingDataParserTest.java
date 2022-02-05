package org.im97mori.ble.advertising;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.im97mori.ble.advertising.PeripheralConnectionIntervalRange.PERIPHERAL_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS;
import static org.im97mori.ble.constants.CompanyUUID.COMPANY_MAPPING_128;
import static org.im97mori.ble.constants.DataType.ADVERTISING_INTERVAL_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.ADVERTISING_INTERVAL_LONG_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.APPEARANCE_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.BIG_INFO_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LOCAL_NAME_DATA_TYPE;
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
import static org.im97mori.ble.constants.Scheme.SCHEME_MAPPING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.TransportDiscoveryServiceUtils;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.constants.AppearanceValues;
import org.im97mori.ble.constants.Scheme;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.net.URI;
import java.util.UUID;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("ALL")
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0002() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0003() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0004() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0005() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0006() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0007() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0008() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0009() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0010() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = FLAGS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0011() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0012() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0013() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
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
        assertNotNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0014() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0015() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0016() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0017() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0018() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0019() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0020() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0023() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0024() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] schemedata = Scheme.HTTP_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemedata.length];
        data[0] = (byte) (utf8data.length + schemedata.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemedata, 0, data, 2, schemedata.length);
        System.arraycopy(utf8data, 0, data, 2 + schemedata.length, utf8data.length);

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNotNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0025() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = INDOOR_POSITIONING_DATA_TYPE;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNotNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0026() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNotNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0027() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNotNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0028() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0029() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNotNull(result.getBigInfo());
    }

    @Test
    public void builderTest0030() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNotNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0102() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.exclude(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE).include(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE).build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0103() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.include(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0104() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.include(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0105() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.include(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0106() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.include(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0107() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.include(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0108() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(SHORTENED_LOCAL_NAME_DATA_TYPE);
        builder.include(SHORTENED_LOCAL_NAME_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0109() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(COMPLETE_LOCAL_NAME_DATA_TYPE);
        builder.include(COMPLETE_LOCAL_NAME_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0110() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(FLAGS_DATA_TYPE);
        builder.include(FLAGS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = FLAGS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0111() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE);
        builder.include(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0112() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(TX_POWER_LEVEL_DATA_TYPE);
        builder.include(TX_POWER_LEVEL_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0113() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE);
        builder.include(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
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
        assertNotNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0114() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        builder.include(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0115() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        builder.include(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0116() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        builder.include(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0117() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(SERVICE_DATA_16_BIT_UUID_DATA_TYPE);
        builder.include(SERVICE_DATA_16_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0118() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(SERVICE_DATA_32_BIT_UUID_DATA_TYPE);
        builder.include(SERVICE_DATA_32_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0119() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(SERVICE_DATA_128_BIT_UUID_DATA_TYPE);
        builder.include(SERVICE_DATA_128_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0120() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(APPEARANCE_DATA_TYPE);
        builder.include(APPEARANCE_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0121() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(PUBLIC_TARGET_ADDRESS_DATA_TYPE);
        builder.include(PUBLIC_TARGET_ADDRESS_DATA_TYPE);
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0122() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(RANDOM_TARGET_ADDRESS_DATA_TYPE);
        builder.include(RANDOM_TARGET_ADDRESS_DATA_TYPE);
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0123() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(ADVERTISING_INTERVAL_DATA_TYPE);
        builder.include(ADVERTISING_INTERVAL_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0124() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(URI_DATA_TYPE);
        builder.include(URI_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] schemedata = Scheme.HTTP_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemedata.length];
        data[0] = (byte) (utf8data.length + schemedata.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemedata, 0, data, 2, schemedata.length);
        System.arraycopy(utf8data, 0, data, 2 + schemedata.length, utf8data.length);

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNotNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0125() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(INDOOR_POSITIONING_DATA_TYPE);
        builder.include(INDOOR_POSITIONING_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = INDOOR_POSITIONING_DATA_TYPE;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNotNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0126() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(TRANSPORT_DISCOVERY_DATA_DATA_TYPE);
        builder.include(TRANSPORT_DISCOVERY_DATA_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNotNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0127() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(LE_SUPPORTED_FEATURES_DATA_TYPE);
        builder.include(LE_SUPPORTED_FEATURES_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNotNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0128() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE);
        builder.include(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0129() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(BIG_INFO_DATA_TYPE);
        builder.include(BIG_INFO_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNotNull(result.getBigInfo());
    }

    @Test
    public void builderTest0130() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(ADVERTISING_INTERVAL_LONG_DATA_TYPE);
        builder.include(ADVERTISING_INTERVAL_LONG_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNotNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0202() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0203() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0204() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0205() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0206() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0207() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0208() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(SHORTENED_LOCAL_NAME_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0209() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(COMPLETE_LOCAL_NAME_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0210() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(FLAGS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = FLAGS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0211() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0212() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(TX_POWER_LEVEL_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0213() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0214() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0215() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0216() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0217() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(SERVICE_DATA_16_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0218() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(SERVICE_DATA_32_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0219() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(SERVICE_DATA_128_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0220() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(APPEARANCE_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0221() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(PUBLIC_TARGET_ADDRESS_DATA_TYPE);
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0222() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(RANDOM_TARGET_ADDRESS_DATA_TYPE);
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0223() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(ADVERTISING_INTERVAL_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0224() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(URI_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] schemedata = Scheme.HTTP_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemedata.length];
        data[0] = (byte) (utf8data.length + schemedata.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemedata, 0, data, 2, schemedata.length);
        System.arraycopy(utf8data, 0, data, 2 + schemedata.length, utf8data.length);

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0225() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(INDOOR_POSITIONING_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = INDOOR_POSITIONING_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0226() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(TRANSPORT_DISCOVERY_DATA_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0227() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(LE_SUPPORTED_FEATURES_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0228() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0229() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(BIG_INFO_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0230() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.exclude(ADVERTISING_INTERVAL_LONG_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0302() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0303() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0304() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0305() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0306() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0307() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0308() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0309() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0310() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = FLAGS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0311() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0312() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0313() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0314() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0315() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0316() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0317() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0318() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0319() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0320() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0323() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0324() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] schemedata = Scheme.HTTP_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemedata.length];
        data[0] = (byte) (utf8data.length + schemedata.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemedata, 0, data, 2, schemedata.length);
        System.arraycopy(utf8data, 0, data, 2 + schemedata.length, utf8data.length);

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0325() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = INDOOR_POSITIONING_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0326() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0327() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0328() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0329() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0330() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0402() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.exclude(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0403() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.exclude(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0404() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.exclude(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0405() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.exclude(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0406() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.exclude(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0407() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        builder.exclude(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0408() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(SHORTENED_LOCAL_NAME_DATA_TYPE);
        builder.exclude(SHORTENED_LOCAL_NAME_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0409() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(COMPLETE_LOCAL_NAME_DATA_TYPE);
        builder.exclude(COMPLETE_LOCAL_NAME_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0410() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(FLAGS_DATA_TYPE);
        builder.exclude(FLAGS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = FLAGS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0411() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE);
        builder.exclude(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0412() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(TX_POWER_LEVEL_DATA_TYPE);
        builder.exclude(TX_POWER_LEVEL_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0413() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE);
        builder.exclude(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0414() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        builder.exclude(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0415() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        builder.exclude(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0416() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        builder.exclude(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0417() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(SERVICE_DATA_16_BIT_UUID_DATA_TYPE);
        builder.exclude(SERVICE_DATA_16_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0418() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(SERVICE_DATA_32_BIT_UUID_DATA_TYPE);
        builder.exclude(SERVICE_DATA_32_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0419() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(SERVICE_DATA_128_BIT_UUID_DATA_TYPE);
        builder.exclude(SERVICE_DATA_128_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0420() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(APPEARANCE_DATA_TYPE);
        builder.exclude(APPEARANCE_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0421() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(PUBLIC_TARGET_ADDRESS_DATA_TYPE);
        builder.exclude(PUBLIC_TARGET_ADDRESS_DATA_TYPE);
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0422() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(RANDOM_TARGET_ADDRESS_DATA_TYPE);
        builder.exclude(RANDOM_TARGET_ADDRESS_DATA_TYPE);
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0423() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(ADVERTISING_INTERVAL_DATA_TYPE);
        builder.exclude(ADVERTISING_INTERVAL_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0424() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(URI_DATA_TYPE);
        builder.exclude(URI_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] schemedata = Scheme.HTTP_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemedata.length];
        data[0] = (byte) (utf8data.length + schemedata.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemedata, 0, data, 2, schemedata.length);
        System.arraycopy(utf8data, 0, data, 2 + schemedata.length, utf8data.length);

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0425() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INDOOR_POSITIONING_DATA_TYPE);
        builder.exclude(INDOOR_POSITIONING_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = INDOOR_POSITIONING_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0426() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INDOOR_POSITIONING_DATA_TYPE);
        builder.exclude(INDOOR_POSITIONING_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0427() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(LE_SUPPORTED_FEATURES_DATA_TYPE);
        builder.exclude(LE_SUPPORTED_FEATURES_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0428() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE);
        builder.exclude(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0429() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(BIG_INFO_DATA_TYPE);
        builder.exclude(BIG_INFO_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0430() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(ADVERTISING_INTERVAL_LONG_DATA_TYPE);
        builder.exclude(ADVERTISING_INTERVAL_LONG_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0502() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0503() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0504() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0505() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0506() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0507() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0508() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(SHORTENED_LOCAL_NAME_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        String name = "shortened local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = SHORTENED_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0509() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(COMPLETE_LOCAL_NAME_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        String name = "complete local name";
        byte[] utf8data = name.getBytes();
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = COMPLETE_LOCAL_NAME_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0510() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(FLAGS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = FLAGS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0511() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        int companyId = 0x000000E0;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0512() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(TX_POWER_LEVEL_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0513() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
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
        assertNotNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0514() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0515() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0516() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0517() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(SERVICE_DATA_16_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0518() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(SERVICE_DATA_32_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0519() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(SERVICE_DATA_128_BIT_UUID_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0520() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(APPEARANCE_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        int key = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0521() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(PUBLIC_TARGET_ADDRESS_DATA_TYPE);
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
        data[1] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0522() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(RANDOM_TARGET_ADDRESS_DATA_TYPE);
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
        data[1] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0523() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(ADVERTISING_INTERVAL_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = ADVERTISING_INTERVAL_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0524() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(URI_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] schemedata = Scheme.HTTP_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemedata.length];
        data[0] = (byte) (utf8data.length + schemedata.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemedata, 0, data, 2, schemedata.length);
        System.arraycopy(utf8data, 0, data, 2 + schemedata.length, utf8data.length);

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNotNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0525() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(INDOOR_POSITIONING_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = INDOOR_POSITIONING_DATA_TYPE;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNotNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0526() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(TRANSPORT_DISCOVERY_DATA_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = 0;
        data[4] = 0;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNotNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0527() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(LE_SUPPORTED_FEATURES_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNotNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0528() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0529() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(BIG_INFO_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNotNull(result.getBigInfo());
    }

    @Test
    public void builderTest0530() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false);
        builder.include(ADVERTISING_INTERVAL_LONG_DATA_TYPE);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = ADVERTISING_INTERVAL_LONG_DATA_TYPE;
        data[2] = 0x00;
        data[3] = 0x00;
        data[4] = 0x00;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNotNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0600() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[232];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[39] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[57] = SHORTENED_LOCAL_NAME_DATA_TYPE;
        data[58] = 'a';

        data[59] = 3;
        data[60] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = FLAGS_DATA_TYPE;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = TX_POWER_LEVEL_DATA_TYPE;
        data[72] = -127;

        data[73] = 5;
        data[74] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[108] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[136] = APPEARANCE_DATA_TYPE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = URI_DATA_TYPE;
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
        data[178] = INDOOR_POSITIONING_DATA_TYPE;
        data[179] = 0b00000000;

        data[180] = 4;
        data[181] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[182] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[183] = 0;
        data[184] = 0;

        data[185] = 2;
        data[186] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[187] = 0b00000001;

        data[188] = 8;
        data[189] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[190] = (byte) 0b11111110;
        data[191] = (byte) 0b11111111;
        data[192] = (byte) 0b11111111;
        data[193] = (byte) 0b11111111;
        data[194] = (byte) 0b11111111;
        data[195] = 0b00000000;
        data[196] = 0b00000000;

        data[197] = 34;
        data[198] = BIG_INFO_DATA_TYPE;
        data[199] = 0b00000000;
        data[200] = 0b00000000;
        data[201] = 0b00000000;
        data[202] = 0b00000000;
        data[203] = 0b00000000;
        data[204] = 0b00000000;
        data[205] = 0b00000000;
        data[206] = 0b00000000;
        data[207] = 0b00000000;
        data[208] = 0b00000000;
        data[209] = 0b00000000;
        data[210] = 0b00000000;
        data[211] = 0b00000000;
        data[212] = 0b00000000;
        data[213] = 0b00000000;
        data[214] = 0b00000000;
        data[215] = 0b00000000;
        data[216] = 0b00000000;
        data[217] = 0b00000000;
        data[218] = 0b00000000;
        data[219] = 0b00000000;
        data[220] = 0b00000000;
        data[221] = 0b00000000;
        data[222] = 0b00000000;
        data[223] = 0b00000000;
        data[224] = 0b00000000;
        data[225] = 0b00000000;
        data[226] = 0b00000000;
        data[227] = 0b00000000;
        data[228] = 0b00000000;
        data[229] = 0b00000000;
        data[220] = 0b00000000;
        data[231] = 0b00000000;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(28, result.getResultList().size());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(0).getDataType());
        assertEquals(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(1).getDataType());
        assertEquals(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(2).getDataType());
        assertEquals(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(3).getDataType());
        assertEquals(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(4).getDataType());
        assertEquals(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(5).getDataType());
        assertEquals(SHORTENED_LOCAL_NAME_DATA_TYPE, result.getResultList().get(6).getDataType());
        assertEquals(COMPLETE_LOCAL_NAME_DATA_TYPE, result.getResultList().get(7).getDataType());
        assertEquals(FLAGS_DATA_TYPE, result.getResultList().get(8).getDataType());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result.getResultList().get(9).getDataType());
        assertEquals(TX_POWER_LEVEL_DATA_TYPE, result.getResultList().get(10).getDataType());
        assertEquals(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE, result.getResultList().get(11).getDataType());
        assertEquals(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(12).getDataType());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(13).getDataType());
        assertEquals(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(14).getDataType());
        assertEquals(SERVICE_DATA_16_BIT_UUID_DATA_TYPE, result.getResultList().get(15).getDataType());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result.getResultList().get(16).getDataType());
        assertEquals(SERVICE_DATA_128_BIT_UUID_DATA_TYPE, result.getResultList().get(17).getDataType());
        assertEquals(APPEARANCE_DATA_TYPE, result.getResultList().get(18).getDataType());
        assertEquals(PUBLIC_TARGET_ADDRESS_DATA_TYPE, result.getResultList().get(19).getDataType());
        assertEquals(RANDOM_TARGET_ADDRESS_DATA_TYPE, result.getResultList().get(20).getDataType());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result.getResultList().get(21).getDataType());
        assertEquals(URI_DATA_TYPE, result.getResultList().get(22).getDataType());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result.getResultList().get(23).getDataType());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result.getResultList().get(24).getDataType());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result.getResultList().get(25).getDataType());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result.getResultList().get(26).getDataType());
        assertEquals(BIG_INFO_DATA_TYPE, result.getResultList().get(27).getDataType());
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
        assertNotNull(result.getPeripheralConnectionIntervalRange());
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
        assertNotNull(result.getUniformResourceIdentifier());
        assertNotNull(result.getIndoorPositioning());
        assertNotNull(result.getTransportDiscoveryData());
        assertNotNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
        assertNotNull(result.getBigInfo());
    }

    @Test
    public void builderTest0601() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[232];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[39] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[57] = SHORTENED_LOCAL_NAME_DATA_TYPE;
        data[58] = 'a';

        data[59] = 3;
        data[60] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = FLAGS_DATA_TYPE;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = TX_POWER_LEVEL_DATA_TYPE;
        data[72] = -127;

        data[73] = 5;
        data[74] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[108] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[136] = APPEARANCE_DATA_TYPE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = URI_DATA_TYPE;
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
        data[178] = INDOOR_POSITIONING_DATA_TYPE;
        data[179] = 0b00000000;

        data[180] = 4;
        data[181] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[182] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[183] = 0;
        data[184] = 0;

        data[185] = 2;
        data[186] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[187] = 0b00000001;

        data[188] = 8;
        data[189] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[190] = (byte) 0b11111110;
        data[191] = (byte) 0b11111111;
        data[192] = (byte) 0b11111111;
        data[193] = (byte) 0b11111111;
        data[194] = (byte) 0b11111111;
        data[195] = 0b00000000;
        data[196] = 0b00000000;

        data[197] = 34;
        data[198] = BIG_INFO_DATA_TYPE;
        data[199] = 0b00000000;
        data[200] = 0b00000000;
        data[201] = 0b00000000;
        data[202] = 0b00000000;
        data[203] = 0b00000000;
        data[204] = 0b00000000;
        data[205] = 0b00000000;
        data[206] = 0b00000000;
        data[207] = 0b00000000;
        data[208] = 0b00000000;
        data[209] = 0b00000000;
        data[210] = 0b00000000;
        data[211] = 0b00000000;
        data[212] = 0b00000000;
        data[213] = 0b00000000;
        data[214] = 0b00000000;
        data[215] = 0b00000000;
        data[216] = 0b00000000;
        data[217] = 0b00000000;
        data[218] = 0b00000000;
        data[219] = 0b00000000;
        data[220] = 0b00000000;
        data[221] = 0b00000000;
        data[222] = 0b00000000;
        data[223] = 0b00000000;
        data[224] = 0b00000000;
        data[225] = 0b00000000;
        data[226] = 0b00000000;
        data[227] = 0b00000000;
        data[228] = 0b00000000;
        data[229] = 0b00000000;
        data[220] = 0b00000000;
        data[231] = 0b00000000;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(28, result.getResultList().size());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(0).getDataType());
        assertEquals(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(1).getDataType());
        assertEquals(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(2).getDataType());
        assertEquals(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(3).getDataType());
        assertEquals(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(4).getDataType());
        assertEquals(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(5).getDataType());
        assertEquals(SHORTENED_LOCAL_NAME_DATA_TYPE, result.getResultList().get(6).getDataType());
        assertEquals(COMPLETE_LOCAL_NAME_DATA_TYPE, result.getResultList().get(7).getDataType());
        assertEquals(FLAGS_DATA_TYPE, result.getResultList().get(8).getDataType());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result.getResultList().get(9).getDataType());
        assertEquals(TX_POWER_LEVEL_DATA_TYPE, result.getResultList().get(10).getDataType());
        assertEquals(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE, result.getResultList().get(11).getDataType());
        assertEquals(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(12).getDataType());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(13).getDataType());
        assertEquals(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(14).getDataType());
        assertEquals(SERVICE_DATA_16_BIT_UUID_DATA_TYPE, result.getResultList().get(15).getDataType());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result.getResultList().get(16).getDataType());
        assertEquals(SERVICE_DATA_128_BIT_UUID_DATA_TYPE, result.getResultList().get(17).getDataType());
        assertEquals(APPEARANCE_DATA_TYPE, result.getResultList().get(18).getDataType());
        assertEquals(PUBLIC_TARGET_ADDRESS_DATA_TYPE, result.getResultList().get(19).getDataType());
        assertEquals(RANDOM_TARGET_ADDRESS_DATA_TYPE, result.getResultList().get(20).getDataType());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result.getResultList().get(21).getDataType());
        assertEquals(URI_DATA_TYPE, result.getResultList().get(22).getDataType());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result.getResultList().get(23).getDataType());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result.getResultList().get(24).getDataType());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result.getResultList().get(25).getDataType());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result.getResultList().get(26).getDataType());
        assertEquals(BIG_INFO_DATA_TYPE, result.getResultList().get(27).getDataType());
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
        assertNotNull(result.getPeripheralConnectionIntervalRange());
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
        assertNotNull(result.getUniformResourceIdentifier());
        assertNotNull(result.getIndoorPositioning());
        assertNotNull(result.getTransportDiscoveryData());
        assertNotNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
        assertNotNull(result.getBigInfo());
    }

    @Test
    public void builderTest0602() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.excludeAll().includeAll().build();

        byte[] data = new byte[232];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[39] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[57] = SHORTENED_LOCAL_NAME_DATA_TYPE;
        data[58] = 'a';

        data[59] = 3;
        data[60] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = FLAGS_DATA_TYPE;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = TX_POWER_LEVEL_DATA_TYPE;
        data[72] = -127;

        data[73] = 5;
        data[74] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[108] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[136] = APPEARANCE_DATA_TYPE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = URI_DATA_TYPE;
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
        data[178] = INDOOR_POSITIONING_DATA_TYPE;
        data[179] = 0b00000000;

        data[180] = 4;
        data[181] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[182] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[183] = 0;
        data[184] = 0;

        data[185] = 2;
        data[186] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[187] = 0b00000001;

        data[188] = 8;
        data[189] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[190] = (byte) 0b11111110;
        data[191] = (byte) 0b11111111;
        data[192] = (byte) 0b11111111;
        data[193] = (byte) 0b11111111;
        data[194] = (byte) 0b11111111;
        data[195] = 0b00000000;
        data[196] = 0b00000000;

        data[197] = 34;
        data[198] = BIG_INFO_DATA_TYPE;
        data[199] = 0b00000000;
        data[200] = 0b00000000;
        data[201] = 0b00000000;
        data[202] = 0b00000000;
        data[203] = 0b00000000;
        data[204] = 0b00000000;
        data[205] = 0b00000000;
        data[206] = 0b00000000;
        data[207] = 0b00000000;
        data[208] = 0b00000000;
        data[209] = 0b00000000;
        data[210] = 0b00000000;
        data[211] = 0b00000000;
        data[212] = 0b00000000;
        data[213] = 0b00000000;
        data[214] = 0b00000000;
        data[215] = 0b00000000;
        data[216] = 0b00000000;
        data[217] = 0b00000000;
        data[218] = 0b00000000;
        data[219] = 0b00000000;
        data[220] = 0b00000000;
        data[221] = 0b00000000;
        data[222] = 0b00000000;
        data[223] = 0b00000000;
        data[224] = 0b00000000;
        data[225] = 0b00000000;
        data[226] = 0b00000000;
        data[227] = 0b00000000;
        data[228] = 0b00000000;
        data[229] = 0b00000000;
        data[220] = 0b00000000;
        data[231] = 0b00000000;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(28, result.getResultList().size());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(0).getDataType());
        assertEquals(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(1).getDataType());
        assertEquals(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(2).getDataType());
        assertEquals(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(3).getDataType());
        assertEquals(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(4).getDataType());
        assertEquals(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result.getResultList().get(5).getDataType());
        assertEquals(SHORTENED_LOCAL_NAME_DATA_TYPE, result.getResultList().get(6).getDataType());
        assertEquals(COMPLETE_LOCAL_NAME_DATA_TYPE, result.getResultList().get(7).getDataType());
        assertEquals(FLAGS_DATA_TYPE, result.getResultList().get(8).getDataType());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result.getResultList().get(9).getDataType());
        assertEquals(TX_POWER_LEVEL_DATA_TYPE, result.getResultList().get(10).getDataType());
        assertEquals(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE, result.getResultList().get(11).getDataType());
        assertEquals(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(12).getDataType());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(13).getDataType());
        assertEquals(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result.getResultList().get(14).getDataType());
        assertEquals(SERVICE_DATA_16_BIT_UUID_DATA_TYPE, result.getResultList().get(15).getDataType());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result.getResultList().get(16).getDataType());
        assertEquals(SERVICE_DATA_128_BIT_UUID_DATA_TYPE, result.getResultList().get(17).getDataType());
        assertEquals(APPEARANCE_DATA_TYPE, result.getResultList().get(18).getDataType());
        assertEquals(PUBLIC_TARGET_ADDRESS_DATA_TYPE, result.getResultList().get(19).getDataType());
        assertEquals(RANDOM_TARGET_ADDRESS_DATA_TYPE, result.getResultList().get(20).getDataType());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result.getResultList().get(21).getDataType());
        assertEquals(URI_DATA_TYPE, result.getResultList().get(22).getDataType());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result.getResultList().get(23).getDataType());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result.getResultList().get(24).getDataType());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result.getResultList().get(25).getDataType());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result.getResultList().get(26).getDataType());
        assertEquals(BIG_INFO_DATA_TYPE, result.getResultList().get(27).getDataType());
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
        assertNotNull(result.getPeripheralConnectionIntervalRange());
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
        assertNotNull(result.getUniformResourceIdentifier());
        assertNotNull(result.getIndoorPositioning());
        assertNotNull(result.getTransportDiscoveryData());
        assertNotNull(result.getLeSupportedFeatures());
        assertNotNull(result.getChannelMapUpdateIndication());
        assertNotNull(result.getBigInfo());
    }

    @Test
    public void builderTest0603() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        builder.excludeAll();
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[232];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[39] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[57] = SHORTENED_LOCAL_NAME_DATA_TYPE;
        data[58] = 'a';

        data[59] = 3;
        data[60] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = FLAGS_DATA_TYPE;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = TX_POWER_LEVEL_DATA_TYPE;
        data[72] = -127;

        data[73] = 5;
        data[74] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[108] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[136] = APPEARANCE_DATA_TYPE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = URI_DATA_TYPE;
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
        data[178] = INDOOR_POSITIONING_DATA_TYPE;
        data[179] = 0b00000000;

        data[180] = 4;
        data[181] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[182] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[183] = 0;
        data[184] = 0;

        data[185] = 2;
        data[186] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[187] = 0b00000001;

        data[188] = 8;
        data[189] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[190] = (byte) 0b11111110;
        data[191] = (byte) 0b11111111;
        data[192] = (byte) 0b11111111;
        data[193] = (byte) 0b11111111;
        data[194] = (byte) 0b11111111;
        data[195] = 0b00000000;
        data[196] = 0b00000000;

        data[197] = 34;
        data[198] = BIG_INFO_DATA_TYPE;
        data[199] = 0b00000000;
        data[200] = 0b00000000;
        data[201] = 0b00000000;
        data[202] = 0b00000000;
        data[203] = 0b00000000;
        data[204] = 0b00000000;
        data[205] = 0b00000000;
        data[206] = 0b00000000;
        data[207] = 0b00000000;
        data[208] = 0b00000000;
        data[209] = 0b00000000;
        data[210] = 0b00000000;
        data[211] = 0b00000000;
        data[212] = 0b00000000;
        data[213] = 0b00000000;
        data[214] = 0b00000000;
        data[215] = 0b00000000;
        data[216] = 0b00000000;
        data[217] = 0b00000000;
        data[218] = 0b00000000;
        data[219] = 0b00000000;
        data[220] = 0b00000000;
        data[221] = 0b00000000;
        data[222] = 0b00000000;
        data[223] = 0b00000000;
        data[224] = 0b00000000;
        data[225] = 0b00000000;
        data[226] = 0b00000000;
        data[227] = 0b00000000;
        data[228] = 0b00000000;
        data[229] = 0b00000000;
        data[220] = 0b00000000;
        data[231] = 0b00000000;

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0604() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 1;
        data[3] = 1;
        data[4] = 3;
        data[5] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[6] = 0;
        data[7] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertEquals(2, result.getIncompleteListOf16BitServiceUUIDsList().size());
        assertNotNull(result.getIncompleteListOf16BitServiceUUIDs());
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0605() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 1;
        data[3] = 1;
        data[4] = 3;
        data[5] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[6] = 0;
        data[7] = 0;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);

        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(2, result.getResultList().size());
        assertNull(result.getIncompleteListOf16BitServiceUUIDs());
        assertEquals(2, result.getCompleteListOf16BitServiceUUIDsList().size());
        assertNotNull(result.getCompleteListOf16BitServiceUUIDs());
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0606() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 5;
        data[7] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNotNull(result.getIncompleteListOf32BitServiceUUIDs());
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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0607() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 5;
        data[7] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNotNull(result.getCompleteListOf32BitServiceUUIDs());
        assertEquals(result.getCompleteListOf32BitServiceUUIDs(), result.getCompleteListOf32BitServiceUUIDsList().get(1));
        assertEquals(BASE_UUID, result.getCompleteListOf32BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0608() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[36];
        data[0] = 17;
        data[1] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[19] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNotNull(result.getIncompleteListOf128BitServiceUUIDs());
        assertEquals(result.getIncompleteListOf128BitServiceUUIDs(), result.getIncompleteListOf128BitServiceUUIDsList().get(1));
        assertEquals(new UUID(0, 0), result.getIncompleteListOf128BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getCompleteListOf128BitServiceUUIDs());
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0609() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[36];
        data[0] = 17;
        data[1] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[19] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        assertNotNull(result.getCompleteListOf128BitServiceUUIDs());
        assertEquals(result.getCompleteListOf128BitServiceUUIDs(), result.getCompleteListOf128BitServiceUUIDsList().get(1));
        assertEquals(new UUID(0, 0), result.getCompleteListOf128BitServiceUUIDs().getUuidList().get(0));
        assertNull(result.getShortenedLocalName());
        assertNull(result.getCompleteLocalName());
        assertNull(result.getFlags());
        assertNull(result.getManufacturerSpecificData());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0610() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[2] = (byte) (0x000000E0 & 0x0000ff);
        data[3] = (byte) (0x000000E0 & (0x0000ff >> 8));
        data[4] = 3;
        data[5] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
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
        assertNotNull(result.getManufacturerSpecificData());
        assertEquals(result.getManufacturerSpecificData(), result.getManufacturerSpecificDataList().get(1));
        assertEquals(0x00000008, result.getManufacturerSpecificData().getCompanyIdentifier());
        assertEquals(COMPANY_MAPPING_128.get(BLEUtils.convert16to128(0x00000008)), result.getManufacturerSpecificData().getCompanyName());
        assertNull(result.getTxPowerLevel());
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0611() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[6];
        data[0] = 2;
        data[1] = TX_POWER_LEVEL_DATA_TYPE;
        data[2] = -127;
        data[3] = 2;
        data[4] = TX_POWER_LEVEL_DATA_TYPE;
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
        assertNotNull(result.getTxPowerLevel());
        assertEquals(result.getTxPowerLevel(), result.getTxPowerLevelList().get(1));
        assertEquals(0, result.getTxPowerLevel().getTxPowerLevel());
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0612() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;
        data[6] = 5;
        data[7] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
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
        assertEquals(2, result.getPeripheralConnectionIntervalRangeList().size());
        assertNotNull(result.getPeripheralConnectionIntervalRange());
        assertEquals(result.getPeripheralConnectionIntervalRange(), result.getPeripheralConnectionIntervalRangeList().get(1));
        assertTrue(result.getPeripheralConnectionIntervalRange().hasMaximum());
        assertEquals(0d, 0x0006 * PERIPHERAL_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getPeripheralConnectionIntervalRange().getMaximumValueMillis());
        assertTrue(result.getPeripheralConnectionIntervalRange().hasMinimum());
        assertEquals(0d, 0x0006 * PERIPHERAL_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getPeripheralConnectionIntervalRange().getMinimumValueMillis());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0613() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[2] = 1;
        data[3] = 1;
        data[4] = 3;
        data[5] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
        assertEquals(2, result.getListOf16BitServiceSolicitationUUIDsList().size());
        assertNotNull(result.getListOf16BitServiceSolicitationUUIDs());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0614() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 5;
        data[7] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertEquals(2, result.getListOf32BitServiceSolicitationUUIDsList().size());
        assertNotNull(result.getListOf32BitServiceSolicitationUUIDs());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0615() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[36];
        data[0] = 17;
        data[1] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[19] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertEquals(2, result.getListOf128BitServiceSolicitationUUIDsList().size());
        assertNotNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertEquals(result.getListOf128BitServiceSolicitationUUIDs(), result.getListOf128BitServiceSolicitationUUIDsList().get(1));
        assertEquals(new UUID(0, 0), result.getListOf128BitServiceSolicitationUUIDs().getUuidList().get(0));
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0616() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[8];
        data[0] = 3;
        data[1] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
        data[2] = 1;
        data[3] = 1;
        data[4] = 3;
        data[5] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertEquals(2, result.getServiceData16BitUUIDList().size());
        assertNotNull(result.getServiceData16BitUUID());
        assertEquals(result.getServiceData16BitUUID(), result.getServiceData16BitUUIDList().get(1));
        assertEquals(BASE_UUID, result.getServiceData16BitUUID().getUuid());
        assertNull(result.getServiceData32BitUUID());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0617() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[12];
        data[0] = 5;
        data[1] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[2] = 1;
        data[3] = 1;
        data[4] = 1;
        data[5] = 1;
        data[6] = 5;
        data[7] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertEquals(2, result.getServiceData32BitUUIDList().size());
        assertNotNull(result.getServiceData32BitUUID());
        assertEquals(result.getServiceData32BitUUID(), result.getServiceData32BitUUIDList().get(1));
        assertEquals(BASE_UUID, result.getServiceData32BitUUID().getUuid());
        assertNull(result.getServiceData128BitUUID());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0618() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[36];
        data[0] = 17;
        data[1] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[19] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        assertNull(result.getPeripheralConnectionIntervalRange());
        assertNull(result.getListOf16BitServiceSolicitationUUIDs());
        assertNull(result.getListOf32BitServiceSolicitationUUIDs());
        assertNull(result.getListOf128BitServiceSolicitationUUIDs());
        assertNull(result.getServiceData16BitUUID());
        assertNull(result.getServiceData32BitUUID());
        assertEquals(2, result.getServiceData128BitUUIDList().size());
        assertNotNull(result.getServiceData128BitUUID());
        assertEquals(result.getServiceData128BitUUID(), result.getServiceData128BitUUIDList().get(1));
        assertEquals(new UUID(0, 0), result.getServiceData128BitUUID().getUuid());
        assertNull(result.getAppearance());
        assertNull(result.getPublicTargetAddress());
        assertNull(result.getRandomTargetAddress());
        assertNull(result.getAdvertisingInterval());
        assertNull(result.getAdvertisingIntervalLong());
        assertNull(result.getUniformResourceIdentifier());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0619() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[25];
        data[0] = 11;
        data[1] = URI_DATA_TYPE;
        data[2] = 0x16;
        data[3] = '/';
        data[4] = '/';
        data[5] = 'i';
        data[6] = 'm';
        data[7] = 'o';
        data[8] = 'r';
        data[9] = 'i';
        data[10] = '1';
        data[11] = '/';
        data[12] = 12;
        data[13] = URI_DATA_TYPE;
        data[14] = (byte) 0xc2;
        data[15] = (byte) 0xb9;
        data[16] = '/';
        data[17] = '/';
        data[18] = 'i';
        data[19] = 'm';
        data[20] = 'o';
        data[21] = 'r';
        data[22] = 'i';
        data[23] = '2';
        data[24] = '/';

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
        assertNull(result.getPeripheralConnectionIntervalRange());
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
        assertNull(result.getAdvertisingIntervalLong());
        assertEquals(2, result.getUniformResourceIdentifierList().size());
        assertNotNull(result.getUniformResourceIdentifier());
        assertEquals(result.getUniformResourceIdentifier(), result.getUniformResourceIdentifierList().get(1));
        assertEquals(URI.create(SCHEME_MAPPING.get(new String(data, 14, 2).charAt(0)) + new String(data, 16, 9)), result.getUniformResourceIdentifier().getUri());
        assertNull(result.getIndoorPositioning());
        assertNull(result.getTransportDiscoveryData());
        assertNull(result.getLeSupportedFeatures());
        assertNull(result.getChannelMapUpdateIndication());
        assertNull(result.getBigInfo());
    }

    @Test
    public void builderTest0620() {
        AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
        AdvertisingDataParser parser = builder.build();

        byte[] data = new byte[232];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 0;
        data[3] = 0;

        data[4] = 3;
        data[5] = COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[6] = 0;
        data[7] = 0;

        data[8] = 5;
        data[9] = INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;

        data[14] = 5;
        data[15] = COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[16] = 0x00;
        data[17] = 0x00;
        data[18] = 0x00;
        data[19] = 0x00;

        data[20] = 17;
        data[21] = INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[39] = COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
        data[57] = SHORTENED_LOCAL_NAME_DATA_TYPE;
        data[58] = 'a';

        data[59] = 3;
        data[60] = COMPLETE_LOCAL_NAME_DATA_TYPE;
        data[61] = 'a';
        data[62] = 'b';

        data[63] = 2;
        data[64] = FLAGS_DATA_TYPE;
        data[65] = 0b00000001;

        data[66] = 3;
        data[67] = (byte) MANUFACTURER_SPECIFIC_DATA_DATA_TYPE;
        data[68] = (byte) (0x000000E0 & 0x0000ff);
        data[69] = (byte) (0x000000E0 & (0x0000ff >> 8));

        data[70] = 2;
        data[71] = TX_POWER_LEVEL_DATA_TYPE;
        data[72] = -127;

        data[73] = 5;
        data[74] = PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE;
        data[75] = (byte) 0xff;
        data[76] = (byte) 0xff;
        data[77] = (byte) 0xff;
        data[78] = (byte) 0xff;

        data[79] = 3;
        data[80] = LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[81] = 0;
        data[82] = 0;

        data[83] = 5;
        data[84] = LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
        data[85] = 0x00;
        data[86] = 0x00;
        data[87] = 0x00;
        data[88] = 0x00;

        data[89] = 17;
        data[90] = LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE;
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
        data[108] = SERVICE_DATA_16_BIT_UUID_DATA_TYPE;
        data[109] = 0;
        data[110] = 0;

        data[111] = 5;
        data[112] = SERVICE_DATA_32_BIT_UUID_DATA_TYPE;
        data[113] = 0x00;
        data[114] = 0x00;
        data[115] = 0x00;
        data[116] = 0x00;

        data[117] = 17;
        data[118] = SERVICE_DATA_128_BIT_UUID_DATA_TYPE;
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
        data[136] = APPEARANCE_DATA_TYPE;
        data[137] = (byte) (0x64 & 0x00ff);
        data[138] = (byte) ((0x64 >> 8) & 0x00ff);

        data[139] = 7;
        data[140] = PUBLIC_TARGET_ADDRESS_DATA_TYPE;
        data[141] = 0;
        data[142] = 0;
        data[143] = 0;
        data[144] = 0;
        data[145] = 0;
        data[146] = 0;

        data[147] = 7;
        data[148] = RANDOM_TARGET_ADDRESS_DATA_TYPE;
        data[149] = 0;
        data[150] = 0;
        data[151] = 0;
        data[152] = 0;
        data[153] = 0;
        data[154] = 0;

        data[155] = 3;
        data[156] = ADVERTISING_INTERVAL_DATA_TYPE;
        data[157] = 0x00;
        data[158] = 0x00;

        data[159] = 17;
        data[160] = URI_DATA_TYPE;
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
        data[178] = INDOOR_POSITIONING_DATA_TYPE;
        data[179] = 0b00000000;

        data[180] = 4;
        data[181] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[182] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[183] = 0;
        data[184] = 0;

        data[185] = 2;
        data[186] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[187] = 0b00000001;

        data[188] = 8;
        data[189] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[190] = (byte) 0b11111110;
        data[191] = (byte) 0b11111111;
        data[192] = (byte) 0b11111111;
        data[193] = (byte) 0b11111111;
        data[194] = (byte) 0b11111111;
        data[195] = 0b00000000;
        data[196] = 0b00000000;

        data[197] = 34;
        data[198] = BIG_INFO_DATA_TYPE;
        data[199] = 0b00000000;
        data[200] = 0b00000000;
        data[201] = 0b00000000;
        data[202] = 0b00000000;
        data[203] = 0b00000000;
        data[204] = 0b00000000;
        data[205] = 0b00000000;
        data[206] = 0b00000000;
        data[207] = 0b00000000;
        data[208] = 0b00000000;
        data[209] = 0b00000000;
        data[210] = 0b00000000;
        data[211] = 0b00000000;
        data[212] = 0b00000000;
        data[213] = 0b00000000;
        data[214] = 0b00000000;
        data[215] = 0b00000000;
        data[216] = 0b00000000;
        data[217] = 0b00000000;
        data[218] = 0b00000000;
        data[219] = 0b00000000;
        data[220] = 0b00000000;
        data[221] = 0b00000000;
        data[222] = 0b00000000;
        data[223] = 0b00000000;
        data[224] = 0b00000000;
        data[225] = 0b00000000;
        data[226] = 0b00000000;
        data[227] = 0b00000000;
        data[228] = 0b00000000;
        data[229] = 0b00000000;
        data[220] = 0b00000000;
        data[231] = 0b00000000;

        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(data);
        Parcel parcel = Parcel.obtain();
        result.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AdvertisingDataParser.AdvertisingDataParseResult result2 = AdvertisingDataParser.AdvertisingDataParseResult.CREATOR.createFromParcel(parcel);

        assertNotNull(result2);
        assertNotNull(result2.getResultList());
        assertEquals(28, result2.getResultList().size());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result2.getResultList().get(0).getDataType());
        assertEquals(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result2.getResultList().get(1).getDataType());
        assertEquals(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result2.getResultList().get(2).getDataType());
        assertEquals(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result2.getResultList().get(3).getDataType());
        assertEquals(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result2.getResultList().get(4).getDataType());
        assertEquals(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result2.getResultList().get(5).getDataType());
        assertEquals(SHORTENED_LOCAL_NAME_DATA_TYPE, result2.getResultList().get(6).getDataType());
        assertEquals(COMPLETE_LOCAL_NAME_DATA_TYPE, result2.getResultList().get(7).getDataType());
        assertEquals(FLAGS_DATA_TYPE, result2.getResultList().get(8).getDataType());
        assertEquals(MANUFACTURER_SPECIFIC_DATA_DATA_TYPE, result2.getResultList().get(9).getDataType());
        assertEquals(TX_POWER_LEVEL_DATA_TYPE, result2.getResultList().get(10).getDataType());
        assertEquals(PERIPHERAL_CONNECTION_INTERVAL_RANGE_DATA_TYPE, result2.getResultList().get(11).getDataType());
        assertEquals(LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result2.getResultList().get(12).getDataType());
        assertEquals(LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result2.getResultList().get(13).getDataType());
        assertEquals(LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS_DATA_TYPE, result2.getResultList().get(14).getDataType());
        assertEquals(SERVICE_DATA_16_BIT_UUID_DATA_TYPE, result2.getResultList().get(15).getDataType());
        assertEquals(SERVICE_DATA_32_BIT_UUID_DATA_TYPE, result2.getResultList().get(16).getDataType());
        assertEquals(SERVICE_DATA_128_BIT_UUID_DATA_TYPE, result2.getResultList().get(17).getDataType());
        assertEquals(APPEARANCE_DATA_TYPE, result2.getResultList().get(18).getDataType());
        assertEquals(PUBLIC_TARGET_ADDRESS_DATA_TYPE, result2.getResultList().get(19).getDataType());
        assertEquals(RANDOM_TARGET_ADDRESS_DATA_TYPE, result2.getResultList().get(20).getDataType());
        assertEquals(ADVERTISING_INTERVAL_DATA_TYPE, result2.getResultList().get(21).getDataType());
        assertEquals(URI_DATA_TYPE, result2.getResultList().get(22).getDataType());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result2.getResultList().get(23).getDataType());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result2.getResultList().get(24).getDataType());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result2.getResultList().get(25).getDataType());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result2.getResultList().get(26).getDataType());
        assertEquals(BIG_INFO_DATA_TYPE, result2.getResultList().get(27).getDataType());
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
        assertNotNull(result2.getPeripheralConnectionIntervalRange());
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
        assertNotNull(result2.getUniformResourceIdentifier());
        assertNotNull(result.getIndoorPositioning());
        assertNotNull(result.getTransportDiscoveryData());
        assertNotNull(result2.getLeSupportedFeatures());
        assertNotNull(result2.getChannelMapUpdateIndication());
        assertNotNull(result2.getBigInfo());
    }
}
