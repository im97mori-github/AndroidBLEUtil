package org.im97mori.ble.ad;

/**
 * Advertising Data(Extended Inquiry Response Data)
 */
@SuppressWarnings("WeakerAccess")
public abstract class AbstractAdvertisingData {

    /**
     * <p>
     * data length
     * <p>
     * 1st octed of Advertising Data(Extended Inquiry Response Data)
     * </p>
     */
    protected final int mLength;

    /**
     * Constructor
     *
     * @param length data length
     */
    protected AbstractAdvertisingData(int length) {
        mLength = length;
    }

    /**
     * data length
     */
    public int getLength() {
        return mLength;
    }

    /**
     * <p>
     * Advertising Data(Extended Inquiry Response Data) Type
     * <p>
     * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
     * </p>
     */
    public abstract int getDataType();

}
