package org.im97mori.ble.characteristic.u2aa9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * CGM Status (Characteristics UUID: 0x2AA9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CgmStatusAndroid extends CgmStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CgmStatusAndroid> CREATOR = new ByteArrayCreator<CgmStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new CgmStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmStatusAndroid[] newArray(int size) {
            return new CgmStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CgmStatusAndroid createFromByteArray(@NonNull byte[] values) {
            return new CgmStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA9
     */
    @Deprecated
    public CgmStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CgmStatusAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CgmStatusAndroid(@NonNull Parcel in) {
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
