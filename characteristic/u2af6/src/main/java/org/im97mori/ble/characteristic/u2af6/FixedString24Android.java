package org.im97mori.ble.characteristic.u2af6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Fixed String 24 (Characteristics UUID: 0x2AF6)
 */
@SuppressWarnings({"WeakerAccess"})
public class FixedString24Android extends FixedString24 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FixedString24Android> CREATOR = new ByteArrayCreator<FixedString24Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString24Android createFromParcel(@NonNull Parcel in) {
            return new FixedString24Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString24Android[] newArray(int size) {
            return new FixedString24Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString24Android createFromByteArray(@NonNull byte[] values) {
            return new FixedString24Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF6
     */
    @Deprecated
    public FixedString24Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FixedString24Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param fixedString Fixed String
     */
    public FixedString24Android(@NonNull String fixedString) {
        super(fixedString);
    }


    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString24Android(@NonNull Parcel in) {
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
