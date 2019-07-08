package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
import static org.im97mori.ble.ad.AdvertisingDataConstants.COMPANY_MAPPING;

/**
 * <p>
 * Manufacturer Specific Data
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ManufacturerSpecificData extends AbstractAdvertisingData {

    /**
     * <p>
     * Company Identifier Code
     * <p>
     * https://www.bluetooth.com/specifications/assigned-numbers/company-identifiers/
     * </p>
     */
    private final int mCompanyIdentifier;

    /**
     * byte array of Manufacturer Specific Data
     */
    private final byte[] mManufacturerSpecificData;

    /**
     * Constructor for Manufacturer Specific Data
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    ManufacturerSpecificData(byte[] data, int offset, int length) {
        super(length);

        // Company Identifier Code
        mCompanyIdentifier = (data[offset + 2] & 0xff) | ((data[offset + 3] & 0xff) << 8);

        // Manufacturer Specific Data
        mManufacturerSpecificData = new byte[length - 3];
        if (mManufacturerSpecificData.length > 0) {
            System.arraycopy(data, offset + 4, mManufacturerSpecificData, 0, mManufacturerSpecificData.length);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
    }

    /**
     * @return Company Identifier Code
     */
    public int getCompanyIdentifier() {
        return mCompanyIdentifier;
    }

    /**
     * @return Company Name
     */
    public String getCompanyName() {
        return COMPANY_MAPPING.get(mCompanyIdentifier);
    }

    /**
     * @return byte array of Manufacturer Specific Data
     */
    public byte[] getManufacturerSpecificData() {
        return mManufacturerSpecificData;
    }
}
