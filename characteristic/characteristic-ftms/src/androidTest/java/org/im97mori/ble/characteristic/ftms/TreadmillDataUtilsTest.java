package org.im97mori.ble.characteristic.ftms;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class TreadmillDataUtilsTest {

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
    public void test_00001() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsMoreDataFalse(data));
        assertFalse(TreadmillDataUtils.isFlagsMoreDataTrue(data));
        assertEquals(TreadmillDataUtils.INSTANTANEOUS_SPEED_RESOLUTION * BLEUtils.createUInt16(data, 2)
                , TreadmillDataUtils.getInstantaneousSpeedKilometerPerHour(BLEUtils.createUInt16(data, 2)), 0);
    }

    @Test
    public void test_00002() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsMoreDataFalse(data));
        assertTrue(TreadmillDataUtils.isFlagsMoreDataTrue(data));
    }

    @Test
    public void test_00101() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsAverageSpeedNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsAverageSpeedPresent(data));
    }

    @Test
    public void test_00102() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsAverageSpeedNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsAverageSpeedPresent(data));
        assertEquals(TreadmillDataUtils.AVERAGE_SPEED_RESOLUTION * BLEUtils.createUInt16(data, 4)
                , TreadmillDataUtils.getAverageSpeedKilometerPerHour(BLEUtils.createUInt16(data, 4)), 0);
    }

    @Test
    public void test_00201() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsTotalDistanceNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsTotalDistancePresent(data));
    }

    @Test
    public void test_00202() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsTotalDistanceNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsTotalDistancePresent(data));
    }

    @Test
    public void test_00301() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingPresent(data));
    }

    @Test
    public void test_00302() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingPresent(data));
        assertFalse(TreadmillDataUtils.isInclinationDataNotAvailable(BLEUtils.createSInt16(data, 4)));
        assertEquals(TreadmillDataUtils.INCLINATION_RESOLUTION * BLEUtils.createSInt16(data, 4)
                , TreadmillDataUtils.getInclinationPercent(BLEUtils.createUInt16(data, 4)), 0);
        assertFalse(TreadmillDataUtils.isRampAngleSettingDataNotAvailable(BLEUtils.createSInt16(data, 6)));
        assertEquals(TreadmillDataUtils.RAMP_ANGLE_SETTING_RESOLUTION * BLEUtils.createSInt16(data, 6)
                , TreadmillDataUtils.getRampAngleSettingDegree(BLEUtils.createSInt16(data, 6)), 0);
    }

    @Test
    public void test_00303() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingPresent(data));
        assertTrue(TreadmillDataUtils.isInclinationDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertTrue(TreadmillDataUtils.isRampAngleSettingDataNotAvailable(BLEUtils.createUInt16(data, 6)));
    }

    @Test
    public void test_00401() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsElevationGainNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsElevationGainPresent(data));
    }

    @Test
    public void test_00402() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsElevationGainNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsElevationGainPresent(data));
        assertEquals(TreadmillDataUtils.POSITIVE_ELEVATION_GAIN_RESOLUTION * BLEUtils.createUInt16(data, 4)
                , TreadmillDataUtils.getPositiveElevationGainMeters(BLEUtils.createUInt16(data, 4)), 0);
        assertEquals(TreadmillDataUtils.NEGATIVE_ELEVATION_GAIN_RESOLUTION * BLEUtils.createUInt16(data, 4)
                , TreadmillDataUtils.getNegativeElevationGainMeters(BLEUtils.createUInt16(data, 4)), 0);
    }

    @Test
    public void test_00501() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsInstantaneousPaceNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsInstantaneousPacePresent(data));
    }

    @Test
    public void test_00502() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsInstantaneousPaceNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsInstantaneousPacePresent(data));
        assertEquals(TreadmillDataUtils.INSTANTANEOUS_PACE_RESOLUTION * BLEUtils.createUInt8(data, 4)
                , TreadmillDataUtils.getInstantaneousPaceKilometerPerMinute(BLEUtils.createUInt8(data, 4)), 0);
    }

    @Test
    public void test_00601() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsAveragePaceNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsAveragePacePresent(data));
    }

    @Test
    public void test_00602() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsAveragePaceNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsAveragePacePresent(data));
        assertEquals(TreadmillDataUtils.AVERAGE_PACE_RESOLUTION * BLEUtils.createUInt8(data, 4)
                , TreadmillDataUtils.getAveragePaceKilometerPerMinute(BLEUtils.createUInt8(data, 4)), 0);
    }

    @Test
    public void test_00701() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsExpendedEnergyPresent(data));
    }

    @Test
    public void test_00702() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsExpendedEnergyPresent(data));
        assertFalse(TreadmillDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertFalse(TreadmillDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 6)));
        assertFalse(TreadmillDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 8)));
    }

    @Test
    public void test_00703() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsExpendedEnergyPresent(data));
        assertTrue(TreadmillDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertTrue(TreadmillDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 6)));
        assertTrue(TreadmillDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 8)));
    }

    @Test
    public void test_00801() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsHeartRateNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_00802() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsHeartRateNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_00901() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsMetabolicEquivalentPresent(data));
    }

    @Test
    public void test_00902() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsMetabolicEquivalentPresent(data));
    }

    @Test
    public void test_01001() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_01002() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_01101() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsRemainingTimePresent(data));
    }

    @Test
    public void test_01102() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsRemainingTimePresent(data));
    }


    @Test
    public void test_01201() {
        byte[] data = getData();

        assertTrue(TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputNotPresent(data));
        assertFalse(TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputPresent(data));
    }

    @Test
    public void test_01202() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputPresent(data));
        assertFalse(TreadmillDataUtils.isForceOnBeltDataNotAvailable(BLEUtils.createSInt16(data, 4)));
        assertFalse(TreadmillDataUtils.isPowerOutputDataNotAvailable(BLEUtils.createSInt16(data, 6)));
    }

    @Test
    public void test_01203() {
        byte[] data = getData();

        assertFalse(TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputNotPresent(data));
        assertTrue(TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputPresent(data));
        assertTrue(TreadmillDataUtils.isForceOnBeltDataNotAvailable(BLEUtils.createSInt16(data, 4)));
        assertTrue(TreadmillDataUtils.isPowerOutputDataNotAvailable(BLEUtils.createSInt16(data, 6)));
    }

}
