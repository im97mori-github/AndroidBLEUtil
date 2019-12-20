package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;

/**
 * Three Zone Heart Rate Limits (Characteristics UUID: 0x2A94)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ThreeZoneHeartRateLimits implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ThreeZoneHeartRateLimits> CREATOR = new ByteArrayCreater<ThreeZoneHeartRateLimits>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ThreeZoneHeartRateLimits createFromParcel(@NonNull Parcel in) {
            return new ThreeZoneHeartRateLimits(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ThreeZoneHeartRateLimits[] newArray(int size) {
            return new ThreeZoneHeartRateLimits[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ThreeZoneHeartRateLimits createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ThreeZoneHeartRateLimits(bluetoothGattCharacteristic);
        }

    };

    /**
     * Three zone Heart Rate Limits - Light (Fat burn) / Moderate (Aerobic) Limit
     */
    private final int mThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit;

    /**
     * Three zone Heart Rate Limits - Moderate (Aerobic) / Hard (Anaerobic) Limit
     */
    private final int mThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A94
     */
    public ThreeZoneHeartRateLimits(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit = (values[0] & 0xff);
        mThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit = (values[1] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ThreeZoneHeartRateLimits(@NonNull Parcel in) {
        mThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit = in.readInt();
        mThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit = in.readInt();
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
        dest.writeInt(mThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit);
        dest.writeInt(mThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit);
    }

    /**
     * @return Three zone Heart Rate Limits - Light (Fat burn) / Moderate (Aerobic) Limit
     */
    public int getThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit() {
        return mThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit;
    }

    /**
     * @return Three zone Heart Rate Limits - Moderate (Aerobic) / Hard (Anaerobic) Limit
     */
    public int getThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit() {
        return mThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit);
        byteBuffer.put((byte) mThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit);
        return data;
    }

}
