package org.im97mori.ble.characteristic.u2a25;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Serial Number String (Characteristics UUID: 0x2A25)
 */
@SuppressWarnings({"WeakerAccess"})
public class SerialNumberStringAndroid extends SerialNumberString implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SerialNumberStringAndroid> CREATOR = new ByteArrayCreator<SerialNumberStringAndroid>() {

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
            return new SerialNumberStringAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A25
     */
    @Deprecated
    public SerialNumberStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SerialNumberStringAndroid(@NonNull byte[] values) {
        super(values);
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
    private SerialNumberStringAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
