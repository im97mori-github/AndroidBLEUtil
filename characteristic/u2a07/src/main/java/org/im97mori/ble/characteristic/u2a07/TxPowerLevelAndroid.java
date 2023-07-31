package org.im97mori.ble.characteristic.u2a07;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Tx Power Level (Characteristics UUID: 0x2A07)
 */
@SuppressWarnings({"WeakerAccess"})
public class TxPowerLevelAndroid extends TxPowerLevel implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TxPowerLevelAndroid> CREATOR = new ByteArrayCreator<TxPowerLevelAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerLevelAndroid createFromParcel(@NonNull Parcel in) {
            return new TxPowerLevelAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerLevelAndroid[] newArray(int size) {
            return new TxPowerLevelAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TxPowerLevelAndroid createFromByteArray(@NonNull byte[] values) {
            return new TxPowerLevelAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A07
     */
    @Deprecated
    public TxPowerLevelAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TxPowerLevelAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param txPower Tx Power
     */
    public TxPowerLevelAndroid(int txPower) {
        super(txPower);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TxPowerLevelAndroid(@NonNull Parcel in) {
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
