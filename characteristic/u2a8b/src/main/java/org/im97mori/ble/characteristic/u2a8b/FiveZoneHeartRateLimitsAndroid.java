package org.im97mori.ble.characteristic.u2a8b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Five Zone Heart Rate Limits (Characteristics UUID: 0x2A8B)
 */
@SuppressWarnings({"WeakerAccess"})
public class FiveZoneHeartRateLimitsAndroid extends FiveZoneHeartRateLimits implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FiveZoneHeartRateLimitsAndroid> CREATOR = new ByteArrayCreator<FiveZoneHeartRateLimitsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FiveZoneHeartRateLimitsAndroid createFromParcel(@NonNull Parcel in) {
            return new FiveZoneHeartRateLimitsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FiveZoneHeartRateLimitsAndroid[] newArray(int size) {
            return new FiveZoneHeartRateLimitsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FiveZoneHeartRateLimitsAndroid createFromByteArray(@NonNull byte[] values) {
            return new FiveZoneHeartRateLimitsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8B
     */
    @Deprecated
    public FiveZoneHeartRateLimitsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FiveZoneHeartRateLimitsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param fiveZoneHeartRateLimitsVeryLightLightLimit Five Zone Heart Rate Limits - Very light / Light Limit
     * @param fiveZoneHeartRateLimitsLightModerateLimit  Five Zone Heart Rate Limits - Light / Moderate Limit
     * @param fiveZoneHeartRateLimitsModerateHardLimit   Five Zone Heart Rate Limits - Moderate / Hard Limit
     * @param fiveZoneHeartRateLimitsHardMaximumLimit    Five Zone Heart Rate Limits - Hard / Maximum Limit
     */
    public FiveZoneHeartRateLimitsAndroid(int fiveZoneHeartRateLimitsVeryLightLightLimit, int fiveZoneHeartRateLimitsLightModerateLimit, int fiveZoneHeartRateLimitsModerateHardLimit, int fiveZoneHeartRateLimitsHardMaximumLimit) {
        super(fiveZoneHeartRateLimitsVeryLightLightLimit, fiveZoneHeartRateLimitsLightModerateLimit, fiveZoneHeartRateLimitsModerateHardLimit, fiveZoneHeartRateLimitsHardMaximumLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FiveZoneHeartRateLimitsAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
