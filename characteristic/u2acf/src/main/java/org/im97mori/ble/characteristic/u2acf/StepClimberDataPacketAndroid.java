package org.im97mori.ble.characteristic.u2acf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Step Climber Data packet (Characteristics UUID: 0x2ACF)
 */
@SuppressWarnings({"WeakerAccess"})
public class StepClimberDataPacketAndroid extends StepClimberDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<StepClimberDataPacketAndroid> CREATOR = new ByteArrayCreator<StepClimberDataPacketAndroid>() {

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
            return new StepClimberDataPacketAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACF
     */
    @Deprecated
    public StepClimberDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public StepClimberDataPacketAndroid(@NonNull byte[] values) {
        super(values);
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
        super(Objects.requireNonNull(in.createByteArray()));
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
