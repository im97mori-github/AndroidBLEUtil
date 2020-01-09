package org.im97mori.ble.characteristic.ftms;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

import java.util.Arrays;

/**
 * Step Climber Data (Characteristics UUID: 0x2ACF)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class StepClimberData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<StepClimberData, StepClimberDataPacket> CREATOR = new MultiplePacketCreater<StepClimberData, StepClimberDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepClimberData createFromParcel(@NonNull Parcel in) {
            return new StepClimberData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepClimberData[] newArray(int size) {
            return new StepClimberData[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public StepClimberData createFromMultiplePacketArray(@NonNull StepClimberDataPacket[] multiplePacketArray) {
            return new StepClimberData(multiplePacketArray);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Floors
     */
    private final int mFloors;

    /**
     * Step Count
     */
    private final int mStepCount;

    /**
     * Step Per Minute
     */
    private final int mStepPerMinute;

    /**
     * Average Step Rate
     */
    private final int mAverageStepRate;

    /**
     * Positive Elevation Gain
     */
    private final int mPositiveElevationGain;

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
     * Constructor from {@link StepClimberDataPacket} array
     *
     * @param stepClimberDataPackets 1 or more Step Climber Data packet array
     */
    public StepClimberData(@NonNull StepClimberDataPacket[] stepClimberDataPackets) {
        byte[] flags = new byte[2];
        int floors = 0;
        int stepCount = 0;
        int stepPerMinute = 0;
        int averageStepRate = 0;
        int positiveElevationGain = 0;
        int totalEnergy = 0;
        int energyPerHour = 0;
        int energyPerMinute = 0;
        int heartRate = 0;
        int metabolicEquivalent = 0;
        int elapsedTime = 0;
        int remainingTime = 0;

        // give priority to after packet
        for (StepClimberDataPacket stepClimberDataPacket : stepClimberDataPackets) {
            byte[] values = stepClimberDataPacket.getBytes();
            int index = 2;
            flags = Arrays.copyOfRange(values, 0, 2);
            if (StepClimberDataUtils.isFlagsMoreDataFalse(flags)) {
                floors = BLEUtils.createUInt16(values, index);
                index += 2;
                stepCount = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (StepClimberDataUtils.isFlagsStepPerMinutePresent(flags)) {
                stepPerMinute = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (StepClimberDataUtils.isFlagsAverageStepRatePresent(flags)) {
                averageStepRate = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (StepClimberDataUtils.isFlagsPositiveElevationGainPresent(flags)) {
                positiveElevationGain = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (StepClimberDataUtils.isFlagsExpendedEnergyPresent(flags)) {
                totalEnergy = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerHour = BLEUtils.createUInt16(values, index);
                index += 2;
                energyPerMinute = (values[index++] & 0xff);
            }
            if (StepClimberDataUtils.isFlagsHeartRatePresent(flags)) {
                heartRate = (values[index++] & 0xff);
            }
            if (StepClimberDataUtils.isFlagsMetabolicEquivalentPresent(flags)) {
                metabolicEquivalent = (values[index++] & 0xff);
            }
            if (StepClimberDataUtils.isFlagsElapsedTimePresent(flags)) {
                elapsedTime = BLEUtils.createUInt16(values, index);
                index += 2;
            }
            if (StepClimberDataUtils.isFlagsRemainingTimePresent(flags)) {
                remainingTime = BLEUtils.createUInt16(values, index);
            }
        }

        mFlags = flags;
        mFloors = floors;
        mStepCount = stepCount;
        mStepPerMinute = stepPerMinute;
        mAverageStepRate = averageStepRate;
        mPositiveElevationGain = positiveElevationGain;
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
    private StepClimberData(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mFloors = in.readInt();
        mStepCount = in.readInt();
        mStepPerMinute = in.readInt();
        mAverageStepRate = in.readInt();
        mPositiveElevationGain = in.readInt();
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
        dest.writeInt(mFloors);
        dest.writeInt(mStepCount);
        dest.writeInt(mStepPerMinute);
        dest.writeInt(mAverageStepRate);
        dest.writeInt(mPositiveElevationGain);
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
     * @return Floors
     */
    public int getFloors() {
        return mFloors;
    }

    /**
     * @return Step Count
     */
    public int getStepCount() {
        return mStepCount;
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
     * @return Positive Elevation Gain
     */
    public int getPositiveElevationGain() {
        return mPositiveElevationGain;
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
