package org.im97mori.ble.characteristic.u2a53;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * RSC Measurement (Characteristics UUID: 0x2A53)
 */
@SuppressWarnings({"WeakerAccess"})
public class RSCMeasurementAndroid extends RSCMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RSCMeasurementAndroid> CREATOR = new ByteArrayCreator<RSCMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RSCMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new RSCMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RSCMeasurementAndroid[] newArray(int size) {
            return new RSCMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RSCMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new RSCMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A53
     */
    @Deprecated
    public RSCMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RSCMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                     Flags
     * @param instantaneousSpeed        Instantaneous Speed
     * @param instantaneousCadence      Instantaneous Cadence
     * @param instantaneousStrideLength Instantaneous Stride Length
     * @param totalDistance             Total Distance
     */
    public RSCMeasurementAndroid(int flags, int instantaneousSpeed, int instantaneousCadence, int instantaneousStrideLength, long totalDistance) {
        super(flags, instantaneousSpeed, instantaneousCadence, instantaneousStrideLength, totalDistance);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RSCMeasurementAndroid(@NonNull Parcel in) {
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
