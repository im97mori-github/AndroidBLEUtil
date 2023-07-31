package org.im97mori.ble.characteristic.u2bb4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bearer UCI (Characteristics UUID: 0x2BB4)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerUciAndroid extends BearerUci implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BearerUciAndroid> CREATOR = new ByteArrayCreator<BearerUciAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerUciAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerUciAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerUciAndroid[] newArray(int size) {
            return new BearerUciAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerUciAndroid createFromByteArray(@NonNull byte[] values) {
            return new BearerUciAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB4
     */
    @Deprecated
    public BearerUciAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BearerUciAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerUciAndroid(@NonNull Parcel in) {
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
