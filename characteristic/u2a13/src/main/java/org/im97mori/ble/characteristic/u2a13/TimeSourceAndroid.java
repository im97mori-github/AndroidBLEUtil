package org.im97mori.ble.characteristic.u2a13;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Source (Characteristics UUID: 0x2A13)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeSourceAndroid extends TimeSource implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeSourceAndroid> CREATOR = new ByteArrayCreator<TimeSourceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSourceAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeSourceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSourceAndroid[] newArray(int size) {
            return new TimeSourceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeSourceAndroid createFromByteArray(@NonNull byte[] values) {
            return new TimeSourceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A13
     */
    @Deprecated
    public TimeSourceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeSourceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param timeSource Time Source
     */
    public TimeSourceAndroid(int timeSource) {
        super(timeSource);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeSourceAndroid(@NonNull Parcel in) {
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
