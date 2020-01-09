package org.im97mori.ble.characteristic.ftms;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TREADMILL_DATA_CHARACTERISTIC;

/**
 * Treadmill Data packet (Characteristics UUID: 0x2ACD)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TreadmillDataPacket implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TreadmillDataPacket> CREATOR = new ByteArrayCreater<TreadmillDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillDataPacket createFromParcel(@NonNull Parcel in) {
            return new TreadmillDataPacket(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillDataPacket[] newArray(int size) {
            return new TreadmillDataPacket[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TreadmillDataPacket createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TreadmillDataPacket(bluetoothGattCharacteristic);
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
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACD
     */
    public TreadmillDataPacket(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 2;
        mFlags = Arrays.copyOfRange(values, 0, 2);
        if (TreadmillDataUtils.isFlagsMoreDataFalse(mFlags)) {
            mInstantaneousSpeed = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mInstantaneousSpeed = 0;
        }
        if (TreadmillDataUtils.isFlagsAverageSpeedPresent(mFlags)) {
            mAverageSpeed = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mAverageSpeed = 0;
        }
        if (TreadmillDataUtils.isFlagsTotalDistancePresent(mFlags)) {
            mTotalDistance = BLEUtils.createUInt24(values, index);
            index += 3;
        } else {
            mTotalDistance = 0;
        }
        if (TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingPresent(mFlags)) {
            mInclination = BLEUtils.createSInt16(values, index);
            index += 2;
            mRampAngleSetting = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mInclination = 0;
            mRampAngleSetting = 0;
        }
        if (TreadmillDataUtils.isFlagsElevationGainPresent(mFlags)) {
            mPositiveElevationGain = BLEUtils.createUInt16(values, index);
            index += 2;
            mNegativeElevationGain = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mPositiveElevationGain = 0;
            mNegativeElevationGain = 0;
        }
        if (TreadmillDataUtils.isFlagsInstantaneousPacePresent(mFlags)) {
            mInstantaneousPace = (values[index++] & 0xff);
        } else {
            mInstantaneousPace = 0;
        }
        if (TreadmillDataUtils.isFlagsAveragePacePresent(mFlags)) {
            mAveragePace = (values[index++] & 0xff);
        } else {
            mAveragePace = 0;
        }
        if (TreadmillDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
            mTotalEnergy = BLEUtils.createUInt16(values, index);
            index += 2;
            mEnergyPerHour = BLEUtils.createUInt16(values, index);
            index += 2;
            mEnergyPerMinute = (values[index++] & 0xff);
        } else {
            mTotalEnergy = 0;
            mEnergyPerHour = 0;
            mEnergyPerMinute = 0;
        }
        if (TreadmillDataUtils.isFlagsHeartRatePresent(mFlags)) {
            mHeartRate = (values[index++] & 0xff);
        } else {
            mHeartRate = 0;
        }
        if (TreadmillDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            mMetabolicEquivalent = (values[index++] & 0xff);
        } else {
            mMetabolicEquivalent = 0;
        }
        if (TreadmillDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            mElapsedTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mElapsedTime = 0;
        }
        if (TreadmillDataUtils.isFlagsRemainingTimePresent(mFlags)) {
            mRemainingTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mRemainingTime = 0;
        }
        if (TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputPresent(mFlags)) {
            mForceOnBelt = BLEUtils.createSInt16(values, index);
            index += 2;
            mPowerOutput = BLEUtils.createSInt16(values, index);
        } else {
            mForceOnBelt = 0;
            mPowerOutput = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TreadmillDataPacket(@NonNull Parcel in) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[34];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        length += 2;
        if (TreadmillDataUtils.isFlagsMoreDataFalse(mFlags)) {
            byteBuffer.putShort((short) mInstantaneousSpeed);
            length += 2;
        }
        if (TreadmillDataUtils.isFlagsAverageSpeedPresent(mFlags)) {
            byteBuffer.putShort((short) mAverageSpeed);
            length += 2;
        }
        if (TreadmillDataUtils.isFlagsTotalDistancePresent(mFlags)) {
            byteBuffer.put((byte) mTotalDistance);
            byteBuffer.put((byte) (mTotalDistance >> 8));
            byteBuffer.put((byte) (mTotalDistance >> 16));
            length += 3;
        }
        if (TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingPresent(mFlags)) {
            byteBuffer.putShort((short) mInclination);
            byteBuffer.putShort((short) mRampAngleSetting);
            length += 4;
        }
        if (TreadmillDataUtils.isFlagsElevationGainPresent(mFlags)) {
            byteBuffer.putShort((short) mPositiveElevationGain);
            byteBuffer.putShort((short) mNegativeElevationGain);
            length += 4;
        }
        if (TreadmillDataUtils.isFlagsInstantaneousPacePresent(mFlags)) {
            byteBuffer.put((byte) mInstantaneousPace);
            length++;
        }
        if (TreadmillDataUtils.isFlagsAveragePacePresent(mFlags)) {
            byteBuffer.put((byte) mAveragePace);
            length++;
        }
        if (TreadmillDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
            byteBuffer.putShort((short) mTotalEnergy);
            byteBuffer.putShort((short) mEnergyPerHour);
            byteBuffer.put((byte) mEnergyPerMinute);
            length += 5;
        }
        if (TreadmillDataUtils.isFlagsHeartRatePresent(mFlags)) {
            byteBuffer.put((byte) mHeartRate);
            length++;
        }
        if (TreadmillDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            byteBuffer.put((byte) mMetabolicEquivalent);
            length++;
        }
        if (TreadmillDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            byteBuffer.putShort((short) mElapsedTime);
            length += 2;
        }
        if (TreadmillDataUtils.isFlagsRemainingTimePresent(mFlags)) {
            byteBuffer.putShort((short) mRemainingTime);
            length += 2;
        }
        if (TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputPresent(mFlags)) {
            byteBuffer.putShort((short) mForceOnBelt);
            byteBuffer.putShort((short) mPowerOutput);
            length += 4;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

}
