package org.im97mori.ble.characteristic.u2bc8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Broadcast Receive State (Characteristics UUID: 0x2BC8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BroadcastReceiveStateAndroid extends BroadcastReceiveState implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BroadcastReceiveStateAndroid> CREATOR = new ByteArrayCreator<BroadcastReceiveStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BroadcastReceiveStateAndroid createFromParcel(@NonNull Parcel in) {
            return new BroadcastReceiveStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BroadcastReceiveStateAndroid[] newArray(int size) {
            return new BroadcastReceiveStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BroadcastReceiveStateAndroid createFromByteArray(@NonNull byte[] values) {
            return new BroadcastReceiveStateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC8
     */
    @Deprecated
    public BroadcastReceiveStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BroadcastReceiveStateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BroadcastReceiveStateAndroid(@NonNull Parcel in) {
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
