package org.im97mori.ble.characteristic.u2a95;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;

/**
 * Two Zone Heart Rate Limit (Characteristics UUID: 0x2A95)
 */
@SuppressWarnings({"WeakerAccess"})
public class TwoZoneHeartRateLimitAndroid extends TwoZoneHeartRateLimit implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TwoZoneHeartRateLimitAndroid> CREATOR = new ByteArrayCreater<TwoZoneHeartRateLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TwoZoneHeartRateLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new TwoZoneHeartRateLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TwoZoneHeartRateLimitAndroid[] newArray(int size) {
            return new TwoZoneHeartRateLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TwoZoneHeartRateLimitAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TwoZoneHeartRateLimitAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A95
     */
    public TwoZoneHeartRateLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param twoZoneHeartRateLimitFatBurnFitnessLimit Two zone Heart Rate Limit - Fat burn / Fitness Limit
     */
    public TwoZoneHeartRateLimitAndroid(int twoZoneHeartRateLimitFatBurnFitnessLimit) {
        super(twoZoneHeartRateLimitFatBurnFitnessLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TwoZoneHeartRateLimitAndroid(@NonNull Parcel in) {
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
