package org.im97mori.ble.characteristic.u2b80;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Volume Offset State (Characteristics UUID: 0x2B80)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class VolumeOffsetStateAndroid extends VolumeOffsetState implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VolumeOffsetStateAndroid> CREATOR = new ByteArrayCreator<VolumeOffsetStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeOffsetStateAndroid createFromParcel(@NonNull Parcel in) {
            return new VolumeOffsetStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeOffsetStateAndroid[] newArray(int size) {
            return new VolumeOffsetStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VolumeOffsetStateAndroid createFromByteArray(@NonNull byte[] values) {
            return new VolumeOffsetStateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B80
     */
    @Deprecated
    public VolumeOffsetStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public VolumeOffsetStateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VolumeOffsetStateAndroid(@NonNull Parcel in) {
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
