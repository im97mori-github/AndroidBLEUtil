package org.im97mori.ble.characteristic.u2a03;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_ADDRESS_CHARACTERISTIC;

/**
 * Reconnection Address (Characteristics UUID: 0x2A03)
 */
@SuppressWarnings({"WeakerAccess"})
public class ReconnectionAddressAndroid extends ReconnectionAddress implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReconnectionAddressAndroid> CREATOR = new ByteArrayCreater<ReconnectionAddressAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_ADDRESS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ReconnectionAddressAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A03
     */
    public ReconnectionAddressAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
