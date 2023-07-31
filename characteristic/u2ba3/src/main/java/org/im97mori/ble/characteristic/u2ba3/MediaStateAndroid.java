package org.im97mori.ble.characteristic.u2ba3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Media State (Characteristics UUID: 0x2BA3)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MediaStateAndroid extends MediaState implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MediaStateAndroid> CREATOR = new ByteArrayCreator<MediaStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaStateAndroid createFromParcel(@NonNull Parcel in) {
            return new MediaStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaStateAndroid[] newArray(int size) {
            return new MediaStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MediaStateAndroid createFromByteArray(@NonNull byte[] values) {
            return new MediaStateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA3
     */
    @Deprecated
    public MediaStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MediaStateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MediaStateAndroid(@NonNull Parcel in) {
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
