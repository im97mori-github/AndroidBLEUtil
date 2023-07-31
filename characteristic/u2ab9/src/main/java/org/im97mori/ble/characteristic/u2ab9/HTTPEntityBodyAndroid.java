package org.im97mori.ble.characteristic.u2ab9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * HTTP Entity Body (Characteristics UUID: 0x2AB9)
 */
@SuppressWarnings({"WeakerAccess"})
public class HTTPEntityBodyAndroid extends HTTPEntityBody implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HTTPEntityBodyAndroid> CREATOR = new ByteArrayCreator<HTTPEntityBodyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPEntityBodyAndroid createFromParcel(@NonNull Parcel in) {
            return new HTTPEntityBodyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPEntityBodyAndroid[] newArray(int size) {
            return new HTTPEntityBodyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPEntityBodyAndroid createFromByteArray(@NonNull byte[] values) {
            return new HTTPEntityBodyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB9
     */
    @Deprecated
    public HTTPEntityBodyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HTTPEntityBodyAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param httpEntityBody HTTP Entity Body
     */
    public HTTPEntityBodyAndroid(@NonNull String httpEntityBody) {
        super(httpEntityBody);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPEntityBodyAndroid(@NonNull Parcel in) {
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
