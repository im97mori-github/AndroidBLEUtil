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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FITNESS_MACHINE_STATUS_CHARACTERISTIC;

/**
 * Fitness Machine Status (Characteristics UUID: 0x2ADA)
 */
public class FitnessMachineStatus implements ByteArrayInterface, Parcelable {

    /**
     * 0x01: Reset
     */
    public static final int OP_CODE_RESET = 0x01;

    /**
     * 0x02: Fitness Machine Stopped or Paused by the User
     */
    public static final int OP_CODE_FITNESS_MACHINE_STOPPED_OR_PAUSED_BY_THE_USER = 0x02;

    /**
     * 0x03: Fitness Machine Stopped by Safety Key
     */
    public static final int OP_CODE_FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY = 0x03;

    /**
     * 0x04: Fitness Machine Started or Resumed by the User
     */
    public static final int OP_CODE_FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER = 0x04;

    /**
     * 0x05: Target Speed Changed
     */
    public static final int OP_CODE_TARGET_SPEED_CHANGED = 0x05;

    /**
     * 0x06: Target Incline Changed
     */
    public static final int OP_CODE_TARGET_INCLINE_CHANGED = 0x06;

    /**
     * 0x07: Target Resistance Level Changed
     */
    public static final int OP_CODE_TARGET_RESISTANCE_LEVEL_CHANGED = 0x07;

    /**
     * 0x08: Target Power Changed
     */
    public static final int OP_CODE_TARGET_POWER_CHANGED = 0x08;

    /**
     * 0x09: Target Heart Rate Changed
     */
    public static final int OP_CODE_TARGET_HEART_RATE_CHANGED = 0x09;

    /**
     * 0x0a: Targeted Expended Energy Changed
     */
    public static final int OP_CODE_TARGETED_EXPENDED_ENERGY_CHANGED = 0x0a;

    /**
     * 0x0b: Targeted Number of Steps Changed
     */
    public static final int OP_CODE_TARGETED_NUMBER_OF_STEPS_CHANGED = 0x0b;

    /**
     * 0x0c: Targeted Number of Strides Changed
     */
    public static final int OP_CODE_TARGETED_NUMBER_OF_STRIDES_CHANGED = 0x0c;

    /**
     * 0x0d: Targeted Distance Changed
     */
    public static final int OP_CODE_TARGETED_DISTANCE_CHANGED = 0x0d;

    /**
     * 0x0e: Targeted Training Time Changed
     */
    public static final int OP_CODE_TARGETED_TRAINING_TIME_CHANGED = 0x0e;

    /**
     * 0x0f: Targeted Time in Two Heart Rate Zones Changed
     */
    public static final int OP_CODE_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED = 0x0f;

    /**
     * 0x10: Targeted Time in Three Heart Rate Zones Changed
     */
    public static final int OP_CODE_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED = 0x10;

    /**
     * 0x11: Targeted Time in Five Heart Rate Zones Changed
     */
    public static final int OP_CODE_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED = 0x11;

    /**
     * 0x12: Indoor Bike Simulation Parameters Changed
     */
    public static final int OP_CODE_INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED = 0x12;

    /**
     * 0x13: Wheel Circumference Changed
     */
    public static final int OP_CODE_WHEEL_CIRCUMFERENCE_CHANGED = 0x13;

    /**
     * 0x14: Spin Down Status
     */
    public static final int OP_CODE_SPIN_DOWN_STATUS = 0x14;

    /**
     * 0x15: Targeted Cadence Changed
     */
    public static final int OP_CODE_TARGETED_CADENCE_CHANGED = 0x15;

    /**
     * 0xff: Control Permission Lost
     */
    public static final int OP_CODE_CONTROL_PERMISSION_LOST = 0xff;

    /**
     * Target Speed Changed Unit 0.01 km/h
     */
    public static final double TARGET_SPEED_CHANGED_RESOLUTION = 0.01d;

