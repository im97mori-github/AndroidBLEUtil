package org.im97mori.ble.characteristic.u2a64;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Cycling Power Vector (Characteristics UUID: 0x2A64)
 */
@SuppressWarnings({"WeakerAccess"})
public class CyclingPowerVectorAndroid extends CyclingPowerVector implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CyclingPowerVectorAndroid> CREATOR = new ByteArrayCreator<CyclingPowerVectorAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerVectorAndroid createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerVectorAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerVectorAndroid[] newArray(int size) {
            return new CyclingPowerVectorAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerVectorAndroid createFromByteArray(@NonNull byte[] values) {
            return new CyclingPowerVectorAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A64
     */
    @Deprecated
    public CyclingPowerVectorAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CyclingPowerVectorAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                                         Flags
     * @param crankRevolutionDataCumulativeCrankRevolutions Crank Revolution Data - Cumulative Crank Revolutions
     * @param crankRevolutionDataLastCrankEventTime         Crank Revolution Data - Last Crank Event Time
     * @param firstCrankMeasurementAngle                    First Crank Measurement Angle
     * @param instantaneousForceMagnitudeArray              Instantaneous Force Magnitude Array
     * @param instantaneousTorqueMagnitudeArray             Instantaneous Torque Magnitude Array
     */
    public CyclingPowerVectorAndroid(int flags, int crankRevolutionDataCumulativeCrankRevolutions, int crankRevolutionDataLastCrankEventTime, int firstCrankMeasurementAngle, @NonNull int[] instantaneousForceMagnitudeArray, @NonNull int[] instantaneousTorqueMagnitudeArray) {
        super(flags, crankRevolutionDataCumulativeCrankRevolutions, crankRevolutionDataLastCrankEventTime, firstCrankMeasurementAngle, instantaneousForceMagnitudeArray, instantaneousTorqueMagnitudeArray);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CyclingPowerVectorAndroid(@NonNull Parcel in) {
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
