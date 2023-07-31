package org.im97mori.ble.characteristic.u2b82;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Volume Offset Control Point (Characteristics UUID: 0x2B82)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class VolumeOffsetControlPointAndroid extends VolumeOffsetControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VolumeOffsetControlPointAndroid> CREATOR = new ByteArrayCreator<VolumeOffsetControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeOffsetControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new VolumeOffsetControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeOffsetControlPointAndroid[] newArray(int size) {
            return new VolumeOffsetControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VolumeOffsetControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new VolumeOffsetControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B82
     */
    @Deprecated
    public VolumeOffsetControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public VolumeOffsetControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VolumeOffsetControlPointAndroid(@NonNull Parcel in) {
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
