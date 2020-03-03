package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * URI
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class UniformRsourceIdentifierAndroid extends UniformRsourceIdentifier implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UniformRsourceIdentifierAndroid> CREATOR = new ByteArrayCreater<UniformRsourceIdentifierAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UniformRsourceIdentifierAndroid createFromParcel(@NonNull Parcel in) {
            return new UniformRsourceIdentifierAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UniformRsourceIdentifierAndroid[] newArray(int size) {
            return new UniformRsourceIdentifierAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public UniformRsourceIdentifierAndroid createFromByteArray(@NonNull byte[] values) {
            return new UniformRsourceIdentifierAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for URI
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public UniformRsourceIdentifierAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private UniformRsourceIdentifierAndroid(@NonNull Parcel in) {
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
