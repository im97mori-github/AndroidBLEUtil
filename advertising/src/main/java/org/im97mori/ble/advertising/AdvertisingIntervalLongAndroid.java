package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Advertising Interval - long
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class AdvertisingIntervalLongAndroid extends AdvertisingIntervalLong implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AdvertisingIntervalLongAndroid> CREATOR = new ByteArrayCreator<AdvertisingIntervalLongAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingIntervalLongAndroid createFromParcel(@NonNull Parcel in) {
            return new AdvertisingIntervalLongAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingIntervalLongAndroid[] newArray(int size) {
            return new AdvertisingIntervalLongAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public AdvertisingIntervalLongAndroid createFromByteArray(@NonNull byte[] values) {
            return new AdvertisingIntervalLongAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #AdvertisingIntervalLongAndroid(byte[], int, int)
     */
    public AdvertisingIntervalLongAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Advertising Interval
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public AdvertisingIntervalLongAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param isUInt32                {@code true}:4 octets, {@code false}:3 octets
     * @param advertisingIntervalLong Advertising Interval - long
     */
    public AdvertisingIntervalLongAndroid(boolean isUInt32, long advertisingIntervalLong) {
        super(isUInt32, advertisingIntervalLong);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingIntervalLongAndroid(@NonNull Parcel in) {
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
