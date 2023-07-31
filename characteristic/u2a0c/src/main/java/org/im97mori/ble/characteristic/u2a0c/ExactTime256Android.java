package org.im97mori.ble.characteristic.u2a0c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Exact Time 256 (Characteristics UUID: 0x2A0C)
 */
@SuppressWarnings({"WeakerAccess"})
public class ExactTime256Android extends ExactTime256 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ExactTime256Android> CREATOR = new ByteArrayCreator<ExactTime256Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ExactTime256Android createFromParcel(@NonNull Parcel in) {
            return new ExactTime256Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ExactTime256Android[] newArray(int size) {
            return new ExactTime256Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ExactTime256Android createFromByteArray(@NonNull byte[] values) {
            return new ExactTime256Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0C
     */
    @Deprecated
    public ExactTime256Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ExactTime256Android(@NonNull byte[] values) {
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
     */
    public ExactTime256Android(int year, int month, int day, int hours, int minutes, int seconds, int dayOfWeek, int fractions256) {
        super(year, month, day, hours, minutes, seconds, dayOfWeek, fractions256);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ExactTime256Android(@NonNull Parcel in) {
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
