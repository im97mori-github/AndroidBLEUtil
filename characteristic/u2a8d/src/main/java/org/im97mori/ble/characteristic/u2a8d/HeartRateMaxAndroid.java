package org.im97mori.ble.characteristic.u2a8d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Heart Rate Max (Characteristics UUID: 0x2A8D)
 */
@SuppressWarnings({"WeakerAccess"})
public class HeartRateMaxAndroid extends HeartRateMax implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HeartRateMaxAndroid> CREATOR = new ByteArrayCreator<HeartRateMaxAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMaxAndroid createFromParcel(@NonNull Parcel in) {
            return new HeartRateMaxAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMaxAndroid[] newArray(int size) {
            return new HeartRateMaxAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeartRateMaxAndroid createFromByteArray(@NonNull byte[] values) {
            return new HeartRateMaxAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8D
     */
    @Deprecated
    public HeartRateMaxAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HeartRateMaxAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param heartRateMax Heart Rate Max
     */
    public HeartRateMaxAndroid(int heartRateMax) {
        super(heartRateMax);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeartRateMaxAndroid(@NonNull Parcel in) {
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
