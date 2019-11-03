package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreater;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.APPEARANCE_DESCRIPTION_MAP;
import static org.im97mori.ble.BLEConstants.APPEARANCE_VALUE_MAP;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_APPEARANCE;

/**
 * <p>
 * Appearance
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class Appearance extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Appearance> CREATOR = new ByteArrayCreater<Appearance>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Appearance createFromParcel(@NonNull Parcel in) {
            return new Appearance(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Appearance[] newArray(int size) {
            return new Appearance[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public Appearance createFromByteArray(@NonNull byte[] values) {
            return new Appearance(values, 0, values.length - 1);
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
    public Appearance(@NonNull byte[] data
            , int offset
            , int length) {
        super(length);

        ByteBuffer bb = ByteBuffer.wrap(data, offset + 2, length - 1).order(ByteOrder.LITTLE_ENDIAN);
        mAppearanceKey = bb.getShort() & 0xffff;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Appearance(@NonNull Parcel in) {
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
    @Nullable
    public String getAppearanceValue() {
        return APPEARANCE_VALUE_MAP.get(mAppearanceKey);
    }

    /**
     * @return Appearance description
     */
    @Nullable
    public String getAppearanceDescription() {
        return APPEARANCE_DESCRIPTION_MAP.get(mAppearanceKey);
    }

}
