package org.im97mori.ble.characteristic.u2a94;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Three Zone Heart Rate Limits (Characteristics UUID: 0x2A94)
 */
@SuppressWarnings({"WeakerAccess"})
public class ThreeZoneHeartRateLimitsAndroid extends ThreeZoneHeartRateLimits implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ThreeZoneHeartRateLimitsAndroid> CREATOR = new ByteArrayCreator<ThreeZoneHeartRateLimitsAndroid>() {

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
            return new ThreeZoneHeartRateLimitsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A94
     */
    @Deprecated
    public ThreeZoneHeartRateLimitsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ThreeZoneHeartRateLimitsAndroid(@NonNull byte[] values) {
        super(values);
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
    private ThreeZoneHeartRateLimitsAndroid(@NonNull Parcel in) {
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
