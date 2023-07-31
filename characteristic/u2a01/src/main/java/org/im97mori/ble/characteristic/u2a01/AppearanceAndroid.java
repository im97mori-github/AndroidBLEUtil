package org.im97mori.ble.characteristic.u2a01;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Appearance (Characteristics UUID: 0x2A01)
 */
@SuppressWarnings({"WeakerAccess"})
public class AppearanceAndroid extends Appearance implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AppearanceAndroid> CREATOR = new ByteArrayCreator<AppearanceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AppearanceAndroid createFromParcel(@NonNull Parcel in) {
            return new AppearanceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AppearanceAndroid[] newArray(int size) {
            return new AppearanceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AppearanceAndroid createFromByteArray(@NonNull byte[] values) {
            return new AppearanceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A01
     */
    @Deprecated
    public AppearanceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AppearanceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param appearanceValue Appearance Value
     */
    public AppearanceAndroid(int appearanceValue) {
        super(appearanceValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AppearanceAndroid(@NonNull Parcel in) {
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
