package org.im97mori.ble.characteristic.u2b4c;

import static org.im97mori.ble.constants.CharacteristicUUID.FOUR_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

/**
 * Four Zone Heart Rate Limits (Characteristics UUID: 0x2B4C)
 */
@SuppressWarnings({"WeakerAccess"})
public class FourZoneHeartRateLimitsAndroid extends FourZoneHeartRateLimits implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FourZoneHeartRateLimitsAndroid> CREATOR = new ByteArrayCreator<FourZoneHeartRateLimitsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FourZoneHeartRateLimitsAndroid createFromParcel(@NonNull Parcel in) {
            return new FourZoneHeartRateLimitsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FourZoneHeartRateLimitsAndroid[] newArray(int size) {
            return new FourZoneHeartRateLimitsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FourZoneHeartRateLimitsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FOUR_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FourZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4C
     */
    public FourZoneHeartRateLimitsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param fourZoneHeartRateLimitsLightModerateLimit Five Zone Heart Rate Limits
     *                                                  - Very light / Light Limit
     * @param fourZoneHeartRateLimitsModerateHardLimit  Five Zone Heart Rate Limits
     *                                                  - Light / Moderate Limit
     * @param fourZoneHeartRateLimitsHardMaximumLimit   Five Zone Heart Rate Limits
     *                                                  - Moderate / Hard Limit
     */
    public FourZoneHeartRateLimitsAndroid(int fourZoneHeartRateLimitsLightModerateLimit,
                                          int fourZoneHeartRateLimitsModerateHardLimit
            , int fourZoneHeartRateLimitsHardMaximumLimit) {
        super(fourZoneHeartRateLimitsLightModerateLimit, fourZoneHeartRateLimitsModerateHardLimit, fourZoneHeartRateLimitsHardMaximumLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FourZoneHeartRateLimitsAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
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
