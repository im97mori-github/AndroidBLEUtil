package org.im97mori.ble.characteristic.u2a07;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;

/**
 * Tx Power Level (Characteristics UUID: 0x2A07)
 */
@SuppressWarnings({"WeakerAccess"})
public class TxPowerLevelAndroid extends TxPowerLevel implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TxPowerLevelAndroid> CREATOR = new ByteArrayCreater<TxPowerLevelAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TxPowerLevelAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A07
     */
    public TxPowerLevelAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
