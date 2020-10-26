package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Manufacturer Specific Data
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ManufacturerSpecificDataAndroid extends ManufacturerSpecificData implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ManufacturerSpecificDataAndroid> CREATOR = new ByteArrayCreater<ManufacturerSpecificDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ManufacturerSpecificDataAndroid createFromParcel(@NonNull Parcel in) {
            return new ManufacturerSpecificDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ManufacturerSpecificDataAndroid[] newArray(int size) {
            return new ManufacturerSpecificDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ManufacturerSpecificDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new ManufacturerSpecificDataAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Manufacturer Specific Data
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ManufacturerSpecificDataAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ManufacturerSpecificDataAndroid(@NonNull Parcel in) {
        super(in.createByteArray(), 0, in.readInt());
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
        dest.writeByteArray(getBytes());
        dest.writeInt(getLength());
    }

}
