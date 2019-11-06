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

import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;

/**
 * Environmental Sensing Measurement (Descriptor UUID: 0x290C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class EnvironmentalSensingMeasurement implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EnvironmentalSensingMeasurement> CREATOR = new ByteArrayCreater<EnvironmentalSensingMeasurement>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingMeasurement createFromParcel(Parcel in) {
            return new EnvironmentalSensingMeasurement(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingMeasurement[] newArray(int size) {
            return new EnvironmentalSensingMeasurement[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnvironmentalSensingMeasurement createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new EnvironmentalSensingMeasurement(bluetoothGattDescriptor);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Sampling Function
     */
    private final int mSamplingFunction;

    /**
     * Measurement Period
     */
    private final int mMeasurementPeriod;

    /**
     * Internal Update Interval
     */
    private final int mInternalUpdateInterval;

    /**
     * Application
     */
    private final int mApplication;

    /**
     * Measurement Uncertainty
     */
    private final int mMeasurementUncertainty;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290C
     */
    public EnvironmentalSensingMeasurement(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mFlags = Arrays.copyOfRange(values, 0, 2);
        mSamplingFunction = (values[2] & 0xff);
        mMeasurementPeriod = (values[3] & 0xff) | ((values[4] & 0xff) << 8) | ((values[5] & 0xff) << 16);
        mInternalUpdateInterval = (values[6] & 0xff) | ((values[7] & 0xff) << 8) | ((values[8] & 0xff) << 16);
        mApplication = (values[9] & 0xff);
        mMeasurementUncertainty = (values[10] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnvironmentalSensingMeasurement(Parcel in) {
        mFlags = in.createByteArray();
        mSamplingFunction = in.readInt();
        mMeasurementPeriod = in.readInt();
        mInternalUpdateInterval = in.readInt();
        mApplication = in.readInt();
        mMeasurementUncertainty = in.readInt();
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
        dest.writeByteArray(mFlags);
        dest.writeInt(mSamplingFunction);
        dest.writeInt(mMeasurementPeriod);
        dest.writeInt(mInternalUpdateInterval);
        dest.writeInt(mApplication);
        dest.writeInt(mMeasurementUncertainty);
    }

    /**
     * @return Flags
     */
    @NonNull
    public byte[] getFlags() {
        return mFlags;
    }

    /**
     * @return Sampling Function
     */
    public int getSamplingFunction() {
        return mSamplingFunction;
    }

    /**
     * @return Measurement Period
     */
    public int getMeasurementPeriod() {
        return mMeasurementPeriod;
    }

    /**
     * @return Internal Update Interval
     */
    public int getInternalUpdateInterval() {
        return mInternalUpdateInterval;
    }

    /**
     * @return Application
     */
    public int getApplication() {
        return mApplication;
    }

    /**
     * @return Measurement Uncertainty
     */
    public int getMeasurementUncertainty() {
        return mMeasurementUncertainty;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[11];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        byteBuffer.put((byte) mSamplingFunction);
        byteBuffer.put((byte) mMeasurementPeriod);
        byteBuffer.put((byte) (mMeasurementPeriod >> 8));
        byteBuffer.put((byte) (mMeasurementPeriod >> 16));
        byteBuffer.put((byte) mInternalUpdateInterval);
        byteBuffer.put((byte) (mInternalUpdateInterval >> 8));
        byteBuffer.put((byte) (mInternalUpdateInterval >> 16));
        byteBuffer.put((byte) mApplication);
        byteBuffer.put((byte) mMeasurementUncertainty);
        return data;
    }

}
