package org.im97mori.ble.characteristic.u2acf;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Step Climber Data (Characteristics UUID: 0x2ACF)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class StepClimberDataAndroid extends StepClimberData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<StepClimberDataAndroid, StepClimberDataPacketAndroid> CREATOR = new MultiplePacketCreater<StepClimberDataAndroid, StepClimberDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepClimberDataAndroid createFromParcel(@NonNull Parcel in) {
            return new StepClimberDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepClimberDataAndroid[] newArray(int size) {
            return new StepClimberDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public StepClimberDataAndroid createFromMultiplePacketArray(@NonNull StepClimberDataPacketAndroid[] multiplePacketArray) {
            return new StepClimberDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link StepClimberDataPacket} array
     *
     * @param stepClimberDataPackets 1 or more Step Climber Data packet array
     */
    public StepClimberDataAndroid(@NonNull StepClimberDataPacket[] stepClimberDataPackets) {
        super(stepClimberDataPackets);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private StepClimberDataAndroid(@NonNull Parcel in) {
        super(new StepClimberDataPacketAndroid[]{StepClimberDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
    public StepClimberDataAndroid(@NonNull byte[] flags, int floors, int stepCount, int stepPerMinute, int averageStepRate, int positiveElevationGain, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, floors, stepCount, stepPerMinute, averageStepRate, positiveElevationGain, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
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
