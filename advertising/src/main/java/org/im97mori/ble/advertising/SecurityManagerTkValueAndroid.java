package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Security Manager TK Value
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class SecurityManagerTkValueAndroid extends SecurityManagerTkValue implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SecurityManagerTkValueAndroid> CREATOR = new ByteArrayCreator<SecurityManagerTkValueAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecurityManagerTkValueAndroid createFromParcel(@NonNull Parcel in) {
            return new SecurityManagerTkValueAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecurityManagerTkValueAndroid[] newArray(int size) {
            return new SecurityManagerTkValueAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public SecurityManagerTkValueAndroid createFromByteArray(@NonNull byte[] values) {
            return new SecurityManagerTkValueAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #SecurityManagerTkValueAndroid(byte[], int, int)
     */
    public SecurityManagerTkValueAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Tx Power Level
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public SecurityManagerTkValueAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param securityManagerTkValue Security Manager TK Value
     */
    public SecurityManagerTkValueAndroid(@NonNull byte[] securityManagerTkValue) {
        super(securityManagerTkValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SecurityManagerTkValueAndroid(@NonNull Parcel in) {
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
