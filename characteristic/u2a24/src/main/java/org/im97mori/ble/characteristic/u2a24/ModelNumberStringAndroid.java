package org.im97mori.ble.characteristic.u2a24;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Model Number String (Characteristics UUID: 0x2A24)
 */
@SuppressWarnings({"WeakerAccess"})
public class ModelNumberStringAndroid extends ModelNumberString implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ModelNumberStringAndroid> CREATOR = new ByteArrayCreator<ModelNumberStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ModelNumberStringAndroid createFromParcel(@NonNull Parcel in) {
            return new ModelNumberStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ModelNumberStringAndroid[] newArray(int size) {
            return new ModelNumberStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ModelNumberStringAndroid createFromByteArray(@NonNull byte[] values) {
            return new ModelNumberStringAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A24
     */
    @Deprecated
    public ModelNumberStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ModelNumberStringAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param modelNumber Model Number
     */
    public ModelNumberStringAndroid(@NonNull String modelNumber) {
        super(modelNumber);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ModelNumberStringAndroid(@NonNull Parcel in) {
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
