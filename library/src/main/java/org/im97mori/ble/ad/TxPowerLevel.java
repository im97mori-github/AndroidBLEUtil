package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

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
    TxPowerLevel(byte[] data, int offset, int length) {
        super(length);

        mTxPowerLevel = data[offset + 2];
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
