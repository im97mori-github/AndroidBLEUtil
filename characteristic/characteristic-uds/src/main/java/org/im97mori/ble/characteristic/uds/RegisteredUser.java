package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;

/**
 * User data for multiple packet characteristic
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RegisteredUser implements ByteArrayInterface, Parcelable {

    /**
     * @see #SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
     * @see #SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
     */
    public static final int SEGMENTATION_HEADER_FIRST_SEGMENT_MASK = 0b00000001;

    /**
     * 0: not First Segment
     */
    public static final int SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE = 0b00000000;

    /**
     * 1: First Segment
     */
    public static final int SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE = 0b00000001;

    /**
     * @see #SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
     * @see #SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
     */
    public static final int SEGMENTATION_HEADER_LAST_SEGMENT_MASK = 0b00000010;

    /**
     * 0: not Last Segment
     */
    public static final int SEGMENTATION_HEADER_LAST_SEGMENT_FALSE = 0b00000000;

    /**
     * 1: Last Segment
     */
    public static final int SEGMENTATION_HEADER_LAST_SEGMENT_TRUE = 0b00000010;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RegisteredUser> CREATOR = new ByteArrayCreater<RegisteredUser>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RegisteredUser createFromParcel(@NonNull Parcel in) {
            return new RegisteredUser(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RegisteredUser[] newArray(int size) {
            return new RegisteredUser[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RegisteredUser createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RegisteredUser(bluetoothGattCharacteristic);
        }

    };

    /**
     * Segmentation Header
     */
    private final int mSegmentationHeader;

    /**
     * Registered User Index
     */
    private final int mRegisteredUserIndex;

    /**
     * Registered User Data
     */
    private final byte[] mRegisteredUserData;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A87, 0x2A8A, 0x2A90
     */
    public RegisteredUser(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mSegmentationHeader = BLEUtils.createUInt8(values, 0);
        if (isSegmentationHeaderFirstSegment()) {
            mRegisteredUserIndex = BLEUtils.createUInt8(values, 1);
            mRegisteredUserData = Arrays.copyOfRange(values, 2, values.length);
        } else {
            mRegisteredUserIndex = 0;
            mRegisteredUserData = Arrays.copyOfRange(values, 1, values.length);
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RegisteredUser(@NonNull Parcel in) {
        mSegmentationHeader = in.readInt();
        mRegisteredUserIndex = in.readInt();
        mRegisteredUserData = in.createByteArray();
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
        dest.writeInt(mSegmentationHeader);
        dest.writeInt(mRegisteredUserIndex);
        dest.writeByteArray(mRegisteredUserData);
    }

    /**
     * @return Segmentation Header
     */
    public int getSegmentationHeader() {
        return mSegmentationHeader;
    }

    /**
     * @return {@code true}:not First Segment, {@code false}:First Segment
     */
    public boolean isSegmentationHeaderNotFirstSegment() {
        return isSegmentationHeaderMatched(SEGMENTATION_HEADER_FIRST_SEGMENT_MASK, SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE);
    }

    /**
     * @return {@code true}:First Segment, {@code false}:not First Segment
     */
    public boolean isSegmentationHeaderFirstSegment() {
        return isSegmentationHeaderMatched(SEGMENTATION_HEADER_FIRST_SEGMENT_MASK, SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE);
    }

    /**
     * @return {@code true}:not Last Segment, {@code false}:Last Segment
     */
    public boolean isSegmentationHeaderNotLastSegment() {
        return isSegmentationHeaderMatched(SEGMENTATION_HEADER_LAST_SEGMENT_MASK, SEGMENTATION_HEADER_LAST_SEGMENT_FALSE);
    }

    /**
     * @return {@code true}:Last Segment, {@code false}:not Last Segment
     */
    public boolean isSegmentationHeaderLastSegment() {
        return isSegmentationHeaderMatched(SEGMENTATION_HEADER_LAST_SEGMENT_MASK, SEGMENTATION_HEADER_LAST_SEGMENT_TRUE);
    }

    /**
     * @return Rolling Segment Number (0 to 63)
     */
    public int getSegmentationHeaderRollingSegmentNumber() {
        return (mSegmentationHeader >> 2) & 0b00111111;
    }

    /**
     * @return Registered User Index
     */
    public int getRegisteredUserIndex() {
        return mRegisteredUserIndex;
    }

    /**
     * @return Registered User Data
     */
    public byte[] getRegisteredUserData() {
        return mRegisteredUserData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[2 + mRegisteredUserData.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mSegmentationHeader);
        length++;
        if (isSegmentationHeaderFirstSegment()) {
            byteBuffer.put((byte) mRegisteredUserIndex);
            length++;
        }
        byteBuffer.put(mRegisteredUserData, 0, mRegisteredUserData.length);
        length += mRegisteredUserData.length;
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Segmentation Header
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE}
     *               , {@link #SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE}
     *               , {@link #SEGMENTATION_HEADER_LAST_SEGMENT_FALSE}
     *               , {@link #SEGMENTATION_HEADER_LAST_SEGMENT_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isSegmentationHeaderMatched(int mask, int expect) {
        return (mask & mSegmentationHeader) == expect;
    }

}
