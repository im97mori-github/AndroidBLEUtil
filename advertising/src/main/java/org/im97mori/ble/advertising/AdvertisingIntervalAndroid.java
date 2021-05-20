package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Advertising Interval
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class AdvertisingIntervalAndroid extends AdvertisingInterval implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AdvertisingIntervalAndroid> CREATOR = new ByteArrayCreater<AdvertisingIntervalAndroid>() {

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
     * Constructor for Advertising Interval
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public AdvertisingIntervalAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingIntervalAndroid(@NonNull Parcel in) {
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
