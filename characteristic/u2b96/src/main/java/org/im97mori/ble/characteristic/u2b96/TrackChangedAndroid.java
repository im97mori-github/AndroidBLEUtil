package org.im97mori.ble.characteristic.u2b96;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Track Changed (Characteristics UUID: 0x2B96)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackChangedAndroid extends TrackChanged implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrackChangedAndroid> CREATOR = new ByteArrayCreator<TrackChangedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackChangedAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackChangedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackChangedAndroid[] newArray(int size) {
            return new TrackChangedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackChangedAndroid createFromByteArray(@NonNull byte[] values) {
            return new TrackChangedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B96
     */
    @Deprecated
    public TrackChangedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TrackChangedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackChangedAndroid(@NonNull Parcel in) {
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
