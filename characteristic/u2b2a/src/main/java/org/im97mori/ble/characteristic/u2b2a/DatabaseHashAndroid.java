package org.im97mori.ble.characteristic.u2b2a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_HASH_CHARACTERISTIC;

/**
 * Database Hash (Characteristics UUID: 0x2B2A)
 */
@SuppressWarnings({"WeakerAccess"})
public class DatabaseHashAndroid extends DatabaseHash implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DatabaseHashAndroid> CREATOR = new ByteArrayCreater<DatabaseHashAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseHashAndroid createFromParcel(@NonNull Parcel in) {
            return new DatabaseHashAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DatabaseHashAndroid[] newArray(int size) {
            return new DatabaseHashAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DatabaseHashAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DatabaseHashAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B2A
     */
    public DatabaseHashAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DatabaseHashAndroid(@NonNull Parcel in) {
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
