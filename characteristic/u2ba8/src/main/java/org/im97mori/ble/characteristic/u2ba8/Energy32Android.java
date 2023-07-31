package org.im97mori.ble.characteristic.u2ba8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Energy 32 (Characteristics UUID: 0x2BA8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Energy32Android extends Energy32 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<Energy32Android> CREATOR = new ByteArrayCreator<Energy32Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Energy32Android createFromParcel(@NonNull Parcel in) {
            return new Energy32Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Energy32Android[] newArray(int size) {
            return new Energy32Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Energy32Android createFromByteArray(@NonNull byte[] values) {
            return new Energy32Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA8
     */
    @Deprecated
    public Energy32Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public Energy32Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Energy32Android(@NonNull Parcel in) {
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
