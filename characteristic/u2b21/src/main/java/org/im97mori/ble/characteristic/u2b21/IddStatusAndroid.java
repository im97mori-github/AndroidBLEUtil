package org.im97mori.ble.characteristic.u2b21;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * IDD Status (Characteristics UUID: 0x2B21)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddStatusAndroid extends IddStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IddStatusAndroid> CREATOR = new ByteArrayCreator<IddStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new IddStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddStatusAndroid[] newArray(int size) {
            return new IddStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddStatusAndroid createFromByteArray(@NonNull byte[] values) {
            return new IddStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B21
     */
    @Deprecated
    public IddStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IddStatusAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddStatusAndroid(@NonNull Parcel in) {
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
