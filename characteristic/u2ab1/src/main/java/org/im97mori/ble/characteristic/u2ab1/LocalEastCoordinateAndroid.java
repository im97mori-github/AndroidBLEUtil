package org.im97mori.ble.characteristic.u2ab1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Local East Coordinate (Characteristics UUID: 0x2AB1)
 */
@SuppressWarnings({"WeakerAccess"})
public class LocalEastCoordinateAndroid extends LocalEastCoordinate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LocalEastCoordinateAndroid> CREATOR = new ByteArrayCreator<LocalEastCoordinateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalEastCoordinateAndroid createFromParcel(@NonNull Parcel in) {
            return new LocalEastCoordinateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalEastCoordinateAndroid[] newArray(int size) {
            return new LocalEastCoordinateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocalEastCoordinateAndroid createFromByteArray(@NonNull byte[] values) {
            return new LocalEastCoordinateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB1
     */
    @Deprecated
    public LocalEastCoordinateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LocalEastCoordinateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param localEastCoordinate Local East Coordinate
     */
    public LocalEastCoordinateAndroid(int localEastCoordinate) {
        super(localEastCoordinate);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocalEastCoordinateAndroid(@NonNull Parcel in) {
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
