package org.im97mori.ble;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IndoorPositioningUtilsTest {

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesAreNotPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT;
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesAreNotPresent(indoorPositioningConfiguration));
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT;
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesAreNotPresent(indoorPositioningConfiguration));
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM;
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration));
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsLocalCoordinateSystem(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsLocalCoordinateSystem_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM;
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration));
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsLocalCoordinateSystem(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsNotPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT;
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsNotPresent(indoorPositioningConfiguration));
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT;
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsNotPresent(indoorPositioningConfiguration));
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsNotPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT;
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsNotPresent(indoorPositioningConfiguration));
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT;
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsNotPresent(indoorPositioningConfiguration));
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsNotPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT;
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsNotPresent(indoorPositioningConfiguration));
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT;
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsNotPresent(indoorPositioningConfiguration));
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsNotPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT;
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsNotPresent(indoorPositioningConfiguration));
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT;
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsNotPresent(indoorPositioningConfiguration));
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationLocationNameAvailableInTheGattDatabaseLocationNameIsNotPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationLocationNameAvailableInTheGattDatabaseLocationNameIsNotPresent(indoorPositioningConfiguration));
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationLocationNameAvailableInTheGattDatabaseLocationNameIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isIndoorPositioningConfigurationLocationNameAvailableInTheGattDatabaseLocationNameIsPresent_001() {
        int indoorPositioningConfiguration = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_PRESENT;
        assertFalse(IndoorPositioningUtils.isIndoorPositioningConfigurationLocationNameAvailableInTheGattDatabaseLocationNameIsNotPresent(indoorPositioningConfiguration));
        assertTrue(IndoorPositioningUtils.isIndoorPositioningConfigurationLocationNameAvailableInTheGattDatabaseLocationNameIsPresent(indoorPositioningConfiguration));
    }

    @Test
    public void test_isLatitudeNotConfigured_001() {
        assertTrue(IndoorPositioningUtils.isLatitudeNotConfigured(IndoorPositioningUtils.LATITUDE_NOT_CONFIGURED));
    }

    @Test
    public void test_isLatitudeNotConfigured_002() {
        assertFalse(IndoorPositioningUtils.isLatitudeNotConfigured(IndoorPositioningUtils.LATITUDE_NOT_CONFIGURED + 1));
    }

    @Test
    public void test_getLatitudeWgs84_001() {
        int latitude = 0;
        assertEquals(latitude, IndoorPositioningUtils.getLatitudeWgs84(latitude), 0);
    }

    @Test
    public void test_getLatitudeWgs84_002() {
        int latitude = 0x7FFFFFFF;
        assertEquals(90, IndoorPositioningUtils.getLatitudeWgs84(latitude), 1);
    }

    @Test
    public void test_getLatitudeWgs84_003() {
        int latitude = 0x80000001;
        assertEquals(-90, IndoorPositioningUtils.getLatitudeWgs84(latitude), 1);
    }

    @Test
    public void test_isLongitudeNotConfigured_001() {
        assertTrue(IndoorPositioningUtils.isLongitudeNotConfigured(IndoorPositioningUtils.LONGITUDE_NOT_CONFIGURED));
    }

    @Test
    public void test_isLongitudeNotConfigured_002() {
        assertFalse(IndoorPositioningUtils.isLongitudeNotConfigured(IndoorPositioningUtils.LONGITUDE_NOT_CONFIGURED + 1));
    }

    @Test
    public void test_getLongitudeWgs84_001() {
        int longitude = 0;
        assertEquals(longitude, IndoorPositioningUtils.getLongitudeWgs84(longitude), 0);
    }

    @Test
    public void test_getLongitudeWgs84_002() {
        int longitude = 0x7FFFFFFF;
        assertEquals(180, IndoorPositioningUtils.getLongitudeWgs84(longitude), 1);
    }

    @Test
    public void test_getLongitudeWgs84_003() {
        int longitude = 0x80000001;
        assertEquals(-180, IndoorPositioningUtils.getLongitudeWgs84(longitude), 1);
    }

    @Test
    public void test_isLocalNorthCoordinateNotConfigured_001() {
        assertTrue(IndoorPositioningUtils.isLocalNorthCoordinateNotConfigured(IndoorPositioningUtils.LOCAL_NORTH_COORDINATE_NOT_CONFIGURED));
    }

    @Test
    public void test_isLocalNorthCoordinateNotConfigured_002() {
        assertFalse(IndoorPositioningUtils.isLocalNorthCoordinateNotConfigured(IndoorPositioningUtils.LOCAL_NORTH_COORDINATE_NOT_CONFIGURED + 1));
    }

    @Test
    public void test_isLocalEastCoordinateNotConfigured_001() {
        assertTrue(IndoorPositioningUtils.isLocalEastCoordinateNotConfigured(IndoorPositioningUtils.LOCAL_EAST_COORDINATE_NOT_CONFIGURED));
    }

    @Test
    public void test_isLocalEastCoordinateNotConfigured_002() {
        assertFalse(IndoorPositioningUtils.isLocalEastCoordinateNotConfigured(IndoorPositioningUtils.LOCAL_EAST_COORDINATE_NOT_CONFIGURED + 1));
    }

    @Test
    public void test_isFloorNumberMinValue_001() {
        assertTrue(IndoorPositioningUtils.isFloorNumberMinValue(IndoorPositioningUtils.FLOOR_NUMBER_MIN));
    }

    @Test
    public void test_isFloorNumberMinValue_002() {
        assertFalse(IndoorPositioningUtils.isFloorNumberMinValue(IndoorPositioningUtils.FLOOR_NUMBER_MIN + 1));
    }

    @Test
    public void test_isFloorNumberMaxValue_001() {
        assertTrue(IndoorPositioningUtils.isFloorNumberMaxValue(IndoorPositioningUtils.FLOOR_NUMBER_MAX));
    }

    @Test
    public void test_isFloorNumberMaxValue_002() {
        assertFalse(IndoorPositioningUtils.isFloorNumberMaxValue(IndoorPositioningUtils.FLOOR_NUMBER_MAX - 1));
    }

    @Test
    public void test_isFloorNumberGroundFloor_001() {
        assertTrue(IndoorPositioningUtils.isFloorNumberGroundFloor(IndoorPositioningUtils.FLOOR_NUMBER_GROUND_FLOOR_0));
    }

    @Test
    public void test_isFloorNumberGroundFloor_002() {
        assertTrue(IndoorPositioningUtils.isFloorNumberGroundFloor(IndoorPositioningUtils.FLOOR_NUMBER_GROUND_FLOOR_1));
    }

    @Test
    public void test_isFloorNumberGroundFloor_003() {
        assertFalse(IndoorPositioningUtils.isFloorNumberGroundFloor(IndoorPositioningUtils.FLOOR_NUMBER_GROUND_FLOOR_0 - 1));
    }

    @Test
    public void test_isFloorNumberNotConfigured_001() {
        assertTrue(IndoorPositioningUtils.isFloorNumberNotConfigured(IndoorPositioningUtils.FLOOR_NUMBER_NO_FLOOR_NUMBER_IS_CONFIGURED));
    }

    @Test
    public void test_isFloorNumberNotConfigured_002() {
        assertFalse(IndoorPositioningUtils.isFloorNumberNotConfigured(IndoorPositioningUtils.FLOOR_NUMBER_NO_FLOOR_NUMBER_IS_CONFIGURED - 1));
    }

    @Test
    public void test_getFloorNumberWithOffset_001() {
        assertEquals(0, IndoorPositioningUtils.getFloorNumberWithOffset(IndoorPositioningUtils.FLOOR_NUMBER_GROUND_FLOOR_0));
    }

    @Test
    public void test_getFloorNumberWithOffset_002() {
        assertEquals(1, IndoorPositioningUtils.getFloorNumberWithOffset(IndoorPositioningUtils.FLOOR_NUMBER_GROUND_FLOOR_1));
    }

    @Test
    public void test_getFloorNumberWithOffset_003() {
        assertEquals(IndoorPositioningUtils.FLOOR_NUMBER_OFFSET, IndoorPositioningUtils.getFloorNumberWithOffset(0));
    }

    @Test
    public void test_isAltitudeNotConfigured_001() {
        assertTrue(IndoorPositioningUtils.isAltitudeNotConfigured(IndoorPositioningUtils.ALTITUDE_IS_NOT_CONFIGURED));
    }

    @Test
    public void test_isAltitudeNotConfigured_002() {
        assertFalse(IndoorPositioningUtils.isAltitudeNotConfigured(IndoorPositioningUtils.ALTITUDE_IS_NOT_CONFIGURED - 1));
    }

    @Test
    public void test_isAltitudeMaxValue_001() {
        assertTrue(IndoorPositioningUtils.isAltitudeMaxValue(IndoorPositioningUtils.ALTITUDE_MAX));
    }

    @Test
    public void test_isAltitudeMaxValue_002() {
        assertFalse(IndoorPositioningUtils.isAltitudeMaxValue(IndoorPositioningUtils.ALTITUDE_MAX - 1));
    }

    @Test
    public void test_isAltitudeMinValue_001() {
        assertTrue(IndoorPositioningUtils.isAltitudeMinValue(IndoorPositioningUtils.ALTITUDE_MIN));
    }

    @Test
    public void test_isAltitudeMinValue_002() {
        assertFalse(IndoorPositioningUtils.isAltitudeMinValue(IndoorPositioningUtils.ALTITUDE_MIN - 1));
    }

    @Test
    public void test_getAltitudeDecimeters_001() {
        assertEquals(IndoorPositioningUtils.ALTITUDE_OFFSET, IndoorPositioningUtils.getAltitudeDecimeters(0));
    }

    @Test
    public void test_isUncertaintyStationary_001() {
        assertTrue(IndoorPositioningUtils.isUncertaintyStationaryStationary(IndoorPositioningUtils.UNCERTAINTY_STATIONARY_STATIONARY));
        assertFalse(IndoorPositioningUtils.isUncertaintyStationaryMobile(IndoorPositioningUtils.UNCERTAINTY_STATIONARY_STATIONARY));
    }

    @Test
    public void test_isUncertaintyStationary_002() {
        assertFalse(IndoorPositioningUtils.isUncertaintyStationaryStationary(IndoorPositioningUtils.UNCERTAINTY_STATIONARY_MOBILE));
        assertTrue(IndoorPositioningUtils.isUncertaintyStationaryMobile(IndoorPositioningUtils.UNCERTAINTY_STATIONARY_MOBILE));
    }

    @Test
    public void test_isUncertaintyUpdateTime_001() {
        assertTrue(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto3s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_3S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto4s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_3S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto6s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_3S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto12s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_3S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto28s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_3S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto89s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_3S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto426s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_3S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTime3541s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_3S));
    }

    @Test
    public void test_isUncertaintyUpdateTime_002() {
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto3s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_4S));
        assertTrue(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto4s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_4S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto6s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_4S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto12s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_4S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto28s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_4S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto89s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_4S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto426s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_4S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTime3541s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_4S));
    }

    @Test
    public void test_isUncertaintyUpdateTime_003() {
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto3s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_6S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto4s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_6S));
        assertTrue(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto6s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_6S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto12s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_6S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto28s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_6S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto89s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_6S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto426s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_6S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTime3541s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_6S));
    }

    @Test
    public void test_isUncertaintyUpdateTime_004() {
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto3s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_12S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto4s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_12S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto6s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_12S));
        assertTrue(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto12s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_12S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto28s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_12S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto89s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_12S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto426s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_12S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTime3541s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_12S));
    }

    @Test
    public void test_isUncertaintyUpdateTime_005() {
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto3s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_28S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto4s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_28S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto6s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_28S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto12s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_28S));
        assertTrue(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto28s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_28S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto89s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_28S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto426s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_28S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTime3541s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_28S));
    }

    @Test
    public void test_isUncertaintyUpdateTime_006() {
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto3s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_89S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto4s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_89S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto6s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_89S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto12s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_89S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto28s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_89S));
        assertTrue(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto89s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_89S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto426s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_89S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTime3541s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_89S));
    }

    @Test
    public void test_isUncertaintyUpdateTime_007() {
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto3s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_426S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto4s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_426S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto6s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_426S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto12s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_426S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto28s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_426S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto89s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_426S));
        assertTrue(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto426s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_426S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTime3541s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_UPTO_426S));
    }

    @Test
    public void test_isUncertaintyUpdateTime_008() {
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto3s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_3541S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto4s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_3541S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto6s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_3541S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto12s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_3541S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto28s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_3541S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto89s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_3541S));
        assertFalse(IndoorPositioningUtils.isUncertaintyUpdateTimeUpto426s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_3541S));
        assertTrue(IndoorPositioningUtils.isUncertaintyUpdateTime3541s(IndoorPositioningUtils.UNCERTAINTY_UPDATE_TIME_3541S));
    }

    @Test
    public void test_isUncertaintyPrecision_001() {
        assertTrue(IndoorPositioningUtils.isUncertaintyPrecisionIdeal(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionExcellent(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionGood(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionModerate(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionFair(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionPoor(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionUseless(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL));
    }

    @Test
    public void test_isUncertaintyPrecision_002() {
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionIdeal(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT));
        assertTrue(IndoorPositioningUtils.isUncertaintyPrecisionExcellent(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionGood(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionModerate(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionFair(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionPoor(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionUseless(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT));
    }

    @Test
    public void test_isUncertaintyPrecision_003() {
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionIdeal(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionExcellent(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD));
        assertTrue(IndoorPositioningUtils.isUncertaintyPrecisionGood(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionModerate(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionFair(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionPoor(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionUseless(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD));
    }

    @Test
    public void test_isUncertaintyPrecision_004() {
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionIdeal(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionExcellent(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionGood(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE));
        assertTrue(IndoorPositioningUtils.isUncertaintyPrecisionModerate(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionFair(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionPoor(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionUseless(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE));
    }

    @Test
    public void test_isUncertaintyPrecision_005() {
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionIdeal(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionExcellent(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionGood(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionModerate(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR));
        assertTrue(IndoorPositioningUtils.isUncertaintyPrecisionFair(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionPoor(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionUseless(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR));
    }

    @Test
    public void test_isUncertaintyPrecision_006() {
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionIdeal(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionExcellent(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionGood(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionModerate(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionFair(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR));
        assertTrue(IndoorPositioningUtils.isUncertaintyPrecisionPoor(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionUseless(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR));
    }

    @Test
    public void test_isUncertaintyPrecision_007() {
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionIdeal(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionExcellent(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionGood(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionModerate(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionFair(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS));
        assertFalse(IndoorPositioningUtils.isUncertaintyPrecisionPoor(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS));
        assertTrue(IndoorPositioningUtils.isUncertaintyPrecisionUseless(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS));
    }

}
