package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * LE Secure Connections Random Value
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class LeSecureConnectionsRandomValueAndroid extends LeSecureConnectionsRandomValue implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LeSecureConnectionsRandomValueAndroid> CREATOR = new ByteArrayCreator<LeSecureConnectionsRandomValueAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeSecureConnectionsRandomValueAndroid createFromParcel(@NonNull Parcel in) {
            return new LeSecureConnectionsRandomValueAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeSecureConnectionsRandomValueAndroid[] newArray(int size) {
            return new LeSecureConnectionsRandomValueAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public LeSecureConnectionsRandomValueAndroid createFromByteArray(@NonNull byte[] values) {
            return new LeSecureConnectionsRandomValueAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #LeSecureConnectionsRandomValueAndroid(byte[], int, int)
     */
    public LeSecureConnectionsRandomValueAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public LeSecureConnectionsRandomValueAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param leSecureConnectionsRandomValue LE Secure Connections Random Value
     */
    public LeSecureConnectionsRandomValueAndroid(@NonNull byte[] leSecureConnectionsRandomValue) {
        super(leSecureConnectionsRandomValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LeSecureConnectionsRandomValueAndroid(@NonNull Parcel in) {
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
