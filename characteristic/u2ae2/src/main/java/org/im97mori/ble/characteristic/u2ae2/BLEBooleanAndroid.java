package org.im97mori.ble.characteristic.u2ae2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Boolean (Characteristics UUID: 0x2AE2)
 */
// TODO
public class BLEBooleanAndroid extends BLEBoolean implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BLEBooleanAndroid> CREATOR = new ByteArrayCreator<BLEBooleanAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BLEBooleanAndroid createFromParcel(@NonNull Parcel in) {
            return new BLEBooleanAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BLEBooleanAndroid[] newArray(int size) {
            return new BLEBooleanAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BLEBooleanAndroid createFromByteArray(@NonNull byte[] values) {
            return new BLEBooleanAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE2
     */
    @Deprecated
    public BLEBooleanAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BLEBooleanAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param booleanValue Boolean value
     */
    public BLEBooleanAndroid(int booleanValue) {
        super(booleanValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BLEBooleanAndroid(@NonNull Parcel in) {
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
