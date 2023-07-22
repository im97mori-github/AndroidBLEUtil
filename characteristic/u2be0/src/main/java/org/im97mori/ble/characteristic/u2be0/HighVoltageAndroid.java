package org.im97mori.ble.characteristic.u2be0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.HIGH_VOLTAGE_CHARACTERISTIC;

/**
 * High Voltage (Characteristics UUID: 0x2BE0)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class HighVoltageAndroid extends HighVoltage implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HighVoltageAndroid> CREATOR = new ByteArrayCreator<HighVoltageAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighVoltageAndroid createFromParcel(@NonNull Parcel in) {
            return new HighVoltageAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighVoltageAndroid[] newArray(int size) {
            return new HighVoltageAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HighVoltageAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HIGH_VOLTAGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HighVoltageAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE0
     */
    public HighVoltageAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HighVoltageAndroid(@NonNull Parcel in) {
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
