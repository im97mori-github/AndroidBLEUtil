package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * Incomplete List of 32-bit Service Class UUIDs
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class IncompleteListOf32BitServiceUUIDsAndroid extends IncompleteListOf32BitServiceUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IncompleteListOf32BitServiceUUIDsAndroid> CREATOR = new ByteArrayCreator<IncompleteListOf32BitServiceUUIDsAndroid>() {

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
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #IncompleteListOf32BitServiceUUIDsAndroid(byte[], int, int)
     */
    public IncompleteListOf32BitServiceUUIDsAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Incomplete List of 32-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public IncompleteListOf32BitServiceUUIDsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor for Incomplete List of 32-bit Service Class UUIDs
     *
     * @param uuids UUID array
     * @see IncompleteListOf32BitServiceUUIDsAndroid#IncompleteListOf32BitServiceUUIDsAndroid(List)
     */
    public IncompleteListOf32BitServiceUUIDsAndroid(@NonNull UUID... uuids) {
        this(Arrays.asList(uuids));
    }

    /**
     * Constructor for Incomplete List of 32-bit Service Class UUIDs
     *
     * @param uuidList UUID list
     */
    public IncompleteListOf32BitServiceUUIDsAndroid(@NonNull List<UUID> uuidList) {
        super(uuidList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IncompleteListOf32BitServiceUUIDsAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()), 0, in.readInt());
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
