package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;
import android.os.Parcelable;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.ad.AdvertisingDataConstants.ADVERTISING_INTERVAL_UNIT_MILLIS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_ADVERTISING_INTERVAL;

/**
 * <p>
 * Advertising Interval
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class AdvertisingInterval extends AbstractAdvertisingData implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<AdvertisingInterval> CREATOR = new Creator<AdvertisingInterval>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public AdvertisingInterval createFromParcel(Parcel in) {
            return new AdvertisingInterval(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public AdvertisingInterval[] newArray(int size) {
            return new AdvertisingInterval[size];
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
    public AdvertisingInterval(byte[] data, int offset, int length) {
        super(length);

        ByteBuffer bb = ByteBuffer.wrap(data, offset + 2, length - 1).order(ByteOrder.LITTLE_ENDIAN);
        mAdvertisingInterval = bb.getShort() & 0xffff;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingInterval(Parcel in) {
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
    public void writeToParcel(Parcel dest, int flags) {
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
