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
 * Complete List of 32-bit Service Class UUIDs
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class CompleteListOf32BitServiceUUIDsAndroid extends CompleteListOf32BitServiceUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CompleteListOf32BitServiceUUIDsAndroid> CREATOR = new ByteArrayCreator<CompleteListOf32BitServiceUUIDsAndroid>() {

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
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #CompleteListOf32BitServiceUUIDsAndroid(byte[], int, int)
     */
    public CompleteListOf32BitServiceUUIDsAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Complete List of 32-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public CompleteListOf32BitServiceUUIDsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor for Complete List of 32-bit Service Class UUIDs
     *
     * @param uuids UUID array
     * @see CompleteListOf32BitServiceUUIDsAndroid#CompleteListOf32BitServiceUUIDsAndroid(List)
     */
    public CompleteListOf32BitServiceUUIDsAndroid(@NonNull UUID... uuids) {
        this(Arrays.asList(uuids));
    }

    /**
     * Constructor for Complete List of 32-bit Service Class UUIDs
     *
     * @param uuidList UUID list
     */
    public CompleteListOf32BitServiceUUIDsAndroid(@NonNull List<UUID> uuidList) {
        super(uuidList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CompleteListOf32BitServiceUUIDsAndroid(Parcel in) {
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
