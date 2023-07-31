package org.im97mori.ble.characteristic.u2a12;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Accuracy (Characteristics UUID: 0x2A12)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeAccuracyAndroid extends TimeAccuracy implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeAccuracyAndroid> CREATOR = new ByteArrayCreator<TimeAccuracyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeAccuracyAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeAccuracyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeAccuracyAndroid[] newArray(int size) {
            return new TimeAccuracyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeAccuracyAndroid createFromByteArray(@NonNull byte[] values) {
            return new TimeAccuracyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A12
     */
    @Deprecated
    public TimeAccuracyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeAccuracyAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param accuracy Accuracy
     */
    public TimeAccuracyAndroid(int accuracy) {
        super(accuracy);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeAccuracyAndroid(@NonNull Parcel in) {
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
