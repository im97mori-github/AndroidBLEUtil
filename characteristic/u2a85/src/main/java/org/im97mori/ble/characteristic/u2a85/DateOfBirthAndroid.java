package org.im97mori.ble.characteristic.u2a85;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.DATE_OF_BIRTH_CHARACTERISTIC;

/**
 * Date of Birth (Characteristics UUID: 0x2A85)
 */
@SuppressWarnings({"WeakerAccess"})
public class DateOfBirthAndroid extends DateOfBirth implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DateOfBirthAndroid> CREATOR = new ByteArrayCreater<DateOfBirthAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DateOfBirthAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A85
     */
    public DateOfBirthAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
