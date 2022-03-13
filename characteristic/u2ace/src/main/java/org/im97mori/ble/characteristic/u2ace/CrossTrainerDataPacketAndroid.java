package org.im97mori.ble.characteristic.u2ace;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CROSS_TRAINER_DATA_CHARACTERISTIC;

/**
 * Cross Trainer Data packet (Characteristics UUID: 0x2ACE)
 */
@SuppressWarnings({"WeakerAccess"})
public class CrossTrainerDataPacketAndroid extends CrossTrainerDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CrossTrainerDataPacketAndroid> CREATOR = new ByteArrayCreator<CrossTrainerDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerDataPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new CrossTrainerDataPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerDataPacketAndroid[] newArray(int size) {
            return new CrossTrainerDataPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CrossTrainerDataPacketAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACE
     */
    public CrossTrainerDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param flags                 Flags
     * @param instantaneousSpeed    Instantaneous Speed
     * @param averageSpeed          Average Speed
     * @param totalDistance         Total Distance
     * @param stepPerMinute         Step Per Minute
     * @param averageStepRate       Average Step Rate
     * @param strideCount           Stride Count
     * @param positiveElevationGain Positive Elevation Gain
     * @param negativeElevationGain Negative Elevation Gain
     * @param inclination           Inclination
     * @param rampAngleSetting      Ramp Angle Setting
     * @param resistanceLevel       Resistance Level
     * @param instantaneousPower    Instantaneous Power
     * @param averagePower          Average Power
     * @param totalEnergy           Total Energy
     * @param energyPerHour         Energy Per Hour
     * @param energyPerMinute       Energy Per Minute
     * @param heartRate             Heart Rate
     * @param metabolicEquivalent   Metabolic Equivalent
     * @param elapsedTime           Elapsed Time
     * @param remainingTime         Remaining Time
     */
    public CrossTrainerDataPacketAndroid(@NonNull byte[] flags, int instantaneousSpeed, int averageSpeed, int totalDistance, int stepPerMinute, int averageStepRate, int strideCount, int positiveElevationGain, int negativeElevationGain, int inclination, int rampAngleSetting, int resistanceLevel, int instantaneousPower, int averagePower, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, instantaneousSpeed, averageSpeed, totalDistance, stepPerMinute, averageStepRate, strideCount, positiveElevationGain, negativeElevationGain, inclination, rampAngleSetting, resistanceLevel, instantaneousPower, averagePower, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CrossTrainerDataPacketAndroid(@NonNull Parcel in) {
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
