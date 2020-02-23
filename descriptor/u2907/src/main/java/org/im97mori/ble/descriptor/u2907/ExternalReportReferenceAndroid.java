package org.im97mori.ble.descriptor.u2907;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.EXTERNAL_REPORT_REFERENCE_DESCRIPTOR;

/**
 * External Report Reference (Descriptor UUID: 0x2907)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ExternalReportReferenceAndroid extends ExternalReportReference implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ExternalReportReferenceAndroid> CREATOR = new ByteArrayCreater<ExternalReportReferenceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ExternalReportReferenceAndroid createFromParcel(@NonNull Parcel in) {
            return new ExternalReportReferenceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExternalReportReferenceAndroid[] newArray(int size) {
            return new ExternalReportReferenceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ExternalReportReferenceAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ExternalReportReferenceAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2907
     */
    public ExternalReportReferenceAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ExternalReportReferenceAndroid(@NonNull Parcel in) {
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
