package org.im97mori.ble.characteristic.ftms;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

import java.util.Arrays;

/**
 * Treadmill Data (Characteristics UUID: 0x2ACD)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TreadmillData implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<TreadmillData, TreadmillDataPacket> CREATOR = new MultiplePacketCreater<TreadmillData, TreadmillDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillData createFromParcel(@NonNull Parcel in) {
            return new TreadmillData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillData[] newArray(int size) {
            return new TreadmillData[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public TreadmillData createFromMultiplePacketArray(@NonNull TreadmillDataPacket[] multiplePacketArray) {
            return new TreadmillData(multiplePacketArray);
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
     * Inclination
     */
    private final int mInclination;

    /**
     * Ramp Angle Setting
     */
    private final int mRampAngleSetting;

    /**
     * Positive Elevation Gain
     */
    private final int mPositiveElevationGain;

    /**
     * Negative Elevation Gain
     */
    private final int mNegativeElevationGain;

    /**
     * Instantaneous Pace
     */
    private final int mInstantaneousPace;

    /**
     * Average Pace
     */
    private final int mAveragePace;

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
     * Force on Belt
     */
    private final int mForceOnBelt;

    /**
     * Power Output
     */
    private final int mPowerOutput;

    /**
     * Constructor from {@link TreadmillDataPacket} array
     *
     * @param treadmillDataPackets 1 or more Treadmill Data packet array
     */
    public TreadmillData(@NonNull TreadmillDataPacket[] treadmillDataPackets) {
        byte[] flags = new byte[2];
        int instantaneousSpeed = 0;
        int averageSpeed = 0;
        int totalDistance = 0;
        int inclination = 0;
        int rampAngleSetting = 0;
        int positiveElevationGain = 0;
        int negativeElevationGain = 0;
        int instantaneousPace = 0;
        int averagePace = 0;
        int totalEnergy = 0;
        int energyPerHour = 0;
        int energyPerMinute = 0;
        int heartRate = 0;
        int metabolicEquivalent = 0;
        int elapsedTime = 0;
        int remainingTime = 0;
        int forceOnBelt = 0;
        int powerOutput = 0;

        // give priority to after packet
        for (TreadmillDataPacket treadmillDataPacket : treadmillDataPackets) {
            byte[] values = treadmillDataPacket.getBytes();
            int index = 2;
            flags = Arrays.copyOfRange(values, 0, 2);

            if (TreadmillDataUtils.isFlagsMoreDataFalse(flags)) {
                instantaneousSpeed = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (TreadmillDataUtils.isFlagsAverageSpeedPresent(flags)) {
                averageSpeed = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (TreadmillDataUtils.isFlagsTotalDistancePresent(flags)) {
                totalDistance = BLEUtils.createUInt24(values, index);
                index += 3;
            }
            if (TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingPresent(flags)) {
                inclination = BLEUtils.createSInt16(values, index);
                index += 2;
                rampAngleSetting = BLEUtils.createSInt16(values, index);
                index += 2;
            }
            if (TreadmillDataUtils.isFlagsElevationGainPresent(flags)) {
                positiveElevationGain = BLEUtils.createUInt16(values, index);
                index += 2;
                negativeElevationGain = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (TreadmillDataUtils.isFlagsInstantaneousPacePresent(flags)) {
                instantaneousPace = (values[index++] & 0xff);
            }
            if (TreadmillDataUtils.isFlagsAveragePacePresent(flags)) {
                averagePace = (values[index++] & 0xff);
            }
            if (TreadmillDataUtils.isFlagsExpendedEnergyPresent(flags)) {
                totalEnergy = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerHour = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerMinute = (values[index++] & 0xff);
            }
            if (TreadmillDataUtils.isFlagsHeartRatePresent(flags)) {
                heartRate = (values[index++] & 0xff);
            }
            if (TreadmillDataUtils.isFlagsMetabolicEquivalentPresent(flags)) {
                metabolicEquivalent = (values[index++] & 0xff);
            }
            if (TreadmillDataUtils.isFlagsElapsedTimePresent(flags)) {
                elapsedTime = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (TreadmillDataUtils.isFlagsRemainingTimePresent(flags)) {
                remainingTime = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputPresent(flags)) {
                forceOnBelt = BLEUtils.createSInt16(values, index);
                index += 2;
                powerOutput = BLEUtils.createSInt16(values, index);
            }
        }

        mFlags = flags;
        mInstantaneousSpeed = instantaneousSpeed;
        mAverageSpeed = averageSpeed;
        mTotalDistance = totalDistance;
        mInclination = inclination;
        mRampAngleSetting = rampAngleSetting;
        mPositiveElevationGain = positiveElevationGain;
        mNegativeElevationGain = negativeElevationGain;
        mInstantaneousPace = instantaneousPace;
        mAveragePace = averagePace;
        mTotalEnergy = totalEnergy;
        mEnergyPerHour = energyPerHour;
        mEnergyPerMinute = energyPerMinute;
        mHeartRate = heartRate;
        mMetabolicEquivalent = metabolicEquivalent;
        mElapsedTime = elapsedTime;
        mRemainingTime = remainingTime;
        mForceOnBelt = forceOnBelt;
        mPowerOutput = powerOutput;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TreadmillData(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mInstantaneousSpeed = in.readInt();
        mAverageSpeed = in.readInt();
        mTotalDistance = in.readInt();
        mInclination = in.readInt();
        mRampAngleSetting = in.readInt();
        mPositiveElevationGain = in.readInt();
        mNegativeElevationGain = in.readInt();
        mInstantaneousPace = in.readInt();
        mAveragePace = in.readInt();
        mTotalEnergy = in.readInt();
        mEnergyPerHour = in.readInt();
        mEnergyPerMinute = in.readInt();
        mHeartRate = in.readInt();
        mMetabolicEquivalent = in.readInt();
        mElapsedTime = in.readInt();
        mRemainingTime = in.readInt();
        mForceOnBelt = in.readInt();
        mPowerOutput = in.readInt();
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
        dest.writeInt(mInclination);
        dest.writeInt(mRampAngleSetting);
        dest.writeInt(mPositiveElevationGain);
        dest.writeInt(mNegativeElevationGain);
        dest.writeInt(mInstantaneousPace);
        dest.writeInt(mAveragePace);
        dest.writeInt(mTotalEnergy);
        dest.writeInt(mEnergyPerHour);
        dest.writeInt(mEnergyPerMinute);
        dest.writeInt(mHeartRate);
        dest.writeInt(mMetabolicEquivalent);
        dest.writeInt(mElapsedTime);
        dest.writeInt(mRemainingTime);
        dest.writeInt(mForceOnBelt);
        dest.writeInt(mPowerOutput);
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

    /**
     * @return Force on Belt
     */
    public int getForceOnBelt() {
        return mForceOnBelt;
    }

    /**
     * @return Power Output
     */
    public int getPowerOutput() {
        return mPowerOutput;
    }

}
