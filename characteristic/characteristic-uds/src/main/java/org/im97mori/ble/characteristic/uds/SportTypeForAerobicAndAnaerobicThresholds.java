package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;

/**
 * Sport Type for Aerobic and Anaerobic Thresholds (Characteristics UUID: 0x2A93)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SportTypeForAerobicAndAnaerobicThresholds implements ByteArrayInterface, Parcelable {

    /**
     * 0: Unspecified
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UNSPECIFIED = 0;

    /**
     * 1: Running (Treadmill)
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_RUNNING = 1;

    /**
     * 2: Cycling (Ergometer)
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CYCLING = 2;

    /**
     * 3: Rowing (Ergometer)
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_ROWING = 3;

    /**
     * 4: Cross Training (Elliptical)
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CROSS_TRAINING = 4;

    /**
     * 5: Climbing
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CLIMBING = 5;

    /**
     * 6: Skiing
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_SKIING = 6;

    /**
     * 7: Skating
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_SKATING = 7;

    /**
     * 8: Arm exercising
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_ARM_EXERCISING = 8;

    /**
     * 9: Lower body exercising
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_LOWER_BODY_EXERCISING = 9;

    /**
     * 10: Upper body exercising
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UPPER_BODY_EXERCISING = 10;

    /**
     * 11: Whole body exercising
     */
    public static final int SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_WHOLE_BODY_EXERCISING = 11;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SportTypeForAerobicAndAnaerobicThresholds> CREATOR = new ByteArrayCreater<SportTypeForAerobicAndAnaerobicThresholds>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholds createFromParcel(@NonNull Parcel in) {
            return new SportTypeForAerobicAndAnaerobicThresholds(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholds[] newArray(int size) {
            return new SportTypeForAerobicAndAnaerobicThresholds[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholds createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SportTypeForAerobicAndAnaerobicThresholds(bluetoothGattCharacteristic);
        }

    };

    /**
     * Sport Type for Aerobic and Anaerobic Thresholds
     */
    private final int mSportTypeForAerobicAndAnaerobicThresholds;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A93
     */
    public SportTypeForAerobicAndAnaerobicThresholds(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mSportTypeForAerobicAndAnaerobicThresholds = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SportTypeForAerobicAndAnaerobicThresholds(@NonNull Parcel in) {
        mSportTypeForAerobicAndAnaerobicThresholds = in.readInt();
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
        dest.writeInt(mSportTypeForAerobicAndAnaerobicThresholds);
    }

    /**
     * @return Sport Type for Aerobic and Anaerobic Thresholds
     */
    public int getSportTypeForAerobicAndAnaerobicThresholds() {
        return mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Unspecified, {@code false}:not Unspecified
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsUnspecified() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UNSPECIFIED == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Running, {@code false}:not Running
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsRunning() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_RUNNING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Cycling, {@code false}:not Cycling
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsCycling() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CYCLING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Rowing, {@code false}:not Rowing
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsRowing() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_ROWING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Cross Training, {@code false}:not Cross Training
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsCrossTraining() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CROSS_TRAINING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Climbing, {@code false}:not Climbing
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsClimbing() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CLIMBING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Skiing, {@code false}:not Skiing
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsSkiing() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_SKIING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Skating, {@code false}:not Skating
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsSkating() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_SKATING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Arm exercising, {@code false}:not Arm exercising
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsArmExercising() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_ARM_EXERCISING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Lower body exercising, {@code false}:not Lower body exercising
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsLowerBodyExercising() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_LOWER_BODY_EXERCISING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Upper body exercising, {@code false}:not Upper body exercising
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsUpperBodyExercising() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UPPER_BODY_EXERCISING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * @return {@code true}:Whole body exercising, {@code false}:not Whole body exercising
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsWholeBodyExercising() {
        return SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_WHOLE_BODY_EXERCISING == mSportTypeForAerobicAndAnaerobicThresholds;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mSportTypeForAerobicAndAnaerobicThresholds);
        return data;
    }

}
