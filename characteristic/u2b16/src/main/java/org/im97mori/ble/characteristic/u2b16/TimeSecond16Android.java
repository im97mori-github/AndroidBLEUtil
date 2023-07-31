package org.im97mori.ble.characteristic.u2b16;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Second 16 (Characteristics UUID: 0x2B16)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeSecond16Android extends TimeSecond16 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeSecond16Android> CREATOR = new ByteArrayCreator<TimeSecond16Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond16Android createFromParcel(@NonNull Parcel in) {
            return new TimeSecond16Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond16Android[] newArray(int size) {
            return new TimeSecond16Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeSecond16Android createFromByteArray(@NonNull byte[] values) {
            return new TimeSecond16Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B16
     */
    @Deprecated
    public TimeSecond16Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeSecond16Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param timeSecond16 Time Second 16
     */
    public TimeSecond16Android(int timeSecond16) {
        super(timeSecond16);
    }


    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeSecond16Android(@NonNull Parcel in) {
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
