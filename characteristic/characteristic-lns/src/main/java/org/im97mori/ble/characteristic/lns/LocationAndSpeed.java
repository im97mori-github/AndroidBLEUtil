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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCATION_AND_SPEED_CHARACTERISTIC;

/**
 * Location and Speed Characteristic (Characteristics UUID: 0x2A67)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LocationAndSpeed implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
     * @see #FLAGS_INSTANTANEOUS_SPEED_PRESENT_TRUE
     */
    public static final int FLAGS_INSTANTANEOUS_SPEED_PRESENT_MASK = 0b00000000_00000001;

    /**
     * 0: Instantaneous Speed Present False
     */
    public static final int FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Instantaneous Speed Present True
     */
    public static final int FLAGS_INSTANTANEOUS_SPEED_PRESENT_TRUE = 0b00000000_00000001;

    /**
     * @see #FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
     * @see #FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_MASK = 0b00000000_00000010;

    /**
     * 0: Total Distance Present False
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Total Distance Present True
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_TRUE = 0b00000000_00000010;

    /**
     * @see #FLAGS_LOCATION_PRESENT_FALSE
     * @see #FLAGS_LOCATION_PRESENT_TRUE
     */
    public static final int FLAGS_LOCATION_PRESENT_MASK = 0b00000000_00000100;

    /**
     * 0: Location Present False
     */
    public static final int FLAGS_LOCATION_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Location Present True
     */
    public static final int FLAGS_LOCATION_PRESENT_TRUE = 0b00000000_00000100;

    /**
     * @see #FLAGS_ELEVATION_PRESENT_FALSE
     * @see #FLAGS_ELEVATION_PRESENT_TRUE
     */
    public static final int FLAGS_ELEVATION_PRESENT_MASK = 0b00000000_00001000;

    /**
     * 0: Elevation Present False
     */
    public static final int FLAGS_ELEVATION_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Elevation Present True
     */
    public static final int FLAGS_ELEVATION_PRESENT_TRUE = 0b00000000_00001000;

    /**
     * @see #FLAGS_HEADING_PRESENT_FALSE
     * @see #FLAGS_HEADING_PRESENT_TRUE
     */
    public static final int FLAGS_HEADING_PRESENT_MASK = 0b00000000_00010000;

    /**
     * 0: Heading Present False
     */
    public static final int FLAGS_HEADING_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Heading Present True
     */
    public static final int FLAGS_HEADING_PRESENT_TRUE = 0b00000000_00010000;

    /**
     * @see #FLAGS_ROLLING_TIME_PRESENT_FALSE
     * @see #FLAGS_ROLLING_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_ROLLING_TIME_PRESENT_MASK = 0b00000000_00100000;

    /**
     * 0: Rolling Time Present False
     */
    public static final int FLAGS_ROLLING_TIME_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Rolling Time Present True
     */
    public static final int FLAGS_ROLLING_TIME_PRESENT_TRUE = 0b00000000_00100000;

    /**
     * @see #FLAGS_UTC_TIME_PRESENT_FALSE
     * @see #FLAGS_UTC_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_UTC_TIME_PRESENT_MASK = 0b00000000_01000000;

    /**
     * 0: UTC Time Present False
     */
    public static final int FLAGS_UTC_TIME_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: UTC Time Present True
     */
    public static final int FLAGS_UTC_TIME_PRESENT_TRUE = 0b00000000_01000000;

    /**
     * @see #FLAGS_POSITION_SATUS_NO_POSITION
     * @see #FLAGS_POSITION_SATUS_POSITION_OK
     * @see #FLAGS_POSITION_SATUS_ESTIMATED_POSITION
     * @see #FLAGS_POSITION_SATUS_LAST_KNOWN_POSITION
     */
    public static final int FLAGS_POSITION_SATUS_MASK = 0b00000001_10000000;

    /**
     * 0: No Position
     */
    public static final int FLAGS_POSITION_SATUS_NO_POSITION = 0b00000000_00000000;

    /**
     * 1: Position Ok
     */
    public static final int FLAGS_POSITION_SATUS_POSITION_OK = 0b00000000_10000000;

    /**
     * 2: Estimated Position
     */
    public static final int FLAGS_POSITION_SATUS_ESTIMATED_POSITION = 0b00000001_00000000;

    /**
     * 3: Last Known Position
     */
    public static final int FLAGS_POSITION_SATUS_LAST_KNOWN_POSITION = 0b00000001_10000000;

    /**
     * @see #FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
     * @see #FLAGS_SPEED_AND_DISTANCE_FORMAT_3D
     */
    public static final int FLAGS_SPEED_AND_DISTANCE_FORMAT_MASK = 0b00000010_00000000;

    /**
     * 0: 2D
     */
    public static final int FLAGS_SPEED_AND_DISTANCE_FORMAT_2D = 0b00000000_00000000;

    /**
     * 1: 3D
     */
    public static final int FLAGS_SPEED_AND_DISTANCE_FORMAT_3D = 0b00000010_00000000;

    /**
     * @see #FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
     * @see #FLAGS_ELEVATION_SOURCE_BAROMETRIC_AIR_PRESSURE
     * @see #FLAGS_ELEVATION_SOURCE_DATABASE_SERVICE
     * @see #FLAGS_ELEVATION_SOURCE_OTHER
     */
    public static final int FLAGS_ELEVATION_SOURCE_MASK = 0b00001100_00000000;

    /**
     * 0: Positioning System
     */
    public static final int FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM = 0b00000000_00000000;

    /**
     * 1: Barometric Air Pressure
     */
    public static final int FLAGS_ELEVATION_SOURCE_BAROMETRIC_AIR_PRESSURE = 0b00000100_00000000;

    /**
     * 2: Database Service (or similiar)
     */
    public static final int FLAGS_ELEVATION_SOURCE_DATABASE_SERVICE = 0b00001000_00000000;

    /**
     * 3: Other
     */
    public static final int FLAGS_ELEVATION_SOURCE_OTHER = 0b00001100_00000000;

    /**
     * @see #FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT
     * @see #FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS
     */
    public static final int FLAGS_HEADING_SOURCE_MASK = 0b00010000_00000000;

    /**
     * 0: Heading based on movement
     */
    public static final int FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT = 0b00000000_00000000;

    /**
     * 1: Heading based on magnetic compass
     */
    public static final int FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS = 0b00010000_00000000;

    /**
     * Instantaneous Speed Unit 1/100 meters per second
     */
    public static final double INSTANTANEOUS_SPEED_RESOLUTION = 0.01d;

    /**
     * Total Distance Unit 1/10 meters
     */
    public static final double TOTAL_DISTANCE_RESOLUTION = 0.1d;

    /**
     * Location - Latitude Unit 1/(10^7) degrees
     */
    public static final double LOCATION_LATITUDE_RESOLUTION = 0.0000001d;

    /**
     * Location - Longitude Unit 1/(10^7) degrees
     */
    public static final double LOCATION_LONGITUDE_RESOLUTION = 0.0000001d;

    /**
     * Elevation Unit 1/100 meters
     */
    public static final double ELEVATION_RESOLUTION = 0.01d;

    /**
     * Heading Unit 1/100 degrees
     */
    public static final double HEADING_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocationAndSpeed> CREATOR = new ByteArrayCreater<LocationAndSpeed>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationAndSpeed createFromParcel(@NonNull Parcel in) {
            return new LocationAndSpeed(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationAndSpeed[] newArray(int size) {
            return new LocationAndSpeed[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocationAndSpeed createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCATION_AND_SPEED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocationAndSpeed(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Instantaneous Speed
     */
    private final int mInstantaneousSpeed;

    /**
     * Total Distance
     */
    private final int mTotalDistance;

    /**
     * Location - Latitude
     */
    private final int mLocationLatitude;

    /**
     * Location - Longitude
     */
    private final int mLocationLongitude;

    /**
     * Elevation
     */
    private final int mElevation;

    /**
     * Heading
     */
    private final int mHeading;

    /**
     * Rolling Time
     */
    private final int mRollingTime;

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
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A67
     */
    public LocationAndSpeed(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 0;
        mFlags = Arrays.copyOfRange(values, index, index + 2);
        index += 2;
        if (isFlagsInstantaneousSpeedPresent()) {
            mInstantaneousSpeed = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mInstantaneousSpeed = 0;
        }
        if (isFlagsTotalDistancePresent()) {
            mTotalDistance = BLEUtils.createUInt24(values, index);
            index += 3;
        } else {
            mTotalDistance = 0;
        }
        if (isFlagsLocationPresent()) {
            mLocationLatitude = BLEUtils.createSInt32(values, index);
            index += 4;
            mLocationLongitude = BLEUtils.createSInt32(values, index);
            index += 4;
        } else {
            mLocationLatitude = 0;
            mLocationLongitude = 0;
        }
        if (isFlagsElevationPresent()) {
            mElevation = BLEUtils.createSInt24(values, index);
            index += 3;
        } else {
            mElevation = 0;
        }
        if (isFlagsHeadingPresent()) {
            mHeading = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mHeading = 0;
        }
        if (isFlagsRollingTimePresent()) {
            mRollingTime = (values[index++] & 0xff);
        } else {
            mRollingTime = 0;
        }
        if (isFlagsUtcTimePresent()) {
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
    private LocationAndSpeed(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mInstantaneousSpeed = in.readInt();
        mTotalDistance = in.readInt();
        mLocationLatitude = in.readInt();
        mLocationLongitude = in.readInt();
        mElevation = in.readInt();
        mHeading = in.readInt();
        mRollingTime = in.readInt();
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
        dest.writeInt(mInstantaneousSpeed);
        dest.writeInt(mTotalDistance);
        dest.writeInt(mLocationLatitude);
        dest.writeInt(mLocationLongitude);
        dest.writeInt(mElevation);
        dest.writeInt(mHeading);
        dest.writeInt(mRollingTime);
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
     * @return {@code true}:Instantaneous Speed not Present, {@code false}:Instantaneous Speed Present
     */
    public boolean isFlagsInstantaneousSpeedNotPresent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_SPEED_PRESENT_MASK, FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Instantaneous Speed Present, {@code false}:Instantaneous Speed not Present
     */
    public boolean isFlagsInstantaneousSpeedPresent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_SPEED_PRESENT_MASK, FLAGS_INSTANTANEOUS_SPEED_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Total Distance not Present, {@code false}:Total Distance Present
     */
    public boolean isFlagsTotalDistanceNotPresent() {
        return isFlagsMatched(FLAGS_TOTAL_DISTANCE_PRESENT_MASK, FLAGS_TOTAL_DISTANCE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Total Distance Present, {@code false}:Total Distance not Present
     */
    public boolean isFlagsTotalDistancePresent() {
        return isFlagsMatched(FLAGS_TOTAL_DISTANCE_PRESENT_MASK, FLAGS_TOTAL_DISTANCE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Location not Present, {@code false}:Location Present
     */
    public boolean isFlagsLocationNotPresent() {
        return isFlagsMatched(FLAGS_LOCATION_PRESENT_MASK, FLAGS_LOCATION_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Location Present, {@code false}:Location not Present
     */
    public boolean isFlagsLocationPresent() {
        return isFlagsMatched(FLAGS_LOCATION_PRESENT_MASK, FLAGS_LOCATION_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Elevation not Present, {@code false}:Elevation Present
     */
    public boolean isFlagsElevationNotPresent() {
        return isFlagsMatched(FLAGS_ELEVATION_PRESENT_MASK, FLAGS_ELEVATION_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Elevation Present, {@code false}:Elevation not Present
     */
    public boolean isFlagsElevationPresent() {
        return isFlagsMatched(FLAGS_ELEVATION_PRESENT_MASK, FLAGS_ELEVATION_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Heading not Present, {@code false}:Heading Present
     */
    public boolean isFlagsHeadingNotPresent() {
        return isFlagsMatched(FLAGS_HEADING_PRESENT_MASK, FLAGS_HEADING_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Heading Present, {@code false}:Heading not Present
     */
    public boolean isFlagsHeadingPresent() {
        return isFlagsMatched(FLAGS_HEADING_PRESENT_MASK, FLAGS_HEADING_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Rolling Time not Present, {@code false}:Rolling Time Present
     */
    public boolean isFlagsRollingTimeNotPresent() {
        return isFlagsMatched(FLAGS_ROLLING_TIME_PRESENT_MASK, FLAGS_ROLLING_TIME_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Rolling Time Present, {@code false}:Rolling Time not Present
     */
    public boolean isFlagsRollingTimePresent() {
        return isFlagsMatched(FLAGS_ROLLING_TIME_PRESENT_MASK, FLAGS_ROLLING_TIME_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:UTC Time not Present, {@code false}:UTC Time Present
     */
    public boolean isFlagsUtcTimeNotPresent() {
        return isFlagsMatched(FLAGS_UTC_TIME_PRESENT_MASK, FLAGS_UTC_TIME_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:UTC Time Present, {@code false}:UTC Time not Present
     */
    public boolean isFlagsUtcTimePresent() {
        return isFlagsMatched(FLAGS_UTC_TIME_PRESENT_MASK, FLAGS_UTC_TIME_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:No Position, {@code false}:not No Position
     */
    public boolean isFlagsPositionStatusNoPosition() {
        return isFlagsMatched(FLAGS_POSITION_SATUS_MASK, FLAGS_POSITION_SATUS_NO_POSITION);
    }

    /**
     * @return {@code true}:Position Ok, {@code false}:not Position Ok
     */
    public boolean isFlagsPositionStatusPositionOk() {
        return isFlagsMatched(FLAGS_POSITION_SATUS_MASK, FLAGS_POSITION_SATUS_POSITION_OK);
    }

    /**
     * @return {@code true}:Estimated Position, {@code false}:not Estimated Position
     */
    public boolean isFlagsPositionStatusEstimatedPosition() {
        return isFlagsMatched(FLAGS_POSITION_SATUS_MASK, FLAGS_POSITION_SATUS_ESTIMATED_POSITION);
    }

    /**
     * @return {@code true}:Last Known Position, {@code false}:not Last Known Position
     */
    public boolean isFlagsPositionStatusLastKnownPosition() {
        return isFlagsMatched(FLAGS_POSITION_SATUS_MASK, FLAGS_POSITION_SATUS_LAST_KNOWN_POSITION);
    }

    /**
     * @return {@code true}:2D, {@code false}:3D
     */
    public boolean isFlagsSpeedAndDistanceFormat2d() {
        return isFlagsMatched(FLAGS_SPEED_AND_DISTANCE_FORMAT_MASK, FLAGS_SPEED_AND_DISTANCE_FORMAT_2D);
    }

    /**
     * @return {@code true}:3D, {@code false}:2D
     */
    public boolean isFlagsSpeedAndDistanceFormat3d() {
        return isFlagsMatched(FLAGS_SPEED_AND_DISTANCE_FORMAT_MASK, FLAGS_SPEED_AND_DISTANCE_FORMAT_3D);
    }

    /**
     * @return {@code true}:Positioning System, {@code false}:not Positioning System
     */
    public boolean isFlagsElevationSourcePositionSystem() {
        return isFlagsMatched(FLAGS_ELEVATION_SOURCE_MASK, FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM);
    }

    /**
     * @return {@code true}:Barometric Air Pressure, {@code false}:not Barometric Air Pressure
     */
    public boolean isFlagsElevationSourceBarometricAirPressure() {
        return isFlagsMatched(FLAGS_ELEVATION_SOURCE_MASK, FLAGS_ELEVATION_SOURCE_BAROMETRIC_AIR_PRESSURE);
    }

    /**
     * @return {@code true}:Database Service, {@code false}:not Database Service
     */
    public boolean isFlagsElevationSourceDatabase() {
        return isFlagsMatched(FLAGS_ELEVATION_SOURCE_MASK, FLAGS_ELEVATION_SOURCE_DATABASE_SERVICE);
    }

    /**
     * @return {@code true}:Other, {@code false}:not Other
     */
    public boolean isFlagsElevationOther() {
        return isFlagsMatched(FLAGS_ELEVATION_SOURCE_MASK, FLAGS_ELEVATION_SOURCE_OTHER);
    }

    /**
     * @return {@code true}:Heading based on movement, {@code false}:Heading based on magnetic compass
     */
    public boolean isFlagsHeadingSourceHeadingBasedOnMovement() {
        return isFlagsMatched(FLAGS_HEADING_SOURCE_MASK, FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT);
    }

    /**
     * @return {@code true}:Heading based on magnetic compass, {@code false}:Heading based on movement
     */
    public boolean isFlagsHeadingSourceHeadingBasedOnMagneticCompass() {
        return isFlagsMatched(FLAGS_HEADING_SOURCE_MASK, FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS);
    }

    /**
     * @return Instantaneous Speed
     */
    public int getInstantaneousSpeed() {
        return mInstantaneousSpeed;
    }

    /**
     * @return Instantaneous Speed(meters)
     */
    public double getInstantaneousSpeedMeters() {
        return INSTANTANEOUS_SPEED_RESOLUTION * mInstantaneousSpeed;
    }

    /**
     * @return Total Distance
     */
    public int getTotalDistance() {
        return mTotalDistance;
    }


    /**
     * @return Total Distance(meters)
     */
    public double getTotalDistanceMeters() {
        return TOTAL_DISTANCE_RESOLUTION * mTotalDistance;
    }

    /**
     * @return Location - Latitude
     */
    public int getLocationLatitude() {
        return mLocationLatitude;
    }

    /**
     * @return Location - Latitude(degrees)
     */
    public double getLocationLatitudeDegrees() {
        return LOCATION_LATITUDE_RESOLUTION * mLocationLatitude;
    }

    /**
     * @return Location - Longitude
     */
    public int getLocationLongitude() {
        return mLocationLongitude;
    }

    /**
     * @return Location - Longitude(degrees)
     */
    public double getLocationLongitudeDegrees() {
        return LOCATION_LONGITUDE_RESOLUTION * mLocationLongitude;
    }

    /**
     * @return Elevation
     */
    public int getElevation() {
        return mElevation;
    }

    /**
     * @return Elevation(meters)
     */
    public double getElevationMeters() {
        return ELEVATION_RESOLUTION * mElevation;
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
     * @return Rolling Time
     */
    public int getRollingTime() {
        return mRollingTime;
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
        int length = 2;
        byte[] data = new byte[28];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        if (isFlagsInstantaneousSpeedPresent()) {
            byteBuffer.putShort((short) mInstantaneousSpeed);
            length += 2;
        }
        if (isFlagsTotalDistancePresent()) {
            byteBuffer.put((byte) mTotalDistance);
            byteBuffer.put((byte) (mTotalDistance >> 8));
            byteBuffer.put((byte) (mTotalDistance >> 16));
            length += 3;
        }
        if (isFlagsLocationPresent()) {
            byteBuffer.putInt(mLocationLatitude);
            byteBuffer.putInt(mLocationLongitude);
            length += 8;
        }
        if (isFlagsElevationPresent()) {
            byteBuffer.put((byte) mElevation);
            byteBuffer.put((byte) (mElevation >> 8));
            byteBuffer.put((byte) (mElevation >> 16));
            length += 3;
        }
        if (isFlagsHeadingPresent()) {
            byteBuffer.putShort((short) mHeading);
            length += 2;
        }
        if (isFlagsRollingTimePresent()) {
            byteBuffer.put((byte) mRollingTime);
            length++;
        }
        if (isFlagsUtcTimePresent()) {
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
     * @param expect one of {@link #FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE}
     *               , {@link #FLAGS_INSTANTANEOUS_SPEED_PRESENT_TRUE}
     *               , {@link #FLAGS_TOTAL_DISTANCE_PRESENT_FALSE}
     *               , {@link #FLAGS_TOTAL_DISTANCE_PRESENT_TRUE}
     *               , {@link #FLAGS_LOCATION_PRESENT_FALSE}
     *               , {@link #FLAGS_LOCATION_PRESENT_TRUE}
     *               , {@link #FLAGS_ELEVATION_PRESENT_FALSE}
     *               , {@link #FLAGS_ELEVATION_PRESENT_TRUE}
     *               , {@link #FLAGS_HEADING_PRESENT_FALSE}
     *               , {@link #FLAGS_HEADING_PRESENT_TRUE}
     *               , {@link #FLAGS_ROLLING_TIME_PRESENT_FALSE}
     *               , {@link #FLAGS_ROLLING_TIME_PRESENT_TRUE}
     *               , {@link #FLAGS_UTC_TIME_PRESENT_FALSE}
     *               , {@link #FLAGS_UTC_TIME_PRESENT_TRUE}
     *               , {@link #FLAGS_POSITION_SATUS_NO_POSITION}
     *               , {@link #FLAGS_POSITION_SATUS_POSITION_OK}
     *               , {@link #FLAGS_POSITION_SATUS_ESTIMATED_POSITION}
     *               , {@link #FLAGS_POSITION_SATUS_LAST_KNOWN_POSITION}
     *               , {@link #FLAGS_SPEED_AND_DISTANCE_FORMAT_2D}
     *               , {@link #FLAGS_SPEED_AND_DISTANCE_FORMAT_3D}
     *               , {@link #FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM}
     *               , {@link #FLAGS_ELEVATION_SOURCE_BAROMETRIC_AIR_PRESSURE}
     *               , {@link #FLAGS_ELEVATION_SOURCE_DATABASE_SERVICE}
     *               , {@link #FLAGS_ELEVATION_SOURCE_OTHER}
     *               , {@link #FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT}
     *               , {@link #FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mFlags, 0)) == expect;
    }

}
