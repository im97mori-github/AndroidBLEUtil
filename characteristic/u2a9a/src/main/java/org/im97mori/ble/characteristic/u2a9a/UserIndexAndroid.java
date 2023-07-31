package org.im97mori.ble.characteristic.u2a9a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * User Index (Characteristics UUID: 0x2A9A)
 */
@SuppressWarnings({"WeakerAccess"})
public class UserIndexAndroid extends UserIndex implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<UserIndexAndroid> CREATOR = new ByteArrayCreator<UserIndexAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserIndexAndroid createFromParcel(@NonNull Parcel in) {
            return new UserIndexAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserIndexAndroid[] newArray(int size) {
            return new UserIndexAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UserIndexAndroid createFromByteArray(@NonNull byte[] values) {
            return new UserIndexAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9A
     */
    @Deprecated
    public UserIndexAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public UserIndexAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param userIndex User Index
     */
    public UserIndexAndroid(int userIndex) {
        super(userIndex);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UserIndexAndroid(@NonNull Parcel in) {
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
