package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_MAX_CHARACTERISTIC;

/**
 * Heart Rate Max (Characteristics UUID: 0x2A8D)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HeartRateMax implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HeartRateMax> CREATOR = new ByteArrayCreater<HeartRateMax>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMax createFromParcel(@NonNull Parcel in) {
            return new HeartRateMax(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMax[] newArray(int size) {
            return new HeartRateMax[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeartRateMax createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HeartRateMax(bluetoothGattCharacteristic);
        }

    };

    /**
     * Heart Rate Max
     */
    private final int mHeartRateMax;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8D
     */
    public HeartRateMax(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHeartRateMax = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeartRateMax(@NonNull Parcel in) {
        mHeartRateMax = in.readInt();
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
        dest.writeInt(mHeartRateMax);
    }

    /**
     * @return Heart Rate Max
     */
    public int getHeartRateMax() {
        return mHeartRateMax;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mHeartRateMax);
        return data;
    }

}
