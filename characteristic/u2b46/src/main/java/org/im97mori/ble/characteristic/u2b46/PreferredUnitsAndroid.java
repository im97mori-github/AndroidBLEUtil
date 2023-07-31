package org.im97mori.ble.characteristic.u2b46;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;
import java.util.UUID;

/**
 * Preferred Units (Characteristics UUID: 0x2B46)
 */
@SuppressWarnings({"WeakerAccess"})
public class PreferredUnitsAndroid extends PreferredUnits implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PreferredUnitsAndroid> CREATOR = new ByteArrayCreator<PreferredUnitsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PreferredUnitsAndroid createFromParcel(@NonNull Parcel in) {
            return new PreferredUnitsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PreferredUnitsAndroid[] newArray(int size) {
            return new PreferredUnitsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PreferredUnitsAndroid createFromByteArray(@NonNull byte[] values) {
            return new PreferredUnitsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B46
     */
    @Deprecated
    public PreferredUnitsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PreferredUnitsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param units 128bit unit uuid
     */
    public PreferredUnitsAndroid(@NonNull UUID... units) {
        super(units);
    }

    /**
     * Constructor from parameters
     *
     * @param units 16bit unit uuid
     */
    public PreferredUnitsAndroid(@NonNull int... units) {
        super(units);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PreferredUnitsAndroid(@NonNull Parcel in) {
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
