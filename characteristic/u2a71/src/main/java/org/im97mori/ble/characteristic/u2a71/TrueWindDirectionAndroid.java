package org.im97mori.ble.characteristic.u2a71;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * True Wind Direction (Characteristics UUID: 0x2A71)
 */
@SuppressWarnings({"WeakerAccess"})
public class TrueWindDirectionAndroid extends TrueWindDirection implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrueWindDirectionAndroid> CREATOR = new ByteArrayCreator<TrueWindDirectionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindDirectionAndroid createFromParcel(@NonNull Parcel in) {
            return new TrueWindDirectionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindDirectionAndroid[] newArray(int size) {
            return new TrueWindDirectionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrueWindDirectionAndroid createFromByteArray(@NonNull byte[] values) {
            return new TrueWindDirectionAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A71
     */
    @Deprecated
    public TrueWindDirectionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TrueWindDirectionAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param trueWindDirection True Wind Direction
     */
    public TrueWindDirectionAndroid(int trueWindDirection) {
        super(trueWindDirection);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrueWindDirectionAndroid(@NonNull Parcel in) {
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
