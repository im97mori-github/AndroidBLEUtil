package org.im97mori.ble.characteristic.u2ad2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Indoor Bike Data (Characteristics UUID: 0x2AD2)
 */
@SuppressWarnings({"WeakerAccess"})
public class IndoorBikeDataAndroid extends IndoorBikeData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<IndoorBikeDataAndroid, IndoorBikeDataPacketAndroid> CREATOR = new MultiplePacketCreater<IndoorBikeDataAndroid, IndoorBikeDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataAndroid createFromParcel(@NonNull Parcel in) {
            return new IndoorBikeDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataAndroid[] newArray(int size) {
            return new IndoorBikeDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IndoorBikeDataAndroid createFromMultiplePacketArray(@NonNull IndoorBikeDataPacketAndroid[] multiplePacketArray) {
            return new IndoorBikeDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link IndoorBikeDataPacket} array
     *
     * @param indoorBikeDataPackets 1 or more Indoor Bike Data packet array
     */
    public IndoorBikeDataAndroid(@NonNull IndoorBikeDataPacketAndroid[] indoorBikeDataPackets) {
        super(indoorBikeDataPackets);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                Flags
     * @param instantaneousSpeed   Instantaneous Speed
     * @param averageSpeed         Average Speed
     * @param instantaneousCadence Instantaneous Cadence
     * @param averageCadence       Average Cadence
     * @param totalDistance        Total Distance
     * @param resistanceLevel      Resistance Level
     * @param instantaneousPower   Instantaneous Power
     * @param averagePower         Average Power
     * @param totalEnergy          Total Energy
     * @param energyPerHour        Energy Per Hour
     * @param energyPerMinute      Energy Per Minute
     * @param heartRate            Heart Rate
     * @param metabolicEquivalent  Metabolic Equivalent
     * @param elapsedTime          Elapsed Time
     * @param remainingTime        Remaining Time
     */
    public IndoorBikeDataAndroid(@NonNull byte[] flags, int instantaneousSpeed, int averageSpeed, int instantaneousCadence, int averageCadence, int totalDistance, int resistanceLevel, int instantaneousPower, int averagePower, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, instantaneousSpeed, averageSpeed, instantaneousCadence, averageCadence, totalDistance, resistanceLevel, instantaneousPower, averagePower, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IndoorBikeDataAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(new IndoorBikeDataPacketAndroid[]{IndoorBikeDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
