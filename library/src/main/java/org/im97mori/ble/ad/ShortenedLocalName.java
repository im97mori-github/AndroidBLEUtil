package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SHORTENED_LOCAL_NAME;

/**
 * <p>
 * Shortened Local Name
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class ShortenedLocalName extends AbstractAdvertisingData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<ShortenedLocalName> CREATOR = new Creator<ShortenedLocalName>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ShortenedLocalName createFromParcel(@NonNull Parcel in) {
            return new ShortenedLocalName(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ShortenedLocalName[] newArray(int size) {
            return new ShortenedLocalName[size];
        }

    };

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
    public ShortenedLocalName(@NonNull byte[] data, int offset, int length) {
        super(length);
        mShortenedLocalName = new String(data, offset + 2, length - 1);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ShortenedLocalName(@NonNull Parcel in) {
        super(in.readInt());
        mShortenedLocalName = in.readString();
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
        dest.writeString(mShortenedLocalName);
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
    @NonNull
    public String getShortenedLocalName() {
        return mShortenedLocalName;
    }

}
