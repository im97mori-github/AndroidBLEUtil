package org.im97mori.ble.characteristic.u2bad;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Constant Tone Extension Enable (Characteristics UUID: 0x2BAD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ConstantToneExtensionEnableAndroid extends ConstantToneExtensionEnable implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ConstantToneExtensionEnableAndroid> CREATOR = new ByteArrayCreator<ConstantToneExtensionEnableAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ConstantToneExtensionEnableAndroid createFromParcel(@NonNull Parcel in) {
            return new ConstantToneExtensionEnableAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ConstantToneExtensionEnableAndroid[] newArray(int size) {
            return new ConstantToneExtensionEnableAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ConstantToneExtensionEnableAndroid createFromByteArray(@NonNull byte[] values) {
            return new ConstantToneExtensionEnableAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAD
     */
    @Deprecated
    public ConstantToneExtensionEnableAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ConstantToneExtensionEnableAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ConstantToneExtensionEnableAndroid(@NonNull Parcel in) {
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
