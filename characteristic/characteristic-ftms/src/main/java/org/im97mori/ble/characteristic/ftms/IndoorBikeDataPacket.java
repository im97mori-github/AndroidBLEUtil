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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INDOOR_BIKE_DATA_CHARACTERISTIC;

/**
 * Indoor Bike Data packet (Characteristics UUID: 0x2AD2)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IndoorBikeDataPacket implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IndoorBikeDataPacket> CREATOR = new ByteArrayCreater<IndoorBikeDataPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataPacket createFromParcel(@NonNull Parcel in) {
            return new IndoorBikeDataPacket(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataPacket[] newArray(int size) {
            return new IndoorBikeDataPacket[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IndoorBikeDataPacket createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IndoorBikeDataPacket(bluetoothGattCharacteristic);
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
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD2
     */
    public IndoorBikeDataPacket(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 2;
        mFlags = Arrays.copyOfRange(values, 0, 2);
        if (IndoorBikeDataUtils.isFlagsMoreDataFalse(mFlags)) {
            mInstantaneousSpeed = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mInstantaneousSpeed = 0;
        }
        if (IndoorBikeDataUtils.isFlagsAverageSpeedPresent(mFlags)) {
            mAverageSpeed = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mAverageSpeed = 0;
        }
        if (IndoorBikeDataUtils.isFlagsInstantaneousCadencePresent(mFlags)) {
            mInstantaneousCadence = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mInstantaneousCadence = 0;
        }
        if (IndoorBikeDataUtils.isFlagsAverageCandencePresent(mFlags)) {
            mAverageCadence = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mAverageCadence = 0;
        }
        if (IndoorBikeDataUtils.isFlagsTotalDistancePresent(mFlags)) {
            mTotalDistance = BLEUtils.createUInt24(values, index);
            index += 3;
        } else {
            mTotalDistance = 0;
        }
        if (IndoorBikeDataUtils.isFlagsResistanceLevelPresent(mFlags)) {
            mResistanceLevel = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mResistanceLevel = 0;
        }
        if (IndoorBikeDataUtils.isFlagsInstantaneousPowerPresent(mFlags)) {
            mInstantaneousPower = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mInstantaneousPower = 0;
        }
        if (IndoorBikeDataUtils.isFlagsAveragePowerPresent(mFlags)) {
            mAveragePower = BLEUtils.createSInt16(values, index);
            index += 2;
        } else {
            mAveragePower = 0;
        }
        if (IndoorBikeDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
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
        if (IndoorBikeDataUtils.isFlagsHeartRatePresent(mFlags)) {
            mHeartRate = (values[index++] & 0xff);
        } else {
            mHeartRate = 0;
        }
        if (IndoorBikeDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            mMetabolicEquivalent = (values[index++] & 0xff);
        } else {
            mMetabolicEquivalent = 0;
        }
        if (IndoorBikeDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            mElapsedTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mElapsedTime = 0;
        }
        if (IndoorBikeDataUtils.isFlagsRemainingTimePresent(mFlags)) {
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
    private IndoorBikeDataPacket(@NonNull Parcel in) {
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
        if (IndoorBikeDataUtils.isFlagsMoreDataFalse(mFlags)) {
            byteBuffer.putShort((short) mInstantaneousSpeed);
            length += 2;
        }
        if (IndoorBikeDataUtils.isFlagsAverageSpeedPresent(mFlags)) {
            byteBuffer.putShort((short) mAverageSpeed);
            length += 2;
        }
        if (IndoorBikeDataUtils.isFlagsInstantaneousCadencePresent(mFlags)) {
            byteBuffer.putShort((short) mInstantaneousCadence);
            length += 2;
        }
        if (IndoorBikeDataUtils.isFlagsAverageCandencePresent(mFlags)) {
            byteBuffer.putShort((short) mAverageCadence);
            length += 2;
        }
        if (IndoorBikeDataUtils.isFlagsTotalDistancePresent(mFlags)) {
            byteBuffer.put((byte) mTotalDistance);
            byteBuffer.put((byte) (mTotalDistance >> 8));
            byteBuffer.put((byte) (mTotalDistance >> 16));
            length += 3;
        }
        if (IndoorBikeDataUtils.isFlagsResistanceLevelPresent(mFlags)) {
            byteBuffer.putShort((short) mResistanceLevel);
            length += 2;
        }
        if (IndoorBikeDataUtils.isFlagsInstantaneousPowerPresent(mFlags)) {
            byteBuffer.putShort((short) mInstantaneousPower);
            length += 2;
        }
        if (IndoorBikeDataUtils.isFlagsAveragePowerPresent(mFlags)) {
            byteBuffer.putShort((short) mAveragePower);
            length += 2;
        }
        if (IndoorBikeDataUtils.isFlagsExpendedEnergyPresent(mFlags)) {
            byteBuffer.putShort((short) mTotalEnergy);
            byteBuffer.putShort((short) mEnergyPerHour);
            byteBuffer.put((byte) mEnergyPerMinute);
            length += 5;
        }
        if (IndoorBikeDataUtils.isFlagsHeartRatePresent(mFlags)) {
            byteBuffer.put((byte) mHeartRate);
            length++;
        }
        if (IndoorBikeDataUtils.isFlagsMetabolicEquivalentPresent(mFlags)) {
            byteBuffer.put((byte) mMetabolicEquivalent);
            length++;
        }
        if (IndoorBikeDataUtils.isFlagsElapsedTimePresent(mFlags)) {
            byteBuffer.putShort((short) mElapsedTime);
            length += 2;
        }
        if (IndoorBikeDataUtils.isFlagsRemainingTimePresent(mFlags)) {
            byteBuffer.putShort((short) mRemainingTime);
            length += 2;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

}
