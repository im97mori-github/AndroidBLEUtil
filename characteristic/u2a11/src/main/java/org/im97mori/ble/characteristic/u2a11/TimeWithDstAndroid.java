package org.im97mori.ble.characteristic.u2a11;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_WITH_DST_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_WITH_DST_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeWithDstAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A11
     */
    public TimeWithDstAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
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
