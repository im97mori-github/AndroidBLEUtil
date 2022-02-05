package org.im97mori.ble.characteristic.u2ace;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.CrossTrainerDataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CrossTrainerDataAndroidTest {

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
        //@formatter:off
        byte[] data = new byte[41];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data[ 7] = 0x05;
        data[ 8] = 0x06;
        data[ 9] = 0x07;
        data[10] = 0x08;
        data[11] = 0x09;
        data[12] = 0x0a;
        data[13] = 0x0b;
        data[14] = 0x0c;
        data[15] = 0x0d;
        data[16] = 0x0e;
        data[17] = 0x0f;
        data[18] = 0x10;
        data[19] = 0x11;
        data[20] = 0x12;
        data[21] = 0x13;
        data[22] = 0x14;
        data[23] = 0x15;
        data[24] = 0x16;
        data[25] = 0x17;
        data[26] = 0x18;
        data[27] = 0x19;
        data[28] = 0x1a;
        data[29] = 0x1b;
        data[30] = 0x1c;
        data[31] = 0x1d;
        data[32] = 0x1e;
        data[33] = 0x1f;
        data[34] = 0x20;
        data[35] = 0x21;
        data[36] = 0x22;
        data[37] = 0x23;
        data[38] = 0x24;
        data[39] = 0x25;
        data[40] = 0x26;
        //@formatter:on

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(Arrays.copyOfRange(data, 0, 3), result1.getFlags());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(0x0403, result1.getAverageSpeed());
        assertEquals(0x070605, result1.getTotalDistance());
        assertEquals(0x0908, result1.getStepPerMinute());
        assertEquals(0x0b0a, result1.getAverageStepRate());
        assertEquals(0x0d0c, result1.getStrideCount());
        assertEquals(0x0f0e, result1.getPositiveElevationGain());
        assertEquals(0x1110, result1.getNegativeElevationGain());
        assertEquals(0x1312, result1.getInclination());
        assertEquals(0x1514, result1.getRampAngleSetting());
        assertEquals(0x1716, result1.getResistanceLevel());
        assertEquals(0x1918, result1.getInstantaneousPower());
        assertEquals(0x1b1a, result1.getAveragePower());
        assertEquals(0x1d1c, result1.getTotalEnergy());
        assertEquals(0x1f1e, result1.getEnergyPerHour());
        assertEquals(0x20, result1.getEnergyPerMinute());
        assertEquals(0x21, result1.getHeartRate());
        assertEquals(0x22, result1.getMetabolicEquivalent());
        assertEquals(0x2423, result1.getElapsedTime());
        assertEquals(0x2625, result1.getRemainingTime());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data1 = new byte[41];
        int flags = CrossTrainerDataUtils.FLAGS_MORE_DATA_FALSE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                | CrossTrainerDataUtils.FLAGS_MOVEMENT_DIRECTION_TRUE;
        data1[ 0] = (byte) flags;
        data1[ 1] = (byte) (flags >> 8);
        data1[ 2] = (byte) (flags >> 16);
        data1[ 3] = 0x01;
        data1[ 4] = 0x02;
        data1[ 5] = 0x03;
        data1[ 6] = 0x04;
        data1[ 7] = 0x05;
        data1[ 8] = 0x06;
        data1[ 9] = 0x07;
        data1[10] = 0x08;
        data1[11] = 0x09;
        data1[12] = 0x0a;
        data1[13] = 0x0b;
        data1[14] = 0x0c;
        data1[15] = 0x0d;
        data1[16] = 0x0e;
        data1[17] = 0x0f;
        data1[18] = 0x10;
        data1[19] = 0x11;
        data1[20] = 0x12;
        data1[21] = 0x13;
        data1[22] = 0x14;
        data1[23] = 0x15;
        data1[24] = 0x16;
        data1[25] = 0x17;
        data1[26] = 0x18;
        data1[27] = 0x19;
        data1[28] = 0x1a;
        data1[29] = 0x1b;
        data1[30] = 0x1c;
        data1[31] = 0x1d;
        data1[32] = 0x1e;
        data1[33] = 0x1f;
        data1[34] = 0x20;
        data1[35] = 0x21;
        data1[36] = 0x22;
        data1[37] = 0x23;
        data1[38] = 0x24;
        data1[39] = 0x25;
        data1[40] = 0x26;

        byte[] data2 = new byte[41];
        data2[ 0] = (byte) flags;
        data2[ 1] = (byte) (flags >> 8);
        data2[ 2] = (byte) (flags >> 16);
        data2[ 3] = 0x27;
        data2[ 4] = 0x28;
        data2[ 5] = 0x29;
        data2[ 6] = 0x2a;
        data2[ 7] = 0x2b;
        data2[ 8] = 0x2c;
        data2[ 9] = 0x2d;
        data2[10] = 0x2e;
        data2[11] = 0x2f;
        data2[12] = 0x30;
        data2[13] = 0x31;
        data2[14] = 0x32;
        data2[15] = 0x33;
        data2[16] = 0x34;
        data2[17] = 0x35;
        data2[18] = 0x36;
        data2[19] = 0x37;
        data2[20] = 0x38;
        data2[21] = 0x39;
        data2[22] = 0x3a;
        data2[23] = 0x3b;
        data2[24] = 0x3c;
        data2[25] = 0x3d;
        data2[26] = 0x3e;
        data2[27] = 0x3f;
        data2[28] = 0x40;
        data2[29] = 0x41;
        data2[30] = 0x42;
        data2[31] = 0x43;
        data2[32] = 0x44;
        data2[33] = 0x45;
        data2[34] = 0x46;
        data2[35] = 0x47;
        data2[36] = 0x48;
        data2[37] = 0x49;
        data2[38] = 0x4a;
        data2[39] = 0x4b;
        data2[40] = 0x4c;
        //@formatter:on

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data1), CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data2)});
        assertArrayEquals(Arrays.copyOfRange(data2, 0, 3), result1.getFlags());
        assertEquals(0x2827, result1.getInstantaneousSpeed());
        assertEquals(0x2a29, result1.getAverageSpeed());
        assertEquals(0x2d2c2b, result1.getTotalDistance());
        assertEquals(0x2f2e, result1.getStepPerMinute());
        assertEquals(0x3130, result1.getAverageStepRate());
        assertEquals(0x3332, result1.getStrideCount());
        assertEquals(0x3534, result1.getPositiveElevationGain());
        assertEquals(0x3736, result1.getNegativeElevationGain());
        assertEquals(0x3938, result1.getInclination());
        assertEquals(0x3b3a, result1.getRampAngleSetting());
        assertEquals(0x3d3c, result1.getResistanceLevel());
        assertEquals(0x3f3e, result1.getInstantaneousPower());
        assertEquals(0x4140, result1.getAveragePower());
        assertEquals(0x4342, result1.getTotalEnergy());
        assertEquals(0x4544, result1.getEnergyPerHour());
        assertEquals(0x46, result1.getEnergyPerMinute());
        assertEquals(0x47, result1.getHeartRate());
        assertEquals(0x48, result1.getMetabolicEquivalent());
        assertEquals(0x4a49, result1.getElapsedTime());
        assertEquals(0x4c4b, result1.getRemainingTime());
    }

    @Test
    public void test_constructor_00003() {
        byte[] flags = new byte[] { 1 };
        int instantaneousSpeed = 2;
        int averageSpeed = 3;
        int totalDistance = 4;
        int stepPerMinute = 5;
        int averageStepRate = 6;
        int strideCount = 7;
        int positiveElevationGain = 8;
        int negativeElevationGain = 9;
        int inclination = 10;
        int rampAngleSetting = 11;
        int resistanceLevel = 12;
        int instantaneousPower = 13;
        int averagePower = 14;
        int totalEnergy = 15;
        int energyPerHour = 16;
        int energyPerMinute = 17;
        int heartRate = 18;
        int metabolicEquivalent = 19;
        int elapsedTime = 20;
        int remainingTime = 21;

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(flags, instantaneousSpeed, averageSpeed, totalDistance, stepPerMinute, averageStepRate, strideCount, positiveElevationGain, negativeElevationGain, inclination, rampAngleSetting, resistanceLevel, instantaneousPower, averagePower, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
        assertArrayEquals(flags, result1.getFlags());
        assertEquals(instantaneousSpeed, result1.getInstantaneousSpeed());
        assertEquals(averageSpeed, result1.getAverageSpeed());
        assertEquals(totalDistance, result1.getTotalDistance());
        assertEquals(stepPerMinute, result1.getStepPerMinute());
        assertEquals(averageStepRate, result1.getAverageStepRate());
        assertEquals(strideCount, result1.getStrideCount());
        assertEquals(positiveElevationGain, result1.getPositiveElevationGain());
        assertEquals(negativeElevationGain, result1.getNegativeElevationGain());
        assertEquals(inclination, result1.getInclination());
        assertEquals(rampAngleSetting, result1.getRampAngleSetting());
        assertEquals(resistanceLevel, result1.getResistanceLevel());
        assertEquals(instantaneousPower, result1.getInstantaneousPower());
        assertEquals(averagePower, result1.getAveragePower());
        assertEquals(totalEnergy, result1.getTotalEnergy());
        assertEquals(energyPerHour, result1.getEnergyPerHour());
        assertEquals(energyPerMinute, result1.getEnergyPerMinute());
        assertEquals(heartRate, result1.getHeartRate());
        assertEquals(metabolicEquivalent, result1.getMetabolicEquivalent());
        assertEquals(elapsedTime, result1.getElapsedTime());
        assertEquals(remainingTime, result1.getRemainingTime());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getStepPerMinute(), result2.getStepPerMinute());
        assertEquals(result1.getAverageStepRate(), result2.getAverageStepRate());
        assertEquals(result1.getStrideCount(), result2.getStrideCount());
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

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01302() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01401() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01402() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01501() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01502() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01302() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01401() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01402() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01501() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01502() {
        byte[] data = getData();

        CrossTrainerDataAndroid result1 = new CrossTrainerDataAndroid(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        CrossTrainerDataAndroid result2 = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
