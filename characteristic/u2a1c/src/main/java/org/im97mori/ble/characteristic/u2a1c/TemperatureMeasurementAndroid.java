package org.im97mori.ble.characteristic.u2a1c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_FLOAT;

import java.util.Objects;

/**
 * Temperature Measurement (Characteristics UUID: 0x2A1C)
 */
@SuppressWarnings({"WeakerAccess"})
public class TemperatureMeasurementAndroid extends TemperatureMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TemperatureMeasurementAndroid> CREATOR = new ByteArrayCreator<TemperatureMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new TemperatureMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureMeasurementAndroid[] newArray(int size) {
            return new TemperatureMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TemperatureMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new TemperatureMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A1C
     */
    @Deprecated
    public TemperatureMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TemperatureMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                                 Flags
     * @param temperatureMeasurementValueCelsius    Temperature Measurement Value (Celsius)
     * @param temperatureMeasurementValueFahrenheit Temperature Measurement Value (Fahrenheit)
     * @param year                                  Year
     * @param month                                 Month
     * @param day                                   Day
     * @param hours                                 Hours
     * @param minutes                               Minutes
     * @param seconds                               Seconds
     * @param temperatureTextDescription            Temperature Text Description
     */
    public TemperatureMeasurementAndroid(int flags, double temperatureMeasurementValueCelsius, double temperatureMeasurementValueFahrenheit, int year, int month, int day, int hours, int minutes, int seconds, int temperatureTextDescription) {
        this(flags, new IEEE_11073_20601_FLOAT(temperatureMeasurementValueCelsius), new IEEE_11073_20601_FLOAT(temperatureMeasurementValueFahrenheit), year, month, day, hours, minutes, seconds, temperatureTextDescription);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                                 Flags
     * @param temperatureMeasurementValueCelsius    Temperature Measurement Value (Celsius)
     * @param temperatureMeasurementValueFahrenheit Temperature Measurement Value (Fahrenheit)
     * @param year                                  Year
     * @param month                                 Month
     * @param day                                   Day
     * @param hours                                 Hours
     * @param minutes                               Minutes
     * @param seconds                               Seconds
     * @param temperatureTextDescription            Temperature Text Description
     */
    public TemperatureMeasurementAndroid(int flags, IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius, IEEE_11073_20601_FLOAT temperatureMeasurementValueFahrenheit, int year, int month, int day, int hours, int minutes, int seconds, int temperatureTextDescription) {
        super(flags, temperatureMeasurementValueCelsius, temperatureMeasurementValueFahrenheit, year, month, day, hours, minutes, seconds, temperatureTextDescription);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TemperatureMeasurementAndroid(@NonNull Parcel in) {
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
