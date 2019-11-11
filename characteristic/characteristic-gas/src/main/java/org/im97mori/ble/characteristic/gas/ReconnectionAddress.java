package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RECONNECTION_ADDRESS_CHARACTERISTIC;

/**
 * Reconnection Address (Characteristics UUID: 0x2A03)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ReconnectionAddress implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReconnectionAddress> CREATOR = new ByteArrayCreater<ReconnectionAddress>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionAddress createFromParcel(@NonNull Parcel in) {
            return new ReconnectionAddress(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionAddress[] newArray(int size) {
            return new ReconnectionAddress[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReconnectionAddress createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_ADDRESS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ReconnectionAddress(bluetoothGattCharacteristic);
        }

    };

    /**
     * Address
     */
    private final long mAddress;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A03
     */
    public ReconnectionAddress(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAddress = BLEUtils.createUInt48(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReconnectionAddress(@NonNull Parcel in) {
        mAddress = in.readLong();
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
        dest.writeLong(mAddress);
    }

    /**
     * @return Address
     */
    public long getAddress() {
        return mAddress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[6];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAddress);
        byteBuffer.put((byte) (mAddress >> 8));
        byteBuffer.put((byte) (mAddress >> 16));
        byteBuffer.put((byte) (mAddress >> 24));
        byteBuffer.put((byte) (mAddress >> 32));
        byteBuffer.put((byte) (mAddress >> 40));
        return data;
    }

}
