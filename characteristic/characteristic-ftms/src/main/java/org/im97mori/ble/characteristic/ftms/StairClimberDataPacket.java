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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.STAIR_CLIMBER_DATA_CHARACTERISTIC;

/**
 * Stair Climber Data packet (Characteristics UUID: 0x2AD0)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class StairClimberDataPacket implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<StairClimberDataPacket> CREATOR = new ByteArrayCreater<StairClimberDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StairClimberDataPacket createFromParcel(@NonNull Parcel in) {
            return new StairClimberDataPacket(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StairClimberDataPacket[] newArray(int size) {
            return new StairClimberDataPacket[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public StairClimberDataPacket createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new StairClimberDataPacket(bluetoothGattCharacteristic);
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
     * Stride Count
     */
    private final int mStrideCount;

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
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD0
     */
    public StairClimberDataPacket(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 2;
        mFlags = Arrays.copyOfRange(values, 0, 2);
        if (StairClimberDataUtils.isFlagsMoreDataFalse(mFlags)) {
            mFloors = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mFloors = 0;
        }
        if (StairClimberDataUtils.isFlagsStepPerMinutePresent(mFlags)) {
            mStepPerMinute = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mStepPerMinute = 0;
        }
        if (StairClimberDataUtils.isFlagsAverageStepRatePresent(mFlags)) {
            mAverageStepRate = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mAverageStepRate = 0;
        }
        if (StairClimberDataUtils.isFlagsPositiveElevationGainPresent(mFlags)) {
            mPositiveElevationGain = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mPositiveElevationGain = 0;
        }
        if (StairClimberDataUtils.isFlagsStrideCountPresent(mFlags)) {
            mStrideCount = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mStrideCount = 0;
        }
        if (StairClimberDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
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
        if (StairClimberDataUtils.isFlagsHeartRatePresent(mFlags)) {
            mHeartRate = (values[index++] & 0xff);
        } else {
            mHeartRate = 0;
        }
        if (StairClimberDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            mMetabolicEquivalent = (values[index++] & 0xff);
        } else {
            mMetabolicEquivalent = 0;
        }
        if (StairClimberDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            mElapsedTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mElapsedTime = 0;
        }
        if (StairClimberDataUtils.isFlagsRemainingTimePresent(mFlags)) {
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
    private StairClimberDataPacket(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mFloors = in.readInt();
        mStepPerMinute = in.readInt();
        mAverageStepRate = in.readInt();
        mPositiveElevationGain = in.readInt();
        mStrideCount = in.readInt();
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
        dest.writeInt(mStepPerMinute);
        dest.writeInt(mAverageStepRate);
        dest.writeInt(mPositiveElevationGain);
        dest.writeInt(mStrideCount);
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
     * @return Stride Count
     */
    public int getStrideCount() {
        return mStrideCount;
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
        byte[] data = new byte[23];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        length += 2;
        if (StairClimberDataUtils.isFlagsMoreDataFalse(mFlags)) {
            byteBuffer.putShort((short) mFloors);
            length += 2;
        }
        if (StairClimberDataUtils.isFlagsStepPerMinutePresent(mFlags)) {
            byteBuffer.putShort((short) mStepPerMinute);
            length += 2;
        }
        if (StairClimberDataUtils.isFlagsAverageStepRatePresent(mFlags)) {
            byteBuffer.putShort((short) mAverageStepRate);
            length += 2;
        }
        if (StairClimberDataUtils.isFlagsPositiveElevationGainPresent(mFlags)) {
            byteBuffer.putShort((short) mPositiveElevationGain);
            length += 2;
        }
        if (StairClimberDataUtils.isFlagsStrideCountPresent(mFlags)) {
            byteBuffer.putShort((short) mStrideCount);
            length += 2;
        }
        if (StairClimberDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
            byteBuffer.putShort((short) mTotalEnergy);
            byteBuffer.putShort((short) mEnergyPerHour);
            byteBuffer.put((byte) mEnergyPerMinute);
            length += 5;
        }
        if (StairClimberDataUtils.isFlagsHeartRatePresent(mFlags)) {
            byteBuffer.put((byte) mHeartRate);
            length++;
        }
        if (StairClimberDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            byteBuffer.put((byte) mMetabolicEquivalent);
            length++;
        }
        if (StairClimberDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            byteBuffer.putShort((short) mElapsedTime);
            length += 2;
        }
        if (StairClimberDataUtils.isFlagsRemainingTimePresent(mFlags)) {
            byteBuffer.putShort((short) mRemainingTime);
            length += 2;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

}
