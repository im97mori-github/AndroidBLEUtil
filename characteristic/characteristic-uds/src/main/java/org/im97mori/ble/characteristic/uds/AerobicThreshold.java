package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_THRESHOLD_CHARACTERISTIC;

/**
 * Aerobic Threshold (Characteristics UUID: 0x2A7F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AerobicThreshold implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AerobicThreshold> CREATOR = new ByteArrayCreater<AerobicThreshold>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicThreshold createFromParcel(@NonNull Parcel in) {
            return new AerobicThreshold(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicThreshold[] newArray(int size) {
            return new AerobicThreshold[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AerobicThreshold createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AerobicThreshold(bluetoothGattCharacteristic);
        }

    };

    /**
     * Aerobic Threshold
     */
    private final int mAerobicThreshold;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7F
     */
    public AerobicThreshold(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAerobicThreshold = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AerobicThreshold(@NonNull Parcel in) {
        mAerobicThreshold = in.readInt();
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
        dest.writeInt(mAerobicThreshold);
    }

    /**
     * @return Aerobic Threshold
     */
    public int getAerobicThreshold() {
        return mAerobicThreshold;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAerobicThreshold);
        return data;
    }

}
