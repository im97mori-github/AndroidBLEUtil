package org.im97mori.ble.characteristic.u2a03;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Reconnection Address (Characteristics UUID: 0x2A03)
 */
@SuppressWarnings({"WeakerAccess"})
public class ReconnectionAddressAndroid extends ReconnectionAddress implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ReconnectionAddressAndroid> CREATOR = new ByteArrayCreator<ReconnectionAddressAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionAddressAndroid createFromParcel(@NonNull Parcel in) {
            return new ReconnectionAddressAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionAddressAndroid[] newArray(int size) {
            return new ReconnectionAddressAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReconnectionAddressAndroid createFromByteArray(@NonNull byte[] values) {
            return new ReconnectionAddressAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A03
     */
    @Deprecated
    public ReconnectionAddressAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ReconnectionAddressAndroid(@NonNull byte[] values) {
        super(values);
    }

    /***
     * Constructor from parameters
     *
     * @param address Address
     */
    public ReconnectionAddressAndroid(long address) {
        super(address);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReconnectionAddressAndroid(@NonNull Parcel in) {
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
