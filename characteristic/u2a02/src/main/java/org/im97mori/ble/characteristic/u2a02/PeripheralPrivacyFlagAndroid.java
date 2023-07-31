package org.im97mori.ble.characteristic.u2a02;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Peripheral Privacy Flag (Characteristics UUID: 0x2A02)
 */
@SuppressWarnings({"WeakerAccess"})
public class PeripheralPrivacyFlagAndroid extends PeripheralPrivacyFlag implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PeripheralPrivacyFlagAndroid> CREATOR = new ByteArrayCreator<PeripheralPrivacyFlagAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPrivacyFlagAndroid createFromParcel(@NonNull Parcel in) {
            return new PeripheralPrivacyFlagAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPrivacyFlagAndroid[] newArray(int size) {
            return new PeripheralPrivacyFlagAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PeripheralPrivacyFlagAndroid createFromByteArray(@NonNull byte[] values) {
            return new PeripheralPrivacyFlagAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A02
     */
    @Deprecated
    public PeripheralPrivacyFlagAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PeripheralPrivacyFlagAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flag Flag
     */
    public PeripheralPrivacyFlagAndroid(int flag) {
        super(flag);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PeripheralPrivacyFlagAndroid(@NonNull Parcel in) {
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
