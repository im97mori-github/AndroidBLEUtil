package org.im97mori.ble.characteristic.u2a81;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Anaerobic Heart Rate Lower Limit (Characteristics UUID: 0x2A81)
 */
@SuppressWarnings({"WeakerAccess"})
public class AnaerobicHeartRateLowerLimitAndroid extends AnaerobicHeartRateLowerLimit implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AnaerobicHeartRateLowerLimitAndroid> CREATOR = new ByteArrayCreator<AnaerobicHeartRateLowerLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateLowerLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new AnaerobicHeartRateLowerLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateLowerLimitAndroid[] newArray(int size) {
            return new AnaerobicHeartRateLowerLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnaerobicHeartRateLowerLimitAndroid createFromByteArray(@NonNull byte[] values) {
            return new AnaerobicHeartRateLowerLimitAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A81
     */
    @Deprecated
    public AnaerobicHeartRateLowerLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AnaerobicHeartRateLowerLimitAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param anaerobicHeartRateUpperLimit Anaerobic Heart Rate Upper Limit
     */
    public AnaerobicHeartRateLowerLimitAndroid(int anaerobicHeartRateUpperLimit) {
        super(anaerobicHeartRateUpperLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnaerobicHeartRateLowerLimitAndroid(@NonNull Parcel in) {
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
