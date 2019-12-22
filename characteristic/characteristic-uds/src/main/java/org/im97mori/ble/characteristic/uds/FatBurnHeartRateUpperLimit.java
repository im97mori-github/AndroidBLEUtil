package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;

/**
 * Fat Burn Heart Rate Upper Limit (Characteristics UUID: 0x2A89)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FatBurnHeartRateUpperLimit implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FatBurnHeartRateUpperLimit> CREATOR = new ByteArrayCreater<FatBurnHeartRateUpperLimit>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateUpperLimit createFromParcel(@NonNull Parcel in) {
            return new FatBurnHeartRateUpperLimit(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateUpperLimit[] newArray(int size) {
            return new FatBurnHeartRateUpperLimit[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FatBurnHeartRateUpperLimit createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FatBurnHeartRateUpperLimit(bluetoothGattCharacteristic);
        }

    };

    /**
     * Fat Burn Heart Rate Upper Limit
     */
    private final int mFatBurnHeartRateUpperLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A89
     */
    public FatBurnHeartRateUpperLimit(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFatBurnHeartRateUpperLimit = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FatBurnHeartRateUpperLimit(@NonNull Parcel in) {
        mFatBurnHeartRateUpperLimit = in.readInt();
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
        dest.writeInt(mFatBurnHeartRateUpperLimit);
    }

    /**
     * @return Fat Burn Heart Rate Upper Limit
     */
    public int getFatBurnHeartRateUpperLimit() {
        return mFatBurnHeartRateUpperLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFatBurnHeartRateUpperLimit);
        return data;
    }

}
