package org.im97mori.ble.characteristic.u2b49;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Stride Length (Characteristics UUID: 0x2B49)
 */
@SuppressWarnings({"WeakerAccess"})
public class StrideLengthAndroid extends StrideLength implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<StrideLengthAndroid> CREATOR = new ByteArrayCreator<StrideLengthAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StrideLengthAndroid createFromParcel(@NonNull Parcel in) {
            return new StrideLengthAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StrideLengthAndroid[] newArray(int size) {
            return new StrideLengthAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public StrideLengthAndroid createFromByteArray(@NonNull byte[] values) {
            return new StrideLengthAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B49
     */
    @Deprecated
    public StrideLengthAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public StrideLengthAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param strideLength Stride Length
     */
    public StrideLengthAndroid(int strideLength) {
        super(strideLength);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private StrideLengthAndroid(@NonNull Parcel in) {
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
