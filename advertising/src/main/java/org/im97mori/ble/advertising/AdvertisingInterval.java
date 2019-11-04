package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.ADVERTISING_INTERVAL_UNIT_MILLIS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_ADVERTISING_INTERVAL;

/**
 * <p>
 * Advertising Interval
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class AdvertisingInterval extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AdvertisingInterval> CREATOR = new ByteArrayCreater<AdvertisingInterval>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingInterval createFromParcel(@NonNull Parcel in) {
            return new AdvertisingInterval(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingInterval[] newArray(int size) {
            return new AdvertisingInterval[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public AdvertisingInterval createFromByteArray(@NonNull byte[] values) {
            return new AdvertisingInterval(values, 0, values.length - 1);
        }

    };

    /**
     * Advertising Interval
     */
    private final int mAdvertisingInterval;

    /**
     * Constructor for Advertising Interval
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public AdvertisingInterval(@NonNull byte[] data
            , int offset
            , int length) {
        super(length);

        ByteBuffer bb = ByteBuffer.wrap(data, offset + 2, length - 1).order(ByteOrder.LITTLE_ENDIAN);
        mAdvertisingInterval = bb.getShort() & 0xffff;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingInterval(@NonNull Parcel in) {
        super(in.readInt());
        mAdvertisingInterval = in.readInt();
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
        dest.writeInt(mAdvertisingInterval);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_ADVERTISING_INTERVAL;
    }

    /**
     * @return Advertising Interval
     */
    public int getAdvertisingInterval() {
        return mAdvertisingInterval;
    }

    /**
     * @return Advertising Interval(millis)
     */
    public double getAdvertisingIntervalMillis() {
        return mAdvertisingInterval * ADVERTISING_INTERVAL_UNIT_MILLIS;
    }

}
