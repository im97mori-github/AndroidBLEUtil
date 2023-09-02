package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Broadcast_Code
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class BroadcastCodeAndroid extends BroadcastCode implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BroadcastCodeAndroid> CREATOR = new ByteArrayCreator<BroadcastCodeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BroadcastCodeAndroid createFromParcel(@NonNull Parcel in) {
            return new BroadcastCodeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BroadcastCodeAndroid[] newArray(int size) {
            return new BroadcastCodeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BroadcastCodeAndroid createFromByteArray(@NonNull byte[] values) {
            return new BroadcastCodeAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #BroadcastCodeAndroid(byte[], int, int)
     */
    public BroadcastCodeAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public BroadcastCodeAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param broadcastCode Broadcast_Code
     */
    public BroadcastCodeAndroid(@NonNull byte[] broadcastCode) {
        super(broadcastCode);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BroadcastCodeAndroid(@NonNull Parcel in) {
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
