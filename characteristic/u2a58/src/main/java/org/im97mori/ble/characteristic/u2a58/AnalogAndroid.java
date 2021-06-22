package org.im97mori.ble.characteristic.u2a58;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ANALOG_CHARACTERISTIC;

/**
 * Analog (Characteristics UUID: 0x2A58)
 */
@SuppressWarnings({"WeakerAccess"})
public class AnalogAndroid extends Analog implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AnalogAndroid> CREATOR = new ByteArrayCreater<AnalogAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnalogAndroid createFromParcel(@NonNull Parcel in) {
            return new AnalogAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnalogAndroid[] newArray(int size) {
            return new AnalogAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnalogAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ANALOG_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AnalogAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A58
     */
    public AnalogAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnalogAndroid(@NonNull Parcel in) {
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
