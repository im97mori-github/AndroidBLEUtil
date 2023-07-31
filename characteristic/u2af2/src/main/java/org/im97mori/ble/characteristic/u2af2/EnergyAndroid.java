package org.im97mori.ble.characteristic.u2af2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

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
            return new EnergyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF2
     */
    @Deprecated
    public EnergyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EnergyAndroid(@NonNull byte[] values) {
        super(values);
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
