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
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeHour_24Android extends TimeHour_24 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeHour_24Android> CREATOR = new ByteArrayCreater<TimeHour_24Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeHour_24Android createFromParcel(@NonNull Parcel in) {
            return new TimeHour_24Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeHour_24Android[] newArray(int size) {
            return new TimeHour_24Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeHour_24Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_HOUR_24_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeHour_24Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B14
     */
    public TimeHour_24Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeHour_24Android(@NonNull Parcel in) {
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
