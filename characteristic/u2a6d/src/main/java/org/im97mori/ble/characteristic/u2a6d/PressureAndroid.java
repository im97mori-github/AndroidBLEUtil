package org.im97mori.ble.characteristic.u2a6d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;

/**
 * Pressure (Characteristics UUID: 0x2A6D)
 */
@SuppressWarnings({"WeakerAccess"})
public class PressureAndroid extends Pressure implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PressureAndroid> CREATOR = new ByteArrayCreator<PressureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PressureAndroid createFromParcel(@NonNull Parcel in) {
            return new PressureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PressureAndroid[] newArray(int size) {
            return new PressureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PressureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PressureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6D
     */
    public PressureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param pressure Pressure
     */
    public PressureAndroid(long pressure) {
        super(pressure);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PressureAndroid(@NonNull Parcel in) {
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
