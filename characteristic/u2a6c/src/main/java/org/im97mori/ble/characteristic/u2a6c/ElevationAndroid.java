package org.im97mori.ble.characteristic.u2a6c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ELEVATION_CHARACTERISTIC;

/**
 * Elevation (Characteristics UUID: 0x2A6C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ElevationAndroid extends Elevation implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ElevationAndroid> CREATOR = new ByteArrayCreater<ElevationAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ElevationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6C
     */
    public ElevationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ElevationAndroid(@NonNull Parcel in) {
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