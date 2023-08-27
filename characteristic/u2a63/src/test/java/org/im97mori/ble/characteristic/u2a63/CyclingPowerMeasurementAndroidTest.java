package org.im97mori.ble.characteristic.u2a63;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CyclingPowerMeasurementAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[5];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_LEFT
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[6];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_LEFT
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_CRANK_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[10];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
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
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[8];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[8];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[8];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data_00702 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[7];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x43;
        data[ 5] = 0x65;
        data[ 6] = (byte) 0x87;
        data_00802 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00901 = data;
    }

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[6];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data_00902 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01001 = data;
    }

    private static final byte[] data_01002;
    static {
        byte[] data = new byte[6];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
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
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01101 = data;
    }

    private static final byte[] data_01102;
    static {
        byte[] data = new byte[6];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
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
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01201 = data;
    }

    private static final byte[] data_01202;
    static {
        byte[] data = new byte[4];
        int flags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
                | CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01202 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsPedalPowerBalanceNotPresent());
        assertFalse(result1.isFlagsPedalPowerBalancePresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsPedalPowerBalanceNotPresent());
        assertTrue(result1.isFlagsPedalPowerBalancePresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x03, result1.getPedalPowerBalance());
        assertEquals(CyclingPowerMeasurement.PEDAL_POWER_BALANCE_RESOLUTION * 0x03, result1.getPedalPowerBalancePercentage(), 0);
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsPedalPowerBalanceReferenceUnknown());
        assertFalse(result1.isFlagsPedalPowerBalanceReferenceLeft());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsPedalPowerBalanceReferenceUnknown());
        assertTrue(result1.isFlagsPedalPowerBalanceReferenceLeft());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsAccumulatedTorqueNotPresent());
        assertFalse(result1.isFlagsAccumulatedTorquePresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsAccumulatedTorqueNotPresent());
        assertTrue(result1.isFlagsAccumulatedTorquePresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x0403, result1.getAccumulatedTorque());
        assertEquals(CyclingPowerMeasurement.ACCUMULATED_TORQUE_RESOLUTION * 0x0403, result1.getAccumulatedTorqueNewtonMetres(), 0);
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsAccumulatedTorqueSourceWheelBased());
        assertFalse(result1.isFlagsAccumulatedTorqueSourceCrankBased());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsAccumulatedTorqueSourceWheelBased());
        assertTrue(result1.isFlagsAccumulatedTorqueSourceCrankBased());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsWheelRevolutionDataNotPresent());
        assertFalse(result1.isFlagsWheelRevolutionDataPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsWheelRevolutionDataNotPresent());
        assertTrue(result1.isFlagsWheelRevolutionDataPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x06050403L, result1.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(0x0807, result1.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(CyclingPowerMeasurement.WHEEL_REVOLUTION_DATA_LAST_WHEEL_EVENT_TIME_RESOLUTION * 0x0807, result1.getWheelRevolutionDataLastWheelEventTimeSeconds(), 0);
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsCrankRevolutionDataNotPresent());
        assertFalse(result1.isFlagsCrankRevolutionDataPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsCrankRevolutionDataNotPresent());
        assertTrue(result1.isFlagsCrankRevolutionDataPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x0403, result1.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(0x0605, result1.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(CyclingPowerMeasurement.CRANK_REVOLUTION_DATA_LAST_CRANK_EVENT_TIME_RESOLUTION * 0x0605, result1.getCrankRevolutionDataLastCrankEventTimeSeconds(), 0);
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsExtremeForceMagnitudesNotPresent());
        assertFalse(result1.isFlagsExtremeForceMagnitudesPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00602() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsExtremeForceMagnitudesNotPresent());
        assertTrue(result1.isFlagsExtremeForceMagnitudesPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x0403, result1.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(0x0605, result1.getExtremeForceMagnitudesMinimumForceMagnitude());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsExtremeTorqueMagnitudesNotPresent());
        assertFalse(result1.isFlagsExtremeTorqueMagnitudesPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00702() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsExtremeTorqueMagnitudesNotPresent());
        assertTrue(result1.isFlagsExtremeTorqueMagnitudesPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x0403, result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(CyclingPowerMeasurement.EXTREME_TOURQUE_MAGNITUDES_MAXIMUM_TORQUE_MAGNITUDE * 0x0403, result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitudeNewtonMetres(), 0);
        assertEquals(0x0605, result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(CyclingPowerMeasurement.EXTREME_TOURQUE_MAGNITUDES_MINIMUM_TORQUE_MAGNITUDE * 0x0605, result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitudeNewtonMetres(), 0);
    }

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsExtremeAnglesNotPresent());
        assertFalse(result1.isFlagsExtremeAnglesPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00802() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsExtremeAnglesNotPresent());
        assertTrue(result1.isFlagsExtremeAnglesPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x543, result1.getExtremeAnglesMaximumAngle());
        assertEquals(0x876, result1.getExtremeAnglesMinimumAngle());
    }

    @Test
    public void test_constructor_00901() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsTopDeadSpotAngleNotPresent());
        assertFalse(result1.isFlagsTopDeadSpotAnglePresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_00902() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTopDeadSpotAngleNotPresent());
        assertTrue(result1.isFlagsTopDeadSpotAnglePresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x0403, result1.getTopDeadSpotAngle());
    }

    @Test
    public void test_constructor_01001() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsBottomDeadSpotAngleNotPresent());
        assertFalse(result1.isFlagsBottomDeadSpotAnglePresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_01002() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsBottomDeadSpotAngleNotPresent());
        assertTrue(result1.isFlagsBottomDeadSpotAnglePresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x0403, result1.getBottomDeadSpotAngle());
    }

    @Test
    public void test_constructor_01101() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsAccumulatedEnergyNotPresent());
        assertFalse(result1.isFlagsAccumulatedEnergyPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_01102() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsAccumulatedEnergyNotPresent());
        assertTrue(result1.isFlagsAccumulatedEnergyPresent());
        assertEquals(0x0201, result1.getInstantaneousPower());
        assertEquals(0x0403, result1.getAccumulatedEnergy());
        assertEquals(CyclingPowerMeasurement.ACCUMATED_ENERGY_RESOLUTION * 0x0403, result1.getAccumulatedEnergyKiloJoules(), 0);
    }

    @Test
    public void test_constructor_01201() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsOffsetCompensationNotIndicator());
        assertFalse(result1.isFlagsOffsetCompensationIndicator());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_01202() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsOffsetCompensationNotIndicator());
        assertTrue(result1.isFlagsOffsetCompensationIndicator());
        assertEquals(0x0201, result1.getInstantaneousPower());
    }

    @Test
    public void test_constructor_01203() {
        byte[] flags = new byte[]{1};
        int instantaneousPower = 2;
        int pedalPowerBalance = 3;
        int accumulatedTorque = 4;
        long wheelRevolutionDataCumulativeWheelRevolutions = 5;
        int wheelRevolutionDataLastWheelEventTime = 6;
        int crankRevolutionDataCumulativeCrankRevolutions = 7;
        int crankRevolutionDataLastCrankEventTime = 8;
        int extremeForceMagnitudesMaximumForceMagnitude = 9;
        int extremeForceMagnitudesMinimumForceMagnitude = 10;
        int extremeTorqueMagnitudesMaximumTorqueMagnitude = 11;
        int extremeTorqueMagnitudesMinimumTorqueMagnitude = 12;
        int extremeAnglesMaximumAngle = 13;
        int extremeAnglesMinimumAngle = 14;
        int topDeadSpotAngle = 15;
        int bottomDeadSpotAngle = 16;
        int accumulatedEnergy = 17;

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(flags, instantaneousPower, pedalPowerBalance, accumulatedTorque, wheelRevolutionDataCumulativeWheelRevolutions, wheelRevolutionDataLastWheelEventTime, crankRevolutionDataCumulativeCrankRevolutions, crankRevolutionDataLastCrankEventTime, extremeForceMagnitudesMaximumForceMagnitude, extremeForceMagnitudesMinimumForceMagnitude, extremeTorqueMagnitudesMaximumTorqueMagnitude, extremeTorqueMagnitudesMinimumTorqueMagnitude, extremeAnglesMaximumAngle, extremeAnglesMinimumAngle, topDeadSpotAngle, bottomDeadSpotAngle, accumulatedEnergy);
        assertArrayEquals(flags, result1.getFlags());
        assertEquals(instantaneousPower, result1.getInstantaneousPower());
        assertEquals(pedalPowerBalance, result1.getPedalPowerBalance());
        assertEquals(accumulatedTorque, result1.getAccumulatedTorque());
        assertEquals(wheelRevolutionDataCumulativeWheelRevolutions, result1.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(wheelRevolutionDataLastWheelEventTime, result1.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(crankRevolutionDataCumulativeCrankRevolutions, result1.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(crankRevolutionDataLastCrankEventTime, result1.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(extremeForceMagnitudesMaximumForceMagnitude, result1.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(extremeForceMagnitudesMinimumForceMagnitude, result1.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(extremeTorqueMagnitudesMaximumTorqueMagnitude, result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(extremeTorqueMagnitudesMinimumTorqueMagnitude, result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(extremeAnglesMaximumAngle, result1.getExtremeAnglesMaximumAngle());
        assertEquals(extremeAnglesMinimumAngle, result1.getExtremeAnglesMinimumAngle());
        assertEquals(topDeadSpotAngle, result1.getTopDeadSpotAngle());
        assertEquals(bottomDeadSpotAngle, result1.getBottomDeadSpotAngle());
        assertEquals(accumulatedEnergy, result1.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_00902() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_01002() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_01102() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_1_01202() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousPower(), result2.getInstantaneousPower());
        assertEquals(result1.getPedalPowerBalance(), result2.getPedalPowerBalance());
        assertEquals(result1.getAccumulatedTorque(), result2.getAccumulatedTorque());
        assertEquals(result1.getWheelRevolutionDataCumulativeWheelRevolutions(), result2.getWheelRevolutionDataCumulativeWheelRevolutions());
        assertEquals(result1.getWheelRevolutionDataLastWheelEventTime(), result2.getWheelRevolutionDataLastWheelEventTime());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getExtremeForceMagnitudesMaximumForceMagnitude(), result2.getExtremeForceMagnitudesMaximumForceMagnitude());
        assertEquals(result1.getExtremeForceMagnitudesMinimumForceMagnitude(), result2.getExtremeForceMagnitudesMinimumForceMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMaximumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMaximumTorqueMagnitude());
        assertEquals(result1.getExtremeTorqueMagnitudesMinimumTorqueMagnitude(), result2.getExtremeTorqueMagnitudesMinimumTorqueMagnitude());
        assertEquals(result1.getExtremeAnglesMaximumAngle(), result2.getExtremeAnglesMaximumAngle());
        assertEquals(result1.getExtremeAnglesMinimumAngle(), result2.getExtremeAnglesMinimumAngle());
        assertEquals(result1.getTopDeadSpotAngle(), result2.getTopDeadSpotAngle());
        assertEquals(result1.getBottomDeadSpotAngle(), result2.getBottomDeadSpotAngle());
        assertEquals(result1.getAccumulatedEnergy(), result2.getAccumulatedEnergy());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        CyclingPowerMeasurementAndroid result1 = new CyclingPowerMeasurementAndroid(data);
        CyclingPowerMeasurementAndroid result2 = CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
