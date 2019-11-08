package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.REPORT_REFERENCE_DESCRIPTOR;

/**
 * Report Reference (Descriptor UUID: 0x2908)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ReportReference implements ByteArrayInterface, Parcelable {

    /**
     * Report Type:Input Report
     */
    public static final int REPORT_TYPE_INPUT_REPORT = 0x01;

    /**
     * Report Type:Output Report
     */
    public static final int REPORT_TYPE_OUTPUT_REPORT = 0x02;

    /**
     * Report Type:Feature Report
     */
    public static final int REPORT_TYPE_FEATURE_REPORT = 0x03;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReportReference> CREATOR = new ByteArrayCreater<ReportReference>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ReportReference createFromParcel(Parcel in) {
            return new ReportReference(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ReportReference[] newArray(int size) {
            return new ReportReference[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReportReference createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(REPORT_REFERENCE_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ReportReference(bluetoothGattDescriptor);
        }

    };

    /**
     * Report ID
     */
    private final int mReportId;

    /**
     * Report Type
     */
    private final int mReportType;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2908
     */
    public ReportReference(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mReportId = (values[0] & 0xff);
        mReportType = (values[1] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReportReference(Parcel in) {
        mReportId = in.readInt();
        mReportType = in.readInt();
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
        dest.writeInt(mReportId);
        dest.writeInt(mReportType);
    }

    /**
     * @return Report ID
     */
    public int getReportId() {
        return mReportId;
    }

    /**
     * @return Report Type
     */
    public int getReportType() {
        return mReportType;
    }

    /**
     * @return {@code true}:report type is {@link #REPORT_TYPE_INPUT_REPORT}, {@code false}:not {@link #REPORT_TYPE_INPUT_REPORT}
     */
    public boolean isReportTypeInputReport() {
        return REPORT_TYPE_INPUT_REPORT == mReportType;
    }

    /**
     * @return {@code true}:report type is {@link #REPORT_TYPE_OUTPUT_REPORT}, {@code false}:not {@link #REPORT_TYPE_OUTPUT_REPORT}
     */
    public boolean isReportTypeOutputReport() {
        return REPORT_TYPE_OUTPUT_REPORT == mReportType;
    }

    /**
     * @return {@code true}:report type is {@link #REPORT_TYPE_FEATURE_REPORT}, {@code false}:not {@link #REPORT_TYPE_FEATURE_REPORT}
     */
    public boolean isReportTypeFeatureReport() {
        return REPORT_TYPE_FEATURE_REPORT == mReportType;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mReportId);
        byteBuffer.put((byte) mReportType);
        return data;
    }

}
