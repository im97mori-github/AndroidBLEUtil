package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * BIGInfo
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class BigInfoAndroid extends BigInfo implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BigInfoAndroid> CREATOR = new ByteArrayCreater<BigInfoAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BigInfoAndroid createFromParcel(@NonNull Parcel in) {
            return new BigInfoAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BigInfoAndroid[] newArray(int size) {
            return new BigInfoAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BigInfoAndroid createFromByteArray(@NonNull byte[] values) {
            return new BigInfoAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for BIGInfo
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public BigInfoAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BigInfoAndroid(@NonNull Parcel in) {
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
