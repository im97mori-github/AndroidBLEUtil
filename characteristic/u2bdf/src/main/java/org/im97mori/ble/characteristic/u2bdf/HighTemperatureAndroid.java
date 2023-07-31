package org.im97mori.ble.characteristic.u2bdf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * High Temperature (Characteristics UUID: 0x2BDF)
 */
@SuppressWarnings({"WeakerAccess"})
public class HighTemperatureAndroid extends HighTemperature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HighTemperatureAndroid> CREATOR = new ByteArrayCreator<HighTemperatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighTemperatureAndroid createFromParcel(@NonNull Parcel in) {
            return new HighTemperatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighTemperatureAndroid[] newArray(int size) {
            return new HighTemperatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HighTemperatureAndroid createFromByteArray(@NonNull byte[] values) {
            return new HighTemperatureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BDF
     */
    @Deprecated
    public HighTemperatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HighTemperatureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param highTemperature High Temperature
     */
    public HighTemperatureAndroid(int highTemperature) {
        super(highTemperature);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HighTemperatureAndroid(@NonNull Parcel in) {
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
