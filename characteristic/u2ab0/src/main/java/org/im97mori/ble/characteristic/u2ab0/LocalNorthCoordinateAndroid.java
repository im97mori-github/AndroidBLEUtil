package org.im97mori.ble.characteristic.u2ab0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCAL_NORTH_COORDINATE_CHARACTERISTIC;

/**
 * Local North Coordinate (Characteristics UUID: 0x2AB0)
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class LocalNorthCoordinateAndroid extends LocalNorthCoordinate implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocalNorthCoordinateAndroid> CREATOR = new ByteArrayCreater<LocalNorthCoordinateAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCAL_NORTH_COORDINATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocalNorthCoordinateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB0
     */
    public LocalNorthCoordinateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocalNorthCoordinateAndroid(@NonNull Parcel in) {
        super(in.createByteArray());
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
