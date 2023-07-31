package org.im97mori.ble.characteristic.u2b2c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * BSS Response (Characteristics UUID: 0x2B2C)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BssResponseAndroid extends BssResponse implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BssResponseAndroid> CREATOR = new ByteArrayCreator<BssResponseAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BssResponseAndroid createFromParcel(@NonNull Parcel in) {
            return new BssResponseAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BssResponseAndroid[] newArray(int size) {
            return new BssResponseAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BssResponseAndroid createFromByteArray(@NonNull byte[] values) {
            return new BssResponseAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B2C
     */
    @Deprecated
    public BssResponseAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BssResponseAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BssResponseAndroid(@NonNull Parcel in) {
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
