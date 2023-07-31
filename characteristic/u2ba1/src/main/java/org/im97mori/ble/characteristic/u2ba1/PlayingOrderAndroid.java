package org.im97mori.ble.characteristic.u2ba1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Playing Order (Characteristics UUID: 0x2BA1)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PlayingOrderAndroid extends PlayingOrder implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PlayingOrderAndroid> CREATOR = new ByteArrayCreator<PlayingOrderAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlayingOrderAndroid createFromParcel(@NonNull Parcel in) {
            return new PlayingOrderAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlayingOrderAndroid[] newArray(int size) {
            return new PlayingOrderAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PlayingOrderAndroid createFromByteArray(@NonNull byte[] values) {
            return new PlayingOrderAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA1
     */
    @Deprecated
    public PlayingOrderAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PlayingOrderAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PlayingOrderAndroid(@NonNull Parcel in) {
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
