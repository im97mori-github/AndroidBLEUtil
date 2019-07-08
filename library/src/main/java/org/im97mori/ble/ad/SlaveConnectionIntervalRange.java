package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.SLAVE_CONNECTION_INTERVAL_NO_SPECIFIC_VALUE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS;

/**
 * <p>
 * Slave Connection Interval Range
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class SlaveConnectionIntervalRange extends AbstractAdvertisingData {

    /**
     * <p>
     * Minimum connection interval
     * <p>
     * Core Specification v5.1 Vol 3 Part C 12.3
     * </p>
     */
    private final int mMinimumValue;

    /**
     * <p>
     * Maximum connection interval
     * <p>
     * Core Specification v5.1 Vol 3 Part C 12.3
     * </p>
     */
    private final int mMaximumValue;

    /**
     * Constructor for Slave Connection Interval Range
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    SlaveConnectionIntervalRange(byte[] data, int offset, int length) {
        super(length);

        ByteBuffer bb = ByteBuffer.wrap(data, offset + 2, length - 1).order(ByteOrder.LITTLE_ENDIAN);
        mMinimumValue = bb.getShort() & 0xffff;
        mMaximumValue = bb.getShort() & 0xffff;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
    }

    /**
     * check Minimum connection interval is presented
     *
     * @return {@code true}:presented, [@code false}:not presented
     */
    public boolean hasMinimum() {
        return mMinimumValue != SLAVE_CONNECTION_INTERVAL_NO_SPECIFIC_VALUE;
    }

    /**
     * check Maximum connection interval is presented
     *
     * @return {@code true}:presented, [@code false}:not presented
     */
    public boolean hasMaximum() {
        return mMaximumValue != SLAVE_CONNECTION_INTERVAL_NO_SPECIFIC_VALUE;
    }

    /**
     * if {@link #hasMinimum()} return true, return Minimum connection interval
     *
     * @return Minimum connection interval(millis)
     */
    public double getMinimumValueMillis() {
        return mMinimumValue * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS;
    }

    /**
     * if {@link #hasMaximum()} return true, return Maximum connection interval
     *
     * @return Maximum connection interval(millis)
     */
    public double getMaximuValueMillis() {
        return mMaximumValue * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS;
    }
}
