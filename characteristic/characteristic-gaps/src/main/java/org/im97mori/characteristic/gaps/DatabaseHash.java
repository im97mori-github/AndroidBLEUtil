package org.im97mori.characteristic.gaps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_HASH_CHARACTERISTIC;

/**
 * Database Hash (Characteristics UUID: 0x2B29)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class DatabaseHash implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DatabaseHash> CREATOR = new ByteArrayCreater<DatabaseHash>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseHash createFromParcel(@NonNull Parcel in) {
            return new DatabaseHash(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseHash[] newArray(int size) {
            return new DatabaseHash[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DatabaseHash createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DatabaseHash(bluetoothGattCharacteristic);
        }

    };

    /**
     * Database Hash
     */
    private final byte[] mDatabaseHash;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B29
     */
    public DatabaseHash(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mDatabaseHash = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DatabaseHash(@NonNull Parcel in) {
        mDatabaseHash = in.createByteArray();
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
        dest.writeByteArray(mDatabaseHash);
    }

    /**
     * @return Database Hash
     */
    public byte[] getDatabaseHash() {
        return mDatabaseHash;
    }

    /**
     * @return Database Hash {@link BigInteger}
     */
    public BigInteger getDatabaseHashBigInteger() {
        return BLEUtils.createUInt128(mDatabaseHash, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[mDatabaseHash.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mDatabaseHash);
        return data;
    }

}
