package org.im97mori.ble.characteristic.u2a92;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Resting Heart Rate (Characteristics UUID: 0x2A92)
 */
@SuppressWarnings({"WeakerAccess"})
public class RestingHeartRateAndroid extends RestingHeartRate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RestingHeartRateAndroid> CREATOR = new ByteArrayCreator<RestingHeartRateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RestingHeartRateAndroid createFromParcel(@NonNull Parcel in) {
            return new RestingHeartRateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RestingHeartRateAndroid[] newArray(int size) {
            return new RestingHeartRateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RestingHeartRateAndroid createFromByteArray(@NonNull byte[] values) {
            return new RestingHeartRateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A92
     */
    @Deprecated
    public RestingHeartRateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RestingHeartRateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param restingHeartRate Resting Heart Rate
     */
    public RestingHeartRateAndroid(int restingHeartRate) {
        super(restingHeartRate);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RestingHeartRateAndroid(@NonNull Parcel in) {
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
