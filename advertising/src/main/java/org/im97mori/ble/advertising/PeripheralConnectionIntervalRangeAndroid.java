package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * <p>
 * Peripheral Connection Interval Range(Slave Connection Interval Range)
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class PeripheralConnectionIntervalRangeAndroid extends PeripheralConnectionIntervalRange implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PeripheralConnectionIntervalRangeAndroid> CREATOR = new ByteArrayCreater<PeripheralConnectionIntervalRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralConnectionIntervalRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new PeripheralConnectionIntervalRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralConnectionIntervalRangeAndroid[] newArray(int size) {
            return new PeripheralConnectionIntervalRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public PeripheralConnectionIntervalRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new PeripheralConnectionIntervalRangeAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * Constructor for Slave Connection Interval Range
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public PeripheralConnectionIntervalRangeAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PeripheralConnectionIntervalRangeAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
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