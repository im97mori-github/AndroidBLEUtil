package org.im97mori.ble.characteristic.u2a36;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Intermediate Cuff Pressure (Characteristics UUID: 0x2A36)
 */
@SuppressWarnings({"WeakerAccess"})
public class IntermediateCuffPressureAndroid extends IntermediateCuffPressure implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IntermediateCuffPressureAndroid> CREATOR = new ByteArrayCreator<IntermediateCuffPressureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateCuffPressureAndroid createFromParcel(@NonNull Parcel in) {
            return new IntermediateCuffPressureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateCuffPressureAndroid[] newArray(int size) {
            return new IntermediateCuffPressureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IntermediateCuffPressureAndroid createFromByteArray(@NonNull byte[] values) {
            return new IntermediateCuffPressureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A36
     */
    @Deprecated
    public IntermediateCuffPressureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IntermediateCuffPressureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                                                           Flags
     * @param intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg    Intermediate
     *                                                                        Cuff
     *                                                                        Pressure
     *                                                                        Compound
     *                                                                        Value
     *                                                                        -
     *                                                                        Current
     *                                                                        Cuff
     *                                                                        Pressure
     *                                                                        (mmHg)
     * @param intermediateCuffPressureCompoundValueCurrentCuffPressureKpa     Intermediate
     *                                                                        Cuff
     *                                                                        Pressure
     *                                                                        Compound
     *                                                                        Value
     *                                                                        -
     *                                                                        Current
     *                                                                        Cuff
     *                                                                        Pressure
     *                                                                        (kPa)
     * @param intermediateCuffPressureCompoundValueDiastolicUnused            Intermediate
     *                                                                        Cuff
     *                                                                        Pressure
     *                                                                        Compound
     *                                                                        Value
     *                                                                        -
     *                                                                        Diastolic
     *                                                                        (unused)
     * @param intermediateCuffPressureCompoundValueMeanArterialPressureUnused Intermediate
     *                                                                        Cuff
     *                                                                        Pressure
     *                                                                        Compound
     *                                                                        Value
     *                                                                        - Mean
     *                                                                        Arterial
     *                                                                        Pressure
     *                                                                        (unused)
     * @param year                                                            Year
     * @param month                                                           Month
     * @param day                                                             Day
     * @param hours                                                           Hours
     * @param minutes                                                         Minutes
     * @param seconds                                                         Seconds
     * @param pulseRate                                                       Pulse
     *                                                                        Rate
     * @param userId                                                          User
     *                                                                        ID
     * @param measurementStatus                                               Measurement
     *                                                                        Status
     */
    public IntermediateCuffPressureAndroid(int flags,
                                    @NonNull IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg,
                                    @NonNull IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa,
                                    @NonNull IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused,
                                    @NonNull IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused, int year,
                                    int month, int day, int hours, int minutes, int seconds, IEEE_11073_20601_SFLOAT pulseRate, int userId,
                                    byte[] measurementStatus) {
        super(flags, intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg, intermediateCuffPressureCompoundValueCurrentCuffPressureKpa, intermediateCuffPressureCompoundValueDiastolicUnused, intermediateCuffPressureCompoundValueMeanArterialPressureUnused, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IntermediateCuffPressureAndroid(@NonNull Parcel in) {
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
