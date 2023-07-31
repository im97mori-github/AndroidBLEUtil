package org.im97mori.ble.characteristic.u2be4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Noise (Characteristics UUID: 0x2BE4)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class NoiseAndroid extends Noise implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<NoiseAndroid> CREATOR = new ByteArrayCreator<NoiseAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NoiseAndroid createFromParcel(@NonNull Parcel in) {
            return new NoiseAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NoiseAndroid[] newArray(int size) {
            return new NoiseAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NoiseAndroid createFromByteArray(@NonNull byte[] values) {
            return new NoiseAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE4
     */
    @Deprecated
    public NoiseAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public NoiseAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NoiseAndroid(@NonNull Parcel in) {
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
