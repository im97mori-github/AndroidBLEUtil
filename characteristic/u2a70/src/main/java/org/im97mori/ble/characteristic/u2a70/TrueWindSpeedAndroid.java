package org.im97mori.ble.characteristic.u2a70;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * True Wind Speed (Characteristics UUID: 0x2A70)
 */
@SuppressWarnings({"WeakerAccess"})
public class TrueWindSpeedAndroid extends TrueWindSpeed implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrueWindSpeedAndroid> CREATOR = new ByteArrayCreator<TrueWindSpeedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindSpeedAndroid createFromParcel(@NonNull Parcel in) {
            return new TrueWindSpeedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindSpeedAndroid[] newArray(int size) {
            return new TrueWindSpeedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrueWindSpeedAndroid createFromByteArray(@NonNull byte[] values) {
            return new TrueWindSpeedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A70
     */
    @Deprecated
    public TrueWindSpeedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TrueWindSpeedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param trueWindSpeed True Wind Speed
     */
    public TrueWindSpeedAndroid(int trueWindSpeed) {
        super(trueWindSpeed);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrueWindSpeedAndroid(@NonNull Parcel in) {
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
