package org.im97mori.ble.characteristic.u2ab4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Uncertainty (Characteristics UUID: 0x2AB4)
 */
@SuppressWarnings({"WeakerAccess"})
public class UncertaintyAndroid extends Uncertainty implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<UncertaintyAndroid> CREATOR = new ByteArrayCreator<UncertaintyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UncertaintyAndroid createFromParcel(@NonNull Parcel in) {
            return new UncertaintyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UncertaintyAndroid[] newArray(int size) {
            return new UncertaintyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UncertaintyAndroid createFromByteArray(@NonNull byte[] values) {
            return new UncertaintyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB4
     */
    @Deprecated
    public UncertaintyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public UncertaintyAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param uncertainty Uncertainty
     */
    public UncertaintyAndroid(int uncertainty) {
        super(uncertainty);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UncertaintyAndroid(@NonNull Parcel in) {
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