    /**
     * Target Incline Changed Unit 0.1 %
     */
    public static final double TARGET_INCLINE_CHANGED_RESOLUTION = 0.1d;

    /**
     * Target Resistance Level Changed Unit 0.1
     */
    public static final double TARGET_RESISTANCE_LEVEL_CHANGED_RESOLUTION = 0.1d;

    /**
     * Indoor Bike Simulation Parameters Changed Wind Speed Unit 0.001 Meters Per Second
     */
    public static final double INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_WIND_SPEED_RESOLUTION = 0.001d;

    /**
     * Indoor Bike Simulation Parameters Changed Grade Unit 0.01 Percentage
     */
    public static final double INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_GRADE_RESOLUTION = 0.01d;

    /**
     * Indoor Bike Simulation Parameters Changed Coefficient of Rolling Resistance Unit 0.0001
     */
    public static final double INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_COEFFICIENT_OF_ROLLING_RESISTANCE_RESOLUTION = 0.0001d;

    /**
     * Indoor Bike Simulation Parameters Changed Wind Resistance Coefficient Unit 0.01 Kilogram per Meter
     */
    public static final double INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_WIND_RESISTANCE_COEFFICIENT_RESOLUTION = 0.01d;

    /**
     * Wheel Circumference Changed Unit 0.1 Millimeter
     */
    public static final double WHEEL_CIRCUMFERENCE_CHANGED_RESOLUTION = 0.1d;

    /**
     * Targeted Cadence Changed Unit 0.5 1/minute
     */
    public static final double TARGETED_CADENCE_CHANGED_RESOLUTION = 0.5d;

    /**
     * 0x01: Spin Down Requested
     */
    public static final int SPIN_DOWN_STATUS_SPIN_DOWN_REQUESTED = 0x01;

    /**
     * 0x02: Success
     */
    public static final int SPIN_DOWN_STATUS_SUCCESS = 0x02;

    /**
     * 0x03: Error
     */
    public static final int SPIN_DOWN_STATUS_ERROR = 0x03;

