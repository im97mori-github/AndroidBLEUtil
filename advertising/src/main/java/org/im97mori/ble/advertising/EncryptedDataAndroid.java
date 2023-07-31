package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Encrypted Data
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class EncryptedDataAndroid extends EncryptedData implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EncryptedDataAndroid> CREATOR = new ByteArrayCreator<EncryptedDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EncryptedDataAndroid createFromParcel(@NonNull Parcel in) {
            return new EncryptedDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EncryptedDataAndroid[] newArray(int size) {
            return new EncryptedDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public EncryptedDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new EncryptedDataAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #EncryptedDataAndroid(byte[], int, int)
     */
    public EncryptedDataAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Encrypted Data
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public EncryptedDataAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param randomizer Randomizer
     * @param payload    Payload
     * @param mic        MIC
     */
    public EncryptedDataAndroid(@NonNull byte[] randomizer, @NonNull byte[] payload, @NonNull byte[] mic) {
        super(randomizer, payload, mic);

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EncryptedDataAndroid(@NonNull Parcel in) {
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
