package org.im97mori.ble.characteristic.u2b2a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Database Hash (Characteristics UUID: 0x2B2A)
 */
@SuppressWarnings({"WeakerAccess"})
public class DatabaseHashAndroid extends DatabaseHash implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DatabaseHashAndroid> CREATOR = new ByteArrayCreator<DatabaseHashAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseHashAndroid createFromParcel(@NonNull Parcel in) {
            return new DatabaseHashAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseHashAndroid[] newArray(int size) {
            return new DatabaseHashAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DatabaseHashAndroid createFromByteArray(@NonNull byte[] values) {
            return new DatabaseHashAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B2A
     */
    @Deprecated
    public DatabaseHashAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DatabaseHashAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DatabaseHashAndroid(@NonNull Parcel in) {
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
