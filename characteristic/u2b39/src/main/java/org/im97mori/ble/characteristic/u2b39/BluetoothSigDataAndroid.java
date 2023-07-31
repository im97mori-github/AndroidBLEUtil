package org.im97mori.ble.characteristic.u2b39;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bluetooth SIG Data (Characteristics UUID: 0x2B39)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BluetoothSigDataAndroid extends BluetoothSigData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BluetoothSigDataAndroid> CREATOR = new ByteArrayCreator<BluetoothSigDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BluetoothSigDataAndroid createFromParcel(@NonNull Parcel in) {
            return new BluetoothSigDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BluetoothSigDataAndroid[] newArray(int size) {
            return new BluetoothSigDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BluetoothSigDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new BluetoothSigDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B39
     */
    @Deprecated
    public BluetoothSigDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BluetoothSigDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BluetoothSigDataAndroid(@NonNull Parcel in) {
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
