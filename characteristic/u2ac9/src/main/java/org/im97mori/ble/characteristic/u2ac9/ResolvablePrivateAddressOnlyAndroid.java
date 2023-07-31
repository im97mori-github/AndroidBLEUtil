package org.im97mori.ble.characteristic.u2ac9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Resolvable Private Address Only (Characteristics UUID: 0x2AC9)
 */
@SuppressWarnings({"WeakerAccess"})
public class ResolvablePrivateAddressOnlyAndroid extends ResolvablePrivateAddressOnly implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ResolvablePrivateAddressOnlyAndroid> CREATOR = new ByteArrayCreator<ResolvablePrivateAddressOnlyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ResolvablePrivateAddressOnlyAndroid createFromParcel(@NonNull Parcel in) {
            return new ResolvablePrivateAddressOnlyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ResolvablePrivateAddressOnlyAndroid[] newArray(int size) {
            return new ResolvablePrivateAddressOnlyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ResolvablePrivateAddressOnlyAndroid createFromByteArray(@NonNull byte[] values) {
            return new ResolvablePrivateAddressOnlyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC9
     */
    @Deprecated
    public ResolvablePrivateAddressOnlyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ResolvablePrivateAddressOnlyAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param resolvablePrivateAddress Resolvable Private Address
     */
    public ResolvablePrivateAddressOnlyAndroid(int resolvablePrivateAddress) {
        super(resolvablePrivateAddress);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ResolvablePrivateAddressOnlyAndroid(@NonNull Parcel in) {
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
