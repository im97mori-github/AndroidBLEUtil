package org.im97mori.ble.characteristic.u2aed;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Date UTC (Characteristics UUID: 0x2AED)
 */
@SuppressWarnings({"WeakerAccess"})
public class DateUtcAndroid extends DateUtc implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DateUtcAndroid> CREATOR = new ByteArrayCreator<DateUtcAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateUtcAndroid createFromParcel(@NonNull Parcel in) {
            return new DateUtcAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateUtcAndroid[] newArray(int size) {
            return new DateUtcAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DateUtcAndroid createFromByteArray(@NonNull byte[] values) {
            return new DateUtcAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AED
     */
    @Deprecated
    public DateUtcAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DateUtcAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param date Date
     */
    public DateUtcAndroid(int date) {
        super(date);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DateUtcAndroid(@NonNull Parcel in) {
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
