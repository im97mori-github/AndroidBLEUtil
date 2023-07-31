package org.im97mori.ble.characteristic.u2ad0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Stair Climber Data packet (Characteristics UUID: 0x2AD0)
 */
@SuppressWarnings({"WeakerAccess"})
public class StairClimberDataPacketAndroid extends StairClimberDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<StairClimberDataPacketAndroid> CREATOR = new ByteArrayCreator<StairClimberDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StairClimberDataPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new StairClimberDataPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StairClimberDataPacketAndroid[] newArray(int size) {
            return new StairClimberDataPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public StairClimberDataPacketAndroid createFromByteArray(@NonNull byte[] values) {
            return new StairClimberDataPacketAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD0
     */
    @Deprecated
    public StairClimberDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public StairClimberDataPacketAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                 Flags
     * @param floors                Floors
     * @param stepPerMinute         Step Per Minute
     * @param averageStepRate       Average Step Rate
     * @param positiveElevationGain Positive Elevation Gain
     * @param strideCount           Stride Count
     * @param totalEnergy           Total Energy
     * @param energyPerHour         Energy Per Hour
     * @param energyPerMinute       Energy Per Minute
     * @param heartRate             Heart Rate
     * @param metabolicEquivalent   Metabolic Equivalent
     * @param elapsedTime           Elapsed Time
     * @param remainingTime         Remaining Time
     */
    public StairClimberDataPacketAndroid(@NonNull byte[] flags, int floors, int stepPerMinute, int averageStepRate, int positiveElevationGain, int strideCount, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, floors, stepPerMinute, averageStepRate, positiveElevationGain, strideCount, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private StairClimberDataPacketAndroid(@NonNull Parcel in) {
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
