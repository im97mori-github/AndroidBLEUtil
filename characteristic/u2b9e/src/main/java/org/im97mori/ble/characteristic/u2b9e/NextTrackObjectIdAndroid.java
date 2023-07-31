package org.im97mori.ble.characteristic.u2b9e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Next Track Object ID (Characteristics UUID: 0x2B9E)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class NextTrackObjectIdAndroid extends NextTrackObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<NextTrackObjectIdAndroid> CREATOR = new ByteArrayCreator<NextTrackObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NextTrackObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new NextTrackObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NextTrackObjectIdAndroid[] newArray(int size) {
            return new NextTrackObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NextTrackObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new NextTrackObjectIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9E
     */
    @Deprecated
    public NextTrackObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public NextTrackObjectIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NextTrackObjectIdAndroid(@NonNull Parcel in) {
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
