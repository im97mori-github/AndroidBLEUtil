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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;

/**
 * Cycling Power Measurement (Characteristics UUID: 0x2A63)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CyclingPowerMeasurement implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE
     * @see #FLAGS_PEDAL_POWER_BALANCE_PRESENT_TRUE
     */
    public static final int FLAGS_PEDAL_POWER_BALANCE_PRESENT_MASK = 0b00000000_00000001;

    /**
     * 0: Pedal Power Balance Present False
     */
    public static final int FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Pedal Power Balance Present True
     */
    public static final int FLAGS_PEDAL_POWER_BALANCE_PRESENT_TRUE = 0b00000000_00000001;

    /**
     * @see #FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN
     * @see #FLAGS_PEDAL_POWER_BALANCE_REFERENCE_LEFT
     */
    public static final int FLAGS_PEDAL_POWER_BALANCE_REFERENCE_MASK = 0b00000000_00000010;

    /**
     * 0: Pedal Power Balance Reference Unknown
     */
    public static final int FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN = 0b00000000_00000000;

    /**
     * 1: Pedal Power Balance Reference Left
     */
    public static final int FLAGS_PEDAL_POWER_BALANCE_REFERENCE_LEFT = 0b00000000_00000010;

    /**
     * @see #FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE
     * @see #FLAGS_ACCUMULATED_TORQUE_PRESENT_TRUE
     */
    public static final int FLAGS_ACCUMULATED_TORQUE_PRESENT_MASK = 0b00000000_00000100;

    /**
     * 0: Accumulated Torque Present False
     */
    public static final int FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Accumulated Torque Present True
     */
    public static final int FLAGS_ACCUMULATED_TORQUE_PRESENT_TRUE = 0b00000000_00000100;

    /**
     * @see #FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED
     * @see #FLAGS_ACCUMULATED_TORQUE_SOURCE_CRANK_BASED
     */
    public static final int FLAGS_ACCUMULATED_TORQUE_SOURCE_MASK = 0b00000000_00001000;

    /**
     * 0:Accumulated Torque Source Wheel Based
     */
    public static final int FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED = 0b00000000_00000000;

    /**
     * 1:Accumulated Torque Source Crank Based
     */
    public static final int FLAGS_ACCUMULATED_TORQUE_SOURCE_CRANK_BASED = 0b00000000_00001000;

    /**
     * @see #FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
     * @see #FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE
     */
    public static final int FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_MASK = 0b00000000_00010000;

    /**
     * 0: Wheel Revolution Data Present True
     */
    public static final int FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Wheel Revolution Data Present False
     */
    public static final int FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE = 0b00000000_00010000;

    /**
     * @see #FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
     * @see #FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
     */
    public static final int FLAGS_CRANK_REVOLUTION_DATA_PRESENT_MASK = 0b00000000_00100000;

    /**
     * 0: Crank Revolution Data Present False
     */
    public static final int FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Crank Revolution Data Present True
     */
    public static final int FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE = 0b00000000_00100000;

    /**
     * @see #FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE
     * @see #FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_TRUE
     */
    public static final int FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_MASK = 0b00000000_01000000;

    /**
     * 0: Extreme Force Magnitudes Present False
     */
    public static final int FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Extreme Force Magnitudes Present True
     */
    public static final int FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_TRUE = 0b00000000_01000000;

    /**
     * @see #FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE
     * @see #FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_TRUE
     */
    public static final int FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_MASK = 0b00000000_10000000;

    /**
     * 0: Extreme Torque Magnitudes Present False
     */
    public static final int FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Extreme Torque Magnitudes Present True
     */
    public static final int FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_TRUE = 0b00000000_10000000;

    /**
     * @see #FLAGS_EXTREME_ANGLES_PRESENT_FALSE
     * @see #FLAGS_EXTREME_ANGLES_PRESENT_TRUE
     */
    public static final int FLAGS_EXTREME_ANGLES_PRESENT_MASK = 0b00000001_00000000;

    /**
     * 0: Extreme Angles Present False
     */
    public static final int FLAGS_EXTREME_ANGLES_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Extreme Angles Present True
     */
    public static final int FLAGS_EXTREME_ANGLES_PRESENT_TRUE = 0b00000001_00000000;

    /**
     * @see #FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE
     * @see #FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_TRUE
     */
    public static final int FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_MASK = 0b00000010_00000000;

    /**
     * 0: Top Dead Spot Angle Present False
     */
    public static final int FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Top Dead Spot Angle Present True
     */
    public static final int FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_TRUE = 0b00000010_00000000;

    /**
     * @see #FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE
     * @see #FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_TRUE
     */
    public static final int FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_MASK = 0b00000100_00000000;

    /**
     * 0: Bottom Dead Spot Angle Present False
     */
    public static final int FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Bottom Dead Spot Angle Present True
     */
    public static final int FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_TRUE = 0b00000100_00000000;

    /**
     * @see #FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE
     * @see #FLAGS_ACCUMULATED_ENERGY_PRESENT_TRUE
     */
    public static final int FLAGS_ACCUMULATED_ENERGY_PRESENT_MASK = 0b00001000_00000000;

    /**
     * 0: Accumulated Energy Present False
     */
    public static final int FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Accumulated Energy Present True
     */
    public static final int FLAGS_ACCUMULATED_ENERGY_PRESENT_TRUE = 0b00001000_00000000;

    /**
     * @see #FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE
     * @see #FLAGS_OFFSET_COMPENSATION_INDICATION_TRUE
     */
    public static final int FLAGS_OFFSET_COMPENSATION_INDICATION_MASK = 0b00010000_00000000;

    /**
     * 0: Offset Compensation Indicator False
     */
    public static final int FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE = 0b00000000_00000000;

    /**
     * 1: Offset Compensation Indicator True
     */
    public static final int FLAGS_OFFSET_COMPENSATION_INDICATION_TRUE = 0b00010000_00000000;

    /**
     * Pedal Power Balance Unit 1/2 percentage
     */
    public static final double PEDAL_POWER_BALANCE_RESOLUTION = 0.5d;

    /**
     * Accumulated Torque Unit 1/32 newton metres
     */
    public static final double ACCUMULATED_TORQUE_RESOLUTION = 1 / 32d;

    /**
     * Wheel Revolution Data - Last Wheel Event Time Unit 1/2048 seconds
     */
    public static final double WHEEL_REVOLUTION_DATA_LAST_WHEEL_EVENT_TIME_RESOLUTION = 1 / 2048d;

    /**
     * Crank Revolution Data- Last Crank Event Time Unit 1/1024 seconds
     */
    public static final double CRANK_REVOLUTION_DATA_LAST_CRANK_EVENT_TIME_RESOLUTION = 1 / 1024d;

    /**
     * Extreme Torque Magnitudes- Maximum Torque Magnitude Unit 1/32 newton metres
     */
    public static final double EXTREME_TOURQUE_MAGNITUDES_MAXIMUM_TORQUE_MAGNITUDE = 1 / 32d;

    /**
     * Extreme Torque Magnitudes- Minimum Torque Magnitude Unit 1/32 newton metres
     */
    public static final double EXTREME_TOURQUE_MAGNITUDES_MINIMUM_TORQUE_MAGNITUDE = 1 / 32d;

    /**
     * Accumulated Energy Unit 1 kilojoules
     */
    public static final double ACCUMATED_ENERGY_RESOLUTION = 0.001d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CyclingPowerMeasurement> CREATOR = new ByteArrayCreater<CyclingPowerMeasurement>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerMeasurement createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerMeasurement(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerMeasurement[] newArray(int size) {
            return new CyclingPowerMeasurement[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerMeasurement createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CyclingPowerMeasurement(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Instantaneous Power
     */
    private final int mInstantaneousPower;

    /**
     * Pedal Power Balance
     */
    private final int mPedalPowerBalance;

    /**
     * Accumulated Torque
     */
    private final int mAccumulatedTorque;

    /**
     * Wheel Revolution Data - Cumulative Wheel Revolutions
     */
    private final long mWheelRevolutionDataCumulativeWheelRevolutions;

    /**
     * Wheel Revolution Data - Last Wheel Event Time
     */
    private final int mWheelRevolutionDataLastWheelEventTime;

    /**
     * Crank Revolution Data- Cumulative Crank Revolutions
     */
    private final int mCrankRevolutionDataCumulativeCrankRevolutions;

    /**
     * Crank Revolution Data- Last Crank Event Time
     */
    private final int mCrankRevolutionDataLastCrankEventTime;

    /**
     * Extreme Force Magnitudes - Maximum Force Magnitude
     */
    private final int mExtremeForceMagnitudesMaximumForceMagnitude;

    /**
     * Extreme Force Magnitudes - Minimum Force Magnitude
     */
    private final int mExtremeForceMagnitudesMinimumForceMagnitude;

    /**
     * Extreme Torque Magnitudes- Maximum Torque Magnitude
     */
    private final int mExtremeTorqueMagnitudesMaximumTorqueMagnitude;

    /**
     * Extreme Torque Magnitudes- Minimum Torque Magnitude
     */
    private final int mExtremeTorqueMagnitudesMinimumTorqueMagnitude;

    /**
     * Extreme Angles - Maximum Angle
     */
    private final int mExtremeAnglesMaximumAngle;

    /**
     * Extreme Angles - Minimum Angle
     */
    private final int mExtremeAnglesMinimumAngle;

    /**
     * Top Dead Spot Angle
     */
    private final int mTopDeadSpotAngle;

    /**
     * Bottom Dead Spot Angle
     */
    private final int mBottomDeadSpotAngle;

    /**
     * Accumulated Energy
     */
    private final int mAccumulatedEnergy;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A63
     */
    public CyclingPowerMeasurement(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 0;
        mFlags = Arrays.copyOfRange(values, index, 2);
        index += 2;
        mInstantaneousPower = BLEUtils.createSInt16(values, index);
        index += 2;
        if (isFlagsPedalPowerBalancePresent()) {
            mPedalPowerBalance = (values[index] & 0xff);
            index++;
        } else {
            mPedalPowerBalance = 0;
        }
        if (isFlagsAccumulatedTorquePresent()) {
            mAccumulatedTorque = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mAccumulatedTorque = 0;
        }
        if (isFlagsWheelRevolutionDataPresent()) {
            mWheelRevolutionDataCumulativeWheelRevolutions = BLEUtils.createUInt32(values, index);
            index += 4;
            mWheelRevolutionDataLastWheelEventTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mWheelRevolutionDataCumulativeWheelRevolutions = 0;
            mWheelRevolutionDataLastWheelEventTime = 0;
        }
        if (isFlagsCrankRevolutionDataPresent()) {
            mCrankRevolutionDataCumulativeCrankRevolutions = BLEUtils.createUInt16(values, index);
            index += 2;
            mCrankRevolutionDataLastCrankEventTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mCrankRevolutionDataCumulativeCrankRevolutions = 0;
            mCrankRevolutionDataLastCrankEventTime = 0;
        }
        if (isFlagsExtremeForceMagnitudesPresent()) {
            mExtremeForceMagnitudesMaximumForceMagnitude = BLEUtils.createSInt16(values, index);
            index += 2;
            mExtremeForceMagnitudesMinimumForceMagnitude = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mExtremeForceMagnitudesMaximumForceMagnitude = 0;
            mExtremeForceMagnitudesMinimumForceMagnitude = 0;
        }
        if (isFlagsExtremeTorqueMagnitudesPresent()) {
            mExtremeTorqueMagnitudesMaximumTorqueMagnitude = BLEUtils.createSInt16(values, index);
            index += 2;
            mExtremeTorqueMagnitudesMinimumTorqueMagnitude = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mExtremeTorqueMagnitudesMaximumTorqueMagnitude = 0;
            mExtremeTorqueMagnitudesMinimumTorqueMagnitude = 0;
        }
        if (isFlagsExtremeAnglesPresent()) {
            mExtremeAnglesMaximumAngle = BLEUtils.createUInt12(values, index);
            mExtremeAnglesMinimumAngle = BLEUtils.createUInt12(values, index, 12);
            index += 3;
        } else {
            mExtremeAnglesMaximumAngle = 0;
            mExtremeAnglesMinimumAngle = 0;
        }
        if (isFlagsTopDeadSpotAnglePresent()) {
            mTopDeadSpotAngle = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mTopDeadSpotAngle = 0;
        }
        if (isFlagsBottomDeadSpotAnglePresent()) {
            mBottomDeadSpotAngle = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mBottomDeadSpotAngle = 0;
        }
        if (isFlagsAccumulatedEnergyPresent()) {
            mAccumulatedEnergy = BLEUtils.createUInt16(values, index);
        } else {
            mAccumulatedEnergy = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CyclingPowerMeasurement(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mInstantaneousPower = in.readInt();
        mPedalPowerBalance = in.readInt();
        mAccumulatedTorque = in.readInt();
        mWheelRevolutionDataCumulativeWheelRevolutions = in.readLong();
        mWheelRevolutionDataLastWheelEventTime = in.readInt();
        mCrankRevolutionDataCumulativeCrankRevolutions = in.readInt();
        mCrankRevolutionDataLastCrankEventTime = in.readInt();
        mExtremeForceMagnitudesMaximumForceMagnitude = in.readInt();
        mExtremeForceMagnitudesMinimumForceMagnitude = in.readInt();
        mExtremeTorqueMagnitudesMaximumTorqueMagnitude = in.readInt();
        mExtremeTorqueMagnitudesMinimumTorqueMagnitude = in.readInt();
        mExtremeAnglesMaximumAngle = in.readInt();
        mExtremeAnglesMinimumAngle = in.readInt();
        mTopDeadSpotAngle = in.readInt();
        mBottomDeadSpotAngle = in.readInt();
        mAccumulatedEnergy = in.readInt();
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
        dest.writeByteArray(mFlags);
        dest.writeInt(mInstantaneousPower);
        dest.writeInt(mPedalPowerBalance);
        dest.writeInt(mAccumulatedTorque);
        dest.writeLong(mWheelRevolutionDataCumulativeWheelRevolutions);
        dest.writeInt(mWheelRevolutionDataLastWheelEventTime);
        dest.writeInt(mCrankRevolutionDataCumulativeCrankRevolutions);
        dest.writeInt(mCrankRevolutionDataLastCrankEventTime);
        dest.writeInt(mExtremeForceMagnitudesMaximumForceMagnitude);
        dest.writeInt(mExtremeForceMagnitudesMinimumForceMagnitude);
        dest.writeInt(mExtremeTorqueMagnitudesMaximumTorqueMagnitude);
        dest.writeInt(mExtremeTorqueMagnitudesMinimumTorqueMagnitude);
        dest.writeInt(mExtremeAnglesMaximumAngle);
        dest.writeInt(mExtremeAnglesMinimumAngle);
        dest.writeInt(mTopDeadSpotAngle);
        dest.writeInt(mBottomDeadSpotAngle);
        dest.writeInt(mAccumulatedEnergy);
    }

    /**
     * @return Flags
     */
    public byte[] getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:Pedal Power Balance not Present, {@code false}:Pedal Power Balance Present
     */
    public boolean isFlagsPedalPowerBalanceNotPresent() {
        return isFlagsMatched(FLAGS_PEDAL_POWER_BALANCE_PRESENT_MASK, FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Pedal Power Balance Present, {@code false}:Pedal Power Balance not Present
     */
    public boolean isFlagsPedalPowerBalancePresent() {
        return isFlagsMatched(FLAGS_PEDAL_POWER_BALANCE_PRESENT_MASK, FLAGS_PEDAL_POWER_BALANCE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Pedal Power Balance Reference Unknown, {@code false}:Pedal Power Balance Reference Left
     */
    public boolean isFlagsPedalPowerBalanceReferenceUnknown() {
        return isFlagsMatched(FLAGS_PEDAL_POWER_BALANCE_REFERENCE_MASK, FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN);
    }

    /**
     * @return {@code true}:Pedal Power Balance Reference Left, {@code false}:Pedal Power Balance Reference Unknown
     */
    public boolean isFlagsPedalPowerBalanceReferenceLeft() {
        return isFlagsMatched(FLAGS_PEDAL_POWER_BALANCE_REFERENCE_MASK, FLAGS_PEDAL_POWER_BALANCE_REFERENCE_LEFT);
    }

    /**
     * @return {@code true}:Accumulated Torque not Present, {@code false}:Accumulated Torque Present
     */
    public boolean isFlagsAccumulatedTorqueNotPresent() {
        return isFlagsMatched(FLAGS_ACCUMULATED_TORQUE_PRESENT_MASK, FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Accumulated Torque Present, {@code false}:Accumulated Torque not Present
     */
    public boolean isFlagsAccumulatedTorquePresent() {
        return isFlagsMatched(FLAGS_ACCUMULATED_TORQUE_PRESENT_MASK, FLAGS_ACCUMULATED_TORQUE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Accumulated Torque Source Wheel Based, {@code false}:Accumulated Torque Source Crank Based
     */
    public boolean isFlagsAccumulatedTorqueSourceWheelBased() {
        return isFlagsMatched(FLAGS_ACCUMULATED_TORQUE_SOURCE_MASK, FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED);
    }

    /**
     * @return {@code true}:Accumulated Torque Source Crank Based, {@code false}:Accumulated Torque Source Wheel Based
     */
    public boolean isFlagsAccumulatedTorqueSourceCrankBased() {
        return isFlagsMatched(FLAGS_ACCUMULATED_TORQUE_SOURCE_MASK, FLAGS_ACCUMULATED_TORQUE_SOURCE_CRANK_BASED);
    }

    /**
     * @return {@code true}:Wheel Revolution Data not Present, {@code false}:Wheel Revolution Data Present
     */
    public boolean isFlagsWheelRevolutionDataNotPresent() {
        return isFlagsMatched(FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_MASK, FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Wheel Revolution Data Present, {@code false}:Wheel Revolution Data not Present
     */
    public boolean isFlagsWheelRevolutionDataPresent() {
        return isFlagsMatched(FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_MASK, FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Crank Revolution Data not Present, {@code false}:Crank Revolution Data Present
     */
    public boolean isFlagsCrankRevolutionDataNotPresent() {
        return isFlagsMatched(FLAGS_CRANK_REVOLUTION_DATA_PRESENT_MASK, FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Crank Revolution Data Present, {@code false}:Crank Revolution Data not Present
     */
    public boolean isFlagsCrankRevolutionDataPresent() {
        return isFlagsMatched(FLAGS_CRANK_REVOLUTION_DATA_PRESENT_MASK, FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Extreme Force Magnitudes not Present, {@code false}:Extreme Force Magnitudes Present
     */
    public boolean isFlagsExtremeForceMagnitudesNotPresent() {
        return isFlagsMatched(FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_MASK, FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Extreme Force Magnitudes Present, {@code false}:Extreme Force Magnitudes not Present
     */
    public boolean isFlagsExtremeForceMagnitudesPresent() {
        return isFlagsMatched(FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_MASK, FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Extreme Torque Magnitudes not Present, {@code false}:Extreme Torque Magnitudes Present
     */
    public boolean isFlagsExtremeTorqueMagnitudesNotPresent() {
        return isFlagsMatched(FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_MASK, FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Extreme Torque Magnitudes Present, {@code false}:Extreme Torque Magnitudes not Present
     */
    public boolean isFlagsExtremeTorqueMagnitudesPresent() {
        return isFlagsMatched(FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_MASK, FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Extreme Angles not Present, {@code false}:Extreme Angles Present
     */
    public boolean isFlagsExtremeAnglesNotPresent() {
        return isFlagsMatched(FLAGS_EXTREME_ANGLES_PRESENT_MASK, FLAGS_EXTREME_ANGLES_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Extreme Angles Present, {@code false}:Extreme Angles not Present
     */
    public boolean isFlagsExtremeAnglesPresent() {
        return isFlagsMatched(FLAGS_EXTREME_ANGLES_PRESENT_MASK, FLAGS_EXTREME_ANGLES_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Top Dead Spot Angle not Present, {@code false}:Top Dead Spot Angle Present
     */
    public boolean isFlagsTopDeadSpotAngleNotPresent() {
        return isFlagsMatched(FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_MASK, FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Top Dead Spot Angle Present, {@code false}:Top Dead Spot Angle not Present
     */
    public boolean isFlagsTopDeadSpotAnglePresent() {
        return isFlagsMatched(FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_MASK, FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Bottom Dead Spot Angle not Present, {@code false}:Bottom Dead Spot Angle Present
     */
    public boolean isFlagsBottomDeadSpotAngleNotPresent() {
        return isFlagsMatched(FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_MASK, FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Bottom Dead Spot Angle Present, {@code false}:Bottom Dead Spot Angle not Present
     */
    public boolean isFlagsBottomDeadSpotAnglePresent() {
        return isFlagsMatched(FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_MASK, FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Accumulated Energy not Present, {@code false}:Accumulated Energy Present
     */
    public boolean isFlagsAccumulatedEnergyNotPresent() {
        return isFlagsMatched(FLAGS_ACCUMULATED_ENERGY_PRESENT_MASK, FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Accumulated Energy Present, {@code false}:Accumulated Energy not Present
     */
    public boolean isFlagsAccumulatedEnergyPresent() {
        return isFlagsMatched(FLAGS_ACCUMULATED_ENERGY_PRESENT_MASK, FLAGS_ACCUMULATED_ENERGY_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Offset Compensation not Indicator, {@code false}:Offset Compensation Indicator
     */
    public boolean isFlagsOffsetCompensationNotIndicator() {
        return isFlagsMatched(FLAGS_OFFSET_COMPENSATION_INDICATION_MASK, FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE);
    }

    /**
     * @return {@code true}:Offset Compensation Indicator, {@code false}:Offset Compensation not Indicator
     */
    public boolean isFlagsOffsetCompensationIndicator() {
        return isFlagsMatched(FLAGS_OFFSET_COMPENSATION_INDICATION_MASK, FLAGS_OFFSET_COMPENSATION_INDICATION_TRUE);
    }

    /**
     * @return Instantaneous Power
     */
    public int getInstantaneousPower() {
        return mInstantaneousPower;
    }

    /**
     * @return Pedal Power Balance
     */
    public int getPedalPowerBalance() {
        return mPedalPowerBalance;
    }

    /**
     * @return Pedal Power Balance(percentage)
     */
    public double getPedalPowerBalancePercentage() {
        return PEDAL_POWER_BALANCE_RESOLUTION * mPedalPowerBalance;
    }

    /**
     * @return Accumulated Torque
     */
    public int getAccumulatedTorque() {
        return mAccumulatedTorque;
    }

    /**
     * @return Accumulated Torque(newton metres)
     */
    public double getAccumulatedTorqueNewtonMetres() {
        return ACCUMULATED_TORQUE_RESOLUTION * mAccumulatedTorque;
    }

    /**
     * @return Wheel Revolution Data - Cumulative Wheel Revolutions
     */
    public long getWheelRevolutionDataCumulativeWheelRevolutions() {
        return mWheelRevolutionDataCumulativeWheelRevolutions;
    }

    /**
     * @return Wheel Revolution Data - Last Wheel Event Time
     */
    public int getWheelRevolutionDataLastWheelEventTime() {
        return mWheelRevolutionDataLastWheelEventTime;
    }

    /**
     * @return Wheel Revolution Data - Last Wheel Event Time(seconds)
     */
    public double getWheelRevolutionDataLastWheelEventTimeSeconds() {
        return WHEEL_REVOLUTION_DATA_LAST_WHEEL_EVENT_TIME_RESOLUTION * mWheelRevolutionDataLastWheelEventTime;
    }

    /**
     * @return Crank Revolution Data- Cumulative Crank Revolutions
     */
    public int getCrankRevolutionDataCumulativeCrankRevolutions() {
        return mCrankRevolutionDataCumulativeCrankRevolutions;
    }

    /**
     * @return Crank Revolution Data- Last Crank Event Time
     */
    public int getCrankRevolutionDataLastCrankEventTime() {
        return mCrankRevolutionDataLastCrankEventTime;
    }

    /**
     * @return Crank Revolution Data- Last Crank Event Time(seconds)
     */
    public double getCrankRevolutionDataLastCrankEventTimeSeconds() {
        return CRANK_REVOLUTION_DATA_LAST_CRANK_EVENT_TIME_RESOLUTION * mCrankRevolutionDataLastCrankEventTime;
    }

    /**
     * @return Extreme Force Magnitudes - Maximum Force Magnitude
     */
    public int getExtremeForceMagnitudesMaximumForceMagnitude() {
        return mExtremeForceMagnitudesMaximumForceMagnitude;
    }

    /**
     * @return Extreme Force Magnitudes - Minimum Force Magnitude
     */
    public int getExtremeForceMagnitudesMinimumForceMagnitude() {
        return mExtremeForceMagnitudesMinimumForceMagnitude;
    }

    /**
     * @return Extreme Torque Magnitudes- Maximum Torque Magnitude
     */
    public int getExtremeTorqueMagnitudesMaximumTorqueMagnitude() {
        return mExtremeTorqueMagnitudesMaximumTorqueMagnitude;
    }

    /**
     * @return Extreme Torque Magnitudes- Maximum Torque Magnitude(newton metres)
     */
    public double getExtremeTorqueMagnitudesMaximumTorqueMagnitudeNewtonMetres() {
        return EXTREME_TOURQUE_MAGNITUDES_MAXIMUM_TORQUE_MAGNITUDE * mExtremeTorqueMagnitudesMaximumTorqueMagnitude;
    }

    /**
     * @return Extreme Torque Magnitudes- Minimum Torque Magnitude
     */
    public int getExtremeTorqueMagnitudesMinimumTorqueMagnitude() {
        return mExtremeTorqueMagnitudesMinimumTorqueMagnitude;
    }

    /**
     * @return Extreme Torque Magnitudes- Minimum Torque Magnitude(newton metres)
     */
    public double getExtremeTorqueMagnitudesMinimumTorqueMagnitudeNewtonMetres() {
        return EXTREME_TOURQUE_MAGNITUDES_MINIMUM_TORQUE_MAGNITUDE * mExtremeTorqueMagnitudesMinimumTorqueMagnitude;
    }

    /**
     * @return Extreme Angles - Maximum Angle
     */
    public int getExtremeAnglesMaximumAngle() {
        return mExtremeAnglesMaximumAngle;
    }

    /**
     * @return Extreme Angles - Minimum Angle
     */
    public int getExtremeAnglesMinimumAngle() {
        return mExtremeAnglesMinimumAngle;
    }

    /**
     * @return Top Dead Spot Angle
     */
    public int getTopDeadSpotAngle() {
        return mTopDeadSpotAngle;
    }

    /**
     * @return Bottom Dead Spot Angle
     */
    public int getBottomDeadSpotAngle() {
        return mBottomDeadSpotAngle;
    }

    /**
     * @return Accumulated Energy
     */
    public int getAccumulatedEnergy() {
        return mAccumulatedEnergy;
    }

    /**
     * @return Accumulated Energy(kilojoules)
     */
    public double getAccumulatedEnergyKiloJoules() {
        return ACCUMATED_ENERGY_RESOLUTION * mAccumulatedEnergy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[34];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        length += 2;
        byteBuffer.putShort((short) mInstantaneousPower);
        length += 2;
        if (isFlagsPedalPowerBalancePresent()) {
            byteBuffer.put((byte) mPedalPowerBalance);
            length++;
        }
        if (isFlagsAccumulatedTorquePresent()) {
            byteBuffer.putShort((short) mAccumulatedTorque);
            length += 2;
        }
        if (isFlagsWheelRevolutionDataPresent()) {
            byteBuffer.putInt((int) mWheelRevolutionDataCumulativeWheelRevolutions);
            byteBuffer.putShort((short) mWheelRevolutionDataLastWheelEventTime);
            length += 6;
        }
        if (isFlagsCrankRevolutionDataPresent()) {
            byteBuffer.putShort((short) mCrankRevolutionDataCumulativeCrankRevolutions);
            byteBuffer.putShort((short) mCrankRevolutionDataLastCrankEventTime);
            length += 4;
        }
        if (isFlagsExtremeForceMagnitudesPresent()) {
            byteBuffer.putShort((short) mExtremeForceMagnitudesMaximumForceMagnitude);
            byteBuffer.putShort((short) mExtremeForceMagnitudesMinimumForceMagnitude);
            length += 4;
        }
        if (isFlagsExtremeTorqueMagnitudesPresent()) {
            byteBuffer.putShort((short) mExtremeTorqueMagnitudesMaximumTorqueMagnitude);
            byteBuffer.putShort((short) mExtremeTorqueMagnitudesMinimumTorqueMagnitude);
            length += 4;
        }
        if (isFlagsExtremeAnglesPresent()) {
            int extremeAngles = (mExtremeAnglesMinimumAngle << 12) | mExtremeAnglesMaximumAngle;
            byteBuffer.put((byte) extremeAngles);
            byteBuffer.put((byte) (extremeAngles >> 8));
            byteBuffer.put((byte) (extremeAngles >> 16));
            length += 3;
        }
        if (isFlagsTopDeadSpotAnglePresent()) {
            byteBuffer.putShort((short) mTopDeadSpotAngle);
            length += 2;
        }
        if (isFlagsBottomDeadSpotAnglePresent()) {
            byteBuffer.putShort((short) mBottomDeadSpotAngle);
            length += 2;
        }
        if (isFlagsAccumulatedEnergyPresent()) {
            byteBuffer.putShort((short) mAccumulatedEnergy);
            length += 2;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAGS_PEDAL_POWER_BALANCE_PRESENT_FALSE}
     *               , {@link #FLAGS_PEDAL_POWER_BALANCE_PRESENT_TRUE}
     *               , {@link #FLAGS_PEDAL_POWER_BALANCE_REFERENCE_UNKNOWN}
     *               , {@link #FLAGS_PEDAL_POWER_BALANCE_REFERENCE_LEFT}
     *               , {@link #FLAGS_ACCUMULATED_TORQUE_PRESENT_FALSE}
     *               , {@link #FLAGS_ACCUMULATED_TORQUE_PRESENT_TRUE}
     *               , {@link #FLAGS_ACCUMULATED_TORQUE_SOURCE_WHEEL_BASED}
     *               , {@link #FLAGS_ACCUMULATED_TORQUE_SOURCE_CRANK_BASED}
     *               , {@link #FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE}
     *               , {@link #FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE}
     *               , {@link #FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE}
     *               , {@link #FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE}
     *               , {@link #FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_FALSE}
     *               , {@link #FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_TRUE}
     *               , {@link #FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_FALSE}
     *               , {@link #FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_TRUE}
     *               , {@link #FLAGS_EXTREME_ANGLES_PRESENT_FALSE}
     *               , {@link #FLAGS_EXTREME_ANGLES_PRESENT_TRUE}
     *               , {@link #FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_FALSE}
     *               , {@link #FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_TRUE}
     *               , {@link #FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_FALSE}
     *               , {@link #FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_TRUE}
     *               , {@link #FLAGS_ACCUMULATED_ENERGY_PRESENT_FALSE}
     *               , {@link #FLAGS_ACCUMULATED_ENERGY_PRESENT_TRUE}
     *               , {@link #FLAGS_OFFSET_COMPENSATION_INDICATION_FALSE}
     *               , {@link #FLAGS_OFFSET_COMPENSATION_INDICATION_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mFlags, 0)) == expect;
    }

}
