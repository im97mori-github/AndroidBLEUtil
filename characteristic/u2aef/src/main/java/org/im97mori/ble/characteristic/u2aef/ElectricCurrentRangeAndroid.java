package org.im97mori.ble.characteristic.u2aef;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Electric Current Range (Characteristics UUID: 0x2AEF)
 */
@SuppressWarnings({"WeakerAccess"})
public class ElectricCurrentRangeAndroid extends ElectricCurrentRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ElectricCurrentRangeAndroid> CREATOR = new ByteArrayCreator<ElectricCurrentRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new ElectricCurrentRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentRangeAndroid[] newArray(int size) {
            return new ElectricCurrentRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ElectricCurrentRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new ElectricCurrentRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AEF
     */
    @Deprecated
    public ElectricCurrentRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ElectricCurrentRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumElectricCurrentValue Minimum Electric Current Value
     * @param maximumElectricCurrentValue Maximum Electric Current Value
     */
    public ElectricCurrentRangeAndroid(int minimumElectricCurrentValue, int maximumElectricCurrentValue) {
        super(minimumElectricCurrentValue, maximumElectricCurrentValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ElectricCurrentRangeAndroid(@NonNull Parcel in) {
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
