package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;
import android.os.Parcelable;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
import static org.im97mori.ble.ad.AdvertisingDataConstants.COMPANY_MAPPING;

/**
 * <p>
 * Manufacturer Specific Data
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class ManufacturerSpecificData extends AbstractAdvertisingData implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<ManufacturerSpecificData> CREATOR = new Creator<ManufacturerSpecificData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ManufacturerSpecificData createFromParcel(Parcel in) {
            return new ManufacturerSpecificData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ManufacturerSpecificData[] newArray(int size) {
            return new ManufacturerSpecificData[size];
        }

    };

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
    public ManufacturerSpecificData(byte[] data, int offset, int length) {
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
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public ManufacturerSpecificData(Parcel in) {
        super(in.readInt());
        mCompanyIdentifier = in.readInt();
        mManufacturerSpecificData = in.createByteArray();
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLength);
        dest.writeInt(mCompanyIdentifier);
        dest.writeByteArray(mManufacturerSpecificData);
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
