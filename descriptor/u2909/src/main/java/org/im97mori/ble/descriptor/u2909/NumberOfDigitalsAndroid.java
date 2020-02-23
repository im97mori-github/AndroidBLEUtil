package org.im97mori.ble.descriptor.u2909;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.NUMBEROF_DIGITALS_DESCRIPTOR;

/**
 * Number of Digitals (Descriptor UUID: 0x2909)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
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
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(NUMBEROF_DIGITALS_DESCRIPTOR, 0);
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
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
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
