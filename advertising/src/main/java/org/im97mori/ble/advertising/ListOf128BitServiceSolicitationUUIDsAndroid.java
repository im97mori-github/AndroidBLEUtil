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
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #ListOf128BitServiceSolicitationUUIDsAndroid(byte[], int, int)
     */
    public ListOf128BitServiceSolicitationUUIDsAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

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
     * Constructor for Incomplete List of 128-bit Service Class UUIDs
     *
     * @param uuids UUID array
     * @see ListOf128BitServiceSolicitationUUIDsAndroid#ListOf128BitServiceSolicitationUUIDsAndroid(List)
     */
    public ListOf128BitServiceSolicitationUUIDsAndroid(@NonNull UUID... uuids) {
        this(Arrays.asList(uuids));
    }

    /**
     * Constructor for Incomplete List of 128-bit Service Class UUIDs
     *
     * @param uuidList UUID list
     */
    public ListOf128BitServiceSolicitationUUIDsAndroid(@NonNull List<UUID> uuidList) {
        super(uuidList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ListOf128BitServiceSolicitationUUIDsAndroid(Parcel in) {
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
