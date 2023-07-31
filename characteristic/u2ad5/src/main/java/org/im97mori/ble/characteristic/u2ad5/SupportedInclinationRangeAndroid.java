package org.im97mori.ble.characteristic.u2ad5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Supported Inclination Range (Characteristics UUID: 0x2AD5)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedInclinationRangeAndroid extends SupportedInclinationRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SupportedInclinationRangeAndroid> CREATOR = new ByteArrayCreator<SupportedInclinationRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedInclinationRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedInclinationRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedInclinationRangeAndroid[] newArray(int size) {
            return new SupportedInclinationRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedInclinationRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new SupportedInclinationRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD5
     */
    @Deprecated
    public SupportedInclinationRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SupportedInclinationRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumInclination Minimum Inclination
     * @param maximumInclination Maximum Inclination
     * @param minimumIncrement   Minimum Increment
     */
    public SupportedInclinationRangeAndroid(int minimumInclination, int maximumInclination, int minimumIncrement) {
        super(minimumInclination, maximumInclination, minimumIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedInclinationRangeAndroid(@NonNull Parcel in) {
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
