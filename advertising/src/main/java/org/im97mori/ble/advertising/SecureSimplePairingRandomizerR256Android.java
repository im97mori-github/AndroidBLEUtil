package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Secure Simple Pairing Randomizer R-256
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class SecureSimplePairingRandomizerR256Android extends SecureSimplePairingRandomizerR256 implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SecureSimplePairingRandomizerR256Android> CREATOR = new ByteArrayCreator<SecureSimplePairingRandomizerR256Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecureSimplePairingRandomizerR256Android createFromParcel(@NonNull Parcel in) {
            return new SecureSimplePairingRandomizerR256Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecureSimplePairingRandomizerR256Android[] newArray(int size) {
            return new SecureSimplePairingRandomizerR256Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public SecureSimplePairingRandomizerR256Android createFromByteArray(@NonNull byte[] values) {
            return new SecureSimplePairingRandomizerR256Android(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #SecureSimplePairingRandomizerR256Android(byte[], int, int)
     */
    public SecureSimplePairingRandomizerR256Android(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public SecureSimplePairingRandomizerR256Android(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param secureSimplePairingRandomizerR256 Secure Simple Pairing Randomizer R-256
     */
    public SecureSimplePairingRandomizerR256Android(@NonNull byte[] secureSimplePairingRandomizerR256) {
        super(secureSimplePairingRandomizerR256);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SecureSimplePairingRandomizerR256Android(@NonNull Parcel in) {
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
