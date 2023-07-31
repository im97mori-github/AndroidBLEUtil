package org.im97mori.ble.characteristic.u2a11;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time with DST (Characteristics UUID: 0x2A11)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeWithDstAndroid extends TimeWithDst implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeWithDstAndroid> CREATOR = new ByteArrayCreator<TimeWithDstAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeWithDstAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeWithDstAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeWithDstAndroid[] newArray(int size) {
            return new TimeWithDstAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeWithDstAndroid createFromByteArray(@NonNull byte[] values) {
            return new TimeWithDstAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A11
     */
    @Deprecated
    public TimeWithDstAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeWithDstAndroid(@NonNull byte[] values) {
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
     * @param dstOffset DST Offset
     */
    public TimeWithDstAndroid(int year, int month, int day, int hours, int minutes, int seconds, int dstOffset) {
        super(year, month, day, hours, minutes, seconds, dstOffset);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeWithDstAndroid(@NonNull Parcel in) {
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
