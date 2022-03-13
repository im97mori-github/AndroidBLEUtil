package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * Complete List of 16-bit Service Class UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class CompleteListOf16BitServiceUUIDsAndroid extends CompleteListOf16BitServiceUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CompleteListOf16BitServiceUUIDsAndroid> CREATOR = new ByteArrayCreator<CompleteListOf16BitServiceUUIDsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CompleteListOf16BitServiceUUIDsAndroid createFromParcel(@NonNull Parcel in) {
            return new CompleteListOf16BitServiceUUIDsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CompleteListOf16BitServiceUUIDsAndroid[] newArray(int size) {
            return new CompleteListOf16BitServiceUUIDsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public CompleteListOf16BitServiceUUIDsAndroid createFromByteArray(@NonNull byte[] values) {
            return new CompleteListOf16BitServiceUUIDsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #CompleteListOf16BitServiceUUIDsAndroid(byte[], int, int)
     */
    public CompleteListOf16BitServiceUUIDsAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Complete List of 16-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public CompleteListOf16BitServiceUUIDsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor for Complete List of 16-bit Service Class UUIDs
     *
     * @param uuids UUID array
     * @see CompleteListOf16BitServiceUUIDsAndroid#CompleteListOf16BitServiceUUIDsAndroid(List)
     */
    public CompleteListOf16BitServiceUUIDsAndroid(@NonNull UUID... uuids) {
        this(Arrays.asList(uuids));
    }

    /**
     * Constructor for Complete List of 16-bit Service Class UUIDs
     *
     * @param uuidList UUID list
     */
    public CompleteListOf16BitServiceUUIDsAndroid(@NonNull List<UUID> uuidList) {
        super(uuidList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CompleteListOf16BitServiceUUIDsAndroid(Parcel in) {
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
