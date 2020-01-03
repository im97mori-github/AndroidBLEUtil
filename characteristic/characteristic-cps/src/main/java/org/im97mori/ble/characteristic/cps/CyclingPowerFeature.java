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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_FEATURE_CHARACTERISTIC;

/**
 * Cycling Power Feature (Characteristics UUID: 0x2A65)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CyclingPowerFeature implements ByteArrayInterface, Parcelable {

    /**
     * @see #CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000001;

    /**
     * 0: Pedal Power Balance Supported False
     */
    public static final int CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Pedal Power Balance Supported True
     */
    public static final int CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000001;

    /**
     * @see #CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000010;

    /**
     * 0: Accumulated Torque Supported False
     */
    public static final int CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Accumulated Torque Supported True
     */
    public static final int CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000010;

    /**
     * @see #CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000100;

    /**
     * 0: Wheel Revolution Data Supported False
     */
    public static final int CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Wheel Revolution Data Supported True
     */
    public static final int CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000100;

    /**
     * @see #CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_MASK = 0b00000000_00000000_00000000_00001000;

    /**
     * 0: Crank Revolution Data Supported False
     */
    public static final int CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Crank Revolution Data Supported True
     */
    public static final int CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00001000;

    /**
     * @see #CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_MASK = 0b00000000_00000000_00000000_00010000;

    /**
     * 0: Extreme Magnitudes Supported False
     */
    public static final int CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Extreme Magnitudes Supported True
     */
    public static final int CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00010000;

    /**
     * @see #CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_MASK = 0b00000000_00000000_00000000_00100000;

    /**
     * 0: Extreme Angles Supported False
     */
    public static final int CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Extreme Angles Supported True
     */
    public static final int CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00100000;

    /**
     * @see #CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_MASK = 0b00000000_00000000_00000000_01000000;

    /**
     * 0: Top and Bottom Dead Spot Angles Supported False
     */
    public static final int CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Top and Bottom Dead Spot Angles Supported True
     */
    public static final int CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_TRUE = 0b00000000_00000000_00000000_01000000;

    /**
     * @see #CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_MASK = 0b00000000_00000000_00000000_10000000;

    /**
     * 0: Accumulated Energy Supported False
     */
    public static final int CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Accumulated Energy Supported True
     */
    public static final int CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_TRUE = 0b00000000_00000000_00000000_10000000;

    /**
     * @see #CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_MASK = 0b00000000_00000000_00000001_00000000;

    /**
     * 0: Offset Compensation Indicator Supported False
     */
    public static final int CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Offset Compensation Indicator Supported True
     */
    public static final int CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_TRUE = 0b00000000_00000000_00000001_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_MASK = 0b00000000_00000000_00000010_00000000;

    /**
     * 0: Offset Compensation Supported False
     */
    public static final int CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Offset Compensation Supported True
     */
    public static final int CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE = 0b00000000_00000000_00000010_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_MASK = 0b00000000_00000000_00000100_00000000;

    /**
     * 0: Cycling Power Measurement Characteristic Content Masking Supported False
     */
    public static final int CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Cycling Power Measurement Characteristic Content Masking Supported True
     */
    public static final int CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE = 0b00000000_00000000_00000100_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_MASK = 0b00000000_00000000_00001000_00000000;

    /**
     * 0: Multiple Sensor Locations Supported False
     */
    public static final int CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Multiple Sensor Locations Supported True
     */
    public static final int CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE = 0b00000000_00000000_00001000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_MASK = 0b00000000_00000000_00010000_00000000;

    /**
     * 0: Crank Length Adjustment Supported False
     */
    public static final int CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Crank Length Adjustment Supported True
     */
    public static final int CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE = 0b00000000_00000000_00010000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_MASK = 0b00000000_00000000_00100000_00000000;

    /**
     * 0: Chain Length Adjustment Supported False
     */
    public static final int CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Chain Length Adjustment Supported True
     */
    public static final int CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE = 0b00000000_00000000_00100000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_MASK = 0b00000000_00000000_01000000_00000000;

    /**
     * 0: Chain Weight Adjustment Supported False
     */
    public static final int CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Chain Weight Adjustment Supported True
     */
    public static final int CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_TRUE = 0b00000000_00000000_01000000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_MASK = 0b00000000_00000000_10000000_00000000;

    /**
     * 0: Span Length Adjustment Supported False
     */
    public static final int CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Span Length Adjustment Supported True
     */
    public static final int CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE = 0b00000000_00000000_10000000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_FORCE_BASED
     * @see #CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED
     */
    public static final int CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_SUPPORTED_MASK = 0b00000000_00000001_00000000_00000000;

    /**
     * 0: Sensor Measurement Context Force based
     */
    public static final int CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_FORCE_BASED = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Sensor Measurement Context Torque based
     */
    public static final int CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED = 0b00000000_00000001_00000000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_MASK = 0b00000000_00000010_00000000_00000000;

    /**
     * 0: Instantaneous Measurement Direction Supported False
     */
    public static final int CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Instantaneous Measurement Direction Supported True
     */
    public static final int CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_TRUE = 0b00000000_00000010_00000000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_MASK = 0b00000000_00000100_00000000_00000000;

    /**
     * 0: Factory Calibration Date Supported False
     */
    public static final int CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Factory Calibration Date Supported True
     */
    public static final int CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE = 0b00000000_00000100_00000000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_FALSE
     * @see #CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE
     */
    public static final int CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_MASK = 0b00000000_00001000_00000000_00000000;

    /**
     * 0: Enhanced Offset Compensation Supported False
     */
    public static final int CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Enhanced Offset Compensation Supported True
     */
    public static final int CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE = 0b00000000_00001000_00000000_00000000;

    /**
     * @see #CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_UNSPECIFIED
     * @see #CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_NOT_FOR_USE_IN_A_DISTRIBUTED_SYSTEM
     * @see #CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_CAN_BE_USED_IN_A_DISTRIBUTED_SYSTEM
     */
    public static final int CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_MASK = 0b00000000_00110000_00000000_00000000;

    /**
     * 0: Distribute System Support Unspecified (legacy sensor)
     */
    public static final int CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_UNSPECIFIED = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Distribute System Support Not for use in a distributed system
     */
    public static final int CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_NOT_FOR_USE_IN_A_DISTRIBUTED_SYSTEM = 0b00000000_00010000_00000000_00000000;

    /**
     * 1: Distribute System Support Can be used in a distributed system
     */
    public static final int CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_CAN_BE_USED_IN_A_DISTRIBUTED_SYSTEM = 0b00000000_00100000_00000000_00000000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CyclingPowerFeature> CREATOR = new ByteArrayCreater<CyclingPowerFeature>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerFeature createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerFeature(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerFeature[] newArray(int size) {
            return new CyclingPowerFeature[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerFeature createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CyclingPowerFeature(bluetoothGattCharacteristic);
        }

    };

    /**
     * Cycling Power Feature
     */
    private final byte[] mCyclingPowerFeature;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A65
     */
    public CyclingPowerFeature(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCyclingPowerFeature = Arrays.copyOfRange(values, 0, 4);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CyclingPowerFeature(@NonNull Parcel in) {
        mCyclingPowerFeature = in.createByteArray();
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
        dest.writeByteArray(mCyclingPowerFeature);
    }

    /**
     * @return Cycling Power Feature
     */
    public byte[] getCyclingPowerFeature() {
        return mCyclingPowerFeature;
    }

    /**
     * @return {@code true}:Pedal Power Balance not Supported, {@code false}:Pedal Power Balance Supported
     */
    public boolean isCyclingPowerFeaturePedalPowerBalanceNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_MASK, CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Pedal Power Balance Supported, {@code false}:Pedal Power Balance not Supported
     */
    public boolean isCyclingPowerFeaturePedalPowerBalanceSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_MASK, CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Accumulated Torque not Supported, {@code false}:Accumulated Torque Supported
     */
    public boolean isCyclingPowerFeatureAccumulatedTorqueNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_MASK, CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Accumulated Torque Supported, {@code false}:Accumulated Torque not Supported
     */
    public boolean isCyclingPowerFeatureAccumulatedTorqueSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_MASK, CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Wheel Revolution Data not Supported, {@code false}:Wheel Revolution Data Supported
     */
    public boolean isCyclingPowerFeatureWheelRevolutionDataNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_MASK, CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Wheel Revolution Data Supported, {@code false}:Wheel Revolution Data not Supported
     */
    public boolean isCyclingPowerFeatureWheelRevolutionDataSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_MASK, CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Crank Revolution Data not Supported, {@code false}:Crank Revolution Data Supported
     */
    public boolean isCyclingPowerFeatureCrankRevolutionDataNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_MASK, CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Crank Revolution Data Supported, {@code false}:Crank Revolution Data not Supported
     */
    public boolean isCyclingPowerFeatureCrankRevolutionDataSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_MASK, CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Extreme Magnitudes not Supported, {@code false}:Extreme Magnitudes Supported
     */
    public boolean isCyclingPowerFeatureExtremeMagnitudesNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_MASK, CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Extreme Magnitudes Supported, {@code false}:Extreme Magnitudes not Supported
     */
    public boolean isCyclingPowerFeatureExtremeMagnitudesSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_MASK, CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Extreme Angles not Supported, {@code false}:Extreme Angles Supported
     */
    public boolean isCyclingPowerFeatureExtremeAnglesNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_MASK, CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Extreme Angles Supported, {@code false}:Extreme Angles not Supported
     */
    public boolean isCyclingPowerFeatureExtremeAnglesSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_MASK, CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Top and Bottom Dead Spot Angles not Supported, {@code false}:Top and Bottom Dead Spot Angles Supported
     */
    public boolean isCyclingPowerFeatureTopAndBottomDeadSpotAnglesNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_MASK, CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Top and Bottom Dead Spot Angles Supported, {@code false}:Top and Bottom Dead Spot Angles not Supported
     */
    public boolean isCyclingPowerFeatureTopAndBottomDeadSpotAnglesSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_MASK, CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Accumulated Energy not Supported, {@code false}:Accumulated Energy Supported
     */
    public boolean isCyclingPowerFeatureAccumulatedEnergyNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_MASK, CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Accumulated Energy Supported, {@code false}:Accumulated Energy not Supported
     */
    public boolean isCyclingPowerFeatureAccumulatedEnergySupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_MASK, CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Offset Compensation Indicator not Supported, {@code false}:Offset Compensation Indicator Supported
     */
    public boolean isCyclingPowerFeatureOffsetCompensationIndicatorNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_MASK, CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Offset Compensation Indicator Supported, {@code false}:Offset Compensation Indicator not Supported
     */
    public boolean isCyclingPowerFeatureOffsetCompensationIndicatorSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_MASK, CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Offset Compensation not Supported, {@code false}:Offset Compensation Supported
     */
    public boolean isCyclingPowerFeatureOffsetCompensationNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_MASK, CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Offset Compensation Supported, {@code false}:Offset Compensation not Supported
     */
    public boolean isCyclingPowerFeatureOffsetCompensationSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_MASK, CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Cycling Power Measurement Characteristic Content Masking not Supported, {@code false}:Cycling Power Measurement Characteristic Content Masking Supported
     */
    public boolean isCyclingPowerFeatureCyclingPowerMeasurementCharacteristicContentMaskingNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_MASK
                , CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Cycling Power Measurement Characteristic Content Masking Supported, {@code false}:Cycling Power Measurement Characteristic Content Masking not Supported
     */
    public boolean isCyclingPowerFeatureCyclingPowerMeasurementCharacteristicContentMaskingSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_MASK
                , CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Multiple Sensor Locations not Supported, {@code false}:Multiple Sensor Locations Supported
     */
    public boolean isCyclingPowerFeatureCyclingMultipleSensorLocationsNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_MASK, CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Multiple Sensor Locations Supported, {@code false}:Multiple Sensor Locations not Supported
     */
    public boolean isCyclingPowerFeatureCyclingMultipleSensorLocationsSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_MASK, CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Crank Length Adjustment not Supported, {@code false}:Crank Length Adjustment Supported
     */
    public boolean isCyclingPowerFeatureCrankLengthAdjustmentNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Crank Length Adjustment Supported, {@code false}:Crank Length Adjustment not Supported
     */
    public boolean isCyclingPowerFeatureCrankLengthAdjustmentSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Chain Length Adjustment not Supported, {@code false}:Chain Length Adjustment Supported
     */
    public boolean isCyclingPowerFeatureChainLengthAdjustmentNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Chain Length Adjustment Supported, {@code false}:Chain Length Adjustment not Supported
     */
    public boolean isCyclingPowerFeatureChainLengthAdjustmentSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Chain Weight Adjustment not Supported, {@code false}:Chain Weight Adjustment Supported
     */
    public boolean isCyclingPowerFeatureChainWeightAdjustmentNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Chain Weight Adjustment Supported, {@code false}:Chain Weight Adjustment not Supported
     */
    public boolean isCyclingPowerFeatureChainWeightAdjustmentSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Span Length Adjustment not Supported, {@code false}:Span Length Adjustment Supported
     */
    public boolean isCyclingPowerFeatureSpanLengthAdjustmentNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Span Length Adjustment Supported, {@code false}:Span Length Adjustment not Supported
     */
    public boolean isCyclingPowerFeatureSpanLengthAdjustmentSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Sensor Measurement Context Force based, {@code false}:Sensor Measurement Context Torque based
     */
    public boolean isCyclingPowerFeatureSensorMeasurementContextForceBased() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_FORCE_BASED);
    }

    /**
     * @return {@code true}:Sensor Measurement Context Torque based, {@code false}:Sensor Measurement Context Force based
     */
    public boolean isCyclingPowerFeatureSensorMeasurementContextTorqueBased() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_SUPPORTED_MASK, CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED);
    }

    /**
     * @return {@code true}:Instantaneous Measurement Direction not Supported, {@code false}:Instantaneous Measurement Direction Supported
     */
    public boolean isCyclingPowerFeatureInstantaneousMeasurementDirectionNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_MASK, CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Instantaneous Measurement Direction Supported, {@code false}:Instantaneous Measurement Direction not Supported
     */
    public boolean isCyclingPowerFeatureInstantaneousMeasurementDirectionSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_MASK, CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Factory Calibration Date not Supported, {@code false}:Factory Calibration Date Supported
     */
    public boolean isCyclingPowerFeatureFactoryCalibrationDateNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_MASK, CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Factory Calibration Date Supported, {@code false}:Factory Calibration Date not Supported
     */
    public boolean isCyclingPowerFeatureFactoryCalibrationDateSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_MASK, CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Enhanced Offset Compensation not Supported, {@code false}:Enhanced Offset Compensation Supported
     */
    public boolean isCyclingPowerFeatureEnhancedOffsetCompensationNotSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_MASK, CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Enhanced Offset Compensation Supported, {@code false}:Enhanced Offset Compensation not Supported
     */
    public boolean isCyclingPowerFeatureEnhancedOffsetCompensationSupported() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_MASK, CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Distribute System Support Unspecified (legacy sensor), {@code false}:not Distribute System Support Unspecified (legacy sensor)
     */
    public boolean isCyclingPowerFeatureCyclingPowerDistributeSystemSupportUnspecified() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_MASK, CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_UNSPECIFIED);
    }

    /**
     * @return {@code true}:Distribute System Support Not for use in a distributed system, {@code false}:not Distribute System Support Not for use in a distributed system
     */
    public boolean isCyclingPowerFeatureCyclingPowerDistributeSystemSupportNotForUse() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_MASK, CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_NOT_FOR_USE_IN_A_DISTRIBUTED_SYSTEM);
    }

    /**
     * @return {@code true}:Distribute System Support Can be used in a distributed system, {@code false}:not Distribute System Support Can be used in a distributed system
     */
    public boolean isCyclingPowerFeatureCyclingPowerDistributeSystemSupportCanBeUsed() {
        return isFeatureMatched(CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_MASK, CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_CAN_BE_USED_IN_A_DISTRIBUTED_SYSTEM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mCyclingPowerFeature);
        return data;
    }

    /**
     * check Cycling Power Feature
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_FORCE_BASED}
     *               , {@link #CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED}
     *               , {@link #CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_FALSE}
     *               , {@link #CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE}
     *               , {@link #CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_UNSPECIFIED}
     *               , {@link #CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_NOT_FOR_USE_IN_A_DISTRIBUTED_SYSTEM}
     *               , {@link #CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_CAN_BE_USED_IN_A_DISTRIBUTED_SYSTEM}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFeatureMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt32(mCyclingPowerFeature, 0)) == expect;
    }

}
