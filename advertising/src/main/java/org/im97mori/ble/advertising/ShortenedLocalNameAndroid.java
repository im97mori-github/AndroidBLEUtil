package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Shortened Local Name
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ShortenedLocalNameAndroid extends ShortenedLocalName implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ShortenedLocalNameAndroid> CREATOR = new ByteArrayCreater<ShortenedLocalNameAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ShortenedLocalNameAndroid createFromParcel(@NonNull Parcel in) {
            return new ShortenedLocalNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ShortenedLocalNameAndroid[] newArray(int size) {
            return new ShortenedLocalNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ShortenedLocalNameAndroid createFromByteArray(@NonNull byte[] values) {
            return new ShortenedLocalNameAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Shortened Local Name
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ShortenedLocalNameAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ShortenedLocalNameAndroid(@NonNull Parcel in) {
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
