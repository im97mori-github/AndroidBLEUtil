package org.im97mori.ble.descriptor.u290c;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Environmental Sensing Measurement (Descriptor UUID: 0x290C)
 */
@SuppressWarnings({"WeakerAccess"})
public class EnvironmentalSensingMeasurementAndroid extends EnvironmentalSensingMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EnvironmentalSensingMeasurementAndroid> CREATOR = new ByteArrayCreator<EnvironmentalSensingMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new EnvironmentalSensingMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingMeasurementAndroid[] newArray(int size) {
            return new EnvironmentalSensingMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnvironmentalSensingMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new EnvironmentalSensingMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290C
     */
    @Deprecated
    public EnvironmentalSensingMeasurementAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public EnvironmentalSensingMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnvironmentalSensingMeasurementAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
    }

    /**
     * Constructor from parameters
     *
     * @param flags                  Flags
     * @param samplingFunction       Sampling Function
     * @param measurementPeriod      Measurement Period
     * @param internalUpdateInterval Internal Update Interval
     * @param application            Application
     * @param measurementUncertainty Measurement Uncertainty
     */
    public EnvironmentalSensingMeasurementAndroid(@NonNull byte[] flags, int samplingFunction, int measurementPeriod, int internalUpdateInterval, int application, int measurementUncertainty) {
        super(flags, samplingFunction, measurementPeriod, internalUpdateInterval, application, measurementUncertainty);
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
