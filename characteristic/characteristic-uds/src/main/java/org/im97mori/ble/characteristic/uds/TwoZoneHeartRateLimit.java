package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;

/**
 * Two Zone Heart Rate Limit (Characteristics UUID: 0x2A95)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TwoZoneHeartRateLimit implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TwoZoneHeartRateLimit> CREATOR = new ByteArrayCreater<TwoZoneHeartRateLimit>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TwoZoneHeartRateLimit createFromParcel(@NonNull Parcel in) {
            return new TwoZoneHeartRateLimit(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TwoZoneHeartRateLimit[] newArray(int size) {
            return new TwoZoneHeartRateLimit[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TwoZoneHeartRateLimit createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TwoZoneHeartRateLimit(bluetoothGattCharacteristic);
        }

    };

    /**
     * Two zone Heart Rate Limit - Fat burn / Fitness Limit
     */
    private final int mTwoZoneHeartRateLimitFatBurnFitnessLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A95
     */
    public TwoZoneHeartRateLimit(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTwoZoneHeartRateLimitFatBurnFitnessLimit = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TwoZoneHeartRateLimit(@NonNull Parcel in) {
        mTwoZoneHeartRateLimitFatBurnFitnessLimit = in.readInt();
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
        dest.writeInt(mTwoZoneHeartRateLimitFatBurnFitnessLimit);
    }

    /**
     * @return Two zone Heart Rate Limit - Fat burn / Fitness Limit
     */
    public int getTwoZoneHeartRateLimitFatBurnFitnessLimit() {
        return mTwoZoneHeartRateLimitFatBurnFitnessLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mTwoZoneHeartRateLimitFatBurnFitnessLimit);
        return data;
    }

}
