package org.im97mori.ble.characteristic.tps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.im97mori.ble.BLEUtils;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;

/**
 * Tx Power Level (Characteristics UUID: 0x2A07)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TxPowerLevel implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TxPowerLevel> CREATOR = new ByteArrayCreater<TxPowerLevel>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerLevel createFromParcel(@NonNull Parcel in) {
            return new TxPowerLevel(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerLevel[] newArray(int size) {
            return new TxPowerLevel[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TxPowerLevel createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TX_POWER_LEVEL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TxPowerLevel(bluetoothGattCharacteristic);
        }

    };

    /**
     * Tx Power
     */
    private final int mTxPower;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A07
     */
    public TxPowerLevel(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTxPower = BLEUtils.createSInt8(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TxPowerLevel(@NonNull Parcel in) {
        mTxPower = in.readInt();
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
        dest.writeInt(mTxPower);
    }

    /**
     * @return Tx Power
     */
    public int getTxPower() {
        return mTxPower;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mTxPower);
        return data;
    }

}
