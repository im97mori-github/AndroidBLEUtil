package org.im97mori.ble.characteristic.u2a9d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_MEASUREMENT_CHARACTERISTIC;

/**
 * Weight Measurement (Characteristics UUID: 0x2A9D)
 */
@SuppressWarnings({"WeakerAccess"})
public class WeightMeasurementAndroid extends WeightMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<WeightMeasurementAndroid> CREATOR = new ByteArrayCreater<WeightMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new WeightMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightMeasurementAndroid[] newArray(int size) {
            return new WeightMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WeightMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WEIGHT_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WeightMeasurementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9D
     */
    public WeightMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param flags          Flags
     * @param weightSi       Weight - SI
     * @param weightImperial Weight - Imperial
     * @param year           Year
     * @param month          Month
     * @param day            Day
     * @param hours          Hours
     * @param minutes        Minutes
     * @param seconds        Seconds
     * @param userId         User ID
     * @param bmi            BMI
     * @param heightSi       Height - SI
     * @param heightImperial Height - Imperial
     */
    public WeightMeasurementAndroid(int flags, int weightSi, int weightImperial, int year, int month, int day, int hours, int minutes, int seconds, int userId, int bmi, int heightSi, int heightImperial) {
        super(flags, weightSi, weightImperial, year, month, day, hours, minutes, seconds, userId, bmi, heightSi, heightImperial);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WeightMeasurementAndroid(@NonNull Parcel in) {
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
