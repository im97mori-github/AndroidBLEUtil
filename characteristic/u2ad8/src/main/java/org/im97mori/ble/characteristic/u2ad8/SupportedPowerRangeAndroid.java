package org.im97mori.ble.characteristic.u2ad8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Supported Power Range (Characteristics UUID: 0x2AD8)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedPowerRangeAndroid extends SupportedPowerRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SupportedPowerRangeAndroid> CREATOR = new ByteArrayCreator<SupportedPowerRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedPowerRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedPowerRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedPowerRangeAndroid[] newArray(int size) {
            return new SupportedPowerRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedPowerRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new SupportedPowerRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD8
     */
    @Deprecated
    public SupportedPowerRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SupportedPowerRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumPower     Minimum Power
     * @param maximumPower     Maximum Power
     * @param minimumIncrement Minimum Increment
     */
    public SupportedPowerRangeAndroid(int minimumPower, int maximumPower, int minimumIncrement) {
        super(minimumPower, maximumPower, minimumIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedPowerRangeAndroid(@NonNull Parcel in) {
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
