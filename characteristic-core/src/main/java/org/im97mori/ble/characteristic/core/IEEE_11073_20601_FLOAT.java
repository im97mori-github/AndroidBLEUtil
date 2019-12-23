package org.im97mori.ble.characteristic.core;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;

import java.util.Arrays;

/**
 * 16-BIT FLOATING POINT DATA TYPE (FLOAT-TYPE) (Personal Health Devices Transcoding 2.2.2)
 */
@SuppressWarnings("unused")
public class IEEE_11073_20601_FLOAT {

    /**
     * SFLOAT byte array
     */
    private final byte[] mData;

    /**
     * SFLOAT (IEEE 754 format)
     */
    private final double mSfloat;

    /**
     * Constructor from byte array
     *
     * @param data   SFLOAT byte array
     * @param offset data offset
     */
    public IEEE_11073_20601_FLOAT(@NonNull byte[] data, int offset) {
        mData = Arrays.copyOfRange(data, offset, offset + 2);
        mSfloat = BLEUtils.createSfloat(data, offset);
    }

    /**
     * @return SFLOAT byte array
     */
    public byte[] getData() {
        return mData;
    }

    /**
     * @return SFLOAT
     */
    public double getSfloat() {
        return mSfloat;
    }

}
