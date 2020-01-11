package org.im97mori.ble;

/**
 * <p>
 * Utility for
 * org.bluetooth.characteristic.indoor_positioning_configuration(0x2AAD) characteristic
 * org.bluetooth.characteristic.latitude(0x2AAE) characteristic
 * org.bluetooth.characteristic.Longitude(0x2AAF) characteristic
 * org.bluetooth.characteristic.local_north_coordinate(0x2AB0) characteristic
 * org.bluetooth.characteristic.local_east_coordinate(0x2AB1) characteristic
 * org.bluetooth.characteristic.floor_number(0x2AB2) characteristic
 * org.bluetooth.characteristic.altitude(0x2AB3) characteristic
 * org.bluetooth.characteristic.uncertainty(0x2AB4) characteristic
 * </p>
 */
public class IndoorPositioningUtils {

    /**
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_MASK = 0b00000001;

    /**
     * 0: Coordinates are not present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT = 0b00000000;

    /**
     * 1: Coordinates are present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT = 0b00000001;

    /**
     * @see #INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
     * @see #INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_MASK = 0b00000010;

    /**
     * 0: WGS84 coordinate system
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM = 0b00000000;

    /**
     * 1: Local coordinate system
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM = 0b00000010;

    /**
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_MASK = 0b00000100;

    /**
     * 0: Tx Power is not present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT = 0b00000000;

    /**
     * 1: Tx Power is present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT = 0b00000100;

    /**
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_MASK = 0b00001000;

    /**
     * 0: Altitude is not present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT = 0b00000000;

    /**
     * 1: Altitude is present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT = 0b00001000;

    /**
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_MASK = 0b00010000;

    /**
     * 0: Floor Number is not present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT = 0b00000000;

    /**
     * 1: Floor Number is present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT = 0b00010000;

    /**
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
     * @see #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_MASK = 0b00100000;

    /**
     * 0: Uncertainty is not present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT = 0b00000000;

    /**
     * 1: Uncertainty is present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT = 0b00100000;

    /**
     * @see #INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT
     * @see #INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_PRESENT
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_MASK = 0b01000000;

    /**
     * 0: Location Name is not present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT = 0b00000000;

    /**
     * 1: Location Name is present
     */
    public static final int INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_PRESENT = 0b01000000;

    /**
     * 0x80000000: Latitude Characteristic indicates not configured
     */
    public static final int LATITUDE_NOT_CONFIGURED = 0x80000000;

    /**
     * 0x80000000: Longitude Characteristic indicates not configured
     */
    public static final int LONGITUDE_NOT_CONFIGURED = 0x80000000;

    /**
     * 0x8000: Local North Coordinateinformation is not configured
     */
    public static final int LOCAL_NORTH_COORDINATE_NOT_CONFIGURED = 0x8000;

    /**
     * 0x8000: Local East Coordinateinformation is not configured
     */
    public static final int LOCAL_EAST_COORDINATE_NOT_CONFIGURED = 0x8000;

    /**
     * 0: Floor number -20 (X=0), has a special meaning not only indicating the floor -20
     */
    public static final int FLOOR_NUMBER_MIN = 0;

    /**
     * 252: Floor number = 232(X =252) has a special meaning not only indicating the floor 232, but also any floor above that
     */
    public static final int FLOOR_NUMBER_MAX = 252;

    /**
     * 253: (X =253) meaning floor number 0 and ground floor
     */
    public static final int FLOOR_NUMBER_GROUND_FLOOR_0 = 253;

    /**
     * 254: (X =254) meaning floor number 1 and ground floor
     */
    public static final int FLOOR_NUMBER_GROUND_FLOOR_1 = 254;

    /**
     * 255: X =255 means no floor number is configured
     */
    public static final int FLOOR_NUMBER_NO_FLOOR_NUMBER_IS_CONFIGURED = 255;

    /**
     * Floor number offset
     */
    public static final int FLOOR_NUMBER_OFFSET = -20;

    /**
     * 65535: Altitude is not configured
     */
    public static final int ALTITUDE_IS_NOT_CONFIGURED = 65535;

