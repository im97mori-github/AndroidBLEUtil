package org.im97mori.ble.characteristic.u2be8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.VOLTAGE_FREQUENCY_CHARACTERISTIC;

/**
 * Voltage Frequency (Characteristics UUID: 0x2BE8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class VoltageFrequencyAndroid extends VoltageFrequency implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VoltageFrequencyAndroid> CREATOR = new ByteArrayCreator<VoltageFrequencyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageFrequencyAndroid createFromParcel(@NonNull Parcel in) {
            return new VoltageFrequencyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageFrequencyAndroid[] newArray(int size) {
            return new VoltageFrequencyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VoltageFrequencyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOLTAGE_FREQUENCY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VoltageFrequencyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE8
     */
    public VoltageFrequencyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VoltageFrequencyAndroid(@NonNull Parcel in) {
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
