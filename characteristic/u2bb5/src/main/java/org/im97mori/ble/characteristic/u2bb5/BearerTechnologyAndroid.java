package org.im97mori.ble.characteristic.u2bb5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bearer Technology (Characteristics UUID: 0x2BB5)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerTechnologyAndroid extends BearerTechnology implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BearerTechnologyAndroid> CREATOR = new ByteArrayCreator<BearerTechnologyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerTechnologyAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerTechnologyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerTechnologyAndroid[] newArray(int size) {
            return new BearerTechnologyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerTechnologyAndroid createFromByteArray(@NonNull byte[] values) {
            return new BearerTechnologyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB5
     */
    @Deprecated
    public BearerTechnologyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BearerTechnologyAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerTechnologyAndroid(@NonNull Parcel in) {
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
