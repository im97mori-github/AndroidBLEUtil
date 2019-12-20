package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;

/**
 * Anaerobic Heart Rate Upper Limit (Characteristics UUID: 0x2A82)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AnaerobicHeartRateUpperLimit implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AnaerobicHeartRateUpperLimit> CREATOR = new ByteArrayCreater<AnaerobicHeartRateUpperLimit>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateUpperLimit createFromParcel(@NonNull Parcel in) {
            return new AnaerobicHeartRateUpperLimit(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateUpperLimit[] newArray(int size) {
            return new AnaerobicHeartRateUpperLimit[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnaerobicHeartRateUpperLimit createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AnaerobicHeartRateUpperLimit(bluetoothGattCharacteristic);
        }

    };

    /**
     * Anaerobic Heart Rate Upper Limit
     */
    private final int mAnaerobicHeartRateUpperLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A82
     */
    public AnaerobicHeartRateUpperLimit(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAnaerobicHeartRateUpperLimit = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnaerobicHeartRateUpperLimit(@NonNull Parcel in) {
        mAnaerobicHeartRateUpperLimit = in.readInt();
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
        dest.writeInt(mAnaerobicHeartRateUpperLimit);
    }

    /**
     * @return Anaerobic Heart Rate Upper Limit
     */
    public int getAnaerobicHeartRateUpperLimit() {
        return mAnaerobicHeartRateUpperLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAnaerobicHeartRateUpperLimit);
        return data;
    }

}
