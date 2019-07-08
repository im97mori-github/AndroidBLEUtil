package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SHORTENED_LOCAL_NAME;

/**
 * <p>
 * Shortened Local Name
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ShortenedLocalName extends AbstractAdvertisingData {

    /**
     * Shortened Local Name
     */
    private final String mShortenedLocalName;

    /**
     * Constructor for Shortened Local Name
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    ShortenedLocalName(byte[] data, int offset, int length) {
        super(length);
        mShortenedLocalName = new String(data, offset + 2, length - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_SHORTENED_LOCAL_NAME;
    }

    /**
     * @return Shortened Local Name
     */
    public String getShortenedLocalName() {
        return mShortenedLocalName;
    }

}
