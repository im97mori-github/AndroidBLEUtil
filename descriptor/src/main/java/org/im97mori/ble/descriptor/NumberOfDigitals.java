package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.NUMBEROF_DIGITALS_DESCRIPTOR;

/**
 * Number of Digitals (Descriptor UUID: 0x2909)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class NumberOfDigitals implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<NumberOfDigitals> CREATOR = new ByteArrayCreater<NumberOfDigitals>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public NumberOfDigitals createFromParcel(Parcel in) {
            return new NumberOfDigitals(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public NumberOfDigitals[] newArray(int size) {
            return new NumberOfDigitals[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NumberOfDigitals createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(NUMBEROF_DIGITALS_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new NumberOfDigitals(bluetoothGattDescriptor);
        }

    };

    /**
     * No of Digitals
     */
    private final int mNoOfDigitals;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2909
     */
    public NumberOfDigitals(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mNoOfDigitals = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NumberOfDigitals(Parcel in) {
        mNoOfDigitals = in.readInt();
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNoOfDigitals);
    }

    /**
     * @return No of Digitals
     */
    public int getNoOfDigitals() {
        return mNoOfDigitals;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mNoOfDigitals);
        return data;
    }

}
