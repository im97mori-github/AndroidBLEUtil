package org.im97mori.ble.characteristic.u2a85;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Date of Birth (Characteristics UUID: 0x2A85)
 */
@SuppressWarnings({"WeakerAccess"})
public class DateOfBirthAndroid extends DateOfBirth implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DateOfBirthAndroid> CREATOR = new ByteArrayCreator<DateOfBirthAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateOfBirthAndroid createFromParcel(@NonNull Parcel in) {
            return new DateOfBirthAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateOfBirthAndroid[] newArray(int size) {
            return new DateOfBirthAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DateOfBirthAndroid createFromByteArray(@NonNull byte[] values) {
            return new DateOfBirthAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A85
     */
    @Deprecated
    public DateOfBirthAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DateOfBirthAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param year  Year
     * @param month Month
     * @param day   Day
     */
    public DateOfBirthAndroid(int year, int month, int day) {
        super(year, month, day);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DateOfBirthAndroid(@NonNull Parcel in) {
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
