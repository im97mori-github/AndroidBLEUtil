package org.im97mori.ble.characteristic.u2b19;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Voltage Specification (Characteristics UUID: 0x2B19)
 */
@SuppressWarnings({"WeakerAccess"})
public class VoltageSpecificationAndroid extends VoltageSpecification implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VoltageSpecificationAndroid> CREATOR = new ByteArrayCreator<VoltageSpecificationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageSpecificationAndroid createFromParcel(@NonNull Parcel in) {
            return new VoltageSpecificationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageSpecificationAndroid[] newArray(int size) {
            return new VoltageSpecificationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VoltageSpecificationAndroid createFromByteArray(@NonNull byte[] values) {
            return new VoltageSpecificationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B19
     */
    @Deprecated
    public VoltageSpecificationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public VoltageSpecificationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumVoltageValue Minimum Voltage Value
     * @param typicalVoltageValue Typical Voltage Value
     * @param maximumVoltageValue Maximum Voltage Value
     */
    public VoltageSpecificationAndroid(int minimumVoltageValue, int typicalVoltageValue, int maximumVoltageValue) {
        super(minimumVoltageValue, typicalVoltageValue, maximumVoltageValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VoltageSpecificationAndroid(@NonNull Parcel in) {
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
