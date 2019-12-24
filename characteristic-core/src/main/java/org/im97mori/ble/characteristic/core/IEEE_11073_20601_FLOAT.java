package org.im97mori.ble.characteristic.core;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;

import java.util.Arrays;

/**
 * 32-BIT FLOATING POINT DATA TYPE (FLOAT-TYPE) (Personal Health Devices Transcoding 2.2.1)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class IEEE_11073_20601_FLOAT {

    /**
     * SFLOAT byte array
     */
    private final byte[] mData;

    /**
     * FLOAT (IEEE 754 format)
     */
    private final double mFloat;

    /**
     * Constructor from byte array
     *
     * @param data   FLOAT byte array
     * @param offset data offset
     */
    public IEEE_11073_20601_FLOAT(@NonNull byte[] data, int offset) {
        mData = Arrays.copyOfRange(data, offset, offset + 4);
        mFloat = BLEUtils.createFloat(data, offset);
    }

    /**
     * @return FLOAT byte array
     */
    public byte[] getData() {
        return mData;
    }

    /**
     * @return FLOAT
     */
    public double getFloat() {
        return mFloat;
    }

}
