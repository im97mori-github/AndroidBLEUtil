package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Complete List of 32-bit Service Class UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class CompleteListOf32BitServiceUUIDsAndroid extends CompleteListOf32BitServiceUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CompleteListOf32BitServiceUUIDsAndroid> CREATOR = new ByteArrayCreater<CompleteListOf32BitServiceUUIDsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CompleteListOf32BitServiceUUIDsAndroid createFromParcel(@NonNull Parcel in) {
            return new CompleteListOf32BitServiceUUIDsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CompleteListOf32BitServiceUUIDsAndroid[] newArray(int size) {
            return new CompleteListOf32BitServiceUUIDsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public CompleteListOf32BitServiceUUIDsAndroid createFromByteArray(@NonNull byte[] values) {
            return new CompleteListOf32BitServiceUUIDsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Complete List of 32-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public CompleteListOf32BitServiceUUIDsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CompleteListOf32BitServiceUUIDsAndroid(Parcel in) {
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
