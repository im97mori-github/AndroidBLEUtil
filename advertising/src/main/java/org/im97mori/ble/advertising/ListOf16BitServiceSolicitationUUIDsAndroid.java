package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * List of 16-bit Service Solicitation UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ListOf16BitServiceSolicitationUUIDsAndroid extends ListOf16BitServiceSolicitationUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ListOf16BitServiceSolicitationUUIDsAndroid> CREATOR = new ByteArrayCreater<ListOf16BitServiceSolicitationUUIDsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ListOf16BitServiceSolicitationUUIDsAndroid createFromParcel(@NonNull Parcel in) {
            return new ListOf16BitServiceSolicitationUUIDsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ListOf16BitServiceSolicitationUUIDsAndroid[] newArray(int size) {
            return new ListOf16BitServiceSolicitationUUIDsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ListOf16BitServiceSolicitationUUIDsAndroid createFromByteArray(@NonNull byte[] values) {
            return new ListOf16BitServiceSolicitationUUIDsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #ListOf16BitServiceSolicitationUUIDsAndroid(byte[], int, int)
     */
    public ListOf16BitServiceSolicitationUUIDsAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Complete List of 16-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ListOf16BitServiceSolicitationUUIDsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor for List of 128-bit Service Solicitation UUIDs
     *
     * @param uuids UUID array
     * @see ListOf16BitServiceSolicitationUUIDsAndroid#ListOf16BitServiceSolicitationUUIDsAndroid(List)
     */
    public ListOf16BitServiceSolicitationUUIDsAndroid(@NonNull UUID... uuids) {
        this(Arrays.asList(uuids));
    }

    /**
     * Constructor from parameters
     *
     * @param uuidList UUID list
     */
    public ListOf16BitServiceSolicitationUUIDsAndroid(@NonNull List<UUID> uuidList) {
        super(uuidList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ListOf16BitServiceSolicitationUUIDsAndroid(Parcel in) {
        //noinspection ConstantConditions
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
