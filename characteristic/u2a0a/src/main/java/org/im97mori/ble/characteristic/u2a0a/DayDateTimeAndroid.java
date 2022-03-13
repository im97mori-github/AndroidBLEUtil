package org.im97mori.ble.characteristic.u2a0a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.DAY_DATE_TIME_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DAY_DATE_TIME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DayDateTimeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0A
     */
    public DayDateTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
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
