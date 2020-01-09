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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ROWER_DATA_CHARACTERISTIC;

/**
 * Rower Data packet (Characteristics UUID: 0x2AD1)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RowerDataPacket implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RowerDataPacket> CREATOR = new ByteArrayCreater<RowerDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerDataPacket createFromParcel(@NonNull Parcel in) {
            return new RowerDataPacket(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerDataPacket[] newArray(int size) {
            return new RowerDataPacket[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RowerDataPacket createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RowerDataPacket(bluetoothGattCharacteristic);
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
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD1
     */
    public RowerDataPacket(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 2;
        mFlags = Arrays.copyOfRange(values, 0, 2);
        if (RowerDataUtils.isFlagsMoreDataFalse(mFlags)) {
            mStrokeRate = (values[index++] & 0xff);
            mStrokeCount = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mStrokeRate = 0;
            mStrokeCount = 0;
        }
        if (RowerDataUtils.isFlagsAverageStrokePresent(mFlags)) {
            mAverageStrokeRate = (values[index++] & 0xff);
        } else {
            mAverageStrokeRate = 0;
        }
        if (RowerDataUtils.isFlagsTotalDistancePresente(mFlags)) {
            mTotalDistance = BLEUtils.createUInt24(values, index);
            index += 3;
        } else {
            mTotalDistance = 0;
        }
        if (RowerDataUtils.isFlagsInstantaneousPacePresent(mFlags)) {
            mInstantaneousPace = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mInstantaneousPace = 0;
        }
        if (RowerDataUtils.isFlagsAveragePacePresent(mFlags)) {
            mAveragePace = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mAveragePace = 0;
        }
        if (RowerDataUtils.isFlagsInstantaneousPowerPresent(mFlags)) {
            mInstantaneousPower = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mInstantaneousPower = 0;
        }
        if (RowerDataUtils.isFlagsAveragePowerPresent(mFlags)) {
            mAveragePower = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mAveragePower = 0;
        }
        if (RowerDataUtils.isFlagsResistanceLevelPresent(mFlags)) {
            mResistanceLevel = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mResistanceLevel = 0;
        }
        if (RowerDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
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
        if (RowerDataUtils.isFlagsHeartRatePresent(mFlags)) {
            mHeartRate = (values[index++] & 0xff);
        } else {
            mHeartRate = 0;
        }
        if (RowerDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            mMetabolicEquivalent = (values[index++] & 0xff);
        } else {
            mMetabolicEquivalent = 0;
        }
        if (RowerDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            mElapsedTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mElapsedTime = 0;
        }
        if (RowerDataUtils.isFlagsRemainingTimePresent(mFlags)) {
            mRemainingTime = BLEUtils.createUInt16(values, index);
        } else {
            mRemainingTime = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RowerDataPacket(@NonNull Parcel in) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[30];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        length += 2;
        if (RowerDataUtils.isFlagsMoreDataFalse(mFlags)) {
            byteBuffer.put((byte) mStrokeRate);
            byteBuffer.putShort((short) mStrokeCount);
            length += 3;
        }
        if (RowerDataUtils.isFlagsAverageStrokePresent(mFlags)) {
            byteBuffer.put((byte) mAverageStrokeRate);
            length++;
        }
        if (RowerDataUtils.isFlagsTotalDistancePresente(mFlags)) {
            byteBuffer.put((byte) mTotalDistance);
            byteBuffer.put((byte) (mTotalDistance >> 8));
            byteBuffer.put((byte) (mTotalDistance >> 16));
            length += 3;
        }
        if (RowerDataUtils.isFlagsInstantaneousPacePresent(mFlags)) {
            byteBuffer.putShort((short) mInstantaneousPace);
            length += 2;
        }
        if (RowerDataUtils.isFlagsAveragePacePresent(mFlags)) {
            byteBuffer.putShort((short) mAveragePace);
            length += 2;
        }
        if (RowerDataUtils.isFlagsInstantaneousPowerPresent(mFlags)) {
            byteBuffer.putShort((short) mInstantaneousPower);
            length += 2;
        }
        if (RowerDataUtils.isFlagsAveragePowerPresent(mFlags)) {
            byteBuffer.putShort((short) mAveragePower);
            length += 2;
        }
        if (RowerDataUtils.isFlagsResistanceLevelPresent(mFlags)) {
            byteBuffer.putShort((short) mResistanceLevel);
            length += 2;
        }
        if (RowerDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
            byteBuffer.putShort((short) mTotalEnergy);
            byteBuffer.putShort((short) mEnergyPerHour);
            byteBuffer.put((byte) mEnergyPerMinute);
            length += 5;
        }
        if (RowerDataUtils.isFlagsHeartRatePresent(mFlags)) {
            byteBuffer.put((byte) mHeartRate);
            length++;
        }
        if (RowerDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            byteBuffer.put((byte) mMetabolicEquivalent);
            length++;
        }
        if (RowerDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            byteBuffer.putShort((short) mElapsedTime);
            length += 2;
        }
        if (RowerDataUtils.isFlagsRemainingTimePresent(mFlags)) {
            byteBuffer.putShort((short) mRemainingTime);
            length += 2;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

}
