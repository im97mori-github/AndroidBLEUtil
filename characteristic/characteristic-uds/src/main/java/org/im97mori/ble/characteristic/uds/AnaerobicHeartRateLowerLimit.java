package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;

/**
 * Anaerobic Heart Rate Lower Limit (Characteristics UUID: 0x2A81)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AnaerobicHeartRateLowerLimit implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AnaerobicHeartRateLowerLimit> CREATOR = new ByteArrayCreater<AnaerobicHeartRateLowerLimit>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateLowerLimit createFromParcel(@NonNull Parcel in) {
            return new AnaerobicHeartRateLowerLimit(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateLowerLimit[] newArray(int size) {
            return new AnaerobicHeartRateLowerLimit[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnaerobicHeartRateLowerLimit createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AnaerobicHeartRateLowerLimit(bluetoothGattCharacteristic);
        }

    };

    /**
     * Anaerobic Heart Rate Lower Limit
     */
    private final int mAnaerobicHeartRateLowerLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A81
     */
    public AnaerobicHeartRateLowerLimit(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAnaerobicHeartRateLowerLimit = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnaerobicHeartRateLowerLimit(@NonNull Parcel in) {
        mAnaerobicHeartRateLowerLimit = in.readInt();
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
        dest.writeInt(mAnaerobicHeartRateLowerLimit);
    }

    /**
     * @return Anaerobic Heart Rate Lower Limit
     */
    public int getAnaerobicHeartRateLowerLimit() {
        return mAnaerobicHeartRateLowerLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAnaerobicHeartRateLowerLimit);
        return data;
    }

}
