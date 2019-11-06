package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;

/**
 * Valid Range (Descriptor UUID: 0x2906)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ValidRange implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ValidRange> CREATOR = new ByteArrayCreater<ValidRange>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ValidRange createFromParcel(Parcel in) {
            return new ValidRange(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ValidRange[] newArray(int size) {
            return new ValidRange[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ValidRange createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ValidRange(bluetoothGattDescriptor);
        }

    };

    /**
     * Lower inclusive value
     */
    private final byte[] mLowerInclusiveValue;

    /**
     * Upper inclusive value
     */
    private final byte[] mUpperInclusiveValue;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2906
     */
    public ValidRange(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mLowerInclusiveValue = Arrays.copyOfRange(values, 0, values.length / 2);
        mUpperInclusiveValue = Arrays.copyOfRange(values, values.length / 2, values.length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ValidRange(Parcel in) {
        mLowerInclusiveValue = in.createByteArray();
        mUpperInclusiveValue = in.createByteArray();
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
        dest.writeByteArray(mLowerInclusiveValue);
        dest.writeByteArray(mUpperInclusiveValue);
    }

    /**
     * @return Lower inclusive value
     */
    @NonNull
    public byte[] getLowerInclusiveValue() {
        return mLowerInclusiveValue;
    }

    /**
     * @return Upper inclusive value
     */
    @NonNull
    public byte[] getUpperInclusiveValue() {
        return mUpperInclusiveValue;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[mLowerInclusiveValue.length + mUpperInclusiveValue.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mLowerInclusiveValue);
        byteBuffer.put(mUpperInclusiveValue);
        return data;
    }

}
