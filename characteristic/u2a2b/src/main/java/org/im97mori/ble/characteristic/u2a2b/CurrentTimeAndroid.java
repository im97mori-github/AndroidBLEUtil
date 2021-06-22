package org.im97mori.ble.characteristic.u2a2b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;

/**
 * Current Time (Characteristics UUID: 0x2A2B)
 */
@SuppressWarnings({"WeakerAccess"})
public class CurrentTimeAndroid extends CurrentTime implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CurrentTimeAndroid> CREATOR = new ByteArrayCreater<CurrentTimeAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CurrentTimeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A2B
     */
    public CurrentTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
