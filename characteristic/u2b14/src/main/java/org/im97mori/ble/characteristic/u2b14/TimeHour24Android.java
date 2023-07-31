package org.im97mori.ble.characteristic.u2b14;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Hour 24 (Characteristics UUID: 0x2B14)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeHour24Android extends TimeHour24 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeHour24Android> CREATOR = new ByteArrayCreator<TimeHour24Android>() {

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
            return new TimeHour24Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B14
     */
    @Deprecated
    public TimeHour24Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeHour24Android(@NonNull byte[] values) {
        super(values);
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
