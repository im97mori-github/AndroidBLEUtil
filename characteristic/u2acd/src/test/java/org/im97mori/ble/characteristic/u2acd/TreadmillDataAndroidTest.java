package org.im97mori.ble.characteristic.u2acd;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.TreadmillDataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TreadmillDataAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_TRUE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[6];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[7];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[8];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data_00302 = data;
    }

    private static final byte[] data_00303;
    static {
        byte[] data = new byte[8];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) TreadmillDataUtils.INCLINATION_DATA_NOT_AVAILABLE;
        data[ 5] = (byte) (TreadmillDataUtils.INCLINATION_DATA_NOT_AVAILABLE >> 8);
        data[ 6] = (byte) TreadmillDataUtils.RAMP_ANGLE_SETTING_DATA_NOT_AVAILABLE;
        data[ 7] = (byte) (TreadmillDataUtils.RAMP_ANGLE_SETTING_DATA_NOT_AVAILABLE >> 8);
        data_00303 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[8];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[5];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[5];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[9];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data_00702 = data;
    }

    private static final byte[] data_00703;
    static {
        byte[] data = new byte[9];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) TreadmillDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE;
        data[ 5] = (byte) (TreadmillDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE >> 8);
        data[ 6] = (byte) TreadmillDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE;
        data[ 7] = (byte) (TreadmillDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE >> 8);
        data[ 8] = (byte) TreadmillDataUtils.ENERGY_PER_MINUTE_DATA_NOT_AVAILABLE;
        data_00703 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[5];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data_00802 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00901 = data;
    }

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[5];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data_00902 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01001 = data;
    }

    private static final byte[] data_01002;
    static {
        byte[] data = new byte[6];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data_01002 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01101 = data;
    }

    private static final byte[] data_01102;
    static {
        byte[] data = new byte[6];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data_01102 = data;
    }

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[4];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01201 = data;
    }

    private static final byte[] data_01202;
    static {
        byte[] data = new byte[8];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data_01202 = data;
    }

    private static final byte[] data_01203;
    static {
        byte[] data = new byte[8];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) TreadmillDataUtils.FORCE_ON_BELT_DATA_NOT_AVAILABLE;
        data[ 5] = (byte) (TreadmillDataUtils.FORCE_ON_BELT_DATA_NOT_AVAILABLE >> 8);
        data[ 6] = (byte) TreadmillDataUtils.POWER_OUTPUT_DATA_NOT_AVAILABLE;
        data[ 7] = (byte) (TreadmillDataUtils.POWER_OUTPUT_DATA_NOT_AVAILABLE >> 8);
        data_01203 = data;
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
        byte[] data = new byte[34];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        data[30] = 0x1d;
        data[31] = 0x1e;
        data[32] = 0x1f;
        data[33] = 0x20;
        //@formatter:on

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(0x0403, result1.getAverageSpeed());
        assertEquals(0x070605, result1.getTotalDistance());
        assertEquals(0x0908, result1.getInclination());
        assertEquals(0x0b0a, result1.getRampAngleSetting());
        assertEquals(0x0d0c, result1.getPositiveElevationGain());
        assertEquals(0x0f0e, result1.getNegativeElevationGain());
        assertEquals(0x10, result1.getInstantaneousPace());
        assertEquals(0x11, result1.getAveragePace());
        assertEquals(0x1312, result1.getTotalEnergy());
        assertEquals(0x1514, result1.getEnergyPerHour());
        assertEquals(0x16, result1.getEnergyPerMinute());
        assertEquals(0x17, result1.getHeartRate());
        assertEquals(0x18, result1.getMetabolicEquivalent());
        assertEquals(0x1a19, result1.getElapsedTime());
        assertEquals(0x1c1b, result1.getRemainingTime());
        assertEquals(0x1e1d, result1.getForceOnBelt());
        assertEquals(0x201f, result1.getPowerOutput());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data1 = new byte[34];
        int flags = TreadmillDataUtils.FLAGS_MORE_DATA_FALSE
                | TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                | TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE;
        data1[ 0] = (byte) flags;
        data1[ 1] = (byte) (flags >> 8);
        data1[ 2] = 0x01;
        data1[ 3] = 0x02;
        data1[ 4] = 0x03;
        data1[ 5] = 0x04;
        data1[ 6] = 0x05;
        data1[ 7] = 0x06;
        data1[ 8] = 0x07;
        data1[ 9] = 0x08;
        data1[10] = 0x09;
        data1[11] = 0x0a;
        data1[12] = 0x0b;
        data1[13] = 0x0c;
        data1[14] = 0x0d;
        data1[15] = 0x0e;
        data1[16] = 0x0f;
        data1[17] = 0x10;
        data1[18] = 0x11;
        data1[19] = 0x12;
        data1[20] = 0x13;
        data1[21] = 0x14;
        data1[22] = 0x15;
        data1[23] = 0x16;
        data1[24] = 0x17;
        data1[25] = 0x18;
        data1[26] = 0x19;
        data1[27] = 0x1a;
        data1[28] = 0x1b;
        data1[29] = 0x1c;
        data1[30] = 0x1d;
        data1[31] = 0x1e;
        data1[32] = 0x1f;
        data1[33] = 0x20;

        byte[] data2 = new byte[34];
        data2[ 0] = (byte) flags;
        data2[ 1] = (byte) (flags >> 8);
        data2[ 2] = 0x21;
        data2[ 3] = 0x22;
        data2[ 4] = 0x23;
        data2[ 5] = 0x24;
        data2[ 6] = 0x25;
        data2[ 7] = 0x26;
        data2[ 8] = 0x27;
        data2[ 9] = 0x28;
        data2[10] = 0x29;
        data2[11] = 0x2a;
        data2[12] = 0x2b;
        data2[13] = 0x2c;
        data2[14] = 0x2d;
        data2[15] = 0x2e;
        data2[16] = 0x2f;
        data2[17] = 0x30;
        data2[18] = 0x31;
        data2[19] = 0x32;
        data2[20] = 0x33;
        data2[21] = 0x34;
        data2[22] = 0x35;
        data2[23] = 0x36;
        data2[24] = 0x37;
        data2[25] = 0x38;
        data2[26] = 0x39;
        data2[27] = 0x3a;
        data2[28] = 0x3b;
        data2[29] = 0x3c;
        data2[30] = 0x3d;
        data2[31] = 0x3e;
        data2[32] = 0x3f;
        data2[33] = 0x40;
        //@formatter:on

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data1), TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data2));
        assertArrayEquals(Arrays.copyOfRange(data2, 0, 2), result1.getFlags());
        assertEquals(0x2221, result1.getInstantaneousSpeed());
        assertEquals(0x2423, result1.getAverageSpeed());
        assertEquals(0x272625, result1.getTotalDistance());
        assertEquals(0x2928, result1.getInclination());
        assertEquals(0x2b2a, result1.getRampAngleSetting());
        assertEquals(0x2d2c, result1.getPositiveElevationGain());
        assertEquals(0x2f2e, result1.getNegativeElevationGain());
        assertEquals(0x30, result1.getInstantaneousPace());
        assertEquals(0x31, result1.getAveragePace());
        assertEquals(0x3332, result1.getTotalEnergy());
        assertEquals(0x3534, result1.getEnergyPerHour());
        assertEquals(0x36, result1.getEnergyPerMinute());
        assertEquals(0x37, result1.getHeartRate());
        assertEquals(0x38, result1.getMetabolicEquivalent());
        assertEquals(0x3a39, result1.getElapsedTime());
        assertEquals(0x3c3b, result1.getRemainingTime());
        assertEquals(0x3e3d, result1.getForceOnBelt());
        assertEquals(0x403f, result1.getPowerOutput());
    }

    @Test
    public void test_constructor_00003() {
        byte[] flags = new byte[] { 1 };
        int instantaneousSpeed = 2;
        int averageSpeed = 3;
        int totalDistance = 4;
        int inclination = 5;
        int rampAngleSetting = 6;
        int positiveElevationGain = 7;
        int negativeElevationGain = 8;
        int instantaneousPace = 9;
        int averagePace = 10;
        int totalEnergy = 11;
        int energyPerHour = 12;
        int energyPerMinute = 13;
        int heartRate = 14;
        int metabolicEquivalent = 15;
        int elapsedTime = 16;
        int remainingTime = 17;
        int forceOnBelt = 18;
        int powerOutput = 19;

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(flags, instantaneousSpeed, averageSpeed, totalDistance, inclination, rampAngleSetting, positiveElevationGain, negativeElevationGain, instantaneousPace, averagePace, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime, forceOnBelt, powerOutput);
        assertArrayEquals(flags, result1.getFlags());
        assertEquals(instantaneousSpeed, result1.getInstantaneousSpeed());
        assertEquals(averageSpeed, result1.getAverageSpeed());
        assertEquals(totalDistance, result1.getTotalDistance());
        assertEquals(inclination, result1.getInclination());
        assertEquals(rampAngleSetting, result1.getRampAngleSetting());
        assertEquals(positiveElevationGain, result1.getPositiveElevationGain());
        assertEquals(negativeElevationGain, result1.getNegativeElevationGain());
        assertEquals(instantaneousPace, result1.getInstantaneousPace());
        assertEquals(averagePace, result1.getAveragePace());
        assertEquals(totalEnergy, result1.getTotalEnergy());
        assertEquals(energyPerHour, result1.getEnergyPerHour());
        assertEquals(energyPerMinute, result1.getEnergyPerMinute());
        assertEquals(heartRate, result1.getHeartRate());
        assertEquals(metabolicEquivalent, result1.getMetabolicEquivalent());
        assertEquals(elapsedTime, result1.getElapsedTime());
        assertEquals(remainingTime, result1.getRemainingTime());
        assertEquals(forceOnBelt, result1.getForceOnBelt());
        assertEquals(powerOutput, result1.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_00902() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_01002() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_01102() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_1_01202() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getAverageSpeed(), result2.getAverageSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInclination(), result2.getInclination());
        assertEquals(result1.getRampAngleSetting(), result2.getRampAngleSetting());
        assertEquals(result1.getPositiveElevationGain(), result2.getPositiveElevationGain());
        assertEquals(result1.getNegativeElevationGain(), result2.getNegativeElevationGain());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getTotalEnergy(), result2.getTotalEnergy());
        assertEquals(result1.getEnergyPerHour(), result2.getEnergyPerHour());
        assertEquals(result1.getEnergyPerMinute(), result2.getEnergyPerMinute());
        assertEquals(result1.getHeartRate(), result2.getHeartRate());
        assertEquals(result1.getMetabolicEquivalent(), result2.getMetabolicEquivalent());
        assertEquals(result1.getElapsedTime(), result2.getElapsedTime());
        assertEquals(result1.getRemainingTime(), result2.getRemainingTime());
        assertEquals(result1.getForceOnBelt(), result2.getForceOnBelt());
        assertEquals(result1.getPowerOutput(), result2.getPowerOutput());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        TreadmillDataAndroid result1 = new TreadmillDataAndroid(TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data));
        TreadmillDataAndroid result2 = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
