package org.im97mori.ble.characteristic.u2ab6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * URI (Characteristics UUID: 0x2AB6)
 */
@SuppressWarnings({"WeakerAccess"})
public class URIAndroid extends URI implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<URIAndroid> CREATOR = new ByteArrayCreator<URIAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public URIAndroid createFromParcel(@NonNull Parcel in) {
            return new URIAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public URIAndroid[] newArray(int size) {
            return new URIAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public URIAndroid createFromByteArray(@NonNull byte[] values) {
            return new URIAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB6
     */
    @Deprecated
    public URIAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public URIAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param uri URI
     */
    public URIAndroid(@NonNull String uri) {
        super(uri);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private URIAndroid(@NonNull Parcel in) {
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
