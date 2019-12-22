package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;

/**
 * Aerobic Heart Rate Upper Limit (Characteristics UUID: 0x2A84)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AerobicHeartRateUpperLimit implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AerobicHeartRateUpperLimit> CREATOR = new ByteArrayCreater<AerobicHeartRateUpperLimit>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateUpperLimit createFromParcel(@NonNull Parcel in) {
            return new AerobicHeartRateUpperLimit(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateUpperLimit[] newArray(int size) {
            return new AerobicHeartRateUpperLimit[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AerobicHeartRateUpperLimit createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AerobicHeartRateUpperLimit(bluetoothGattCharacteristic);
        }

    };

    /**
     * Aerobic Heart Rate Upper Limit
     */
    private final int mAerobicHeartRateUpperLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A84
     */
    public AerobicHeartRateUpperLimit(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAerobicHeartRateUpperLimit = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AerobicHeartRateUpperLimit(@NonNull Parcel in) {
        mAerobicHeartRateUpperLimit = in.readInt();
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
        dest.writeInt(mAerobicHeartRateUpperLimit);
    }

    /**
     * @return Aerobic Heart Rate Upper Limit
     */
    public int getAerobicHeartRateUpperLimit() {
        return mAerobicHeartRateUpperLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAerobicHeartRateUpperLimit);
        return data;
    }

}
