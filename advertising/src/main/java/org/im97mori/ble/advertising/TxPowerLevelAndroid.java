package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Tx Power Level
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class TxPowerLevelAndroid extends TxPowerLevel implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TxPowerLevelAndroid> CREATOR = new ByteArrayCreator<TxPowerLevelAndroid>() {

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
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #TxPowerLevelAndroid(byte[], int, int)
     */
    public TxPowerLevelAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Tx Power Level
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public TxPowerLevelAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param txPowerLevel Tx Power Level
     */
    public TxPowerLevelAndroid(byte txPowerLevel) {
        super(txPowerLevel);

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TxPowerLevelAndroid(@NonNull Parcel in) {
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
