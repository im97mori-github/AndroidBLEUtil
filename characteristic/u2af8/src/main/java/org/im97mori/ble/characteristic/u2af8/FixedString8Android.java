package org.im97mori.ble.characteristic.u2af8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Fixed String 8 (Characteristics UUID: 0x2AF8)
 */
@SuppressWarnings({"WeakerAccess"})
public class FixedString8Android extends FixedString8 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FixedString8Android> CREATOR = new ByteArrayCreator<FixedString8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString8Android createFromParcel(@NonNull Parcel in) {
            return new FixedString8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString8Android[] newArray(int size) {
            return new FixedString8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString8Android createFromByteArray(@NonNull byte[] values) {
            return new FixedString8Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF8
     */
    @Deprecated
    public FixedString8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FixedString8Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param fixedString Fixed String
     */
    public FixedString8Android(@NonNull String fixedString) {
        super(fixedString);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString8Android(@NonNull Parcel in) {
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
