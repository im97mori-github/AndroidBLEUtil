package org.im97mori.ble.characteristic.ftms;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class IndoorBikeDataUtilsTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[5];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00702 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[7];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data_00802 = data;
    }

    private static final byte[] data_00803;
    static {
        byte[] data = new byte[7];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) IndoorBikeDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE;
        data[ 3] = (byte) (IndoorBikeDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE >> 8);
        data[ 4] = (byte) IndoorBikeDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE;
        data[ 5] = (byte) (IndoorBikeDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE >> 8);
        data[ 6] = (byte) IndoorBikeDataUtils.ENERGY_PER_MINUTE_DATA_NOT_AVAILABLE;
        data_00803 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00901 = data;
    }

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[3];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_00902 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_01001 = data;
    }

    private static final byte[] data_01002;
    static {
        byte[] data = new byte[3];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_01002 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_01101 = data;
    }

    private static final byte[] data_01102;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01102 = data;
    }

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[2];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_01201 = data;
    }

    private static final byte[] data_01202;
    static {
        byte[] data = new byte[4];
        int flags = IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01202 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = 1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if (stackTraceElementArray[2].getMethodName().equals(stackTraceElement.getMethodName())) {
                index += i;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_00001() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsMoreDataFalse(data));
        assertFalse(IndoorBikeDataUtils.isFlagsMoreDataTrue(data));
        assertEquals(IndoorBikeDataUtils.INSTANTANEOUS_SPEED_RESOLUTION * BLEUtils.createUInt16(data, 2)
                , IndoorBikeDataUtils.getInstantaneousSpeedKilometerPerHour(BLEUtils.createUInt16(data, 2)), 0);
    }

    @Test
    public void test_00002() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsMoreDataFalse(data));
        assertTrue(IndoorBikeDataUtils.isFlagsMoreDataTrue(data));
    }

    @Test
    public void test_00101() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsAverageSpeedNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsAverageSpeedPresent(data));
    }

    @Test
    public void test_00102() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsAverageSpeedNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsAverageSpeedPresent(data));
        assertEquals(IndoorBikeDataUtils.AVERAGE_SPEED_RESOLUTION * BLEUtils.createUInt16(data, 2)
                , IndoorBikeDataUtils.getAverageSpeedKilometerPerHour(BLEUtils.createUInt16(data, 2)), 0);
    }

    @Test
    public void test_00201() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsInstantaneousCadenceNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsInstantaneousCadencePresent(data));
    }

    @Test
    public void test_00202() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsInstantaneousCadenceNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsInstantaneousCadencePresent(data));
        assertEquals(IndoorBikeDataUtils.INSTANTANEOUS_CADENCE_RESOLUTION * BLEUtils.createUInt16(data, 2)
                , IndoorBikeDataUtils.getInstantaneousCadenceRpm(BLEUtils.createUInt16(data, 2)), 0);
    }

    @Test
    public void test_00301() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsAverageCandenceNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsAverageCandencePresent(data));
    }

    @Test
    public void test_00302() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsAverageCandenceNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsAverageCandencePresent(data));
        assertEquals(IndoorBikeDataUtils.AVERAGE_CADENCE_RESOLUTION * BLEUtils.createUInt16(data, 2)
                , IndoorBikeDataUtils.getAverageCadenceRpm(BLEUtils.createUInt16(data, 2)), 0);
    }

    @Test
    public void test_00401() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsTotalDistanceNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsTotalDistancePresent(data));
    }

    @Test
    public void test_00402() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsTotalDistanceNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsTotalDistancePresent(data));
    }

    @Test
    public void test_00501() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsResistanceLevelNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsResistanceLevelPresent(data));
    }

    @Test
    public void test_00502() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsResistanceLevelNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsResistanceLevelPresent(data));
    }

    @Test
    public void test_00601() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsInstantaneousPowerNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsInstantaneousPowerPresent(data));
    }

    @Test
    public void test_00602() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsInstantaneousPowerNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsInstantaneousPowerPresent(data));
    }

    @Test
    public void test_00701() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsAveragePowerNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsAveragePowerPresent(data));
    }

    @Test
    public void test_00702() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsAveragePowerNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsAveragePowerPresent(data));
    }

    @Test
    public void test_00801() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsExpendedEnergyPresent(data));
    }

    @Test
    public void test_00802() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsExpendedEnergyPresent(data));
        assertFalse(IndoorBikeDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 2)));
        assertFalse(IndoorBikeDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertFalse(IndoorBikeDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 5)));
    }

    @Test
    public void test_00803() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsExpendedEnergyPresent(data));
        assertTrue(IndoorBikeDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 2)));
        assertTrue(IndoorBikeDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertTrue(IndoorBikeDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 5)));
    }

    @Test
    public void test_00901() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsHeartRateNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_00902() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsHeartRateNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_01001() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsMetabolicEquivalentPresent(data));
    }

    @Test
    public void test_01002() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsMetabolicEquivalentPresent(data));
        assertEquals(IndoorBikeDataUtils.METABOLIC_EQUIVALENT_RESOLUTION * BLEUtils.createUInt8(data, 2)
                , IndoorBikeDataUtils.getMetabolicEquivalentWithUnit(BLEUtils.createUInt8(data, 2)), 0);
    }

    @Test
    public void test_01101() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_01102() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_01201() {
        byte[] data = getData();

        assertTrue(IndoorBikeDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertFalse(IndoorBikeDataUtils.isFlagsRemainingTimePresent(data));
    }

    @Test
    public void test_01202() {
        byte[] data = getData();

        assertFalse(IndoorBikeDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertTrue(IndoorBikeDataUtils.isFlagsRemainingTimePresent(data));
    }
}
