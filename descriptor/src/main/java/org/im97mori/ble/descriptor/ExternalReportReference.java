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
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.EXTERNAL_REPORT_REFERENCE_DESCRIPTOR;

/**
 * External Report Reference (Descriptor UUID: 0x2907)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ExternalReportReference implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ExternalReportReference> CREATOR = new ByteArrayCreater<ExternalReportReference>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ExternalReportReference createFromParcel(Parcel in) {
            return new ExternalReportReference(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExternalReportReference[] newArray(int size) {
            return new ExternalReportReference[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ExternalReportReference createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ExternalReportReference(bluetoothGattDescriptor);
        }

    };

    /**
     * External Report Reference
     */
    private final byte[] mExternalReportReference;

    /**
     * External Report Reference UUID
     */
    private final UUID mUuid;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2907
     */
    public ExternalReportReference(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mExternalReportReference = Arrays.copyOfRange(values, 0, 2);

        // combine with BASE UUID
        long target = mExternalReportReference[0] & 0xff;
        target |= (mExternalReportReference[1] & 0xff) << 8;
        target = target << 32;
        mUuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ExternalReportReference(Parcel in) {
        mExternalReportReference = in.createByteArray();
        mUuid = (UUID) in.readSerializable();
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
        dest.writeByteArray(mExternalReportReference);
        dest.writeSerializable(mUuid);
    }

    /**
     * @return External Report Reference
     */
    @NonNull
    public byte[] getExternalReportReference() {
        return mExternalReportReference;
    }

    /**
     * @return External Report Reference UUID
     */
    @NonNull
    public UUID getExternalReportReferenceUuid() {
        return mUuid;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mExternalReportReference);
        return data;
    }

}
