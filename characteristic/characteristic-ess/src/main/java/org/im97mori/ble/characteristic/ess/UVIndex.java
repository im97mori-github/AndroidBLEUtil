package org.im97mori.ble.characteristic.ess;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UV_INDEX_CHARACTERISTIC;

/**
 * UV Index (Characteristics UUID: 0x2A76)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class UVIndex implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UVIndex> CREATOR = new ByteArrayCreater<UVIndex>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UVIndex createFromParcel(@NonNull Parcel in) {
            return new UVIndex(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UVIndex[] newArray(int size) {
            return new UVIndex[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UVIndex createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UVIndex(bluetoothGattCharacteristic);
        }

    };

    /**
     * UV Index
     */
    private final int mUVIndex;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A76
     */
    public UVIndex(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mUVIndex = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UVIndex(@NonNull Parcel in) {
        mUVIndex = in.readInt();
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
        dest.writeInt(mUVIndex);
    }

    /**
     * @return UV Index
     */
    public int getUVIndex() {
        return mUVIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mUVIndex);
        return data;
    }

}
