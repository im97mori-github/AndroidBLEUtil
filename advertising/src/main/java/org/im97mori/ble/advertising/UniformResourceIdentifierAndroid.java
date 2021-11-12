package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * URI
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class UniformResourceIdentifierAndroid extends UniformResourceIdentifier implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UniformResourceIdentifierAndroid> CREATOR = new ByteArrayCreater<UniformResourceIdentifierAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UniformResourceIdentifierAndroid createFromParcel(@NonNull Parcel in) {
            return new UniformResourceIdentifierAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UniformResourceIdentifierAndroid[] newArray(int size) {
            return new UniformResourceIdentifierAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public UniformResourceIdentifierAndroid createFromByteArray(@NonNull byte[] values) {
            return new UniformResourceIdentifierAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #UniformResourceIdentifierAndroid(byte[], int, int)
     */
    public UniformResourceIdentifierAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for URI
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public UniformResourceIdentifierAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param scheme    Scheme
     * @param uriString URI text
     */
    public UniformResourceIdentifierAndroid(char scheme, @NonNull String uriString) {
        super(scheme, uriString);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UniformResourceIdentifierAndroid(@NonNull Parcel in) {
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
