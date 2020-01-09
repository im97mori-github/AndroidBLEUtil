package org.im97mori.ble.characteristic.ftms;

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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;

/**
 * Fitness Machine Control Point (Characteristics UUID: 0x2AD9)
 */
public class FitnessMachineControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 0x00: Request Control
     */
    public static final int OP_CODE_REQUEST_CONTROL = 0x00;

    /**
     * 0x01: Reset
     */
    public static final int OP_CODE_RESET = 0x01;

    /**
     * 0x02: Set Target Speed
     */
    public static final int OP_CODE_SET_TARGET_SPEED = 0x02;

    /**
     * 0x03: Set Target Inclination
     */
    public static final int OP_CODE_SET_TARGET_INCLINATION = 0x03;

    /**
     * 0x04: Set Target Resistance Level
     */
    public static final int OP_CODE_SET_TARGET_RESISTANCE_LEVEL = 0x04;

    /**
     * 0x05: Set Target Power
     */
    public static final int OP_CODE_SET_TARGET_POWER = 0x05;

    /**
     * 0x06: Set Target Heart Rate
     */
    public static final int OP_CODE_SET_TARGET_HEART_RATE = 0x06;

    /**
     * 0x07: Start or Resume
     */
    public static final int OP_CODE_START_OR_RESUME = 0x07;

    /**
     * 0x08: Stop or Pause
     */
    public static final int OP_CODE_STOP_OR_PAUSE = 0x08;

    /**
     * 0x09: Set Targeted Expended Energy
     */
    public static final int OP_CODE_SET_TARGETED_EXPENDED_ENERGY = 0x09;

    /**
     * 0x0a: Set Targeted Number of Steps
     */
    public static final int OP_CODE_SET_TARGETED_NUMBER_OF_STEPS = 0x0a;

    /**
     * 0x0b: Set Targeted Number of Strides
     */
    public static final int OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES = 0x0b;

    /**
     * 0x0c: Set Targeted Distance
     */
    public static final int OP_CODE_SET_TARGETED_DISTANCE = 0x0c;

    /**
     * 0x0d: Set Targeted Training Time
     */
    public static final int OP_CODE_SET_TARGETED_TRAINING_TIME = 0x0d;

    /**
     * 0x0e: Set Targeted Time in Two Heart Rate Zones
     */
    public static final int OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES = 0x0e;

    /**
     * 0x0f: Set Targeted Time in Three Heart Rate Zones
     */
    public static final int OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES = 0x0f;

    /**
     * 0x10: Set Targeted Time in Five Heart Rate Zones
     */
    public static final int OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES = 0x10;

    /**
     * 0x11: Set Indoor Bike Simulation Parameters
     */
    public static final int OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES = 0x11;

    /**
     * 0x12: Set Wheel Circumference
     */
    public static final int OP_CODE_SET_WHEEL_CICUMFERENCE = 0x12;

    /**
     * 0x13: Spin Down Control
     */
    public static final int OP_CODE_SPIN_DOWN_CONTROL = 0x13;

    /**
     * 0x14: Set Targeted Cadence
     */
    public static final int OP_CODE_SET_TARGETED_CADENCE = 0x14;

    /**
     * 0x80: Response Code
     */
    public static final int OP_CODE_RESPONSE_CODE = 0x80;

    /**
     * 0x01: Success
     */
    public static final int RESULT_CODE_SUCCESS = 0x01;

    /**
     * 0x02: Op Code not supported
     */
    public static final int RESULT_CODE_OP_CODE_NOT_SUPPORTED = 0x02;

    /**
     * 0x03: Invalid Parameter
     */
    public static final int RESULT_CODE_INVALID_PARAMETER = 0x03;

    /**
     * 0x04: Operation Failed
     */
    public static final int RESULT_CODE_OPERATION_FAILED = 0x04;

    /**
     * 0x05: Control Not Permitted
     */
    public static final int RESULT_CODE_CONTROL_NOT_PERMITTED = 0x05;

    /**
     * Target Speed Unit 0.01 km/h
     */
    public static final double TARGET_SPEED_RESOLUTION = 0.01d;

    /**
     * Target Inclination Unit 0.1 %
     */
    public static final double TARGET_INCLINATION_RESOLUTION = 0.1d;

    /**
     * Target Resistance Level Unit 0.1
     */
    public static final double TARGET_RESISTANCE_LEVEL_RESOLUTION = 0.1d;

    /**
     * Wind Speed 0.0001 Unit Meters Per Second
     */
    public static final double WIND_SPEED_RESOLUTION = 0.001d;

    /**
     * Grade 0.01 Unit Percentage
     */
    public static final double GRADE_RESOLUTION = 0.01d;

    /**
     * Coefficient of Rolling Resistance Unit
     */
    public static final double COEFFICIENT_OF_ROLLING_RESISTANCE_RESOLUTION = 0.0001d;

    /**
     * Wind Resistance Coefficient Unit 0.01 Kilogram per Meter
     */
    public static final double WIND_RESISTANCE_COEFFICIENT_RESOLUTION = 0.01d;

    /**
     * Wheel Circumference Unit 0.1 Millimeter
     */
    public static final double WHEEL_CIRCUMFERENCE_RESOLUTION = 0.1d;

    /**
     * Target Speed Low Unit 0.01 km/h
     */
    public static final double SPIN_DOWN_TARGET_SPEED_LOW_RESOLUTION = 0.01d;

    /**
     * Target Speed High Unit 0.01 km/h
     */
    public static final double SPIN_DOWN_TARGET_SPEED_HIGH_RESOLUTION = 0.01d;

    /**
     * Targeted Cadence Unit 0.5 1/minute
     */
    public static final double TARGETED_CADENCE_RESOLUTION = 0.5d;

    /**
     * 0x01: Stop
     */
    public static final int STOP_OR_PAUSE_STOP = 0x01;

    /**
     * 0x02: Pause
     */
    public static final int STOP_OR_PAUSE_PAUSE = 0x02;

    /**
     * 0x01: Start
     */
    public static final int SPIN_DOWN_START = 0x01;

    /**
     * 0x02: Ignore
     */
    public static final int SPIN_DOWN_IGNORE = 0x02;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FitnessMachineControlPoint> CREATOR = new ByteArrayCreater<FitnessMachineControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineControlPoint createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineControlPoint[] newArray(int size) {
            return new FitnessMachineControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FitnessMachineControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FitnessMachineControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Op Code
     */
    private final int mOpCode;

    /**
     * Parameter
     */
    private final byte[] mParameter;

    /**
     * Request Op Code
     */
    private final int mRequestOpCode;

    /**
     * Result Code
     */
    private final int mResultCode;

    /**
     * Response Parameter
     */
    private final byte[] mResponseParameter;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD9
     */
    public FitnessMachineControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mOpCode = (values[0] & 0xff);
        if (isOpCodeRequestControl(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 1);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeReset(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 1);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetSpeed(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetInclination(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetResistanceLevel(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 2);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetPower(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetHeartRate(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 2);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeStartOrResume(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 1);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeStopOrPause(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 2);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedExpendedEnergy(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedNumberOfSteps(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedNumberOfStrides(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedDistance(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 4);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedTrainingTime(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedTimeInTwoHeartRateZones(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 5);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedTimeInThreeHeartRateZones(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 7);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedTimeInFiveHeartRateZones(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 11);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetIndoorBikeSimulationParameters(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 7);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetWheelCircumference(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSpinDownControl(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 2);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeSetTargetedCadence(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodeResponseCode(mOpCode)) {
            mParameter = Arrays.copyOfRange(values, 1, 1);
            mRequestOpCode = values[1] & 0xff;
            mResultCode = values[2] & 0xff;
            if (isOpCodeSpinDownControl(mRequestOpCode) && isResultCodeSuccess()) {
                mResponseParameter = Arrays.copyOfRange(values, 3, 7);
            } else {
                mResponseParameter = new byte[0];
            }
        } else {
            mParameter = new byte[0];
            mRequestOpCode = 0;
            mResultCode = 0;
            mResponseParameter = new byte[0];
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FitnessMachineControlPoint(@NonNull Parcel in) {
        mOpCode = in.readInt();
        mParameter = in.createByteArray();
        mRequestOpCode = in.readInt();
        mResultCode = in.readInt();
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
        dest.writeInt(mOpCode);
        dest.writeByteArray(mParameter);
        dest.writeInt(mRequestOpCode);
        dest.writeInt(mResultCode);
        dest.writeByteArray(mResponseParameter);
    }

    /**
     * @return Op Code
     */
    public int getOpCode() {
        return mOpCode;
    }

    /**
     * @return {@code true}:Request Control, {@code false}:not Request Control
     */
    public boolean isOpCodeRequestControl(int opCode) {
        return OP_CODE_REQUEST_CONTROL == opCode;
    }

    /**
     * @return {@code true}:Reset, {@code false}:not Reset
     */
    public boolean isOpCodeReset(int opCode) {
        return OP_CODE_RESET == opCode;
    }

    /**
     * @return {@code true}:Set Target Speed, {@code false}:not Set Target Speed
     */
    public boolean isOpCodeSetTargetSpeed(int opCode) {
        return OP_CODE_SET_TARGET_SPEED == opCode;
    }

    /**
     * @return {@code true}:Set Target Inclination, {@code false}:not Set Target Inclination
     */
    public boolean isOpCodeSetTargetInclination(int opCode) {
        return OP_CODE_SET_TARGET_INCLINATION == opCode;
    }

    /**
     * @return {@code true}:Set Target Resistance Level, {@code false}:not Set Target Resistance Level
     */
    public boolean isOpCodeSetTargetResistanceLevel(int opCode) {
        return OP_CODE_SET_TARGET_RESISTANCE_LEVEL == opCode;
    }

    /**
     * @return {@code true}:Set Target Power, {@code false}:not Set Target Power
     */
    public boolean isOpCodeSetTargetPower(int opCode) {
        return OP_CODE_SET_TARGET_POWER == opCode;
    }

    /**
     * @return {@code true}:Set Target Heart Rate, {@code false}:not Set Target Heart Rate
     */
    public boolean isOpCodeSetTargetHeartRate(int opCode) {
        return OP_CODE_SET_TARGET_HEART_RATE == opCode;
    }

    /**
     * @return {@code true}:Start or Resume, {@code false}:not Start or Resume
     */
    public boolean isOpCodeStartOrResume(int opCode) {
        return OP_CODE_START_OR_RESUME == opCode;
    }

    /**
     * @return {@code true}:Stop or Pause, {@code false}:not Stop or Pause
     */
    public boolean isOpCodeStopOrPause(int opCode) {
        return OP_CODE_STOP_OR_PAUSE == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Expended Energy, {@code false}:not Set Targeted Expended Energy
     */
    public boolean isOpCodeSetTargetedExpendedEnergy(int opCode) {
        return OP_CODE_SET_TARGETED_EXPENDED_ENERGY == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Number of Steps, {@code false}:not Set Targeted Number of Steps
     */
    public boolean isOpCodeSetTargetedNumberOfSteps(int opCode) {
        return OP_CODE_SET_TARGETED_NUMBER_OF_STEPS == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Number of Strides, {@code false}:not Set Targeted Number of Strides
     */
    public boolean isOpCodeSetTargetedNumberOfStrides(int opCode) {
        return OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Distance, {@code false}:not Set Targeted Distance
     */
    public boolean isOpCodeSetTargetedDistance(int opCode) {
        return OP_CODE_SET_TARGETED_DISTANCE == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Training Time, {@code false}:not Set Targeted Training Time
     */
    public boolean isOpCodeSetTargetedTrainingTime(int opCode) {
        return OP_CODE_SET_TARGETED_TRAINING_TIME == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Time in Two Heart Rate Zones, {@code false}:not Set Targeted Time in Two Heart Rate Zones
     */
    public boolean isOpCodeSetTargetedTimeInTwoHeartRateZones(int opCode) {
        return OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Time in Three Heart Rate Zones, {@code false}:not Set Targeted Time in Three Heart Rate Zones
     */
    public boolean isOpCodeSetTargetedTimeInThreeHeartRateZones(int opCode) {
        return OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Time in Five Heart Rate Zones, {@code false}:not Set Targeted Time in Five Heart Rate Zones
     */
    public boolean isOpCodeSetTargetedTimeInFiveHeartRateZones(int opCode) {
        return OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES == opCode;
    }

    /**
     * @return {@code true}:Set Indoor Bike Simulation Parameters, {@code false}:not Set Indoor Bike Simulation Parameters
     */
    public boolean isOpCodeSetIndoorBikeSimulationParameters(int opCode) {
        return OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES == opCode;
    }

    /**
     * @return {@code true}:Set Wheel Circumference, {@code false}:not Set Wheel Circumference
     */
    public boolean isOpCodeSetWheelCircumference(int opCode) {
        return OP_CODE_SET_WHEEL_CICUMFERENCE == opCode;
    }

    /**
     * @return {@code true}:Spin Down Control, {@code false}:not Spin Down Control
     */
    public boolean isOpCodeSpinDownControl(int opCode) {
        return OP_CODE_SPIN_DOWN_CONTROL == opCode;
    }

    /**
     * @return {@code true}:Set Targeted Cadence, {@code false}:not Set Targeted Cadence
     */
    public boolean isOpCodeSetTargetedCadence(int opCode) {
        return OP_CODE_SET_TARGETED_CADENCE == opCode;
    }

    /**
     * @return {@code true}:Response Code, {@code false}:not Response Code
     */
    public boolean isOpCodeResponseCode(int opCode) {
        return OP_CODE_RESPONSE_CODE == opCode;
    }

    /**
     * @return Parameter
     */
    public byte[] getParameter() {
        return mParameter;
    }

    /**
     * @return Target Speed
     */
    public int getTargetSpeed() {
        int targetSpeed;
        if (isOpCodeSetTargetSpeed(mOpCode)) {
            targetSpeed = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetSpeed = 0;
        }
        return targetSpeed;
    }

    /**
     * @return Target Speed(0.01 km/h)
     */
    public double getTargetSpeedKmH() {
        return TARGET_SPEED_RESOLUTION * getTargetSpeed();
    }

    /**
     * @return Target Inclination
     */
    public int getTargetInclination() {
        int targetInclination;
        if (isOpCodeSetTargetInclination(mOpCode)) {
            targetInclination = BLEUtils.createSInt16(mParameter, 0);
        } else {
            targetInclination = 0;
        }
        return targetInclination;
    }

    /**
     * @return Target Inclination(0.1 %)
     */
    public double getTargetInclinationPercent() {
        return TARGET_INCLINATION_RESOLUTION * getTargetInclination();
    }

    /**
     * @return Target Resistance Level
     */
    public int getTargetResistanceLevel() {
        int targetResistanceLevel;
        if (isOpCodeSetTargetResistanceLevel(mOpCode)) {
            targetResistanceLevel = BLEUtils.createUInt8(mParameter, 0);
        } else {
            targetResistanceLevel = 0;
        }
        return targetResistanceLevel;
    }

    /**
     * @return Target Resistance Level(0.1)
     */
    public double getTargetResistanceLevelWithUnit() {
        return TARGET_RESISTANCE_LEVEL_RESOLUTION * getTargetResistanceLevel();
    }

    /**
     * @return Target Power
     */
    public int getTargetPower() {
        int targetPower;
        if (isOpCodeSetTargetPower(mOpCode)) {
            targetPower = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetPower = 0;
        }
        return targetPower;
    }

    /**
     * @return Target Heart Rate
     */
    public int getTargetHeartRate() {
        int targetHeartRate;
        if (isOpCodeSetTargetHeartRate(mOpCode)) {
            targetHeartRate = BLEUtils.createUInt8(mParameter, 0);
        } else {
            targetHeartRate = 0;
        }
        return targetHeartRate;
    }

    /**
     * @return {@code true}:Stop, {@code false}:not Stop
     */
    public boolean isStopOrPauseStop() {
        return isOpCodeStopOrPause(mOpCode) && STOP_OR_PAUSE_STOP == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return {@code true}:Pause, {@code false}:not Pause
     */
    public boolean isStopOrPausePause() {
        return isOpCodeStopOrPause(mOpCode) && STOP_OR_PAUSE_PAUSE == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return Targeted Expended Energy
     */
    public int getTargetedExpendedEnergy() {
        int targetedExpendedEnergy;
        if (isOpCodeSetTargetedExpendedEnergy(mOpCode)) {
            targetedExpendedEnergy = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedExpendedEnergy = 0;
        }
        return targetedExpendedEnergy;
    }

    /**
     * @return Targeted Number of Steps
     */
    public int getTargetedNumberOfSteps() {
        int targetedNumberOfSteps;
        if (isOpCodeSetTargetedNumberOfSteps(mOpCode)) {
            targetedNumberOfSteps = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedNumberOfSteps = 0;
        }
        return targetedNumberOfSteps;
    }

    /**
     * @return Targeted Number of Strides
     */
    public int getTargetedNumberOfStrides() {
        int targetedNumberOfSteps;
        if (isOpCodeSetTargetedNumberOfStrides(mOpCode)) {
            targetedNumberOfSteps = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedNumberOfSteps = 0;
        }
        return targetedNumberOfSteps;
    }

    /**
     * @return Targeted Distance
     */
    public int getTargetedDistance() {
        int targetedDistance;
        if (isOpCodeSetTargetedDistance(mOpCode)) {
            targetedDistance = BLEUtils.createUInt24(mParameter, 0);
        } else {
            targetedDistance = 0;
        }
        return targetedDistance;
    }

    /**
     * @return Targeted Training Time
     */
    public int getTargetedTrainingTime() {
        int targetedTrainingTime;
        if (isOpCodeSetTargetedTrainingTime(mOpCode)) {
            targetedTrainingTime = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedTrainingTime = 0;
        }
        return targetedTrainingTime;
    }

    /**
     * @return Targeted Time in Fat Burn Zone
     */
    public int getTargetedTimeInFatBurnZone() {
        int targetedTimeInFatBurnZone;
        if (isOpCodeSetTargetedTimeInTwoHeartRateZones(mOpCode)) {
            targetedTimeInFatBurnZone = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedTimeInFatBurnZone = 0;
        }
        return targetedTimeInFatBurnZone;
    }

    /**
     * @return Targeted Time in Fitness Zone
     */
    public int getTargetedTimeInFitnessZone() {
        int targetedTimeInFitnessZone;
        if (isOpCodeSetTargetedTimeInTwoHeartRateZones(mOpCode)) {
            targetedTimeInFitnessZone = BLEUtils.createUInt16(mParameter, 2);
        } else {
            targetedTimeInFitnessZone = 0;
        }
        return targetedTimeInFitnessZone;
    }

    /**
     * @return Targeted Time in Light Zone
     */
    public int getTargetedTimeInLightZone() {
        int targetedTimeInLightZone;
        if (isOpCodeSetTargetedTimeInThreeHeartRateZones(mOpCode)) {
            targetedTimeInLightZone = BLEUtils.createUInt16(mParameter, 0);
        } else if (isOpCodeSetTargetedTimeInFiveHeartRateZones(mOpCode)) {
            targetedTimeInLightZone = BLEUtils.createUInt16(mParameter, 2);
        } else {
            targetedTimeInLightZone = 0;
        }
        return targetedTimeInLightZone;
    }

    /**
     * @return Targeted Time in Moderate Zone
     */
    public int getTargetedTimeInModerateZone() {
        int targetedTimeInModerateZone;
        if (isOpCodeSetTargetedTimeInThreeHeartRateZones(mOpCode)) {
            targetedTimeInModerateZone = BLEUtils.createUInt16(mParameter, 2);
        } else if (isOpCodeSetTargetedTimeInFiveHeartRateZones(mOpCode)) {
            targetedTimeInModerateZone = BLEUtils.createUInt16(mParameter, 4);
        } else {
            targetedTimeInModerateZone = 0;
        }
        return targetedTimeInModerateZone;
    }

    /**
     * @return Targeted Time in Hard Zone
     */
    public int getTargetedTimeInHardZone() {
        int targetedTimeInHardZone;
        if (isOpCodeSetTargetedTimeInThreeHeartRateZones(mOpCode)) {
            targetedTimeInHardZone = BLEUtils.createUInt16(mParameter, 4);
        } else if (isOpCodeSetTargetedTimeInFiveHeartRateZones(mOpCode)) {
            targetedTimeInHardZone = BLEUtils.createUInt16(mParameter, 6);
        } else {
            targetedTimeInHardZone = 0;
        }
        return targetedTimeInHardZone;
    }

    /**
     * @return Targeted Time in Very Light Zone
     */
    public int getTargetedTimeInVeryLightZone() {
        int targetedTimeInVeryLightZone;
        if (isOpCodeSetTargetedTimeInFiveHeartRateZones(mOpCode)) {
            targetedTimeInVeryLightZone = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedTimeInVeryLightZone = 0;
        }
        return targetedTimeInVeryLightZone;
    }

    /**
     * @return Targeted Time in Maximum Zone
     */
    public int getTargetedTimeInMaximumZone() {
        int targetedTimeInMaximumZone;
        if (isOpCodeSetTargetedTimeInFiveHeartRateZones(mOpCode)) {
            targetedTimeInMaximumZone = BLEUtils.createUInt16(mParameter, 8);
        } else {
            targetedTimeInMaximumZone = 0;
        }
        return targetedTimeInMaximumZone;
    }

    /**
     * @return Wind Speed
     */
    public int getWindSpeed() {
        int windSpeed;
        if (isOpCodeSetIndoorBikeSimulationParameters(mOpCode)) {
            windSpeed = BLEUtils.createSInt16(mParameter, 0);
        } else {
            windSpeed = 0;
        }
        return windSpeed;
    }

    /**
     * @return Wind Speed(Meters Per Second)
     */
    public double getWindSpeedMetersPerSecond() {
        return WIND_SPEED_RESOLUTION * getWindSpeed();
    }

    /**
     * @return Grade
     */
    public int getGrade() {
        int grade;
        if (isOpCodeSetIndoorBikeSimulationParameters(mOpCode)) {
            grade = BLEUtils.createSInt16(mParameter, 2);
        } else {
            grade = 0;
        }
        return grade;
    }

    /**
     * @return Grade(Percentage)
     */
    public double getGradePercentage() {
        return GRADE_RESOLUTION * getGrade();
    }

    /**
     * @return Coefficient of Rolling Resistance
     */
    public int getCoefficientOfRollingResistance() {
        int coefficientOfRollingResistance;
        if (isOpCodeSetIndoorBikeSimulationParameters(mOpCode)) {
            coefficientOfRollingResistance = BLEUtils.createUInt8(mParameter, 4);
        } else {
            coefficientOfRollingResistance = 0;
        }
        return coefficientOfRollingResistance;
    }

    /**
     * @return Coefficient of Rolling Resistance with Unit
     */
    public double getCoefficientOfRollingResistanceWithUnit() {
        return COEFFICIENT_OF_ROLLING_RESISTANCE_RESOLUTION * getCoefficientOfRollingResistance();
    }

    /**
     * @return Wind Resistance Coefficient
     */
    public int getWindResistanceCoefficient() {
        int windResistanceCoefficient;
        if (isOpCodeSetIndoorBikeSimulationParameters(mOpCode)) {
            windResistanceCoefficient = BLEUtils.createUInt8(mParameter, 5);
        } else {
            windResistanceCoefficient = 0;
        }
        return windResistanceCoefficient;
    }

    /**
     * @return Wind Resistance Coefficient(Kilogram per Meter)
     */
    public double getWindResistanceCoefficientKilogramPerMeter() {
        return WIND_RESISTANCE_COEFFICIENT_RESOLUTION * getWindResistanceCoefficient();
    }

    /**
     * @return Wheel Circumference
     */
    public int getWheelCircumference() {
        int wheelCircumference;
        if (isOpCodeSetWheelCircumference(mOpCode)) {
            wheelCircumference = BLEUtils.createUInt16(mParameter, 0);
        } else {
            wheelCircumference = 0;
        }
        return wheelCircumference;
    }

    /**
     * @return Wheel Circumference(km/h)
     */
    public double getWheelCircumferenceKmH() {
        return WHEEL_CIRCUMFERENCE_RESOLUTION * getWheelCircumference();
    }

    /**
     * @return {@code true}:Start, {@code false}:not Start
     */
    public boolean isSpinDownControlStart() {
        return isOpCodeSpinDownControl(mOpCode) && SPIN_DOWN_START == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return {@code true}:Ignore, {@code false}:not Ignore
     */
    public boolean isSpinDownControlIgnore() {
        return isOpCodeSpinDownControl(mOpCode) && SPIN_DOWN_IGNORE == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return Targeted Cadence
     */
    public int getTargetedCadence() {
        int targetedCadence;
        if (isOpCodeSetTargetedCadence(mOpCode)) {
            targetedCadence = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedCadence = 0;
        }
        return targetedCadence;
    }

    /**
     * @return Targeted Cadence(0.5 1/minute)
     */
    public double getTargetedCadenceRpm() {
        return TARGETED_CADENCE_RESOLUTION * getTargetedCadence();
    }

    /**
     * @return Request Op Code
     */
    public int getRequestOpCode() {
        return mRequestOpCode;
    }

    /**
     * @return Result Code
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
     * @return {@code true}:Op Code not supported, {@code false}:not Op Code not supported
     */
    public boolean isResultCodeOpCodeNotSupported() {
        return RESULT_CODE_OP_CODE_NOT_SUPPORTED == mResultCode;
    }

    /**
     * @return {@code true}:Invalid Parameter, {@code false}:not Invalid Parameter
     */
    public boolean isResultCodeInvalidParameter() {
        return RESULT_CODE_INVALID_PARAMETER == mResultCode;
    }

    /**
     * @return {@code true}:Operation Failed, {@code false}:not Operation Failed
     */
    public boolean isResultCodeOperationFailed() {
        return RESULT_CODE_OPERATION_FAILED == mResultCode;
    }

    /**
     * @return {@code true}:Control Not Permitted, {@code false}:not Control Not Permitted
     */
    public boolean isResultCodeControlNotPermitted() {
        return RESULT_CODE_CONTROL_NOT_PERMITTED == mResultCode;
    }

    /**
     * @return Response Parameter
     */
    public byte[] getResponseParameter() {
        return mResponseParameter;
    }

    /**
     * @return Target Speed Low
     */
    public int getTargetSpeedLow() {
        int targetSpeedLow;
        if (isOpCodeResponseCode(mOpCode) && isOpCodeSpinDownControl(mRequestOpCode) && isResultCodeSuccess()) {
            targetSpeedLow = BLEUtils.createUInt16(mResponseParameter, 0);
        } else {
            targetSpeedLow = 0;
        }
        return targetSpeedLow;
    }

    /**
     * @return Target Speed Low(km/h)
     */
    public double getTargetSpeedLowKmH() {
        return SPIN_DOWN_TARGET_SPEED_LOW_RESOLUTION * getTargetSpeedLow();
    }

    /**
     * @return Target Speed High
     */
    public int getTargetSpeedHigh() {
        int targetSpeedHigh;
        if (isOpCodeResponseCode(mOpCode) && isOpCodeSpinDownControl(mRequestOpCode) && isResultCodeSuccess()) {
            targetSpeedHigh = BLEUtils.createUInt16(mResponseParameter, 2);
        } else {
            targetSpeedHigh = 0;
        }
        return targetSpeedHigh;
    }

    /**
     * @return Target Speed High(km/h)
     */
    public double getTargetSpeedHighKmH() {
        return SPIN_DOWN_TARGET_SPEED_HIGH_RESOLUTION * getTargetSpeedHigh();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 1;
        byte[] data = new byte[3 + mParameter.length + mResponseParameter.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mOpCode);
        byteBuffer.put(mParameter);
        length += mParameter.length;
        if (isOpCodeResponseCode(mOpCode)) {
            byteBuffer.put((byte) mRequestOpCode);
            length++;
            byteBuffer.put((byte) mResultCode);
            length++;
            byteBuffer.put(mResponseParameter);
            length += mResponseParameter.length;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

}
