package org.im97mori.ble.characteristic.u2be6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Second 32 (Characteristics UUID: 0x2BE6)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeSecond32Android extends TimeSecond32 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeSecond32Android> CREATOR = new ByteArrayCreator<TimeSecond32Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond32Android createFromParcel(@NonNull Parcel in) {
            return new TimeSecond32Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond32Android[] newArray(int size) {
            return new TimeSecond32Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeSecond32Android createFromByteArray(@NonNull byte[] values) {
            return new TimeSecond32Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE6
     */
    @Deprecated
    public TimeSecond32Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeSecond32Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeSecond32Android(@NonNull Parcel in) {
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
