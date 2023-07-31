package org.im97mori.ble.characteristic.u2a82;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Anaerobic Heart Rate Upper Limit (Characteristics UUID: 0x2A82)
 */
@SuppressWarnings({"WeakerAccess"})
public class AnaerobicHeartRateUpperLimitAndroid extends AnaerobicHeartRateUpperLimit implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AnaerobicHeartRateUpperLimitAndroid> CREATOR = new ByteArrayCreator<AnaerobicHeartRateUpperLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateUpperLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new AnaerobicHeartRateUpperLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateUpperLimitAndroid[] newArray(int size) {
            return new AnaerobicHeartRateUpperLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnaerobicHeartRateUpperLimitAndroid createFromByteArray(@NonNull byte[] values) {
            return new AnaerobicHeartRateUpperLimitAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A82
     */
    @Deprecated
    public AnaerobicHeartRateUpperLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AnaerobicHeartRateUpperLimitAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param anaerobicHeartRateLowerLimit Anaerobic Heart Rate Lower Limit
     */
    public AnaerobicHeartRateUpperLimitAndroid(int anaerobicHeartRateLowerLimit) {
        super(anaerobicHeartRateLowerLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnaerobicHeartRateUpperLimitAndroid(@NonNull Parcel in) {
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
