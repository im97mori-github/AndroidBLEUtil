package org.im97mori.ble.characteristic.u2b9b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Seeking Speed (Characteristics UUID: 0x2B9B)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SeekingSpeedAndroid extends SeekingSpeed implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SeekingSpeedAndroid> CREATOR = new ByteArrayCreator<SeekingSpeedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SeekingSpeedAndroid createFromParcel(@NonNull Parcel in) {
            return new SeekingSpeedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SeekingSpeedAndroid[] newArray(int size) {
            return new SeekingSpeedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SeekingSpeedAndroid createFromByteArray(@NonNull byte[] values) {
            return new SeekingSpeedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9B
     */
    @Deprecated
    public SeekingSpeedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SeekingSpeedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SeekingSpeedAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
        dest.writeByteArray(getBytes());
    }

}
