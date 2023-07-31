package org.im97mori.ble.characteristic.u2ae1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Average Voltage (Characteristics UUID: 0x2AE1)
 */
@SuppressWarnings({"WeakerAccess"})
public class AverageVoltageAndroid extends AverageVoltage implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AverageVoltageAndroid> CREATOR = new ByteArrayCreator<AverageVoltageAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AverageVoltageAndroid createFromParcel(@NonNull Parcel in) {
            return new AverageVoltageAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AverageVoltageAndroid[] newArray(int size) {
            return new AverageVoltageAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AverageVoltageAndroid createFromByteArray(@NonNull byte[] values) {
            return new AverageVoltageAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE1
     */
    @Deprecated
    public AverageVoltageAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AverageVoltageAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param voltageValue    Voltage Value
     * @param sensingDuration Sensing Duration
     */
    public AverageVoltageAndroid(int voltageValue, int sensingDuration) {
        super(voltageValue, sensingDuration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AverageVoltageAndroid(@NonNull Parcel in) {
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
