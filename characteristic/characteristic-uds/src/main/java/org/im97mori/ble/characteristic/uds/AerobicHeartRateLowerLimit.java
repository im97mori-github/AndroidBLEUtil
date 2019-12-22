package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;

/**
 * Aerobic Heart Rate Lower Limit (Characteristics UUID: 0x2A7E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AerobicHeartRateLowerLimit implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AerobicHeartRateLowerLimit> CREATOR = new ByteArrayCreater<AerobicHeartRateLowerLimit>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateLowerLimit createFromParcel(@NonNull Parcel in) {
            return new AerobicHeartRateLowerLimit(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateLowerLimit[] newArray(int size) {
            return new AerobicHeartRateLowerLimit[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AerobicHeartRateLowerLimit createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AerobicHeartRateLowerLimit(bluetoothGattCharacteristic);
        }

    };

    /**
     * Aerobic Heart Rate Lower Limit
     */
    private final int mAerobicHeartRateLowerLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7E
     */
    public AerobicHeartRateLowerLimit(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAerobicHeartRateLowerLimit = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AerobicHeartRateLowerLimit(@NonNull Parcel in) {
        mAerobicHeartRateLowerLimit = in.readInt();
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
        dest.writeInt(mAerobicHeartRateLowerLimit);
    }

    /**
     * @return Aerobic Heart Rate Lower Limit
     */
    public int getAerobicHeartRateLowerLimit() {
        return mAerobicHeartRateLowerLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAerobicHeartRateLowerLimit);
        return data;
    }

}
