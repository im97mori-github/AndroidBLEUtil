package org.im97mori.ble.characteristic.u2b01;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Luminous Intensity (Characteristics UUID: 0x2B01)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousIntensityAndroid extends LuminousIntensity implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LuminousIntensityAndroid> CREATOR = new ByteArrayCreator<LuminousIntensityAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousIntensityAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousIntensityAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousIntensityAndroid[] newArray(int size) {
            return new LuminousIntensityAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousIntensityAndroid createFromByteArray(@NonNull byte[] values) {
            return new LuminousIntensityAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B01
     */
    @Deprecated
    public LuminousIntensityAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LuminousIntensityAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param luminousIntensity Luminous Intensity
     */
    public LuminousIntensityAndroid(int luminousIntensity) {
        super(luminousIntensity);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousIntensityAndroid(@NonNull Parcel in) {
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
