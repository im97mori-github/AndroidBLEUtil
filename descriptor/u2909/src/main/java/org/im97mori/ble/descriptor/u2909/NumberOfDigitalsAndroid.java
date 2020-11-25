package org.im97mori.ble.descriptor.u2909;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.NUMBER_OF_DIGITALS_DESCRIPTOR;

/**
 * Number of Digitals (Descriptor UUID: 0x2909)
 */
@SuppressWarnings({"WeakerAccess"})
public class NumberOfDigitalsAndroid extends NumberOfDigitals implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<NumberOfDigitalsAndroid> CREATOR = new ByteArrayCreater<NumberOfDigitalsAndroid>() {

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
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(NUMBER_OF_DIGITALS_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new NumberOfDigitalsAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2909
     */
    public NumberOfDigitalsAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
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
        super(in.createByteArray());
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
