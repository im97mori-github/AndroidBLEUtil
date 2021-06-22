package org.im97mori.ble.characteristic.u2acf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.STEP_CLIMBER_DATA_CHARACTERISTIC;

/**
 * Step Climber Data packet (Characteristics UUID: 0x2ACF)
 */
@SuppressWarnings({"WeakerAccess"})
public class StepClimberDataPacketAndroid extends StepClimberDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<StepClimberDataPacketAndroid> CREATOR = new ByteArrayCreater<StepClimberDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepClimberDataPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new StepClimberDataPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepClimberDataPacketAndroid[] newArray(int size) {
            return new StepClimberDataPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public StepClimberDataPacketAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new StepClimberDataPacketAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACF
     */
    public StepClimberDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param flags                 Flags
     * @param floors                Floors
     * @param stepCount             Step Count
     * @param stepPerMinute         Step Per Minute
     * @param averageStepRate       Average Step Rate
     * @param positiveElevationGain Positive Elevation Gain
     * @param totalEnergy           Total Energy
     * @param energyPerHour         Energy Per Hour
     * @param energyPerMinute       Energy Per Minute
     * @param heartRate             Heart Rate
     * @param metabolicEquivalent   Metabolic Equivalent
     * @param elapsedTime           Elapsed Time
     * @param remainingTime         Remaining Time
     */
    public StepClimberDataPacketAndroid(@NonNull byte[] flags, int floors, int stepCount, int stepPerMinute, int averageStepRate, int positiveElevationGain, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, floors, stepCount, stepPerMinute, averageStepRate, positiveElevationGain, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private StepClimberDataPacketAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
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
