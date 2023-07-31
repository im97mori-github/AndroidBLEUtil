package org.im97mori.ble.characteristic.u2b47;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * High Resolution Height (Characteristics UUID: 0x2B47)
 */
@SuppressWarnings({"WeakerAccess"})
public class HighResolutionHeightAndroid extends HighResolutionHeight implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HighResolutionHeightAndroid> CREATOR = new ByteArrayCreator<HighResolutionHeightAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighResolutionHeightAndroid createFromParcel(@NonNull Parcel in) {
            return new HighResolutionHeightAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighResolutionHeightAndroid[] newArray(int size) {
            return new HighResolutionHeightAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HighResolutionHeightAndroid createFromByteArray(@NonNull byte[] values) {
            return new HighResolutionHeightAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B47
     */
    @Deprecated
    public HighResolutionHeightAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HighResolutionHeightAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param height Height
     */
    public HighResolutionHeightAndroid(int height) {
        super(height);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HighResolutionHeightAndroid(@NonNull Parcel in) {
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
