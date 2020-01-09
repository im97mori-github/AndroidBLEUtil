package org.im97mori.ble.characteristic.ftms;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRAINING_STATUS_CHARACTERISTIC;

/**
 * Training Status (Characteristics UUID: 0x2AD3)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TrainingStatus implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
     * @see #FLAGS_TRAINING_STATUS_STRING_PRESENT_TRUE
     */
    public static final int FLAGS_TRAINING_STATUS_STRING_PRESENT_MASK = 0b00000001;

    /**
     * 0: Training Status String present False
     */
    public static final int FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Training Status String present True
     */
    public static final int FLAGS_TRAINING_STATUS_STRING_PRESENT_TRUE = 0b00000001;

    /**
     * @see #FLAGS_EXTENDED_STRING_PRESENT_FALSE
     * @see #FLAGS_EXTENDED_STRING_PRESENT_TRUE
     */
    public static final int FLAGS_EXTENDED_STRING_PRESENT_MASK = 0b00000010;

    /**
     * 0: Extended String present False
     */
    public static final int FLAGS_EXTENDED_STRING_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Extended String present True
     */
    public static final int FLAGS_EXTENDED_STRING_PRESENT_TRUE = 0b00000010;

    /**
     * 0x00: Other
     */
    public static final int TRANING_STATUS_OTHER = 0x00;

    /**
     * 0x01: Idle
     */
    public static final int TRANING_STATUS_IDLE = 0x01;

    /**
     * 0x02: Warming Up
     */
    public static final int TRANING_STATUS_WARMING_UP = 0x02;

    /**
     * 0x03: Low Intensity Interval
     */
    public static final int TRANING_STATUS_LOW_INTENSITY_INTERVAL = 0x03;

    /**
     * 0x04: High Intensity Interval
     */
    public static final int TRANING_STATUS_HIGH_INTENSITY_INTERVAL = 0x04;

    /**
     * 0x05: Recovery Interval
     */
    public static final int TRANING_STATUS_RECOVERY_INTERVAL = 0x05;

    /**
     * 0x06: Isometric
     */
    public static final int TRANING_STATUS_ISOMETRIC = 0x06;

    /**
     * 0x07: Heart Rate Control
     */
    public static final int TRANING_STATUS_HEART_RATE_CONTROL = 0x07;

    /**
     * 0x08: Fitness Test
     */
    public static final int TRANING_STATUS_FITNESS_TEST = 0x08;

    /**
     * 0x09: Speed Outside of Control Region - Low (increase speed to return to controllable region)
     */
    public static final int TRANING_STATUS_SPEED_OUTSIDE_OF_CONTROL_REGION_LOW = 0x09;

    /**
     * 0x0A: Speed Outside of Control Region - High (decrease speed to return to controllable region)
     */
    public static final int TRANING_STATUS_SPEED_OUTSIDE_OF_CONTROL_REGION_HIGH = 0x0A;

    /**
     * 0x0B: Cool Down
     */
    public static final int TRANING_STATUS_COOL_DOWN = 0x0B;

    /**
     * 0x0C: Watt Control
     */
    public static final int TRANING_STATUS_WATT_CONTROL = 0x0C;

    /**
     * 0x0D: Manual Mode (Quick Start)
     */
    public static final int TRANING_STATUS_MANUAL_MODE = 0x0D;

    /**
     * 0x0E: Pre-Workout
     */
    public static final int TRANING_STATUS_PRE_WORKOUT = 0x0E;

    /**
     * 0x0F: Post-Workout
     */
    public static final int TRANING_STATUS_POST_WORKOUT = 0x0F;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TrainingStatus> CREATOR = new ByteArrayCreater<TrainingStatus>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrainingStatus createFromParcel(@NonNull Parcel in) {
            return new TrainingStatus(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrainingStatus[] newArray(int size) {
            return new TrainingStatus[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrainingStatus createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrainingStatus(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final int mFlags;

    /**
     * Training Status
     */
    private final int mTrainingStatus;

    /**
     * Training Status String
     */
    private final String mTrainingStatusString;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD3
     */
    public TrainingStatus(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFlags = values[0];
        mTrainingStatus = values[1];
        if (isFlagsTrainingStatusStringPresent()) {
            mTrainingStatusString = new String(values, 2, values.length - 2);
        } else {
            mTrainingStatusString = null;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrainingStatus(@NonNull Parcel in) {
        mFlags = in.readInt();
        mTrainingStatus = in.readInt();
        mTrainingStatusString = in.readString();
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
        dest.writeInt(mTrainingStatus);
        dest.writeString(mTrainingStatusString);
    }

    /**
     * @return Flags
     */
    public int getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:Training Status String not present, {@code false}:Training Status String present
     */
    public boolean isFlagsTrainingStatusStringNotPresent() {
        return isFlagsMatched(FLAGS_TRAINING_STATUS_STRING_PRESENT_MASK, FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Training Status String present, {@code false}:Training Status String not present
     */
    public boolean isFlagsTrainingStatusStringPresent() {
        return isFlagsMatched(FLAGS_TRAINING_STATUS_STRING_PRESENT_MASK, FLAGS_TRAINING_STATUS_STRING_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Extended String not present, {@code false}:Extended String present
     */
    public boolean isFlagsExtendedStringNotPresent() {
        return isFlagsMatched(FLAGS_EXTENDED_STRING_PRESENT_MASK, FLAGS_EXTENDED_STRING_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Extended String present, {@code false}:Extended String not present
     */
    public boolean isFlagsExtendedStringPresent() {
        return isFlagsMatched(FLAGS_EXTENDED_STRING_PRESENT_MASK, FLAGS_EXTENDED_STRING_PRESENT_TRUE);
    }

    /**
     * @return Training Status
     */
    public int getTrainingStatus() {
        return mTrainingStatus;
    }

    /**
     * @return {@code true}:Other, {@code false}:not Other
     */
    public boolean isTrainingStatusOhter() {
        return TRANING_STATUS_OTHER == mTrainingStatus;
    }

    /**
     * @return {@code true}:Idle, {@code false}:not Idle
     */
    public boolean isTrainingStatusIdle() {
        return TRANING_STATUS_IDLE == mTrainingStatus;
    }

    /**
     * @return {@code true}:Warming Up, {@code false}:not Warming Up
     */
    public boolean isTrainingStatusWarmingUp() {
        return TRANING_STATUS_WARMING_UP == mTrainingStatus;
    }

    /**
     * @return {@code true}:Low Intensity Interval, {@code false}:not Low Intensity Interval
     */
    public boolean isTrainingStatusLowIntensityInterval() {
        return TRANING_STATUS_LOW_INTENSITY_INTERVAL == mTrainingStatus;
    }

    /**
     * @return {@code true}:High Intensity Interval, {@code false}:not High Intensity Interval
     */
    public boolean isTrainingStatusHighIntensityInterval() {
        return TRANING_STATUS_HIGH_INTENSITY_INTERVAL == mTrainingStatus;
    }

    /**
     * @return {@code true}:Recovery Interval, {@code false}:not Recovery Interval
     */
    public boolean isTrainingStatusRecoveryInterval() {
        return TRANING_STATUS_RECOVERY_INTERVAL == mTrainingStatus;
    }

    /**
     * @return {@code true}:Isometric, {@code false}:not Isometric
     */
    public boolean isTrainingStatusIsometric() {
        return TRANING_STATUS_ISOMETRIC == mTrainingStatus;
    }

    /**
     * @return {@code true}:Heart Rate Control, {@code false}:not Heart Rate Control
     */
    public boolean isTrainingStatusHeartRateControl() {
        return TRANING_STATUS_HEART_RATE_CONTROL == mTrainingStatus;
    }

    /**
     * @return {@code true}:Fitness Test, {@code false}:not Fitness Test
     */
    public boolean isTrainingStatusFitnessTest() {
        return TRANING_STATUS_FITNESS_TEST == mTrainingStatus;
    }

    /**
     * @return {@code true}:Speed Outside of Control Region - Low, {@code false}:not Speed Outside of Control Region - Low
     */
    public boolean isTrainingStatusSpeedOutsideOfControlRegionLow() {
        return TRANING_STATUS_SPEED_OUTSIDE_OF_CONTROL_REGION_LOW == mTrainingStatus;
    }

    /**
     * @return {@code true}:Speed Outside of Control Region - High, {@code false}:not Speed Outside of Control Region - High
     */
    public boolean isTrainingStatusSpeedOutsideOfControlRegionHigh() {
        return TRANING_STATUS_SPEED_OUTSIDE_OF_CONTROL_REGION_HIGH == mTrainingStatus;
    }

    /**
     * @return {@code true}:Cool Down, {@code false}:not Cool Down
     */
    public boolean isTrainingStatusCoolDown() {
        return TRANING_STATUS_COOL_DOWN == mTrainingStatus;
    }

    /**
     * @return {@code true}:Watt Control, {@code false}:not Watt Control
     */
    public boolean isTrainingStatusWattControl() {
        return TRANING_STATUS_WATT_CONTROL == mTrainingStatus;
    }

    /**
     * @return {@code true}:Manual Mode, {@code false}:not Manual Mode
     */
    public boolean isTrainingStatusManualMode() {
        return TRANING_STATUS_MANUAL_MODE == mTrainingStatus;
    }

    /**
     * @return {@code true}:Pre-Workout, {@code false}:not Pre-Workout
     */
    public boolean isTrainingStatusPreWorkout() {
        return TRANING_STATUS_PRE_WORKOUT == mTrainingStatus;
    }

    /**
     * @return {@code true}:Post-Workout, {@code false}:not Post-Workout
     */
    public boolean isTrainingStatusPostWorkout() {
        return TRANING_STATUS_POST_WORKOUT == mTrainingStatus;
    }

    /**
     * @return Training Status String
     */
    @Nullable
    public String getTrainingStatusString() {
        return mTrainingStatusString;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2 + (mTrainingStatusString == null ? 0 : mTrainingStatusString.length())];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFlags);
        byteBuffer.put((byte) mTrainingStatus);
        if (mTrainingStatusString != null) {
            byteBuffer.put(mTrainingStatusString.getBytes());
        }
        return data;
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE}
     *               , {@link #FLAGS_TRAINING_STATUS_STRING_PRESENT_TRUE}
     *               , {@link #FLAGS_EXTENDED_STRING_PRESENT_FALSE}
     *               , {@link #FLAGS_EXTENDED_STRING_PRESENT_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & mFlags) == expect;
    }

}
