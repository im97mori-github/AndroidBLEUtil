package org.im97mori.ble.characteristic.u2a99;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Database Change Increment (Characteristics UUID: 0x2A99)
 */
@SuppressWarnings({"WeakerAccess"})
public class DatabaseChangeIncrementAndroid extends DatabaseChangeIncrement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DatabaseChangeIncrementAndroid> CREATOR = new ByteArrayCreator<DatabaseChangeIncrementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseChangeIncrementAndroid createFromParcel(@NonNull Parcel in) {
            return new DatabaseChangeIncrementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseChangeIncrementAndroid[] newArray(int size) {
            return new DatabaseChangeIncrementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DatabaseChangeIncrementAndroid createFromByteArray(@NonNull byte[] values) {
            return new DatabaseChangeIncrementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A99
     */
    @Deprecated
    public DatabaseChangeIncrementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DatabaseChangeIncrementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param databaseChangeIncrement Database Change Increment
     */
    public DatabaseChangeIncrementAndroid(long databaseChangeIncrement) {
        super(databaseChangeIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DatabaseChangeIncrementAndroid(@NonNull Parcel in) {
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
