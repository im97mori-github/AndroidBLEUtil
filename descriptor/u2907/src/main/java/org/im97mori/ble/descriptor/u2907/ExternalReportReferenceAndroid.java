package org.im97mori.ble.descriptor.u2907;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;
import java.util.UUID;

/**
 * External Report Reference (Descriptor UUID: 0x2907)
 */
@SuppressWarnings({"WeakerAccess"})
public class ExternalReportReferenceAndroid extends ExternalReportReference implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ExternalReportReferenceAndroid> CREATOR = new ByteArrayCreator<ExternalReportReferenceAndroid>() {

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
            return new ExternalReportReferenceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2907
     */
    @Deprecated
    public ExternalReportReferenceAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public ExternalReportReferenceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param externalReportReference External Report Reference
     * @param uuid                    External Report Reference UUID
     */
    public ExternalReportReferenceAndroid(@NonNull byte[] externalReportReference, @NonNull UUID uuid) {
        super(externalReportReference, uuid);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ExternalReportReferenceAndroid(@NonNull Parcel in) {
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
