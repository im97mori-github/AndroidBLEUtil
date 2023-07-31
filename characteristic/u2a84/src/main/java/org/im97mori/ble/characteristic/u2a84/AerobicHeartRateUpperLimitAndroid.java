package org.im97mori.ble.characteristic.u2a84;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Aerobic Heart Rate Upper Limit (Characteristics UUID: 0x2A84)
 */
@SuppressWarnings({"WeakerAccess"})
public class AerobicHeartRateUpperLimitAndroid extends AerobicHeartRateUpperLimit implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AerobicHeartRateUpperLimitAndroid> CREATOR = new ByteArrayCreator<AerobicHeartRateUpperLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateUpperLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new AerobicHeartRateUpperLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateUpperLimitAndroid[] newArray(int size) {
            return new AerobicHeartRateUpperLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AerobicHeartRateUpperLimitAndroid createFromByteArray(@NonNull byte[] values) {
            return new AerobicHeartRateUpperLimitAndroid(values);
        }

    };


    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A84
     */
    @Deprecated
    public AerobicHeartRateUpperLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AerobicHeartRateUpperLimitAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param aerobicHeartRateUpperLimit Aerobic Heart Rate Upper Limit
     */
    public AerobicHeartRateUpperLimitAndroid(int aerobicHeartRateUpperLimit) {
        super(aerobicHeartRateUpperLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AerobicHeartRateUpperLimitAndroid(@NonNull Parcel in) {
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
