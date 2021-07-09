package org.im97mori.ble.characteristic.u2ae4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CHROMATICITY_COORDINATES_CHARACTERISTIC;

/**
 * Chromaticity Coordinates (Characteristics UUID: 0x2AE4)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticityCoordinatesAndroid extends ChromaticityCoordinates implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ChromaticityCoordinatesAndroid> CREATOR = new ByteArrayCreater<ChromaticityCoordinatesAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CHROMATICITY_COORDINATES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ChromaticityCoordinatesAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE4
     */
    public ChromaticityCoordinatesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
        //noinspection ConstantConditions
        super(in.createByteArray());
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
