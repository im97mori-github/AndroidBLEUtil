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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_SPEED_RANGE_CHARACTERISTIC;

/**
 * Supported Speed Range (Characteristics UUID: 0x2AD4)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedSpeedRange implements ByteArrayInterface, Parcelable {

    /**
     * Minimum Speed Unit 0.01 Kilometer per hour
     */
    public static final double MINIMUM_SPEED_RESOLUTION = 0.01d;

    /**
     * Maximum Speed Unit 0.01 Kilometer per hour
     */
    public static final double MAXIMUM_SPEED_RESOLUTION = 0.01d;

    /**
     * Minimum Increment Unit 0.01 Meters per second
     */
    public static final double MINIMUM_INCREMENT_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedSpeedRange> CREATOR = new ByteArrayCreater<SupportedSpeedRange>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedSpeedRange createFromParcel(@NonNull Parcel in) {
            return new SupportedSpeedRange(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedSpeedRange[] newArray(int size) {
            return new SupportedSpeedRange[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedSpeedRange createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedSpeedRange(bluetoothGattCharacteristic);
        }

    };

    /**
     * Minimum Speed
     */
    private final int mMinimumSpeed;

    /**
     * Maximum Speed
     */
    private final int mMaximumSpeed;

    /**
     * Minimum Increment
     */
    private final int mMinimumIncrement;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD4
     */
    public SupportedSpeedRange(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMinimumSpeed = BLEUtils.createUInt16(values, 0);
        mMaximumSpeed = BLEUtils.createUInt16(values, 2);
        mMinimumIncrement = BLEUtils.createUInt16(values, 4);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedSpeedRange(@NonNull Parcel in) {
        mMinimumSpeed = in.readInt();
        mMaximumSpeed = in.readInt();
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
        dest.writeInt(mMinimumSpeed);
        dest.writeInt(mMaximumSpeed);
        dest.writeInt(mMinimumIncrement);
    }

    /**
     * @return Minimum Speed
     */
    public int getMinimumSpeed() {
        return mMinimumSpeed;
    }

    /**
     * @return Minimum Speed(Kilometer per hour)
     */
    public double getMinimumSpeedKilometerPerHour() {
        return MINIMUM_SPEED_RESOLUTION * mMinimumSpeed;
    }

    /**
     * @return Maximum Speed
     */
    public int getMaximumSpeed() {
        return mMaximumSpeed;
    }

    /**
     * @return Maximum Speed(Kilometer per hour)
     */
    public double getMaximumSpeedKilometerPerHour() {
        return MAXIMUM_SPEED_RESOLUTION * mMaximumSpeed;
    }

    /**
     * @return Minimum Increment
     */
    public int getMinimumIncrement() {
        return mMinimumIncrement;
    }

    /**
     * @return Minimum Increment(Meters per second)
     */
    public double getMinimumIncrementMetersPerSecond() {
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
        byteBuffer.putShort((short) mMinimumSpeed);
        byteBuffer.putShort((short) mMaximumSpeed);
        byteBuffer.putShort((short) mMinimumIncrement);
        return data;
    }

}
