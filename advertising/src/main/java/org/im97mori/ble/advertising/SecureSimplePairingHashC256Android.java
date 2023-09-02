package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Secure Simple Pairing Hash C-256
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class SecureSimplePairingHashC256Android extends SecureSimplePairingHashC256 implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SecureSimplePairingHashC256Android> CREATOR = new ByteArrayCreator<SecureSimplePairingHashC256Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecureSimplePairingHashC256Android createFromParcel(@NonNull Parcel in) {
            return new SecureSimplePairingHashC256Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecureSimplePairingHashC256Android[] newArray(int size) {
            return new SecureSimplePairingHashC256Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public SecureSimplePairingHashC256Android createFromByteArray(@NonNull byte[] values) {
            return new SecureSimplePairingHashC256Android(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #SecureSimplePairingHashC256Android(byte[], int, int)
     */
    public SecureSimplePairingHashC256Android(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public SecureSimplePairingHashC256Android(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param secureSimplePairingHashC256 Secure Simple Pairing Hash C-256
     */
    public SecureSimplePairingHashC256Android(@NonNull byte[] secureSimplePairingHashC256) {
        super(secureSimplePairingHashC256);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SecureSimplePairingHashC256Android(@NonNull Parcel in) {
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
