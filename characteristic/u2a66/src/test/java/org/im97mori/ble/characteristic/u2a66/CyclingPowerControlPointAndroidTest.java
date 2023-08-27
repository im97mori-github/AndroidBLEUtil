package org.im97mori.ble.characteristic.u2a66;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.im97mori.ble.characteristic.core.SensorLocationUtils;
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
public class CyclingPowerControlPointAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[5];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data_00001 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION;
        data[ 1] = 0x01;
        data_00101 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION;
        data_00201 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00301 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH;
        data_00401 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00501 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH;
        data_00601 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00701 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT;
        data_00801 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00901 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH;
        data_01001 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION;
        data_01101 = data;
    }

    private static final byte[] data_01201;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01201 = data;
    }

    private static final byte[] data_01202;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_TURN_OFF
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01202 = data;
    }

    private static final byte[] data_01211;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01211 = data;
    }

    private static final byte[] data_01212;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_TURN_OFF
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01212 = data;
    }

    private static final byte[] data_01221;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01221 = data;
    }

    private static final byte[] data_01222;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_TURN_OFF
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01222 = data;
    }

    private static final byte[] data_01231;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01231 = data;
    }

    private static final byte[] data_01232;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_TURN_OFF
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01232 = data;
    }

    private static final byte[] data_01241;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01241 = data;
    }

    private static final byte[] data_01242;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_TURN_OFF
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01242 = data;
    }

    private static final byte[] data_01251;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01251 = data;
    }

    private static final byte[] data_01252;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_TURN_OFF
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01252 = data;
    }

    private static final byte[] data_01261;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01261 = data;
    }

    private static final byte[] data_01262;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_TURN_OFF
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01262 = data;
    }

    private static final byte[] data_01271;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01271 = data;
    }

    private static final byte[] data_01272;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_TURN_OFF
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01272 = data;
    }

    private static final byte[] data_01301;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01301 = data;
    }

    private static final byte[] data_01302;
    static {
        int mask = CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
                | CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_TURN_OFF;
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 1] = (byte) mask;
        data[ 2] = (byte) (mask >> 8);
        data_01302 = data;
    }

    private static final byte[] data_01401;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE;
        data_01401 = data;
    }

    private static final byte[] data_01501;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE;
        data_01501 = data;
    }

    private static final byte[] data_01601;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data_01601 = data;
    }

    private static final byte[] data_01701;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data_01701 = data;
    }

    private static final byte[] data_01702;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_01702 = data;
    }

    private static final byte[] data_01703;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_01703 = data;
    }

    private static final byte[] data_01704;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_01704 = data;
    }

    private static final byte[] data_01801;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data_01801 = data;
    }

    private static final byte[] data_01802;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_01802 = data;
    }

    private static final byte[] data_01803;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_01803 = data;
    }

    private static final byte[] data_01804;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_01804 = data;
    }

    private static final byte[] data_01901;
    static {
        byte[] data = new byte[4];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = SensorLocationUtils.SENSOR_LOCATION_OTHER;
        data_01901 = data;
    }

    private static final byte[] data_01902;
    static {
        byte[] data = new byte[20];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = SensorLocationUtils.SENSOR_LOCATION_OTHER;
        data[ 4] = SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE;
        data[ 5] = SensorLocationUtils.SENSOR_LOCATION_IN_SHOE;
        data[ 6] = SensorLocationUtils.SENSOR_LOCATION_HIP;
        data[ 7] = SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL;
        data[ 8] = SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK;
        data[ 9] = SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK;
        data[10] = SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL;
        data[11] = SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL;
        data[12] = SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB;
        data[13] = SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT;
        data[14] = SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY;
        data[15] = SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL;
        data[16] = SensorLocationUtils.SENSOR_LOCATION_REAR_HUB;
        data[17] = SensorLocationUtils.SENSOR_LOCATION_CHEST;
        data[18] = SensorLocationUtils.SENSOR_LOCATION_SPIDER;
        data[19] = SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING;
        data_01902 = data;
    }

    private static final byte[] data_01903;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_01903 = data;
    }

    private static final byte[] data_01904;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_01904 = data;
    }

    private static final byte[] data_01905;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_01905 = data;
    }

    private static final byte[] data_02001;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data_02001 = data;
    }

    private static final byte[] data_02002;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02002 = data;
    }

    private static final byte[] data_02003;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02003 = data;
    }

    private static final byte[] data_02004;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02004 = data;
    }

    private static final byte[] data_02101;
    static {
        byte[] data = new byte[5];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_02101 = data;
    }

    private static final byte[] data_02102;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02102 = data;
    }

    private static final byte[] data_02103;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02103 = data;
    }

    private static final byte[] data_02104;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02104 = data;
    }

    private static final byte[] data_02201;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data_02201 = data;
    }

    private static final byte[] data_02202;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02202 = data;
    }

    private static final byte[] data_02203;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02203 = data;
    }

    private static final byte[] data_02204;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02204 = data;
    }

    private static final byte[] data_02301;
    static {
        byte[] data = new byte[5];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_02301 = data;
    }

    private static final byte[] data_02302;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02302 = data;
    }

    private static final byte[] data_02303;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02303 = data;
    }

    private static final byte[] data_02304;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02304 = data;
    }

    private static final byte[] data_02401;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data_02401 = data;
    }

    private static final byte[] data_02402;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02402 = data;
    }

    private static final byte[] data_02403;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02403 = data;
    }

    private static final byte[] data_02404;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02404 = data;
    }

    private static final byte[] data_02501;
    static {
        byte[] data = new byte[5];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_02501 = data;
    }

    private static final byte[] data_02502;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02502 = data;
    }

    private static final byte[] data_02503;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02503 = data;
    }

    private static final byte[] data_02504;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02504 = data;
    }

    private static final byte[] data_02601;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data_02601 = data;
    }

    private static final byte[] data_02602;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02602 = data;
    }

    private static final byte[] data_02603;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02603 = data;
    }

    private static final byte[] data_02604;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02604 = data;
    }

    private static final byte[] data_02701;
    static {
        byte[] data = new byte[5];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_02701 = data;
    }

    private static final byte[] data_02702;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02702 = data;
    }

    private static final byte[] data_02703;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02703 = data;
    }

    private static final byte[] data_02704;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02704 = data;
    }

    private static final byte[] data_02801;
    static {
        byte[] data = new byte[5];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_02801 = data;
    }
    private static final byte[] data_02802;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02802 = data;
    }

    private static final byte[] data_02803;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02803 = data;
    }

    private static final byte[] data_02804;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02804 = data;
    }

    private static final byte[] data_02901;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data_02901 = data;
    }

    private static final byte[] data_02902;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_02902 = data;
    }

    private static final byte[] data_02903;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_02903 = data;
    }

    private static final byte[] data_02904;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_02904 = data;
    }

    private static final byte[] data_03001;
    static {
        byte[] data = new byte[4];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x01;
        data_03001 = data;
    }

    private static final byte[] data_03002;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_03002 = data;
    }

    private static final byte[] data_03003;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_03003 = data;
    }

    private static final byte[] data_03004;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_03004 = data;
    }

    private static final byte[] data_03101;
    static {
        byte[] data = new byte[10];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_DECEMBER;
        data[ 6] = 31;
        data[ 7] = 23;
        data[ 8] = 59;
        data[ 9] = 59;
        data_03101 = data;
    }

    private static final byte[] data_03102;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_03102 = data;
    }

    private static final byte[] data_03103;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_03103 = data;
    }

    private static final byte[] data_03104;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_03104 = data;
    }

    private static final byte[] data_03201;
    static {
        byte[] data = new byte[5];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_03201 = data;
    }

    private static final byte[] data_03202;
    static {
        byte[] data = new byte[6];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x08;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data_03202 = data;
    }

    private static final byte[] data_03203;
    static {
        byte[] data = new byte[7];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x08;
        data[ 4] = 0x00;
        data[ 5] = 0x01;
        data[ 6] = 0x02;
        data_03203 = data;
    }

    private static final byte[] data_03204;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_03204 = data;
    }

    private static final byte[] data_03205;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_03205 = data;
    }

    private static final byte[] data_03206;
    static {
        byte[] data = new byte[4];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data[ 3] = CyclingPowerControlPoint.PARAMETER_VALUE_START_ENHANCED_OFFET_COMPENSATION_INCORRECT_CALIBRATION_POSITION;
        data_03206 = data;
    }

    private static final byte[] data_03207;
    static {
        byte[] data = new byte[7];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data[ 3] = (byte) CyclingPowerControlPoint.PARAMETER_VALUE_START_ENHANCED_OFFET_COMPENSATION_MANUFACTURER_SPECIFIC_ERROR_FOLLOWS;
        data[ 4] = 0x08;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data_03207 = data;
    }

    private static final byte[] data_03208;
    static {
        byte[] data = new byte[8];
        data[ 0] = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
        data[ 1] = CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION;
        data[ 2] = CyclingPowerControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data[ 3] = (byte) CyclingPowerControlPoint.PARAMETER_VALUE_START_ENHANCED_OFFET_COMPENSATION_MANUFACTURER_SPECIFIC_ERROR_FOLLOWS;
        data[ 4] = 0x08;
        data[ 5] = 0x00;
        data[ 6] = 0x01;
        data[ 7] = 0x02;
        data_03208 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertTrue(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 5), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertTrue(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 2), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertTrue(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertTrue(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertTrue(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertTrue(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertTrue(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertTrue(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_00901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertTrue(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
    }

    @Test
    public void test_constructor_01001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertTrue(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_01101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertTrue(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_01201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentPedalPowerBalanceLeaveAsDefault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentPedalPowerBalanceTurnOff());
    }

    @Test
    public void test_constructor_01202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentPedalPowerBalanceLeaveAsDefault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentPedalPowerBalanceTurnOff());
    }

    @Test
    public void test_constructor_01211() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedTorqueLeaveAsDfault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedTorqueTurnOff());
    }

    @Test
    public void test_constructor_01212() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedTorqueLeaveAsDfault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedTorqueTurnOff());
    }

    @Test
    public void test_constructor_01221() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentWheelRevolutionDataLeaveAsDefault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentWheelRevolutionDataTurnOff());
    }

    @Test
    public void test_constructor_01222() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentWheelRevolutionDataLeaveAsDefault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentWheelRevolutionDataTurnOff());
    }

    @Test
    public void test_constructor_01231() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentCrankRevolutionDataLeaveAsDefault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentCrankRevolutionDataTurnOff());
    }

    @Test
    public void test_constructor_01232() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentCrankRevolutionDataLeaveAsDefault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentCrankRevolutionDataTurnOff());
    }

    @Test
    public void test_constructor_01241() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeMagnitudesLeaveAsDefault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeMagnitudesTurnOff());
    }

    @Test
    public void test_constructor_01242() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeMagnitudesLeaveAsDefault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeMagnitudesTurnOff());
    }

    @Test
    public void test_constructor_01251() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeAnglesLeaveAsDefault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeAnglesTurnOff());
    }

    @Test
    public void test_constructor_01252() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeAnglesLeaveAsDefault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeAnglesTurnOff());
    }

    @Test
    public void test_constructor_01261() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentTopDeadSpotAngleLeaveAsDefault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentTopDeadSpotAngleTurnOff());
    }

    @Test
    public void test_constructor_01262() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentTopDeadSpotAngleLeaveAsDefault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentTopDeadSpotAngleTurnOff());
    }

    @Test
    public void test_constructor_01271() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentBottomDeadSpotAngleLeaveAsDefault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentBottomDeadSpotAngleTurnOff());
    }

    @Test
    public void test_constructor_01272() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentBottomDeadSpotAngleLeaveAsDefault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentBottomDeadSpotAngleTurnOff());
    }

    @Test
    public void test_constructor_01301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedEnergyLeaveAsDefault());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedEnergyTurnOff());
    }

    @Test
    public void test_constructor_01302() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getParameterValue());
        assertFalse(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedEnergyLeaveAsDefault());
        assertTrue(result1.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedEnergyTurnOff());
    }

    @Test
    public void test_constructor_01401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertTrue(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_01501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertTrue(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_01601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getParameterValue());
    }

    @Test
    public void test_constructor_01701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertTrue(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01702() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertTrue(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01703() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertTrue(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01704() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertTrue(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01802() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01803() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01804() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 4), result1.getResponseParameter());
        assertEquals(1, result1.getResponseParameter().length);
        assertTrue(SensorLocationUtils.isSensorLocationOhter(result1.getResponseParameter()[0]));
    }

    @Test
    public void test_constructor_01902() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 20), result1.getResponseParameter());
        assertEquals(17, result1.getResponseParameter().length);
        assertTrue(SensorLocationUtils.isSensorLocationOhter(result1.getResponseParameter()[0]));
        assertTrue(SensorLocationUtils.isSensorLocationTopOfShoe(result1.getResponseParameter()[1]));
        assertTrue(SensorLocationUtils.isSensorLocationInShoe(result1.getResponseParameter()[2]));
        assertTrue(SensorLocationUtils.isSensorLocationHip(result1.getResponseParameter()[3]));
        assertTrue(SensorLocationUtils.isSensorLocationFrontWheel(result1.getResponseParameter()[4]));
        assertTrue(SensorLocationUtils.isSensorLocationLeftCrank(result1.getResponseParameter()[5]));
        assertTrue(SensorLocationUtils.isSensorLocationRightCrank(result1.getResponseParameter()[6]));
        assertTrue(SensorLocationUtils.isSensorLocationLeftPedal(result1.getResponseParameter()[7]));
        assertTrue(SensorLocationUtils.isSensorLocationRightPedal(result1.getResponseParameter()[8]));
        assertTrue(SensorLocationUtils.isSensorLocationFrontHub(result1.getResponseParameter()[9]));
        assertTrue(SensorLocationUtils.isSensorLocationRearDropout(result1.getResponseParameter()[10]));
        assertTrue(SensorLocationUtils.isSensorLocationChainstay(result1.getResponseParameter()[11]));
        assertTrue(SensorLocationUtils.isSensorLocationRearWheel(result1.getResponseParameter()[12]));
        assertTrue(SensorLocationUtils.isSensorLocationRearHub(result1.getResponseParameter()[13]));
        assertTrue(SensorLocationUtils.isSensorLocationChest(result1.getResponseParameter()[14]));
        assertTrue(SensorLocationUtils.isSensorLocationSpider(result1.getResponseParameter()[15]));
        assertTrue(SensorLocationUtils.isSensorLocationChainRing(result1.getResponseParameter()[16]));
    }

    @Test
    public void test_constructor_01903() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01904() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_01905() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02002() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02003() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02004() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 5), result1.getResponseParameter());
        assertEquals(0x0201, BLEUtils.createUInt16(result1.getResponseParameter(), 0));
    }

    @Test
    public void test_constructor_02102() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02103() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02104() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02203() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02204() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 5), result1.getResponseParameter());
        assertEquals(0x0201, BLEUtils.createUInt16(result1.getResponseParameter(), 0));
    }

    @Test
    public void test_constructor_02302() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02303() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02304() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02402() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02403() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02404() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 5), result1.getResponseParameter());
        assertEquals(0x0201, BLEUtils.createUInt16(result1.getResponseParameter(), 0));
    }

    @Test
    public void test_constructor_02502() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02503() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02504() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02602() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02603() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02604() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 5), result1.getResponseParameter());
        assertEquals(0x0201, BLEUtils.createUInt16(result1.getResponseParameter(), 0));
    }

    @Test
    public void test_constructor_02702() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02703() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02704() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 5), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02802() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02803() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02804() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02902() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02903() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_02904() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 4), result1.getResponseParameter());
        assertEquals(0x01, result1.getResponseParameter()[0]);
    }

    @Test
    public void test_constructor_03002() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03003() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03004() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 10), result1.getResponseParameter());
        assertEquals(9999, BLEUtils.createUInt16(result1.getResponseParameter(), 0));
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getResponseParameter()[2]);
        assertEquals(31, result1.getResponseParameter()[3]);
        assertEquals(23, result1.getResponseParameter()[4]);
        assertEquals(59, result1.getResponseParameter()[5]);
        assertEquals(59, result1.getResponseParameter()[6]);
    }

    @Test
    public void test_constructor_03102() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03103() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03104() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 5), result1.getResponseParameter());
        assertEquals(0x01, result1.getResponseParameter()[0]);
        assertEquals(0x02, result1.getResponseParameter()[1]);
        assertFalse(result1.hasManufacturerSpecificData());
    }

    @Test
    public void test_constructor_03202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 6), result1.getResponseParameter());
        assertEquals(0x08, result1.getResponseParameter()[0]);
        assertEquals(0x00, result1.getResponseParameter()[1]);
        assertEquals(0x00, result1.getResponseParameter()[2]);
        assertTrue(result1.hasManufacturerSpecificData());
        assertEquals(0x0008, result1.getCompanyId());
        assertEquals(0x00, result1.getManfacturerSpecificDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 6, 6), result1.getManfacturerSpecificData());
    }

    @Test
    public void test_constructor_03203() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 7), result1.getResponseParameter());
        assertEquals(0x08, result1.getResponseParameter()[0]);
        assertEquals(0x00, result1.getResponseParameter()[1]);
        assertEquals(0x01, result1.getResponseParameter()[2]);
        assertEquals(0x02, result1.getResponseParameter()[3]);
        assertTrue(result1.hasManufacturerSpecificData());
        assertEquals(0x0008, result1.getCompanyId());
        assertEquals(0x01, result1.getManfacturerSpecificDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 6, 7), result1.getManfacturerSpecificData());
    }

    @Test
    public void test_constructor_03204() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03205() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_03206() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 4), result1.getResponseParameter());
        assertEquals(data[3], result1.getResponseParameter()[0]);
        assertTrue(result1.isParameterValueStartEnhancedOffsetCompensationIncorrectCalibrationPosition());
        assertFalse(result1.isParameterValueStartEnhancedOffsetCompensationManufacturerSpecificErrorFollows());
    }

    @Test
    public void test_constructor_03207() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 7), result1.getResponseParameter());
        assertEquals(data[3], result1.getResponseParameter()[0]);
        assertFalse(result1.isParameterValueStartEnhancedOffsetCompensationIncorrectCalibrationPosition());
        assertTrue(result1.isParameterValueStartEnhancedOffsetCompensationManufacturerSpecificErrorFollows());
        assertTrue(result1.hasManufacturerSpecificData());
        assertEquals(0x0008, result1.getCompanyId());
        assertEquals(0x00, result1.getManfacturerSpecificDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 7), result1.getManfacturerSpecificData());
    }

    @Test
    public void test_constructor_03208() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertEquals(data[0], result1.getOpCodes());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getOpCodes()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getOpCodes()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getOpCodes()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getOpCodes()));
        assertFalse(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getOpCodes()));
        assertTrue(result1.isOpCodesResponseCode(result1.getOpCodes()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodesSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestCrankLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestChainWeight(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesSetSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSpanLength(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesStartOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestSamplingRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesRequestFactoryCalibrationDate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodesStartEnhancedOffsetCompensation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodesResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 8), result1.getResponseParameter());
        assertEquals(data[3], result1.getResponseParameter()[0]);
        assertFalse(result1.isParameterValueStartEnhancedOffsetCompensationIncorrectCalibrationPosition());
        assertTrue(result1.isParameterValueStartEnhancedOffsetCompensationManufacturerSpecificErrorFollows());
        assertTrue(result1.hasManufacturerSpecificData());
        assertEquals(0x0008, result1.getCompanyId());
        assertEquals(0x01, result1.getManfacturerSpecificDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 8), result1.getManfacturerSpecificData());
    }

    @Test
    public void test_constructor_03209() {
        int opCodes = 1;
        byte[] parameterValue = new byte[] { 2 };
        int requestOpCode = 3;
        int responseValue = 4;
        byte[] responseParameter = new byte[] { 5 };

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(opCodes, parameterValue, requestOpCode, responseValue, responseParameter);
        assertEquals(opCodes, result1.getOpCodes());
        assertArrayEquals(parameterValue, result1.getParameterValue());
        assertEquals(requestOpCode, result1.getRequestOpCode());
        assertEquals(responseValue, result1.getResponseValue());
        assertArrayEquals(responseParameter, result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01211() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01212() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01221() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01222() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01231() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01232() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01241() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01242() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01251() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01252() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01261() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01262() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01271() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01272() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01302() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01702() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01703() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01704() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01802() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01803() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01804() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01902() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01903() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01904() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01905() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02002() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02003() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02004() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02102() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02103() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02104() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02203() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02204() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02302() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02303() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02304() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02402() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02403() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02404() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02502() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02503() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02504() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02602() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02603() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02604() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02702() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02703() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02704() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02802() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02803() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02804() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02902() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02903() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02904() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03002() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03003() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03004() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03102() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03103() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03104() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03203() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03204() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03205() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03206() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03207() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03208() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCodes(), result2.getOpCodes());
        assertArrayEquals(result1.getParameterValue(), result2.getParameterValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01211() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01212() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01221() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01222() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01231() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01232() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01241() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01242() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01251() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01252() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01261() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01262() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01271() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01272() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01302() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01702() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01703() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01704() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01802() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01803() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01804() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01902() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01903() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01904() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01905() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02002() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02003() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02004() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02102() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02103() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02104() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02203() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02204() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02302() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02303() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02304() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02402() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02403() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02404() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02502() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02503() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02504() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02602() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02603() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02604() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02702() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02703() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02704() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02802() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02803() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02804() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02902() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02903() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02904() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03002() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03003() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03004() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03102() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03103() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03104() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03203() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03204() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03205() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03206() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03207() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03208() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01211() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01212() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01221() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01222() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01231() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01232() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01241() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01242() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01251() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01252() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01261() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01262() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01271() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01272() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01302() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01702() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01703() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01704() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01802() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01803() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01804() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01902() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01903() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01904() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01905() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02002() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02003() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02004() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02102() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02103() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02104() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02203() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02204() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02301() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02302() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02303() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02304() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02401() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02402() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02403() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02404() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02501() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02502() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02503() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02504() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02601() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02602() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02603() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02604() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02701() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02702() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02703() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02704() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02801() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02802() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02803() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02804() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02901() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02902() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02903() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02904() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03001() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03002() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03003() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03004() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03101() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03102() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03103() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03104() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03201() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03202() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03203() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03204() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03205() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03206() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03207() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03208() {
        byte[] data = getData();

        CyclingPowerControlPointAndroid result1 = new CyclingPowerControlPointAndroid(data);
        CyclingPowerControlPointAndroid result2 = CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
