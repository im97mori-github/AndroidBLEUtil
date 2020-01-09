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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;

/**
 * Supported Inclination Range (Characteristics UUID: 0x2AD5)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedInclinationRange implements ByteArrayInterface, Parcelable {

    /**
     * Minimum Inclination Unit 0.1 Percent
     */
    public static final double MINIMUM_INCLINATION_RESOLUTION = 0.1d;

    /**
     * Maximum Inclination Unit 0.1 Percent
     */
    public static final double MAXIMUM_INCLINATION_RESOLUTION = 0.1d;

    /**
     * Minimum Increment Unit 0.1 Percent
     */
    public static final double MINIMUM_INCREMENT_RESOLUTION = 0.1d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedInclinationRange> CREATOR = new ByteArrayCreater<SupportedInclinationRange>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedInclinationRange createFromParcel(@NonNull Parcel in) {
            return new SupportedInclinationRange(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedInclinationRange[] newArray(int size) {
            return new SupportedInclinationRange[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedInclinationRange createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedInclinationRange(bluetoothGattCharacteristic);
        }

    };

    /**
     * Minimum Inclination
     */
    private final int mMinimumInclination;

    /**
     * Maximum Inclination
     */
    private final int mMaximumInclination;

    /**
     * Minimum Increment
     */
    private final int mMinimumIncrement;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD5
     */
    public SupportedInclinationRange(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMinimumInclination = BLEUtils.createSInt16(values, 0);
        mMaximumInclination = BLEUtils.createSInt16(values, 2);
        mMinimumIncrement = BLEUtils.createUInt16(values, 4);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedInclinationRange(@NonNull Parcel in) {
        mMinimumInclination = in.readInt();
        mMaximumInclination = in.readInt();
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
        dest.writeInt(mMinimumInclination);
        dest.writeInt(mMaximumInclination);
        dest.writeInt(mMinimumIncrement);
    }

    /**
     * @return Minimum Inclination
     */
    public int getMinimumInclination() {
        return mMinimumInclination;
    }

    /**
     * @return Minimum Inclination(Percent)
     */
    public double getMinimumInclinationPercent() {
        return MINIMUM_INCLINATION_RESOLUTION * mMinimumInclination;
    }

    /**
     * @return Maximum Inclination
     */
    public int getMaximumInclination() {
        return mMaximumInclination;
    }

    /**
     * @return Maximum Inclination(Percent)
     */
    public double getMaximumInclinationPercent() {
        return MAXIMUM_INCLINATION_RESOLUTION * mMaximumInclination;
    }

    /**
     * @return Minimum Increment
     */
    public int getMinimumIncrement() {
        return mMinimumIncrement;
    }

    /**
     * @return Minimum Increment(Percent)
     */
    public double getMinimumIncrementPercent() {
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
        byteBuffer.putShort((short) mMinimumInclination);
        byteBuffer.putShort((short) mMaximumInclination);
        byteBuffer.putShort((short) mMinimumIncrement);
        return data;
    }

}
