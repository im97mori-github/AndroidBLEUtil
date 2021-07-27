package org.im97mori.ble.characteristic.u2b14;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_HOUR_24_CHARACTERISTIC;

/**
 * Time Hour 24 (Characteristics UUID: 0x2B14)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeHour24Android extends TimeHour24 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeHour24Android> CREATOR = new ByteArrayCreater<TimeHour24Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeHour24Android createFromParcel(@NonNull Parcel in) {
            return new TimeHour24Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeHour24Android[] newArray(int size) {
            return new TimeHour24Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeHour24Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_HOUR_24_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeHour24Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B14
     */
    public TimeHour24Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param timeHour24 Time Hour 24
     */
    public TimeHour24Android(int timeHour24) {
        super(timeHour24);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeHour24Android(@NonNull Parcel in) {
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
