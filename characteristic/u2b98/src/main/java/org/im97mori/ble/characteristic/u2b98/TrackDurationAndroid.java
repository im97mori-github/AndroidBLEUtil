package org.im97mori.ble.characteristic.u2b98;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Track Duration (Characteristics UUID: 0x2B98)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackDurationAndroid extends TrackDuration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrackDurationAndroid> CREATOR = new ByteArrayCreator<TrackDurationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackDurationAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackDurationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackDurationAndroid[] newArray(int size) {
            return new TrackDurationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackDurationAndroid createFromByteArray(@NonNull byte[] values) {
            return new TrackDurationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B98
     */
    @Deprecated
    public TrackDurationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TrackDurationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackDurationAndroid(@NonNull Parcel in) {
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
