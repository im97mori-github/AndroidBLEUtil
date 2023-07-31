package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Advertising Interval
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class AdvertisingIntervalAndroid extends AdvertisingInterval implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AdvertisingIntervalAndroid> CREATOR = new ByteArrayCreator<AdvertisingIntervalAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingIntervalAndroid createFromParcel(@NonNull Parcel in) {
            return new AdvertisingIntervalAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingIntervalAndroid[] newArray(int size) {
            return new AdvertisingIntervalAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public AdvertisingIntervalAndroid createFromByteArray(@NonNull byte[] values) {
            return new AdvertisingIntervalAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #AdvertisingIntervalAndroid(byte[], int, int)
     */
    public AdvertisingIntervalAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Advertising Interval
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public AdvertisingIntervalAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param advertisingInterval Advertising Interval
     */
    public AdvertisingIntervalAndroid(int advertisingInterval) {
        super(advertisingInterval);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingIntervalAndroid(@NonNull Parcel in) {
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
