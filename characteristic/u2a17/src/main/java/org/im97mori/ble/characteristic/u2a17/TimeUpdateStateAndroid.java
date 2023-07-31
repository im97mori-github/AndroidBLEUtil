package org.im97mori.ble.characteristic.u2a17;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Update State (Characteristics UUID: 0x2A17)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeUpdateStateAndroid extends TimeUpdateState implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeUpdateStateAndroid> CREATOR = new ByteArrayCreator<TimeUpdateStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateStateAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeUpdateStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateStateAndroid[] newArray(int size) {
            return new TimeUpdateStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeUpdateStateAndroid createFromByteArray(@NonNull byte[] values) {
            return new TimeUpdateStateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A17
     */
    @Deprecated
    public TimeUpdateStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeUpdateStateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param currentState Current State
     * @param result       Result
     */
    public TimeUpdateStateAndroid(int currentState, int result) {
        super(currentState, result);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeUpdateStateAndroid(@NonNull Parcel in) {
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
