package org.im97mori.ble.characteristic.u2a1d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Temperature Type (Characteristics UUID: 0x2A1D)
 */
@SuppressWarnings({"WeakerAccess"})
public class TemperatureTypeAndroid extends TemperatureType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TemperatureTypeAndroid> CREATOR = new ByteArrayCreator<TemperatureTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new TemperatureTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureTypeAndroid[] newArray(int size) {
            return new TemperatureTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TemperatureTypeAndroid createFromByteArray(@NonNull byte[] values) {
            return new TemperatureTypeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A1D
     */
    @Deprecated
    public TemperatureTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TemperatureTypeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param temperatureTextDescription Temperature Text Description
     */
    public TemperatureTypeAndroid(int temperatureTextDescription) {
        super(temperatureTextDescription);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TemperatureTypeAndroid(@NonNull Parcel in) {
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
