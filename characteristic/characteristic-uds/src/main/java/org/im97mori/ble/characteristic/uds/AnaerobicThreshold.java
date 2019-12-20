package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_THRESHOLD_CHARACTERISTIC;

/**
 * Anaerobic Threshold (Characteristics UUID: 0x2A83)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AnaerobicThreshold implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AnaerobicThreshold> CREATOR = new ByteArrayCreater<AnaerobicThreshold>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicThreshold createFromParcel(@NonNull Parcel in) {
            return new AnaerobicThreshold(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicThreshold[] newArray(int size) {
            return new AnaerobicThreshold[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnaerobicThreshold createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AnaerobicThreshold(bluetoothGattCharacteristic);
        }

    };

    /**
     * Anaerobic Threshold
     */
    private final int mAnaerobicThreshold;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A83
     */
    public AnaerobicThreshold(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAnaerobicThreshold = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnaerobicThreshold(@NonNull Parcel in) {
        mAnaerobicThreshold = in.readInt();
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
        dest.writeInt(mAnaerobicThreshold);
    }

    /**
     * @return Anaerobic Threshold
     */
    public int getAnaerobicThreshold() {
        return mAnaerobicThreshold;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAnaerobicThreshold);
        return data;
    }

}
