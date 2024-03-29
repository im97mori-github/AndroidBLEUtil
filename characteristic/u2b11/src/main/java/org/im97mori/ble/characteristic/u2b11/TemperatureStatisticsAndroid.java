package org.im97mori.ble.characteristic.u2b11;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Temperature Statistics (Characteristics UUID: 0x2B11)
 */
@SuppressWarnings({"WeakerAccess"})
public class TemperatureStatisticsAndroid extends TemperatureStatistics implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TemperatureStatisticsAndroid> CREATOR = new ByteArrayCreator<TemperatureStatisticsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureStatisticsAndroid createFromParcel(@NonNull Parcel in) {
            return new TemperatureStatisticsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureStatisticsAndroid[] newArray(int size) {
            return new TemperatureStatisticsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TemperatureStatisticsAndroid createFromByteArray(@NonNull byte[] values) {
            return new TemperatureStatisticsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B11
     */
    @Deprecated
    public TemperatureStatisticsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TemperatureStatisticsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param averageTemperature           Average Temperature
     * @param standardDeviationTemperature Standard Deviation Temperature
     * @param minimumTemperature           Minimum Temperature
     * @param maximumTemperature           Maximum Temperature
     * @param sensingDuration              Sensing Duration
     */
    public TemperatureStatisticsAndroid(int averageTemperature, int standardDeviationTemperature, int minimumTemperature, int maximumTemperature, int sensingDuration) {
        super(averageTemperature, standardDeviationTemperature, minimumTemperature, maximumTemperature, sensingDuration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TemperatureStatisticsAndroid(@NonNull Parcel in) {
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
