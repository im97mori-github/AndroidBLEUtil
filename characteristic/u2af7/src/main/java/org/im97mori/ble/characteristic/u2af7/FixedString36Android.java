package org.im97mori.ble.characteristic.u2af7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Fixed String 36 (Characteristics UUID: 0x2AF7)
 */
@SuppressWarnings({"WeakerAccess"})
public class FixedString36Android extends FixedString36 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FixedString36Android> CREATOR = new ByteArrayCreator<FixedString36Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString36Android createFromParcel(@NonNull Parcel in) {
            return new FixedString36Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString36Android[] newArray(int size) {
            return new FixedString36Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString36Android createFromByteArray(@NonNull byte[] values) {
            return new FixedString36Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF7
     */
    @Deprecated
    public FixedString36Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FixedString36Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param fixedString Fixed String
     */
    public FixedString36Android(@NonNull String fixedString) {
        super(fixedString);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString36Android(@NonNull Parcel in) {
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
