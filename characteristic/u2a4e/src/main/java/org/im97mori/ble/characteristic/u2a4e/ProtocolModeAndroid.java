package org.im97mori.ble.characteristic.u2a4e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Protocol Mode (Characteristics UUID: 0x2A4E)
 */
@SuppressWarnings({"WeakerAccess"})
public class ProtocolModeAndroid extends ProtocolMode implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ProtocolModeAndroid> CREATOR = new ByteArrayCreator<ProtocolModeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ProtocolModeAndroid createFromParcel(@NonNull Parcel in) {
            return new ProtocolModeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ProtocolModeAndroid[] newArray(int size) {
            return new ProtocolModeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ProtocolModeAndroid createFromByteArray(@NonNull byte[] values) {
            return new ProtocolModeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4E
     */
    @Deprecated
    public ProtocolModeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ProtocolModeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param protocolModeValues Protocol Mode Value
     */
    public ProtocolModeAndroid(int protocolModeValues) {
        super(protocolModeValues);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ProtocolModeAndroid(@NonNull Parcel in) {
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
