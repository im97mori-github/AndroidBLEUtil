package org.im97mori.ble.characteristic.u2a73;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Apparent Wind Direction (Characteristics UUID: 0x2A73)
 */
@SuppressWarnings({"WeakerAccess"})
public class ApparentWindDirectionAndroid extends ApparentWindDirection implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ApparentWindDirectionAndroid> CREATOR = new ByteArrayCreator<ApparentWindDirectionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindDirectionAndroid createFromParcel(@NonNull Parcel in) {
            return new ApparentWindDirectionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindDirectionAndroid[] newArray(int size) {
            return new ApparentWindDirectionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentWindDirectionAndroid createFromByteArray(@NonNull byte[] values) {
            return new ApparentWindDirectionAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A73
     */
    @Deprecated
    public ApparentWindDirectionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ApparentWindDirectionAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param apparentWindDirection Apparent Wind Direction
     */
    public ApparentWindDirectionAndroid(int apparentWindDirection) {
        super(apparentWindDirection);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentWindDirectionAndroid(@NonNull Parcel in) {
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
