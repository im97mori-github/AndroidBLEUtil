package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LOCAL_NAME;

/**
 * <p>
 * Complete Local Name
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class CompleteLocalName extends AbstractAdvertisingData {

    /**
     * Complete Local Name
     */
    private final String mCompleteLocalName;

    /**
     * Constructor for Complete Local Name
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    CompleteLocalName(byte[] data, int offset, int length) {
        super(length);
        mCompleteLocalName = new String(data, offset + 2, length - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_COMPLETE_LOCAL_NAME;
    }

    /**
     * @return Complete Local Name
     */
    public String getCompleteLocalName() {
        return mCompleteLocalName;
    }

}
