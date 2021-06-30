package org.im97mori.ble.descriptor.u290f;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.DescriptorUUID.COMPLETE_BR_EDR_TRANSPORT_BLOCK_DATA_DESCRIPTOR;

/**
 * Complete BR-EDR Transport Block Data (Descriptor UUID: 0x290F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CompleteBrEdrTransportBlockDataAndroid extends CompleteBrEdrTransportBlockData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CompleteBrEdrTransportBlockDataAndroid> CREATOR = new ByteArrayCreater<CompleteBrEdrTransportBlockDataAndroid>() {

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
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(COMPLETE_BR_EDR_TRANSPORT_BLOCK_DATA_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2909
     */
    public CompleteBrEdrTransportBlockDataAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CompleteBrEdrTransportBlockDataAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
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
