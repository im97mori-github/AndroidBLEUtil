package org.im97mori.ble.characteristic.u2a3f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Alert Status (Characteristics UUID: 0x2A3F)
 */
@SuppressWarnings({"WeakerAccess"})
public class AlertStatusAndroid extends AlertStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AlertStatusAndroid> CREATOR = new ByteArrayCreator<AlertStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new AlertStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertStatusAndroid[] newArray(int size) {
            return new AlertStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertStatusAndroid createFromByteArray(@NonNull byte[] values) {
            return new AlertStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A3F
     */
    @Deprecated
    public AlertStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AlertStatusAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param alertStatus Alert Status
     */
    public AlertStatusAndroid(int alertStatus) {
        super(alertStatus);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertStatusAndroid(@NonNull Parcel in) {
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
