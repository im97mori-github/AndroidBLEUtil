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
 * Incomplete List of 128-bit Service Class UUIDs
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class IncompleteListOf128BitServiceUUIDsAndroid extends IncompleteListOf128BitServiceUUIDs implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IncompleteListOf128BitServiceUUIDsAndroid> CREATOR = new ByteArrayCreator<IncompleteListOf128BitServiceUUIDsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncompleteListOf128BitServiceUUIDsAndroid createFromParcel(@NonNull Parcel in) {
            return new IncompleteListOf128BitServiceUUIDsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncompleteListOf128BitServiceUUIDsAndroid[] newArray(int size) {
            return new IncompleteListOf128BitServiceUUIDsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IncompleteListOf128BitServiceUUIDsAndroid createFromByteArray(@NonNull byte[] values) {
            return new IncompleteListOf128BitServiceUUIDsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #IncompleteListOf128BitServiceUUIDsAndroid(byte[], int, int)
     */
    public IncompleteListOf128BitServiceUUIDsAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Incomplete List of 128-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public IncompleteListOf128BitServiceUUIDsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor for Incomplete List of 128-bit Service Class UUIDs
     *
     * @param uuids UUID array
     * @see IncompleteListOf128BitServiceUUIDsAndroid#IncompleteListOf128BitServiceUUIDsAndroid(List)
     */
    public IncompleteListOf128BitServiceUUIDsAndroid(@NonNull UUID... uuids) {
        this(Arrays.asList(uuids));
    }

    /**
     * Constructor for Incomplete List of 128-bit Service Class UUIDs
     *
     * @param uuidList UUID list
     */
    public IncompleteListOf128BitServiceUUIDsAndroid(@NonNull List<UUID> uuidList) {
        super(uuidList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IncompleteListOf128BitServiceUUIDsAndroid(Parcel in) {
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
