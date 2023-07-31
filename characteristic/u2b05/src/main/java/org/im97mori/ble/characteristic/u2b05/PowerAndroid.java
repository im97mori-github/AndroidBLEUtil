package org.im97mori.ble.characteristic.u2b05;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Power (Characteristics UUID: 0x2B05)
 */
@SuppressWarnings({"WeakerAccess"})
public class PowerAndroid extends Power implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PowerAndroid> CREATOR = new ByteArrayCreator<PowerAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PowerAndroid createFromParcel(@NonNull Parcel in) {
            return new PowerAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PowerAndroid[] newArray(int size) {
            return new PowerAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PowerAndroid createFromByteArray(@NonNull byte[] values) {
            return new PowerAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B05
     */
    @Deprecated
    public PowerAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PowerAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param power Power
     */
    public PowerAndroid(int power) {
        super(power);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PowerAndroid(@NonNull Parcel in) {
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
