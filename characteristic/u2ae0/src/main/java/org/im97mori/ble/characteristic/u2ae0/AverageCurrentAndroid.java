package org.im97mori.ble.characteristic.u2ae0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Average Current (Characteristics UUID: 0x2AE0)
 */
@SuppressWarnings({"WeakerAccess"})
public class AverageCurrentAndroid extends AverageCurrent implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AverageCurrentAndroid> CREATOR = new ByteArrayCreator<AverageCurrentAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AverageCurrentAndroid createFromParcel(@NonNull Parcel in) {
            return new AverageCurrentAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AverageCurrentAndroid[] newArray(int size) {
            return new AverageCurrentAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AverageCurrentAndroid createFromByteArray(@NonNull byte[] values) {
            return new AverageCurrentAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE0
     */
    @Deprecated
    public AverageCurrentAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AverageCurrentAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param electricCurrentValue Electric Current Value
     * @param sensingDuration      Sensing Duration
     */
    public AverageCurrentAndroid(int electricCurrentValue, int sensingDuration) {
        super(electricCurrentValue, sensingDuration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AverageCurrentAndroid(@NonNull Parcel in) {
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
