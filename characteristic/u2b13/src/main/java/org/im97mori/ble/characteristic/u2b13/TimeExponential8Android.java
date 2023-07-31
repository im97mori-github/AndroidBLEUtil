package org.im97mori.ble.characteristic.u2b13;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Exponential 8 (Characteristics UUID: 0x2B13)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeExponential8Android extends TimeExponential8 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeExponential8Android> CREATOR = new ByteArrayCreator<TimeExponential8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeExponential8Android createFromParcel(@NonNull Parcel in) {
            return new TimeExponential8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeExponential8Android[] newArray(int size) {
            return new TimeExponential8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeExponential8Android createFromByteArray(@NonNull byte[] values) {
            return new TimeExponential8Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B13
     */
    @Deprecated
    public TimeExponential8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeExponential8Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param timeExponential8 Time Exponential 8
     */
    public TimeExponential8Android(int timeExponential8) {
        super(timeExponential8);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeExponential8Android(@NonNull Parcel in) {
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
