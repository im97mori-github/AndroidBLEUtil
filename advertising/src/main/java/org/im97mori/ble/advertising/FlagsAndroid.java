package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.List;

/**
 * <p>
 * Flags
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class FlagsAndroid extends Flags implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FlagsAndroid> CREATOR = new ByteArrayCreator<FlagsAndroid>() {

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
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #FlagsAndroid(byte[], int, int)
     */
    public FlagsAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Flags
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public FlagsAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param flagsList Flags list
     */
    public FlagsAndroid(@NonNull List<Integer> flagsList) {
        super(flagsList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FlagsAndroid(@NonNull Parcel in) {
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
