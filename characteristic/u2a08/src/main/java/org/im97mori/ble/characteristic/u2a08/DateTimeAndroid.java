package org.im97mori.ble.characteristic.u2a08;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.DATE_TIME_CHARACTERISTIC;

/**
 * Date Time (Characteristics UUID: 0x2A08)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DateTimeAndroid extends DateTime implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DateTimeAndroid> CREATOR = new ByteArrayCreater<DateTimeAndroid>() {

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
