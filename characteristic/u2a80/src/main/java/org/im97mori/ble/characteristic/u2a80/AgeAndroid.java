package org.im97mori.ble.characteristic.u2a80;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Age (Characteristics UUID: 0x2A80)
 */
@SuppressWarnings({"WeakerAccess"})
public class AgeAndroid extends Age implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AgeAndroid> CREATOR = new ByteArrayCreator<AgeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AgeAndroid createFromParcel(@NonNull Parcel in) {
            return new AgeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AgeAndroid[] newArray(int size) {
            return new AgeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AgeAndroid createFromByteArray(@NonNull byte[] values) {
            return new AgeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A80
     */
    @Deprecated
    public AgeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AgeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param age Age
     */
    public AgeAndroid(int age) {
        super(age);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AgeAndroid(@NonNull Parcel in) {
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
