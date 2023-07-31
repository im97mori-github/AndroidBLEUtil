package org.im97mori.ble.characteristic.u2bb3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bearer Provider Name (Characteristics UUID: 0x2BB3)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerProviderNameAndroid extends BearerProviderName implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BearerProviderNameAndroid> CREATOR = new ByteArrayCreator<BearerProviderNameAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerProviderNameAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerProviderNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerProviderNameAndroid[] newArray(int size) {
            return new BearerProviderNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerProviderNameAndroid createFromByteArray(@NonNull byte[] values) {
            return new BearerProviderNameAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB3
     */
    @Deprecated
    public BearerProviderNameAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BearerProviderNameAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerProviderNameAndroid(@NonNull Parcel in) {
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
