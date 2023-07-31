package org.im97mori.ble.characteristic.u2b34;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Enhanced Blood Pressure Measurement (Characteristics UUID: 0x2B34)
 */
@SuppressWarnings({"WeakerAccess"})
public class EnhancedBloodPressureMeasurementAndroid extends EnhancedBloodPressureMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EnhancedBloodPressureMeasurementAndroid> CREATOR = new ByteArrayCreator<EnhancedBloodPressureMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnhancedBloodPressureMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new EnhancedBloodPressureMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnhancedBloodPressureMeasurementAndroid[] newArray(int size) {
            return new EnhancedBloodPressureMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnhancedBloodPressureMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new EnhancedBloodPressureMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B34
     */
    @Deprecated
    public EnhancedBloodPressureMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EnhancedBloodPressureMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                                                         Flags
     * @param bloodPressureMeasurementCompoundValueSystolicMmhg             Blood
     *                                                                      Pressure
     *                                                                      Measurement
     *                                                                      Compound
     *                                                                      Value -
     *                                                                      Systolic
     *                                                                      (mmHg)
     * @param bloodPressureMeasurementCompoundValueDiastolicMmhg            Blood
     *                                                                      Pressure
     *                                                                      Measurement
     *                                                                      Compound
     *                                                                      Value -
     *                                                                      Diastolic
     *                                                                      (mmHg)
     * @param bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg Blood
     *                                                                      Pressure
     *                                                                      Measurement
     *                                                                      Compound
     *                                                                      Value -
     *                                                                      Mean
     *                                                                      Arterial
     *                                                                      Pressure
     *                                                                      (mmHg)
     * @param bloodPressureMeasurementCompoundValueSystolicKpa              Blood
     *                                                                      Pressure
     *                                                                      Measurement
     *                                                                      Compound
     *                                                                      Value -
     *                                                                      Systolic
     *                                                                      (kPa)
     * @param bloodPressureMeasurementCompoundValueDiastolicKpa             Blood
     *                                                                      Pressure
     *                                                                      Measurement
     *                                                                      Compound
     *                                                                      Value -
     *                                                                      Diastolic
     *                                                                      (kPa)
     * @param bloodPressureMeasurementCompoundValueMeanArterialPressureKpa  Blood
     *                                                                      Pressure
     *                                                                      Measurement
     *                                                                      Compound
     *                                                                      Value -
     *                                                                      Mean
     *                                                                      Arterial
     *                                                                      Pressure
     *                                                                      (kPa)
     * @param timeStamp                                                     Time
     *                                                                      Stamp
     * @param pulseRate                                                     Pulse
     *                                                                      Rate
     * @param userId                                                        User ID
     * @param measurementStatus                                             Measurement
     *                                                                      Status
     * @param userFacingTime                                                User
     *                                                                      Facing
     */
    public EnhancedBloodPressureMeasurementAndroid(int flags,
                                                   @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg,
                                                   @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg,
                                                   @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg,
                                                   @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa,
                                                   @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa,
                                                   @NonNull IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa,
                                                   long timeStamp, @NonNull IEEE_11073_20601_SFLOAT pulseRate, int userId, @NonNull byte[] measurementStatus,
                                                   long userFacingTime) {
        super(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, timeStamp, pulseRate, userId, measurementStatus, userFacingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnhancedBloodPressureMeasurementAndroid(@NonNull Parcel in) {
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
