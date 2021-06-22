package org.im97mori.ble.characteristic.u2b1f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class ReconnectionConfigurationControlPointAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[1];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
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
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 1] = (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED;
        data[ 2] = (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8);
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00202 = data;
    }

    private static final byte[] data_00203;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 1] = (byte) ReconnectionConfigurationControlPoint.RECONNECTION_TIMEOUT_DISABLED;
        data[ 2] = (byte) (ReconnectionConfigurationControlPoint.RECONNECTION_TIMEOUT_DISABLED >> 8);
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00203 = data;
    }

    private static final byte[] data_00204;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED;
        data[ 4] = (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00204 = data;
    }

    private static final byte[] data_00205;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED;
        data[ 6] = (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8);
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00205 = data;
    }

    private static final byte[] data_00206;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED;
        data[ 8] = (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8);
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00206 = data;
    }

    private static final byte[] data_00207;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED;
        data[10] = (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8);
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00207 = data;
    }

    private static final byte[] data_00208;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
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
        data[11] = (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED;
        data[12] = (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8);
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00208 = data;
    }

    private static final byte[] data_00209;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
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
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED;
        data[14] = (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8);
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00209 = data;
    }

    private static final byte[] data_00210;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
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
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED;
        data[16] = (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8);
        data_00210 = data;
    }

    private static final byte[] data_00211;
    static {
        byte[] data = new byte[19];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
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
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00211 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS;
        data[ 1] = 0x01;
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[1];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES;
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[1];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES;
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES;
        data[ 1] = 0x01;
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[5];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[5];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data_00702 = data;
    }

    private static final byte[] data_00703;
    static {
        byte[] data = new byte[5];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER;
        data[ 1] = (byte) 0xFFFFFFFE;
        data[ 2] = (byte) (0xFFFFFFFE >> 8);
        data[ 3] = (byte) (0xFFFFFFFE >> 16);
        data[ 4] = (byte) (0xFFFFFFFE >> 24);
        data_00703 = data;
    }

    private static final byte[] data_00704;
    static {
        byte[] data = new byte[7];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_00704 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[1];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER;
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00802 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 1] = ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_1;
        data_00901 = data;
    }

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 1] = ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_2;
        data_00902 = data;
    }

    private static final byte[] data_00903;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 1] = ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_3;
        data_00903 = data;
    }

    private static final byte[] data_00904;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 1] = ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_4;
        data_00904 = data;
    }

    private static final byte[] data_00905;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 1] = ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_1;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00905 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY;
        data[ 1] = ReconnectionConfigurationControlPoint.UPGRADE_TO_LESC_ONLY_FALSE;
        data_01001 = data;
    }

    private static final byte[] data_01002;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY;
        data[ 1] = (byte) ReconnectionConfigurationControlPoint.UPGRADE_TO_LESC_ONLY_TRUE;
        data_01002 = data;
    }

    private static final byte[] data_01003;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY;
        data[ 1] = ReconnectionConfigurationControlPoint.UPGRADE_TO_LESC_ONLY_FALSE;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01003 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING;
        data[ 1] = ReconnectionConfigurationControlPoint.SWITCH_OOB_PAIRING_FALSE;
        data_01101 = data;
    }

    private static final byte[] data_01102;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING;
        data[ 1] = (byte) ReconnectionConfigurationControlPoint.SWITCH_OOB_PAIRING_TRUE;
        data_01102 = data;
    }

    private static final byte[] data_01103;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING;
        data[ 1] = ReconnectionConfigurationControlPoint.SWITCH_OOB_PAIRING_FALSE;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01103 = data;
    }

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS;
        data[ 1] = ReconnectionConfigurationControlPoint.LIMITED_ACCESS_FALSE;
        data_01201 = data;
    }

    private static final byte[] data_01202;
    static {
        byte[] data = new byte[2];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS;
        data[ 1] = (byte) ReconnectionConfigurationControlPoint.LIMITED_ACCESS_TRUE;
        data_01202 = data;
    }

    private static final byte[] data_01203;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS;
        data[ 1] = ReconnectionConfigurationControlPoint.LIMITED_ACCESS_FALSE;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_01203 = data;
    }

    private static final byte[] data_01301;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01301 = data;
    }

    private static final byte[] data_01302;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01302 = data;
    }

    private static final byte[] data_01303;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        data_01303 = data;
    }

    private static final byte[] data_01304;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01304 = data;
    }

    private static final byte[] data_01305;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01305 = data;
    }

    private static final byte[] data_01306;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01306 = data;
    }

    private static final byte[] data_01307;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01307 = data;
    }

    private static final byte[] data_01308;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01308 = data;
    }

    private static final byte[] data_01309;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01309 = data;
    }

    private static final byte[] data_01310;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01310 = data;
    }

    private static final byte[] data_01311;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01311 = data;
    }

    private static final byte[] data_01312;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01312 = data;
    }

    private static final byte[] data_01313;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01313 = data;
    }

    private static final byte[] data_01314;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_FAILED);
        data_01314 = data;
    }

    private static final byte[] data_01315;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01315 = data;
    }

    private static final byte[] data_01316;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01316 = data;
    }

    private static final byte[] data_01317;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01317 = data;
    }

    private static final byte[] data_01318;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01318 = data;
    }

    private static final byte[] data_01319;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01319 = data;
    }

    private static final byte[] data_01320;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01320 = data;
    }

    private static final byte[] data_01321;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data_01321 = data;
    }

    private static final byte[] data_01322;
    static {
        byte[] data = new byte[4];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_FAILED);
        data_01322 = data;
    }

    private static final byte[] data_01323;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01323 = data;
    }

    private static final byte[] data_01324;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data_01324 = data;
    }

    private static final byte[] data_01325;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED;
        data_01325 = data;
    }

    private static final byte[] data_01326;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        data_01326 = data;
    }

    private static final byte[] data_01327;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED;
        data_01327 = data;
    }

    private static final byte[] data_01328;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        data_01328 = data;
    }

    private static final byte[] data_01329;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01329 = data;
    }

    private static final byte[] data_01330;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01330 = data;
    }

    private static final byte[] data_01331;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data_01331 = data;
    }

    private static final byte[] data_01332;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED;
        data_01332 = data;
    }

    private static final byte[] data_01333;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED;
        data_01333 = data;
    }

    private static final byte[] data_01334;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01334 = data;
    }

    private static final byte[] data_01335;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01335 = data;
    }

    private static final byte[] data_01336;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01336 = data;
    }

    private static final byte[] data_01337;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01337 = data;
    }

    private static final byte[] data_01338;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01338 = data;
    }

    private static final byte[] data_01339;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01339 = data;
    }

    private static final byte[] data_01340;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data_01340 = data;
    }

    private static final byte[] data_01341;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01341 = data;
    }

    private static final byte[] data_01342;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01342 = data;
    }

    private static final byte[] data_01343;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data_01343 = data;
    }

    private static final byte[] data_01344;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        data_01344 = data;
    }

    private static final byte[] data_01345;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01345 = data;
    }

    private static final byte[] data_01346;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01346 = data;
    }

    private static final byte[] data_01347;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        data_01347 = data;
    }

    private static final byte[] data_01348;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01348 = data;
    }

    private static final byte[] data_01349;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01349 = data;
    }

    private static final byte[] data_01350;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data_01350 = data;
    }

    private static final byte[] data_01351;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        data_01351 = data;
    }

    private static final byte[] data_01352;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01352 = data;
    }

    private static final byte[] data_01353;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01353 = data;
    }

    private static final byte[] data_01354;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data_01354 = data;
    }

    private static final byte[] data_01355;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        data_01355 = data;
    }

    private static final byte[] data_01356;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01356 = data;
    }

    private static final byte[] data_01357;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01357 = data;
    }

    private static final byte[] data_01358;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data_01358 = data;
    }

    private static final byte[] data_01359;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        data_01359 = data;
    }

    private static final byte[] data_01360;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        data_01360 = data;
    }

    private static final byte[] data_01361;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01361 = data;
    }

    private static final byte[] data_01362;
    static {
        byte[] data = new byte[3];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data_01362 = data;
    }

    private static final byte[] data_01363;
    static {
        byte[] data = new byte[5];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_01363 = data;
    }

    private static final byte[] data_01364;
    static {
        byte[] data = new byte[6];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data[ 4] = 0x01;
        data[ 5] = 0x02;
        data_01364 = data;
    }

    private static final byte[] data_01365;
    static {
        byte[] data = new byte[6];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS;
        data[ 2] = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.FIELD_NO_0_FAILED
                | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS);
        data[ 4] = 0x01;
        data[ 5] = 0x02;
        data_01365 = data;
    }

    private static final byte[] data_01401;
    static {
        byte[] data = new byte[18];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES;
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
        data_01401 = data;
    }

    private static final byte[] data_01402;
    static {
        byte[] data = new byte[18];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES;
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
        data_01402 = data;
    }

    private static final byte[] data_01403;
    static {
        byte[] data = new byte[18];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES;
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
        data_01403 = data;
    }

    private static final byte[] data_01404;
    static {
        byte[] data = new byte[20];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE;
        data[ 1] = ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES;
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
        data_01404 = data;
    }

    private static final byte[] data_01501;
    static {
        byte[] data = new byte[13];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE;
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
        data[11] = 0x0b;
        data[12] = 0x0c;
        data_01501 = data;
    }

    private static final byte[] data_01502;
    static {
        byte[] data = new byte[13];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE;
        data[ 1] = (byte) ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED;
        data[ 2] = (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 8);
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 16);
        data[ 4] = (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 24);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data_01502 = data;
    }

    private static final byte[] data_01503;
    static {
        byte[] data = new byte[13];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE;
        data[ 1] = (byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED;
        data[ 2] = (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8);
        data[ 3] = (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16);
        data[ 4] = (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data_01503 = data;
    }

    private static final byte[] data_01504;
    static {
        byte[] data = new byte[15];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE;
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
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data_01504 = data;
    }

    private static final byte[] data_01601;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION;
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
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_01601 = data;
    }

    private static final byte[] data_01602;
    static {
        byte[] data = new byte[17];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION;
        data[ 1] = (byte) ReconnectionConfigurationControlPoint.RECONNECTION_TIMEOUT_DISABLED;
        data[ 2] = (byte) (ReconnectionConfigurationControlPoint.RECONNECTION_TIMEOUT_DISABLED >> 8);
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_01602 = data;
    }

    private static final byte[] data_01603;
    static {
        byte[] data = new byte[19];
        data[ 0] = ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION;
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
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_01603 = data;
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

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, result1.getOpcode());
        assertTrue(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, result1.getOpcode());
        assertTrue(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, result1.getReconnectionTimeout());
        assertTrue(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.RECONNECTION_TIMEOUT_DISABLED, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertTrue(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, result1.getMinimumConnectionInterval());
        assertTrue(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, result1.getMaximumConnectionInterval());
        assertTrue(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, result1.getSlaveLatency());
        assertTrue(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, result1.getSupervisionTimeoutMultiplier());
        assertTrue(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00208() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, result1.getAdvertisementInterval());
        assertTrue(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00209() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, result1.getAdvertisementCount());
        assertTrue(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00210() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, result1.getAdvertisementRepetitionTime());
        assertTrue(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00211() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x1211, result1.getE2eCrc().intValue());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertTrue(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x01, result1.getParameterSet());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertTrue(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0302, result1.getE2eCrc().intValue());
        assertEquals(0x01, result1.getParameterSet());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
    }

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x01, result1.getParameterSet());
    }

    @Test
    public void test_constructor_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0302, result1.getE2eCrc().intValue());
        assertEquals(0x01, result1.getParameterSet());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x04030201, result1.getWhiteListTimer());
        assertFalse(result1.isWhiteListDisabled());
        assertFalse(result1.isWhiteListTimerDisabled());
    }

    @Test
    public void test_constructor_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0, result1.getWhiteListTimer());
        assertTrue(result1.isWhiteListDisabled());
        assertFalse(result1.isWhiteListTimerDisabled());
    }

    @Test
    public void test_constructor_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0xFFFFFFFEL, result1.getWhiteListTimer());
        assertFalse(result1.isWhiteListDisabled());
        assertTrue(result1.isWhiteListTimerDisabled());
    }

    @Test
    public void test_constructor_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0605, result1.getE2eCrc().intValue());
        assertEquals(0x04030201, result1.getWhiteListTimer());
        assertFalse(result1.isWhiteListDisabled());
        assertFalse(result1.isWhiteListTimerDisabled());
    }

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
    }

    @Test
    public void test_constructor_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertTrue(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
    }

    @Test
    public void test_constructor_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertTrue(result1.isAdvertisementConfiguration1());
        assertFalse(result1.isAdvertisementConfiguration2());
        assertFalse(result1.isAdvertisementConfiguration3());
        assertFalse(result1.isAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertFalse(result1.isAdvertisementConfiguration1());
        assertTrue(result1.isAdvertisementConfiguration2());
        assertFalse(result1.isAdvertisementConfiguration3());
        assertFalse(result1.isAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_00903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertFalse(result1.isAdvertisementConfiguration1());
        assertFalse(result1.isAdvertisementConfiguration2());
        assertTrue(result1.isAdvertisementConfiguration3());
        assertFalse(result1.isAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_00904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertFalse(result1.isAdvertisementConfiguration1());
        assertFalse(result1.isAdvertisementConfiguration2());
        assertFalse(result1.isAdvertisementConfiguration3());
        assertTrue(result1.isAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_00905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
        assertTrue(result1.isAdvertisementConfiguration1());
        assertFalse(result1.isAdvertisementConfiguration2());
        assertFalse(result1.isAdvertisementConfiguration3());
        assertFalse(result1.isAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertTrue(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertTrue(result1.isUpgradeToLescOnlyFalse());
        assertFalse(result1.isUpgradeToLescOnlyTrue());
    }

    @Test
    public void test_constructor_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertTrue(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertFalse(result1.isUpgradeToLescOnlyFalse());
        assertTrue(result1.isUpgradeToLescOnlyTrue());
    }

    @Test
    public void test_constructor_01003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertTrue(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
        assertTrue(result1.isUpgradeToLescOnlyFalse());
        assertFalse(result1.isUpgradeToLescOnlyTrue());
    }

    @Test
    public void test_constructor_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertTrue(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertTrue(result1.isSwitchOobPairingFalse());
        assertFalse(result1.isSwitchOobPairingTrue());
    }

    @Test
    public void test_constructor_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertTrue(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertFalse(result1.isSwitchOobPairingFalse());
        assertTrue(result1.isSwitchOobPairingTrue());
    }

    @Test
    public void test_constructor_01103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertTrue(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
        assertTrue(result1.isSwitchOobPairingFalse());
        assertFalse(result1.isSwitchOobPairingTrue());
    }

    @Test
    public void test_constructor_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertTrue(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertTrue(result1.isLimitedAccessFalse());
        assertFalse(result1.isLimitedAccessTrue());
    }

    @Test
    public void test_constructor_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertTrue(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertFalse(result1.isLimitedAccessFalse());
        assertTrue(result1.isLimitedAccessTrue());
    }

    @Test
    public void test_constructor_01203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertTrue(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
        assertTrue(result1.isLimitedAccessFalse());
        assertFalse(result1.isLimitedAccessTrue());
    }

    @Test
    public void test_constructor_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, result1.getRequestOpcodes());
        assertTrue(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, result1.getRequestOpcodes());
        assertTrue(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, result1.getRequestOpcodes());
        assertTrue(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertFalse(result1.isFieldNo0Success());
        assertTrue(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01308() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertFalse(result1.isFieldNo1Success());
        assertTrue(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01309() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertFalse(result1.isFieldNo2Success());
        assertTrue(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01310() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertFalse(result1.isFieldNo3Success());
        assertTrue(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01311() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertFalse(result1.isFieldNo4Success());
        assertTrue(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01312() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertFalse(result1.isFieldNo5Success());
        assertTrue(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01313() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertFalse(result1.isFieldNo6Success());
        assertTrue(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01314() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertFalse(result1.isFieldNo7Success());
        assertTrue(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01315() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertFalse(result1.isFieldNo0Success());
        assertTrue(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01316() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertFalse(result1.isFieldNo1Success());
        assertTrue(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01317() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertFalse(result1.isFieldNo2Success());
        assertTrue(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01318() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertFalse(result1.isFieldNo3Success());
        assertTrue(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01319() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertFalse(result1.isFieldNo4Success());
        assertTrue(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01320() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertFalse(result1.isFieldNo5Success());
        assertTrue(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01321() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertFalse(result1.isFieldNo6Success());
        assertTrue(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01322() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertTrue(result1.isFieldNo0Success());
        assertFalse(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertFalse(result1.isFieldNo7Success());
        assertTrue(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01323() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01324() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01325() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertTrue(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01326() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01327() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertTrue(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01328() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01329() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01330() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01331() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01332() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertTrue(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01333() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertTrue(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01334() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01335() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01336() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01337() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01338() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01339() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01340() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01341() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01342() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01343() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01344() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01345() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01346() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01347() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01348() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01349() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01350() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01351() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01352() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01353() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01354() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01355() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01356() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01357() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01358() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01359() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01360() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01361() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertTrue(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01362() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01363() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertTrue(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
    }

    @Test
    public void test_constructor_01364() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertTrue(result1.isResultCodeCommunicationParameterOutOfRange());
        assertFalse(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertFalse(result1.isFieldNo0Success());
        assertTrue(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01365() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertTrue(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getE2eCrc().intValue());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpcodeNotSupported());
        assertFalse(result1.isResultCodeInvalidOperand());
        assertFalse(result1.isResultCodeOperationFailed());
        assertFalse(result1.isResultCodeCommunicationParameterOutOfRange());
        assertTrue(result1.isResultCodeInvalidParameterCombination());
        assertFalse(result1.isResultCodeDeviceBusy());
        assertFalse(result1.isResultCodeCommunicationParametersRejected());
        assertFalse(result1.isResultCodeProposalAccepted());
        assertFalse(result1.isFieldNo0Success());
        assertTrue(result1.isFieldNo0Failed());
        assertTrue(result1.isFieldNo1Success());
        assertFalse(result1.isFieldNo1Failed());
        assertTrue(result1.isFieldNo2Success());
        assertFalse(result1.isFieldNo2Failed());
        assertTrue(result1.isFieldNo3Success());
        assertFalse(result1.isFieldNo3Failed());
        assertTrue(result1.isFieldNo4Success());
        assertFalse(result1.isFieldNo4Failed());
        assertTrue(result1.isFieldNo5Success());
        assertFalse(result1.isFieldNo5Failed());
        assertTrue(result1.isFieldNo6Success());
        assertFalse(result1.isFieldNo6Failed());
        assertTrue(result1.isFieldNo7Success());
        assertFalse(result1.isFieldNo7Failed());
    }

    @Test
    public void test_constructor_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 18), result1.getResultParameter());
    }

    @Test
    public void test_constructor_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 18), result1.getResultParameter());
    }

    @Test
    public void test_constructor_01403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 18), result1.getResultParameter());
    }

    @Test
    public void test_constructor_01404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x1211, result1.getE2eCrc().intValue());
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES, result1.getRequestOpcodes());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getRequestOpcodes()));
        assertTrue(result1.isOpcodeGetMaxValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getRequestOpcodes()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getRequestOpcodes()));
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 18), result1.getResultParameter());
    }

    @Test
    public void test_constructor_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x04030201L, result1.getWhiteListTimer());
        assertEquals(0x08070605L, result1.getMinWhiteListTimer());
        assertEquals(0x0c0b0a09L, result1.getMaxWhiteListTimer());
        assertFalse(result1.isWhiteListDisabled());
        assertFalse(result1.isWhiteListTimerDisabled());
        assertArrayEquals(Arrays.copyOfRange(data, 1, 13), result1.getResultParameter());
    }

    @Test
    public void test_constructor_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED, result1.getWhiteListTimer());
        assertEquals(0x08070605L, result1.getMinWhiteListTimer());
        assertEquals(0x0c0b0a09L, result1.getMaxWhiteListTimer());
        assertTrue(result1.isWhiteListDisabled());
        assertFalse(result1.isWhiteListTimerDisabled());
        assertArrayEquals(Arrays.copyOfRange(data, 1, 13), result1.getResultParameter());
    }

    @Test
    public void test_constructor_01503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED, result1.getWhiteListTimer());
        assertEquals(0x08070605L, result1.getMinWhiteListTimer());
        assertEquals(0x0c0b0a09L, result1.getMaxWhiteListTimer());
        assertFalse(result1.isWhiteListDisabled());
        assertTrue(result1.isWhiteListTimerDisabled());
        assertArrayEquals(Arrays.copyOfRange(data, 1, 13), result1.getResultParameter());
    }

    @Test
    public void test_constructor_01504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x0e0dL, result1.getE2eCrc().intValue());
        assertEquals(0x04030201L, result1.getWhiteListTimer());
        assertEquals(0x08070605L, result1.getMinWhiteListTimer());
        assertEquals(0x0c0b0a09L, result1.getMaxWhiteListTimer());
        assertFalse(result1.isWhiteListDisabled());
        assertFalse(result1.isWhiteListTimerDisabled());
        assertArrayEquals(Arrays.copyOfRange(data, 1, 13), result1.getResultParameter());
    }

    @Test
    public void test_constructor_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_01602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNull(result1.getE2eCrc());
        assertEquals(ReconnectionConfigurationControlPoint.RECONNECTION_TIMEOUT_DISABLED, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertTrue(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_01603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertEquals(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION, result1.getOpcode());
        assertFalse(result1.isOpcodeEnableDisconnect(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetActualCommunicationParameters(result1.getOpcode()));
        assertFalse(result1.isOpcodeProposeSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeActivateStoredSettings(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMaxValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetMinValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetStoredValues(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeGetWhiteListTimer(result1.getOpcode()));
        assertFalse(result1.isOpcodeSetAdvertisementConfiguration(result1.getOpcode()));
        assertFalse(result1.isOpcodeUpgradeToLescOnly(result1.getOpcode()));
        assertFalse(result1.isOpcodeSwitchOobPairing(result1.getOpcode()));
        assertFalse(result1.isOpcodeLimitedAccess(result1.getOpcode()));
        assertFalse(result1.isOpcodeProcedureResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeCommunicationParameterResponse(result1.getOpcode()));
        assertFalse(result1.isOpcodeWhiteListTimerResponse(result1.getOpcode()));
        assertTrue(result1.isOpcodeClientParameterIndication(result1.getOpcode()));
        assertNotNull(result1.getE2eCrc());
        assertEquals(0x1211, result1.getE2eCrc().intValue());
        assertEquals(0x0201, result1.getReconnectionTimeout());
        assertFalse(result1.isReconnectionTimeoutNotBeChanged());
        assertFalse(result1.isReconnectionTimeoutDisabled());
        assertEquals(0x0403, result1.getMinimumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MINIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0403, result1.getMinimumConnectionIntervalMs(), 0);
        assertFalse(result1.isMinimumConnectionIntervalNotBeChanged());
        assertEquals(0x0605, result1.getMaximumConnectionInterval());
        assertEquals(ReconnectionConfigurationControlPoint.MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * 0x0605, result1.getMaximumConnectionIntervalMs(), 0);
        assertFalse(result1.isMaximumConnectionIntervalNotBeChanged());
        assertEquals(0x0807, result1.getSlaveLatency());
        assertFalse(result1.isSlaveLatencyNotBeChanged());
        assertEquals(0x0a09, result1.getSupervisionTimeoutMultiplier());
        assertEquals(ReconnectionConfigurationControlPoint.SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * 0x0a09, result1.getSupervisionTimeoutMultiplierMs(), 0);
        assertFalse(result1.isSupervisionTimeoutMultiplierNotBeChanged());
        assertEquals(0x0c0b, result1.getAdvertisementInterval());
        assertEquals(ReconnectionConfigurationControlPoint.ADVERTISEMENT_INTERVAL_RESOLUTION * 0x0c0b, result1.getAdvertisementIntervalMs(), 0);
        assertFalse(result1.isAdvertisementIntervalNotBeChanged());
        assertEquals(0x0e0d, result1.getAdvertisementCount());
        assertFalse(result1.isAdvertisementCountNotBeChanged());
        assertEquals(0x100f, result1.getAdvertisementRepetitionTime());
        assertFalse(result1.isAdvertisementRepetitionTimeNotBeChanged());
    }

    @Test
    public void test_constructor_01604() {
        int opcode = 1;
        byte[] operand = new byte[] { 2 };
        int e2eCrc = 3;
        int requestOpcodes = 4;
        int resultCode = 5;
        byte[] resultParameter = new byte[] { 6 };

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(opcode, operand, e2eCrc, requestOpcodes, resultCode, resultParameter);
        assertEquals(opcode, result1.getOpcode());
        assertArrayEquals(operand, result1.getOperand());
        assertEquals(e2eCrc, result1.getE2eCrc().intValue());
        assertEquals(requestOpcodes, result1.getRequestOpcodes());
        assertEquals(resultCode, result1.getResultCode());
        assertArrayEquals(resultParameter, result1.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00208() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00209() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00210() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00211() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_00905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01308() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01309() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01310() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01311() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01312() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01313() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01314() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01315() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01316() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01317() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01318() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01319() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01320() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01321() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01322() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01323() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01324() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01325() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01326() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01327() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01328() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01329() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01330() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01331() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01332() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01333() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01334() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01335() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01336() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01337() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01338() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01339() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01340() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01341() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01342() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01343() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01344() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01345() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01346() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01347() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01348() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01349() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01350() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01351() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01352() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01353() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01354() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01355() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01356() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01357() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01358() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01359() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01360() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01361() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01362() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01363() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01364() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01365() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_1_01603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpcode(), result2.getOpcode());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
        assertEquals(result1.getRequestOpcodes(), result2.getRequestOpcodes());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResultParameter(), result2.getResultParameter());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00208() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00209() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00210() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00211() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01308() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01309() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01310() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01311() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01312() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01313() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01314() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01315() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01316() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01317() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01318() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01319() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01320() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01321() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01322() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01323() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01324() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01325() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01326() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01327() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01328() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01329() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01330() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01331() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01332() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01333() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01334() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01335() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01336() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01337() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01338() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01339() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01340() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01341() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01342() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01343() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01344() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01345() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01346() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01347() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01348() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01349() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01350() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01351() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01352() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01353() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01354() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01355() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01356() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01357() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01358() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01359() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01360() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01361() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01362() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01363() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01364() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01365() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00208() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00209() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00210() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00211() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00905() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01103() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01303() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01304() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01305() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01306() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01307() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01308() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01309() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01310() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01311() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01312() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01313() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01314() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01315() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01316() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01317() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01318() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01319() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01320() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01321() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01322() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01323() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01324() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01325() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01326() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01327() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01328() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01329() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01330() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01331() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01332() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01333() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01334() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01335() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01336() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01337() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01338() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01339() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01340() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01341() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01342() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01343() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01344() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01345() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01346() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01347() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01348() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01349() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01350() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01351() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01352() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01353() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01354() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01355() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01356() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01357() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01358() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01359() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01360() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01361() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01362() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01363() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01364() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01365() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReconnectionConfigurationControlPointAndroid result1 = new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        ReconnectionConfigurationControlPointAndroid result2 = ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
