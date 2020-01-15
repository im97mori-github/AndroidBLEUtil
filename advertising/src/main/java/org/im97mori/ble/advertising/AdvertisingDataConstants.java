package org.im97mori.ble.advertising;

import android.annotation.SuppressLint;
import android.util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * BLE Advertising Data Constants
 */
@SuppressWarnings("WeakerAccess")
@SuppressLint("UseSparseArrays")
public class AdvertisingDataConstants {

    /**
     * <p>
     * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
     * Core Specification Supplement v8 Part A DATA TYPESSPECIFICATION
     * </p>
     */
    public static final class AdvertisingDataTypes {

        // 1.1 SERVICE UUID

        /**
         * Incomplete List of 16-bit Service Class UUIDs
         */
        public static final int DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS = 0x02;

        /**
         * Complete List of 16-bit Service Class UUIDs
         */
        public static final int DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS = 0x03;

        /**
         * Incomplete List of 32-bit Service Class UUIDs
         */
        public static final int DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS = 0x04;

        /**
         * Complete List of 32-bit Service Class UUIDs
         */
        public static final int DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS = 0x05;

        /**
         * Incomplete List of 128-bit Service Class UUIDs
         */
        public static final int DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS = 0x06;

        /**
         * Complete List of 128-bit Service Class UUIDs
         */
        public static final int DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS = 0x07;


        // 1.2 LOCAL NAME

        /**
         * Shortened Local Name
         */
        public static final int DATA_TYPE_SHORTENED_LOCAL_NAME = 0x08;

        /**
         * Complete Local Name
         */
        public static final int DATA_TYPE_COMPLETE_LOCAL_NAME = 0x09;


        // 1.3 FLAGS

        /**
         * Flags
         */
        public static final int DATA_TYPE_FLAGS = 0x01;


        // 1.4   MANUFACTURER SPECIFIC DATA

        /**
         * Manufacturer Specific Data
         */
        public static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 0xff;


        // 1.5 TX POWER LEVEL

        /**
         * Tx Power Level
         */
        public static final int DATA_TYPE_TX_POWER_LEVEL = 0x0a;


        // 1.9 SLAVE CONNECTION INTERVAL RANGE

        /**
         * Slave Connection Interval Range
         */
        public static final int DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE = 0x12;


        // 1.10 SERVICE SOLICITATION

        /**
         * List of 16-bit Service Solicitation UUIDs
         */
        public static final int DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS = 0x14;

        /**
         * List of 32-bit Service Solicitation UUIDs
         */
        public static final int DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS = 0x1f;

        /**
         * List of 128-bit Service Solicitation UUIDs
         */
        public static final int DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS = 0x15;


        // 1.11   SERVICE DATA

        /**
         * Service Data - 16-bit UUID
         */
        public static final int DATA_TYPE_SERVICE_DATA_16_BIT_UUID = 0x16;

        /**
         * Service Data - 32-bit UUID
         */
        public static final int DATA_TYPE_SERVICE_DATA_32_BIT_UUID = 0x20;

        /**
         * Service Data - 128-bit UUID
         */
        public static final int DATA_TYPE_SERVICE_DATA_128_BIT_UUID = 0x21;


        // 1.12 APPEARANCE

        /**
         * Appearance
         */
        public static final int DATA_TYPE_APPEARANCE = 0x19;


        // 1.13 PUBLIC TARGET ADDRESS

        /**
         * Public Target Address
         */
        public static final int DATA_TYPE_PUBLIC_TARGET_ADDRESS = 0x17;


        // 1.14 RANDOM TARGET ADDRESS

        /**
         * Random Target Address
         */
        public static final int DATA_TYPE_RANDOM_TARGET_ADDRESS = 0x18;


        // 1.15 ADVERTISING INTERVAL

        /**
         * Advertising Interval
         */
        public static final int DATA_TYPE_ADVERTISING_INTERVAL = 0x1a;


        // 1.18 UNIFORM RESOURCE IDENTIFIER (URI)

        /**
         * URI
         */
        public static final int DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER = 0x24;

        /**
         * Indoor Positioning
         */
        public static final int DATA_TYPE_INDOOR_POSITIONING = 0x25;

        /**
         * Transport Discovery Data
         */
        public static final int DATA_TYPE_TRANSPORT_DISCOVERY_DATA = 0x26;

        // 1.19 LE SUPPORTED FEATURES

        /**
         * LE Supported Features
         */
        public static final int DATA_TYPE_LE_SUPPORTED_FEATURES = 0x27;


        // 1.20 CHANNEL MAP UPDATE INDICATION

        /**
         * Channel Map Update Indication
         */
        public static final int DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION = 0x28;
    }

    /**
     * <p>
     * Flags Constants
     * <p>
     * Core Specification Supplement v8 Part A 1.3
     * <p>
     * {@link Pair#first}:offset, {@link Pair#second}:bitmask
     * </p>
     */
    public static final class FlagsDataType {

