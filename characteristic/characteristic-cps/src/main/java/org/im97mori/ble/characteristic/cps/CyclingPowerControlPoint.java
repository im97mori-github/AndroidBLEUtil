package org.im97mori.ble.characteristic.cps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;

/**
 * Cycling Power Control Point (Characteristics UUID: 0x2A66)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CyclingPowerControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 1: Set Cumulative Value
     */
    public static final int OP_CODES_SET_CUMULATIVE_VALUE = 1;

    /**
     * 2: Update Sensor Location
     */
    public static final int OP_CODES_UPDATE_SENSOR_LOCATION = 2;

    /**
     * 3: Request Supported Sensor Locations
     */
    public static final int OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION = 3;

    /**
     * 4: Set Crank Length
     */
    public static final int OP_CODES_SET_CRANK_LENGTH = 4;

    /**
     * 5: Request Crank Length
     */
    public static final int OP_CODES_REQUEST_CRANK_LENGTH = 5;

    /**
     * 6: Set Chain Length
     */
    public static final int OP_CODES_SET_CHAIN_LENGTH = 6;

    /**
     * 7: Request Chain Length
     */
    public static final int OP_CODES_REQUEST_CHAIN_LENGTH = 7;

    /**
     * 8: Set Chain Weight
     */
    public static final int OP_CODES_SET_CHAIN_WEIGHT = 8;

    /**
     * 9: Request Chain Weight
     */
    public static final int OP_CODES_REQUEST_CHAIN_WEIGHT = 9;

    /**
     * 10: Set Span Length
     */
    public static final int OP_CODES_SET_SPAN_LENGTH = 10;

    /**
     * 11: Request Span Length
     */
    public static final int OP_CODES_REQUEST_SPAN_LENGTH = 11;

    /**
     * 12: Start Offset Compensation
     */
    public static final int OP_CODES_START_OFFSET_COMPENSATION = 12;

    /**
     * 13: Mask Cycling Power Measurement Characteristic Content
     */
    public static final int OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT = 13;

    /**
     * 14: Request Sampling Rate
     */
    public static final int OP_CODES_REQUEST_SAMPLING_RATE = 14;

    /**
     * 15: Request Factory Calibration Date
     */
    public static final int OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE = 15;

    /**
     * 16: Start Enhanced Offset Compensation
     */
    public static final int OP_CODES_START_ENHANCED_OFFSET_COMPENSATION = 16;

    /**
     * 32: Response Code
     */
    public static final int OP_CODES_RESPONSE_CODE = 32;

    /**
     * 1: Success
     */
    public static final int RESPONSE_VALUE_SUCCESS = 1;

    /**
     * 2: Op Code not Supported
     */
    public static final int RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED = 2;

    /**
     * 3: Invalid Parameter
     */
    public static final int RESPONSE_VALUE_INVALID_PARAMETER = 3;

    /**
     * 4: Operation Failed
     */
    public static final int RESPONSE_VALUE_OPERATION_FAILED = 4;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_MASK = 0b00000000_00000001;

    /**
     * 0: Pedal Power Balance Leave as default
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * 1: Pedal Power Balance Turn off
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_TURN_OFF = 0b00000000_00000001;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_MASK = 0b00000000_00000010;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 0: Accumulated Torque Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 1: Accumulated Torque Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_TURN_OFF = 0b00000000_00000010;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_MASK = 0b00000000_00000100;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 0: Wheel Revolution Data Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 1: Wheel Revolution Data Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_TURN_OFF = 0b00000000_00000100;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_MASK = 0b00000000_00001000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 0: Crank Revolution Data Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 1: Crank Revolution Data Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_TURN_OFF = 0b00000000_00001000;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_MASK = 0b00000000_00010000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 0: Extreme Magnitudes Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 1: Extreme Magnitudes Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_TURN_OFF = 0b00000000_00010000;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_MASK = 0b00000000_00100000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 0: Extreme Angles Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 1: Extreme Angles Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_TURN_OFF = 0b00000000_00100000;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_MASK = 0b00000000_01000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 0: Top Dead Spot Angle Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 1: Top Dead Spot Angle Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_TURN_OFF = 0b00000000_01000000;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_MASK = 0b00000000_10000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 0: Bottom Dead Spot Angle Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 1: Bottom Dead Spot Angle Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_TURN_OFF = 0b00000000_10000000;

    /**
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_MASK = 0b00000001_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 0: Accumulated Energy Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Cycling Power Measurement Characteristic Content
     * 1: Accumulated Energy Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_TURN_OFF = 0b00000001_00000000;

    /**
     * <p>
     * Start Enhanced Offset Compensation
     * 0x01: Incorrect calibration position
     * </p>
     */
    public static final int PARAMETER_VALUE_START_ENHANCED_OFFET_COMPENSATION_INCORRECT_CALIBRATION_POSITION = 0x01;

    /**
     * <p>
     * Start Enhanced Offset Compensation
     * 0xff: Manufacturer specific error follows
     * </p>
     */
    public static final int PARAMETER_VALUE_START_ENHANCED_OFFET_COMPENSATION_MANUFACTURER_SPECIFIC_ERROR_FOLLOWS = 0xFF;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CyclingPowerControlPoint> CREATOR = new ByteArrayCreater<CyclingPowerControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerControlPoint createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerControlPoint[] newArray(int size) {
            return new CyclingPowerControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CyclingPowerControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Op Codes
     */
    private final int mOpCodes;

    /**
     * Parameter Value
     */
    private final byte[] mParameterValue;

    /**
     * Request Op Code
     */
    private final int mRequestOpCode;

    /**
     * Response Value
     */
    private final int mResponseValue;

    /**
     * Response Parameter
     */
    private final byte[] mResponseParameter;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A66
     */
    public CyclingPowerControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mOpCodes = (values[0] & 0xff);
        if (isOpCodesSetCumulativeValue(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 5);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesUpdateSensorLocation(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 2);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestSupportedSensorLocations(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesSetCrankLength(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestCrankLength(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesSetChainLength(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestChainLength(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesSetChainWeight(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestChainWeight(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesSetSpanLength(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestSpanLength(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesStartOffsetCompensation(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestSamplingRate(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestFactoryCalibrationDate(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesStartEnhancedOffsetCompensation(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesResponseCode(mOpCodes)) {
            mParameterValue = new byte[0];
            mRequestOpCode = (values[1] & 0xff);
            mResponseValue = (values[2] & 0xff);
            if (isOpCodesRequestSupportedSensorLocations(mRequestOpCode)) {
                if (isResponseValueSuccess()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, values.length);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else if (isOpCodesRequestCrankLength(mRequestOpCode)) {
                if (isResponseValueSuccess()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, 5);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else if (isOpCodesRequestChainLength(mRequestOpCode)) {
                if (isResponseValueSuccess()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, 5);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else if (isOpCodesRequestChainWeight(mRequestOpCode)) {
                if (isResponseValueSuccess()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, 5);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else if (isOpCodesRequestSpanLength(mRequestOpCode)) {
                if (isResponseValueSuccess()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, 5);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else if (isOpCodesRequestSamplingRate(mRequestOpCode)) {
                if (isResponseValueSuccess()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, 4);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else if (isOpCodesRequestFactoryCalibrationDate(mRequestOpCode)) {
                if (isResponseValueSuccess()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, 10);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else if (isOpCodesStartEnhancedOffsetCompensation(mRequestOpCode)) {
                if (isResponseValueSuccess()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, values.length);
                } else if (isResponseValueOperationFailed()) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, values.length);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else {
                mResponseParameter = new byte[0];
            }
        } else {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CyclingPowerControlPoint(@NonNull Parcel in) {
        mOpCodes = in.readInt();
        mParameterValue = in.createByteArray();
        mRequestOpCode = in.readInt();
        mResponseValue = in.readInt();
        mResponseParameter = in.createByteArray();
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
        dest.writeInt(mOpCodes);
        dest.writeByteArray(mParameterValue);
        dest.writeInt(mRequestOpCode);
        dest.writeInt(mResponseValue);
        dest.writeByteArray(getResponseParameter());
    }

    /**
     * @return Op Codes
     */
    public int getOpCodes() {
        return mOpCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Set Cumulative Value, {@code false}:not Set Cumulative Value
     */
    public boolean isOpCodesSetCumulativeValue(int opCodes) {
        return OP_CODES_SET_CUMULATIVE_VALUE == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Update Sensor Location, {@code false}:not Update Sensor Location
     */
    public boolean isOpCodesUpdateSensorLocation(int opCodes) {
        return OP_CODES_UPDATE_SENSOR_LOCATION == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Request Supported Sensor Locations, {@code false}:not Request Supported Sensor Locations
     */
    public boolean isOpCodesRequestSupportedSensorLocations(int opCodes) {
        return OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Set Crank Length, {@code false}:not Set Crank Length
     */
    public boolean isOpCodesSetCrankLength(int opCodes) {
        return OP_CODES_SET_CRANK_LENGTH == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Request Crank Length, {@code false}:not Request Crank Length
     */
    public boolean isOpCodesRequestCrankLength(int opCodes) {
        return OP_CODES_REQUEST_CRANK_LENGTH == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Set Chain Length, {@code false}:not Set Chain Length
     */
    public boolean isOpCodesSetChainLength(int opCodes) {
        return OP_CODES_SET_CHAIN_LENGTH == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Request Chain Length, {@code false}:not Request Chain Length
     */
    public boolean isOpCodesRequestChainLength(int opCodes) {
        return OP_CODES_REQUEST_CHAIN_LENGTH == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Set Chain Weight, {@code false}:not Set Chain Weight
     */
    public boolean isOpCodesSetChainWeight(int opCodes) {
        return OP_CODES_SET_CHAIN_WEIGHT == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Request Chain Weight, {@code false}:not Request Chain Weight
     */
    public boolean isOpCodesRequestChainWeight(int opCodes) {
        return OP_CODES_REQUEST_CHAIN_WEIGHT == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Set Span Length, {@code false}:not Set Span Length
     */
    public boolean isOpCodesSetSpanLength(int opCodes) {
        return OP_CODES_SET_SPAN_LENGTH == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Request Span Length, {@code false}:not Request Span Length
     */
    public boolean isOpCodesRequestSpanLength(int opCodes) {
        return OP_CODES_REQUEST_SPAN_LENGTH == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Start Offset Compensation, {@code false}:not Start Offset Compensation
     */
    public boolean isOpCodesStartOffsetCompensation(int opCodes) {
        return OP_CODES_START_OFFSET_COMPENSATION == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Mask Cycling Power Measurement Characteristic Content, {@code false}:not Mask Cycling Power Measurement Characteristic Content
     */
    public boolean isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(int opCodes) {
        return OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Request Sampling Rate, {@code false}:not Request Sampling Rate
     */
    public boolean isOpCodesRequestSamplingRate(int opCodes) {
        return OP_CODES_REQUEST_SAMPLING_RATE == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Request Factory Calibration Date, {@code false}:not Request Factory Calibration Date
     */
    public boolean isOpCodesRequestFactoryCalibrationDate(int opCodes) {
        return OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Start Enhanced Offset Compensation, {@code false}:not Start Enhanced Offset Compensation
     */
    public boolean isOpCodesStartEnhancedOffsetCompensation(int opCodes) {
        return OP_CODES_START_ENHANCED_OFFSET_COMPENSATION == opCodes;
    }

    /**
     * @param opCodes Op Codes
     * @return {@code true}:Response Code, {@code false}:not Response Code
     */
    public boolean isOpCodesResponseCode(int opCodes) {
        return OP_CODES_RESPONSE_CODE == opCodes;
    }

    /**
     * @return Parameter Value
     */
    public byte[] getParameterValue() {
        return mParameterValue;
    }

    /**
     * @return {@code true}:Pedal Power Balance Leave as default, {@code false}:not Pedal Power Balance Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentPedalPowerBalanceLeaveAsDefault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Pedal Power Balance Turn off, {@code false}:not Pedal Power Balance Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentPedalPowerBalanceTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Accumulated Torque Leave as default, {@code false}:not Accumulated Torque Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedTorqueLeaveAsDfault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Accumulated Torque Turn off, {@code false}:not Accumulated Torque Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedTorqueTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Wheel Revolution Data Leave as default, {@code false}:not Wheel Revolution Data Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentWheelRevolutionDataLeaveAsDefault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Wheel Revolution Data Turn off, {@code false}:not Wheel Revolution Data Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentWheelRevolutionDataTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Crank Revolution Data Leave as default, {@code false}:not Crank Revolution Data Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentCrankRevolutionDataLeaveAsDefault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Crank Revolution Data Turn off, {@code false}:not Crank Revolution Data Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentCrankRevolutionDataTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Extreme Magnitudes Leave as default, {@code false}:not Extreme Magnitudes Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeMagnitudesLeaveAsDefault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Extreme Magnitudes Turn off, {@code false}:not Extreme Magnitudes Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeMagnitudesTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Extreme Angles Leave as default, {@code false}:not Extreme Angles Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeAnglesLeaveAsDefault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Extreme Angles Turn off, {@code false}:not Extreme Angles Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeAnglesTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Top Dead Spot Angle Leave as default, {@code false}:not Top Dead Spot Angle Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentTopDeadSpotAngleLeaveAsDefault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Top Dead Spot Angle Turn off, {@code false}:not Top Dead Spot Angle Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentTopDeadSpotAngleTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Bottom Dead Spot Angle Leave as default, {@code false}:not Bottom Dead Spot Angle Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentBottomDeadSpotAngleLeaveAsDefault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Bottom Dead Spot Angle Turn off, {@code false}:not Bottom Dead Spot Angle Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentBottomDeadSpotAngleTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Accumulated Energy Leave as default, {@code false}:not Accumulated Energy Leave as default
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedEnergyLeaveAsDefault() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT
        );
    }

    /**
     * @return {@code true}:Accumulated Energy Turn off, {@code false}:not Accumulated Energy Turn off
     */
    public boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedEnergyTurnOff() {
        return isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(mOpCodes)
                && isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_MASK
                , PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_TURN_OFF
        );
    }

    /**
     * @return {@code true}:Incorrect calibration position, {@code false}:not Incorrect calibration position
     */
    public boolean isParameterValueStartEnhancedOffsetCompensationIncorrectCalibrationPosition() {
        return isOpCodesStartEnhancedOffsetCompensation(mRequestOpCode) && isResponseValueOperationFailed() && PARAMETER_VALUE_START_ENHANCED_OFFET_COMPENSATION_INCORRECT_CALIBRATION_POSITION == mResponseParameter[0];
    }

    /**
     * @return {@code true}:Manufacturer specific error follows, {@code false}:not Manufacturer specific error follows
     */
    public boolean isParameterValueStartEnhancedOffsetCompensationManufacturerSpecificErrorFollows() {
        return isOpCodesStartEnhancedOffsetCompensation(mRequestOpCode) && isResponseValueOperationFailed() && PARAMETER_VALUE_START_ENHANCED_OFFET_COMPENSATION_MANUFACTURER_SPECIFIC_ERROR_FOLLOWS == (0xff & mResponseParameter[0]);
    }

    /**
     * @return Request Op Code
     */
    public int getRequestOpCode() {
        return mRequestOpCode;
    }

    /**
     * @return Response Value
     */
    public int getResponseValue() {
        return mResponseValue;
    }

    /**
     * @return {@code true}:Success, {@code false}:not Success
     */
    public boolean isResponseValueSuccess() {
        return RESPONSE_VALUE_SUCCESS == mResponseValue;
    }

    /**
     * @return {@code true}:Op Code not Supported, {@code false}:not Op Code not Supported
     */
    public boolean isResponseValueOpCodeNotSupported() {
        return RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED == mResponseValue;
    }

    /**
     * @return {@code true}:Invalid Parameter, {@code false}:not Invalid Parameter
     */
    public boolean isResponseValueInvalidParameter() {
        return RESPONSE_VALUE_INVALID_PARAMETER == mResponseValue;
    }

    /**
     * @return {@code true}:Operation Failed, {@code false}:not Operation Failed
     */
    public boolean isResponseValueOperationFailed() {
        return RESPONSE_VALUE_OPERATION_FAILED == mResponseValue;
    }

    /**
     * @return Response Parameter
     */
    public byte[] getResponseParameter() {
        return mResponseParameter;
    }

    /**
     * @return {@code true}:has Manufacturer specific data in Start Enhanced Offset Compensation Response Parameter, {@code false}:no Manufacturer specific data
     */
    public boolean hasManufacturerSpecificData() {
        return hasManufacturerSpecificDataWithSuccess() || hasManufacturerSpecificDataWithOperationFailed();
    }

    /**
     * @return company id or -1(no company id in response parameter)
     * @see org.im97mori.ble.BLEConstants#COMPANY_MAPPING
     */
    public int getCompanyId() {
        int companyId;
        if (hasManufacturerSpecificDataWithSuccess()) {
            companyId = BLEUtils.createUInt16(mResponseParameter, 0);
        } else if (isParameterValueStartEnhancedOffsetCompensationManufacturerSpecificErrorFollows()) {
            companyId = BLEUtils.createUInt16(mResponseParameter, 1);
        } else {
            companyId = -1;
        }
        return companyId;
    }

    /**
     * @return manufacturer specific data length or -1(no manufacturer specific data in response parameter)
     */
    public int getManfacturerSpecificDataLength() {
        int length;
        if (hasManufacturerSpecificDataWithSuccess()) {
            length = BLEUtils.createUInt8(mResponseParameter, 2);
        } else if (isParameterValueStartEnhancedOffsetCompensationManufacturerSpecificErrorFollows()) {
            length = BLEUtils.createUInt8(mResponseParameter, 3);
        } else {
            length = -1;
        }
        return length;
    }

    /**
     * @return manufacturer specific data
     */
    public byte[] getManfacturerSpecificData() {
        int length = getManfacturerSpecificDataLength();
        return Arrays.copyOfRange(mResponseParameter, mResponseParameter.length - length, mResponseParameter.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 1;
        byte[] data = new byte[3 + mParameterValue.length + mResponseParameter.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mOpCodes);
        byteBuffer.put(mParameterValue);
        length += mParameterValue.length;
        if (isOpCodesResponseCode(mOpCodes)) {
            byteBuffer.put((byte) mRequestOpCode);
            length++;
            byteBuffer.put((byte) mResponseValue);
            length++;
            byteBuffer.put(mResponseParameter);
            length += mResponseParameter.length;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Parameter Value for Mask Cycling Power Measurement Characteristic Content
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_TURN_OFF}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_TURN_OFF}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_TURN_OFF}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_TURN_OFF}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_TURN_OFF}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_TURN_OFF}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_TURN_OFF}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_TURN_OFF}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_LEAVE_AS_DEFAULT}
     *               , {@link #PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_TURN_OFF}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isParameterValueMaskCyclingPowerMeasurementCharacteristicContentMatched(int mask, int expect) {
        return (mask & BLEUtils.createUInt16(mParameterValue, 0)) == expect;
    }

    /**
     * @return {@code true}:has Manufacturer specific data in Start Enhanced Offset Compensation Response Parameter with Success Response Value, {@code false}:no Manufacturer specific data
     */
    private boolean hasManufacturerSpecificDataWithSuccess() {
        return isOpCodesStartEnhancedOffsetCompensation(mRequestOpCode) && isResponseValueSuccess() && mResponseParameter.length > 2;
    }

    /**
     * @return {@code true}:has Manufacturer specific data in Start Enhanced Offset Compensation Response Parameter with Operation Failed Response Value, {@code false}:no Manufacturer specific data
     */
    private boolean hasManufacturerSpecificDataWithOperationFailed() {
        return isOpCodesStartEnhancedOffsetCompensation(mRequestOpCode) && isResponseValueOperationFailed() && mResponseParameter.length > 1;
    }

}
