package org.im97mori.ble.characteristic.u2a96;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * VO2 Max (Characteristics UUID: 0x2A96)
 */
@SuppressWarnings({"WeakerAccess"})
public class VO2MaxAndroid extends VO2Max implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VO2MaxAndroid> CREATOR = new ByteArrayCreator<VO2MaxAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VO2MaxAndroid createFromParcel(@NonNull Parcel in) {
            return new VO2MaxAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VO2MaxAndroid[] newArray(int size) {
            return new VO2MaxAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VO2MaxAndroid createFromByteArray(@NonNull byte[] values) {
            return new VO2MaxAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A96
     */
    @Deprecated
    public VO2MaxAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public VO2MaxAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param vo2Max VO2 Max
     */
    public VO2MaxAndroid(int vo2Max) {
        super(vo2Max);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VO2MaxAndroid(@NonNull Parcel in) {
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
