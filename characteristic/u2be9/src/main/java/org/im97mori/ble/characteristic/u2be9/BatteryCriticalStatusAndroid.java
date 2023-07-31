package org.im97mori.ble.characteristic.u2be9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Battery Critical Status (Characteristics UUID: 0x2BE9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BatteryCriticalStatusAndroid extends BatteryCriticalStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BatteryCriticalStatusAndroid> CREATOR = new ByteArrayCreator<BatteryCriticalStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryCriticalStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new BatteryCriticalStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryCriticalStatusAndroid[] newArray(int size) {
            return new BatteryCriticalStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryCriticalStatusAndroid createFromByteArray(@NonNull byte[] values) {
            return new BatteryCriticalStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE9
     */
    @Deprecated
    public BatteryCriticalStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BatteryCriticalStatusAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryCriticalStatusAndroid(@NonNull Parcel in) {
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
