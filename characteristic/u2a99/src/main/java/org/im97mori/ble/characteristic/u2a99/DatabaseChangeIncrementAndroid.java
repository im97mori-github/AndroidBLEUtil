package org.im97mori.ble.characteristic.u2a99;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;

/**
 * Database Change Increment (Characteristics UUID: 0x2A99)
 */
@SuppressWarnings({"WeakerAccess"})
public class DatabaseChangeIncrementAndroid extends DatabaseChangeIncrement implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DatabaseChangeIncrementAndroid> CREATOR = new ByteArrayCreater<DatabaseChangeIncrementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseChangeIncrementAndroid createFromParcel(@NonNull Parcel in) {
            return new DatabaseChangeIncrementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseChangeIncrementAndroid[] newArray(int size) {
            return new DatabaseChangeIncrementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DatabaseChangeIncrementAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DatabaseChangeIncrementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A99
     */
    public DatabaseChangeIncrementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param databaseChangeIncrement Database Change Increment
     */
    public DatabaseChangeIncrementAndroid(long databaseChangeIncrement) {
        super(databaseChangeIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private DatabaseChangeIncrementAndroid(@NonNull Parcel in) {
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
