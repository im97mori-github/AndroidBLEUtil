package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Tx Power Level
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class TxPowerLevelAndroid extends TxPowerLevel implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TxPowerLevelAndroid> CREATOR = new ByteArrayCreater<TxPowerLevelAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerLevelAndroid createFromParcel(@NonNull Parcel in) {
            return new TxPowerLevelAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerLevelAndroid[] newArray(int size) {
            return new TxPowerLevelAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public TxPowerLevelAndroid createFromByteArray(@NonNull byte[] values) {
            return new TxPowerLevelAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Tx Power Level
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public TxPowerLevelAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TxPowerLevelAndroid(@NonNull Parcel in) {
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
