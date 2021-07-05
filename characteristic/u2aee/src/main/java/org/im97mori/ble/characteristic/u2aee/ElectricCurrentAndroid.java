package org.im97mori.ble.characteristic.u2aee;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ELECTRIC_CURRENT_CHARACTERISTIC;

/**
 * Electric Current (Characteristics UUID: 0x2AEE)
 */
@SuppressWarnings({"WeakerAccess"})
public class ElectricCurrentAndroid extends ElectricCurrent implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ElectricCurrentAndroid> CREATOR = new ByteArrayCreater<ElectricCurrentAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentAndroid createFromParcel(@NonNull Parcel in) {
            return new ElectricCurrentAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentAndroid[] newArray(int size) {
            return new ElectricCurrentAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ElectricCurrentAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELECTRIC_CURRENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AEE
     */
    public ElectricCurrentAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param current Current
     */
    public ElectricCurrentAndroid(int current) {
        super(current);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ElectricCurrentAndroid(@NonNull Parcel in) {
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
