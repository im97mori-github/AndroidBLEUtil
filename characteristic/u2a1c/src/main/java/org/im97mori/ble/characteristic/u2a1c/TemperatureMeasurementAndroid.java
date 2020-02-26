package org.im97mori.ble.characteristic.u2a1c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_MEASUREMENT_CHARACTERISTIC;

/**
 * Temperature Measurement (Characteristics UUID: 0x2A1C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TemperatureMeasurementAndroid extends TemperatureMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TemperatureMeasurementAndroid> CREATOR = new ByteArrayCreater<TemperatureMeasurementAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TemperatureMeasurementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A1C
     */
    public TemperatureMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TemperatureMeasurementAndroid(@NonNull Parcel in) {
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
