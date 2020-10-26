package org.im97mori.ble.characteristic.u2a5d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;

/**
 * Sensor Location (Characteristics UUID: 0x2A5D)
 */
@SuppressWarnings({"WeakerAccess"})
public class SensorLocationAndroid extends SensorLocation implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SensorLocationAndroid> CREATOR = new ByteArrayCreater<SensorLocationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SensorLocationAndroid createFromParcel(@NonNull Parcel in) {
            return new SensorLocationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SensorLocationAndroid[] newArray(int size) {
            return new SensorLocationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SensorLocationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SensorLocationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5D
     */
    public SensorLocationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param sensorLocation Sensor Location
     */
    public SensorLocationAndroid(int sensorLocation) {
        super(sensorLocation);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SensorLocationAndroid(@NonNull Parcel in) {
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
