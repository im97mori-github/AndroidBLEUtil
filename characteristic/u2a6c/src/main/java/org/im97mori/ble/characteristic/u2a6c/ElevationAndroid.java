package org.im97mori.ble.characteristic.u2a6c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Elevation (Characteristics UUID: 0x2A6C)
 */
@SuppressWarnings({"WeakerAccess"})
public class ElevationAndroid extends Elevation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ElevationAndroid> CREATOR = new ByteArrayCreator<ElevationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElevationAndroid createFromParcel(@NonNull Parcel in) {
            return new ElevationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElevationAndroid[] newArray(int size) {
            return new ElevationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ElevationAndroid createFromByteArray(@NonNull byte[] values) {
            return new ElevationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6C
     */
    @Deprecated
    public ElevationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ElevationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param elevation Elevation
     */
    public ElevationAndroid(int elevation) {
        super(elevation);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ElevationAndroid(@NonNull Parcel in) {
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
