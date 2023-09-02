package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * LE Role
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class LeRoleAndroid extends LeRole implements AdvertisingDataInterfaceAndroid {


    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LeRoleAndroid> CREATOR = new ByteArrayCreator<LeRoleAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeRoleAndroid createFromParcel(@NonNull Parcel in) {
            return new LeRoleAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeRoleAndroid[] newArray(int size) {
            return new LeRoleAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public LeRoleAndroid createFromByteArray(@NonNull byte[] values) {
            return new LeRoleAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #LeRoleAndroid(byte[], int, int)
     */
    public LeRoleAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Flags
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public LeRoleAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param leRole LE Role
     */
    public LeRoleAndroid(int leRole) {
        super(leRole);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LeRoleAndroid(@NonNull Parcel in) {
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
