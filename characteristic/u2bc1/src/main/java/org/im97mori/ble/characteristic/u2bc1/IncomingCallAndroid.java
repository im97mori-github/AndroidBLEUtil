package org.im97mori.ble.characteristic.u2bc1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Incoming Call (Characteristics UUID: 0x2BC1)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IncomingCallAndroid extends IncomingCall implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IncomingCallAndroid> CREATOR = new ByteArrayCreator<IncomingCallAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncomingCallAndroid createFromParcel(@NonNull Parcel in) {
            return new IncomingCallAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncomingCallAndroid[] newArray(int size) {
            return new IncomingCallAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IncomingCallAndroid createFromByteArray(@NonNull byte[] values) {
            return new IncomingCallAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC1
     */
    @Deprecated
    public IncomingCallAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IncomingCallAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IncomingCallAndroid(@NonNull Parcel in) {
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
