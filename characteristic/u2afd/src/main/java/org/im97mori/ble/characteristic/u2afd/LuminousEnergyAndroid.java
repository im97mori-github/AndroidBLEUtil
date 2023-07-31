package org.im97mori.ble.characteristic.u2afd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Luminous Energy (Characteristics UUID: 0x2AFD)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousEnergyAndroid extends LuminousEnergy implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LuminousEnergyAndroid> CREATOR = new ByteArrayCreator<LuminousEnergyAndroid>() {

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
            return new LuminousEnergyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFD
     */
    @Deprecated
    public LuminousEnergyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LuminousEnergyAndroid(@NonNull byte[] values) {
        super(values);
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
