package org.im97mori.ble.characteristic.u2af0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Electric Current Specification (Characteristics UUID: 0x2AF0)
 */
@SuppressWarnings({"WeakerAccess"})
public class ElectricCurrentSpecificationAndroid extends ElectricCurrentSpecification implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ElectricCurrentSpecificationAndroid> CREATOR = new ByteArrayCreator<ElectricCurrentSpecificationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentSpecificationAndroid createFromParcel(@NonNull Parcel in) {
            return new ElectricCurrentSpecificationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentSpecificationAndroid[] newArray(int size) {
            return new ElectricCurrentSpecificationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ElectricCurrentSpecificationAndroid createFromByteArray(@NonNull byte[] values) {
            return new ElectricCurrentSpecificationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF0
     */
    @Deprecated
    public ElectricCurrentSpecificationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ElectricCurrentSpecificationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumElectricCurrentValue Minimum Electric Current Value
     * @param typicalElectricCurrentValue Typical Electric Current Value
     * @param maximumElectricCurrentValue Maximum Electric Current Value
     */
    public ElectricCurrentSpecificationAndroid(int minimumElectricCurrentValue, int typicalElectricCurrentValue, int maximumElectricCurrentValue) {
        super(minimumElectricCurrentValue, typicalElectricCurrentValue, maximumElectricCurrentValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ElectricCurrentSpecificationAndroid(@NonNull Parcel in) {
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
