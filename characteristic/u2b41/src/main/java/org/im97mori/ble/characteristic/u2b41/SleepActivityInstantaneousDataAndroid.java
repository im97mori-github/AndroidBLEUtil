package org.im97mori.ble.characteristic.u2b41;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Sleep Activity Instantaneous Data (Characteristics UUID: 0x2B41)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SleepActivityInstantaneousDataAndroid extends SleepActivityInstantaneousData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SleepActivityInstantaneousDataAndroid> CREATOR = new ByteArrayCreator<SleepActivityInstantaneousDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SleepActivityInstantaneousDataAndroid createFromParcel(@NonNull Parcel in) {
            return new SleepActivityInstantaneousDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SleepActivityInstantaneousDataAndroid[] newArray(int size) {
            return new SleepActivityInstantaneousDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SleepActivityInstantaneousDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new SleepActivityInstantaneousDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B41
     */
    @Deprecated
    public SleepActivityInstantaneousDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SleepActivityInstantaneousDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SleepActivityInstantaneousDataAndroid(@NonNull Parcel in) {
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
