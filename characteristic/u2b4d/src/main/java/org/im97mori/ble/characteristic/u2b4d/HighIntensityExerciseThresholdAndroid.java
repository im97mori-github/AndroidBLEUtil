package org.im97mori.ble.characteristic.u2b4d;

import static org.im97mori.ble.constants.CharacteristicUUID.HIGH_INTENSITY_EXERCISE_THRESHOLD_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * High Intensity Exercise Threshold (Characteristics UUID: 0x2B4D)
 */
@SuppressWarnings({"WeakerAccess"})
public class HighIntensityExerciseThresholdAndroid extends HighIntensityExerciseThreshold implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HighIntensityExerciseThresholdAndroid> CREATOR = new ByteArrayCreater<HighIntensityExerciseThresholdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighIntensityExerciseThresholdAndroid createFromParcel(@NonNull Parcel in) {
            return new HighIntensityExerciseThresholdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighIntensityExerciseThresholdAndroid[] newArray(int size) {
            return new HighIntensityExerciseThresholdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HighIntensityExerciseThresholdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HIGH_INTENSITY_EXERCISE_THRESHOLD_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4D
     */
    public HighIntensityExerciseThresholdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param fieldSelector                           Field Selector
     * @param thresholdAsEnergyExpenditurePerHour     Threshold as Energy
     *                                                Expenditure per Hour
     * @param thresholdAsMetabolicEquivalent          Threshold as Metabolic
     *                                                Equivalent
     * @param thresholdAsPercentageOfMaximumHeartRate Threshold as Percentage of
     *                                                Maximum Heart Rate
     * @param thresholdAsHeartRate                    Threshold as Heart Rate
     */
    public HighIntensityExerciseThresholdAndroid(int fieldSelector, int thresholdAsEnergyExpenditurePerHour,
                                                 int thresholdAsMetabolicEquivalent, int thresholdAsPercentageOfMaximumHeartRate, int thresholdAsHeartRate) {
        super(fieldSelector, thresholdAsEnergyExpenditurePerHour, thresholdAsMetabolicEquivalent, thresholdAsPercentageOfMaximumHeartRate, thresholdAsHeartRate);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HighIntensityExerciseThresholdAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
        dest.writeByteArray(getBytes());
    }

}
