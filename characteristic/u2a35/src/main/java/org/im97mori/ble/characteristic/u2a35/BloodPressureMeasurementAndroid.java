package org.im97mori.ble.characteristic.u2a35;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Blood Pressure Measurement (Characteristics UUID: 0x2A35)
 */
@SuppressWarnings({"WeakerAccess"})
public class BloodPressureMeasurementAndroid extends BloodPressureMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BloodPressureMeasurementAndroid> CREATOR = new ByteArrayCreator<BloodPressureMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new BloodPressureMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureMeasurementAndroid[] newArray(int size) {
            return new BloodPressureMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BloodPressureMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new BloodPressureMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A35
     */
    @Deprecated
    public BloodPressureMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BloodPressureMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                                                         Flags
     * @param bloodPressureMeasurementCompoundValueSystolicMmhg             Blood Pressure Measurement Compound Value - Systolic (mmHg)
     * @param bloodPressureMeasurementCompoundValueDiastolicMmhg            Blood Pressure Measurement Compound Value - Diastolic (mmHg)
     * @param bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg Blood Pressure Measurement Compound Value - Mean Arterial Pressure (mmHg)
     * @param bloodPressureMeasurementCompoundValueSystolicKpa              Blood Pressure Measurement Compound Value - Systolic (kPa)
     * @param bloodPressureMeasurementCompoundValueDiastolicKpa             Blood Pressure Measurement Compound Value - Diastolic (kPa)
     * @param bloodPressureMeasurementCompoundValueMeanArterialPressureKpa  Blood Pressure Measurement Compound Value - Mean Arterial Pressure (kPa)
     * @param year                                                          Year
     * @param month                                                         Month
     * @param day                                                           Day
     * @param hours                                                         Hours
     * @param minutes                                                       Minutes
     * @param seconds                                                       Seconds
     * @param pulseRate                                                     Pulse Rate
     * @param userId                                                        User ID
     * @param measurementStatus                                             Measurement Status
     */
    public BloodPressureMeasurementAndroid(int flags, @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg, @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg, @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa, @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa, @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, int year, int month, int day, int hours, int minutes, int seconds, IEEE_11073_20601_SFLOAT pulseRate, int userId, byte[] measurementStatus) {
        super(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BloodPressureMeasurementAndroid(@NonNull Parcel in) {
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
