package org.im97mori.ble.characteristic.u2ab1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCAL_EAST_COORDINATE_CHARACTERISTIC;

/**
 * Local East Coordinate (Characteristics UUID: 0x2AB1)
 */
@SuppressWarnings({"WeakerAccess"})
public class LocalEastCoordinateAndroid extends LocalEastCoordinate implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocalEastCoordinateAndroid> CREATOR = new ByteArrayCreater<LocalEastCoordinateAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCAL_EAST_COORDINATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocalEastCoordinateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB1
     */
    public LocalEastCoordinateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
    @SuppressWarnings("ConstantConditions")
    private LocalEastCoordinateAndroid(@NonNull Parcel in) {
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
