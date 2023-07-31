package org.im97mori.ble.characteristic.u2a0a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Day Date Time (Characteristics UUID: 0x2A0A)
 */
@SuppressWarnings({"WeakerAccess"})
public class DayDateTimeAndroid extends DayDateTime implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DayDateTimeAndroid> CREATOR = new ByteArrayCreator<DayDateTimeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DayDateTimeAndroid createFromParcel(@NonNull Parcel in) {
            return new DayDateTimeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DayDateTimeAndroid[] newArray(int size) {
            return new DayDateTimeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DayDateTimeAndroid createFromByteArray(@NonNull byte[] values) {
            return new DayDateTimeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0A
     */
    @Deprecated
    public DayDateTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DayDateTimeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param year      Year
     * @param month     Month
     * @param day       Day
     * @param hours     Hours
     * @param minutes   Minutes
     * @param seconds   Seconds
     * @param dayOfWeek Day of Week
     */
    public DayDateTimeAndroid(int year, int month, int day, int hours, int minutes, int seconds, int dayOfWeek) {
        super(year, month, day, hours, minutes, seconds, dayOfWeek);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DayDateTimeAndroid(@NonNull Parcel in) {
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