        /**
         * LE Limited Discoverable Mode
         */
        public static final Pair<Integer, Integer> FLAG_LE_LIMITED_DISCOVERABLE_MODE = Pair.create(0, 0b00000001);

        /**
         * LE General Discoverable Mode
         */
        public static final Pair<Integer, Integer> FLAG_LE_GENERAL_DISCOVERABLE_MODE = Pair.create(0, 0b00000010);

        /**
         * BR/EDR Not Supported
         */
        public static final Pair<Integer, Integer> FLAG_BR_EDR_NOT_SUPPORTED = Pair.create(0, 0b00000100);

        /**
         * Simultaneous LE and BR/EDR to Same Device Capable (Controller)
         */
        public static final Pair<Integer, Integer> FLAG_SIMULTANEOUS_LE_AND_BR_EDR_TO_SAME_DEVICE_CAPABLE_CONTROLLER = Pair.create(0, 0b00001000);

        /**
         * Simultaneous LE and BR/EDR to Same Device Capable (Host)
         */
        public static final Pair<Integer, Integer> FLAG_SIMULTANEOUS_LE_AND_BR_EDR_TO_SAME_DEVICE_CAPABLE_HOST = Pair.create(0, 0b00010000);

    }

    /**
     * Core Specification Supplement v8 Part A 1.9.2 Unit of Connection Interval Range(millis)
     */
    public static final double SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS = 1.25d;

    /**
     * Core Specification Supplement v8 Part A 1.9.2 no specific minimum / maximum values
     */
    public static final int SLAVE_CONNECTION_INTERVAL_NO_SPECIFIC_VALUE = 0xffff;

    /**
     * Core Specification Supplement v8 Part A 1.15.2 Unit of Advertising Interval(millis)
     */
    public static final double ADVERTISING_INTERVAL_UNIT_MILLIS = 0.625d;

    /**
     * <p>
     * LE Supported Features Constants
     * <p>
     * Core Specification Supplement v8 Part A 1.19
     * Core Specification v5.1 Vol 6 Part B 4.6
     * <p>
     * {@link Pair#first}:offset, {@link Pair#second}:bitmask
     * </p>
     */
    public static final class LeSupportedFeatures {

        /**
         * LE Encryption
         */
        public static final Pair<Integer, Integer> FEATURE_SUPPORTED_FEATURE_LE_ENCRYPTION = Pair.create(0, 0b00000001);

        /**
         * Connection Parameters Request Procedure
         */
        public static final Pair<Integer, Integer> FEATURE_CONNECTION_PARAMETERS_REQUEST_PROCEDURE = Pair.create(0, 0b00000010);

        /**
         * Extended Reject Indication
         */
        public static final Pair<Integer, Integer> FEATURE_EXTENDED_REJECT_INDICATION = Pair.create(0, 0b00000100);

        /**
         * Slave-initiated Features Exchange
         */
        public static final Pair<Integer, Integer> FEATURE_SLAVE_INITIATED_FEATURES_EXCHANGE = Pair.create(0, 0b00001000);

        /**
         * LE Ping
         */
        public static final Pair<Integer, Integer> FEATURE_LE_PING = Pair.create(0, 0b00010000);

        /**
         * LE Data Packet Length Extension
         */
        public static final Pair<Integer, Integer> FEATURE_LE_DATA_PACKET_LENGTH_EXTENSION = Pair.create(0, 0b00100000);

        /**
         * LL Privacy
         */
        public static final Pair<Integer, Integer> FEATURE_LL_PRIVACY = Pair.create(0, 0b01000000);

        /**
         * Extended Scanner Filter Policies
         */
        public static final Pair<Integer, Integer> FEATURE_EXTENDED_SCANNER_FILTER_POLICIES = Pair.create(0, 0b10000000);

        /**
         * LE 2M PHY
         */
        public static final Pair<Integer, Integer> FEATURE_LE_2M_PHY = Pair.create(1, 0b00000001);

        /**
         * Stable Modulation Index - Transmitter
         */
        public static final Pair<Integer, Integer> FEATURE_STABLE_MODULATION_INDEX_TRANSMITTER = Pair.create(1, 0b00000010);

        /**
         * Stable Modulation Index - Receiver
         */
        public static final Pair<Integer, Integer> FEATURE_STABLE_MODULATION_INDEX_RECEIVER = Pair.create(1, 0b00000100);

        /**
         * LE Coded PHY
         */
        public static final Pair<Integer, Integer> FEATURE_LE_CODED_PHY = Pair.create(1, 0b00001000);

        /**
         * LE Extended Advertising
         */
        public static final Pair<Integer, Integer> FEATURE_LE_EXTENDED_ADVERTISING = Pair.create(1, 0b00010000);

