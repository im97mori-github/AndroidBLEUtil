package org.im97mori.ble.characteristic.u2b85;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Coordinated Set Size (Characteristics UUID: 0x2B85)
 */
@SuppressWarnings({"WeakerAccess"})
public class CoordinatedSetSizeAndroid extends CoordinatedSetSize implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CoordinatedSetSizeAndroid> CREATOR = new ByteArrayCreator<CoordinatedSetSizeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CoordinatedSetSizeAndroid createFromParcel(@NonNull Parcel in) {
            return new CoordinatedSetSizeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CoordinatedSetSizeAndroid[] newArray(int size) {
            return new CoordinatedSetSizeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CoordinatedSetSizeAndroid createFromByteArray(@NonNull byte[] values) {
            return new CoordinatedSetSizeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B85
     */
    @Deprecated
    public CoordinatedSetSizeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CoordinatedSetSizeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param coordinatedSetSize Coordinated Set Size
     */
    public CoordinatedSetSizeAndroid(int coordinatedSetSize) {
        super(coordinatedSetSize);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CoordinatedSetSizeAndroid(@NonNull Parcel in) {
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
