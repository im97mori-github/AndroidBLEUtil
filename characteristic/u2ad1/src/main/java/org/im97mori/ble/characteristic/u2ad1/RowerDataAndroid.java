package org.im97mori.ble.characteristic.u2ad1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.MultiplePacketCreator;

/**
 * Rower Data (Characteristics UUID: 0x2AD1)
 */
@SuppressWarnings({"WeakerAccess"})
public class RowerDataAndroid extends RowerData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final MultiplePacketCreator<RowerDataAndroid, RowerDataPacketAndroid> CREATOR = new MultiplePacketCreator<RowerDataAndroid, RowerDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerDataAndroid createFromParcel(@NonNull Parcel in) {
            return new RowerDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerDataAndroid[] newArray(int size) {
            return new RowerDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public RowerDataAndroid createFromMultiplePacketArray(@NonNull RowerDataPacketAndroid[] multiplePacketArray) {
            return new RowerDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link RowerDataPacket} array
     *
     * @param rowerDataPackets 1 or more Rower Data packet array
     */
    public RowerDataAndroid(@NonNull RowerDataPacketAndroid... rowerDataPackets) {
        super(rowerDataPackets);
    }

    /**
     * Constructor from parameters
     *
     * @param flags               Flags
     * @param strokeRate          Stroke Rate
     * @param strokeCount         Stroke Count
     * @param averageStrokeRate   Average Stroke Rate
     * @param totalDistance       Total Distance
     * @param instantaneousPace   Instantaneous Pace
     * @param averagePace         Average Pace
     * @param instantaneousPower  Instantaneous Power
     * @param averagePower        Average Power
     * @param resistanceLevel     Resistance Level
     * @param totalEnergy         Total Energy
     * @param energyPerHour       Energy Per Hour
     * @param energyPerMinute     Energy Per Minute
     * @param heartRate           Heart Rate
     * @param metabolicEquivalent Metabolic Equivalent
     * @param elapsedTime         Elapsed Time
     * @param remainingTime       Remaining Time
     */
    public RowerDataAndroid(@NonNull byte[] flags, int strokeRate, int strokeCount, int averageStrokeRate, int totalDistance, int instantaneousPace, int averagePace, int instantaneousPower, int averagePower, int resistanceLevel, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, strokeRate, strokeCount, averageStrokeRate, totalDistance, instantaneousPace, averagePace, instantaneousPower, averagePower, resistanceLevel, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RowerDataAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
