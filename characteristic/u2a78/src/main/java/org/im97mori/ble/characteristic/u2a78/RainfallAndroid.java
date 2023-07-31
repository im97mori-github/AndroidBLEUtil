package org.im97mori.ble.characteristic.u2a78;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Rainfall (Characteristics UUID: 0x2A78)
 */
@SuppressWarnings({"WeakerAccess"})
public class RainfallAndroid extends Rainfall implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RainfallAndroid> CREATOR = new ByteArrayCreator<RainfallAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RainfallAndroid createFromParcel(@NonNull Parcel in) {
            return new RainfallAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RainfallAndroid[] newArray(int size) {
            return new RainfallAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RainfallAndroid createFromByteArray(@NonNull byte[] values) {
            return new RainfallAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A78
     */
    @Deprecated
    public RainfallAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RainfallAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param rainfall Rainfall
     */
    public RainfallAndroid(int rainfall) {
        super(rainfall);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RainfallAndroid(@NonNull Parcel in) {
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
