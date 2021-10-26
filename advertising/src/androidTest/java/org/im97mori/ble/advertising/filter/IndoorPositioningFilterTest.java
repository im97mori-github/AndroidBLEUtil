package org.im97mori.ble.advertising.filter;

import org.im97mori.ble.IndoorPositioningUtils;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.IndoorPositioningAndroid;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.INDOOR_POSITIONING_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class IndoorPositioningFilterTest {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[2];
        expectData[0] = 1;
        expectData[1] = INDOOR_POSITIONING_DATA_TYPE;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[2];
        actualData[0] = 1;
        actualData[1] = INDOOR_POSITIONING_DATA_TYPE;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[2];
        expectData[0] = 1;
        expectData[1] = INDOOR_POSITIONING_DATA_TYPE;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }


    @Test
    public void test_101() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[3];
        expectData[ 0] = 2;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[11];
        expectData[ 0] = 10;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = 0x01;
        expectData[ 4] = 0x02;
        expectData[ 5] = 0x03;
        expectData[ 6] = 0x04;
        expectData[ 7] = 0x05;
        expectData[ 8] = 0x06;
        expectData[ 9] = 0x07;
        expectData[10] = 0x08;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[7];
        expectData[ 0] = 6;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = 0x01;
        expectData[ 4] = 0x02;
        expectData[ 5] = 0x03;
        expectData[ 6] = 0x04;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_104() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = 0x01;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_105() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[5];
        expectData[ 0] = 4;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = 0x01;
        expectData[ 4] = 0x02;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_106() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = 0x01;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_107() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_108() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_109() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_110() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_111() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_112() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_113() {
        //@formatter:off
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] expectData = new byte[4];
        expectData[ 0] = 3;
        expectData[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        expectData[ 2] = (byte) flag;
        expectData[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS;
        //@formatter:on

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new IndoorPositioningFilter(IndoorPositioningAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

}
