package org.im97mori.ble.characteristic.u2b4a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Handedness (Characteristics UUID: 0x2B4A)
 */
@SuppressWarnings({"WeakerAccess"})
public class HandednessAndroid extends Handedness implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HandednessAndroid> CREATOR = new ByteArrayCreator<HandednessAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HandednessAndroid createFromParcel(@NonNull Parcel in) {
            return new HandednessAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HandednessAndroid[] newArray(int size) {
            return new HandednessAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HandednessAndroid createFromByteArray(@NonNull byte[] values) {
            return new HandednessAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4A
     */
    @Deprecated
    public HandednessAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HandednessAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param handedness Handedness
     */
    public HandednessAndroid(int handedness) {
        super(handedness);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HandednessAndroid(@NonNull Parcel in) {
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
