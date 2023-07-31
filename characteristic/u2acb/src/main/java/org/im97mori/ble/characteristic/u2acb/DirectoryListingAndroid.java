package org.im97mori.ble.characteristic.u2acb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Directory Listing (Characteristics UUID: 0x2ACB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DirectoryListingAndroid extends DirectoryListing implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DirectoryListingAndroid> CREATOR = new ByteArrayCreator<DirectoryListingAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DirectoryListingAndroid createFromParcel(@NonNull Parcel in) {
            return new DirectoryListingAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DirectoryListingAndroid[] newArray(int size) {
            return new DirectoryListingAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DirectoryListingAndroid createFromByteArray(@NonNull byte[] values) {
            return new DirectoryListingAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACB
     */
    @Deprecated
    public DirectoryListingAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DirectoryListingAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DirectoryListingAndroid(@NonNull Parcel in) {
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
