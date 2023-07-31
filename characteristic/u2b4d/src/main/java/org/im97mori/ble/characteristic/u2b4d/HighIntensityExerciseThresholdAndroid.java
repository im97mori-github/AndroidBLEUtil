package org.im97mori.ble.characteristic.u2b4d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * High Intensity Exercise Threshold (Characteristics UUID: 0x2B4D)
 */
@SuppressWarnings({"WeakerAccess"})
public class HighIntensityExerciseThresholdAndroid extends HighIntensityExerciseThreshold implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HighIntensityExerciseThresholdAndroid> CREATOR = new ByteArrayCreator<HighIntensityExerciseThresholdAndroid>() {

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
            return new HighIntensityExerciseThresholdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4D
     */
    @Deprecated
    public HighIntensityExerciseThresholdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HighIntensityExerciseThresholdAndroid(@NonNull byte[] values) {
        super(values);
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
        super(Objects.requireNonNull(in.createByteArray()));
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
