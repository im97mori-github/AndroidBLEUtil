package org.im97mori.ble.characteristic.u2ad1;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.RowerDataUtils;
import org.im97mori.ble.test.TestBase;
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
public class RowerDataAndroidTest extends TestBase {

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
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data_00802 = data;
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

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[30];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE;
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
        //@formatter:on

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertEquals(0x01, result1.getStrokeRate());
        assertEquals(0x0302, result1.getStrokeCount());
        assertEquals(0x04, result1.getAverageStrokeRate());
        assertEquals(0x070605, result1.getTotalDistance());
        assertEquals(0x0908, result1.getInstantaneousPace());
        assertEquals(0x0b0a, result1.getAveragePace());
        assertEquals(0x0d0c, result1.getInstantaneousPower());
        assertEquals(0x0f0e, result1.getAveragePower());
        assertEquals(0x1110, result1.getResistanceLevel());
        assertEquals(0x1312, result1.getTotalEnergy());
        assertEquals(0x1514, result1.getEnergyPerHour());
        assertEquals(0x16, result1.getEnergyPerMinute());
        assertEquals(0x17, result1.getHeartRate());
        assertEquals(0x18, result1.getMetabolicEquivalent());
        assertEquals(0x1a19, result1.getElapsedTime());
        assertEquals(0x1c1b, result1.getRemainingTime());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data1 = new byte[30];
        int flags = RowerDataUtils.FLAGS_MORE_DATA_FALSE
                | RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                | RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                | RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE
                | RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                | RowerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE;
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

        byte[] data2 = new byte[30];
        data2[ 0] = (byte) flags;
        data2[ 1] = (byte) (flags >> 8);
        data2[ 2] = 0x1d;
        data2[ 3] = 0x1e;
        data2[ 4] = 0x1f;
        data2[ 5] = 0x20;
        data2[ 6] = 0x21;
        data2[ 7] = 0x22;
        data2[ 8] = 0x23;
        data2[ 9] = 0x24;
        data2[10] = 0x25;
        data2[11] = 0x26;
        data2[12] = 0x27;
        data2[13] = 0x28;
        data2[14] = 0x29;
        data2[15] = 0x2a;
        data2[16] = 0x2b;
        data2[17] = 0x2c;
        data2[18] = 0x2d;
        data2[19] = 0x2e;
        data2[20] = 0x2f;
        data2[21] = 0x30;
        data2[22] = 0x31;
        data2[23] = 0x32;
        data2[24] = 0x33;
        data2[25] = 0x34;
        data2[26] = 0x35;
        data2[27] = 0x36;
        data2[28] = 0x37;
        data2[29] = 0x38;
        //@formatter:on

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data1), RowerDataPacketAndroid.CREATOR.createFromByteArray(data2));
        assertArrayEquals(Arrays.copyOfRange(data2, 0, 2), result1.getFlags());
        assertEquals(0x1d, result1.getStrokeRate());
        assertEquals(0x1f1e, result1.getStrokeCount());
        assertEquals(0x20, result1.getAverageStrokeRate());
        assertEquals(0x232221, result1.getTotalDistance());
        assertEquals(0x2524, result1.getInstantaneousPace());
        assertEquals(0x2726, result1.getAveragePace());
        assertEquals(0x2928, result1.getInstantaneousPower());
        assertEquals(0x2b2a, result1.getAveragePower());
        assertEquals(0x2d2c, result1.getResistanceLevel());
        assertEquals(0x2f2e, result1.getTotalEnergy());
        assertEquals(0x3130, result1.getEnergyPerHour());
        assertEquals(0x32, result1.getEnergyPerMinute());
        assertEquals(0x33, result1.getHeartRate());
        assertEquals(0x34, result1.getMetabolicEquivalent());
        assertEquals(0x3635, result1.getElapsedTime());
        assertEquals(0x3837, result1.getRemainingTime());
    }

    @Test
    public void test_constructor_00003() {
        byte[] flags = new byte[] { 1 };
        int strokeRate = 2;
        int strokeCount = 3;
        int averageStrokeRate = 4;
        int totalDistance = 5;
        int instantaneousPace = 6;
        int averagePace = 7;
        int instantaneousPower = 8;
        int averagePower = 9;
        int resistanceLevel = 10;
        int totalEnergy = 11;
        int energyPerHour = 12;
        int energyPerMinute = 13;
        int heartRate = 14;
        int metabolicEquivalent = 15;
        int elapsedTime = 16;
        int remainingTime = 17;

        RowerDataAndroid result1 = new RowerDataAndroid(flags, strokeRate, strokeCount, averageStrokeRate, totalDistance, instantaneousPace, averagePace, instantaneousPower, averagePower, resistanceLevel, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
        assertArrayEquals(flags, result1.getFlags());
        assertEquals(strokeRate, result1.getStrokeRate());
        assertEquals(strokeCount, result1.getStrokeCount());
        assertEquals(averageStrokeRate, result1.getAverageStrokeRate());
        assertEquals(totalDistance, result1.getTotalDistance());
        assertEquals(instantaneousPace, result1.getInstantaneousPace());
        assertEquals(averagePace, result1.getAveragePace());
        assertEquals(instantaneousPower, result1.getInstantaneousPower());
        assertEquals(averagePower, result1.getAveragePower());
        assertEquals(resistanceLevel, result1.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getStrokeRate(), result2.getStrokeRate());
        assertEquals(result1.getStrokeCount(), result2.getStrokeCount());
        assertEquals(result1.getAverageStrokeRate(), result2.getAverageStrokeRate());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getInstantaneousPace(), result2.getInstantaneousPace());
        assertEquals(result1.getAveragePace(), result2.getAveragePace());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getAveragePower(), result2.getAveragePower());
        assertEquals(result1.getResistanceLevel(), result2.getResistanceLevel());
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

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        RowerDataAndroid result1 = new RowerDataAndroid(RowerDataPacketAndroid.CREATOR.createFromByteArray(data));
        RowerDataAndroid result2 = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
