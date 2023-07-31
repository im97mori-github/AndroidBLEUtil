package org.im97mori.ble.characteristic.u2af5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Fixed String 16 (Characteristics UUID: 0x2AF5)
 */
@SuppressWarnings({"WeakerAccess"})
public class FixedString16Android extends FixedString16 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FixedString16Android> CREATOR = new ByteArrayCreator<FixedString16Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString16Android createFromParcel(@NonNull Parcel in) {
            return new FixedString16Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString16Android[] newArray(int size) {
            return new FixedString16Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString16Android createFromByteArray(@NonNull byte[] values) {
            return new FixedString16Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF5
     */
    @Deprecated
    public FixedString16Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FixedString16Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param fixedString Fixed String
     */
    public FixedString16Android(@NonNull String fixedString) {
        super(fixedString);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString16Android(@NonNull Parcel in) {
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
