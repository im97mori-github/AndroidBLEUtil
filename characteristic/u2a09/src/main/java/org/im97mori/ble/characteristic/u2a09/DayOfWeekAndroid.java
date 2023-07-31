package org.im97mori.ble.characteristic.u2a09;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Day of Week (Characteristics UUID: 0x2A09)
 */
@SuppressWarnings({"WeakerAccess"})
public class DayOfWeekAndroid extends DayOfWeek implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DayOfWeekAndroid> CREATOR = new ByteArrayCreator<DayOfWeekAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DayOfWeekAndroid createFromParcel(@NonNull Parcel in) {
            return new DayOfWeekAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DayOfWeekAndroid[] newArray(int size) {
            return new DayOfWeekAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DayOfWeekAndroid createFromByteArray(@NonNull byte[] values) {
            return new DayOfWeekAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A09
     */
    @Deprecated
    public DayOfWeekAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DayOfWeekAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param dayOfWeek   Day of Week
     */
    public DayOfWeekAndroid(int dayOfWeek) {
        super(dayOfWeek);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DayOfWeekAndroid(@NonNull Parcel in) {
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
