package org.im97mori.ble.characteristic.u2b11;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TEMPERATURE_STATISTICS_CHARACTERISTIC;

/**
 * Temperature Statistics (Characteristics UUID: 0x2B11)
 */
@SuppressWarnings({"WeakerAccess"})
public class TemperatureStatisticsAndroid extends TemperatureStatistics implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TemperatureStatisticsAndroid> CREATOR = new ByteArrayCreater<TemperatureStatisticsAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_STATISTICS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TemperatureStatisticsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B11
     */
    public TemperatureStatisticsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
        //noinspection ConstantConditions
        super(in.createByteArray());
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
