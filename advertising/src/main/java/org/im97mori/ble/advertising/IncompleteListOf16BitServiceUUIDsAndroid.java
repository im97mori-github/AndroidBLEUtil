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
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #IncompleteListOf16BitServiceUUIDsAndroid(byte[], int, int)
     */
    public IncompleteListOf16BitServiceUUIDsAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

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
     * Constructor for Incomplete List of 16-bit Service Class UUIDs
     *
     * @param uuids UUID array
     * @see IncompleteListOf16BitServiceUUIDsAndroid#IncompleteListOf16BitServiceUUIDsAndroid(List)
     */
    public IncompleteListOf16BitServiceUUIDsAndroid(@NonNull UUID... uuids) {
        this(Arrays.asList(uuids));
    }

    /**
     * Constructor for Complete List of 16-bit Service Class UUIDs
     *
     * @param uuidList UUID list
     */
    public IncompleteListOf16BitServiceUUIDsAndroid(@NonNull List<UUID> uuidList) {
        super(uuidList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IncompleteListOf16BitServiceUUIDsAndroid(@NonNull Parcel in) {
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
