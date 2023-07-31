package org.im97mori.ble.characteristic.u2ab7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * HTTP Headers (Characteristics UUID: 0x2AB7)
 */
@SuppressWarnings({"WeakerAccess"})
public class HTTPHeadersAndroid extends HTTPHeaders implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HTTPHeadersAndroid> CREATOR = new ByteArrayCreator<HTTPHeadersAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPHeadersAndroid createFromParcel(@NonNull Parcel in) {
            return new HTTPHeadersAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPHeadersAndroid[] newArray(int size) {
            return new HTTPHeadersAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPHeadersAndroid createFromByteArray(@NonNull byte[] values) {
            return new HTTPHeadersAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB7
     */
    @Deprecated
    public HTTPHeadersAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HTTPHeadersAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param httpHeaders HTTP Headers
     */
    public HTTPHeadersAndroid(@NonNull String httpHeaders) {
        super(httpHeaders);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPHeadersAndroid(@NonNull Parcel in) {
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
