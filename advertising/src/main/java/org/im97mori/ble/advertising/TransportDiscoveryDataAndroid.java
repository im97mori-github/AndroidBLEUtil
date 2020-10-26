package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Transport Discovery Data
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class TransportDiscoveryDataAndroid extends TransportDiscoveryData implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TransportDiscoveryDataAndroid> CREATOR = new ByteArrayCreater<TransportDiscoveryDataAndroid>() {

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
     * Constructor for Advertising Interval
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public TransportDiscoveryDataAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TransportDiscoveryDataAndroid(@NonNull Parcel in) {
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
