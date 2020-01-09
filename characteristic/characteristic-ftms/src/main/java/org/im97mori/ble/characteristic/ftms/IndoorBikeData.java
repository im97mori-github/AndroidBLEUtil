package org.im97mori.ble.characteristic.ftms;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

import java.util.Arrays;

/**
 * Indoor Bike Data (Characteristics UUID: 0x2AD2)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IndoorBikeData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<IndoorBikeData, IndoorBikeDataPacket> CREATOR = new MultiplePacketCreater<IndoorBikeData, IndoorBikeDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeData createFromParcel(@NonNull Parcel in) {
            return new IndoorBikeData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeData[] newArray(int size) {
            return new IndoorBikeData[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IndoorBikeData createFromMultiplePacketArray(@NonNull IndoorBikeDataPacket[] multiplePacketArray) {
            return new IndoorBikeData(multiplePacketArray);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Instantaneous Speed
     */
    private final int mInstantaneousSpeed;

    /**
     * Average Speed
     */
    private final int mAverageSpeed;

    /**
     * Instantaneous Cadence
     */
    private final int mInstantaneousCadence;

    /**
     * Average Cadence
     */
    private final int mAverageCadence;

    /**
     * Total Distance
     */
    private final int mTotalDistance;

    /**
     * Resistance Level
     */
    private final int mResistanceLevel;

    /**
     * Instantaneous Power
     */
    private final int mInstantaneousPower;

    /**
     * Average Power
     */
    private final int mAveragePower;

    /**
     * Total Energy
     */
    private final int mTotalEnergy;

    /**
     * Energy Per Hour
     */
    private final int mEnergyPerHour;

    /**
     * Energy Per Minute
     */
    private final int mEnergyPerMinute;

    /**
     * Heart Rate
     */
    private final int mHeartRate;

    /**
     * Metabolic Equivalent
     */
    private final int mMetabolicEquivalent;

    /**
     * Elapsed Time
     */
    private final int mElapsedTime;

    /**
     * Remaining Time
     */
    private final int mRemainingTime;

    /**
     * Constructor from {@link IndoorBikeDataPacket} array
     *
     * @param indoorBikeDataPackets 1 or more Indoor Bike Data packet array
     */
    public IndoorBikeData(@NonNull IndoorBikeDataPacket[] indoorBikeDataPackets) {
        byte[] flags = new byte[2];
        int instantaneousSpeed = 0;
        int averageSpeed = 0;
        int instantaneousCadence = 0;
        int averageCadence = 0;
        int totalDistance = 0;
        int resistanceLevel = 0;
        int instantaneousPower = 0;
        int averagePower = 0;
        int totalEnergy = 0;
        int energyPerHour = 0;
        int energyPerMinute = 0;
        int heartRate = 0;
        int metabolicEquivalent = 0;
        int elapsedTime = 0;
        int remainingTime = 0;

        // give priority to after packet
        for (IndoorBikeDataPacket indoorBikeDataPacket : indoorBikeDataPackets) {
            byte[] values = indoorBikeDataPacket.getBytes();
            int index = 2;
            flags = Arrays.copyOfRange(values, 0, 2);
            if (IndoorBikeDataUtils.isFlagsMoreDataFalse(flags)) {
                instantaneousSpeed = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (IndoorBikeDataUtils.isFlagsAverageSpeedPresent(flags)) {
                averageSpeed = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (IndoorBikeDataUtils.isFlagsInstantaneousCadencePresent(flags)) {
                instantaneousCadence = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (IndoorBikeDataUtils.isFlagsAverageCandencePresent(flags)) {
                averageCadence = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (IndoorBikeDataUtils.isFlagsTotalDistancePresent(flags)) {
                totalDistance = BLEUtils.createUInt24(values, index);
                index += 3;
            }
            if (IndoorBikeDataUtils.isFlagsResistanceLevelPresent(flags)) {
                resistanceLevel = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (IndoorBikeDataUtils.isFlagsInstantaneousPowerPresent(flags)) {
                instantaneousPower = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (IndoorBikeDataUtils.isFlagsAveragePowerPresent(flags)) {
                averagePower = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (IndoorBikeDataUtils.isFlagsExpendedEnergyPresent(flags)) {
                totalEnergy = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerHour = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerMinute = (values[index++] & 0xff);
            }
            if (IndoorBikeDataUtils.isFlagsHeartRatePresent(flags)) {
                heartRate = (values[index++] & 0xff);
            }
            if (IndoorBikeDataUtils.isFlagsMetabolicEquivalentPresent(flags)) {
                metabolicEquivalent = (values[index++] & 0xff);
            }
            if (IndoorBikeDataUtils.isFlagsElapsedTimePresent(flags)) {
                elapsedTime = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (IndoorBikeDataUtils.isFlagsRemainingTimePresent(flags)) {
                remainingTime = BLEUtils.createUInt16(values, index);
            }
        }

        mFlags = flags;
        mInstantaneousSpeed = instantaneousSpeed;
        mAverageSpeed = averageSpeed;
        mInstantaneousCadence = instantaneousCadence;
        mAverageCadence = averageCadence;
        mTotalDistance = totalDistance;
        mResistanceLevel = resistanceLevel;
        mInstantaneousPower = instantaneousPower;
        mAveragePower = averagePower;
        mTotalEnergy = totalEnergy;
        mEnergyPerHour = energyPerHour;
        mEnergyPerMinute = energyPerMinute;
        mHeartRate = heartRate;
        mMetabolicEquivalent = metabolicEquivalent;
        mElapsedTime = elapsedTime;
        mRemainingTime = remainingTime;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IndoorBikeData(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mInstantaneousSpeed = in.readInt();
        mAverageSpeed = in.readInt();
        mInstantaneousCadence = in.readInt();
        mAverageCadence = in.readInt();
        mTotalDistance = in.readInt();
        mResistanceLevel = in.readInt();
        mInstantaneousPower = in.readInt();
        mAveragePower = in.readInt();
        mTotalEnergy = in.readInt();
        mEnergyPerHour = in.readInt();
        mEnergyPerMinute = in.readInt();
        mHeartRate = in.readInt();
        mMetabolicEquivalent = in.readInt();
        mElapsedTime = in.readInt();
        mRemainingTime = in.readInt();
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
        dest.writeByteArray(mFlags);
        dest.writeInt(mInstantaneousSpeed);
        dest.writeInt(mAverageSpeed);
        dest.writeInt(mInstantaneousCadence);
        dest.writeInt(mAverageCadence);
        dest.writeInt(mTotalDistance);
        dest.writeInt(mResistanceLevel);
        dest.writeInt(mInstantaneousPower);
        dest.writeInt(mAveragePower);
        dest.writeInt(mTotalEnergy);
        dest.writeInt(mEnergyPerHour);
        dest.writeInt(mEnergyPerMinute);
        dest.writeInt(mHeartRate);
        dest.writeInt(mMetabolicEquivalent);
        dest.writeInt(mElapsedTime);
        dest.writeInt(mRemainingTime);
    }

    /**
     * @return Flags
     */
    public byte[] getFlags() {
        return mFlags;
    }

    /**
     * @return Instantaneous Speed
     */
    public int getInstantaneousSpeed() {
        return mInstantaneousSpeed;
    }

    /**
     * @return Average Speed
     */
    public int getAverageSpeed() {
        return mAverageSpeed;
    }

    /**
     * @return Instantaneous Cadence
     */
    public int getInstantaneousCadence() {
        return mInstantaneousCadence;
    }

    /**
     * @return Average Cadence
     */
    public int getAverageCadence() {
        return mAverageCadence;
    }

    /**
     * @return Total Distance
     */
    public int getTotalDistance() {
        return mTotalDistance;
    }

    /**
     * @return Resistance Level
     */
    public int getResistanceLevel() {
        return mResistanceLevel;
    }

    /**
     * @return Instantaneous Power
     */
    public int getInstantaneousPower() {
        return mInstantaneousPower;
    }

    /**
     * @return Average Power
     */
    public int getAveragePower() {
        return mAveragePower;
    }

    /**
     * @return Total Energy
     */
    public int getTotalEnergy() {
        return mTotalEnergy;
    }

    /**
     * @return Energy Per Hour
     */
    public int getEnergyPerHour() {
        return mEnergyPerHour;
    }

    /**
     * @return Energy Per Minute
     */
    public int getEnergyPerMinute() {
        return mEnergyPerMinute;
    }

    /**
     * @return Heart Rate
     */
    public int getHeartRate() {
        return mHeartRate;
    }

    /**
     * @return Metabolic Equivalent
     */
    public int getMetabolicEquivalent() {
        return mMetabolicEquivalent;
    }

    /**
     * @return Elapsed Time
     */
    public int getElapsedTime() {
        return mElapsedTime;
    }

    /**
     * @return Remaining Time
     */
    public int getRemainingTime() {
        return mRemainingTime;
    }

}
