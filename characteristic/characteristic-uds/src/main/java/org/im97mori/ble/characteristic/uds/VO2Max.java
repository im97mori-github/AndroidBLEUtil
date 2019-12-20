package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.V_O2_MAX_CHARACTERISTIC;

/**
 * VO2 Max (Characteristics UUID: 0x2A96)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class VO2Max implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<VO2Max> CREATOR = new ByteArrayCreater<VO2Max>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VO2Max createFromParcel(@NonNull Parcel in) {
            return new VO2Max(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VO2Max[] newArray(int size) {
            return new VO2Max[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VO2Max createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(V_O2_MAX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VO2Max(bluetoothGattCharacteristic);
        }

    };

    /**
     * VO2 Max
     */
    private final int mVo2Max;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A96
     */
    public VO2Max(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mVo2Max = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VO2Max(@NonNull Parcel in) {
        mVo2Max = in.readInt();
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
        dest.writeInt(mVo2Max);
    }

    /**
     * @return VO2 Max
     */
    public int getVo2Max() {
        return mVo2Max;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mVo2Max);
        return data;
    }

}
