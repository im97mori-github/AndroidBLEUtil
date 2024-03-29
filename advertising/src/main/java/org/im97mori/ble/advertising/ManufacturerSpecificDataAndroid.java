package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Manufacturer Specific Data
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class ManufacturerSpecificDataAndroid extends ManufacturerSpecificData implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ManufacturerSpecificDataAndroid> CREATOR = new ByteArrayCreator<ManufacturerSpecificDataAndroid>() {

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
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #ManufacturerSpecificDataAndroid(byte[], int, int)
     */
    public ManufacturerSpecificDataAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Manufacturer Specific Data
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public ManufacturerSpecificDataAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param companyIdentifier        Company Identifier Code
     * @param manufacturerSpecificData byte array of Manufacturer Specific Data
     */
    public ManufacturerSpecificDataAndroid(int companyIdentifier, @NonNull byte[] manufacturerSpecificData) {
        super(companyIdentifier, manufacturerSpecificData);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ManufacturerSpecificDataAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()), 0, in.readInt());
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
