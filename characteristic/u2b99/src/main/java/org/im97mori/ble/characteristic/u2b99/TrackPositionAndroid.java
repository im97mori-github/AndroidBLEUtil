package org.im97mori.ble.characteristic.u2b99;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Track Position (Characteristics UUID: 0x2B99)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackPositionAndroid extends TrackPosition implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrackPositionAndroid> CREATOR = new ByteArrayCreator<TrackPositionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackPositionAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackPositionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackPositionAndroid[] newArray(int size) {
            return new TrackPositionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackPositionAndroid createFromByteArray(@NonNull byte[] values) {
            return new TrackPositionAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B99
     */
    @Deprecated
    public TrackPositionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TrackPositionAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackPositionAndroid(@NonNull Parcel in) {
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
