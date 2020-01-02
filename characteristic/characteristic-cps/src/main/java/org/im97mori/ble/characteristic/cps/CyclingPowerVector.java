package org.im97mori.ble.characteristic.cps;

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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_VECTOR_CHARACTERISTIC;

/**
 * Cycling Power Vector (Characteristics UUID: 0x2A64)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CyclingPowerVector implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
     * @see #FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
     */
    public static final int FLAGS_CRANK_REVOLUTION_DATA_PRESENT_MASK = 0b00000001;

    /**
     * 0: Crank Revolution Data Present False
     */
    public static final int FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Crank Revolution Data Present True
     */
    public static final int FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE = 0b00000001;

    /**
     * @see #FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
     * @see #FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE
     */
    public static final int FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_MASK = 0b00000010;

    /**
     * 0: First Crank Measurement Angle Present False
     */
    public static final int FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE = 0b00000000;

    /**
     * 1: First Crank Measurement Angle Present True
     */
    public static final int FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE = 0b00000010;

    /**
     * @see #FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
     * @see #FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE
     */
    public static final int FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_MASK = 0b00000100;

    /**
     * 0: Instantaneous Force Magnitude Array Present False
     */
    public static final int FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Instantaneous Force Magnitude Array Present True
     */
    public static final int FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE = 0b00000100;

    /**
     * @see #FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
     * @see #FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE
     */
    public static final int FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_MASK = 0b00001000;

    /**
     * 0: Instantaneous Torque Magnitude Array Present False
     */
    public static final int FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Instantaneous Torque Magnitude Array Present True
     */
    public static final int FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE = 0b00001000;


    /**
     * @see #FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN
     * @see #FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_TANGENTIAL_COMPONENT
     * @see #FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_RADIAL_COMPONENT
     * @see #FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_LATERAL_COMPONENT
     */
    public static final int FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_MASK = 0b00110000;

    /**
     * 0: Instantaneous Measurement Direction Unknown
     */
    public static final int FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN = 0b00000000;

    /**
     * 1: Instantaneous Measurement Direction Tangential Component
     */
    public static final int FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_TANGENTIAL_COMPONENT = 0b00010000;

    /**
     * 2: Instantaneous Measurement Direction Radial Component
     */
    public static final int FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_RADIAL_COMPONENT = 0b00100000;

    /**
     * 3: Instantaneous Measurement Direction Lateral Component
     */
    public static final int FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_LATERAL_COMPONENT = 0b00110000;

    /**
     * Crank Revolution Data - Last Crank Event Time Unit 1/1024 seconds
     */
    public static final double CRANK_REVOLUTION_DATA_LAST_CRANK_EVENT_TIME_RESOLUTION = 1 / 1024d;

    /**
     * Instantaneous Torque Magnitude Array Unit 1/32 newton/meter
     */
    public static final double INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION = 1 / 32d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CyclingPowerVector> CREATOR = new ByteArrayCreater<CyclingPowerVector>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerVector createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerVector(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerVector[] newArray(int size) {
            return new CyclingPowerVector[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerVector createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CyclingPowerVector(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final int mFlags;

    /**
     * Crank Revolution Data - Cumulative Crank Revolutions
     */
    private final int mCrankRevolutionDataCumulativeCrankRevolutions;

    /**
     * Crank Revolution Data - Last Crank Event Time
     */
    private final int mCrankRevolutionDataLastCrankEventTime;

    /**
     * First Crank Measurement Angle
     */
    private final int mFirstCrankMeasurementAngle;

    /**
     * Instantaneous Force Magnitude Array
     */
    private final int[] mInstantaneousForceMagnitudeArray;

    /**
     * Instantaneous Torque Magnitude Array
     */
    private final int[] mInstantaneousTorqueMagnitudeArray;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A64
     */
    public CyclingPowerVector(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 0;
        mFlags = values[index++];
        if (isFlagsCrankRevolutionDataPresent()) {
            mCrankRevolutionDataCumulativeCrankRevolutions = BLEUtils.createUInt16(values, index);
            index += 2;
            mCrankRevolutionDataLastCrankEventTime = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mCrankRevolutionDataCumulativeCrankRevolutions = 0;
            mCrankRevolutionDataLastCrankEventTime = 0;
        }
        if (isFlagsFirstCrankMeasurementAnglePresent()) {
            mFirstCrankMeasurementAngle = BLEUtils.createUInt16(values, index);
            index += 2;
        } else {
            mFirstCrankMeasurementAngle = 0;
        }
        if (isFlagsInstantaneousForceMagnitudeArrayPresent()) {
            int count;
            if (isFlagsCrankRevolutionDataPresent()) {
                if (isFlagsFirstCrankMeasurementAnglePresent()) {
                    count = 6;
                } else {
                    count = 7;
                }
            } else {
                if (isFlagsFirstCrankMeasurementAnglePresent()) {
                    count = 8;
                } else {
                    count = 9;
                }
            }
            mInstantaneousForceMagnitudeArray = new int[count];
            for (int i = 0; i < count; i++) {
                mInstantaneousForceMagnitudeArray[i] = BLEUtils.createUInt16(values, index + i * 2);
            }
        } else {
            mInstantaneousForceMagnitudeArray = new int[0];
        }
        if (isFlagsInstantaneousTorqueMagnitudeArrayPresent()) {
            int count;
            if (isFlagsCrankRevolutionDataPresent()) {
                if (isFlagsFirstCrankMeasurementAnglePresent()) {
                    count = 6;
                } else {
                    count = 7;
                }
            } else {
                if (isFlagsFirstCrankMeasurementAnglePresent()) {
                    count = 8;
                } else {
                    count = 9;
                }
            }
            mInstantaneousTorqueMagnitudeArray = new int[count];
            for (int i = 0; i < count; i++) {
                mInstantaneousTorqueMagnitudeArray[i] = BLEUtils.createUInt16(values, index + i * 2);
            }
        } else {
            mInstantaneousTorqueMagnitudeArray = new int[0];
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CyclingPowerVector(@NonNull Parcel in) {
        mFlags = in.readInt();
        mCrankRevolutionDataCumulativeCrankRevolutions = in.readInt();
        mCrankRevolutionDataLastCrankEventTime = in.readInt();
        mFirstCrankMeasurementAngle = in.readInt();
        mInstantaneousForceMagnitudeArray = in.createIntArray();
        mInstantaneousTorqueMagnitudeArray = in.createIntArray();
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
        dest.writeInt(mFlags);
        dest.writeInt(mCrankRevolutionDataCumulativeCrankRevolutions);
        dest.writeInt(mCrankRevolutionDataLastCrankEventTime);
        dest.writeInt(mFirstCrankMeasurementAngle);
        dest.writeIntArray(mInstantaneousForceMagnitudeArray);
        dest.writeIntArray(mInstantaneousTorqueMagnitudeArray);
    }

    /**
     * @return Flags
     */
    public int getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:Crank Revolution Data not Present, {@code false}:Crank Revolution Data Present
     */
    public boolean isFlagsCrankRevolutionDataNotPresent() {
        return isFlagsMatched(FLAGS_CRANK_REVOLUTION_DATA_PRESENT_MASK, FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Crank Revolution Data Present, {@code false}:Crank Revolution Data not Present
     */
    public boolean isFlagsCrankRevolutionDataPresent() {
        return isFlagsMatched(FLAGS_CRANK_REVOLUTION_DATA_PRESENT_MASK, FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:First Crank Measurement Angle not Present, {@code false}:First Crank Measurement Angle Present
     */
    public boolean isFlagsFirstCrankMeasurementAngleNotPresent() {
        return isFlagsMatched(FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_MASK, FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:First Crank Measurement Angle Present, {@code false}:First Crank Measurement Angle not Present
     */
    public boolean isFlagsFirstCrankMeasurementAnglePresent() {
        return isFlagsMatched(FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_MASK, FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Instantaneous Force Magnitude Array not Present, {@code false}:Instantaneous Force Magnitude Array Present
     */
    public boolean isFlagsInstantaneousForceMagnitudeArrayNotPresent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_MASK, FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Instantaneous Force Magnitude Array Present, {@code false}:Instantaneous Force Magnitude Array not Present
     */
    public boolean isFlagsInstantaneousForceMagnitudeArrayPresent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_MASK, FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Instantaneous Torque Magnitude Array not Present, {@code false}:Instantaneous Torque Magnitude Array Present
     */
    public boolean isFlagsInstantaneousTorqueMagnitudeArrayNotPresent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_MASK, FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Instantaneous Torque Magnitude Array Present, {@code false}:Instantaneous Torque Magnitude Array not Present
     */
    public boolean isFlagsInstantaneousTorqueMagnitudeArrayPresent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_MASK, FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Instantaneous Measurement Direction Unknown, {@code false}:not Instantaneous Measurement Direction Unknown
     */
    public boolean isFlagsInstantaneousMeasurementDirectionUnknown() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_MASK, FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN);
    }

    /**
     * @return {@code true}:Instantaneous Measurement Direction Tangential Component, {@code false}:not Instantaneous Measurement Direction Tangential Component
     */
    public boolean isFlagsInstantaneousMeasurementDirectionTangentialComponent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_MASK, FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_TANGENTIAL_COMPONENT);
    }

    /**
     * @return {@code true}:Instantaneous Measurement Direction Lateral Component, {@code false}:not Instantaneous Measurement Direction Lateral Component
     */
    public boolean isFlagsInstantaneousMeasurementDirectionRadialComponent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_MASK, FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_RADIAL_COMPONENT);
    }

    /**
     * @return {@code true}:Lateral Component, {@code false}:not Lateral Component
     */
    public boolean isFlagsInstantaneousMeasurementDirectionLateralComponent() {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_MASK, FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_LATERAL_COMPONENT);
    }

    /**
     * @return Crank Revolution Data - Cumulative Crank Revolutions
     */
    public int getCrankRevolutionDataCumulativeCrankRevolutions() {
        return mCrankRevolutionDataCumulativeCrankRevolutions;
    }

    /**
     * @return Crank Revolution Data - Last Crank Event Time
     */
    public int getCrankRevolutionDataLastCrankEventTime() {
        return mCrankRevolutionDataLastCrankEventTime;
    }

    /**
     * @return Crank Revolution Data - Last Crank Event Time(seconds)
     */
    public double getCrankRevolutionDataLastCrankEventTimeSeconds() {
        return CRANK_REVOLUTION_DATA_LAST_CRANK_EVENT_TIME_RESOLUTION * mCrankRevolutionDataLastCrankEventTime;
    }

    /**
     * @return First Crank Measurement Angle
     */
    public int getFirstCrankMeasurementAngle() {
        return mFirstCrankMeasurementAngle;
    }

    /**
     * @return Instantaneous Force Magnitude Array
     */
    public int[] getInstantaneousForceMagnitudeArray() {
        return mInstantaneousForceMagnitudeArray;
    }

    /**
     * @param offset data offset
     * @return Instantaneous Force Magnitude
     */
    public int getInstantaneousForceMagnitude(int offset) {
        return mInstantaneousForceMagnitudeArray[offset];
    }

    /**
     * @return Instantaneous Torque Magnitude Array
     */
    public int[] getInstantaneousTorqueMagnitudeArray() {
        return mInstantaneousTorqueMagnitudeArray;
    }

    /**
     * @param offset data offset
     * @return Instantaneous Torque Magnitude
     */
    public int getInstantaneousTorqueMagnitude(int offset) {
        return mInstantaneousTorqueMagnitudeArray[offset];
    }

    /**
     * @param offset data offset
     * @return Instantaneous Torque Magnitude(newton/meter)
     */
    public double getInstantaneousTorqueMagnitudeNewtonMeter(int offset) {
        return INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * getInstantaneousTorqueMagnitude(offset);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[7 + mInstantaneousForceMagnitudeArray.length * 2 + mInstantaneousTorqueMagnitudeArray.length * 2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFlags);
        length++;
        if (isFlagsCrankRevolutionDataPresent()) {
            byteBuffer.putShort((short) mCrankRevolutionDataCumulativeCrankRevolutions);
            byteBuffer.putShort((short) mCrankRevolutionDataLastCrankEventTime);
            length += 4;
        }
        if (isFlagsFirstCrankMeasurementAnglePresent()) {
            byteBuffer.putShort((short) mFirstCrankMeasurementAngle);
            length += 2;
        }
        if (isFlagsInstantaneousForceMagnitudeArrayPresent()) {
            for (int instantaneousForceMagnitude : mInstantaneousForceMagnitudeArray) {
                byteBuffer.putShort((short) instantaneousForceMagnitude);
            }
            length += mInstantaneousForceMagnitudeArray.length * 2;
        }
        if (isFlagsInstantaneousTorqueMagnitudeArrayPresent()) {
            for (int instantaneousTorqueMagnitude : mInstantaneousTorqueMagnitudeArray) {
                byteBuffer.putShort((short) instantaneousTorqueMagnitude);
            }
            length += mInstantaneousTorqueMagnitudeArray.length * 2;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE}
     *               , {@link #FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE}
     *               , {@link #FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE}
     *               , {@link #FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE}
     *               , {@link #FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE}
     *               , {@link #FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE}
     *               , {@link #FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE}
     *               , {@link #FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE}
     *               , {@link #FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN}
     *               , {@link #FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_TANGENTIAL_COMPONENT}
     *               , {@link #FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_RADIAL_COMPONENT}
     *               , {@link #FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_LATERAL_COMPONENT}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & mFlags) == expect;
    }

}
