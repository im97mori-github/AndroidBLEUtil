package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LOCAL_NAME;

/**
 * <p>
 * Complete Local Name
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class CompleteLocalName extends AbstractAdvertisingData {

    /**
     * @see Creator
     */
    public static final Creator<CompleteLocalName> CREATOR = new Creator<CompleteLocalName>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CompleteLocalName createFromParcel(Parcel in) {
            return new CompleteLocalName(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CompleteLocalName[] newArray(int size) {
            return new CompleteLocalName[size];
        }

    };

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
    public CompleteLocalName(byte[] data, int offset, int length) {
        super(length);
        mCompleteLocalName = new String(data, offset + 2, length - 1);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CompleteLocalName(Parcel in) {
        super(in.readInt());
        mCompleteLocalName = in.readString();
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
        dest.writeString(mCompleteLocalName);
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
