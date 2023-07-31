package org.im97mori.ble.characteristic.u2ae4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Chromaticity Coordinates (Characteristics UUID: 0x2AE4)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticityCoordinatesAndroid extends ChromaticityCoordinates implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ChromaticityCoordinatesAndroid> CREATOR = new ByteArrayCreator<ChromaticityCoordinatesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityCoordinatesAndroid createFromParcel(@NonNull Parcel in) {
            return new ChromaticityCoordinatesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityCoordinatesAndroid[] newArray(int size) {
            return new ChromaticityCoordinatesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ChromaticityCoordinatesAndroid createFromByteArray(@NonNull byte[] values) {
            return new ChromaticityCoordinatesAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE4
     */
    @Deprecated
    public ChromaticityCoordinatesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ChromaticityCoordinatesAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param chromaticityXCoordinate Chromaticity x-coordinate
     * @param chromaticityYCoordinate Chromaticity y-coordinate
     */
    public ChromaticityCoordinatesAndroid(int chromaticityXCoordinate, int chromaticityYCoordinate) {
        super(chromaticityXCoordinate, chromaticityYCoordinate);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChromaticityCoordinatesAndroid(@NonNull Parcel in) {
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
