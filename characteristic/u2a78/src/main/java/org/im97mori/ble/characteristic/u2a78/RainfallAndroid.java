package org.im97mori.ble.characteristic.u2a78;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;

/**
 * Rainfall (Characteristics UUID: 0x2A78)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RainfallAndroid extends Rainfall implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RainfallAndroid> CREATOR = new ByteArrayCreater<RainfallAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RainfallAndroid createFromParcel(@NonNull Parcel in) {
            return new RainfallAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RainfallAndroid[] newArray(int size) {
            return new RainfallAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RainfallAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RainfallAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A78
     */
    public RainfallAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param rainfall Rainfall
     */
    public RainfallAndroid(int rainfall) {
        super(rainfall);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private RainfallAndroid(@NonNull Parcel in) {
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
