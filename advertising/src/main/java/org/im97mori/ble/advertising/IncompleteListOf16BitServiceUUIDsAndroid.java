package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Incomplete List of 16-bit Service Class UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class IncompleteListOf16BitServiceUUIDsAndroid extends IncompleteListOf16BitServiceUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IncompleteListOf16BitServiceUUIDsAndroid> CREATOR = new ByteArrayCreater<IncompleteListOf16BitServiceUUIDsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncompleteListOf16BitServiceUUIDsAndroid createFromParcel(@NonNull Parcel in) {
            return new IncompleteListOf16BitServiceUUIDsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncompleteListOf16BitServiceUUIDsAndroid[] newArray(int size) {
            return new IncompleteListOf16BitServiceUUIDsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IncompleteListOf16BitServiceUUIDsAndroid createFromByteArray(@NonNull byte[] values) {
            return new IncompleteListOf16BitServiceUUIDsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Incomplete List of 16-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public IncompleteListOf16BitServiceUUIDsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IncompleteListOf16BitServiceUUIDsAndroid(@NonNull Parcel in) {
        super(in.createByteArray(), 0, in.readInt());
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
        dest.writeInt(getLength());
    }

}
