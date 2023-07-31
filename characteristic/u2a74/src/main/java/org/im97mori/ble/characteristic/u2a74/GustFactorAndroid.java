package org.im97mori.ble.characteristic.u2a74;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Gust Factor (Characteristics UUID: 0x2A74)
 */
@SuppressWarnings({"WeakerAccess"})
public class GustFactorAndroid extends GustFactor implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<GustFactorAndroid> CREATOR = new ByteArrayCreator<GustFactorAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GustFactorAndroid createFromParcel(@NonNull Parcel in) {
            return new GustFactorAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GustFactorAndroid[] newArray(int size) {
            return new GustFactorAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GustFactorAndroid createFromByteArray(@NonNull byte[] values) {
            return new GustFactorAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A74
     */
    @Deprecated
    public GustFactorAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public GustFactorAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param gustFactor Gust Factor
     */
    public GustFactorAndroid(int gustFactor) {
        super(gustFactor);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GustFactorAndroid(@NonNull Parcel in) {
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
