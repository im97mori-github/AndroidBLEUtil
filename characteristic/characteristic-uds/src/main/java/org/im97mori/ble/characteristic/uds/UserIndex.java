package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;

/**
 * User Index (Characteristics UUID: 0x2A9A)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class UserIndex implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UserIndex> CREATOR = new ByteArrayCreater<UserIndex>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserIndex createFromParcel(@NonNull Parcel in) {
            return new UserIndex(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserIndex[] newArray(int size) {
            return new UserIndex[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UserIndex createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(USER_INDEX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UserIndex(bluetoothGattCharacteristic);
        }

    };

    /**
     * User Index
     */
    private final int mUserIndex;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9A
     */
    public UserIndex(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mUserIndex = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UserIndex(@NonNull Parcel in) {
        mUserIndex = in.readInt();
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
        dest.writeInt(mUserIndex);
    }

    /**
     * @return User Index
     */
    public int getUserIndex() {
        return mUserIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mUserIndex);
        return data;
    }

}
