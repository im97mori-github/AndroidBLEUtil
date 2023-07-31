package org.im97mori.ble.characteristic.u2a7b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Dew Point (Characteristics UUID: 0x2A7B)
 */
@SuppressWarnings({"WeakerAccess"})
public class DewPointAndroid extends DewPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DewPointAndroid> CREATOR = new ByteArrayCreator<DewPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DewPointAndroid createFromParcel(@NonNull Parcel in) {
            return new DewPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DewPointAndroid[] newArray(int size) {
            return new DewPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DewPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new DewPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7B
     */
    @Deprecated
    public DewPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DewPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param dewPoint Dew Point
     */
    public DewPointAndroid(int dewPoint) {
        super(dewPoint);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DewPointAndroid(@NonNull Parcel in) {
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
