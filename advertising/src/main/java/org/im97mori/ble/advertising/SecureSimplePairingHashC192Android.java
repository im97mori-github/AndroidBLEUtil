package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Secure Simple Pairing Hash C-192
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class SecureSimplePairingHashC192Android extends SecureSimplePairingHashC192 implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SecureSimplePairingHashC192Android> CREATOR = new ByteArrayCreator<SecureSimplePairingHashC192Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecureSimplePairingHashC192Android createFromParcel(@NonNull Parcel in) {
            return new SecureSimplePairingHashC192Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecureSimplePairingHashC192Android[] newArray(int size) {
            return new SecureSimplePairingHashC192Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public SecureSimplePairingHashC192Android createFromByteArray(@NonNull byte[] values) {
            return new SecureSimplePairingHashC192Android(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #SecureSimplePairingHashC192Android(byte[], int, int)
     */
    public SecureSimplePairingHashC192Android(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public SecureSimplePairingHashC192Android(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param secureSimplePairingHashC192 Secure Simple Pairing Hash C-192
     */
    public SecureSimplePairingHashC192Android(@NonNull byte[] secureSimplePairingHashC192) {
        super(secureSimplePairingHashC192);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SecureSimplePairingHashC192Android(@NonNull Parcel in) {
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
