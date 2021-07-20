package org.im97mori.ble.characteristic.u2afd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.LUMINOUS_ENERGY_CHARACTERISTIC;

/**
 * Luminous Energy (Characteristics UUID: 0x2AFD)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousEnergyAndroid extends LuminousEnergy implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LuminousEnergyAndroid> CREATOR = new ByteArrayCreater<LuminousEnergyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousEnergyAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousEnergyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousEnergyAndroid[] newArray(int size) {
            return new LuminousEnergyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousEnergyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LUMINOUS_ENERGY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFD
     */
    public LuminousEnergyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param luminousEnergy Luminous Energy
     */
    public LuminousEnergyAndroid(int luminousEnergy) {
        super(luminousEnergy);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousEnergyAndroid(@NonNull Parcel in) {
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
