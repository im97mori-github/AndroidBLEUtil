package org.im97mori.ble.characteristic.ftms;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class RowerDataUtilsTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[5];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[3];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[5];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[4];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[4];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[4];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[4];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[4];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00702 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[7];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data_00802 = data;
    }

    private static final byte[] data_00803;
    static {
        byte[] data = new byte[7];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) RowerDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE;
        data[ 3] = (byte) (RowerDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE >> 8);
        data[ 4] = (byte) RowerDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE;
        data[ 5] = (byte) (RowerDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE >> 8);
        data[ 6] = (byte) RowerDataUtils.ENERGY_PER_MINUTE_DATA_NOT_AVAILABLE;
        data_00803 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00901 = data;
    }

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[3];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_00902 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_01001 = data;
    }

    private static final byte[] data_01002;
    static {
        byte[] data = new byte[3];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_01002 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_01101 = data;
    }

    private static final byte[] data_01102;
    static {
        byte[] data = new byte[4];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01102 = data;
    }

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[2];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_01201 = data;
    }

    private static final byte[] data_01202;
    static {
        byte[] data = new byte[4];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01202 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
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

        assertTrue(RowerDataUtils.isFlagsMoreDataFalse(data));
        assertFalse(RowerDataUtils.isFlagsMoreDataTrue(data));
        assertEquals(RowerDataUtils.STROKE_RATE_RESOLUTION * BLEUtils.createUInt8(data, 2)
                , RowerDataUtils.getStrokeRateStrokePerMinute(BLEUtils.createUInt8(data, 2)), 0);
    }

    @Test
    public void test_00002() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsMoreDataFalse(data));
        assertTrue(RowerDataUtils.isFlagsMoreDataTrue(data));
    }

    @Test
    public void test_00101() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsAverageStrokeNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsAverageStrokePresent(data));
    }

    @Test
    public void test_00102() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsAverageStrokeNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsAverageStrokePresent(data));
        assertEquals(RowerDataUtils.AVERAGE_STROKE_RATE_RESOLUTION * BLEUtils.createUInt8(data, 2)
                , RowerDataUtils.getAverageStrokeRateRpm(BLEUtils.createUInt8(data, 2)), 0);
    }

    @Test
    public void test_00201() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsTotalDistanceNotPresente(data));
        assertFalse(RowerDataUtils.isFlagsTotalDistancePresente(data));
    }

    @Test
    public void test_00202() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsTotalDistanceNotPresente(data));
        assertTrue(RowerDataUtils.isFlagsTotalDistancePresente(data));
    }

    @Test
    public void test_00301() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsInstantaneousPaceNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsInstantaneousPacePresent(data));
    }

    @Test
    public void test_00302() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsInstantaneousPaceNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsInstantaneousPacePresent(data));
    }

    @Test
    public void test_00401() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsAveragePaceNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsAveragePacePresent(data));
    }

    @Test
    public void test_00402() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsAveragePaceNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsAveragePacePresent(data));
    }

    @Test
    public void test_00501() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsInstantaneousPowerNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsInstantaneousPowerPresent(data));
    }

    @Test
    public void test_00502() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsInstantaneousPowerNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsInstantaneousPowerPresent(data));
    }

    @Test
    public void test_00601() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsAveragePowerNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsAveragePowerPresent(data));
    }

    @Test
    public void test_00602() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsAveragePowerNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsAveragePowerPresent(data));
    }

    @Test
    public void test_00701() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsResistanceLevelNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsResistanceLevelPresent(data));
    }

    @Test
    public void test_00702() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsResistanceLevelNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsResistanceLevelPresent(data));
    }

    @Test
    public void test_00801() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsExpendedEnergyPresent(data));
    }

    @Test
    public void test_00802() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsExpendedEnergyPresent(data));
        assertFalse(RowerDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 2)));
        assertFalse(RowerDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertFalse(RowerDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 6)));
    }

    @Test
    public void test_00803() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsExpendedEnergyPresent(data));
        assertTrue(RowerDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 2)));
        assertTrue(RowerDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertTrue(RowerDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 6)));
    }

    @Test
    public void test_00901() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsHeartRateNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_00902() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsHeartRateNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_01001() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsMetabolicEquivalentPresent(data));
    }

    @Test
    public void test_01002() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsMetabolicEquivalentPresent(data));
        assertEquals(RowerDataUtils.METABOLIC_EQUIVALENT_RESOLUTION * BLEUtils.createUInt8(data, 2)
                , RowerDataUtils.getMetabolicEquivalentWithUnit(BLEUtils.createUInt8(data, 2)), 0);
    }

    @Test
    public void test_01101() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_01102() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_01201() {
        byte[] data = getData();

        assertTrue(RowerDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertFalse(RowerDataUtils.isFlagsRemainingTimePresent(data));
    }

    @Test
    public void test_01202() {
        byte[] data = getData();

        assertFalse(RowerDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertTrue(RowerDataUtils.isFlagsRemainingTimePresent(data));
    }

}
