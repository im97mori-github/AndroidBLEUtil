package org.im97mori.ble.characteristic.u2a29;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Manufacturer Name String (Characteristics UUID: 0x2A29)
 */
@SuppressWarnings({"WeakerAccess"})
public class ManufacturerNameStringAndroid extends ManufacturerNameString implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ManufacturerNameStringAndroid> CREATOR = new ByteArrayCreator<ManufacturerNameStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ManufacturerNameStringAndroid createFromParcel(@NonNull Parcel in) {
            return new ManufacturerNameStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ManufacturerNameStringAndroid[] newArray(int size) {
            return new ManufacturerNameStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ManufacturerNameStringAndroid createFromByteArray(@NonNull byte[] values) {
            return new ManufacturerNameStringAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A29
     */
    @Deprecated
    public ManufacturerNameStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ManufacturerNameStringAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param manufacturerName Manufacturer Name
     */
    public ManufacturerNameStringAndroid(@NonNull String manufacturerName) {
        super(manufacturerName);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ManufacturerNameStringAndroid(@NonNull Parcel in) {
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
