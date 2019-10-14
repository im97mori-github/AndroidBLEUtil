package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TX_POWER_LEVEL;

/**
 * <p>
 * Tx Power Level
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class TxPowerLevel extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TxPowerLevel> CREATOR = new ByteArrayCreater<TxPowerLevel>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerLevel createFromParcel(@NonNull Parcel in) {
            return new TxPowerLevel(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerLevel[] newArray(int size) {
            return new TxPowerLevel[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public TxPowerLevel createFromByteArray(@NonNull byte[] values) {
            return new TxPowerLevel(values, 0, values.length - 1);
        }

    };

    /**
     * Tx Power Level
     */
    private final byte mTxPowerLevel;

    /**
     * Constructor for Tx Power Level
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public TxPowerLevel(@NonNull byte[] data, int offset, int length) {
        super(length);

        mTxPowerLevel = data[offset + 2];
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TxPowerLevel(@NonNull Parcel in) {
        super(in.readInt());
        mTxPowerLevel = in.readByte();
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
        dest.writeInt(mLength);
        dest.writeByte(mTxPowerLevel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_TX_POWER_LEVEL;
    }

    /**
     * @return Tx Power Level
     */
    public byte getTxPowerLevel() {
        return mTxPowerLevel;
    }

}
