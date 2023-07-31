package org.im97mori.ble.characteristic.u2ad7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Supported Heart Rate Range (Characteristics UUID: 0x2AD7)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedHeartRateRangeAndroid extends SupportedHeartRateRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SupportedHeartRateRangeAndroid> CREATOR = new ByteArrayCreator<SupportedHeartRateRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedHeartRateRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedHeartRateRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedHeartRateRangeAndroid[] newArray(int size) {
            return new SupportedHeartRateRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedHeartRateRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new SupportedHeartRateRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD7
     */
    @Deprecated
    public SupportedHeartRateRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SupportedHeartRateRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumHeartRate Minimum Heart Rate
     * @param maximumHeartRate Maximum Heart Rate
     * @param minimumIncrement Minimum Increment
     */
    public SupportedHeartRateRangeAndroid(int minimumHeartRate, int maximumHeartRate, int minimumIncrement) {
        super(minimumHeartRate, maximumHeartRate, minimumIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedHeartRateRangeAndroid(@NonNull Parcel in) {
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
