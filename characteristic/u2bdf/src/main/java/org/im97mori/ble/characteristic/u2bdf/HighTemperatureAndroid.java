package org.im97mori.ble.characteristic.u2bdf;

import static org.im97mori.ble.constants.CharacteristicUUID.HIGH_TEMPERATURE_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HIGH_TEMPERATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HighTemperatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BDF
     */
    public HighTemperatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
