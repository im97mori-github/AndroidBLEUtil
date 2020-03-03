package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Indoor Positioning
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings({"unused"})
public class IndoorPositioningAndroid extends IndoorPositioning implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IndoorPositioningAndroid> CREATOR = new ByteArrayCreater<IndoorPositioningAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningAndroid createFromParcel(@NonNull Parcel in) {
            return new IndoorPositioningAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningAndroid[] newArray(int size) {
            return new IndoorPositioningAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IndoorPositioningAndroid createFromByteArray(@NonNull byte[] values) {
            return new IndoorPositioningAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Indoor Positioning
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public IndoorPositioningAndroid(@NonNull byte[] data
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
    private IndoorPositioningAndroid(@NonNull Parcel in) {
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
