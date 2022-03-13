package org.im97mori.ble.characteristic.u2a08;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.DATE_TIME_CHARACTERISTIC;

/**
 * Date Time (Characteristics UUID: 0x2A08)
 */
@SuppressWarnings({"WeakerAccess"})
public class DateTimeAndroid extends DateTime implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DateTimeAndroid> CREATOR = new ByteArrayCreator<DateTimeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateTimeAndroid createFromParcel(@NonNull Parcel in) {
            return new DateTimeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateTimeAndroid[] newArray(int size) {
            return new DateTimeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DateTimeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATE_TIME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DateTimeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A08
     */
    public DateTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
     */
    public DateTimeAndroid(int year, int month, int day, int hours, int minutes, int seconds) {
        super(year, month, day, hours, minutes, seconds);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DateTimeAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
