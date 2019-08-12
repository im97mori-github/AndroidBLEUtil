package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.ad.AdvertisingDataConstants.APPEARANCE_DESCRIPTION_MAP;
import static org.im97mori.ble.ad.AdvertisingDataConstants.APPEARANCE_VALUE_MAP;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_APPEARANCE;

/**
 * <p>
 * Appearance
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class Appearance extends AbstractAdvertisingData {

    /**
     * @see Creator
     */
    public static final Creator<Appearance> CREATOR = new Creator<Appearance>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public Appearance createFromParcel(Parcel in) {
            return new Appearance(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Appearance[] newArray(int size) {
            return new Appearance[size];
        }

    };

    /**
     * Appearance key
     */
    private final int mAppearanceKey;

    /**
     * Constructor for Appearance
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public Appearance(byte[] data, int offset, int length) {
        super(length);

        ByteBuffer bb = ByteBuffer.wrap(data, offset + 2, length - 1).order(ByteOrder.LITTLE_ENDIAN);
        mAppearanceKey = bb.getShort() & 0xffff;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Appearance(Parcel in) {
        super(in.readInt());
        mAppearanceKey = in.readInt();
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
        dest.writeInt(mAppearanceKey);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_APPEARANCE;
    }

    /**
     * @return Appearance key
     */
    public int getAppearanceKey() {
        return mAppearanceKey;
    }

    /**
     * @return Appearance value
     */
    public String getAppearanceValue() {
        return APPEARANCE_VALUE_MAP.get(mAppearanceKey);
    }

    /**
     * @return Appearance description
     */
    public String getAppearanceDescription() {
        return APPEARANCE_DESCRIPTION_MAP.get(mAppearanceKey);
    }

}
