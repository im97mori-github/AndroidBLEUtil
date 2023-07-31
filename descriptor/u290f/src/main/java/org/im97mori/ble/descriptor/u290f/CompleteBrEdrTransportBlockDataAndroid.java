package org.im97mori.ble.descriptor.u290f;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Complete BR-EDR Transport Block Data (Descriptor UUID: 0x290F)
 */
@SuppressWarnings({"WeakerAccess"})
public class CompleteBrEdrTransportBlockDataAndroid extends CompleteBrEdrTransportBlockData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CompleteBrEdrTransportBlockDataAndroid> CREATOR = new ByteArrayCreator<CompleteBrEdrTransportBlockDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CompleteBrEdrTransportBlockDataAndroid createFromParcel(@NonNull Parcel in) {
            return new CompleteBrEdrTransportBlockDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CompleteBrEdrTransportBlockDataAndroid[] newArray(int size) {
            return new CompleteBrEdrTransportBlockDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CompleteBrEdrTransportBlockDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new CompleteBrEdrTransportBlockDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2909
     */
    @Deprecated
    public CompleteBrEdrTransportBlockDataAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public CompleteBrEdrTransportBlockDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CompleteBrEdrTransportBlockDataAndroid(@NonNull Parcel in) {
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