    /**
     * 65534: Altitude is greater than or equal to 64534 decimeters
     */
    public static final int ALTITUDE_MAX = 65534;

    /**
     * 0: Altitude is less than or equal to -1000 decimeters
     */
    public static final int ALTITUDE_MIN = 0;

    /**
     * Altitude offset
     */
    public static final int ALTITUDE_OFFSET = -1000;

    /**
     * @see #UNCERTAINTY_STATIONARY_STATIONARY
     * @see #UNCERTAINTY_STATIONARY_MOBILE
     */
    public static final int UNCERTAINTY_STATIONARY_MASK = 0b00000001;

    /**
     * 0: stationary
     */
    public static final int UNCERTAINTY_STATIONARY_STATIONARY = 0b00000000;

    /**
     * 1: mobile
     */
    public static final int UNCERTAINTY_STATIONARY_MOBILE = 0b00000001;

    /**
     * @see #UNCERTAINTY_UPDATE_TIME_UPTO_3S
     * @see #UNCERTAINTY_UPDATE_TIME_UPTO_4S
     * @see #UNCERTAINTY_UPDATE_TIME_UPTO_6S
     * @see #UNCERTAINTY_UPDATE_TIME_UPTO_12S
     * @see #UNCERTAINTY_UPDATE_TIME_UPTO_28S
     * @see #UNCERTAINTY_UPDATE_TIME_UPTO_89S
     * @see #UNCERTAINTY_UPDATE_TIME_UPTO_426S
     * @see #UNCERTAINTY_UPDATE_TIME_3541S
     */
    public static final int UNCERTAINTY_UPDATE_TIME_MASK = 0b00001110;

    /**
     * 0: upto 3s
     */
    public static final int UNCERTAINTY_UPDATE_TIME_UPTO_3S = 0b00000000;

    /**
     * 1: upto 4s
     */
    public static final int UNCERTAINTY_UPDATE_TIME_UPTO_4S = 0b00000010;

    /**
     * 2: upto 6s
     */
    public static final int UNCERTAINTY_UPDATE_TIME_UPTO_6S = 0b00000100;

    /**
     * 3: upto 12s
     */
    public static final int UNCERTAINTY_UPDATE_TIME_UPTO_12S = 0b00000110;

    /**
     * 4: upto 28s
     */
    public static final int UNCERTAINTY_UPDATE_TIME_UPTO_28S = 0b00001000;

    /**
     * 5: upto 89s
     */
    public static final int UNCERTAINTY_UPDATE_TIME_UPTO_89S = 0b00001010;

    /**
     * 6: upto 426s
     */
    public static final int UNCERTAINTY_UPDATE_TIME_UPTO_426S = 0b00001100;

    /**
     * 7: 3541s
     */
    public static final int UNCERTAINTY_UPDATE_TIME_3541S = 0b00001110;

    /**
     * @see #UNCERTAINTY_PRECISION_IDEAL
     * @see #UNCERTAINTY_PRECISION_EXCELLENT
     * @see #UNCERTAINTY_PRECISION_GOOD
     * @see #UNCERTAINTY_PRECISION_MODERATE
     * @see #UNCERTAINTY_PRECISION_FAIR
     * @see #UNCERTAINTY_PRECISION_POOR
     * @see #UNCERTAINTY_PRECISION_USELESS
     */
    public static final int UNCERTAINTY_PRECISION_MASK = 0b01110000;

    /**
     * 0: less than 0.1m
     */
    public static final int UNCERTAINTY_PRECISION_IDEAL = 0b00000000;

    /**
     * 1: 0.1-1m
     */
    public static final int UNCERTAINTY_PRECISION_EXCELLENT = 0b00010000;

    /**
     * 2: 1-2m
     */
    public static final int UNCERTAINTY_PRECISION_GOOD = 0b00100000;

    /**
     * 3: 2-5m
     */
    public static final int UNCERTAINTY_PRECISION_MODERATE = 0b00110000;

    /**
     * 4: 5-10m
     */
    public static final int UNCERTAINTY_PRECISION_FAIR = 0b01000000;

