package org.im97mori.ble.characteristic.u2a25;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERIAL_NUMBER_STRING_CHARACTERISTIC;

/**
 * Serial Number String (Characteristics UUID: 0x2A25)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SerialNumberStringAndroid extends SerialNumberString implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SerialNumberStringAndroid> CREATOR = new ByteArrayCreater<SerialNumberStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SerialNumberStringAndroid createFromParcel(@NonNull Parcel in) {
            return new SerialNumberStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SerialNumberStringAndroid[] newArray(int size) {
            return new SerialNumberStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SerialNumberStringAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SerialNumberStringAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A25
     */
    public SerialNumberStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param serialNumber Serial Number
     */
    public SerialNumberStringAndroid(@NonNull String serialNumber) {
        super(serialNumber);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private SerialNumberStringAndroid(@NonNull Parcel in) {
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
