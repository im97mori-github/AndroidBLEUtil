package org.im97mori.ble.characteristic.u2aae;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Latitude (Characteristics UUID: 0x2AAE)
 */
@SuppressWarnings({"WeakerAccess"})
public class LatitudeAndroid extends Latitude implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LatitudeAndroid> CREATOR = new ByteArrayCreator<LatitudeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LatitudeAndroid createFromParcel(@NonNull Parcel in) {
            return new LatitudeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LatitudeAndroid[] newArray(int size) {
            return new LatitudeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LatitudeAndroid createFromByteArray(@NonNull byte[] values) {
            return new LatitudeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAE
     */
    @Deprecated
    public LatitudeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LatitudeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param latitude Latitude
     */
    public LatitudeAndroid(int latitude) {
        super(latitude);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LatitudeAndroid(@NonNull Parcel in) {
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
