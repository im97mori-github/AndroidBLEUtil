package org.im97mori.ble.characteristic.u2a21;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Measurement Interval (Characteristics UUID: 0x2A21)
 */
@SuppressWarnings({"WeakerAccess"})
public class MeasurementIntervalAndroid extends MeasurementInterval implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MeasurementIntervalAndroid> CREATOR = new ByteArrayCreator<MeasurementIntervalAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeasurementIntervalAndroid createFromParcel(@NonNull Parcel in) {
            return new MeasurementIntervalAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeasurementIntervalAndroid[] newArray(int size) {
            return new MeasurementIntervalAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MeasurementIntervalAndroid createFromByteArray(@NonNull byte[] values) {
            return new MeasurementIntervalAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A21
     */
    @Deprecated
    public MeasurementIntervalAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MeasurementIntervalAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param measurementInterval Measurement Interval
     */
    public MeasurementIntervalAndroid(int measurementInterval) {
        super(measurementInterval);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MeasurementIntervalAndroid(@NonNull Parcel in) {
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
