package org.im97mori.ble.characteristic.ftms;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

import java.util.Arrays;

/**
 * Cross Trainer Data (Characteristics UUID: 0x2ACE)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CrossTrainerData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<CrossTrainerData, CrossTrainerDataPacket> CREATOR = new MultiplePacketCreater<CrossTrainerData, CrossTrainerDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerData createFromParcel(@NonNull Parcel in) {
            return new CrossTrainerData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerData[] newArray(int size) {
            return new CrossTrainerData[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public CrossTrainerData createFromMultiplePacketArray(@NonNull CrossTrainerDataPacket[] multiplePacketArray) {
            return new CrossTrainerData(multiplePacketArray);
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
     * Total Distance
     */
    private final int mTotalDistance;

    /**
     * Step Per Minute
     */
    private final int mStepPerMinute;

    /**
     * Average Step Rate
     */
    private final int mAverageStepRate;

    /**
     * Stride Count
     */
    private final int mStrideCount;

    /**
     * Positive Elevation Gain
     */
    private final int mPositiveElevationGain;

    /**
     * Negative Elevation Gain
     */
    private final int mNegativeElevationGain;

    /**
     * Inclination
     */
    private final int mInclination;

    /**
     * Ramp Angle Setting
     */
    private final int mRampAngleSetting;

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
     * Constructor from {@link CrossTrainerDataPacket} array
     *
     * @param crossTrainerDataPackets 1 or more Cross Trainer Data packet array
     */
    public CrossTrainerData(@NonNull CrossTrainerDataPacket[] crossTrainerDataPackets) {
        byte[] flags = new byte[3];
        int instantaneousSpeed = 0;
        int averageSpeed = 0;
        int totalDistance = 0;
        int stepPerMinute = 0;
        int averageStepRate = 0;
        int strideCount = 0;
        int positiveElevationGain = 0;
        int negativeElevationGain = 0;
        int inclination = 0;
        int rampAngleSetting = 0;
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
        for (CrossTrainerDataPacket crossTrainerDataPacket : crossTrainerDataPackets) {
            byte[] values = crossTrainerDataPacket.getBytes();
            int index = 3;
            flags = Arrays.copyOfRange(values, 0, 3);
            if (CrossTrainerDataUtils.isFlagsMoreDataFalse(flags)) {
                instantaneousSpeed = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsAverageSpeedPresent(flags)) {
                averageSpeed = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsTotalDistancePresent(flags)) {
                totalDistance = BLEUtils.createUInt24(values, index);
                index += 3;
            }
            if (CrossTrainerDataUtils.isFlagsStepCountPresent(flags)) {
                stepPerMinute = BLEUtils.createUInt16(values, index);
                index += 2;
                averageStepRate = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsStrideCountPresent(flags)) {
                strideCount = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsElevationGainPresent(flags)) {
                positiveElevationGain = BLEUtils.createUInt16(values, index);
                index += 2;
                negativeElevationGain = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingPresent(flags)) {
                inclination = BLEUtils.createSInt16(values, index);
                index += 2;
                rampAngleSetting = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsResistanceLevelPresent(flags)) {
                resistanceLevel = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsInstantaneousPowerPresent(flags)) {
                instantaneousPower = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsAveragePowerPresent(flags)) {
                averagePower = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsExpendedEnergyPresent(flags)) {
                totalEnergy = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerHour = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerMinute = (values[index++] & 0xff);
            }
            if (CrossTrainerDataUtils.isFlagsHeartRatePresent(flags)) {
                heartRate = (values[index++] & 0xff);
            } else {
                heartRate = 0;
            }
            if (CrossTrainerDataUtils.isFlagsMetabolicEquivalentPresent(flags)) {
                metabolicEquivalent = (values[index++] & 0xff);
            }
            if (CrossTrainerDataUtils.isFlagsElapsedTimePresent(flags)) {
                elapsedTime = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (CrossTrainerDataUtils.isFlagsRemainingTimePresent(flags)) {
                remainingTime = BLEUtils.createUInt16(values, index);
            }
        }

        mFlags = flags;
        mInstantaneousSpeed = instantaneousSpeed;
        mAverageSpeed = averageSpeed;
        mTotalDistance = totalDistance;
        mStepPerMinute = stepPerMinute;
        mAverageStepRate = averageStepRate;
        mStrideCount = strideCount;
        mPositiveElevationGain = positiveElevationGain;
        mNegativeElevationGain = negativeElevationGain;
        mInclination = inclination;
        mRampAngleSetting = rampAngleSetting;
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
    private CrossTrainerData(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mInstantaneousSpeed = in.readInt();
        mAverageSpeed = in.readInt();
        mTotalDistance = in.readInt();
        mStepPerMinute = in.readInt();
        mAverageStepRate = in.readInt();
        mStrideCount = in.readInt();
        mPositiveElevationGain = in.readInt();
        mNegativeElevationGain = in.readInt();
        mInclination = in.readInt();
        mRampAngleSetting = in.readInt();
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
        dest.writeInt(mTotalDistance);
        dest.writeInt(mStepPerMinute);
        dest.writeInt(mAverageStepRate);
        dest.writeInt(mStrideCount);
        dest.writeInt(mPositiveElevationGain);
        dest.writeInt(mNegativeElevationGain);
        dest.writeInt(mInclination);
        dest.writeInt(mRampAngleSetting);
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
     * @return Total Distance
     */
    public int getTotalDistance() {
        return mTotalDistance;
    }

    /**
     * @return Step Per Minute
     */
    public int getStepPerMinute() {
        return mStepPerMinute;
    }

    /**
     * @return Average Step Rate
     */
    public int getAverageStepRate() {
        return mAverageStepRate;
    }

    /**
     * @return Stride Count
     */
    public int getStrideCount() {
        return mStrideCount;
    }

    /**
     * @return Positive Elevation Gain
     */
    public int getPositiveElevationGain() {
        return mPositiveElevationGain;
    }

    /**
     * @return Negative Elevation Gain
     */
    public int getNegativeElevationGain() {
        return mNegativeElevationGain;
    }

    /**
     * @return Inclination
     */
    public int getInclination() {
        return mInclination;
    }

    /**
     * @return Ramp Angle Setting
     */
    public int getRampAngleSetting() {
        return mRampAngleSetting;
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
