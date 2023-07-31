package org.im97mori.ble.characteristic.u2a95;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Two Zone Heart Rate Limit (Characteristics UUID: 0x2A95)
 */
@SuppressWarnings({"WeakerAccess"})
public class TwoZoneHeartRateLimitAndroid extends TwoZoneHeartRateLimit implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TwoZoneHeartRateLimitAndroid> CREATOR = new ByteArrayCreator<TwoZoneHeartRateLimitAndroid>() {

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
            return new TwoZoneHeartRateLimitAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A95
     */
    @Deprecated
    public TwoZoneHeartRateLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TwoZoneHeartRateLimitAndroid(@NonNull byte[] values) {
        super(values);
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
    private TwoZoneHeartRateLimitAndroid(@NonNull Parcel in) {
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
