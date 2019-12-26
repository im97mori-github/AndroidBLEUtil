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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NAVIGATION_CHARACTERISTIC;

/**
 * Navigation (Characteristics UUID: 0x2A68)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Navigation implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAGS_REMAINING_DISTANCE_PRESENT_FALSE
     * @see #FLAGS_REMAINING_DISTANCE_PRESENT_TRUE
     */
    public static final int FLAGS_REMAINING_DISTANCE_PRESENT_MASK = 0b00000000_00000001;

    /**
     * 0: Remaining Distance Present False
     */
    public static final int FLAGS_REMAINING_DISTANCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Remaining Distance Present True
     */
    public static final int FLAGS_REMAINING_DISTANCE_PRESENT_TRUE = 0b00000000_00000001;

    /**
     * @see #FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_FALSE
     * @see #FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_TRUE
     */
    public static final int FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_MASK = 0b00000000_00000010;

    /**
     * 0: Remaining Vertical Distance Present False
     */
    public static final int FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Remaining Vertical Distance Present True
     */
    public static final int FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_TRUE = 0b00000000_00000010;

    /**
     * @see #FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_FALSE
     * @see #FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_TRUE
     */
    public static final int FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_MASK = 0b00000000_00000100;

    /**
     * 0: Estimated Time of Arrival Present False
     */
    public static final int FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Estimated Time of Arrival Present True
     */
    public static final int FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_TRUE = 0b00000000_00000100;

    /**
     * @see #FLAGS_POSITION_STATUS_NO_POSITION
     * @see #FLAGS_POSITION_STATUS_POSITION_OK
     * @see #FLAGS_POSITION_STATUS_ESTIMATED_POSITION
     * @see #FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION
     */
    public static final int FLAGS_POSITION_STATUS_MASK = 0b00000000_0011000;

    /**
     * 0: No Position
     */
    public static final int FLAGS_POSITION_STATUS_NO_POSITION = 0b00000000_00000000;

    /**
     * 1: Position Ok
     */
    public static final int FLAGS_POSITION_STATUS_POSITION_OK = 0b00000000_00001000;

    /**
     * 2: Estimated Position
     */
    public static final int FLAGS_POSITION_STATUS_ESTIMATED_POSITION = 0b00000000_00010000;

    /**
     * 3: Last Known Position
     */
    public static final int FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION = 0b00000000_00011000;

    /**
     * @see #FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT
     * @see #FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS
     */
    public static final int FLAGS_HEADING_SOURCE_MASK = 0b00000000_01000000;

    /**
     * 0: Heading based on movement
     */
    public static final int FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT = 0b00000000_00000000;

    /**
     * 1: Heading based on magnetic compass
     */
    public static final int FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS = 0b00000000_01000000;

    /**
     * @see #FLAGS_NAVIGATION_INDICATOR_TYPE_TO_WAYPOINT
     * @see #FLAGS_NAVIGATION_INDICATOR_TYPE_TO_DESTINATION
     */
    public static final int FLAGS_NAVIGATION_INDICATOR_TYPE_MASK = 0b00000000_10000000;

    /**
     * 0: To Waypoint
     */
    public static final int FLAGS_NAVIGATION_INDICATOR_TYPE_TO_WAYPOINT = 0b00000000_00000000;

    /**
     * 1: To Destination
     */
    public static final int FLAGS_NAVIGATION_INDICATOR_TYPE_TO_DESTINATION = 0b00000000_10000000;

    /**
     * @see #FLAGS_WAYPOINT_REACHED_FALSE
     * @see #FLAGS_WAYPOINT_REACHED_TRUE
     */
    public static final int FLAGS_WAYPOINT_REACHED_MASK = 0b00000001_00000000;

    /**
     * 0: Waypoint Reached False
     */
    public static final int FLAGS_WAYPOINT_REACHED_FALSE = 0b00000000_00000000;

    /**
     * 1: Waypoint Reached True
     */
    public static final int FLAGS_WAYPOINT_REACHED_TRUE = 0b00000001_00000000;

    /**
     * @see #FLAGS_DESTINATION_REACHED_FALSE
     * @see #FLAGS_DESTINATION_REACHED_TRUE
     */
    public static final int FLAGS_DESTINATION_REACHED_MASK = 0b00000010_00000000;

    /**
     * 0: Destination Reached False
     */
    public static final int FLAGS_DESTINATION_REACHED_FALSE = 0b00000000_00000000;

    /**
     * 1: Destination Reached True
     */
    public static final int FLAGS_DESTINATION_REACHED_TRUE = 0b00000010_00000000;

    /**
     * Bearing Unit 1/100 degrees
     */
    public static final double BEARING_RESOLUTION = 0.01d;

    /**
     * Heading Unit 1/100 degrees
     */
    public static final double HEADING_RESOLUTION = 0.01d;

    /**
     * Remaining Distance Unit 1/10 meters
     */
    public static final double REMAINING_DISTANCE_RESOLUTION = 0.1d;

    /**
     * Remaining Vertical Unit 1/100 meters
     */
    public static final double REMAINING_VERTICAL_DISTANCE_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Navigation> CREATOR = new ByteArrayCreater<Navigation>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Navigation createFromParcel(@NonNull Parcel in) {
            return new Navigation(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Navigation[] newArray(int size) {
            return new Navigation[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Navigation createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NAVIGATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Navigation(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Bearing
     */
    private final int mBearing;

    /**
     * Heading
     */
    private final int mHeading;

    /**
     * Remaining Distance
     */
    private final int mRemainingDistance;

    /**
     * Remaining Vertical Distance
     */
    private final int mRemainingVerticalDistance;

    /**
     * Year
     */
    private final int mYear;

    /**
     * Month
     */
    private final int mMonth;

    /**
     * Day
     */
    private final int mDay;

    /**
     * Hours
     */
    private final int mHours;

    /**
     * Minutes
     */
    private final int mMinutes;

    /**
     * Seconds
     */
    private final int mSeconds;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A68
     */
    public Navigation(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 0;
        mFlags = Arrays.copyOfRange(values, index, index + 2);
        index += 2;
        mBearing = BLEUtils.createUInt16(values, index);
        index += 2;
        mHeading = BLEUtils.createUInt16(values, index);
        index += 2;
        if (isFlagsRemainigDistancePresent()) {
            mRemainingDistance = BLEUtils.createUInt24(values, index);
            index += 3;
        } else {
            mRemainingDistance = 0;
        }
        if (isFlagsRemainigVerticalDistancePresent()) {
            mRemainingVerticalDistance = BLEUtils.createSInt24(values, index);
            index += 3;
        } else {
            mRemainingVerticalDistance = 0;
        }
        if (isFlagsEstimatedTimeOfArrivalPresent()) {
            mYear = BLEUtils.createUInt16(values, index);
            index += 2;
            mMonth = (values[index++] & 0xff);
            mDay = (values[index++] & 0xff);
            mHours = (values[index++] & 0xff);
            mMinutes = (values[index++] & 0xff);
            mSeconds = (values[index] & 0xff);
        } else {
            mYear = 0;
            mMonth = 0;
            mDay = 0;
            mHours = 0;
            mMinutes = 0;
            mSeconds = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Navigation(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mBearing = in.readInt();
        mHeading = in.readInt();
        mRemainingDistance = in.readInt();
        mRemainingVerticalDistance = in.readInt();
        mYear = in.readInt();
        mMonth = in.readInt();
        mDay = in.readInt();
        mHours = in.readInt();
        mMinutes = in.readInt();
        mSeconds = in.readInt();
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
        dest.writeInt(mBearing);
        dest.writeInt(mHeading);
        dest.writeInt(mRemainingDistance);
        dest.writeInt(mRemainingVerticalDistance);
        dest.writeInt(mYear);
        dest.writeInt(mMonth);
        dest.writeInt(mDay);
        dest.writeInt(mHours);
        dest.writeInt(mMinutes);
        dest.writeInt(mSeconds);
    }

    /**
     * @return Flags
     */
    public byte[] getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:Remaining Distance not Present, {@code false}:Remaining Distance Present
     */
    public boolean isFlagsRemainigDistanceNotPresent() {
        return isFlagsMatched(FLAGS_REMAINING_DISTANCE_PRESENT_MASK, FLAGS_REMAINING_DISTANCE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Remaining Distance Present, {@code false}:Remaining Distance not Present
     */
    public boolean isFlagsRemainigDistancePresent() {
        return isFlagsMatched(FLAGS_REMAINING_DISTANCE_PRESENT_MASK, FLAGS_REMAINING_DISTANCE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Remaining Vertical Distance not Present, {@code false}:Remaining Vertical Distance Present
     */
    public boolean isFlagsRemainigVerticalDistanceNotPresent() {
        return isFlagsMatched(FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_MASK, FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Remaining Vertical Distance Present, {@code false}:Remaining Vertical Distance not Present
     */
    public boolean isFlagsRemainigVerticalDistancePresent() {
        return isFlagsMatched(FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_MASK, FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Estimated Time of Arrival not Present, {@code false}:Estimated Time of Arrival Present
     */
    public boolean isFlagsEstimatedTimeOfArrivalNotPresent() {
        return isFlagsMatched(FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_MASK, FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Estimated Time of Arrival Present, {@code false}:Estimated Time of Arrival not Present
     */
    public boolean isFlagsEstimatedTimeOfArrivalPresent() {
        return isFlagsMatched(FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_MASK, FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_TRUE);
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
     * @return {@code true}:Heading based on movement, {@code false}:Heading based on magnetic compass
     */
    public boolean isFlagsHeadingSourceBasedOnMovement() {
        return isFlagsMatched(FLAGS_HEADING_SOURCE_MASK, FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT);
    }

    /**
     * @return {@code true}:Heading based on magnetic compass, {@code false}:Heading based on movement
     */
    public boolean isFlagsHeadingSourceBasedOnMagneticCompass() {
        return isFlagsMatched(FLAGS_HEADING_SOURCE_MASK, FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS);
    }

    /**
     * @return {@code true}:To Waypoint, {@code false}:To Destination
     */
    public boolean isFlagsNavigationIndicatorTypeToWaypoint() {
        return isFlagsMatched(FLAGS_NAVIGATION_INDICATOR_TYPE_MASK, FLAGS_NAVIGATION_INDICATOR_TYPE_TO_WAYPOINT);
    }

    /**
     * @return {@code true}:To Destination, {@code false}:To Waypoint
     */
    public boolean isFlagsNavigationIndicatorTypeToDestination() {
        return isFlagsMatched(FLAGS_NAVIGATION_INDICATOR_TYPE_MASK, FLAGS_NAVIGATION_INDICATOR_TYPE_TO_DESTINATION);
    }

    /**
     * @return {@code true}:not Waypoint Reached, {@code false}:Waypoint Reached
     */
    public boolean isFlagsWaypointNotReached() {
        return isFlagsMatched(FLAGS_WAYPOINT_REACHED_MASK, FLAGS_WAYPOINT_REACHED_FALSE);
    }

    /**
     * @return {@code true}:Waypoint Reached, {@code false}:not Waypoint Reached
     */
    public boolean isFlagsWaypointReached() {
        return isFlagsMatched(FLAGS_WAYPOINT_REACHED_MASK, FLAGS_WAYPOINT_REACHED_TRUE);
    }

    /**
     * @return {@code true}:not Destination Reached, {@code false}:Destination Reached
     */
    public boolean isFlagsDestinationNotReached() {
        return isFlagsMatched(FLAGS_DESTINATION_REACHED_MASK, FLAGS_DESTINATION_REACHED_FALSE);
    }

    /**
     * @return {@code true}:Destination Reached, {@code false}:not Destination Reached
     */
    public boolean isFlagsDestinationReached() {
        return isFlagsMatched(FLAGS_DESTINATION_REACHED_MASK, FLAGS_DESTINATION_REACHED_TRUE);
    }

    /**
     * @return Bearing
     */
    public int getBearing() {
        return mBearing;
    }

    /**
     * @return Bearing(degrees)
     */
    public double getBearingDegrees() {
        return BEARING_RESOLUTION * mBearing;
    }

    /**
     * @return Heading
     */
    public int getHeading() {
        return mHeading;
    }

    /**
     * @return Heading(degrees)
     */
    public double getHeadingDegrees() {
        return HEADING_RESOLUTION * mHeading;
    }

    /**
     * @return Remaining Distance
     */
    public int getRemainingDistance() {
        return mRemainingDistance;
    }

    /**
     * @return Remaining Distance(meters)
     */
    public double getRemainingDistanceMeters() {
        return REMAINING_DISTANCE_RESOLUTION * mRemainingDistance;
    }

    /**
     * @return Remaining Vertical Distance
     */
    public int getRemainingVerticalDistance() {
        return mRemainingVerticalDistance;
    }

    /**
     * @return Remaining Vertical Distance(meters)
     */
    public double getRemainingVerticalDistanceMeters() {
        return REMAINING_VERTICAL_DISTANCE_RESOLUTION * mRemainingVerticalDistance;
    }

    /**
     * @return Year
     */
    public int getYear() {
        return mYear;
    }

    /**
     * @return Month
     */
    public int getMonth() {
        return mMonth;
    }

    /**
     * @return Day
     */
    public int getDay() {
        return mDay;
    }

    /**
     * @return Hours
     */
    public int getHours() {
        return mHours;
    }

    /**
     * @return Minutes
     */
    public int getMinutes() {
        return mMinutes;
    }

    /**
     * @return Seconds
     */
    public int getSeconds() {
        return mSeconds;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 6;
        byte[] data = new byte[20];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        byteBuffer.putShort((short) mBearing);
        byteBuffer.putShort((short) mHeading);
        if (isFlagsRemainigDistancePresent()) {
            byteBuffer.put((byte) mRemainingDistance);
            byteBuffer.put((byte) (mRemainingDistance >> 8));
            byteBuffer.put((byte) (mRemainingDistance >> 16));
            length += 3;
        }
        if (isFlagsRemainigVerticalDistancePresent()) {
            byteBuffer.put((byte) mRemainingVerticalDistance);
            byteBuffer.put((byte) (mRemainingVerticalDistance >> 8));
            byteBuffer.put((byte) (mRemainingVerticalDistance >> 16));
            length += 3;
        }
        if (isFlagsEstimatedTimeOfArrivalPresent()) {
            byteBuffer.putShort((short) mYear);
            byteBuffer.put((byte) mMonth);
            byteBuffer.put((byte) mDay);
            byteBuffer.put((byte) mHours);
            byteBuffer.put((byte) mMinutes);
            byteBuffer.put((byte) mSeconds);
            length += 7;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Weight Scale Feature
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAGS_REMAINING_DISTANCE_PRESENT_FALSE}
     *               , {@link #FLAGS_REMAINING_DISTANCE_PRESENT_TRUE}
     *               , {@link #FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_FALSE}
     *               , {@link #FLAGS_REMAINING_VERTICAL_DISTANCE_PRESENT_TRUE}
     *               , {@link #FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_FALSE}
     *               , {@link #FLAGS_ESTIMATED_TIME_OF_ARRIVAL_PRESENT_TRUE}
     *               , {@link #FLAGS_POSITION_STATUS_NO_POSITION}
     *               , {@link #FLAGS_POSITION_STATUS_POSITION_OK}
     *               , {@link #FLAGS_POSITION_STATUS_ESTIMATED_POSITION}
     *               , {@link #FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION}
     *               , {@link #FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT}
     *               , {@link #FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS}
     *               , {@link #FLAGS_NAVIGATION_INDICATOR_TYPE_TO_WAYPOINT}
     *               , {@link #FLAGS_NAVIGATION_INDICATOR_TYPE_TO_DESTINATION}
     *               , {@link #FLAGS_WAYPOINT_REACHED_FALSE}
     *               , {@link #FLAGS_WAYPOINT_REACHED_TRUE}
     *               , {@link #FLAGS_DESTINATION_REACHED_FALSE}
     *               , {@link #FLAGS_DESTINATION_REACHED_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mFlags, 0)) == expect;
    }

}
