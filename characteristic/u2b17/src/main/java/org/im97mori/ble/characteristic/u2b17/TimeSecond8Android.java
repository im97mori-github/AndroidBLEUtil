package org.im97mori.ble.characteristic.u2b17;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Second 8 (Characteristics UUID: 0x2B17)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeSecond8Android extends TimeSecond8 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeSecond8Android> CREATOR = new ByteArrayCreator<TimeSecond8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond8Android createFromParcel(@NonNull Parcel in) {
            return new TimeSecond8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond8Android[] newArray(int size) {
            return new TimeSecond8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeSecond8Android createFromByteArray(@NonNull byte[] values) {
            return new TimeSecond8Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B17
     */
    @Deprecated
    public TimeSecond8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeSecond8Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param timeSecond8 Time Second 8
     */
    public TimeSecond8Android(int timeSecond8) {
        super(timeSecond8);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeSecond8Android(@NonNull Parcel in) {
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
