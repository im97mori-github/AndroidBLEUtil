package org.im97mori.ble.characteristic.u2a9a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;

/**
 * User Index (Characteristics UUID: 0x2A9A)
 */
@SuppressWarnings({"WeakerAccess"})
public class UserIndexAndroid extends UserIndex implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UserIndexAndroid> CREATOR = new ByteArrayCreater<UserIndexAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserIndexAndroid createFromParcel(@NonNull Parcel in) {
            return new UserIndexAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserIndexAndroid[] newArray(int size) {
            return new UserIndexAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UserIndexAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(USER_INDEX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UserIndexAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9A
     */
    public UserIndexAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param userIndex User Index
     */
    public UserIndexAndroid(int userIndex) {
        super(userIndex);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UserIndexAndroid(@NonNull Parcel in) {
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
