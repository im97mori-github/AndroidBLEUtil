package org.im97mori.ble.characteristic.u2b37;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

public class RegisteredUserAndroid extends RegisteredUser implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RegisteredUserAndroid> CREATOR = new ByteArrayCreator<RegisteredUserAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RegisteredUserAndroid createFromParcel(@NonNull Parcel in) {
            return new RegisteredUserAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RegisteredUserAndroid[] newArray(int size) {
            return new RegisteredUserAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RegisteredUserAndroid createFromByteArray(@NonNull byte[] values) {
            return new RegisteredUserAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B37
     */
    @Deprecated
    public RegisteredUserAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RegisteredUserAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RegisteredUserAndroid(@NonNull Parcel in) {
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
