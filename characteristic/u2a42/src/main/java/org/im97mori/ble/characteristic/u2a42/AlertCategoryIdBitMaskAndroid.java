package org.im97mori.ble.characteristic.u2a42;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Alert Category ID Bit Mask (Characteristics UUID: 0x2A42)
 */
@SuppressWarnings({"WeakerAccess"})
public class AlertCategoryIdBitMaskAndroid extends AlertCategoryIdBitMask implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AlertCategoryIdBitMaskAndroid> CREATOR = new ByteArrayCreator<AlertCategoryIdBitMaskAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertCategoryIdBitMaskAndroid createFromParcel(@NonNull Parcel in) {
            return new AlertCategoryIdBitMaskAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertCategoryIdBitMaskAndroid[] newArray(int size) {
            return new AlertCategoryIdBitMaskAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertCategoryIdBitMaskAndroid createFromByteArray(@NonNull byte[] values) {
            return new AlertCategoryIdBitMaskAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A42
     */
    @Deprecated
    public AlertCategoryIdBitMaskAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AlertCategoryIdBitMaskAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertCategoryIdBitMaskAndroid(@NonNull Parcel in) {
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
