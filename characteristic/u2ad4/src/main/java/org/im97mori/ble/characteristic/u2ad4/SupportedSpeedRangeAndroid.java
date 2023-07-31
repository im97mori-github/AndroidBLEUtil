package org.im97mori.ble.characteristic.u2ad4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Supported Speed Range (Characteristics UUID: 0x2AD4)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedSpeedRangeAndroid extends SupportedSpeedRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SupportedSpeedRangeAndroid> CREATOR = new ByteArrayCreator<SupportedSpeedRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedSpeedRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedSpeedRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedSpeedRangeAndroid[] newArray(int size) {
            return new SupportedSpeedRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedSpeedRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new SupportedSpeedRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD4
     */
    @Deprecated
    public SupportedSpeedRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SupportedSpeedRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumSpeed     Minimum Speed
     * @param maximumSpeed     Maximum Speed
     * @param minimumIncrement Minimum Increment
     */
    public SupportedSpeedRangeAndroid(int minimumSpeed, int maximumSpeed, int minimumIncrement) {
        super(minimumSpeed, maximumSpeed, minimumIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedSpeedRangeAndroid(@NonNull Parcel in) {
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
