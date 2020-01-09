package org.im97mori.ble.characteristic.ftms;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

import java.util.Arrays;

/**
 * Rower Data (Characteristics UUID: 0x2AD1)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RowerData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<RowerData, RowerDataPacket> CREATOR = new MultiplePacketCreater<RowerData, RowerDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerData createFromParcel(@NonNull Parcel in) {
            return new RowerData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerData[] newArray(int size) {
            return new RowerData[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public RowerData createFromMultiplePacketArray(@NonNull RowerDataPacket[] multiplePacketArray) {
            return new RowerData(multiplePacketArray);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Stroke Rate
     */
    private final int mStrokeRate;

    /**
     * Stroke Count
     */
    private final int mStrokeCount;

    /**
     * Average Stroke Rate
     */
    private final int mAverageStrokeRate;

    /**
     * Total Distance
     */
    private final int mTotalDistance;

    /**
     * Instantaneous Pace
     */
    private final int mInstantaneousPace;

    /**
     * Average Pace
     */
    private final int mAveragePace;

    /**
     * Instantaneous Power
     */
    private final int mInstantaneousPower;

    /**
     * Average Power
     */
    private final int mAveragePower;

    /**
     * Resistance Level
     */
    private final int mResistanceLevel;

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
     * Constructor from {@link RowerDataPacket} array
     *
     * @param rowerDataPackets 1 or more Rower Data packet array
     */
    public RowerData(@NonNull RowerDataPacket[] rowerDataPackets) {
        byte[] flags = new byte[2];
        int strokeRate = 0;
        int strokeCount = 0;
        int averageStrokeRate = 0;
        int totalDistance = 0;
        int instantaneousPace = 0;
        int averagePace = 0;
        int instantaneousPower = 0;
        int averagePower = 0;
        int resistanceLevel = 0;
        int totalEnergy = 0;
        int energyPerHour = 0;
        int energyPerMinute = 0;
        int heartRate = 0;
        int metabolicEquivalent = 0;
        int elapsedTime = 0;
        int remainingTime = 0;

        // give priority to after packet
        for (RowerDataPacket rowerDataPacket : rowerDataPackets) {
            byte[] values = rowerDataPacket.getBytes();
            int index = 2;
            flags = Arrays.copyOfRange(values, 0, 2);
            if (RowerDataUtils.isFlagsMoreDataFalse(flags)) {
                strokeRate = (values[index++] & 0xff);
                strokeCount = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (RowerDataUtils.isFlagsAverageStrokePresent(flags)) {
                averageStrokeRate = (values[index++] & 0xff);
            }
            if (RowerDataUtils.isFlagsTotalDistancePresente(flags)) {
                totalDistance = BLEUtils.createUInt24(values, index);
                index += 3;
            }
            if (RowerDataUtils.isFlagsInstantaneousPacePresent(flags)) {
                instantaneousPace = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (RowerDataUtils.isFlagsAveragePacePresent(flags)) {
                averagePace = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (RowerDataUtils.isFlagsInstantaneousPowerPresent(flags)) {
                instantaneousPower = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (RowerDataUtils.isFlagsAveragePowerPresent(flags)) {
                averagePower = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (RowerDataUtils.isFlagsResistanceLevelPresent(flags)) {
                resistanceLevel = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (RowerDataUtils.isFlagsExpendedEnergyPresent(flags)) {
                totalEnergy = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerHour = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerMinute = (values[index++] & 0xff);
            }
            if (RowerDataUtils.isFlagsHeartRatePresent(flags)) {
                heartRate = (values[index++] & 0xff);
            }
            if (RowerDataUtils.isFlagsMetabolicEquivalentPresent(flags)) {
                metabolicEquivalent = (values[index++] & 0xff);
            }
            if (RowerDataUtils.isFlagsElapsedTimePresent(flags)) {
                elapsedTime = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (RowerDataUtils.isFlagsRemainingTimePresent(flags)) {
                remainingTime = BLEUtils.createUInt16(values, index);
            }
        }

        mFlags = flags;
        mStrokeRate = strokeRate;
        mStrokeCount = strokeCount;
        mAverageStrokeRate = averageStrokeRate;
        mTotalDistance = totalDistance;
        mInstantaneousPace = instantaneousPace;
        mAveragePace = averagePace;
        mInstantaneousPower = instantaneousPower;
        mAveragePower = averagePower;
        mResistanceLevel = resistanceLevel;
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
    private RowerData(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mStrokeRate = in.readInt();
        mStrokeCount = in.readInt();
        mAverageStrokeRate = in.readInt();
        mTotalDistance = in.readInt();
        mInstantaneousPace = in.readInt();
        mAveragePace = in.readInt();
        mInstantaneousPower = in.readInt();
        mAveragePower = in.readInt();
        mResistanceLevel = in.readInt();
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
        dest.writeInt(mStrokeRate);
        dest.writeInt(mStrokeCount);
        dest.writeInt(mAverageStrokeRate);
        dest.writeInt(mTotalDistance);
        dest.writeInt(mInstantaneousPace);
        dest.writeInt(mAveragePace);
        dest.writeInt(mInstantaneousPower);
        dest.writeInt(mAveragePower);
        dest.writeInt(mResistanceLevel);
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
     * @return Stroke Rate
     */
    public int getStrokeRate() {
        return mStrokeRate;
    }

    /**
     * @return Stroke Count
     */
    public int getStrokeCount() {
        return mStrokeCount;
    }

    /**
     * @return Average Stroke Rate
     */
    public int getAverageStrokeRate() {
        return mAverageStrokeRate;
    }

    /**
     * @return Total Distance
     */
    public int getTotalDistance() {
        return mTotalDistance;
    }

    /**
     * @return Instantaneous Pace
     */
    public int getInstantaneousPace() {
        return mInstantaneousPace;
    }

    /**
     * @return Average Pace
     */
    public int getAveragePace() {
        return mAveragePace;
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
     * @return Resistance Level
     */
    public int getResistanceLevel() {
        return mResistanceLevel;
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
