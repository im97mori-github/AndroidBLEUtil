package org.im97mori.ble.descriptor.u2908;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.REPORT_REFERENCE_DESCRIPTOR;

/**
 * Report Reference (Descriptor UUID: 0x2908)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ReportReferenceAndroid extends ReportReference implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReportReferenceAndroid> CREATOR = new ByteArrayCreater<ReportReferenceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ReportReferenceAndroid createFromParcel(@NonNull Parcel in) {
            return new ReportReferenceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ReportReferenceAndroid[] newArray(int size) {
            return new ReportReferenceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReportReferenceAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(REPORT_REFERENCE_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ReportReferenceAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2908
     */
    public ReportReferenceAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ReportReferenceAndroid(@NonNull Parcel in) {
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
