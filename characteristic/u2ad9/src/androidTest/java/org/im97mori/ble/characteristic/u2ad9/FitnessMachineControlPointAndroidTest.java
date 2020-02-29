package org.im97mori.ble.characteristic.u2ad9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class FitnessMachineControlPointAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL;
        data_00001 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[1];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_RESET;
        data_00101 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00201 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00301 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL;
        data[ 1] = 0x01;
        data_00401 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00501 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE;
        data[ 1] = 0x01;
        data_00601 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[1];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_START_OR_RESUME;
        data_00701 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 1] = FitnessMachineControlPoint.STOP_OR_PAUSE_STOP;
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 1] = FitnessMachineControlPoint.STOP_OR_PAUSE_PAUSE;
        data_00802 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00901 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_01001 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_01101 = data;
    }

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[4];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_01201 = data;
    }

    private static final byte[] data_01301;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_01301 = data;
    }

    private static final byte[] data_01401;
    static {
        byte[] data = new byte[5];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data_01401 = data;
    }

    private static final byte[] data_01501;
    static {
        byte[] data = new byte[7];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_01501 = data;
    }

    private static final byte[] data_01601;
    static {
        byte[] data = new byte[11];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data_01601 = data;
    }

    private static final byte[] data_01701;
    static {
        byte[] data = new byte[7];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_01701 = data;
    }

    private static final byte[] data_01801;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_01801 = data;
    }

    private static final byte[] data_01901;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 1] = FitnessMachineControlPoint.SPIN_DOWN_START;
        data_01901 = data;
    }

    private static final byte[] data_01902;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 1] = FitnessMachineControlPoint.SPIN_DOWN_IGNORE;
        data_01902 = data;
    }

    private static final byte[] data_02001;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_02001 = data;
    }

    private static final byte[] data_02101;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02101 = data;
    }

    private static final byte[] data_02102;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02102 = data;
    }

    private static final byte[] data_02103;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02103 = data;
    }

    private static final byte[] data_02104;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02104 = data;
    }

    private static final byte[] data_02105;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02105 = data;
    }

    private static final byte[] data_02106;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02106 = data;
    }

    private static final byte[] data_02107;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02107 = data;
    }

    private static final byte[] data_02201;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_RESET;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02201 = data;
    }

    private static final byte[] data_02202;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_RESET;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02202 = data;
    }

    private static final byte[] data_02203;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_RESET;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02203 = data;
    }

    private static final byte[] data_02204;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_RESET;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02204 = data;
    }

    private static final byte[] data_02205;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_RESET;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02205 = data;
    }

    private static final byte[] data_02206;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_RESET;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02206 = data;
    }

    private static final byte[] data_02207;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_RESET;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02207 = data;
    }

    private static final byte[] data_02301;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02301 = data;
    }

    private static final byte[] data_02302;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02302 = data;
    }

    private static final byte[] data_02303;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02303 = data;
    }

    private static final byte[] data_02304;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02304 = data;
    }

    private static final byte[] data_02305;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02305 = data;
    }

    private static final byte[] data_02306;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02306 = data;
    }

    private static final byte[] data_02307;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02307 = data;
    }

    private static final byte[] data_02401;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02401 = data;
    }

    private static final byte[] data_02402;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02402 = data;
    }

    private static final byte[] data_02403;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02403 = data;
    }

    private static final byte[] data_02404;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02404 = data;
    }

    private static final byte[] data_02405;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02405 = data;
    }

    private static final byte[] data_02406;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02406 = data;
    }

    private static final byte[] data_02407;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02407 = data;
    }

    private static final byte[] data_02501;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02501 = data;
    }

    private static final byte[] data_02502;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02502 = data;
    }

    private static final byte[] data_02503;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02503 = data;
    }

    private static final byte[] data_02504;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02504 = data;
    }

    private static final byte[] data_02505;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02505 = data;
    }

    private static final byte[] data_02506;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02506 = data;
    }

    private static final byte[] data_02507;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02507 = data;
    }

    private static final byte[] data_02601;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02601 = data;
    }

    private static final byte[] data_02602;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02602 = data;
    }

    private static final byte[] data_02603;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02603 = data;
    }

    private static final byte[] data_02604;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02604 = data;
    }

    private static final byte[] data_02605;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02605 = data;
    }

    private static final byte[] data_02606;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02606 = data;
    }

    private static final byte[] data_02607;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02607 = data;
    }

    private static final byte[] data_02701;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02701 = data;
    }

    private static final byte[] data_02702;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02702 = data;
    }

    private static final byte[] data_02703;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02703 = data;
    }

    private static final byte[] data_02704;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02704 = data;
    }

    private static final byte[] data_02705;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02705 = data;
    }

    private static final byte[] data_02706;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02706 = data;
    }

    private static final byte[] data_02707;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02707 = data;
    }

    private static final byte[] data_02801;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_START_OR_RESUME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02801 = data;
    }

    private static final byte[] data_02802;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_START_OR_RESUME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02802 = data;
    }

    private static final byte[] data_02803;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_START_OR_RESUME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02803 = data;
    }

    private static final byte[] data_02804;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_START_OR_RESUME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02804 = data;
    }

    private static final byte[] data_02805;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_START_OR_RESUME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02805 = data;
    }

    private static final byte[] data_02806;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_START_OR_RESUME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02806 = data;
    }

    private static final byte[] data_02807;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_START_OR_RESUME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02807 = data;
    }

    private static final byte[] data_02901;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02901 = data;
    }

    private static final byte[] data_02902;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02902 = data;
    }

    private static final byte[] data_02903;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_02903 = data;
    }

    private static final byte[] data_02904;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_02904 = data;
    }

    private static final byte[] data_02905;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_02905 = data;
    }

    private static final byte[] data_02906;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_02906 = data;
    }

    private static final byte[] data_02907;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_02907 = data;
    }

    private static final byte[] data_03001;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03001 = data;
    }

    private static final byte[] data_03002;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03002 = data;
    }

    private static final byte[] data_03003;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03003 = data;
    }

    private static final byte[] data_03004;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03004 = data;
    }

    private static final byte[] data_03005;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03005 = data;
    }

    private static final byte[] data_03006;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03006 = data;
    }

    private static final byte[] data_03007;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03007 = data;
    }

    private static final byte[] data_03101;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03101 = data;
    }

    private static final byte[] data_03102;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03102 = data;
    }

    private static final byte[] data_03103;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03103 = data;
    }

    private static final byte[] data_03104;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03104 = data;
    }

    private static final byte[] data_03105;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03105 = data;
    }

    private static final byte[] data_03106;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03106 = data;
    }

    private static final byte[] data_03107;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03107 = data;
    }

    private static final byte[] data_03201;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03201 = data;
    }

    private static final byte[] data_03202;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03202 = data;
    }

    private static final byte[] data_03203;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03203 = data;
    }

    private static final byte[] data_03204;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03204 = data;
    }

    private static final byte[] data_03205;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03205 = data;
    }

    private static final byte[] data_03206;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03206 = data;
    }

    private static final byte[] data_03207;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03207 = data;
    }

    private static final byte[] data_03301;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03301 = data;
    }

    private static final byte[] data_03302;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03302 = data;
    }

    private static final byte[] data_03303;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03303 = data;
    }

    private static final byte[] data_03304;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03304 = data;
    }

    private static final byte[] data_03305;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03305 = data;
    }

    private static final byte[] data_03306;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03306 = data;
    }

    private static final byte[] data_03307;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03307 = data;
    }

    private static final byte[] data_03401;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03401 = data;
    }

    private static final byte[] data_03402;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03402 = data;
    }

    private static final byte[] data_03403;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03403 = data;
    }

    private static final byte[] data_03404;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03404 = data;
    }

    private static final byte[] data_03405;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03405 = data;
    }

    private static final byte[] data_03406;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03406 = data;
    }

    private static final byte[] data_03407;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03407 = data;
    }

    private static final byte[] data_03501;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03501 = data;
    }

    private static final byte[] data_03502;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03502 = data;
    }

    private static final byte[] data_03503;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03503 = data;
    }

    private static final byte[] data_03504;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03504 = data;
    }

    private static final byte[] data_03505;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03505 = data;
    }

    private static final byte[] data_03506;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03506 = data;
    }

    private static final byte[] data_03507;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03507 = data;
    }

    private static final byte[] data_03601;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03601 = data;
    }

    private static final byte[] data_03602;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03602 = data;
    }

    private static final byte[] data_03603;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03603 = data;
    }

    private static final byte[] data_03604;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03604 = data;
    }

    private static final byte[] data_03605;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03605 = data;
    }

    private static final byte[] data_03606;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03606 = data;
    }

    private static final byte[] data_03607;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03607 = data;
    }

    private static final byte[] data_03701;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03701 = data;
    }

    private static final byte[] data_03702;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03702 = data;
    }

    private static final byte[] data_03703;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03703 = data;
    }

    private static final byte[] data_03704;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03704 = data;
    }

    private static final byte[] data_03705;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03705 = data;
    }

    private static final byte[] data_03706;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03706 = data;
    }

    private static final byte[] data_03707;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03707 = data;
    }

    private static final byte[] data_03801;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03801 = data;
    }

    private static final byte[] data_03802;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03802 = data;
    }

    private static final byte[] data_03803;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03803 = data;
    }

    private static final byte[] data_03804;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03804 = data;
    }

    private static final byte[] data_03805;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03805 = data;
    }

    private static final byte[] data_03806;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03806 = data;
    }

    private static final byte[] data_03807;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03807 = data;
    }

    private static final byte[] data_03901;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03901 = data;
    }

    private static final byte[] data_03902;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03902 = data;
    }

    private static final byte[] data_03903;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_03903 = data;
    }

    private static final byte[] data_03904;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_03904 = data;
    }

    private static final byte[] data_03905;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_03905 = data;
    }

    private static final byte[] data_03906;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_03906 = data;
    }

    private static final byte[] data_03907;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_03907 = data;
    }

    private static final byte[] data_04001;
    static {
        byte[] data = new byte[7];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_04001 = data;
    }

    private static final byte[] data_04002;
    static {
        byte[] data = new byte[7];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_04002 = data;
    }

    private static final byte[] data_04003;
    static {
        byte[] data = new byte[7];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_04003 = data;
    }

    private static final byte[] data_04004;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_04004 = data;
    }

    private static final byte[] data_04005;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_04005 = data;
    }

    private static final byte[] data_04006;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_04006 = data;
    }

    private static final byte[] data_04007;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_04007 = data;
    }

    private static final byte[] data_04101;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_04101 = data;
    }

    private static final byte[] data_04102;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_04102 = data;
    }

    private static final byte[] data_04103;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_SUCCESS;
        data_04103 = data;
    }

    private static final byte[] data_04104;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_04104 = data;
    }

    private static final byte[] data_04105;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_04105 = data;
    }

    private static final byte[] data_04106;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_04106 = data;
    }

    private static final byte[] data_04107;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE;
        data[ 2] = FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED;
        data_04107 = data;
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

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL, result1.getOpCode());
        assertTrue(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESET, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertTrue(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetSpeed());
        assertEquals(FitnessMachineControlPoint.TARGET_SPEED_RESOLUTION * 0x0201, result1.getTargetSpeedKmH(), 0);
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetInclination());
        assertEquals(FitnessMachineControlPoint.TARGET_INCLINATION_RESOLUTION * 0x0201, result1.getTargetInclinationPercent(), 0);
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x01, result1.getTargetResistanceLevel());
        assertEquals(FitnessMachineControlPoint.TARGET_RESISTANCE_LEVEL_RESOLUTION * 0x01, result1.getTargetResistanceLevelWithUnit(), 0);
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetPower());
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x01, result1.getTargetHeartRate());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_START_OR_RESUME, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertTrue(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertTrue(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isStopOrPauseStop());
        assertFalse(result1.isStopOrPausePause());
    }

    @Test
    public void test_constructor_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertTrue(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isStopOrPauseStop());
        assertTrue(result1.isStopOrPausePause());
    }

    @Test
    public void test_constructor_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetedExpendedEnergy());
    }

    @Test
    public void test_constructor_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetedNumberOfSteps());
    }

    @Test
    public void test_constructor_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetedNumberOfStrides());
    }

    @Test
    public void test_constructor_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x030201, result1.getTargetedDistance());
    }

    @Test
    public void test_constructor_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetedTrainingTime());
    }

    @Test
    public void test_constructor_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetedTimeInFatBurnZone());
        assertEquals(0x0403, result1.getTargetedTimeInFitnessZone());
    }

    @Test
    public void test_constructor_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetedTimeInLightZone());
        assertEquals(0x0403, result1.getTargetedTimeInModerateZone());
        assertEquals(0x0605, result1.getTargetedTimeInHardZone());
    }

    @Test
    public void test_constructor_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetedTimeInVeryLightZone());
        assertEquals(0x0403, result1.getTargetedTimeInLightZone());
        assertEquals(0x0605, result1.getTargetedTimeInModerateZone());
        assertEquals(0x0807, result1.getTargetedTimeInHardZone());
        assertEquals(0x0a09, result1.getTargetedTimeInMaximumZone());
    }

    @Test
    public void test_constructor_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getWindSpeed());
        assertEquals(FitnessMachineControlPoint.WIND_SPEED_RESOLUTION * 0x0201, result1.getWindSpeedMetersPerSecond(), 0);
        assertEquals(0x0403, result1.getGrade());
        assertEquals(FitnessMachineControlPoint.GRADE_RESOLUTION * 0x0403, result1.getGradePercentage(), 0);
        assertEquals(0x05, result1.getCoefficientOfRollingResistance());
        assertEquals(FitnessMachineControlPoint.COEFFICIENT_OF_ROLLING_RESISTANCE_RESOLUTION * 0x05, result1.getCoefficientOfRollingResistanceWithUnit(), 0);
        assertEquals(0x06, result1.getWindResistanceCoefficient());
        assertEquals(FitnessMachineControlPoint.WIND_RESISTANCE_COEFFICIENT_RESOLUTION * 0x06, result1.getWindResistanceCoefficientKilogramPerMeter(), 0);
    }

    @Test
    public void test_constructor_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getWheelCircumference());
        assertEquals(FitnessMachineControlPoint.WHEEL_CIRCUMFERENCE_RESOLUTION * 0x0201, result1.getWheelCircumferenceKmH(), 0);
    }

    @Test
    public void test_constructor_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertTrue(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isSpinDownControlStart());
        assertFalse(result1.isSpinDownControlIgnore());
    }

    @Test
    public void test_constructor_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertTrue(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isSpinDownControlStart());
        assertTrue(result1.isSpinDownControlIgnore());
    }


    @Test
    public void test_constructor_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertTrue(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x0201, result1.getTargetedCadence());
        assertEquals(FitnessMachineControlPoint.TARGETED_CADENCE_RESOLUTION * 0x0201, result1.getTargetedCadenceRpm(), 0);
    }

    @Test
    public void test_constructor_02101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESET, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02405() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02406() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02407() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02505() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02506() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02507() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_START_OR_RESUME, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02803() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02804() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02805() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02806() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02807() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_02902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_02903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02906() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_02907() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03405() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03406() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03407() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03505() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03506() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03507() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03803() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03804() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03805() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03806() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03807() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_03902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_03903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03906() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_03907() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_04002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_04003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
        assertEquals(0x0201, result1.getTargetSpeedLow());
        assertEquals(FitnessMachineControlPoint.SPIN_DOWN_TARGET_SPEED_LOW_RESOLUTION * 0x0201, result1.getTargetSpeedLowKmH(), 0);
        assertEquals(0x0403, result1.getTargetSpeedHigh());
        assertEquals(FitnessMachineControlPoint.SPIN_DOWN_TARGET_SPEED_HIGH_RESOLUTION * 0x0403, result1.getTargetSpeedHighKmH(), 0);
    }

    @Test
    public void test_constructor_04004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getOpCode()));
        assertFalse(result1.isOpCodeSetTargetedCadence(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_04102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeRequestControl(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeReset(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetSpeed(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetInclination(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetResistanceLevel(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetPower(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetHeartRate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartOrResume(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStopOrPause(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedExpendedEnergy(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfSteps(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedNumberOfStrides(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedDistance(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTrainingTime(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInTwoHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInThreeHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetTargetedTimeInFiveHeartRateZones(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetIndoorBikeSimulationParameters(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSetWheelCircumference(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeSpinDownControl(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeSetTargetedCadence(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
    }

    @Test
    public void test_constructor_04103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeControlNotPermitted());
    }

    @Test
    public void test_constructor_04107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeControlNotPermitted());
    }


    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02405() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02406() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02407() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02505() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02506() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02507() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02803() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02804() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02805() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02806() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02807() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02906() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_02907() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03405() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03406() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03407() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03505() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03506() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03507() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03803() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03804() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03805() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03806() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03807() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03906() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_03907() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_04107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }


    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02405() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02406() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02407() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02505() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02506() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02507() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02803() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02804() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02805() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02806() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02807() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02906() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02907() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03405() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03406() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03407() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03505() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03506() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03507() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03803() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03804() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03805() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03806() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03807() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03906() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_03907() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_04107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }


    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02405() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02406() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02407() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02505() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02506() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02507() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02803() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02804() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02805() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02806() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02807() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02906() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02907() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03405() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03406() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03407() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03505() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03506() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03507() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03803() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03804() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03805() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03806() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03807() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03906() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_03907() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04104() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04105() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04106() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_04107() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineControlPointAndroid result1 = new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        FitnessMachineControlPointAndroid result2 = FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
