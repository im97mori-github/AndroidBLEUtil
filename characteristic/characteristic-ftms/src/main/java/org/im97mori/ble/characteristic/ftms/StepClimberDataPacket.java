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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.STEP_CLIMBER_DATA_CHARACTERISTIC;

/**
 * Step Climber Data packet (Characteristics UUID: 0x2ACF)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class StepClimberDataPacket implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<StepClimberDataPacket> CREATOR = new ByteArrayCreater<StepClimberDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepClimberDataPacket createFromParcel(@NonNull Parcel in) {
            return new StepClimberDataPacket(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepClimberDataPacket[] newArray(int size) {
            return new StepClimberDataPacket[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public StepClimberDataPacket createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new StepClimberDataPacket(bluetoothGattCharacteristic);
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
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACF
     */
    public StepClimberDataPacket(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 2;
        mFlags = Arrays.copyOfRange(values, 0, 2);
        if (StepClimberDataUtils.isFlagsMoreDataFalse(mFlags)) {
            mFloors = BLEUtils.createUInt16(values, index);
            index += 2;
            mStepCount = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mFloors = 0;
            mStepCount = 0;
        }
        if (StepClimberDataUtils.isFlagsStepPerMinutePresent(mFlags)) {
            mStepPerMinute = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mStepPerMinute = 0;
        }
        if (StepClimberDataUtils.isFlagsAverageStepRatePresent(mFlags)) {
            mAverageStepRate = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mAverageStepRate = 0;
        }
        if (StepClimberDataUtils.isFlagsPositiveElevationGainPresent(mFlags)) {
            mPositiveElevationGain = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mPositiveElevationGain = 0;
        }
        if (StepClimberDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
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
        if (StepClimberDataUtils.isFlagsHeartRatePresent(mFlags)) {
            mHeartRate = (values[index++] & 0xff);
        } else {
            mHeartRate = 0;
        }
        if (StepClimberDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            mMetabolicEquivalent = (values[index++] & 0xff);
        } else {
            mMetabolicEquivalent = 0;
        }
        if (StepClimberDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            mElapsedTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mElapsedTime = 0;
        }
        if (StepClimberDataUtils.isFlagsRemainingTimePresent(mFlags)) {
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
    private StepClimberDataPacket(@NonNull Parcel in) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 2;
        byte[] data = new byte[23];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        if (StepClimberDataUtils.isFlagsMoreDataFalse(mFlags)) {
            byteBuffer.putShort((short) mFloors);
            byteBuffer.putShort((short) mStepCount);
            length += 4;
        }
        if (StepClimberDataUtils.isFlagsStepPerMinutePresent(mFlags)) {
            byteBuffer.putShort((short) mStepPerMinute);
            length += 2;
        }
        if (StepClimberDataUtils.isFlagsAverageStepRatePresent(mFlags)) {
            byteBuffer.putShort((short) mAverageStepRate);
            length += 2;
        }
        if (StepClimberDataUtils.isFlagsPositiveElevationGainPresent(mFlags)) {
            byteBuffer.putShort((short) mPositiveElevationGain);
            length += 2;
        }
        if (StepClimberDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
            byteBuffer.putShort((short) mTotalEnergy);
            byteBuffer.putShort((short) mEnergyPerHour);
            byteBuffer.put((byte) mEnergyPerMinute);
            length += 5;
        }
        if (StepClimberDataUtils.isFlagsHeartRatePresent(mFlags)) {
            byteBuffer.put((byte) mHeartRate);
            length++;
        }
        if (StepClimberDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            byteBuffer.put((byte) mMetabolicEquivalent);
            length++;
        }
        if (StepClimberDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            byteBuffer.putShort((short) mElapsedTime);
            length += 2;
        }
        if (StepClimberDataUtils.isFlagsRemainingTimePresent(mFlags)) {
            byteBuffer.putShort((short) mRemainingTime);
            length += 2;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

}
