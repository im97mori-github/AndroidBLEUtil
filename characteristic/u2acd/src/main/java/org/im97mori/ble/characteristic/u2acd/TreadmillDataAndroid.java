package org.im97mori.ble.characteristic.u2acd;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Treadmill Data (Characteristics UUID: 0x2ACD)
 */
@SuppressWarnings({"WeakerAccess"})
public class TreadmillDataAndroid extends TreadmillData implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<TreadmillDataAndroid, TreadmillDataPacketAndroid> CREATOR = new MultiplePacketCreater<TreadmillDataAndroid, TreadmillDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillDataAndroid createFromParcel(@NonNull Parcel in) {
            return new TreadmillDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillDataAndroid[] newArray(int size) {
            return new TreadmillDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public TreadmillDataAndroid createFromMultiplePacketArray(@NonNull TreadmillDataPacketAndroid[] multiplePacketArray) {
            return new TreadmillDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link TreadmillDataPacket} array
     *
     * @param treadmillDataPackets 1 or more Treadmill Data packet array
     */
    public TreadmillDataAndroid(@NonNull TreadmillDataPacketAndroid[] treadmillDataPackets) {
        super(treadmillDataPackets);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                 Flags
     * @param instantaneousSpeed    Instantaneous Speed
     * @param averageSpeed          Average Speed
     * @param totalDistance         Total Distance
     * @param inclination           Inclination
     * @param rampAngleSetting      Ramp Angle Setting
     * @param positiveElevationGain Positive Elevation Gain
     * @param negativeElevationGain Negative Elevation Gain
     * @param instantaneousPace     Instantaneous Pace
     * @param averagePace           Average Pace
     * @param totalEnergy           Total Energy
     * @param energyPerHour         Energy Per Hour
     * @param energyPerMinute       Energy Per Minute
     * @param heartRate             Heart Rate
     * @param metabolicEquivalent   Metabolic Equivalent
     * @param elapsedTime           Elapsed Time
     * @param remainingTime         Remaining Time
     * @param forceOnBelt           Force on Belt
     * @param powerOutput           Power Output
     */
    public TreadmillDataAndroid(@NonNull byte[] flags, int instantaneousSpeed, int averageSpeed, int totalDistance, int inclination, int rampAngleSetting, int positiveElevationGain, int negativeElevationGain, int instantaneousPace, int averagePace, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime, int forceOnBelt, int powerOutput) {
        super(flags, instantaneousSpeed, averageSpeed, totalDistance, inclination, rampAngleSetting, positiveElevationGain, negativeElevationGain, instantaneousPace, averagePace, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime, forceOnBelt, powerOutput);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TreadmillDataAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
