package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;

/**
 * Fat Burn Heart Rate Lower Limit (Characteristics UUID: 0x2A88)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FatBurnHeartRateLowerLimit implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FatBurnHeartRateLowerLimit> CREATOR = new ByteArrayCreater<FatBurnHeartRateLowerLimit>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateLowerLimit createFromParcel(@NonNull Parcel in) {
            return new FatBurnHeartRateLowerLimit(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateLowerLimit[] newArray(int size) {
            return new FatBurnHeartRateLowerLimit[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FatBurnHeartRateLowerLimit createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FatBurnHeartRateLowerLimit(bluetoothGattCharacteristic);
        }

    };

    /**
     * Fat Burn Heart Rate Lower Limit
     */
    private final int mFatBurnHeartRateLowerLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A88
     */
    public FatBurnHeartRateLowerLimit(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFatBurnHeartRateLowerLimit = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FatBurnHeartRateLowerLimit(@NonNull Parcel in) {
        mFatBurnHeartRateLowerLimit = in.readInt();
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
        dest.writeInt(mFatBurnHeartRateLowerLimit);
    }

    /**
     * @return Fat Burn Heart Rate Lower Limit
     */
    public int getFatBurnHeartRateLowerLimit() {
        return mFatBurnHeartRateLowerLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFatBurnHeartRateLowerLimit);
        return data;
    }

}
