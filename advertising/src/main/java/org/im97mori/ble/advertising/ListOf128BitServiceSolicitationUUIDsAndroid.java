package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * List of 128-bit Service Solicitation UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ListOf128BitServiceSolicitationUUIDsAndroid extends ListOf128BitServiceSolicitationUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ListOf128BitServiceSolicitationUUIDsAndroid> CREATOR = new ByteArrayCreater<ListOf128BitServiceSolicitationUUIDsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ListOf128BitServiceSolicitationUUIDsAndroid createFromParcel(@NonNull Parcel in) {
            return new ListOf128BitServiceSolicitationUUIDsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ListOf128BitServiceSolicitationUUIDsAndroid[] newArray(int size) {
            return new ListOf128BitServiceSolicitationUUIDsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ListOf128BitServiceSolicitationUUIDsAndroid createFromByteArray(@NonNull byte[] values) {
            return new ListOf128BitServiceSolicitationUUIDsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for List of 128-bit Service Solicitation UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ListOf128BitServiceSolicitationUUIDsAndroid(@NonNull byte[] data
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
    private ListOf128BitServiceSolicitationUUIDsAndroid(Parcel in) {
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
