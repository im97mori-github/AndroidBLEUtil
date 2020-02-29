package org.im97mori.ble.characteristic.u2ace;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.CrossTrainerDataUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"ConstantConditions", "unused"})
public class CrossTrainerDataPacketAndroidTest {

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
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsMoreDataFalse(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsMoreDataTrue(result1.getFlags()));
        assertEquals(0x0201, result1.getInstantaneousSpeed());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsMoreDataFalse(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsMoreDataTrue(result1.getFlags()));
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsAverageSpeedNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsAverageSpeedPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsAverageSpeedNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsAverageSpeedPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getAverageSpeed());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsTotalDistanceNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsTotalDistancePresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsTotalDistanceNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsTotalDistancePresent(result1.getFlags()));
        assertEquals(0x030201, result1.getTotalDistance());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsStepCountNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsStepCountPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsStepCountNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsStepCountPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getStepPerMinute());
        assertEquals(0x0403, result1.getAverageStepRate());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsStrideCountNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsStrideCountPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsStrideCountNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsStrideCountPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getStrideCount());
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsElevationGainNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsElevationGainPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsElevationGainNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsElevationGainPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getPositiveElevationGain());
        assertEquals(0x0403, result1.getNegativeElevationGain());
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getInclination());
        assertEquals(0x0403, result1.getRampAngleSetting());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsResistanceLevelNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsResistanceLevelPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsResistanceLevelNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsResistanceLevelPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getResistanceLevel());
    }

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsInstantaneousPowerNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsInstantaneousPowerPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsInstantaneousPowerNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsInstantaneousPowerPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsAveragePowerNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsAveragePowerPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsAveragePowerNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsAveragePowerPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getAveragePower());
    }

    @Test
    public void test_constructor_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsExpendedEnergyNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsExpendedEnergyPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsExpendedEnergyNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsExpendedEnergyPresent(result1.getFlags()));
        assertEquals(0x0201, result1.getTotalEnergy());
        assertEquals(0x0403, result1.getEnergyPerHour());
        assertEquals(0x05, result1.getEnergyPerMinute());
    }

    @Test
    public void test_constructor_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsHeartRateNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsHeartRatePresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsHeartRateNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsHeartRatePresent(result1.getFlags()));
        assertEquals(0x01, result1.getHeartRate());
    }

    @Test
    public void test_constructor_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsMetabolicEquivalentNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsMetabolicEquivalentPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsMetabolicEquivalentNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsMetabolicEquivalentPresent(result1.getFlags()));
        assertEquals(0x01, result1.getMetabolicEquivalent());
    }

    @Test
    public void test_constructor_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsElapsedTimeNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsElapsedTimePresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsElapsedTimeNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsElapsedTimePresent(result1.getFlags()));
        assertEquals(0x0201, result1.getElapsedTime());
    }

    @Test
    public void test_constructor_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsRemainingTimeNotPresent(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsRemainingTimePresent(result1.getFlags()));
    }

    @Test
    public void test_constructor_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsRemainingTimeNotPresent(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsRemainingTimePresent(result1.getFlags()));
        assertEquals(0x0201, result1.getRemainingTime());
    }

    @Test
    public void test_constructor_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertTrue(CrossTrainerDataUtils.isFlagsMovementDirectionForward(result1.getFlags()));
        assertFalse(CrossTrainerDataUtils.isFlagsMovementDirectionBackward(result1.getFlags()));
    }

    @Test
    public void test_constructor_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertFalse(CrossTrainerDataUtils.isFlagsMovementDirectionForward(result1.getFlags()));
        assertTrue(CrossTrainerDataUtils.isFlagsMovementDirectionBackward(result1.getFlags()));
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataPacketAndroid result1 = new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        CrossTrainerDataPacketAndroid result2 = CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
