package org.im97mori.ble.characteristic.u2a94;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;

/**
 * Three Zone Heart Rate Limits (Characteristics UUID: 0x2A94)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ThreeZoneHeartRateLimitsAndroid extends ThreeZoneHeartRateLimits implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ThreeZoneHeartRateLimitsAndroid> CREATOR = new ByteArrayCreater<ThreeZoneHeartRateLimitsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ThreeZoneHeartRateLimitsAndroid createFromParcel(@NonNull Parcel in) {
            return new ThreeZoneHeartRateLimitsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ThreeZoneHeartRateLimitsAndroid[] newArray(int size) {
            return new ThreeZoneHeartRateLimitsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ThreeZoneHeartRateLimitsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ThreeZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A94
     */
    public ThreeZoneHeartRateLimitsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit  Three zone Heart Rate Limits - Light (Fat burn) / Moderate (Aerobic) Limit
     * @param threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit Three zone Heart Rate Limits - Moderate (Aerobic) / Hard (Anaerobic) Limit
     */
    public ThreeZoneHeartRateLimitsAndroid(int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit, int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit) {
        super(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ThreeZoneHeartRateLimitsAndroid(@NonNull Parcel in) {
        super(in.createByteArray());
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
        dest.writeByteArray(getBytes());
    }

}
