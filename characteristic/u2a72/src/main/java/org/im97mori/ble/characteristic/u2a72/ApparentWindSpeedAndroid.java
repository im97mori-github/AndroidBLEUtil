package org.im97mori.ble.characteristic.u2a72;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Apparent Wind Speed (Characteristics UUID: 0x2A72)
 */
@SuppressWarnings({"WeakerAccess"})
public class ApparentWindSpeedAndroid extends ApparentWindSpeed implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ApparentWindSpeedAndroid> CREATOR = new ByteArrayCreator<ApparentWindSpeedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindSpeedAndroid createFromParcel(@NonNull Parcel in) {
            return new ApparentWindSpeedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindSpeedAndroid[] newArray(int size) {
            return new ApparentWindSpeedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentWindSpeedAndroid createFromByteArray(@NonNull byte[] values) {
            return new ApparentWindSpeedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A72
     */
    @Deprecated
    public ApparentWindSpeedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ApparentWindSpeedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param apparentWindSpeed Apparent Wind Speed
     */
    public ApparentWindSpeedAndroid(int apparentWindSpeed) {
        super(apparentWindSpeed);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentWindSpeedAndroid(@NonNull Parcel in) {
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
