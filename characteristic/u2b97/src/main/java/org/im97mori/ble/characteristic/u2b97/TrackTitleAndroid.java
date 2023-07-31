package org.im97mori.ble.characteristic.u2b97;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Track Title (Characteristics UUID: 0x2B97)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackTitleAndroid extends TrackTitle implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrackTitleAndroid> CREATOR = new ByteArrayCreator<TrackTitleAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackTitleAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackTitleAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackTitleAndroid[] newArray(int size) {
            return new TrackTitleAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackTitleAndroid createFromByteArray(@NonNull byte[] values) {
            return new TrackTitleAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B97
     */
    @Deprecated
    public TrackTitleAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TrackTitleAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackTitleAndroid(@NonNull Parcel in) {
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
