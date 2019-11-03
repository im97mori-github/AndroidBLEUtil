package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.COMPANY_MAPPING;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;

/**
 * <p>
 * Manufacturer Specific Data
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ManufacturerSpecificData extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ManufacturerSpecificData> CREATOR = new ByteArrayCreater<ManufacturerSpecificData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ManufacturerSpecificData createFromParcel(@NonNull Parcel in) {
            return new ManufacturerSpecificData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ManufacturerSpecificData[] newArray(int size) {
            return new ManufacturerSpecificData[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ManufacturerSpecificData createFromByteArray(@NonNull byte[] values) {
            return new ManufacturerSpecificData(values, 0, values.length - 1);
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
    public ManufacturerSpecificData(@NonNull byte[] data
            , int offset
            , int length) {
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
    private ManufacturerSpecificData(@NonNull Parcel in) {
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
    public void writeToParcel(@NonNull Parcel dest, int flags) {
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
    @Nullable
    public String getCompanyName() {
        return COMPANY_MAPPING.get(mCompanyIdentifier);
    }

    /**
     * @return byte array of Manufacturer Specific Data
     */
    @NonNull
    public byte[] getManufacturerSpecificData() {
        return mManufacturerSpecificData;
    }
}
