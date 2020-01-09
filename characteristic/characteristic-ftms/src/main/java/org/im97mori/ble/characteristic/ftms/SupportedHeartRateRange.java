package org.im97mori.ble.characteristic.ftms;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;

/**
 * Supported Heart Rate Range (Characteristics UUID: 0x2AD7)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedHeartRateRange implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedHeartRateRange> CREATOR = new ByteArrayCreater<SupportedHeartRateRange>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedHeartRateRange createFromParcel(@NonNull Parcel in) {
            return new SupportedHeartRateRange(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedHeartRateRange[] newArray(int size) {
            return new SupportedHeartRateRange[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedHeartRateRange createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedHeartRateRange(bluetoothGattCharacteristic);
        }

    };

    /**
     * Minimum Heart Rate
     */
    private final int mMinimumHeartRate;

    /**
     * Maximum Heart Rate
     */
    private final int mMaximumHeartRate;

    /**
     * Minimum Increment
     */
    private final int mMinimumIncrement;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD7
     */
    public SupportedHeartRateRange(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMinimumHeartRate = (values[0] & 0xff);
        mMaximumHeartRate = (values[1] & 0xff);
        mMinimumIncrement = (values[2] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedHeartRateRange(@NonNull Parcel in) {
        mMinimumHeartRate = in.readInt();
        mMaximumHeartRate = in.readInt();
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
        dest.writeInt(mMinimumHeartRate);
        dest.writeInt(mMaximumHeartRate);
        dest.writeInt(mMinimumIncrement);
    }

    /**
     * @return Minimum Heart Rate
     */
    public int getMinimumHeartRate() {
        return mMinimumHeartRate;
    }

    /**
     * @return Maximum Heart Rate
     */
    public int getMaximumHeartRate() {
        return mMaximumHeartRate;
    }

    /**
     * @return Minimum Increment
     */
    public int getMinimumIncrement() {
        return mMinimumIncrement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[3];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mMinimumHeartRate);
        byteBuffer.put((byte) mMaximumHeartRate);
        byteBuffer.put((byte) mMinimumIncrement);
        return data;
    }

}
