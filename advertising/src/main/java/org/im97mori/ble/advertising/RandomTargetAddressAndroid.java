package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.util.List;

/**
 * <p>
 * Random Target Address
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class RandomTargetAddressAndroid extends RandomTargetAddress implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RandomTargetAddressAndroid> CREATOR = new ByteArrayCreater<RandomTargetAddressAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RandomTargetAddressAndroid createFromParcel(@NonNull Parcel in) {
            return new RandomTargetAddressAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RandomTargetAddressAndroid[] newArray(int size) {
            return new RandomTargetAddressAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public RandomTargetAddressAndroid createFromByteArray(@NonNull byte[] values) {
            return new RandomTargetAddressAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #RandomTargetAddressAndroid(byte[], int, int)
     */
    public RandomTargetAddressAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Random Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public RandomTargetAddressAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }
    /**
     * Constructor from parameters
     *
     * @param addressList Random Target Address list
     */
    public RandomTargetAddressAndroid(@NonNull List<byte[]> addressList) {
        super(addressList);
    }


    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RandomTargetAddressAndroid(@NonNull Parcel in) {
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
