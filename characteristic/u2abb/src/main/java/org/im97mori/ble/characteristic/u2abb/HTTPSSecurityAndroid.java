package org.im97mori.ble.characteristic.u2abb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * HTTPS Security (Characteristics UUID: 0x2ABB)
 */
@SuppressWarnings({"WeakerAccess"})
public class HTTPSSecurityAndroid extends HTTPSSecurity implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HTTPSSecurityAndroid> CREATOR = new ByteArrayCreator<HTTPSSecurityAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPSSecurityAndroid createFromParcel(@NonNull Parcel in) {
            return new HTTPSSecurityAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPSSecurityAndroid[] newArray(int size) {
            return new HTTPSSecurityAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPSSecurityAndroid createFromByteArray(@NonNull byte[] values) {
            return new HTTPSSecurityAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABB
     */
    @Deprecated
    public HTTPSSecurityAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HTTPSSecurityAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param httpsSecurity HTTPS Security
     */
    public HTTPSSecurityAndroid(int httpsSecurity) {
        super(httpsSecurity);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPSSecurityAndroid(@NonNull Parcel in) {
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
