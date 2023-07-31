package org.im97mori.ble.descriptor.u2908;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Report Reference (Descriptor UUID: 0x2908)
 */
@SuppressWarnings({"WeakerAccess"})
public class ReportReferenceAndroid extends ReportReference implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ReportReferenceAndroid> CREATOR = new ByteArrayCreator<ReportReferenceAndroid>() {

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
            return new ReportReferenceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2908
     */
    @Deprecated
    public ReportReferenceAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public ReportReferenceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param reportId   Report ID
     * @param reportType Report Type
     */
    public ReportReferenceAndroid(int reportId, int reportType) {
        super(reportId, reportType);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReportReferenceAndroid(@NonNull Parcel in) {
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
