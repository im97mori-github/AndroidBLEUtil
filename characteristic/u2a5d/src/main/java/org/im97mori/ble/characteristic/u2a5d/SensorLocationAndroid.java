package org.im97mori.ble.characteristic.u2a5d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Sensor Location (Characteristics UUID: 0x2A5D)
 */
@SuppressWarnings({"WeakerAccess"})
public class SensorLocationAndroid extends SensorLocation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SensorLocationAndroid> CREATOR = new ByteArrayCreator<SensorLocationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SensorLocationAndroid createFromParcel(@NonNull Parcel in) {
            return new SensorLocationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SensorLocationAndroid[] newArray(int size) {
            return new SensorLocationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SensorLocationAndroid createFromByteArray(@NonNull byte[] values) {
            return new SensorLocationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5D
     */
    @Deprecated
    public SensorLocationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SensorLocationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param sensorLocation Sensor Location
     */
    public SensorLocationAndroid(int sensorLocation) {
        super(sensorLocation);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SensorLocationAndroid(@NonNull Parcel in) {
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
