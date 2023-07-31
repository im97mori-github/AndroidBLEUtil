package org.im97mori.ble.characteristic.u2b9d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Current Track Object ID (Characteristics UUID: 0x2B9D)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CurrentTrackObjectIdAndroid extends CurrentTrackObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CurrentTrackObjectIdAndroid> CREATOR = new ByteArrayCreator<CurrentTrackObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTrackObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new CurrentTrackObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTrackObjectIdAndroid[] newArray(int size) {
            return new CurrentTrackObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CurrentTrackObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new CurrentTrackObjectIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9D
     */
    @Deprecated
    public CurrentTrackObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CurrentTrackObjectIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CurrentTrackObjectIdAndroid(@NonNull Parcel in) {
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
