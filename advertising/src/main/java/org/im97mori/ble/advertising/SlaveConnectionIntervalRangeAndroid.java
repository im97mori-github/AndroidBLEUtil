package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Slave Connection Interval Range
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class SlaveConnectionIntervalRangeAndroid extends SlaveConnectionIntervalRange implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SlaveConnectionIntervalRangeAndroid> CREATOR = new ByteArrayCreater<SlaveConnectionIntervalRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SlaveConnectionIntervalRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SlaveConnectionIntervalRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SlaveConnectionIntervalRangeAndroid[] newArray(int size) {
            return new SlaveConnectionIntervalRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public SlaveConnectionIntervalRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new SlaveConnectionIntervalRangeAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Slave Connection Interval Range
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public SlaveConnectionIntervalRangeAndroid(@NonNull byte[] data
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
    private SlaveConnectionIntervalRangeAndroid(@NonNull Parcel in) {
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
