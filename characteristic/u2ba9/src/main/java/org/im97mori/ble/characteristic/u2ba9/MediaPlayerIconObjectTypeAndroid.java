package org.im97mori.ble.characteristic.u2ba9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Media Player Icon Object Type (Characteristics UUID: 0x2BA9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MediaPlayerIconObjectTypeAndroid extends MediaPlayerIconObjectType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MediaPlayerIconObjectTypeAndroid> CREATOR = new ByteArrayCreator<MediaPlayerIconObjectTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaPlayerIconObjectTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new MediaPlayerIconObjectTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaPlayerIconObjectTypeAndroid[] newArray(int size) {
            return new MediaPlayerIconObjectTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MediaPlayerIconObjectTypeAndroid createFromByteArray(@NonNull byte[] values) {
            return new MediaPlayerIconObjectTypeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA9
     */
    @Deprecated
    public MediaPlayerIconObjectTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MediaPlayerIconObjectTypeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MediaPlayerIconObjectTypeAndroid(@NonNull Parcel in) {
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
