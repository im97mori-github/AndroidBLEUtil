package org.im97mori.ble.characteristic.u2a75;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Pollen Concentration (Characteristics UUID: 0x2A75)
 */
@SuppressWarnings({"WeakerAccess"})
public class PollenConcentrationAndroid extends PollenConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PollenConcentrationAndroid> CREATOR = new ByteArrayCreator<PollenConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PollenConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new PollenConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PollenConcentrationAndroid[] newArray(int size) {
            return new PollenConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PollenConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            return new PollenConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A75
     */
    @Deprecated
    public PollenConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PollenConcentrationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param pollenConcentration Pollen Concentration
     */
    public PollenConcentrationAndroid(int pollenConcentration) {
        super(pollenConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PollenConcentrationAndroid(@NonNull Parcel in) {
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