    /**
     * 0x04: Stop Pedaling
     */
    public static final int SPIN_DOWN_STATUS_STOP_PEDALING = 0x04;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FitnessMachineStatus> CREATOR = new ByteArrayCreater<FitnessMachineStatus>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineStatus createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineStatus(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineStatus[] newArray(int size) {
            return new FitnessMachineStatus[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FitnessMachineStatus createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FitnessMachineStatus(bluetoothGattCharacteristic);
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
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ADA
     */
    public FitnessMachineStatus(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mOpCode = (values[0] & 0xff);
        if (isOpCodeReset()) {
            mParameter = Arrays.copyOfRange(values, 1, 1);
        } else if (isOpCodeFitnessMachineStoppedOrPausedByTheUser()) {
            mParameter = Arrays.copyOfRange(values, 1, 2);
        } else if (isOpCodeFitnessMachineStoppedBySafetyKey()) {
            mParameter = Arrays.copyOfRange(values, 1, 1);
        } else if (isOpCodeFitnessMachineStartedOrResumedByTheUser()) {
            mParameter = Arrays.copyOfRange(values, 1, 1);
        } else if (isOpCodeTargetSpeedChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeTargetInclineChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeTargetResistanceLevelChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 2);
        } else if (isOpCodeTargetPowerChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeTargetHeartRateChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 2);
        } else if (isOpCodeTargetedExpendedEnergyChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeTargetedNumberOfStepsChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeTargetedNumberOfStridesChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeTargetedDistanceChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 4);
        } else if (isOpCodeTargetedTrainingTimeChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeTargetedTimeInTwoHeartRateZonesChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 5);
        } else if (isOpCodeTargetedTimeInThreeHeartRateZonesChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 7);
        } else if (isOpCodeTargetedTimeInFiveHeartRateZonesChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 11);
        } else if (isOpCodeIndoorBikeSimulationParametersChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 7);
        } else if (isOpCodeWheelCircumferenceChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeSpinDownStatus()) {
            mParameter = Arrays.copyOfRange(values, 1, 2);
        } else if (isOpCodeTargetedCadenceChanged()) {
            mParameter = Arrays.copyOfRange(values, 1, 3);
        } else if (isOpCodeControlPermissionLost()) {
            mParameter = Arrays.copyOfRange(values, 1, 1);
        } else {
            mParameter = Arrays.copyOfRange(values, 1, 1);
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FitnessMachineStatus(@NonNull Parcel in) {
        mOpCode = in.readInt();
        mParameter = in.createByteArray();
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
    }

    /**
     * @return Op Code
     */
    public int getOpCode() {
        return mOpCode;
    }

    /**
     * @return {@code true}:Reset, {@code false}:not Reset
     */
    public boolean isOpCodeReset() {
        return OP_CODE_RESET == mOpCode;
    }

    /**
     * @return {@code true}:Fitness Machine Stopped or Paused by the User, {@code false}:not Fitness Machine Stopped or Paused by the User
     */
    public boolean isOpCodeFitnessMachineStoppedOrPausedByTheUser() {
        return OP_CODE_FITNESS_MACHINE_STOPPED_OR_PAUSED_BY_THE_USER == mOpCode;
    }

    /**
     * @return {@code true}:Fitness Machine Stopped by Safety Key, {@code false}:not Fitness Machine Stopped by Safety Key
     */
    public boolean isOpCodeFitnessMachineStoppedBySafetyKey() {
        return OP_CODE_FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY == mOpCode;
    }

    /**
     * @return {@code true}:Fitness Machine Started or Resumed by the User, {@code false}:not Fitness Machine Started or Resumed by the User
     */
    public boolean isOpCodeFitnessMachineStartedOrResumedByTheUser() {
        return OP_CODE_FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER == mOpCode;
    }

    /**
     * @return {@code true}:Target Speed Changed, {@code false}:not Target Speed Changed
     */
    public boolean isOpCodeTargetSpeedChanged() {
        return OP_CODE_TARGET_SPEED_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Target Incline Changed, {@code false}:not Target Incline Changed
     */
    public boolean isOpCodeTargetInclineChanged() {
        return OP_CODE_TARGET_INCLINE_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Target Resistance Level Changed, {@code false}:not Target Resistance Level Changed
     */
    public boolean isOpCodeTargetResistanceLevelChanged() {
        return OP_CODE_TARGET_RESISTANCE_LEVEL_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Target Power Changed, {@code false}:not Target Power Changed
     */
    public boolean isOpCodeTargetPowerChanged() {
        return OP_CODE_TARGET_POWER_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Target Heart Rate Changed, {@code false}:not Target Heart Rate Changed
     */
    public boolean isOpCodeTargetHeartRateChanged() {
        return OP_CODE_TARGET_HEART_RATE_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Expended Energy Changed, {@code false}:not Targeted Expended Energy Changed
     */
    public boolean isOpCodeTargetedExpendedEnergyChanged() {
        return OP_CODE_TARGETED_EXPENDED_ENERGY_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Number of Steps Changed, {@code false}:not Targeted Number of Steps Changed
     */
    public boolean isOpCodeTargetedNumberOfStepsChanged() {
        return OP_CODE_TARGETED_NUMBER_OF_STEPS_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Number of Strides Changed, {@code false}:not Targeted Number of Strides Changed
     */
    public boolean isOpCodeTargetedNumberOfStridesChanged() {
        return OP_CODE_TARGETED_NUMBER_OF_STRIDES_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Distance Changed, {@code false}:not Targeted Distance Changed
     */
    public boolean isOpCodeTargetedDistanceChanged() {
        return OP_CODE_TARGETED_DISTANCE_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Training Time Changed, {@code false}:not Targeted Training Time Changed
     */
    public boolean isOpCodeTargetedTrainingTimeChanged() {
        return OP_CODE_TARGETED_TRAINING_TIME_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Time in Two Heart Rate Zones Changed, {@code false}:not Targeted Timein Two Heart Rate Zones Changed
     */
    public boolean isOpCodeTargetedTimeInTwoHeartRateZonesChanged() {
        return OP_CODE_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Time in Three Heart Rate Zones Changed, {@code false}:not Targeted Time in Three Heart Rate Zones Changed
     */
    public boolean isOpCodeTargetedTimeInThreeHeartRateZonesChanged() {
        return OP_CODE_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Time in Five Heart Rate Zones Changed, {@code false}:not Targeted Time in Five Heart Rate Zones Changed
     */
    public boolean isOpCodeTargetedTimeInFiveHeartRateZonesChanged() {
        return OP_CODE_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Indoor Bike Simulation Parameters Changed, {@code false}:not Indoor Bike Simulation Parameters Changed
     */
    public boolean isOpCodeIndoorBikeSimulationParametersChanged() {
        return OP_CODE_INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Wheel Circumference Changed, {@code false}:not Wheel Circumference Changed
     */
    public boolean isOpCodeWheelCircumferenceChanged() {
        return OP_CODE_WHEEL_CIRCUMFERENCE_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Spin Down Status, {@code false}:not Spin Down Status
     */
    public boolean isOpCodeSpinDownStatus() {
        return OP_CODE_SPIN_DOWN_STATUS == mOpCode;
    }

    /**
     * @return {@code true}:Targeted Cadence Changed, {@code false}:not Targeted Cadence Changed
     */
    public boolean isOpCodeTargetedCadenceChanged() {
        return OP_CODE_TARGETED_CADENCE_CHANGED == mOpCode;
    }

    /**
     * @return {@code true}:Control Permission Lost, {@code false}:not Control Permission Lost
     */
    public boolean isOpCodeControlPermissionLost() {
        return OP_CODE_CONTROL_PERMISSION_LOST == mOpCode;
    }

    /**
     * @return Parameter
     */
    public byte[] getParameter() {
        return mParameter;
    }

    /**
     * @return {@code true}:Stop, {@code false}:not Stop
     */
    public boolean isStopOrPauseStop() {
        return isOpCodeFitnessMachineStoppedOrPausedByTheUser() && FitnessMachineControlPoint.STOP_OR_PAUSE_STOP == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return {@code true}:Pause, {@code false}:not Pause
     */
    public boolean isStopOrPausePause() {
        return isOpCodeFitnessMachineStoppedOrPausedByTheUser() && FitnessMachineControlPoint.STOP_OR_PAUSE_PAUSE == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return Target Speed Changed
     */
    public int getTargetSpeedChanged() {
        int targetSpeedChanged;
        if (isOpCodeTargetSpeedChanged()) {
            targetSpeedChanged = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetSpeedChanged = 0;
        }
        return targetSpeedChanged;
    }

    /**
     * @return Target Speed Changed(km/h)
     */
    public double getTargetSpeedChangedKmH() {
        return TARGET_SPEED_CHANGED_RESOLUTION * getTargetSpeedChanged();
    }

    /**
     * @return Target Incline Changed
     */
    public int getTargetInclineChanged() {
        int targetInclineChanged;
        if (isOpCodeTargetInclineChanged()) {
            targetInclineChanged = BLEUtils.createSInt16(mParameter, 0);
        } else {
            targetInclineChanged = 0;
        }
        return targetInclineChanged;
    }

    /**
     * @return Target Incline Changed(%)
     */
    public double getTargetInclineChangedPercent() {
        return TARGET_INCLINE_CHANGED_RESOLUTION * getTargetInclineChanged();
    }

    /**
     * @return Target Resistance Level Changed
     */
    public int getTargetResistanceLevelChanged() {
        int targetResistanceLevelChanged;
        if (isOpCodeTargetResistanceLevelChanged()) {
            targetResistanceLevelChanged = BLEUtils.createSInt8(mParameter, 0);
        } else {
            targetResistanceLevelChanged = 0;
        }
        return targetResistanceLevelChanged;
    }

    /**
     * @return Target Resistance Level Changed with Unit
     */
    public double getTargetResistanceLevelChangedWithUnit() {
        return TARGET_RESISTANCE_LEVEL_CHANGED_RESOLUTION * getTargetResistanceLevelChanged();
    }

    /**
     * @return Target Power Changed
     */
    public int getTargetPowerChanged() {
        int targetPowerChanged;
        if (isOpCodeTargetPowerChanged()) {
            targetPowerChanged = BLEUtils.createSInt16(mParameter, 0);
        } else {
            targetPowerChanged = 0;
        }
        return targetPowerChanged;
    }

    /**
     * @return Target Heart Rate Changed
     */
    public int getTargetHeartRateChanged() {
        int targetHeartRateChanged;
        if (isOpCodeTargetHeartRateChanged()) {
            targetHeartRateChanged = BLEUtils.createUInt8(mParameter, 0);
        } else {
            targetHeartRateChanged = 0;
        }
        return targetHeartRateChanged;
    }

    /**
     * @return Targeted Expended Energy Changed
     */
    public int getTargetedExpendedEnergyChanged() {
        int targetedExpendedEnergyChanged;
        if (isOpCodeTargetedExpendedEnergyChanged()) {
            targetedExpendedEnergyChanged = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedExpendedEnergyChanged = 0;
        }
        return targetedExpendedEnergyChanged;
    }

    /**
     * @return Targeted Number of Steps Changed
     */
    public int geTargetedNumberOfStepsChanged() {
        int targetedNumberOfStepsChanged;
        if (isOpCodeTargetedNumberOfStepsChanged()) {
            targetedNumberOfStepsChanged = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedNumberOfStepsChanged = 0;
        }
        return targetedNumberOfStepsChanged;
    }

    /**
     * @return Targeted Number of Strides Changed
     */
    public int geTargetedNumberOfStridesChanged() {
        int targetedNumberOfStridesChanged;
        if (isOpCodeTargetedNumberOfStridesChanged()) {
            targetedNumberOfStridesChanged = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedNumberOfStridesChanged = 0;
        }
        return targetedNumberOfStridesChanged;
    }

    /**
     * @return Targeted Distance Changed
     */
    public int geTargetedDistanceChanged() {
        int targetedDistanceChanged;
        if (isOpCodeTargetedDistanceChanged()) {
            targetedDistanceChanged = BLEUtils.createUInt24(mParameter, 0);
        } else {
            targetedDistanceChanged = 0;
        }
        return targetedDistanceChanged;
    }

    /**
     * @return Targeted Training Time Changed
     */
    public int geTargetedTrainingTimeChanged() {
        int targetedTrainingTimeChanged;
        if (isOpCodeTargetedTrainingTimeChanged()) {
            targetedTrainingTimeChanged = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedTrainingTimeChanged = 0;
        }
        return targetedTrainingTimeChanged;
    }

    /**
     * @return Targeted Time in Two Heart Rate Zones Changed Targeted Time in Fat Burn Zone
     */
    public int geTargetedTimeInTwoHeartRateZonesChangedTargetedTimeInFatBurnZone() {
        int targetedTimeInTwoHeartRateZonesChangedTargetedTimeInFatBurnZone;
        if (isOpCodeTargetedTimeInTwoHeartRateZonesChanged()) {
            targetedTimeInTwoHeartRateZonesChangedTargetedTimeInFatBurnZone = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedTimeInTwoHeartRateZonesChangedTargetedTimeInFatBurnZone = 0;
        }
        return targetedTimeInTwoHeartRateZonesChangedTargetedTimeInFatBurnZone;
    }

    /**
     * @return Targeted Time in Two Heart Rate Zones Changed Targeted Time in Fitness Zone
     */
    public int geTargetedTimeInTwoHeartRateZonesChangedTargetedTimeInFitnessZone() {
        int targetedTimeInTwoHeartRateZonesChangedTargetedTimeInFitnessZone;
        if (isOpCodeTargetedTimeInTwoHeartRateZonesChanged()) {
            targetedTimeInTwoHeartRateZonesChangedTargetedTimeInFitnessZone = BLEUtils.createUInt16(mParameter, 2);
        } else {
            targetedTimeInTwoHeartRateZonesChangedTargetedTimeInFitnessZone = 0;
        }
        return targetedTimeInTwoHeartRateZonesChangedTargetedTimeInFitnessZone;
    }

    /**
     * @return Targeted Time in Three Heart Rate Zones Changed Targeted Time in Light Zone
     */
    public int geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInLightZone() {
        int targetedTimeInThreeHeartRateZonesChangedTargetedTimeInLightZone;
        if (isOpCodeTargetedTimeInThreeHeartRateZonesChanged()) {
            targetedTimeInThreeHeartRateZonesChangedTargetedTimeInLightZone = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedTimeInThreeHeartRateZonesChangedTargetedTimeInLightZone = 0;
        }
        return targetedTimeInThreeHeartRateZonesChangedTargetedTimeInLightZone;
    }

    /**
     * @return Targeted Time in Three Heart Rate Zones Changed Targeted Time in Moderate Zone
     */
    public int geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInModerateZone() {
        int targetedTimeInThreeHeartRateZonesChangedTargetedTimeInModerateZone;
        if (isOpCodeTargetedTimeInThreeHeartRateZonesChanged()) {
            targetedTimeInThreeHeartRateZonesChangedTargetedTimeInModerateZone = BLEUtils.createUInt16(mParameter, 2);
        } else {
            targetedTimeInThreeHeartRateZonesChangedTargetedTimeInModerateZone = 0;
        }
        return targetedTimeInThreeHeartRateZonesChangedTargetedTimeInModerateZone;
    }

    /**
     * @return Targeted Time in Three Heart Rate Zones Changed Targeted Time in Hard Zone
     */
    public int geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInHardZone() {
        int geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInHardZone;
        if (isOpCodeTargetedTimeInThreeHeartRateZonesChanged()) {
            geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInHardZone = BLEUtils.createUInt16(mParameter, 4);
        } else {
            geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInHardZone = 0;
        }
        return geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInHardZone;
    }

    /**
     * @return Targeted Time in Five Heart Rate Zones Changed Targeted Time in Very Light Zone
     */
    public int geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInVeryLightZone() {
        int targetedTimeInFiveHeartRateZonesChangedTargetedTimeInVeryLightZone;
        if (isOpCodeTargetedTimeInFiveHeartRateZonesChanged()) {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInVeryLightZone = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInVeryLightZone = 0;
        }
        return targetedTimeInFiveHeartRateZonesChangedTargetedTimeInVeryLightZone;
    }

    /**
     * @return Targeted Time in Five Heart Rate Zones Changed Targeted Time in Light Zone
     */
    public int geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInLightZone() {
        int targetedTimeInFiveHeartRateZonesChangedTargetedTimeInLightZone;
        if (isOpCodeTargetedTimeInFiveHeartRateZonesChanged()) {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInLightZone = BLEUtils.createUInt16(mParameter, 2);
        } else {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInLightZone = 0;
        }
        return targetedTimeInFiveHeartRateZonesChangedTargetedTimeInLightZone;
    }

    /**
     * @return Targeted Time in Five Heart Rate Zones Changed Targeted Time in Moderate Zone
     */
    public int geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInModerateZone() {
        int targetedTimeInFiveHeartRateZonesChangedTargetedTimeInModerateZone;
        if (isOpCodeTargetedTimeInFiveHeartRateZonesChanged()) {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInModerateZone = BLEUtils.createUInt16(mParameter, 4);
        } else {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInModerateZone = 0;
        }
        return targetedTimeInFiveHeartRateZonesChangedTargetedTimeInModerateZone;
    }

    /**
     * @return Targeted Time in Five Heart Rate Zones Changed Targeted Time in Hard Zone
     */
    public int geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInHardZone() {
        int targetedTimeInFiveHeartRateZonesChangedTargetedTimeInHardZone;
        if (isOpCodeTargetedTimeInFiveHeartRateZonesChanged()) {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInHardZone = BLEUtils.createUInt16(mParameter, 6);
        } else {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInHardZone = 0;
        }
        return targetedTimeInFiveHeartRateZonesChangedTargetedTimeInHardZone;
    }

    /**
     * @return Targeted Time in Five Heart Rate Zones Changed Targeted Time in Maximum Zone
     */
    public int geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInMaximumZone() {
        int targetedTimeInFiveHeartRateZonesChangedTargetedTimeInMaximumZone;
        if (isOpCodeTargetedTimeInFiveHeartRateZonesChanged()) {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInMaximumZone = BLEUtils.createUInt16(mParameter, 8);
        } else {
            targetedTimeInFiveHeartRateZonesChangedTargetedTimeInMaximumZone = 0;
        }
        return targetedTimeInFiveHeartRateZonesChangedTargetedTimeInMaximumZone;
    }

    /**
     * @return Indoor Bike Simulation Parameters Changed Wind Speed
     */
    public int geIndoorBikeSimulationParametersChangedWindSpeed() {
        int indoorBikeSimulationParametersChangedWindSpeed;
        if (isOpCodeIndoorBikeSimulationParametersChanged()) {
            indoorBikeSimulationParametersChangedWindSpeed = BLEUtils.createSInt16(mParameter, 0);
        } else {
            indoorBikeSimulationParametersChangedWindSpeed = 0;
        }
        return indoorBikeSimulationParametersChangedWindSpeed;
    }

    /**
     * @return Indoor Bike Simulation Parameters Changed Wind Speed(Meters Per Second)
     */
    public double geIndoorBikeSimulationParametersChangedWindSpeedMetersPerSecond() {
        return INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_WIND_SPEED_RESOLUTION * geIndoorBikeSimulationParametersChangedWindSpeed();
    }

    /**
     * @return Indoor Bike Simulation Parameters Changed Grade
     */
    public int geIndoorBikeSimulationParametersChangedGrade() {
        int indoorBikeSimulationParametersChangedGrade;
        if (isOpCodeIndoorBikeSimulationParametersChanged()) {
            indoorBikeSimulationParametersChangedGrade = BLEUtils.createSInt16(mParameter, 2);
        } else {
            indoorBikeSimulationParametersChangedGrade = 0;
        }
        return indoorBikeSimulationParametersChangedGrade;
    }

    /**
     * @return Indoor Bike Simulation Parameters Changed Grade(Percentage)
     */
    public double geIndoorBikeSimulationParametersChangedGradePercentage() {
        return INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_GRADE_RESOLUTION * geIndoorBikeSimulationParametersChangedGrade();
    }

    /**
     * @return Indoor Bike Simulation Parameters Changed Coefficient of Rolling Resistance
     */
    public int geIndoorBikeSimulationParametersChangedCoefficientOfRollingResistance() {
        int indoorBikeSimulationParametersChangedCoefficientOfRollingResistance;
        if (isOpCodeIndoorBikeSimulationParametersChanged()) {
            indoorBikeSimulationParametersChangedCoefficientOfRollingResistance = BLEUtils.createUInt8(mParameter, 4);
        } else {
            indoorBikeSimulationParametersChangedCoefficientOfRollingResistance = 0;
        }
        return indoorBikeSimulationParametersChangedCoefficientOfRollingResistance;
    }

    /**
     * @return Indoor Bike Simulation Parameters Changed Coefficient of Rolling Resistance with Unit
     */
    public double geIndoorBikeSimulationParametersChangedCoefficientOfRollingResistanceWithUnit() {
        return INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_COEFFICIENT_OF_ROLLING_RESISTANCE_RESOLUTION * geIndoorBikeSimulationParametersChangedCoefficientOfRollingResistance();
    }

    /**
     * @return Indoor Bike Simulation Parameters Changed Wind Resistance Coefficient
     */
    public int geIndoorBikeSimulationParametersChangedWindResistanceCoefficient() {
        int indoorBikeSimulationParametersChangedWindResistanceCoefficient;
        if (isOpCodeIndoorBikeSimulationParametersChanged()) {
            indoorBikeSimulationParametersChangedWindResistanceCoefficient = BLEUtils.createUInt8(mParameter, 5);
        } else {
            indoorBikeSimulationParametersChangedWindResistanceCoefficient = 0;
        }
        return indoorBikeSimulationParametersChangedWindResistanceCoefficient;
    }

    /**
     * @return Indoor Bike Simulation Parameters Changed Wind Resistance Coefficient(Kilogram per Meter)
     */
    public double geIndoorBikeSimulationParametersChangedWindResistanceCoefficientKilogramPerMeter() {
        return INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_WIND_RESISTANCE_COEFFICIENT_RESOLUTION * geIndoorBikeSimulationParametersChangedWindResistanceCoefficient();
    }

    /**
     * @return Wheel Circumference Changed
     */
    public int geWheelCircumferenceChanged() {
        int wheelCircumferenceChanged;
        if (isOpCodeWheelCircumferenceChanged()) {
            wheelCircumferenceChanged = BLEUtils.createUInt16(mParameter, 0);
        } else {
            wheelCircumferenceChanged = 0;
        }
        return wheelCircumferenceChanged;
    }

    /**
     * @return Wheel Circumference Changed(Millimeter)
     */
    public double geWheelCircumferenceChangedMillimeter() {
        return WHEEL_CIRCUMFERENCE_CHANGED_RESOLUTION * geWheelCircumferenceChanged();
    }

    /**
     * @return {@code true}:Spin Down Requested, {@code false}:not Spin Down Requested
     */
    public boolean isSpinDownStatusSpinDownRequested() {
        return SPIN_DOWN_STATUS_SPIN_DOWN_REQUESTED == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return {@code true}:Success, {@code false}:not Success
     */
    public boolean isSpinDownStatusSuccess() {
        return SPIN_DOWN_STATUS_SUCCESS == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return {@code true}:Error, {@code false}:not Error
     */
    public boolean isSpinDownStatusError() {
        return SPIN_DOWN_STATUS_ERROR == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return {@code true}:Stop Pedaling, {@code false}:not Stop Pedaling
     */
    public boolean isSpinDownStatusStopPedaling() {
        return SPIN_DOWN_STATUS_STOP_PEDALING == BLEUtils.createUInt8(mParameter, 0);
    }

    /**
     * @return Targeted Cadence Changed
     */
    public int geTargetedCadenceChanged() {
        int targetedCadenceChanged;
        if (isOpCodeTargetedCadenceChanged()) {
            targetedCadenceChanged = BLEUtils.createUInt16(mParameter, 0);
        } else {
            targetedCadenceChanged = 0;
        }
        return targetedCadenceChanged;
    }

    /**
     * @return Targeted Cadence Changed(1/minute)
     */
    public double geTargetedCadenceChangedRpm() {
        return TARGETED_CADENCE_CHANGED_RESOLUTION * geTargetedCadenceChanged();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1 + mParameter.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mOpCode);
        byteBuffer.put(mParameter);
        return data;
    }

}
