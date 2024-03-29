package org.im97mori.ble.characteristic.u2a23;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * System ID (Characteristics UUID: 0x2A23)
 */
@SuppressWarnings({"WeakerAccess"})
public class SystemIdAndroid extends SystemId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SystemIdAndroid> CREATOR = new ByteArrayCreator<SystemIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SystemIdAndroid createFromParcel(@NonNull Parcel in) {
            return new SystemIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SystemIdAndroid[] newArray(int size) {
            return new SystemIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SystemIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new SystemIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A23
     */
    @Deprecated
    public SystemIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SystemIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param manufacturerIdentifier           Manufacturer Identifier
     * @param organizationallyUniqueIdentifier Organizationally Unique Identifier
     */
    public SystemIdAndroid(long manufacturerIdentifier, int organizationallyUniqueIdentifier) {
        super(manufacturerIdentifier, organizationallyUniqueIdentifier);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SystemIdAndroid(@NonNull Parcel in) {
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
