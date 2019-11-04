package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LOCAL_NAME;

/**
 * <p>
 * Complete Local Name
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class CompleteLocalName extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CompleteLocalName> CREATOR = new ByteArrayCreater<CompleteLocalName>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CompleteLocalName createFromParcel(@NonNull Parcel in) {
            return new CompleteLocalName(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CompleteLocalName[] newArray(int size) {
            return new CompleteLocalName[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public CompleteLocalName createFromByteArray(@NonNull byte[] values) {
            return new CompleteLocalName(values, 0, values.length - 1);
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
    public CompleteLocalName(@NonNull byte[] data
            , int offset
            , int length) {
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
    public void writeToParcel(@NonNull Parcel dest, int flags) {
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
    @NonNull
    public String getCompleteLocalName() {
        return mCompleteLocalName;
    }

}
