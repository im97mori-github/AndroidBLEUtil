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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;

/**
 * Supported Resistance Level Range (Characteristics UUID: 0x2AD6)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedResistanceLevelRange implements ByteArrayInterface, Parcelable {

    /**
     * Minimum Resistance Level Unit 0.1
     */
    public static final double MINIMUM_RESISTANCE_LEVEL_RESOLUTION = 0.1d;

    /**
     * Maximum Resistance Level Unit 0.1
     */
    public static final double MAXIMUM_RESISTANCE_LEVEL_RESOLUTION = 0.1d;

    /**
     * Minimum Increment Unit 0.1
     */
    public static final double MINIMUM_INCREMENT_RESOLUTION = 0.1d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedResistanceLevelRange> CREATOR = new ByteArrayCreater<SupportedResistanceLevelRange>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedResistanceLevelRange createFromParcel(@NonNull Parcel in) {
            return new SupportedResistanceLevelRange(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedResistanceLevelRange[] newArray(int size) {
            return new SupportedResistanceLevelRange[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedResistanceLevelRange createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedResistanceLevelRange(bluetoothGattCharacteristic);
        }

    };

    /**
     * Minimum Resistance Level
     */
    private final int mMinimumResistanceLevel;

    /**
     * Maximum Resistance Level
     */
    private final int mMaximumResistanceLevel;

    /**
     * Minimum Increment
     */
    private final int mMinimumIncrement;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD6
     */
    public SupportedResistanceLevelRange(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMinimumResistanceLevel = BLEUtils.createSInt16(values, 0);
        mMaximumResistanceLevel = BLEUtils.createSInt16(values, 2);
        mMinimumIncrement = BLEUtils.createUInt16(values, 4);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedResistanceLevelRange(@NonNull Parcel in) {
        mMinimumResistanceLevel = in.readInt();
        mMaximumResistanceLevel = in.readInt();
        mMinimumIncrement = in.readInt();
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
        dest.writeInt(mMinimumResistanceLevel);
        dest.writeInt(mMaximumResistanceLevel);
        dest.writeInt(mMinimumIncrement);
    }

    /**
     * @return Minimum Resistance Level
     */
    public int getMinimumResistanceLevel() {
        return mMinimumResistanceLevel;
    }

    /**
     * @return Minimum Resistance Level with Unit
     */
    public double getMinimumResistanceLevelWithUnit() {
        return MINIMUM_RESISTANCE_LEVEL_RESOLUTION * mMinimumResistanceLevel;
    }

    /**
     * @return Maximum Resistance Level
     */
    public int getMaximumResistanceLevel() {
        return mMaximumResistanceLevel;
    }

    /**
     * @return Maximum Resistance Level with Unit
     */
    public double getMaximumResistanceLevelWithUnit() {
        return MAXIMUM_RESISTANCE_LEVEL_RESOLUTION * mMaximumResistanceLevel;
    }

    /**
     * @return Minimum Increment
     */
    public int getMinimumIncrement() {
        return mMinimumIncrement;
    }

    /**
     * @return Minimum Increment with Unit
     */
    public double getMinimumIncrementWithUnit() {
        return MINIMUM_INCREMENT_RESOLUTION * mMinimumIncrement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[6];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mMinimumResistanceLevel);
        byteBuffer.putShort((short) mMaximumResistanceLevel);
        byteBuffer.putShort((short) mMinimumIncrement);
        return data;
    }

}
