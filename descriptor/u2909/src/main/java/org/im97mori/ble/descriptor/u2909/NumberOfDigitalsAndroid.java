package org.im97mori.ble.descriptor.u2909;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Number of Digitals (Descriptor UUID: 0x2909)
 */
@SuppressWarnings({"WeakerAccess"})
public class NumberOfDigitalsAndroid extends NumberOfDigitals implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<NumberOfDigitalsAndroid> CREATOR = new ByteArrayCreator<NumberOfDigitalsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public NumberOfDigitalsAndroid createFromParcel(@NonNull Parcel in) {
            return new NumberOfDigitalsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public NumberOfDigitalsAndroid[] newArray(int size) {
            return new NumberOfDigitalsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NumberOfDigitalsAndroid createFromByteArray(@NonNull byte[] values) {
            return new NumberOfDigitalsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2909
     */
    @Deprecated
    public NumberOfDigitalsAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public NumberOfDigitalsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param noOfDigitals No of Digitals
     */
    public NumberOfDigitalsAndroid(int noOfDigitals) {
        super(noOfDigitals);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NumberOfDigitalsAndroid(@NonNull Parcel in) {
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
