package org.im97mori.ble.characteristic.u2a16;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Update Control Point (Characteristics UUID: 0x2A16)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeUpdateControlPointAndroid extends TimeUpdateControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeUpdateControlPointAndroid> CREATOR = new ByteArrayCreator<TimeUpdateControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeUpdateControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateControlPointAndroid[] newArray(int size) {
            return new TimeUpdateControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeUpdateControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new TimeUpdateControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A16
     */
    @Deprecated
    public TimeUpdateControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeUpdateControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param timeUpdateControlPoint Time Update Control Point
     */
    public TimeUpdateControlPointAndroid(int timeUpdateControlPoint) {
        super(timeUpdateControlPoint);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeUpdateControlPointAndroid(@NonNull Parcel in) {
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
