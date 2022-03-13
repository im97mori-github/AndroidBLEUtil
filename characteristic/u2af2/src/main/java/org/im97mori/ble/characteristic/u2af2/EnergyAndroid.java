package org.im97mori.ble.characteristic.u2af2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ENERGY_CHARACTERISTIC;

/**
 * Energy (Characteristics UUID: 0x2AF2)
 */
@SuppressWarnings({"WeakerAccess"})
public class EnergyAndroid extends Energy implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EnergyAndroid> CREATOR = new ByteArrayCreator<EnergyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnergyAndroid createFromParcel(@NonNull Parcel in) {
            return new EnergyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnergyAndroid[] newArray(int size) {
            return new EnergyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnergyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ENERGY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EnergyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF2
     */
    public EnergyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param energy Energy
     */
    public EnergyAndroid(int energy) {
        super(energy);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnergyAndroid(@NonNull Parcel in) {
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
