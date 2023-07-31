package org.im97mori.ble.characteristic.u2a7d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Descriptor Value Changed (Characteristics UUID: 0x2A7D)
 */
@SuppressWarnings({"WeakerAccess"})
public class DescriptorValueChangedAndroid extends DescriptorValueChanged implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DescriptorValueChangedAndroid> CREATOR = new ByteArrayCreator<DescriptorValueChangedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DescriptorValueChangedAndroid createFromParcel(@NonNull Parcel in) {
            return new DescriptorValueChangedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DescriptorValueChangedAndroid[] newArray(int size) {
            return new DescriptorValueChangedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DescriptorValueChangedAndroid createFromByteArray(@NonNull byte[] values) {
            return new DescriptorValueChangedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7D
     */
    @Deprecated
    public DescriptorValueChangedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DescriptorValueChangedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags              Flags
     * @param characteristicUUID Characteristic UUID
     */
    public DescriptorValueChangedAndroid(int flags, @NonNull byte[] characteristicUUID) {
        super(flags, characteristicUUID);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DescriptorValueChangedAndroid(@NonNull Parcel in) {
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
