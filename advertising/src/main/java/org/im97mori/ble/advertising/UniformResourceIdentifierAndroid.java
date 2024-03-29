package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * URI
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class UniformResourceIdentifierAndroid extends UniformResourceIdentifier implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<UniformResourceIdentifierAndroid> CREATOR = new ByteArrayCreator<UniformResourceIdentifierAndroid>() {

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
     * @param length 1st octet of Advertising Data
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
