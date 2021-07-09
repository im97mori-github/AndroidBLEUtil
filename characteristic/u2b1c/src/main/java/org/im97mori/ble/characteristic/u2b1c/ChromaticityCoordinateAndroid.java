package org.im97mori.ble.characteristic.u2b1c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CHROMATICITY_COORDINATE_CHARACTERISTIC;

/**
 * Chromaticity Coordinate (Characteristics UUID: 0x2B1C)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticityCoordinateAndroid extends ChromaticityCoordinate implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ChromaticityCoordinateAndroid> CREATOR = new ByteArrayCreater<ChromaticityCoordinateAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CHROMATICITY_COORDINATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ChromaticityCoordinateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1C
     */
    public ChromaticityCoordinateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
