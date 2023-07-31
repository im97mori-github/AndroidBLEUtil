package org.im97mori.ble.characteristic.u2b15;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Millisecond 24 (Characteristics UUID: 0x2B15)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeMillisecond24Android extends TimeMillisecond24 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeMillisecond24Android> CREATOR = new ByteArrayCreator<TimeMillisecond24Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeMillisecond24Android createFromParcel(@NonNull Parcel in) {
            return new TimeMillisecond24Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeMillisecond24Android[] newArray(int size) {
            return new TimeMillisecond24Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeMillisecond24Android createFromByteArray(@NonNull byte[] values) {
            return new TimeMillisecond24Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B15
     */
    @Deprecated
    public TimeMillisecond24Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeMillisecond24Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param timeMillisecond24 Time Millisecond 24
     */
    public TimeMillisecond24Android(int timeMillisecond24) {
        super(timeMillisecond24);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeMillisecond24Android(@NonNull Parcel in) {
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
