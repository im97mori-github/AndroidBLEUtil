package org.im97mori.ble.characteristic.u2bb7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bearer Signal Strength (Characteristics UUID: 0x2BB7)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerSignalStrengthAndroid extends BearerSignalStrength implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BearerSignalStrengthAndroid> CREATOR = new ByteArrayCreator<BearerSignalStrengthAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerSignalStrengthAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerSignalStrengthAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerSignalStrengthAndroid[] newArray(int size) {
            return new BearerSignalStrengthAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerSignalStrengthAndroid createFromByteArray(@NonNull byte[] values) {
            return new BearerSignalStrengthAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB7
     */
    @Deprecated
    public BearerSignalStrengthAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BearerSignalStrengthAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerSignalStrengthAndroid(@NonNull Parcel in) {
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
