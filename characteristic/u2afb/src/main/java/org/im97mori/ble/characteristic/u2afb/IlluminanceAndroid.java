package org.im97mori.ble.characteristic.u2afb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Illuminance (Characteristics UUID: 0x2AFB)
 */
@SuppressWarnings({"WeakerAccess"})
public class IlluminanceAndroid extends Illuminance implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IlluminanceAndroid> CREATOR = new ByteArrayCreator<IlluminanceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IlluminanceAndroid createFromParcel(@NonNull Parcel in) {
            return new IlluminanceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IlluminanceAndroid[] newArray(int size) {
            return new IlluminanceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IlluminanceAndroid createFromByteArray(@NonNull byte[] values) {
            return new IlluminanceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFB
     */
    @Deprecated
    public IlluminanceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IlluminanceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param illuminance Illuminance
     */
    public IlluminanceAndroid(int illuminance) {
        super(illuminance);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IlluminanceAndroid(@NonNull Parcel in) {
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
