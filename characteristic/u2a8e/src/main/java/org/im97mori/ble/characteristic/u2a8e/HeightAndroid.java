package org.im97mori.ble.characteristic.u2a8e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Height (Characteristics UUID: 0x2A8E)
 */
@SuppressWarnings({"WeakerAccess"})
public class HeightAndroid extends Height implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HeightAndroid> CREATOR = new ByteArrayCreator<HeightAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeightAndroid createFromParcel(@NonNull Parcel in) {
            return new HeightAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeightAndroid[] newArray(int size) {
            return new HeightAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeightAndroid createFromByteArray(@NonNull byte[] values) {
            return new HeightAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8E
     */
    @Deprecated
    public HeightAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HeightAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param height Height
     */
    public HeightAndroid(int height) {
        super(height);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeightAndroid(@NonNull Parcel in) {
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
