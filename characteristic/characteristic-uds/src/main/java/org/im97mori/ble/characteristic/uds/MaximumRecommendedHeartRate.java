package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;

/**
 * Maximum Recommended Heart Rate (Characteristics UUID: 0x2A91)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class MaximumRecommendedHeartRate implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MaximumRecommendedHeartRate> CREATOR = new ByteArrayCreater<MaximumRecommendedHeartRate>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MaximumRecommendedHeartRate createFromParcel(@NonNull Parcel in) {
            return new MaximumRecommendedHeartRate(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MaximumRecommendedHeartRate[] newArray(int size) {
            return new MaximumRecommendedHeartRate[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MaximumRecommendedHeartRate createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MaximumRecommendedHeartRate(bluetoothGattCharacteristic);
        }

    };

    /**
     * Maximum Recommended Heart Rate
     */
    private final int mMaximumRecommendedHeartRate;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A91
     */
    public MaximumRecommendedHeartRate(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMaximumRecommendedHeartRate = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MaximumRecommendedHeartRate(@NonNull Parcel in) {
        mMaximumRecommendedHeartRate = in.readInt();
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
        dest.writeInt(mMaximumRecommendedHeartRate);
    }

    /**
     * @return Maximum Recommended Heart Rate
     */
    public int getMaximumRecommendedHeartRate() {
        return mMaximumRecommendedHeartRate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mMaximumRecommendedHeartRate);
        return data;
    }

}
