package org.im97mori.ble.characteristic.u2a76;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * UV Index (Characteristics UUID: 0x2A76)
 */
@SuppressWarnings({"WeakerAccess"})
public class UVIndexAndroid extends UVIndex implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<UVIndexAndroid> CREATOR = new ByteArrayCreator<UVIndexAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UVIndexAndroid createFromParcel(@NonNull Parcel in) {
            return new UVIndexAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UVIndexAndroid[] newArray(int size) {
            return new UVIndexAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UVIndexAndroid createFromByteArray(@NonNull byte[] values) {
            return new UVIndexAndroid(values);
        }

    };
    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A76
     */
    @Deprecated
    public UVIndexAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public UVIndexAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param UVIndex UV Index
     */
    public UVIndexAndroid(int UVIndex) {
        super(UVIndex);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UVIndexAndroid(@NonNull Parcel in) {
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
