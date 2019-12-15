package org.im97mori.ble.characteristic.bas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;

/**
 * Battery Level (Characteristics UUID: 0x2A19)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BatteryLevel implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BatteryLevel> CREATOR = new ByteArrayCreater<BatteryLevel>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryLevel createFromParcel(@NonNull Parcel in) {
            return new BatteryLevel(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryLevel[] newArray(int size) {
            return new BatteryLevel[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryLevel createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BatteryLevel(bluetoothGattCharacteristic);
        }

    };

    /**
     * Level
     */
    private final int mLevel;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A19
     */
    public BatteryLevel(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLevel = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryLevel(@NonNull Parcel in) {
        mLevel = in.readInt();
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
        dest.writeInt(mLevel);
    }

    /**
     * @return Level
     */
    public int getLevel() {
        return mLevel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mLevel);
        return data;
    }

}
