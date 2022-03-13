package org.im97mori.ble.characteristic.u2b18;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.VOLTAGE_CHARACTERISTIC;

/**
 * Voltage (Characteristics UUID: 0x2B18)
 */
@SuppressWarnings({"WeakerAccess"})
public class VoltageAndroid extends Voltage implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VoltageAndroid> CREATOR = new ByteArrayCreator<VoltageAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageAndroid createFromParcel(@NonNull Parcel in) {
            return new VoltageAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageAndroid[] newArray(int size) {
            return new VoltageAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VoltageAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOLTAGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VoltageAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B18
     */
    public VoltageAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param voltageValue Voltage Value
     */
    public VoltageAndroid(int voltageValue) {
        super(voltageValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VoltageAndroid(@NonNull Parcel in) {
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
