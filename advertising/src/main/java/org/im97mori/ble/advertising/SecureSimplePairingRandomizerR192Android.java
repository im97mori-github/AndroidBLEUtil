package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Secure Simple Pairing Randomizer R-192
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class SecureSimplePairingRandomizerR192Android extends SecureSimplePairingRandomizerR192 implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SecureSimplePairingRandomizerR192Android> CREATOR = new ByteArrayCreator<SecureSimplePairingRandomizerR192Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecureSimplePairingRandomizerR192Android createFromParcel(@NonNull Parcel in) {
            return new SecureSimplePairingRandomizerR192Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SecureSimplePairingRandomizerR192Android[] newArray(int size) {
            return new SecureSimplePairingRandomizerR192Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public SecureSimplePairingRandomizerR192Android createFromByteArray(@NonNull byte[] values) {
            return new SecureSimplePairingRandomizerR192Android(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #SecureSimplePairingRandomizerR192Android(byte[], int, int)
     */
    public SecureSimplePairingRandomizerR192Android(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public SecureSimplePairingRandomizerR192Android(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param secureSimplePairingRandomizerR192 Secure Simple Pairing Randomizer R-192
     */
    public SecureSimplePairingRandomizerR192Android(@NonNull byte[] secureSimplePairingRandomizerR192) {
        super(secureSimplePairingRandomizerR192);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SecureSimplePairingRandomizerR192Android(@NonNull Parcel in) {
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
