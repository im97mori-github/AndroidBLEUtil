package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Appearance
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class AppearanceAndroid extends Appearance implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AppearanceAndroid> CREATOR = new ByteArrayCreator<AppearanceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AppearanceAndroid createFromParcel(@NonNull Parcel in) {
            return new AppearanceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AppearanceAndroid[] newArray(int size) {
            return new AppearanceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public AppearanceAndroid createFromByteArray(@NonNull byte[] values) {
            return new AppearanceAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #AppearanceAndroid(byte[], int, int)
     */
    public AppearanceAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Appearance
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public AppearanceAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param appearance Appearance
     */
    public AppearanceAndroid(int appearance) {
        super(appearance);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AppearanceAndroid(@NonNull Parcel in) {
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(getBytes());
        dest.writeInt(getLength());
    }

}
