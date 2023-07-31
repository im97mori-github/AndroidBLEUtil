package org.im97mori.ble.characteristic.u2a58;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Analog (Characteristics UUID: 0x2A58)
 */
@SuppressWarnings({"WeakerAccess"})
public class AnalogAndroid extends Analog implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AnalogAndroid> CREATOR = new ByteArrayCreator<AnalogAndroid>() {

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
            return new AnalogAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A58
     */
    @Deprecated
    public AnalogAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AnalogAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnalogAndroid(@NonNull Parcel in) {
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
