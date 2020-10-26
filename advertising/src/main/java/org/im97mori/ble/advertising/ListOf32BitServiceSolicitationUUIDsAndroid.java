package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * List of 32-bit Service Solicitation UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ListOf32BitServiceSolicitationUUIDsAndroid extends ListOf32BitServiceSolicitationUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ListOf32BitServiceSolicitationUUIDsAndroid> CREATOR = new ByteArrayCreater<ListOf32BitServiceSolicitationUUIDsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ListOf32BitServiceSolicitationUUIDsAndroid createFromParcel(@NonNull Parcel in) {
            return new ListOf32BitServiceSolicitationUUIDsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ListOf32BitServiceSolicitationUUIDsAndroid[] newArray(int size) {
            return new ListOf32BitServiceSolicitationUUIDsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ListOf32BitServiceSolicitationUUIDsAndroid createFromByteArray(@NonNull byte[] values) {
            return new ListOf32BitServiceSolicitationUUIDsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for List of 32-bit Service Solicitation UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ListOf32BitServiceSolicitationUUIDsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ListOf32BitServiceSolicitationUUIDsAndroid(@NonNull Parcel in) {
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
