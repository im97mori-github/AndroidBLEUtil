package org.im97mori.ble.characteristic.u2a2b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Current Time (Characteristics UUID: 0x2A2B)
 */
@SuppressWarnings({"WeakerAccess"})
public class CurrentTimeAndroid extends CurrentTime implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CurrentTimeAndroid> CREATOR = new ByteArrayCreator<CurrentTimeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTimeAndroid createFromParcel(@NonNull Parcel in) {
            return new CurrentTimeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTimeAndroid[] newArray(int size) {
            return new CurrentTimeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CurrentTimeAndroid createFromByteArray(@NonNull byte[] values) {
            return new CurrentTimeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A2B
     */
    @Deprecated
    public CurrentTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CurrentTimeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param year         Year
     * @param month        Month
     * @param day          Day
     * @param hours        Hours
     * @param minutes      Minutes
     * @param seconds      Seconds
     * @param dayOfWeek    Day of Week
     * @param fractions256 Fractions256
     * @param adjustReason Adjust Reason
     */
    public CurrentTimeAndroid(int year, int month, int day, int hours, int minutes, int seconds, int dayOfWeek, int fractions256, int adjustReason) {
        super(year, month, day, hours, minutes, seconds, dayOfWeek, fractions256, adjustReason);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CurrentTimeAndroid(@NonNull Parcel in) {
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
