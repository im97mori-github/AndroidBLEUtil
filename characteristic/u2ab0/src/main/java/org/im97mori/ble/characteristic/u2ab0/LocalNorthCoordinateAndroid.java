package org.im97mori.ble.characteristic.u2ab0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Local North Coordinate (Characteristics UUID: 0x2AB0)
 */
@SuppressWarnings({"WeakerAccess"})
public class LocalNorthCoordinateAndroid extends LocalNorthCoordinate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LocalNorthCoordinateAndroid> CREATOR = new ByteArrayCreator<LocalNorthCoordinateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalNorthCoordinateAndroid createFromParcel(@NonNull Parcel in) {
            return new LocalNorthCoordinateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalNorthCoordinateAndroid[] newArray(int size) {
            return new LocalNorthCoordinateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocalNorthCoordinateAndroid createFromByteArray(@NonNull byte[] values) {
            return new LocalNorthCoordinateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB0
     */
    @Deprecated
    public LocalNorthCoordinateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LocalNorthCoordinateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocalNorthCoordinateAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
    }

    /**
     * Constructor from parameters
     *
     * @param localNorthCoordinate Local North Coordinate
     */
    public LocalNorthCoordinateAndroid(int localNorthCoordinate) {
        super(localNorthCoordinate);
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
