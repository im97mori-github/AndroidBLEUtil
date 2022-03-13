package org.im97mori.ble.characteristic.u2ace;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.MultiplePacketCreator;

/**
 * Cross Trainer Data (Characteristics UUID: 0x2ACE)
 */
@SuppressWarnings({"WeakerAccess"})
public class CrossTrainerDataAndroid extends CrossTrainerData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final MultiplePacketCreator<CrossTrainerDataAndroid, CrossTrainerDataPacketAndroid> CREATOR = new MultiplePacketCreator<CrossTrainerDataAndroid, CrossTrainerDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerDataAndroid createFromParcel(@NonNull Parcel in) {
            return new CrossTrainerDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerDataAndroid[] newArray(int size) {
            return new CrossTrainerDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public CrossTrainerDataAndroid createFromMultiplePacketArray(@NonNull CrossTrainerDataPacketAndroid[] multiplePacketArray) {
            return new CrossTrainerDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link CrossTrainerDataPacket} array
     *
     * @param crossTrainerDataPackets 1 or more Cross Trainer Data packet array
     */
    public CrossTrainerDataAndroid(@NonNull CrossTrainerDataPacket... crossTrainerDataPackets) {
        super(crossTrainerDataPackets);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CrossTrainerDataAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
    public CrossTrainerDataAndroid(@NonNull byte[] flags, int instantaneousSpeed, int averageSpeed, int totalDistance, int stepPerMinute, int averageStepRate, int strideCount, int positiveElevationGain, int negativeElevationGain, int inclination, int rampAngleSetting, int resistanceLevel, int instantaneousPower, int averagePower, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, instantaneousSpeed, averageSpeed, totalDistance, stepPerMinute, averageStepRate, strideCount, positiveElevationGain, negativeElevationGain, inclination, rampAngleSetting, resistanceLevel, instantaneousPower, averagePower, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
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