    /**
     * 5: 10-50m
     */
    public static final int UNCERTAINTY_PRECISION_POOR = 0b01010000;

    /**
     * 6: greater than 50m
     */
    public static final int UNCERTAINTY_PRECISION_USELESS = 0b01100000;

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Coordinates are not present, {@code false}:Coordinates are present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesAreNotPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Coordinates are present, {@code false}:Coordinates are not present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:WGS84 coordinate system, {@code false}:Local coordinate system
     */
    public static boolean isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Local coordinate system, {@code false}:WGS84 coordinate system
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsLocalCoordinateSystem(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Tx Power is not present, {@code false}:Tx Power is present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsNotPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Tx Power is present, {@code false}:Tx Power is not present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Altitude is not present, {@code false}:Altitude is present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsNotPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Altitude is present, {@code false}:Altitude is not present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Floor Number is not present, {@code false}:Floor Number is present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsNotPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Floor Number is present, {@code false}:Floor Number is not present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Uncertainty is not present, {@code false}:Uncertainty is present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsNotPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Uncertainty is present, {@code false}:Uncertainty is not present
     */
    public static boolean isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_MASK,
                INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Location Name is not present, {@code false}:Location Name is not present
     */
    public static boolean isIndoorPositioningConfigurationLocationNameAvailableInTheGattDatabaseLocationNameIsNotPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_MASK,
                INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:Location Name is not present, {@code false}:Location Name is not present
     */
    public static boolean isIndoorPositioningConfigurationLocationNameAvailableInTheGattDatabaseLocationNameIsPresent(int indoorPositioningConfiguration) {
        return isIndoorPositioningConfigurationMatched(INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_MASK,
                INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_PRESENT, indoorPositioningConfiguration);
    }

    /**
     * @param latitude Latitude
     * @return {@code true}:Latitude Characteristic indicates not configured, {@code false}:Latitude Characteristic indicates configured
     */
    public static boolean isLatitudeNotConfigured(int latitude) {
        return LATITUDE_NOT_CONFIGURED == latitude;
    }

    /**
     * @param latitude Latitude
     * @return Latitude(Wgs84)
     */
    public static double getLatitudeWgs84(int latitude) {
        return latitude * 90d / Math.pow(2, 31);
    }

    /**
     * @param longitude Longitude
     * @return {@code true}:Latitude Characteristic indicates not configured, {@code false}:Latitude Characteristic indicates configured
     */
    public static boolean isLongitudeNotConfigured(int longitude) {
        return LONGITUDE_NOT_CONFIGURED == longitude;
    }

    /**
     * @param longitude Longitude
     * @return Longitude(Wgs84)
     */
    public static double getLongitudeWgs84(int longitude) {
        return longitude * 180d / Math.pow(2, 31);
    }

    /**
     * @param localNorthCoordinate Local North Coordinate
     * @return {@code true}:Local North Coordinateinformation is not configured, {@code false}:Local North Coordinateinformation is configured
     */
    public static boolean isLocalNorthCoordinateNotConfigured(int localNorthCoordinate) {
        return LOCAL_NORTH_COORDINATE_NOT_CONFIGURED == localNorthCoordinate;
    }

    /**
     * @param localEastCoordinate Local East Coordinate
     * @return {@code true}:Local East Coordinateinformation is not configured, {@code false}:Local East Coordinateinformation is configured
     */
    public static boolean isLocalEastCoordinateNotConfigured(int localEastCoordinate) {
        return LOCAL_EAST_COORDINATE_NOT_CONFIGURED == localEastCoordinate;
    }

    /**
     * @param floorNumber Floor Number
     * @return {@code true}:Floor number &lt;= -20 {@code false}:Flow number &gt; 20
     */
    public static boolean isFloorNumberMinValue(int floorNumber) {
        return FLOOR_NUMBER_MIN == floorNumber;
    }

    /**
     * @param floorNumber Floor Number
     * @return {@code true}:Floor number &gt;= 232, {@code false}:Floor number &lt; 232
     */
    public static boolean isFloorNumberMaxValue(int floorNumber) {
        return FLOOR_NUMBER_MAX == floorNumber;
    }

    /**
     * @param floorNumber Floor Number
     * @return {@code true}:ground floor, {@code false}:not ground floor
     */
    public static boolean isFloorNumberGroundFloor(int floorNumber) {
        return FLOOR_NUMBER_GROUND_FLOOR_0 == floorNumber || FLOOR_NUMBER_GROUND_FLOOR_1 == floorNumber;
    }

    /**
     * @param floorNumber Floor Number
     * @return {@code true}:no floor number is configured, {@code false}:floor number is configured
     */
    public static boolean isFloorNumberNotConfigured(int floorNumber) {
        return FLOOR_NUMBER_NO_FLOOR_NUMBER_IS_CONFIGURED == floorNumber;
    }

    /**
     * @param floorNumber Floor Number
     * @return Floor Number with Offset
     */
    public static int getFloorNumberWithOffset(int floorNumber) {
        int floorNumberWithOffset;
        if (FLOOR_NUMBER_GROUND_FLOOR_0 == floorNumber) {
            floorNumberWithOffset = 0;
        } else if (FLOOR_NUMBER_GROUND_FLOOR_1 == floorNumber) {
            floorNumberWithOffset = 1;
        } else {
            floorNumberWithOffset = floorNumber + FLOOR_NUMBER_OFFSET;
        }
        return floorNumberWithOffset;
    }

    /**
     * @param altitude Altitude
     * @return {@code true}:Altitude is not configured, {@code false}:Altitude is configured
     */
    public static boolean isAltitudeNotConfigured(int altitude) {
        return ALTITUDE_IS_NOT_CONFIGURED == altitude;
    }

    /**
     * @param altitude Altitude
     * @return {@code true}:Altitude &gt;= 64534 decimeters, {@code false}:Altitude &lt; 64534 decimeters
     */
    public static boolean isAltitudeMaxValue(int altitude) {
        return ALTITUDE_MAX == altitude;
    }

    /**
     * @param altitude Altitude
     * @return {@code true}:Altitude &lt; -1000 decimeters, {@code false}:Altitude &gt;= -1000 decimeters
     */
    public static boolean isAltitudeMinValue(int altitude) {
        return ALTITUDE_MIN == altitude;
    }

    /**
     * @param altitude Altitude
     * @return Altitude(decimeters)
     */
    public static int getAltitudeDecimeters(int altitude) {
        return altitude + ALTITUDE_OFFSET;
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:stationary, {@code false}:not stationary
     */
    public static boolean isUncertaintyStationaryStationary(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_STATIONARY_MASK, UNCERTAINTY_STATIONARY_STATIONARY, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:mobile, {@code false}:not mobile
     */
    public static boolean isUncertaintyStationaryMobile(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_STATIONARY_MASK, UNCERTAINTY_STATIONARY_MOBILE, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:upto 3s, {@code false}:not upto 3s
     */
    public static boolean isUncertaintyUpdateTimeUpto3s(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_UPDATE_TIME_MASK, UNCERTAINTY_UPDATE_TIME_UPTO_3S, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:upto 4s, {@code false}:not upto 4s
     */
    public static boolean isUncertaintyUpdateTimeUpto4s(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_UPDATE_TIME_MASK, UNCERTAINTY_UPDATE_TIME_UPTO_4S, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:upto 6s, {@code false}:not upto 6s
     */
    public static boolean isUncertaintyUpdateTimeUpto6s(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_UPDATE_TIME_MASK, UNCERTAINTY_UPDATE_TIME_UPTO_6S, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:upto 12s, {@code false}:not upto 12s
     */
    public static boolean isUncertaintyUpdateTimeUpto12s(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_UPDATE_TIME_MASK, UNCERTAINTY_UPDATE_TIME_UPTO_12S, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:upto 28s, {@code false}:not upto 28s
     */
    public static boolean isUncertaintyUpdateTimeUpto28s(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_UPDATE_TIME_MASK, UNCERTAINTY_UPDATE_TIME_UPTO_28S, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:upto 89s, {@code false}:not upto 89s
     */
    public static boolean isUncertaintyUpdateTimeUpto89s(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_UPDATE_TIME_MASK, UNCERTAINTY_UPDATE_TIME_UPTO_89S, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:upto 426s, {@code false}:not upto 426s
     */
    public static boolean isUncertaintyUpdateTimeUpto426s(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_UPDATE_TIME_MASK, UNCERTAINTY_UPDATE_TIME_UPTO_426S, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:3541s, {@code false}:not 3541s
     */
    public static boolean isUncertaintyUpdateTime3541s(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_UPDATE_TIME_MASK, UNCERTAINTY_UPDATE_TIME_3541S, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:less than 0.1m, {@code false}:not less than 0.1m
     */
    public static boolean isUncertaintyPrecisionIdeal(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_PRECISION_MASK, UNCERTAINTY_PRECISION_IDEAL, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:0.1-1m, {@code false}:not 0.1-1m
     */
    public static boolean isUncertaintyPrecisionExcellent(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_PRECISION_MASK, UNCERTAINTY_PRECISION_EXCELLENT, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:1-2m, {@code false}:not 1-2m
     */
    public static boolean isUncertaintyPrecisionGood(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_PRECISION_MASK, UNCERTAINTY_PRECISION_GOOD, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:2-5m, {@code false}:not 2-5m
     */
    public static boolean isUncertaintyPrecisionModerate(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_PRECISION_MASK, UNCERTAINTY_PRECISION_MODERATE, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:5-10m, {@code false}:not 5-10m
     */
    public static boolean isUncertaintyPrecisionFair(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_PRECISION_MASK, UNCERTAINTY_PRECISION_FAIR, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:10-50m, {@code false}:not 10-50m
     */
    public static boolean isUncertaintyPrecisionPoor(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_PRECISION_MASK, UNCERTAINTY_PRECISION_POOR, uncertainty);
    }

    /**
     * @param uncertainty Uncertainty
     * @return {@code true}:greater than 50m, {@code false}:not greater than 50m
     */
    public static boolean isUncertaintyPrecisionUseless(int uncertainty) {
        return isUncertaintyMatched(UNCERTAINTY_PRECISION_MASK, UNCERTAINTY_PRECISION_USELESS, uncertainty);
    }

    /**
     * check Indoor Positioning Configuration
     *
     * @param mask                           bitmask for expect
     * @param expect                         one of {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT}
     *                                       , {@link #INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_PRESENT}
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private static boolean isIndoorPositioningConfigurationMatched(int mask, int expect, int indoorPositioningConfiguration) {
        return (mask & indoorPositioningConfiguration) == expect;
    }

    /**
     * check Uncertainty
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #UNCERTAINTY_STATIONARY_STATIONARY}
     *               , {@link #UNCERTAINTY_STATIONARY_MOBILE}
     *               , {@link #UNCERTAINTY_UPDATE_TIME_UPTO_3S}
     *               , {@link #UNCERTAINTY_UPDATE_TIME_UPTO_4S}
     *               , {@link #UNCERTAINTY_UPDATE_TIME_UPTO_6S}
     *               , {@link #UNCERTAINTY_UPDATE_TIME_UPTO_12S}
     *               , {@link #UNCERTAINTY_UPDATE_TIME_UPTO_28S}
     *               , {@link #UNCERTAINTY_UPDATE_TIME_UPTO_89S}
     *               , {@link #UNCERTAINTY_UPDATE_TIME_UPTO_426S}
     *               , {@link #UNCERTAINTY_UPDATE_TIME_3541S}
     *               , {@link #UNCERTAINTY_PRECISION_IDEAL}
     *               , {@link #UNCERTAINTY_PRECISION_EXCELLENT}
     *               , {@link #UNCERTAINTY_PRECISION_GOOD}
     *               , {@link #UNCERTAINTY_PRECISION_MODERATE}
     *               , {@link #UNCERTAINTY_PRECISION_FAIR}
     *               , {@link #UNCERTAINTY_PRECISION_POOR}
     *               , {@link #UNCERTAINTY_PRECISION_USELESS}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private static boolean isUncertaintyMatched(int mask, int expect, int uncertainty) {
        return (mask & uncertainty) == expect;
    }

}
