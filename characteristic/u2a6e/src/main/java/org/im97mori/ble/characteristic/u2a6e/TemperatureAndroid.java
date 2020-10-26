package org.im97mori.ble.characteristic.u2a6e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;

/**
 * Temperature (Characteristics UUID: 0x2A6E)
 */
@SuppressWarnings({"WeakerAccess"})
public class TemperatureAndroid extends Temperature implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TemperatureAndroid> CREATOR = new ByteArrayCreater<TemperatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureAndroid createFromParcel(@NonNull Parcel in) {
            return new TemperatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureAndroid[] newArray(int size) {
            return new TemperatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TemperatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TemperatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6E
     */
    public TemperatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param temperature Temperature
     */
    public TemperatureAndroid(int temperature) {
        super(temperature);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TemperatureAndroid(@NonNull Parcel in) {
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
