package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;

/**
 * Five Zone Heart Rate Limits (Characteristics UUID: 0x2A8B)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FiveZoneHeartRateLimits implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FiveZoneHeartRateLimits> CREATOR = new ByteArrayCreater<FiveZoneHeartRateLimits>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FiveZoneHeartRateLimits createFromParcel(@NonNull Parcel in) {
            return new FiveZoneHeartRateLimits(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FiveZoneHeartRateLimits[] newArray(int size) {
            return new FiveZoneHeartRateLimits[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FiveZoneHeartRateLimits createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FiveZoneHeartRateLimits(bluetoothGattCharacteristic);
        }

    };

    /**
     * Five Zone Heart Rate Limits - Very light / Light Limit
     */
    private final int mFiveZoneHeartRateLimitsVeryLightLightLimit;

    /**
     * Five Zone Heart Rate Limits - Light / Moderate Limit
     */
    private final int mFiveZoneHeartRateLimitsLightModerateLimit;

    /**
     * Five Zone Heart Rate Limits - Moderate / Hard Limit
     */
    private final int mFiveZoneHeartRateLimitsModerateHardLimit;

    /**
     * Five Zone Heart Rate Limits - Hard / Maximum Limit
     */
    private final int mFiveZoneHeartRateLimitsHardMaximumLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8B
     */
    public FiveZoneHeartRateLimits(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFiveZoneHeartRateLimitsVeryLightLightLimit = (values[0] & 0xff);
        mFiveZoneHeartRateLimitsLightModerateLimit = (values[1] & 0xff);
        mFiveZoneHeartRateLimitsModerateHardLimit = (values[2] & 0xff);
        mFiveZoneHeartRateLimitsHardMaximumLimit = (values[3] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FiveZoneHeartRateLimits(@NonNull Parcel in) {
        mFiveZoneHeartRateLimitsVeryLightLightLimit = in.readInt();
        mFiveZoneHeartRateLimitsLightModerateLimit = in.readInt();
        mFiveZoneHeartRateLimitsModerateHardLimit = in.readInt();
        mFiveZoneHeartRateLimitsHardMaximumLimit = in.readInt();
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
        dest.writeInt(mFiveZoneHeartRateLimitsVeryLightLightLimit);
        dest.writeInt(mFiveZoneHeartRateLimitsLightModerateLimit);
        dest.writeInt(mFiveZoneHeartRateLimitsModerateHardLimit);
        dest.writeInt(mFiveZoneHeartRateLimitsHardMaximumLimit);
    }

    /**
     * @return Five Zone Heart Rate Limits - Very light / Light Limit
     */
    public int getFiveZoneHeartRateLimitsVeryLightLightLimit() {
        return mFiveZoneHeartRateLimitsVeryLightLightLimit;
    }

    /**
     * @return Five Zone Heart Rate Limits - Light / Moderate Limit
     */
    public int getFiveZoneHeartRateLimitsLightModerateLimit() {
        return mFiveZoneHeartRateLimitsLightModerateLimit;
    }

    /**
     * @return Five Zone Heart Rate Limits - Moderate / Hard Limit
     */
    public int getFiveZoneHeartRateLimitsModerateHardLimit() {
        return mFiveZoneHeartRateLimitsModerateHardLimit;
    }

    /**
     * @return Five Zone Heart Rate Limits - Hard / Maximum Limit
     */
    public int getFiveZoneHeartRateLimitsHardMaximumLimit() {
        return mFiveZoneHeartRateLimitsHardMaximumLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFiveZoneHeartRateLimitsVeryLightLightLimit);
        byteBuffer.put((byte) mFiveZoneHeartRateLimitsLightModerateLimit);
        byteBuffer.put((byte) mFiveZoneHeartRateLimitsModerateHardLimit);
        byteBuffer.put((byte) mFiveZoneHeartRateLimitsHardMaximumLimit);
        return data;
    }

}
