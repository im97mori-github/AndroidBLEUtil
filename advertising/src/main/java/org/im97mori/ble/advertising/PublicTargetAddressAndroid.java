package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.util.List;

/**
 * <p>
 * Public Target Address
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class PublicTargetAddressAndroid extends PublicTargetAddress implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PublicTargetAddressAndroid> CREATOR = new ByteArrayCreater<PublicTargetAddressAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PublicTargetAddressAndroid createFromParcel(@NonNull Parcel in) {
            return new PublicTargetAddressAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PublicTargetAddressAndroid[] newArray(int size) {
            return new PublicTargetAddressAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public PublicTargetAddressAndroid createFromByteArray(@NonNull byte[] values) {
            return new PublicTargetAddressAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #PublicTargetAddressAndroid(byte[], int, int)
     */
    public PublicTargetAddressAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public PublicTargetAddressAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param addressList Public Target Address list
     */
    public PublicTargetAddressAndroid(@NonNull List<byte[]> addressList) {
        super(addressList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PublicTargetAddressAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray(), 0, in.readInt());
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
