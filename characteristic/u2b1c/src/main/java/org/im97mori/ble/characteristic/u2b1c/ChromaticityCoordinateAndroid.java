package org.im97mori.ble.characteristic.u2b1c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Chromaticity Coordinate (Characteristics UUID: 0x2B1C)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticityCoordinateAndroid extends ChromaticityCoordinate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ChromaticityCoordinateAndroid> CREATOR = new ByteArrayCreator<ChromaticityCoordinateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityCoordinateAndroid createFromParcel(@NonNull Parcel in) {
            return new ChromaticityCoordinateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityCoordinateAndroid[] newArray(int size) {
            return new ChromaticityCoordinateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ChromaticityCoordinateAndroid createFromByteArray(@NonNull byte[] values) {
            return new ChromaticityCoordinateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1C
     */
    @Deprecated
    public ChromaticityCoordinateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ChromaticityCoordinateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param chromaticityCoordinate Chromaticity Coordinate
     */
    public ChromaticityCoordinateAndroid(int chromaticityCoordinate) {
        super(chromaticityCoordinate);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChromaticityCoordinateAndroid(@NonNull Parcel in) {
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
