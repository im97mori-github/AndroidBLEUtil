package org.im97mori.ble.characteristic.ftms;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"ConstantConditions", "unused"})
public class CrossTrainerDataUtilsTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[5];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[5];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[6];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[7];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_00302 = data;
    }

    private static final byte[] data_00303;
    static {
        byte[] data = new byte[7];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) CrossTrainerDataUtils.STEP_PER_MINUTE_DATA_NOT_AVAILABLE;
        data[ 4] = (byte) (CrossTrainerDataUtils.STEP_PER_MINUTE_DATA_NOT_AVAILABLE >> 8);
        data[ 5] = (byte) CrossTrainerDataUtils.AVERAGE_STEP_RATE_DATA_NOT_AVAILABLE;
        data[ 6] = (byte) (CrossTrainerDataUtils.AVERAGE_STEP_RATE_DATA_NOT_AVAILABLE >> 8);
        data_00303 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[5];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[7];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[7];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_00602 = data;
    }

    private static final byte[] data_00603;
    static {
        byte[] data = new byte[7];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) CrossTrainerDataUtils.INCLINATION_DATA_NOT_AVAILABLE;
        data[ 4] = (byte) (CrossTrainerDataUtils.INCLINATION_DATA_NOT_AVAILABLE >> 8);
        data[ 5] = (byte) CrossTrainerDataUtils.RAMP_ANGLE_SETTING_DATA_NOT_AVAILABLE;
        data[ 6] = (byte) (CrossTrainerDataUtils.RAMP_ANGLE_SETTING_DATA_NOT_AVAILABLE >> 8);
        data_00603 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[5];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00702 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[5];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00802 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_00901 = data;
    }

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[5];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00902 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_01001 = data;
    }

    private static final byte[] data_01002;
    static {
        byte[] data = new byte[8];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data[ 7] = 0x05;
        data_01002 = data;
    }

    private static final byte[] data_01003;
    static {
        byte[] data = new byte[8];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) CrossTrainerDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE;
        data[ 4] = (byte) (CrossTrainerDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE >> 8);
        data[ 5] = (byte) CrossTrainerDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE;
        data[ 6] = (byte) (CrossTrainerDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE >> 8);
        data[ 7] = (byte) CrossTrainerDataUtils.ENERGY_PER_MINUTE_DATA_NOT_AVAILABLE;
        data_01003 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_01101 = data;
    }

    private static final byte[] data_01102;
    static {
        byte[] data = new byte[4];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data_01102 = data;
    }

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_01201 = data;
    }

    private static final byte[] data_01202;
    static {
        byte[] data = new byte[4];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data_01202 = data;
    }

    private static final byte[] data_01301;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_01301 = data;
    }

    private static final byte[] data_01302;
    static {
        byte[] data = new byte[5];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_01302 = data;
    }

    private static final byte[] data_01401;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_01401 = data;
    }

    private static final byte[] data_01402;
    static {
        byte[] data = new byte[5];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_01402 = data;
    }

    private static final byte[] data_01501;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_01501 = data;
    }

    private static final byte[] data_01502;
    static {
        byte[] data = new byte[3];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data_01502 = data;
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

        assertTrue(CrossTrainerDataUtils.isFlagsMoreDataFalse(data));
        assertFalse(CrossTrainerDataUtils.isFlagsMoreDataTrue(data));
        assertEquals(CrossTrainerDataUtils.INSTANTANEOUS_SPEED_RESOLUTION * BLEUtils.createUInt16(data, 3)
                , CrossTrainerDataUtils.getInstantaneousSpeedKilometerPerHour(BLEUtils.createUInt16(data, 3)), 0);
    }

    @Test
    public void test_00002() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsMoreDataFalse(data));
        assertTrue(CrossTrainerDataUtils.isFlagsMoreDataTrue(data));
    }

    @Test
    public void test_00101() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsAverageSpeedNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsAverageSpeedPresent(data));
    }

    @Test
    public void test_00102() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsAverageSpeedNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsAverageSpeedPresent(data));
        assertEquals(CrossTrainerDataUtils.AVERAGE_SPEED_RESOLUTION * BLEUtils.createUInt16(data, 3)
                , CrossTrainerDataUtils.getAverageSpeedKilometerPerHour(BLEUtils.createUInt16(data, 3)), 0);
    }

    @Test
    public void test_00201() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsTotalDistanceNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsTotalDistancePresent(data));
    }

    @Test
    public void test_00202() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsTotalDistanceNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsTotalDistancePresent(data));
    }

    @Test
    public void test_00301() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsStepCountNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsStepCountPresent(data));
    }

    @Test
    public void test_00302() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsStepCountNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsStepCountPresent(data));
        assertFalse(CrossTrainerDataUtils.isStepPerMinuteDataNotAvailable(BLEUtils.createUInt16(data, 3)));
        assertFalse(CrossTrainerDataUtils.isAverageStepRateDataNotAvailable(BLEUtils.createUInt16(data, 5)));
    }

    @Test
    public void test_00303() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsStepCountNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsStepCountPresent(data));
        assertTrue(CrossTrainerDataUtils.isStepPerMinuteDataNotAvailable(BLEUtils.createUInt16(data, 3)));
        assertTrue(CrossTrainerDataUtils.isAverageStepRateDataNotAvailable(BLEUtils.createUInt16(data, 5)));
    }

    @Test
    public void test_00401() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsStrideCountNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsStrideCountPresent(data));
    }

    @Test
    public void test_00402() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsStrideCountNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsStrideCountPresent(data));
        assertEquals(CrossTrainerDataUtils.STRIDE_COUNT_RESOLUTION * BLEUtils.createUInt16(data, 3)
                , CrossTrainerDataUtils.getStrideCountWithUnit(BLEUtils.createUInt16(data, 3)), 0);
    }

    @Test
    public void test_00501() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsElevationGainNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsElevationGainPresent(data));
    }

    @Test
    public void test_00502() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsElevationGainNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsElevationGainPresent(data));
    }

    @Test
    public void test_00601() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingPresent(data));
    }

    @Test
    public void test_00602() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingPresent(data));
        assertFalse(CrossTrainerDataUtils.isInclinationDataNotAvailable(BLEUtils.createSInt16(data, 3)));
        assertEquals(CrossTrainerDataUtils.INCLINATION_RESOLUTION * BLEUtils.createSInt16(data, 3)
                , CrossTrainerDataUtils.getInclinationPercent(BLEUtils.createUInt16(data, 3)), 0);
        assertFalse(CrossTrainerDataUtils.isRampAngleSettingDataNotAvailable(BLEUtils.createSInt16(data, 5)));
        assertEquals(CrossTrainerDataUtils.RAMP_ANGLE_SETTING_RESOLUTION * BLEUtils.createSInt16(data, 5)
                , CrossTrainerDataUtils.getRampAngleSettingDegree(BLEUtils.createSInt16(data, 5)), 0);
    }

    @Test
    public void test_00603() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingPresent(data));
        assertTrue(CrossTrainerDataUtils.isInclinationDataNotAvailable(BLEUtils.createSInt16(data, 3)));
        assertTrue(CrossTrainerDataUtils.isRampAngleSettingDataNotAvailable(BLEUtils.createSInt16(data, 5)));
    }

    @Test
    public void test_00701() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsResistanceLevelNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsResistanceLevelPresent(data));
    }

    @Test
    public void test_00702() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsResistanceLevelNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsResistanceLevelPresent(data));
        assertEquals(CrossTrainerDataUtils.RESISTANCE_LEVEL_RESOLUTION * BLEUtils.createSInt16(data, 3)
                , CrossTrainerDataUtils.getResistanceLevelWithUnit(BLEUtils.createUInt16(data, 3)), 0);
    }

    @Test
    public void test_00801() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsInstantaneousPowerNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsInstantaneousPowerPresent(data));
    }

    @Test
    public void test_00802() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsInstantaneousPowerNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsInstantaneousPowerPresent(data));
    }

    @Test
    public void test_00901() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsAveragePowerNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsAveragePowerPresent(data));
    }

    @Test
    public void test_00902() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsAveragePowerNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsAveragePowerPresent(data));
    }

    @Test
    public void test_01001() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsExpendedEnergyPresent(data));
    }

    @Test
    public void test_01002() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsExpendedEnergyPresent(data));
        assertFalse(CrossTrainerDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 3)));
        assertFalse(CrossTrainerDataUtils.isEnergyPerHouryDataNotAvailable(BLEUtils.createUInt16(data, 5)));
        assertFalse(CrossTrainerDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 7)));
    }

    @Test
    public void test_01003() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsExpendedEnergyPresent(data));
        assertTrue(CrossTrainerDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 3)));
        assertTrue(CrossTrainerDataUtils.isEnergyPerHouryDataNotAvailable(BLEUtils.createUInt16(data, 5)));
        assertTrue(CrossTrainerDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 7)));
    }

    @Test
    public void test_01101() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsHeartRateNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_01102() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsHeartRateNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_01201() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsMetabolicEquivalentPresent(data));
    }

    @Test
    public void test_01202() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsMetabolicEquivalentPresent(data));
        assertEquals(CrossTrainerDataUtils.METABOLIC_EQUIVALENT_RESOLUTION * BLEUtils.createUInt8(data, 3)
                , CrossTrainerDataUtils.getMetabolicEquivalentWithUnit(BLEUtils.createUInt8(data, 3)), 0);
    }

    @Test
    public void test_01301() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_01302() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_01401() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertFalse(CrossTrainerDataUtils.isFlagsRemainingTimePresent(data));
    }

    @Test
    public void test_01402() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertTrue(CrossTrainerDataUtils.isFlagsRemainingTimePresent(data));
    }

    @Test
    public void test_01501() {
        byte[] data = getData();

        assertTrue(CrossTrainerDataUtils.isFlagsMovementDirectionForward(data));
        assertFalse(CrossTrainerDataUtils.isFlagsMovementDirectionBackward(data));
    }

    @Test
    public void test_01502() {
        byte[] data = getData();

        assertFalse(CrossTrainerDataUtils.isFlagsMovementDirectionForward(data));
        assertTrue(CrossTrainerDataUtils.isFlagsMovementDirectionBackward(data));
    }

}
