package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.List;

/**
 * <p>
 * Transport Discovery Data
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class TransportDiscoveryDataAndroid extends TransportDiscoveryData implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TransportDiscoveryDataAndroid> CREATOR = new ByteArrayCreator<TransportDiscoveryDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TransportDiscoveryDataAndroid createFromParcel(@NonNull Parcel in) {
            return new TransportDiscoveryDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TransportDiscoveryDataAndroid[] newArray(int size) {
            return new TransportDiscoveryDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public TransportDiscoveryDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new TransportDiscoveryDataAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #TransportDiscoveryDataAndroid(byte[], int, int)
     */
    public TransportDiscoveryDataAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Advertising Interval
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public TransportDiscoveryDataAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param transportBlockList Transport Block List
     */
    public TransportDiscoveryDataAndroid(@NonNull List<TransportBlock> transportBlockList) {
        super(transportBlockList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TransportDiscoveryDataAndroid(@NonNull Parcel in) {
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
