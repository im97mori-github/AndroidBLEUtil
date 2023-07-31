package org.im97mori.ble.characteristic.u2b92;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Change Log Data (Characteristics UUID: 0x2B92)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeChangeLogDataAndroid extends TimeChangeLogData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeChangeLogDataAndroid> CREATOR = new ByteArrayCreator<TimeChangeLogDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeChangeLogDataAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeChangeLogDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeChangeLogDataAndroid[] newArray(int size) {
            return new TimeChangeLogDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeChangeLogDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new TimeChangeLogDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B92
     */
    @Deprecated
    public TimeChangeLogDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeChangeLogDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeChangeLogDataAndroid(@NonNull Parcel in) {
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
