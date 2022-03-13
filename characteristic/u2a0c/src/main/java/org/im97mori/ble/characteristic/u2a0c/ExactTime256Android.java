package org.im97mori.ble.characteristic.u2a0c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.EXACT_TIME_256_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(EXACT_TIME_256_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ExactTime256Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0C
     */
    public ExactTime256Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
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
