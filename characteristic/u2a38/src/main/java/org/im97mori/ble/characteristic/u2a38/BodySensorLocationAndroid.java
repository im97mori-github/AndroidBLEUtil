package org.im97mori.ble.characteristic.u2a38;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BODY_SENSOR_LOCATION_CHARACTERISTIC;

/**
 * Body Sensor Location (Characteristics UUID: 0x2A38)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BodySensorLocationAndroid extends BodySensorLocation implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BodySensorLocationAndroid> CREATOR = new ByteArrayCreater<BodySensorLocationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodySensorLocationAndroid createFromParcel(@NonNull Parcel in) {
            return new BodySensorLocationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodySensorLocationAndroid[] newArray(int size) {
            return new BodySensorLocationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BodySensorLocationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BODY_SENSOR_LOCATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BodySensorLocationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A38
     */
    public BodySensorLocationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private BodySensorLocationAndroid(@NonNull Parcel in) {
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
