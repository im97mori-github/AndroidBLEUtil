package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Flags
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class FlagsAndroid extends Flags implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FlagsAndroid> CREATOR = new ByteArrayCreater<FlagsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FlagsAndroid createFromParcel(@NonNull Parcel in) {
            return new FlagsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FlagsAndroid[] newArray(int size) {
            return new FlagsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public FlagsAndroid createFromByteArray(@NonNull byte[] values) {
            return new FlagsAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Flags
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public FlagsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private FlagsAndroid(@NonNull Parcel in) {
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