        /**
         * LE Periodic Advertising
         */
        public static final Pair<Integer, Integer> FEATURE_LE_PERIODIC_ADVERTISING = Pair.create(1, 0b00100000);

        /**
         * Channel Selection Algorithm #2
         */
        public static final Pair<Integer, Integer> FEATURE_CHANNEL_SELCTION_ALGORITHM_2 = Pair.create(1, 0b01000000);

        /**
         * LE Power Class 1
         */
        public static final Pair<Integer, Integer> FEATURE_LE_POWER_CLASS_1 = Pair.create(1, 0b10000000);

        /**
         * Minimum Number of Used Channels Procedure
         */
        public static final Pair<Integer, Integer> FEATURE_MINIMUM_NUMBER_OF_USED_CHANNELS_PROCEDURE = Pair.create(2, 0b00000001);

        /**
         * Connection CTE Request
         */
        public static final Pair<Integer, Integer> FEATURE_CONNECTION_CTE_REQUEST = Pair.create(2, 0b00000010);

        /**
         * Connection CTE Response
         */
        public static final Pair<Integer, Integer> FEATURE_CONNECTION_CTE_RESPONSE = Pair.create(2, 0b00000100);

        /**
         * Connectionless CTE Transmitter
         */
        public static final Pair<Integer, Integer> FEATURE_CONNECTIONLESS_CTE_TRANSMITTER = Pair.create(2, 0b00001000);

        /**
         * Connectionless CTE Receiver
         */
        public static final Pair<Integer, Integer> FEATURE_CONNECTIONLESS_CTE_RECEIVER = Pair.create(2, 0b00010000);

        /**
         * Antenna Switching During CTE Transmission (AoD)
         */
        public static final Pair<Integer, Integer> FEATURE_ANTENNA_SWITCHING_DURING_CTE_TRANSMISSION_AOD = Pair.create(2, 0b00100000);

        /**
         * Antenna Switching During CTE Reception (AoA)
         */
        public static final Pair<Integer, Integer> FEATURE_ANTENNA_SWITCHING_DURING_CTE_RECEPTION_AOA = Pair.create(2, 0b01000000);

        /**
         * Receiving Constant Tone Extensions
         */
        public static final Pair<Integer, Integer> FEATURE_RECEIVING_CONSTANT_TONE_EXTENSIONS = Pair.create(2, 0b10000000);

        /**
         * Periodic Advertising Sync Transfer - Sender
         */
        public static final Pair<Integer, Integer> FEATURE_PERIODIC_ADVERTISING_SYNC_TRANSFER_SENDER = Pair.create(3, 0b00000001);

        /**
         * Periodic Advertising Sync Transfer - Recipient
         */
        public static final Pair<Integer, Integer> FEATURE_PERIODIC_ADVERTISING_SYNC_TRANSFER_RECIPIENT = Pair.create(3, 0b00000010);

        /**
         * Sleep Clock Accuracy Updates
         */
        public static final Pair<Integer, Integer> FEATURE_SLEEP_CLOCK_ACCURACY_UPDATES = Pair.create(3, 0b00000100);

        /**
         * Remote Public Key Validation
         */
        public static final Pair<Integer, Integer> FEATURE_REMOTE_PUBLIC_KEY_VALIDATION = Pair.create(3, 0b00001000);

    }

    /**
     * <p>
     * Physical channel indices
     * <p>
     * Core Specification v5.1 Vol 6 Part B 1.4.6
     * <p>
     * key:PHY Channel, value:Channel Index
     * </p>
     */
    public static final Map<Integer, Integer> PHYSICAL_CHANNEL_INDICES_MAP;

    static {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 37);
        map.put(1, 0);
        map.put(2, 1);
        map.put(3, 2);
        map.put(4, 3);
        map.put(5, 4);
        map.put(6, 5);
        map.put(7, 6);
        map.put(8, 7);
        map.put(9, 8);
        map.put(10, 9);
        map.put(11, 10);
        map.put(12, 38);
        map.put(13, 11);
        map.put(14, 12);
        map.put(15, 13);
        map.put(16, 14);
        map.put(17, 15);
        map.put(18, 16);
        map.put(19, 17);
        map.put(20, 18);
        map.put(21, 19);
        map.put(22, 20);
        map.put(23, 21);
        map.put(24, 22);
        map.put(25, 23);
        map.put(26, 24);
        map.put(27, 25);
        map.put(28, 26);
        map.put(29, 27);
        map.put(30, 28);
        map.put(31, 29);
        map.put(32, 30);
        map.put(33, 31);
        map.put(34, 32);
        map.put(35, 33);
        map.put(36, 34);
        map.put(37, 35);
        map.put(38, 36);
        map.put(39, 39);

        PHYSICAL_CHANNEL_INDICES_MAP = Collections.synchronizedMap(Collections.unmodifiableMap(map));
    }

}
