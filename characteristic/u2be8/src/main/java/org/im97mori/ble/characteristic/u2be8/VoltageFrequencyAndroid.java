package org.im97mori.ble.characteristic.u2be8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Voltage Frequency (Characteristics UUID: 0x2BE8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class VoltageFrequencyAndroid extends VoltageFrequency implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VoltageFrequencyAndroid> CREATOR = new ByteArrayCreator<VoltageFrequencyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageFrequencyAndroid createFromParcel(@NonNull Parcel in) {
            return new VoltageFrequencyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageFrequencyAndroid[] newArray(int size) {
            return new VoltageFrequencyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VoltageFrequencyAndroid createFromByteArray(@NonNull byte[] values) {
            return new VoltageFrequencyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE8
     */
    @Deprecated
    public VoltageFrequencyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public VoltageFrequencyAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VoltageFrequencyAndroid(@NonNull Parcel in) {
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
