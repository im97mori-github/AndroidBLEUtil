package org.im97mori.ble.characteristic.rcs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;

/**
 * Reconnection Configuration Control Point (Characteristics UUID: 0x2B1F)
 */

@SuppressWarnings("WeakerAccess")
public class ReconnectionConfigurationControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 0x00: Enable Disconnect
     */
    public static final int OPCODE_ENABLE_DISCONNECT = 0x00;

    /**
     * 0x01: Get Actual Communication Parameters
     */
    public static final int OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS = 0x01;

    /**
     * 0x02: Propose Settings
     */
    public static final int OPCODE_PROPOSE_SETTINGS = 0x02;

    /**
     * 0x03: Activate Stored Settings
     */
    public static final int OPCODE_ACTIVATE_STORED_SETTINGS = 0x03;

    /**
     * 0x04: Get Max Values
     */
    public static final int OPCODE_GET_MAX_VALUES = 0x04;

    /**
     * 0x05: Get Min Values
     */
    public static final int OPCODE_GET_MIN_VALUES = 0x05;

    /**
     * 0x06: Get Stored Values
     */
    public static final int OPCODE_GET_STORED_VALUES = 0x06;

    /**
     * 0x07: Set White List Timer
     */
    public static final int OPCODE_SET_WHITE_LIST_TIMER = 0x07;

    /**
     * 0x08: Get White List Timer
     */
    public static final int OPCODE_GET_WHITE_LIST_TIMER = 0x08;

    /**
     * 0x09: Set Advertisement Configuration
     */
    public static final int OPCODE_SET_ADVERTISEMENT_CONFIGURATION = 0x09;

    /**
     * 0x0A: Upgrade to LESC Only
     */
    public static final int OPCODE_UPGRADE_TO_LESC_ONLY = 0x0A;

    /**
     * 0x0B: Switch OOB Pairing
     */
    public static final int OPCODE_SWITCH_OOB_PAIRING = 0x0B;

    /**
     * 0x0C: Limited Access
     */
    public static final int OPCODE_LIMITED_ACCESS = 0x0C;

    /**
     * 0x0E: Procedure Response
     */
    public static final int OPCODE_PROCEDURE_RESPONSE = 0x0E;

    /**
     * 0x0F: Communication Parameter Response
     */
    public static final int OPCODE_COMMUNICATION_PARAMETER_RESPONSE = 0x0F;

    /**
     * 0x10: White List Timer Response
     */
    public static final int OPCODE_WHITE_LIST_TIMER_RESPONSE = 0x10;

    /**
     * 0x11: Client Parameter Indication
     */
    public static final int OPCODE_CLIENT_PARAMETER_INDICATION = 0x11;

    /**
     * 0x01: Success
     */
    public static final int RESULT_CODE_SUCCESS = 0x01;

    /**
     * 0x02: Opcode not supported
     */
    public static final int RESULT_CODE_OPCODE_NOT_SUPPORTED = 0x02;

    /**
     * 0x03: Invalid Operand
     */
    public static final int RESULT_CODE_INVALID_OPERAND = 0x03;

    /**
     * 0x04: Operation failed
     */
    public static final int RESULT_CODE_OPERATION_FAILED = 0x04;

    /**
     * 0x05: Communication Parameter out of range
     */
    public static final int RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE = 0x05;

    /**
     * 0x06: Invalid Parameter combination
     */
    public static final int RESULT_CODE_INVALID_PARAMETER_COMBINATION = 0x06;

    /**
     * 0x07: Device Busy
     */
    public static final int RESULT_CODE_DEVICE_BUSY = 0x07;

    /**
     * 0x08: Communication Parameters rejected
     */
    public static final int RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED = 0x08;

    /**
     * 0x09: Proposal Accepted
     */
    public static final int RESULT_CODE_PROPOSAL_ACCEPTED = 0x09;

    /**
     * Minimum Connection Interval Unit 1.25 ms
     */
    public static final double MINIMUM_CONNECTION_INTERVAL_RESOLUTION = 1.25d;

    /**
     * Maximum Connection Interval Unit 1.25 ms
     */
    public static final double MAXIMUM_CONNECTION_INTERVAL_RESOLUTION = 1.25d;

    /**
     * Supervision Timeout multiplier Unit 10 ms
     */
    public static final double SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION = 10d;

    /**
     * Advertisement Interval Unit 0.625 ms
     */
    public static final double ADVERTISEMENT_INTERVAL_RESOLUTION = 0.625d;

    /**
     * Propose Settings Parameter not to be changed a wildcard value
     */
    public static final int PARAMETER_NOT_BE_CHANGED = 0xFFFF;

    /**
     * Reconnection timeout is disabled
     */
    public static final int RECONNECTION_TIMEOUT_DISABLED = 0xFFFE;

    /**
     * The functionality of White List then is disabled
     */
    public static final int WHITE_LIST_DISABLED = 0;

    /**
     * The functionality of the Whit List Timer is disabled
     */
    public static final long WHITE_LIST_TIMER_DISABLED = 0xFFFFFFFEL;

    /**
     * 0: Advertisement Configuration 1
     */
    public static final int ADVERTISEMENT_CONFIGURATION_1 = 0b00000000;

    /**
     * 1: Advertisement Configuration 2
     */
    public static final int ADVERTISEMENT_CONFIGURATION_2 = 0b00000001;

    /**
     * 2: Advertisement Configuration 3
     */
    public static final int ADVERTISEMENT_CONFIGURATION_3 = 0b00000010;

    /**
     * 3: Advertisement Configuration 4
     */
    public static final int ADVERTISEMENT_CONFIGURATION_4 = 0b00000011;

    /**
     * 0x00: Upgrade to LESC Only False
     */
    public static final int UPGRADE_TO_LESC_ONLY_FALSE = 0x00;

    /**
     * 0xff: Upgrade to LESC Only True
     */
    public static final int UPGRADE_TO_LESC_ONLY_TRUE = 0xff;

    /**
     * 0x00: Switch OOB Pairing False
     */
    public static final int SWITCH_OOB_PAIRING_FALSE = 0x00;

    /**
     * 0xff: Switch OOB Pairing True
     */
    public static final int SWITCH_OOB_PAIRING_TRUE = 0xff;

    /**
     * 0x00: Limited Access False
     */
    public static final int LIMITED_ACCESS_FALSE = 0x00;

    /**
     * 0xff: Limited Access True
     */
    public static final int LIMITED_ACCESS_TRUE = 0xff;

    /**
     * @see #FIELD_NO_0_SUCCESS
     * @see #FIELD_NO_0_FAILED
     */
    public static final int FIELD_NO_0_MASK = 0b00000001;

    /**
     * 0: Field-No 0 Success
     */
    public static final int FIELD_NO_0_SUCCESS = 0b00000000;

    /**
     * 1: Field-No 0 Failed
     */
    public static final int FIELD_NO_0_FAILED = 0b00000001;

    /**
     * @see #FIELD_NO_1_SUCCESS
     * @see #FIELD_NO_1_FAILED
     */
    public static final int FIELD_NO_1_MASK = 0b00000010;

    /**
     * 0: Field-No 1 Success
     */
    public static final int FIELD_NO_1_SUCCESS = 0b00000000;

    /**
     * 1: Field-No 1 Failed
     */
    public static final int FIELD_NO_1_FAILED = 0b00000010;

    /**
     * @see #FIELD_NO_2_SUCCESS
     * @see #FIELD_NO_2_FAILED
     */
    public static final int FIELD_NO_2_MASK = 0b00000100;

    /**
     * 0: Field-No 2 Success
     */
    public static final int FIELD_NO_2_SUCCESS = 0b00000000;

    /**
     * 1: Field-No 2 Failed
     */
    public static final int FIELD_NO_2_FAILED = 0b00000100;

    /**
     * @see #FIELD_NO_3_SUCCESS
     * @see #FIELD_NO_3_FAILED
     */
    public static final int FIELD_NO_3_MASK = 0b00001000;

    /**
     * 0: Field-No 3 Success
     */
    public static final int FIELD_NO_3_SUCCESS = 0b00000000;

    /**
     * 1: Field-No 3 Failed
     */
    public static final int FIELD_NO_3_FAILED = 0b00001000;

    /**
     * @see #FIELD_NO_4_SUCCESS
     * @see #FIELD_NO_4_FAILED
     */
    public static final int FIELD_NO_4_MASK = 0b00010000;

    /**
     * 0: Field-No 4 Success
     */
    public static final int FIELD_NO_4_SUCCESS = 0b00000000;

    /**
     * 1: Field-No 4 Failed
     */
    public static final int FIELD_NO_4_FAILED = 0b00010000;

    /**
     * @see #FIELD_NO_5_SUCCESS
     * @see #FIELD_NO_5_FAILED
     */
    public static final int FIELD_NO_5_MASK = 0b00100000;

    /**
     * 0: Field-No 5 Success
     */
    public static final int FIELD_NO_5_SUCCESS = 0b00000000;

    /**
     * 1: Field-No 5 Failed
     */
    public static final int FIELD_NO_5_FAILED = 0b00100000;

    /**
     * @see #FIELD_NO_6_SUCCESS
     * @see #FIELD_NO_6_FAILED
     */
    public static final int FIELD_NO_6_MASK = 0b01000000;

    /**
     * 0: Field-No 6 Success
     */
    public static final int FIELD_NO_6_SUCCESS = 0b00000000;

    /**
     * 1: Field-No 6 Failed
     */
    public static final int FIELD_NO_6_FAILED = 0b01000000;

    /**
     * @see #FIELD_NO_7_SUCCESS
     * @see #FIELD_NO_7_FAILED
     */
    public static final int FIELD_NO_7_MASK = 0b10000000;

    /**
     * 0: Field-No 7 Success
     */
    public static final int FIELD_NO_7_SUCCESS = 0b00000000;

    /**
     * 1: Field-No 7 Failed
     */
    public static final int FIELD_NO_7_FAILED = 0b10000000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReconnectionConfigurationControlPoint> CREATOR = new ByteArrayCreater<ReconnectionConfigurationControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationControlPoint createFromParcel(@NonNull Parcel in) {
            return new ReconnectionConfigurationControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationControlPoint[] newArray(int size) {
            return new ReconnectionConfigurationControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReconnectionConfigurationControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ReconnectionConfigurationControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Opcode
     */
    private final int mOpcode;

    /**
     * Operand
     */
    private final byte[] mOperand;

    /**
     * E2E-CRC
     */
    private final Integer mE2eCrc;

    /**
     * Request Opcode
     */
    private final int mRequestOpcodes;

    /**
     * Result Codes
     */
    private final int mResultCode;

    /**
     * Result Parameter
     */
    private final byte[] mResultParameter;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1F
     */
    public ReconnectionConfigurationControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mOpcode = (values[0] & 0xff);
        if (isOpcodeEnableDisconnect(mOpcode)) {
            mOperand = new byte[0];
            if (values.length == 3) {
                mE2eCrc = BLEUtils.createUInt16(values, 1);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeGetActualCommunicationParameters(mOpcode)) {
            mOperand = new byte[0];
            if (values.length == 3) {
                mE2eCrc = BLEUtils.createUInt16(values, 1);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeProposeSettings(mOpcode)) {
            mOperand = Arrays.copyOfRange(values, 1, 17);
            if (values.length == 19) {
                mE2eCrc = BLEUtils.createUInt16(values, 17);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeActivateStoredSettings(mOpcode)) {
            mOperand = Arrays.copyOfRange(values, 1, 2);
            if (values.length == 4) {
                mE2eCrc = BLEUtils.createUInt16(values, 2);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeGetMaxValues(mOpcode)) {
            mOperand = new byte[0];
            if (values.length == 3) {
                mE2eCrc = BLEUtils.createUInt16(values, 1);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeGetMinValues(mOpcode)) {
            mOperand = new byte[0];
            if (values.length == 3) {
                mE2eCrc = BLEUtils.createUInt16(values, 1);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeGetStoredValues(mOpcode)) {
            mOperand = Arrays.copyOfRange(values, 1, 2);
            if (values.length == 4) {
                mE2eCrc = BLEUtils.createUInt16(values, 2);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeSetWhiteListTimer(mOpcode)) {
            mOperand = Arrays.copyOfRange(values, 1, 5);
            if (values.length == 7) {
                mE2eCrc = BLEUtils.createUInt16(values, 5);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeGetWhiteListTimer(mOpcode)) {
            mOperand = new byte[0];
            if (values.length == 3) {
                mE2eCrc = BLEUtils.createUInt16(values, 1);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeSetAdvertisementConfiguration(mOpcode)) {
            mOperand = Arrays.copyOfRange(values, 1, 2);
            if (values.length == 4) {
                mE2eCrc = BLEUtils.createUInt16(values, 2);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeUpgradeToLescOnly(mOpcode)) {
            mOperand = Arrays.copyOfRange(values, 1, 2);
            if (values.length == 4) {
                mE2eCrc = BLEUtils.createUInt16(values, 2);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeSwitchOobPairing(mOpcode)) {
            mOperand = Arrays.copyOfRange(values, 1, 2);
            if (values.length == 4) {
                mE2eCrc = BLEUtils.createUInt16(values, 2);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeLimitedAccess(mOpcode)) {
            mOperand = Arrays.copyOfRange(values, 1, 2);
            if (values.length == 4) {
                mE2eCrc = BLEUtils.createUInt16(values, 2);
            } else {
                mE2eCrc = null;
            }
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        } else if (isOpcodeProcedureResponse(mOpcode)) {
            mOperand = new byte[0];
            mRequestOpcodes = BLEUtils.createUInt8(values, 1);
            mResultCode = BLEUtils.createUInt8(values, 2);
            int offset = 3;
            if (isOpcodeProposeSettings(mRequestOpcodes)) {
                if (isResultCodeCommunicationParameterOutOfRange()) {
                    mResultParameter = Arrays.copyOfRange(values, offset, offset + 1);
                    offset++;
                } else if (isResultCodeInvalidParameterCombination()) {
                    mResultParameter = Arrays.copyOfRange(values, offset, offset + 1);
                    offset++;
                } else {
                    mResultParameter = new byte[0];
                }
            } else {
                mResultParameter = new byte[0];
            }
            if (values.length == offset + 2) {
                mE2eCrc = BLEUtils.createUInt16(values, offset);
            } else {
                mE2eCrc = null;
            }
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            mOperand = new byte[0];
            mRequestOpcodes = BLEUtils.createUInt8(values, 1);
            mResultCode = 0;
            mResultParameter = Arrays.copyOfRange(values, 2, 18);
            if (values.length == 20) {
                mE2eCrc = BLEUtils.createUInt16(values, 18);
            } else {
                mE2eCrc = null;
            }
        } else if (isOpcodeWhiteListTimerResponse(mOpcode)) {
            mOperand = new byte[0];
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = Arrays.copyOfRange(values, 1, 13);
            if (values.length == 15) {
                mE2eCrc = BLEUtils.createUInt16(values, 13);
            } else {
                mE2eCrc = null;
            }
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            mOperand = new byte[0];
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = Arrays.copyOfRange(values, 1, 17);
            if (values.length == 19) {
                mE2eCrc = BLEUtils.createUInt16(values, 17);
            } else {
                mE2eCrc = null;
            }
        } else {
            mOperand = new byte[0];
            mE2eCrc = null;
            mRequestOpcodes = 0;
            mResultCode = 0;
            mResultParameter = new byte[0];
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReconnectionConfigurationControlPoint(@NonNull Parcel in) {
        mOpcode = in.readInt();
        mOperand = in.createByteArray();
        if (in.readInt() == 0) {
            mE2eCrc = null;
        } else {
            mE2eCrc = in.readInt();
        }
        mRequestOpcodes = in.readInt();
        mResultCode = in.readInt();
        mResultParameter = in.createByteArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(mOpcode);
        dest.writeByteArray(mOperand);
        if (mE2eCrc == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(mE2eCrc);
        }
        dest.writeInt(mRequestOpcodes);
        dest.writeInt(mResultCode);
        dest.writeByteArray(mResultParameter);
    }

    /**
     * @return Opcode
     */
    public int getOpcode() {
        return mOpcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Enable Disconnect, {@code false}:not Enable Disconnect
     */
    public boolean isOpcodeEnableDisconnect(int opcode) {
        return OPCODE_ENABLE_DISCONNECT == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Get Actual Communication Parameters, {@code false}:not Get Actual Communication Parameters
     */
    public boolean isOpcodeGetActualCommunicationParameters(int opcode) {
        return OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Propose Settings, {@code false}:not Propose Settings
     */
    public boolean isOpcodeProposeSettings(int opcode) {
        return OPCODE_PROPOSE_SETTINGS == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Activate Stored Settings, {@code false}:not Activate Stored Settings
     */
    public boolean isOpcodeActivateStoredSettings(int opcode) {
        return OPCODE_ACTIVATE_STORED_SETTINGS == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Get Max Values, {@code false}:not Get Max Values
     */
    public boolean isOpcodeGetMaxValues(int opcode) {
        return OPCODE_GET_MAX_VALUES == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Get Min Values, {@code false}:not Get Min Values
     */
    public boolean isOpcodeGetMinValues(int opcode) {
        return OPCODE_GET_MIN_VALUES == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Get Stored Values, {@code false}:not Get Stored Values
     */
    public boolean isOpcodeGetStoredValues(int opcode) {
        return OPCODE_GET_STORED_VALUES == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Set White List Timer, {@code false}:not Set White List Timer
     */
    public boolean isOpcodeSetWhiteListTimer(int opcode) {
        return OPCODE_SET_WHITE_LIST_TIMER == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Get White List Timer, {@code false}:not Get White List Timer
     */
    public boolean isOpcodeGetWhiteListTimer(int opcode) {
        return OPCODE_GET_WHITE_LIST_TIMER == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Set Advertisement Configuration, {@code false}:not Set Advertisement Configuration
     */
    public boolean isOpcodeSetAdvertisementConfiguration(int opcode) {
        return OPCODE_SET_ADVERTISEMENT_CONFIGURATION == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Upgrade to LESC Only, {@code false}:not Upgrade to LESC Only
     */
    public boolean isOpcodeUpgradeToLescOnly(int opcode) {
        return OPCODE_UPGRADE_TO_LESC_ONLY == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Switch OOB Pairing, {@code false}:not Switch OOB Pairing
     */
    public boolean isOpcodeSwitchOobPairing(int opcode) {
        return OPCODE_SWITCH_OOB_PAIRING == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Limited Access, {@code false}:not Limited Access
     */
    public boolean isOpcodeLimitedAccess(int opcode) {
        return OPCODE_LIMITED_ACCESS == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Procedure Response, {@code false}:not Procedure Response
     */
    public boolean isOpcodeProcedureResponse(int opcode) {
        return OPCODE_PROCEDURE_RESPONSE == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Communication Parameter Response, {@code false}:not Communication Parameter Response
     */
    public boolean isOpcodeCommunicationParameterResponse(int opcode) {
        return OPCODE_COMMUNICATION_PARAMETER_RESPONSE == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:White List Timer Response, {@code false}:not White List Timer Response
     */
    public boolean isOpcodeWhiteListTimerResponse(int opcode) {
        return OPCODE_WHITE_LIST_TIMER_RESPONSE == opcode;
    }

    /**
     * @param opcode Opcode
     * @return {@code true}:Client Parameter Indication, {@code false}:not Client Parameter Indication
     */
    public boolean isOpcodeClientParameterIndication(int opcode) {
        return OPCODE_CLIENT_PARAMETER_INDICATION == opcode;
    }

    /**
     * @return Operand
     */
    public byte[] getOperand() {
        return mOperand;
    }

    /**
     * @return Reconnection Timeout
     */
    public int getReconnectionTimeout() {
        int reconnectionTimeout;
        if (isOpcodeProposeSettings(mOpcode)) {
            reconnectionTimeout = BLEUtils.createUInt16(mOperand, 0);
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            reconnectionTimeout = BLEUtils.createUInt16(mResultParameter, 0);
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            reconnectionTimeout = BLEUtils.createUInt16(mResultParameter, 0);
        } else {
            reconnectionTimeout = 0;
        }
        return reconnectionTimeout;
    }

    /**
     * @return {@code true}:Reconnection Timeout not be changed, {@code false}:Reconnection Timeout be changed
     */
    public boolean isReconnectionTimeoutNotBeChanged() {
        return isOpcodeProposeSettings(mOpcode) && PARAMETER_NOT_BE_CHANGED == getReconnectionTimeout();
    }

    /**
     * @return {@code true}:Reconnection timeout is disabled, {@code false}:Reconnection timeout is enabled
     */
    public boolean isReconnectionTimeoutDisabled() {
        return RECONNECTION_TIMEOUT_DISABLED == getReconnectionTimeout();
    }

    /**
     * @return Minimum Connection Interval
     */
    public int getMinimumConnectionInterval() {
        int minimumConnectionInterval;
        if (isOpcodeProposeSettings(mOpcode)) {
            minimumConnectionInterval = BLEUtils.createUInt16(mOperand, 2);
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            minimumConnectionInterval = BLEUtils.createUInt16(mResultParameter, 2);
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            minimumConnectionInterval = BLEUtils.createUInt16(mResultParameter, 2);
        } else {
            minimumConnectionInterval = 0;
        }
        return minimumConnectionInterval;
    }

    /**
     * @return Minimum Connection Interval(ms)
     */
    public double getMinimumConnectionIntervalMs() {
        return MINIMUM_CONNECTION_INTERVAL_RESOLUTION * getMinimumConnectionInterval();
    }


    /**
     * @return {@code true}:Minimum Connection Interval not be changed, {@code false}:Minimum Connection Interval be changed
     */
    public boolean isMinimumConnectionIntervalNotBeChanged() {
        return isOpcodeProposeSettings(mOpcode) && PARAMETER_NOT_BE_CHANGED == getMinimumConnectionInterval();
    }

    /**
     * @return Maximum Connection Interval
     */
    public int getMaximumConnectionInterval() {
        int maximumConnectionInterval;
        if (isOpcodeProposeSettings(mOpcode)) {
            maximumConnectionInterval = BLEUtils.createUInt16(mOperand, 4);
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            maximumConnectionInterval = BLEUtils.createUInt16(mResultParameter, 4);
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            maximumConnectionInterval = BLEUtils.createUInt16(mResultParameter, 4);
        } else {
            maximumConnectionInterval = 0;
        }
        return maximumConnectionInterval;
    }

    /**
     * @return Maximum Connection Interval(ms)
     */
    public double getMaximumConnectionIntervalMs() {
        return MAXIMUM_CONNECTION_INTERVAL_RESOLUTION * getMaximumConnectionInterval();
    }

    /**
     * @return {@code true}:Maximum Connection Interval not be changed, {@code false}:Maximum Connection Interval be changed
     */
    public boolean isMaximumConnectionIntervalNotBeChanged() {
        return isOpcodeProposeSettings(mOpcode) && PARAMETER_NOT_BE_CHANGED == getMaximumConnectionInterval();
    }

    /**
     * @return Slave Latency
     */
    public int getSlaveLatency() {
        int slaveLatency;
        if (isOpcodeProposeSettings(mOpcode)) {
            slaveLatency = BLEUtils.createUInt16(mOperand, 6);
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            slaveLatency = BLEUtils.createUInt16(mResultParameter, 6);
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            slaveLatency = BLEUtils.createUInt16(mResultParameter, 6);
        } else {
            slaveLatency = 0;
        }
        return slaveLatency;
    }

    /**
     * @return {@code true}:Slave Latencyl not be changed, {@code false}:Slave Latency be changed
     */
    public boolean isSlaveLatencyNotBeChanged() {
        return isOpcodeProposeSettings(mOpcode) && PARAMETER_NOT_BE_CHANGED == getSlaveLatency();
    }

    /**
     * @return Supervision Timeout multiplier
     */
    public int getSupervisionTimeoutMultiplier() {
        int supervisionTimeoutMultiplier;
        if (isOpcodeProposeSettings(mOpcode)) {
            supervisionTimeoutMultiplier = BLEUtils.createUInt16(mOperand, 8);
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            supervisionTimeoutMultiplier = BLEUtils.createUInt16(mResultParameter, 8);
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            supervisionTimeoutMultiplier = BLEUtils.createUInt16(mResultParameter, 8);
        } else {
            supervisionTimeoutMultiplier = 0;
        }
        return supervisionTimeoutMultiplier;
    }

    /**
     * @return Supervision Timeout multiplier(ms)
     */
    public double getSupervisionTimeoutMultiplierMs() {
        return SUPERVISION_TIMEOUT_MULTIPLIER_RESOLUTION * getSupervisionTimeoutMultiplier();
    }

    /**
     * @return {@code true}:Supervision Timeout multiplier not be changed, {@code false}:Supervision Timeout multiplier be changed
     */
    public boolean isSupervisionTimeoutMultiplierNotBeChanged() {
        return isOpcodeProposeSettings(mOpcode) && PARAMETER_NOT_BE_CHANGED == getSupervisionTimeoutMultiplier();
    }

    /**
     * @return Advertisement Interval
     */
    public int getAdvertisementInterval() {
        int advertisementInterval;
        if (isOpcodeProposeSettings(mOpcode)) {
            advertisementInterval = BLEUtils.createUInt16(mOperand, 10);
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            advertisementInterval = BLEUtils.createUInt16(mResultParameter, 10);
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            advertisementInterval = BLEUtils.createUInt16(mResultParameter, 10);
        } else {
            advertisementInterval = 0;
        }
        return advertisementInterval;
    }

    /**
     * @return Advertisement Interval(ms)
     */
    public double getAdvertisementIntervalMs() {
        return ADVERTISEMENT_INTERVAL_RESOLUTION * getAdvertisementInterval();
    }

    /**
     * @return {@code true}:Advertisement Interval not be changed, {@code false}:Advertisement Interval be changed
     */
    public boolean isAdvertisementIntervalNotBeChanged() {
        return isOpcodeProposeSettings(mOpcode) && PARAMETER_NOT_BE_CHANGED == getAdvertisementInterval();
    }

    /**
     * @return Advertisement Count
     */
    public int getAdvertisementCount() {
        int advertisementCount;
        if (isOpcodeProposeSettings(mOpcode)) {
            advertisementCount = BLEUtils.createUInt16(mOperand, 12);
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            advertisementCount = BLEUtils.createUInt16(mResultParameter, 12);
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            advertisementCount = BLEUtils.createUInt16(mResultParameter, 12);
        } else {
            advertisementCount = 0;
        }
        return advertisementCount;
    }

    /**
     * @return {@code true}:Advertisement Count not be changed, {@code false}:Advertisement Count be changed
     */
    public boolean isAdvertisementCountNotBeChanged() {
        return isOpcodeProposeSettings(mOpcode) && PARAMETER_NOT_BE_CHANGED == getAdvertisementCount();
    }

    /**
     * @return Advertisement Repetition Time
     */
    public int getAdvertisementRepetitionTime() {
        int advertisementRepetitionTime;
        if (isOpcodeProposeSettings(mOpcode)) {
            advertisementRepetitionTime = BLEUtils.createUInt16(mOperand, 14);
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            advertisementRepetitionTime = BLEUtils.createUInt16(mResultParameter, 14);
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            advertisementRepetitionTime = BLEUtils.createUInt16(mResultParameter, 14);
        } else {
            advertisementRepetitionTime = 0;
        }
        return advertisementRepetitionTime;
    }

    /**
     * @return {@code true}:Advertisement Repetition Time not be changed, {@code false}:Advertisement Repetition Time be changed
     */
    public boolean isAdvertisementRepetitionTimeNotBeChanged() {
        return isOpcodeProposeSettings(mOpcode) && PARAMETER_NOT_BE_CHANGED == getAdvertisementRepetitionTime();
    }



    /**
     * @return {@code Activate Stored Settings}:Parameter-Set, {@code Get Stored Values}:Parameter-Set, {@code otherwise}:-1
     */
    public int getParameterSet() {
        int parameterSet;
        if (isOpcodeActivateStoredSettings(mOpcode)) {
            parameterSet = BLEUtils.createUInt8(mOperand, 0);
        } else if (isOpcodeGetStoredValues(mOpcode)) {
            parameterSet = BLEUtils.createUInt8(mOperand, 0);
        } else {
            parameterSet = -1;
        }
        return parameterSet;
    }

    /**
     * @return {@code Set White List Timer}:White List Timer, {@code White List Timer Response}:White List Timer, {@code otherwise}:-1
     */
    public long getWhiteListTimer() {
        long whiteListTimer;
        if (isOpcodeSetWhiteListTimer(mOpcode)) {
            whiteListTimer = BLEUtils.createUInt32(mOperand, 0);
        } else if (isOpcodeWhiteListTimerResponse(mOpcode)) {
            whiteListTimer = BLEUtils.createUInt32(mResultParameter, 0);
        } else {
            whiteListTimer = -1;
        }
        return whiteListTimer;
    }

    /**
     * {@code White List Timer Response}:Min White List Timer, {@code otherwise}:-1
     */
    public long getMinWhiteListTimer() {
        long whiteListTimer;
        if (isOpcodeWhiteListTimerResponse(mOpcode)) {
            whiteListTimer = BLEUtils.createUInt32(mResultParameter, 4);
        } else {
            whiteListTimer = -1;
        }
        return whiteListTimer;
    }

    /**
     * {@code White List Timer Response}:tMax White List Timer, {@code otherwise}:-1
     */
    public long getMaxWhiteListTimer() {
        long whiteListTimer;
        if (isOpcodeWhiteListTimerResponse(mOpcode)) {
            whiteListTimer = BLEUtils.createUInt32(mResultParameter, 8);
        } else {
            whiteListTimer = -1;
        }
        return whiteListTimer;
    }

    /**
     * @return {@code true}:The functionality of White List then is disabled, {@code false}:The functionality of White List then is enabled
     */
    public boolean isWhiteListDisabled() {
        boolean isWhiteListDisabled;
        if (isOpcodeSetWhiteListTimer(mOpcode)) {
            isWhiteListDisabled = WHITE_LIST_DISABLED == getWhiteListTimer();
        } else if (isOpcodeWhiteListTimerResponse(mOpcode)) {
            isWhiteListDisabled = WHITE_LIST_DISABLED == getWhiteListTimer();
        } else {
            isWhiteListDisabled = false;
        }
        return isWhiteListDisabled;
    }

    /**
     * @return {@code true}:The functionality of the Whit List Timer is disabled, {@code false}:The functionality of the Whit List Timer is enabled
     */
    public boolean isWhiteListTimerDisabled() {
        boolean isWhiteListTimerDisabled;
        if (isOpcodeSetWhiteListTimer(mOpcode)) {
            isWhiteListTimerDisabled = WHITE_LIST_TIMER_DISABLED == BLEUtils.createUInt32(mOperand, 0);
        } else if (isOpcodeWhiteListTimerResponse(mOpcode)) {
            isWhiteListTimerDisabled = WHITE_LIST_TIMER_DISABLED == BLEUtils.createUInt32(mResultParameter, 0);
        } else {
            isWhiteListTimerDisabled = false;
        }
        return isWhiteListTimerDisabled;
    }

    /**
     * @return {@code true}:Advertisement Configuration 1, {@code false}:not Advertisement Configuration 1
     */
    public boolean isAdvertisementConfiguration1() {
        boolean isAdvertisementConfiguration1;
        if (isOpcodeSetAdvertisementConfiguration(mOpcode)) {
            isAdvertisementConfiguration1 = ADVERTISEMENT_CONFIGURATION_1 == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isAdvertisementConfiguration1 = false;
        }
        return isAdvertisementConfiguration1;
    }

    /**
     * @return {@code true}:Advertisement Configuration 2, {@code false}:not Advertisement Configuration 2
     */
    public boolean isAdvertisementConfiguration2() {
        boolean isAdvertisementConfiguration2;
        if (isOpcodeSetAdvertisementConfiguration(mOpcode)) {
            isAdvertisementConfiguration2 = ADVERTISEMENT_CONFIGURATION_2 == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isAdvertisementConfiguration2 = false;
        }
        return isAdvertisementConfiguration2;
    }

    /**
     * @return {@code true}:Advertisement Configuration 3, {@code false}:not Advertisement Configuration 3
     */
    public boolean isAdvertisementConfiguration3() {
        boolean isAdvertisementConfiguration3;
        if (isOpcodeSetAdvertisementConfiguration(mOpcode)) {
            isAdvertisementConfiguration3 = ADVERTISEMENT_CONFIGURATION_3 == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isAdvertisementConfiguration3 = false;
        }
        return isAdvertisementConfiguration3;
    }

    /**
     * @return {@code true}:Advertisement Configuration 4, {@code false}:not Advertisement Configuration 4
     */
    public boolean isAdvertisementConfiguration4() {
        boolean isAdvertisementConfiguration4;
        if (isOpcodeSetAdvertisementConfiguration(mOpcode)) {
            isAdvertisementConfiguration4 = ADVERTISEMENT_CONFIGURATION_4 == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isAdvertisementConfiguration4 = false;
        }
        return isAdvertisementConfiguration4;
    }

    /**
     * @return {@code true}:Upgrade to LESC Only False, {@code false}:not Upgrade to LESC Only False
     */
    public boolean isUpgradeToLescOnlyFalse() {
        boolean isIpgradeToLescOnlyFalse;
        if (isOpcodeUpgradeToLescOnly(mOpcode)) {
            isIpgradeToLescOnlyFalse = UPGRADE_TO_LESC_ONLY_FALSE == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isIpgradeToLescOnlyFalse = false;
        }
        return isIpgradeToLescOnlyFalse;
    }

    /**
     * @return {@code true}:Upgrade to LESC Only True, {@code false}:not Upgrade to LESC Only True
     */
    public boolean isUpgradeToLescOnlyTrue() {
        boolean isIpgradeToLescOnlyTrue;
        if (isOpcodeUpgradeToLescOnly(mOpcode)) {
            isIpgradeToLescOnlyTrue = UPGRADE_TO_LESC_ONLY_TRUE == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isIpgradeToLescOnlyTrue = false;
        }
        return isIpgradeToLescOnlyTrue;
    }

    /**
     * @return {@code true}:Switch OOB Pairing False, {@code false}:not Switch OOB Pairing False
     */
    public boolean isSwitchOobPairingFalse() {
        boolean isSwitchOobPairingFalse;
        if (isOpcodeSwitchOobPairing(mOpcode)) {
            isSwitchOobPairingFalse = SWITCH_OOB_PAIRING_FALSE == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isSwitchOobPairingFalse = false;
        }
        return isSwitchOobPairingFalse;
    }

    /**
     * @return {@code true}:Switch OOB Pairing True, {@code false}:not Switch OOB Pairing True
     */
    public boolean isSwitchOobPairingTrue() {
        boolean isSwitchOobPairingTrue;
        if (isOpcodeSwitchOobPairing(mOpcode)) {
            isSwitchOobPairingTrue = SWITCH_OOB_PAIRING_TRUE == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isSwitchOobPairingTrue = false;
        }
        return isSwitchOobPairingTrue;
    }

    /**
     * @return {@code true}:Limited Access False, {@code false}:not Limited Access False
     */
    public boolean isLimitedAccessFalse() {
        boolean isLimitedAccessFalse;
        if (isOpcodeLimitedAccess(mOpcode)) {
            isLimitedAccessFalse = LIMITED_ACCESS_FALSE == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isLimitedAccessFalse = false;
        }
        return isLimitedAccessFalse;
    }

    /**
     * @return {@code true}:Limited Access True, {@code false}:not Limited Access True
     */
    public boolean isLimitedAccessTrue() {
        boolean isLimitedAccessTrue;
        if (isOpcodeLimitedAccess(mOpcode)) {
            isLimitedAccessTrue = LIMITED_ACCESS_TRUE == BLEUtils.createUInt8(mOperand, 0);
        } else {
            isLimitedAccessTrue = false;
        }
        return isLimitedAccessTrue;
    }

    /**
     * @return {@code true}:Success on Field No 0, {@code false}:Communication Parameter out of range or Invalid Parameter combination on Field No 0
     */
    public boolean isFieldNo0Success() {
        return isFieldNoMatched(FIELD_NO_0_MASK, FIELD_NO_0_SUCCESS);
    }

    /**
     * @return {@code true}:Communication Parameter out of range or Invalid Parameter combination on Field No 0, {@code false}:Success on Field No 0
     */
    public boolean isFieldNo0Failed() {
        return isFieldNoMatched(FIELD_NO_0_MASK, FIELD_NO_0_FAILED);
    }

    /**
     * @return {@code true}:Success on Field No 1, {@code false}:Communication Parameter out of range or Invalid Parameter combination on Field No 1
     */
    public boolean isFieldNo1Success() {
        return isFieldNoMatched(FIELD_NO_1_MASK, FIELD_NO_1_SUCCESS);
    }

    /**
     * @return {@code true}:Communication Parameter out of range or Invalid Parameter combination on Field No 1, {@code false}:Success on Field No 1
     */
    public boolean isFieldNo1Failed() {
        return isFieldNoMatched(FIELD_NO_1_MASK, FIELD_NO_1_FAILED);
    }

    /**
     * @return {@code true}:Success on Field No 2, {@code false}:Communication Parameter out of range or Invalid Parameter combination on Field No 2
     */
    public boolean isFieldNo2Success() {
        return isFieldNoMatched(FIELD_NO_2_MASK, FIELD_NO_2_SUCCESS);
    }

    /**
     * @return {@code true}:Communication Parameter out of range or Invalid Parameter combination on Field No 2, {@code false}:Success on Field No 2
     */
    public boolean isFieldNo2Failed() {
        return isFieldNoMatched(FIELD_NO_2_MASK, FIELD_NO_2_FAILED);
    }

    /**
     * @return {@code true}:Success on Field No 3, {@code false}:Communication Parameter out of range or Invalid Parameter combination on Field No 3
     */
    public boolean isFieldNo3Success() {
        return isFieldNoMatched(FIELD_NO_3_MASK, FIELD_NO_3_SUCCESS);
    }

    /**
     * @return {@code true}:Communication Parameter out of range or Invalid Parameter combination on Field No 3, {@code false}:Success on Field No 3
     */
    public boolean isFieldNo3Failed() {
        return isFieldNoMatched(FIELD_NO_3_MASK, FIELD_NO_3_FAILED);
    }

    /**
     * @return {@code true}:Success on Field No 4, {@code false}:Communication Parameter out of range or Invalid Parameter combination on Field No 4
     */
    public boolean isFieldNo4Success() {
        return isFieldNoMatched(FIELD_NO_4_MASK, FIELD_NO_4_SUCCESS);
    }

    /**
     * @return {@code true}:Communication Parameter out of range or Invalid Parameter combination on Field No 4, {@code false}:Success on Field No 4
     */
    public boolean isFieldNo4Failed() {
        return isFieldNoMatched(FIELD_NO_4_MASK, FIELD_NO_4_FAILED);
    }

    /**
     * @return {@code true}:Success on Field No 5, {@code false}:Communication Parameter out of range or Invalid Parameter combination on Field No 5
     */
    public boolean isFieldNo5Success() {
        return isFieldNoMatched(FIELD_NO_5_MASK, FIELD_NO_5_SUCCESS);
    }

    /**
     * @return {@code true}:Communication Parameter out of range or Invalid Parameter combination on Field No 5, {@code false}:Success on Field No 5
     */
    public boolean isFieldNo5Failed() {
        return isFieldNoMatched(FIELD_NO_5_MASK, FIELD_NO_5_FAILED);
    }

    /**
     * @return {@code true}:Success on Field No 6, {@code false}:Communication Parameter out of range or Invalid Parameter combination on Field No 6
     */
    public boolean isFieldNo6Success() {
        return isFieldNoMatched(FIELD_NO_6_MASK, FIELD_NO_6_SUCCESS);
    }

    /**
     * @return {@code true}:Communication Parameter out of range or Invalid Parameter combination on Field No 6, {@code false}:Success on Field No 6
     */
    public boolean isFieldNo6Failed() {
        return isFieldNoMatched(FIELD_NO_6_MASK, FIELD_NO_6_FAILED);
    }

    /**
     * @return {@code true}:Success on Field No 7, {@code false}:Communication Parameter out of range or Invalid Parameter combination on Field No 7
     */
    public boolean isFieldNo7Success() {
        return isFieldNoMatched(FIELD_NO_7_MASK, FIELD_NO_7_SUCCESS);
    }

    /**
     * @return {@code true}:Communication Parameter out of range or Invalid Parameter combination on Field No 7, {@code false}:Success on Field No 7
     */
    public boolean isFieldNo7Failed() {
        return isFieldNoMatched(FIELD_NO_7_MASK, FIELD_NO_7_FAILED);
    }


    /**
     * @return E2E-CRC
     */
    @Nullable
    public Integer getE2eCrc() {
        return mE2eCrc;
    }

    /**
     * @return Request Opcode
     */
    public int getRequestOpcodes() {
        return mRequestOpcodes;
    }

    /**
     * @return Result Codes
     */
    public int getResultCode() {
        return mResultCode;
    }

    /**
     * @return {@code true}:Success, {@code false}:not Success
     */
    public boolean isResultCodeSuccess() {
        return RESULT_CODE_SUCCESS == mResultCode;
    }

    /**
     * @return {@code true}:Opcode not supported, {@code false}:not Opcode not supported
     */
    public boolean isResultCodeOpcodeNotSupported() {
        return RESULT_CODE_OPCODE_NOT_SUPPORTED == mResultCode;
    }

    /**
     * @return {@code true}:Invalid Operand, {@code false}:not Invalid Operand
     */
    public boolean isResultCodeInvalidOperand() {
        return RESULT_CODE_INVALID_OPERAND == mResultCode;
    }

    /**
     * @return {@code true}:Operation failed, {@code false}:not Operation failed
     */
    public boolean isResultCodeOperationFailed() {
        return RESULT_CODE_OPERATION_FAILED == mResultCode;
    }

    /**
     * @return {@code true}:Communication Parameter out of range, {@code false}:not Communication Parameter out of range
     */
    public boolean isResultCodeCommunicationParameterOutOfRange() {
        return RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE == mResultCode;
    }

    /**
     * @return {@code true}:Invalid Parameter combination, {@code false}:not Invalid Parameter combination
     */
    public boolean isResultCodeInvalidParameterCombination() {
        return RESULT_CODE_INVALID_PARAMETER_COMBINATION == mResultCode;
    }

    /**
     * @return {@code true}:Device Busy, {@code false}:not Device Busy
     */
    public boolean isResultCodeDeviceBusy() {
        return RESULT_CODE_DEVICE_BUSY == mResultCode;
    }

    /**
     * @return {@code true}:Communication Parameters rejected, {@code false}:not Communication Parameters rejected
     */
    public boolean isResultCodeCommunicationParametersRejected() {
        return RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED == mResultCode;
    }

    /**
     * @return {@code true}:Proposal Accepted, {@code false}:not Proposal Accepted
     */
    public boolean isResultCodeProposalAccepted() {
        return RESULT_CODE_PROPOSAL_ACCEPTED == mResultCode;
    }

    /**
     * @return Result Parameter
     */
    public byte[] getResultParameter() {
        return mResultParameter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[20];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mOpcode);
        length++;
        byteBuffer.put(mOperand);
        length += mOperand.length;
        if (isOpcodeProcedureResponse(mOpcode)) {
            byteBuffer.put((byte) mRequestOpcodes);
            length++;
            byteBuffer.put((byte) mResultCode);
            length++;
            if (isOpcodeProposeSettings(mRequestOpcodes)) {
                if (isResultCodeCommunicationParameterOutOfRange()) {
                    byteBuffer.put(mResultParameter);
                    length += mResultParameter.length;
                } else if (isResultCodeInvalidParameterCombination()) {
                    byteBuffer.put(mResultParameter);
                    length += mResultParameter.length;
                }
            }
        } else if (isOpcodeCommunicationParameterResponse(mOpcode)) {
            byteBuffer.put((byte) mRequestOpcodes);
            length++;
            byteBuffer.put(mResultParameter);
            length += mResultParameter.length;
        } else if (isOpcodeWhiteListTimerResponse(mOpcode)) {
            byteBuffer.put(mResultParameter);
            length += mResultParameter.length;
        } else if (isOpcodeClientParameterIndication(mOpcode)) {
            byteBuffer.put(mResultParameter);
            length += mResultParameter.length;
        }
        if (mE2eCrc != null) {
            byteBuffer.putShort(mE2eCrc.shortValue());
            length += 2;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Field No
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FIELD_NO_0_SUCCESS}
     *               , {@link #FIELD_NO_0_FAILED}
     *               , {@link #FIELD_NO_1_SUCCESS}
     *               , {@link #FIELD_NO_1_FAILED}
     *               , {@link #FIELD_NO_2_SUCCESS}
     *               , {@link #FIELD_NO_2_FAILED}
     *               , {@link #FIELD_NO_3_SUCCESS}
     *               , {@link #FIELD_NO_3_FAILED}
     *               , {@link #FIELD_NO_4_SUCCESS}
     *               , {@link #FIELD_NO_4_FAILED}
     *               , {@link #FIELD_NO_5_SUCCESS}
     *               , {@link #FIELD_NO_5_FAILED}
     *               , {@link #FIELD_NO_6_SUCCESS}
     *               , {@link #FIELD_NO_6_FAILED}
     *               , {@link #FIELD_NO_7_SUCCESS}
     *               , {@link #FIELD_NO_7_FAILED}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFieldNoMatched(int mask, int expect) {
        return (mask & BLEUtils.createUInt8(mResultParameter, 0)) == expect;
    }

}
