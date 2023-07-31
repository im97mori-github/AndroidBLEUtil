package org.im97mori.ble.characteristic.u2b2d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Emergency ID (Characteristics UUID: 0x2B2D)
 */
@SuppressWarnings({"WeakerAccess"})
public class EmergencyIdAndroid extends EmergencyId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EmergencyIdAndroid> CREATOR = new ByteArrayCreator<EmergencyIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmergencyIdAndroid createFromParcel(@NonNull Parcel in) {
            return new EmergencyIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmergencyIdAndroid[] newArray(int size) {
            return new EmergencyIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EmergencyIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new EmergencyIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B2D
     */
    @Deprecated
    public EmergencyIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EmergencyIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EmergencyIdAndroid(@NonNull Parcel in) {
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
