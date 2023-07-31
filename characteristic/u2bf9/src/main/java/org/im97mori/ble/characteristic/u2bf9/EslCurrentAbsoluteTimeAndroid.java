package org.im97mori.ble.characteristic.u2bf9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * ESL Current Absolute Time (Characteristics UUID: 0x2BF9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EslCurrentAbsoluteTimeAndroid extends EslCurrentAbsoluteTime implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EslCurrentAbsoluteTimeAndroid> CREATOR = new ByteArrayCreator<EslCurrentAbsoluteTimeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslCurrentAbsoluteTimeAndroid createFromParcel(@NonNull Parcel in) {
            return new EslCurrentAbsoluteTimeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslCurrentAbsoluteTimeAndroid[] newArray(int size) {
            return new EslCurrentAbsoluteTimeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EslCurrentAbsoluteTimeAndroid createFromByteArray(@NonNull byte[] values) {
            return new EslCurrentAbsoluteTimeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BF9
     */
    @Deprecated
    public EslCurrentAbsoluteTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EslCurrentAbsoluteTimeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EslCurrentAbsoluteTimeAndroid(@NonNull Parcel in) {
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
