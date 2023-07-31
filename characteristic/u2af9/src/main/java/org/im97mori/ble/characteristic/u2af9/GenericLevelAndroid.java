package org.im97mori.ble.characteristic.u2af9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Generic Level (Characteristics UUID: 0x2AF9)
 */
@SuppressWarnings({"WeakerAccess"})
public class GenericLevelAndroid extends GenericLevel implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<GenericLevelAndroid> CREATOR = new ByteArrayCreator<GenericLevelAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GenericLevelAndroid createFromParcel(@NonNull Parcel in) {
            return new GenericLevelAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GenericLevelAndroid[] newArray(int size) {
            return new GenericLevelAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GenericLevelAndroid createFromByteArray(@NonNull byte[] values) {
            return new GenericLevelAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF9
     */
    @Deprecated
    public GenericLevelAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public GenericLevelAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param genericLevel Generic Level
     */
    public GenericLevelAndroid(int genericLevel) {
        super(genericLevel);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GenericLevelAndroid(@NonNull Parcel in) {
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
