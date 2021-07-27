package org.im97mori.ble.characteristic.u2b10;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TEMPERATURE_RANGE_CHARACTERISTIC;

/**
 * Temperature Range (Characteristics UUID: 0x2B10)
 */
@SuppressWarnings({"WeakerAccess"})
public class TemperatureRangeAndroid extends TemperatureRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TemperatureRangeAndroid> CREATOR = new ByteArrayCreater<TemperatureRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new TemperatureRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureRangeAndroid[] newArray(int size) {
            return new TemperatureRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TemperatureRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B10
     */
    public TemperatureRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param minimumTemperature Minimum Temperature
     * @param maximumTemperature Maximum Temperature
     */
    public TemperatureRangeAndroid(int minimumTemperature, int maximumTemperature) {
        super(minimumTemperature, maximumTemperature);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TemperatureRangeAndroid(@NonNull Parcel in) {
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
