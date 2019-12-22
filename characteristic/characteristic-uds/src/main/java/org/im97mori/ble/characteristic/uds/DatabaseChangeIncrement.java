package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;

/**
 * Database Change Increment (Characteristics UUID: 0x2A99)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class DatabaseChangeIncrement implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DatabaseChangeIncrement> CREATOR = new ByteArrayCreater<DatabaseChangeIncrement>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseChangeIncrement createFromParcel(@NonNull Parcel in) {
            return new DatabaseChangeIncrement(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseChangeIncrement[] newArray(int size) {
            return new DatabaseChangeIncrement[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DatabaseChangeIncrement createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DatabaseChangeIncrement(bluetoothGattCharacteristic);
        }

    };

    /**
     * Database Change Increment
     */
    private final long mDatabaseChangeIncrement;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A99
     */
    public DatabaseChangeIncrement(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mDatabaseChangeIncrement = BLEUtils.createUInt32(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DatabaseChangeIncrement(@NonNull Parcel in) {
        mDatabaseChangeIncrement = in.readLong();
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
        dest.writeLong(mDatabaseChangeIncrement);
    }

    /**
     * @return Database Change Increment
     */
    public long getDatabaseChangeIncrement() {
        return mDatabaseChangeIncrement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt((int) mDatabaseChangeIncrement);
        return data;
    }

}
