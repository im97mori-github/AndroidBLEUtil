package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AGE_CHARACTERISTIC;

/**
 * Age (Characteristics UUID: 0x2A80)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Age implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Age> CREATOR = new ByteArrayCreater<Age>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Age createFromParcel(@NonNull Parcel in) {
            return new Age(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Age[] newArray(int size) {
            return new Age[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Age createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Age(bluetoothGattCharacteristic);
        }

    };

    /**
     * Age
     */
    private final int mAge;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A80
     */
    public Age(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAge = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Age(@NonNull Parcel in) {
        mAge = in.readInt();
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
        dest.writeInt(mAge);
    }

    /**
     * @return Age
     */
    public int getAge() {
        return mAge;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAge);
        return data;
    }

}
