package org.im97mori.ble.characteristic.u2a63;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;

/**
 * Cycling Power Measurement (Characteristics UUID: 0x2A63)
 */
@SuppressWarnings({"WeakerAccess"})
public class CyclingPowerMeasurementAndroid extends CyclingPowerMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CyclingPowerMeasurementAndroid> CREATOR = new ByteArrayCreater<CyclingPowerMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerMeasurementAndroid[] newArray(int size) {
            return new CyclingPowerMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CyclingPowerMeasurementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A63
     */
    public CyclingPowerMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param flags                                         Flags
     * @param instantaneousPower                            Instantaneous Power
     * @param pedalPowerBalance                             Pedal Power Balance
     * @param accumulatedTorque                             Accumulated Torque
     * @param wheelRevolutionDataCumulativeWheelRevolutions Wheel Revolution Data - Cumulative Wheel Revolutions
     * @param wheelRevolutionDataLastWheelEventTime         Wheel Revolution Data - Last Wheel Event Time
     * @param crankRevolutionDataCumulativeCrankRevolutions Crank Revolution Data- Cumulative Crank Revolutions
     * @param crankRevolutionDataLastCrankEventTime         Crank Revolution Data- Last Crank Event Time
     * @param extremeForceMagnitudesMaximumForceMagnitude   Extreme Force Magnitudes - Maximum Force Magnitude
     * @param extremeForceMagnitudesMinimumForceMagnitude   Extreme Force Magnitudes - Minimum Force Magnitude
     * @param extremeTorqueMagnitudesMaximumTorqueMagnitude Extreme Torque Magnitudes- Maximum Torque Magnitude
     * @param extremeTorqueMagnitudesMinimumTorqueMagnitude Extreme Torque Magnitudes- Minimum Torque Magnitude
     * @param extremeAnglesMaximumAngle                     Extreme Angles - Maximum Angle
     * @param extremeAnglesMinimumAngle                     Extreme Angles - Minimum Angle
     * @param topDeadSpotAngle                              Top Dead Spot Angle Bottom Dead Spot Angle
     * @param bottomDeadSpotAngle                           Accumulated Energy
     */
    public CyclingPowerMeasurementAndroid(@NonNull byte[] flags, int instantaneousPower, int pedalPowerBalance, int accumulatedTorque, long wheelRevolutionDataCumulativeWheelRevolutions, int wheelRevolutionDataLastWheelEventTime, int crankRevolutionDataCumulativeCrankRevolutions, int crankRevolutionDataLastCrankEventTime, int extremeForceMagnitudesMaximumForceMagnitude, int extremeForceMagnitudesMinimumForceMagnitude, int extremeTorqueMagnitudesMaximumTorqueMagnitude, int extremeTorqueMagnitudesMinimumTorqueMagnitude, int extremeAnglesMaximumAngle, int extremeAnglesMinimumAngle, int topDeadSpotAngle, int bottomDeadSpotAngle, int accumulatedEnergy) {
        super(flags, instantaneousPower, pedalPowerBalance, accumulatedTorque, wheelRevolutionDataCumulativeWheelRevolutions, wheelRevolutionDataLastWheelEventTime, crankRevolutionDataCumulativeCrankRevolutions, crankRevolutionDataLastCrankEventTime, extremeForceMagnitudesMaximumForceMagnitude, extremeForceMagnitudesMinimumForceMagnitude, extremeTorqueMagnitudesMaximumTorqueMagnitude, extremeTorqueMagnitudesMinimumTorqueMagnitude, extremeAnglesMaximumAngle, extremeAnglesMinimumAngle, topDeadSpotAngle, bottomDeadSpotAngle, accumulatedEnergy);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private CyclingPowerMeasurementAndroid(@NonNull Parcel in) {
        super(in.createByteArray());
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
        dest.writeByteArray(getBytes());
    }

}
