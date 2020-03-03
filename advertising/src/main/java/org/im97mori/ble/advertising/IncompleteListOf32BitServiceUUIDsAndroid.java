package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Incomplete List of 32-bit Service Class UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class IncompleteListOf32BitServiceUUIDsAndroid extends IncompleteListOf32BitServiceUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IncompleteListOf32BitServiceUUIDsAndroid> CREATOR = new ByteArrayCreater<IncompleteListOf32BitServiceUUIDsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncompleteListOf32BitServiceUUIDsAndroid createFromParcel(@NonNull Parcel in) {
            return new IncompleteListOf32BitServiceUUIDsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncompleteListOf32BitServiceUUIDsAndroid[] newArray(int size) {
            return new IncompleteListOf32BitServiceUUIDsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IncompleteListOf32BitServiceUUIDsAndroid createFromByteArray(@NonNull byte[] values) {
            return new IncompleteListOf32BitServiceUUIDsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Incomplete List of 32-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public IncompleteListOf32BitServiceUUIDsAndroid(@NonNull byte[] data
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
    private IncompleteListOf32BitServiceUUIDsAndroid(@NonNull Parcel in) {
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
