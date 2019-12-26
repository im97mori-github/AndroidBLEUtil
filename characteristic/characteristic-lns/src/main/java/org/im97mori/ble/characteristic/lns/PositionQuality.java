package org.im97mori.ble.characteristic.lns;

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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POSITION_QUALITY_CHARACTERISTIC;

/**
 * Position Quality (Characteristics UUID: 0x2A69)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class PositionQuality implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
     * @see #FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_TRUE
     */
    public static final int FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_MASK = 0b00000000_00000001;

    /**
     * 0: Number of Beacons in Solution Present False
     */
    public static final int FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Number of Beacons in Solution Present True
     */
    public static final int FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_TRUE = 0b00000000_00000001;

    /**
     * @see #FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
     * @see #FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_TRUE
     */
    public static final int FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_MASK = 0b00000000_00000010;

    /**
     * 0: Number of Beacons in View Present False
     */
    public static final int FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Number of Beacons in View Present True
     */
    public static final int FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_TRUE = 0b00000000_00000010;

    /**
     * @see #FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
     * @see #FLAGS_TIME_TO_FIRST_FIX_PRESENT_TRUE
     */
    public static final int FLAGS_TIME_TO_FIRST_FIX_PRESENT_MASK = 0b00000000_00000100;

    /**
     * 0: Time to First Fix Present False
     */
    public static final int FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Time to First Fix Present True
     */
    public static final int FLAGS_TIME_TO_FIRST_FIX_PRESENT_TRUE = 0b00000000_00000100;

    /**
     * @see #FLAGS_EHPE_PRESENT_FALSE
     * @see #FLAGS_EHPE_PRESENT_TRUE
     */
    public static final int FLAGS_EHPE_PRESENT_MASK = 0b00000000_00001000;

    /**
     * 0: EHPE Present False
     */
    public static final int FLAGS_EHPE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: EHPE Present True
     */
    public static final int FLAGS_EHPE_PRESENT_TRUE = 0b00000000_00001000;

    /**
     * @see #FLAGS_EVPE_PRESENT_FALSE
     * @see #FLAGS_EVPE_PRESENT_TRUE
     */
    public static final int FLAGS_EVPE_PRESENT_MASK = 0b00000000_00010000;

    /**
     * 0: EVPE Present False
     */
    public static final int FLAGS_EVPE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: EVPE Present True
     */
    public static final int FLAGS_EVPE_PRESENT_TRUE = 0b00000000_00010000;

    /**
     * @see #FLAGS_HDOP_PRESENT_FALSE
     * @see #FLAGS_HDOP_PRESENT_TRUE
     */
    public static final int FLAGS_HDOPE_PRESENT_MASK = 0b00000000_00100000;

    /**
     * 0: HDOP Present False
     */
    public static final int FLAGS_HDOP_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: HDOP Present True
     */
    public static final int FLAGS_HDOP_PRESENT_TRUE = 0b00000000_00100000;

    /**
     * @see #FLAGS_VDOP_PRESENT_FALSE
     * @see #FLAGS_VDOP_PRESENT_TRUE
     */
    public static final int FLAGS_VDOP_PRESENT_MASK = 0b00000000_01000000;

    /**
     * 0: VDOP Present False
     */
    public static final int FLAGS_VDOP_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: VDOP Present False
     */
    public static final int FLAGS_VDOP_PRESENT_TRUE = 0b00000000_01000000;

    /**
     * @see #FLAGS_POSITION_STATUS_NO_POSITION
     * @see #FLAGS_POSITION_STATUS_POSITION_OK
     * @see #FLAGS_POSITION_STATUS_ESTIMATED_POSITION
     * @see #FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION
     */
    public static final int FLAGS_POSITION_STATUS_MASK = 0b00000001_10000000;

    /**
     * 0: No Position
     */
    public static final int FLAGS_POSITION_STATUS_NO_POSITION = 0b00000000_00000000;

    /**
     * 1: Position Ok
     */
    public static final int FLAGS_POSITION_STATUS_POSITION_OK = 0b00000000_10000000;

    /**
     * 2: Estimated Position
     */
    public static final int FLAGS_POSITION_STATUS_ESTIMATED_POSITION = 0b00000001_00000000;

    /**
     * 3: Last Known Position
     */
    public static final int FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION = 0b00000001_10000000;

    /**
     * Time to First Fix Unit 1/10 seconds
     */
    public static final double TIME_TO_FIRST_FIX_RESOLUTION = 0.1d;

    /**
     * EHPE Unit 1/100 meters
     */
    public static final double EHPE_RESOLUTION = 0.01d;

    /**
     * EVPE Unit 1/100 meters
     */
    public static final double EVPE_RESOLUTION = 0.01d;

    /**
     * HDOP Unit 2/10
     */
    public static final double HDOP_RESOLUTION = 0.2d;

    /**
     * VDOP Unit 2/10
     */
    public static final double VDOP_RESOLUTION = 0.2d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PositionQuality> CREATOR = new ByteArrayCreater<PositionQuality>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PositionQuality createFromParcel(@NonNull Parcel in) {
            return new PositionQuality(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PositionQuality[] newArray(int size) {
            return new PositionQuality[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PositionQuality createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POSITION_QUALITY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PositionQuality(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Number of Beacons in Solution
     */
    private final int mNumberOfBeaconsInSolution;

    /**
     * Number of Beacons in View
     */
    private final int mNumberOfBeaconsInView;

    /**
     * Time to First Fix
     */
    private final int mTimeToFirstFix;

    /**
     * EHPE
     */
    private final long mEhpe;

    /**
     * EVPE
     */
    private final long mEvpe;

    /**
     * HDOP
     */
    private final int mHdop;

    /**
     * VDOP
     */
    private final int mVdop;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A69
     */
    public PositionQuality(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 0;
        mFlags = Arrays.copyOfRange(values, index, index + 2);
        index += 2;
        if (isFlagsNumberOfBeasonsInSolutionPresent()) {
            mNumberOfBeaconsInSolution = (values[index++] & 0xff);
        } else {
            mNumberOfBeaconsInSolution = 0;
        }
        if (isFlagsNumberOfBeasonsInViewPresent()) {
            mNumberOfBeaconsInView = (values[index++] & 0xff);
        } else {
            mNumberOfBeaconsInView = 0;
        }
        if (isFlagsTimeToFirstFixPresent()) {
            mTimeToFirstFix = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mTimeToFirstFix = 0;
        }
        if (isFlagsEhpePresent()) {
            mEhpe = BLEUtils.createUInt32(values, index);
            index += 4;
        } else {
            mEhpe = 0;
        }
        if (isFlagEvpePresent()) {
            mEvpe = BLEUtils.createUInt32(values, index);
            index += 4;
        } else {
            mEvpe = 0;
        }
        if (isFlagsHdopPresent()) {
            mHdop = (values[index++] & 0xff);
        } else {
            mHdop = 0;
        }
        if (isFlagsVdopPresent()) {
            mVdop = (values[index] & 0xff);
        } else {
            mVdop = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PositionQuality(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mNumberOfBeaconsInSolution = in.readInt();
        mNumberOfBeaconsInView = in.readInt();
        mTimeToFirstFix = in.readInt();
        mEhpe = in.readLong();
        mEvpe = in.readLong();
        mHdop = in.readInt();
        mVdop = in.readInt();
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
        dest.writeByteArray(mFlags);
        dest.writeInt(mNumberOfBeaconsInSolution);
        dest.writeInt(mNumberOfBeaconsInView);
        dest.writeInt(mTimeToFirstFix);
        dest.writeLong(mEhpe);
        dest.writeLong(mEvpe);
        dest.writeInt(mHdop);
        dest.writeInt(mVdop);
    }

    /**
     * @return Flags
     */
    public byte[] getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:Number of Beacons in Solution not Present, {@code false}:Number of Beacons in Solution Present
     */
    public boolean isFlagsNumberOfBeasonsInSolutionNotPresent() {
        return isFlagsMatched(FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_MASK, FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Number of Beacons in Solution Present, {@code false}:Number of Beacons in Solution not Present
     */
    public boolean isFlagsNumberOfBeasonsInSolutionPresent() {
        return isFlagsMatched(FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_MASK, FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Number of Beacons in View not Present, {@code false}:Number of Beacons in View Present
     */
    public boolean isFlagsNumberOfBeasonsInViewNotPresent() {
        return isFlagsMatched(FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_MASK, FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Number of Beacons in View Present, {@code false}:Number of Beacons in View not Present
     */
    public boolean isFlagsNumberOfBeasonsInViewPresent() {
        return isFlagsMatched(FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_MASK, FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Time to First Fix not Present, {@code false}:Time to First Fix Present
     */
    public boolean isFlagsTimeToFirstFixNotPresent() {
        return isFlagsMatched(FLAGS_TIME_TO_FIRST_FIX_PRESENT_MASK, FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Time to First Fix Present, {@code false}:Time to First Fix not Present
     */
    public boolean isFlagsTimeToFirstFixPresent() {
        return isFlagsMatched(FLAGS_TIME_TO_FIRST_FIX_PRESENT_MASK, FLAGS_TIME_TO_FIRST_FIX_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:EHPE not Present, {@code false}:EHPE Present
     */
    public boolean isFlagsEhpeNotPresent() {
        return isFlagsMatched(FLAGS_EHPE_PRESENT_MASK, FLAGS_EHPE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:EHPE Present, {@code false}:EHPE not Present
     */
    public boolean isFlagsEhpePresent() {
        return isFlagsMatched(FLAGS_EHPE_PRESENT_MASK, FLAGS_EHPE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:EVPE not Present, {@code false}:EVPE Present
     */
    public boolean isFlagEvpeNotPresent() {
        return isFlagsMatched(FLAGS_EVPE_PRESENT_MASK, FLAGS_EVPE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:EVPE not Present, {@code false}:EVPE Present
     */
    public boolean isFlagEvpePresent() {
        return isFlagsMatched(FLAGS_EVPE_PRESENT_MASK, FLAGS_EVPE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:HDOP not Present, {@code false}:HDOP Present
     */
    public boolean isFlagsHdopNotPresent() {
        return isFlagsMatched(FLAGS_HDOPE_PRESENT_MASK, FLAGS_HDOP_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:HDOP Present, {@code false}:HDOP not Present
     */
    public boolean isFlagsHdopPresent() {
        return isFlagsMatched(FLAGS_HDOPE_PRESENT_MASK, FLAGS_HDOP_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:VDOP not Present, {@code false}:VDOP Present
     */
    public boolean isFlagsVdopNotPresent() {
        return isFlagsMatched(FLAGS_VDOP_PRESENT_MASK, FLAGS_VDOP_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:VDOP Present, {@code false}:VDOP not Present
     */
    public boolean isFlagsVdopPresent() {
        return isFlagsMatched(FLAGS_VDOP_PRESENT_MASK, FLAGS_VDOP_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:No Position, {@code false}:not No Position
     */
    public boolean isFlagsPositionStatusNoPosition() {
        return isFlagsMatched(FLAGS_POSITION_STATUS_MASK, FLAGS_POSITION_STATUS_NO_POSITION);
    }

    /**
     * @return {@code true}:Position Ok, {@code false}:not Position Ok
     */
    public boolean isFlagsPositionStatusPositionOk() {
        return isFlagsMatched(FLAGS_POSITION_STATUS_MASK, FLAGS_POSITION_STATUS_POSITION_OK);
    }

    /**
     * @return {@code true}:Estimated Position, {@code false}:not Estimated Position
     */
    public boolean isFlagsPositionStatusEstimatedPosition() {
        return isFlagsMatched(FLAGS_POSITION_STATUS_MASK, FLAGS_POSITION_STATUS_ESTIMATED_POSITION);
    }

    /**
     * @return {@code true}:Last Known Position, {@code false}:not Last Known Position
     */
    public boolean isFlagsPositionStatusLastKnownPosition() {
        return isFlagsMatched(FLAGS_POSITION_STATUS_MASK, FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION);
    }

    /**
     * @return Number of Beacons in Solution
     */
    public int getNumberOfBeaconsInSolution() {
        return mNumberOfBeaconsInSolution;
    }

    /**
     * @return Number of Beacons in View
     */
    public int getNumberOfBeaconsInView() {
        return mNumberOfBeaconsInView;
    }

    /**
     * @return Time to First Fix
     */
    public int getTimeToFirstFix() {
        return mTimeToFirstFix;
    }

    /**
     * @return Time to First Fix(seconds)
     */
    public double getTimeToFirstFixSeconds() {
        return TIME_TO_FIRST_FIX_RESOLUTION * mTimeToFirstFix;
    }

    /**
     * @return EHPE
     */
    public long getEhpe() {
        return mEhpe;
    }

    /**
     * @return EHPE(meters)
     */
    public double getEhpeMeters() {
        return EHPE_RESOLUTION * mEhpe;
    }

    /**
     * @return EVPE
     */
    public long getEvpe() {
        return mEvpe;
    }

    /**
     * @return EVPE(meters)
     */
    public double getEvpeMeters() {
        return EVPE_RESOLUTION * mEvpe;
    }

    /**
     * @return HDOP
     */
    public int getHdop() {
        return mHdop;
    }

    /**
     * @return HDOP with Unit
     */
    public double getHdopWithUnit() {
        return HDOP_RESOLUTION * mHdop;
    }

    /**
     * @return VDOP
     */
    public int getVdop() {
        return mVdop;
    }

    /**
     * @return VDOP with Unit
     */
    public double getVdopWithUnit() {
        return VDOP_RESOLUTION * mVdop;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[16];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        length += 2;
        if (isFlagsNumberOfBeasonsInSolutionPresent()) {
            byteBuffer.put((byte) mNumberOfBeaconsInSolution);
            length++;
        }
        if (isFlagsNumberOfBeasonsInViewPresent()) {
            byteBuffer.put((byte) mNumberOfBeaconsInView);
            length++;
        }
        if (isFlagsTimeToFirstFixPresent()) {
            byteBuffer.putShort((short) mTimeToFirstFix);
            length += 2;
        }
        if (isFlagsEhpePresent()) {
            byteBuffer.putInt((int) mEhpe);
            length += 4;
        }
        if (isFlagEvpePresent()) {
            byteBuffer.putInt((int) mEvpe);
            length += 4;
        }
        if (isFlagsHdopPresent()) {
            byteBuffer.put((byte) mHdop);
            length++;
        }
        if (isFlagsVdopPresent()) {
            byteBuffer.put((byte) mVdop);
            length++;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Weight Scale Feature
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE}
     *               , {@link #FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_TRUE}
     *               , {@link #FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE}
     *               , {@link #FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_TRUE}
     *               , {@link #FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE}
     *               , {@link #FLAGS_TIME_TO_FIRST_FIX_PRESENT_TRUE}
     *               , {@link #FLAGS_EHPE_PRESENT_FALSE}
     *               , {@link #FLAGS_EHPE_PRESENT_TRUE}
     *               , {@link #FLAGS_EVPE_PRESENT_FALSE}
     *               , {@link #FLAGS_EVPE_PRESENT_TRUE}
     *               , {@link #FLAGS_HDOP_PRESENT_FALSE}
     *               , {@link #FLAGS_HDOP_PRESENT_TRUE}
     *               , {@link #FLAGS_VDOP_PRESENT_FALSE}
     *               , {@link #FLAGS_VDOP_PRESENT_TRUE}
     *               , {@link #FLAGS_POSITION_STATUS_NO_POSITION}
     *               , {@link #FLAGS_POSITION_STATUS_POSITION_OK}
     *               , {@link #FLAGS_POSITION_STATUS_ESTIMATED_POSITION}
     *               , {@link #FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mFlags, 0)) == expect;
    }

}
