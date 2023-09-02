package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * LE Secure Connections Confirmation Value
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class LeSecureConnectionsConfirmationValueAndroid extends LeSecureConnectionsConfirmationValue implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LeSecureConnectionsConfirmationValueAndroid> CREATOR = new ByteArrayCreator<LeSecureConnectionsConfirmationValueAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeSecureConnectionsConfirmationValueAndroid createFromParcel(@NonNull Parcel in) {
            return new LeSecureConnectionsConfirmationValueAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeSecureConnectionsConfirmationValueAndroid[] newArray(int size) {
            return new LeSecureConnectionsConfirmationValueAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public LeSecureConnectionsConfirmationValueAndroid createFromByteArray(@NonNull byte[] values) {
            return new LeSecureConnectionsConfirmationValueAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #LeSecureConnectionsConfirmationValueAndroid(byte[], int, int)
     */
    public LeSecureConnectionsConfirmationValueAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public LeSecureConnectionsConfirmationValueAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param leSecureConnectionsConfirmationValue LE Secure Connections Confirmation Value
     */
    public LeSecureConnectionsConfirmationValueAndroid(@NonNull byte[] leSecureConnectionsConfirmationValue) {
        super(leSecureConnectionsConfirmationValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LeSecureConnectionsConfirmationValueAndroid(@NonNull Parcel in) {
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
