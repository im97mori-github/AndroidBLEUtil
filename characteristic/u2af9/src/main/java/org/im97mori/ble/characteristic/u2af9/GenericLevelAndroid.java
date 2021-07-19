package org.im97mori.ble.characteristic.u2af9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.GENERIC_LEVEL_CHARACTERISTIC;

/**
 * Generic Level (Characteristics UUID: 0x2AF9)
 */
@SuppressWarnings({"WeakerAccess"})
public class GenericLevelAndroid extends GenericLevel implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GenericLevelAndroid> CREATOR = new ByteArrayCreater<GenericLevelAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GenericLevelAndroid createFromParcel(@NonNull Parcel in) {
            return new GenericLevelAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GenericLevelAndroid[] newArray(int size) {
            return new GenericLevelAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GenericLevelAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GENERIC_LEVEL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GenericLevelAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF9
     */
    public GenericLevelAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param genericLevel Generic Level
     */
    public GenericLevelAndroid(int genericLevel) {
        super(genericLevel);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GenericLevelAndroid(@NonNull Parcel in) {
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
