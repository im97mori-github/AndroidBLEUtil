package org.im97mori.ble.characteristic.u2b84;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Set Identity Resolving Key Characteristic (Characteristics UUID: 0x2B84)
 */
@SuppressWarnings({"WeakerAccess"})
public class SetIdentityResolvingKeyCharacteristicAndroid extends SetIdentityResolvingKeyCharacteristic implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SetIdentityResolvingKeyCharacteristicAndroid> CREATOR = new ByteArrayCreator<SetIdentityResolvingKeyCharacteristicAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SetIdentityResolvingKeyCharacteristicAndroid createFromParcel(@NonNull Parcel in) {
            return new SetIdentityResolvingKeyCharacteristicAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SetIdentityResolvingKeyCharacteristicAndroid[] newArray(int size) {
            return new SetIdentityResolvingKeyCharacteristicAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SetIdentityResolvingKeyCharacteristicAndroid createFromByteArray(@NonNull byte[] values) {
            return new SetIdentityResolvingKeyCharacteristicAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B84
     */
    @Deprecated
    public SetIdentityResolvingKeyCharacteristicAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SetIdentityResolvingKeyCharacteristicAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param type  Type
     * @param value Value
     */
    public SetIdentityResolvingKeyCharacteristicAndroid(int type, @NonNull byte[] value) {
        super(type, value);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SetIdentityResolvingKeyCharacteristicAndroid(@NonNull Parcel in) {
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
