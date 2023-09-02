package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Security Manager Out of Band
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class SecurityManagerOutOfBandAndroid extends SecurityManagerOutOfBand implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SecurityManagerOutOfBandAndroid> CREATOR = new ByteArrayCreator<SecurityManagerOutOfBandAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecurityManagerOutOfBandAndroid createFromParcel(@NonNull Parcel in) {
            return new SecurityManagerOutOfBandAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecurityManagerOutOfBandAndroid[] newArray(int size) {
            return new SecurityManagerOutOfBandAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public SecurityManagerOutOfBandAndroid createFromByteArray(@NonNull byte[] values) {
            return new SecurityManagerOutOfBandAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #SecurityManagerOutOfBandAndroid(byte[], int, int)
     */
    public SecurityManagerOutOfBandAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Tx Power Level
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public SecurityManagerOutOfBandAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param securityManagerOutOfBandFlag Security Manager Out of Band Flag
     */
    public SecurityManagerOutOfBandAndroid(byte securityManagerOutOfBandFlag) {
        super(securityManagerOutOfBandFlag);

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SecurityManagerOutOfBandAndroid(@NonNull Parcel in) {
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
