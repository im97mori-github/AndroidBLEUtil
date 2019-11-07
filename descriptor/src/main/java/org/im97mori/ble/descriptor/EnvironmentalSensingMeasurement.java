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
     * Sampling Function:Unspecified
     */
    public static final int SAMPLING_FUNCTION_UNSPECIFIED = 0x00;

    /**
     * Sampling Function:Instantaneous
     */
    public static final int SAMPLING_FUNCTION_INSTANTANEOUS = 0x01;

    /**
     * Sampling Function:Arithmetic Mean
     */
    public static final int SAMPLING_FUNCTION_ARITHMETIC_MEAN = 0x02;

    /**
     * Sampling Function:RMS
     */
    public static final int SAMPLING_FUNCTION_RMS = 0x03;

    /**
     * Sampling Function:Maximum
     */
    public static final int SAMPLING_FUNCTION_MAXIMUM = 0x04;

    /**
     * Sampling Function:Minimum
     */
    public static final int SAMPLING_FUNCTION_MINIMUM = 0x05;

    /**
     * Sampling Function:Accumulated
     */
    public static final int SAMPLING_FUNCTION_ACCUMULATED = 0x06;

    /**
     * Sampling Function:Count
     */
    public static final int SAMPLING_FUNCTION_COUNT = 0x07;

    /**
     * Measurement Period:Not in use
     */
    public static final int MEASUREMENT_PERIOD_NOT_IN_USE = 0x00;

    /**
     * Internal Update Interval:Not in use
     */
    public static final int INTERNAL_UPDATE_INTERVAL_NOT_IN_USE = 0x00;

    /**
     * Application:Unspecified
     */
    public static final int APPLICATION_UNSPECIFIED = 0x00;

    /**
     * Application:Air
     */
    public static final int APPLICATION_AIR = 0x01;

    /**
     * Application:Water
     */
    public static final int APPLICATION_WATER = 0x02;

    /**
     * Application:Barometric
     */
    public static final int APPLICATION_BAROMETRIC = 0x03;

    /**
     * Application:Soil
     */
    public static final int APPLICATION_SOIL = 0x04;

    /**
     * Application:Infrared
     */
    public static final int APPLICATION_INFRARED = 0x05;

    /**
     * Application:Map Database
     */
    public static final int APPLICATION_MAP_DATABASE = 0x06;

    /**
     * Application:Barometric Elevation Source
     */
    public static final int APPLICATION_BAROMETRIC_ELEVATION_SOURCE = 0x07;

    /**
     * Application:GPS only Elevation Source
     */
    public static final int APPLICATION_GPS_ONLY_ELEVATION_SOURCE = 0x08;

    /**
     * Application:GPS and Map database Elevation Source
     */
    public static final int APPLICATION_GPS_AND_MAP_DATABASE_ELEVATION_SOURCE = 0x09;

    /**
     * Application:Vertical datum Elevation Source
     */
    public static final int APPLICATION_VERTICAL_DATUM_ELEVATION_SOURCE = 0x0a;

    /**
     * Application:Onshore
     */
    public static final int APPLICATION_ONSHORE = 0x0b;

    /**
     * Application:Onboard vessel or vehicle
     */
    public static final int APPLICATION_ONBOARD_VESSEL_OR_VEHICLE = 0x0c;

    /**
     * Application:Front
     */
    public static final int APPLICATION_FRONT = 0x0d;

    /**
     * Application:Back/Rear
     */
    public static final int APPLICATION_BACK_REAR = 0x0e;

    /**
     * Application:Upper
     */
    public static final int APPLICATION_UPPER = 0x0f;

    /**
     * Application:Lower
     */
    public static final int APPLICATION_LOWER = 0x10;

    /**
     * Application:Primary
     */
    public static final int APPLICATION_PRIMARY = 0x11;

    /**
     * Application:Secondary
     */
    public static final int APPLICATION_SECONDARY = 0x12;

    /**
     * Application:Outdoor
     */
    public static final int APPLICATION_OUTDOOR = 0x13;

    /**
     * Application:Indoor
     */
    public static final int APPLICATION_INDOOR = 0x14;

    /**
     * Application:Top
     */
    public static final int APPLICATION_TOP = 0x15;

    /**
     * Application:Bottom
     */
    public static final int APPLICATION_BOTTOM = 0x16;

    /**
     * Application:Main
     */
    public static final int APPLICATION_MAIN = 0x17;

    /**
     * Application:Backup
     */
    public static final int APPLICATION_BACKUP = 0x18;

    /**
     * Application:Auxiliary
     */
    public static final int APPLICATION_AUXILIARY = 0x19;

    /**
     * Application:Supplementary
     */
    public static final int APPLICATION_SUPPLEMENTARY = 0x1a;

    /**
     * Application:Inside
     */
    public static final int APPLICATION_INSIDE = 0x1b;

    /**
     * Application:Outside
     */
    public static final int APPLICATION_OUTSIDE = 0x1c;

    /**
     * Application:Left
     */
    public static final int APPLICATION_LEFT = 0x1d;

    /**
     * Application:Right
     */
    public static final int APPLICATION_RIGHT = 0x1e;

    /**
     * Application:Internal
     */
    public static final int APPLICATION_INTERNAL = 0x1f;

    /**
     * Application:External
     */
    public static final int APPLICATION_EXTERNAL = 0x20;

    /**
     * Application:Solar
     */
    public static final int APPLICATION_SOLAR = 0x21;

    /**
     * Measurement Uncertainty:nformation not available
     */
    public static final int MEASUREMENT_UNCERTAINTY_INFORMATION_NOT_AVAILABLE = 0xff;

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
     * @return {@code true}:sampling function is {@link #SAMPLING_FUNCTION_UNSPECIFIED}, {@code false}:not {@link #SAMPLING_FUNCTION_UNSPECIFIED}
     */
    public boolean isSamplingFunctionUnspecified() {
        return mSamplingFunction == SAMPLING_FUNCTION_UNSPECIFIED;
    }

    /**
     * @return {@code true}:sampling function is {@link #SAMPLING_FUNCTION_INSTANTANEOUS}, {@code false}:not {@link #SAMPLING_FUNCTION_INSTANTANEOUS}
     */
    public boolean isSamplingFunctionInstantaneous() {
        return mSamplingFunction == SAMPLING_FUNCTION_INSTANTANEOUS;
    }

    /**
     * @return {@code true}:sampling function is {@link #SAMPLING_FUNCTION_ARITHMETIC_MEAN}, {@code false}:not {@link #SAMPLING_FUNCTION_ARITHMETIC_MEAN}
     */
    public boolean isSamplingFunctionArithmeticMean() {
        return mSamplingFunction == SAMPLING_FUNCTION_ARITHMETIC_MEAN;
    }

    /**
     * @return {@code true}:sampling function is {@link #SAMPLING_FUNCTION_RMS}, {@code false}:not {@link #SAMPLING_FUNCTION_RMS}
     */
    public boolean isSamplingFunctionRms() {
        return mSamplingFunction == SAMPLING_FUNCTION_RMS;
    }

    /**
     * @return {@code true}:sampling function is {@link #SAMPLING_FUNCTION_MAXIMUM}, {@code false}:not {@link #SAMPLING_FUNCTION_MAXIMUM}
     */
    public boolean isSamplingFunctionMaximum() {
        return mSamplingFunction == SAMPLING_FUNCTION_MAXIMUM;
    }

    /**
     * @return {@code true}:sampling function is {@link #SAMPLING_FUNCTION_MINIMUM}, {@code false}:not {@link #SAMPLING_FUNCTION_MINIMUM}
     */
    public boolean isSamplingFunctionMinimum() {
        return mSamplingFunction == SAMPLING_FUNCTION_MINIMUM;
    }

    /**
     * @return {@code true}:sampling function is {@link #SAMPLING_FUNCTION_ACCUMULATED}, {@code false}:not {@link #SAMPLING_FUNCTION_ACCUMULATED}
     */
    public boolean isSamplingFunctionAccumulated() {
        return mSamplingFunction == SAMPLING_FUNCTION_ACCUMULATED;
    }

    /**
     * @return {@code true}:sampling function is {@link #SAMPLING_FUNCTION_COUNT}, {@code false}:not {@link #SAMPLING_FUNCTION_COUNT}
     */
    public boolean isSamplingFunctionCount() {
        return mSamplingFunction == SAMPLING_FUNCTION_COUNT;
    }

    /**
     * @return Measurement Period
     */
    public int getMeasurementPeriod() {
        return mMeasurementPeriod;
    }

    /**
     * @return {@code true}:measurement period is {@link #SAMPLING_FUNCTION_COUNT}, {@code false}:not {@link #SAMPLING_FUNCTION_COUNT}
     */
    public boolean isMeasurementPeriodNotInIUse() {
        return mMeasurementPeriod == MEASUREMENT_PERIOD_NOT_IN_USE;
    }

    /**
     * @return Internal Update Interval
     */
    public int getInternalUpdateInterval() {
        return mInternalUpdateInterval;
    }

    /**
     * @return {@code true}:internal update interval is {@link #INTERNAL_UPDATE_INTERVAL_NOT_IN_USE}, {@code false}:not {@link #INTERNAL_UPDATE_INTERVAL_NOT_IN_USE}
     */
    public boolean isInternalUpdateIntervalNotInIUse() {
        return mInternalUpdateInterval == INTERNAL_UPDATE_INTERVAL_NOT_IN_USE;
    }

    /**
     * @return Application
     */
    public int getApplication() {
        return mApplication;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_UNSPECIFIED}, {@code false}:not {@link #APPLICATION_UNSPECIFIED}
     */
    public boolean isApplicationUnspecified() {
        return mApplication == APPLICATION_UNSPECIFIED;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_AIR}, {@code false}:not {@link #APPLICATION_AIR}
     */
    public boolean isApplicationAir() {
        return mApplication == APPLICATION_AIR;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_WATER}, {@code false}:not {@link #APPLICATION_WATER}
     */
    public boolean isApplicationWater() {
        return mApplication == APPLICATION_WATER;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_BAROMETRIC}, {@code false}:not {@link #APPLICATION_BAROMETRIC}
     */
    public boolean isApplicationBarometric() {
        return mApplication == APPLICATION_BAROMETRIC;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_SOIL}, {@code false}:not {@link #APPLICATION_SOIL}
     */
    public boolean isApplicationSoil() {
        return mApplication == APPLICATION_SOIL;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_INFRARED}, {@code false}:not {@link #APPLICATION_INFRARED}
     */
    public boolean isApplicationInfrared() {
        return mApplication == APPLICATION_INFRARED;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_MAP_DATABASE}, {@code false}:not {@link #APPLICATION_MAP_DATABASE}
     */
    public boolean isApplicationMapDatabase() {
        return mApplication == APPLICATION_MAP_DATABASE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_BAROMETRIC_ELEVATION_SOURCE}, {@code false}:not {@link #APPLICATION_BAROMETRIC_ELEVATION_SOURCE}
     */
    public boolean isApplicationBarometricElevationSource() {
        return mApplication == APPLICATION_BAROMETRIC_ELEVATION_SOURCE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_GPS_ONLY_ELEVATION_SOURCE}, {@code false}:not {@link #APPLICATION_GPS_ONLY_ELEVATION_SOURCE}
     */
    public boolean isApplicationGpsOnlyElevationSource() {
        return mApplication == APPLICATION_GPS_ONLY_ELEVATION_SOURCE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_GPS_AND_MAP_DATABASE_ELEVATION_SOURCE}, {@code false}:not {@link #APPLICATION_GPS_AND_MAP_DATABASE_ELEVATION_SOURCE}
     */
    public boolean isApplicationGpsAndMapDatabaseElevationSource() {
        return mApplication == APPLICATION_GPS_AND_MAP_DATABASE_ELEVATION_SOURCE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_VERTICAL_DATUM_ELEVATION_SOURCE}, {@code false}:not {@link #APPLICATION_VERTICAL_DATUM_ELEVATION_SOURCE}
     */
    public boolean isApplicationVerticalDatumElevationSource() {
        return mApplication == APPLICATION_VERTICAL_DATUM_ELEVATION_SOURCE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_ONSHORE}, {@code false}:not {@link #APPLICATION_ONSHORE}
     */
    public boolean isApplicationOnshore() {
        return mApplication == APPLICATION_ONSHORE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_ONBOARD_VESSEL_OR_VEHICLE}, {@code false}:not {@link #APPLICATION_ONBOARD_VESSEL_OR_VEHICLE}
     */
    public boolean isApplicationOnboardVesselOrVehicle() {
        return mApplication == APPLICATION_ONBOARD_VESSEL_OR_VEHICLE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_FRONT}, {@code false}:not {@link #APPLICATION_FRONT}
     */
    public boolean isApplicationFront() {
        return mApplication == APPLICATION_FRONT;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_BACK_REAR}, {@code false}:not {@link #APPLICATION_BACK_REAR}
     */
    public boolean isApplicationBackRear() {
        return mApplication == APPLICATION_BACK_REAR;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_UPPER}, {@code false}:not {@link #APPLICATION_UPPER}
     */
    public boolean isApplicationUpper() {
        return mApplication == APPLICATION_UPPER;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_LOWER}, {@code false}:not {@link #APPLICATION_LOWER}
     */
    public boolean isApplicationLower() {
        return mApplication == APPLICATION_LOWER;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_PRIMARY}, {@code false}:not {@link #APPLICATION_PRIMARY}
     */
    public boolean isApplicationPrimary() {
        return mApplication == APPLICATION_PRIMARY;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_SECONDARY}, {@code false}:not {@link #APPLICATION_SECONDARY}
     */
    public boolean isApplicationSecondary() {
        return mApplication == APPLICATION_SECONDARY;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_OUTDOOR}, {@code false}:not {@link #APPLICATION_OUTDOOR}
     */
    public boolean isApplicationOutdoor() {
        return mApplication == APPLICATION_OUTDOOR;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_INDOOR}, {@code false}:not {@link #APPLICATION_INDOOR}
     */
    public boolean isApplicationIndoor() {
        return mApplication == APPLICATION_INDOOR;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_TOP}, {@code false}:not {@link #APPLICATION_TOP}
     */
    public boolean isApplicationTop() {
        return mApplication == APPLICATION_TOP;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_BOTTOM}, {@code false}:not {@link #APPLICATION_BOTTOM}
     */
    public boolean isApplicationBottom() {
        return mApplication == APPLICATION_BOTTOM;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_MAIN}, {@code false}:not {@link #APPLICATION_MAIN}
     */
    public boolean isApplicationMain() {
        return mApplication == APPLICATION_MAIN;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_BACKUP}, {@code false}:not {@link #APPLICATION_BACKUP}
     */
    public boolean isApplicationBackup() {
        return mApplication == APPLICATION_BACKUP;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_AUXILIARY}, {@code false}:not {@link #APPLICATION_AUXILIARY}
     */
    public boolean isApplicationAuxiliary() {
        return mApplication == APPLICATION_AUXILIARY;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_SUPPLEMENTARY}, {@code false}:not {@link #APPLICATION_SUPPLEMENTARY}
     */
    public boolean isApplicationSupplementary() {
        return mApplication == APPLICATION_SUPPLEMENTARY;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_INSIDE}, {@code false}:not {@link #APPLICATION_INSIDE}
     */
    public boolean isApplicationInside() {
        return mApplication == APPLICATION_INSIDE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_OUTSIDE}, {@code false}:not {@link #APPLICATION_OUTSIDE}
     */
    public boolean isApplicationOutside() {
        return mApplication == APPLICATION_OUTSIDE;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_LEFT}, {@code false}:not {@link #APPLICATION_LEFT}
     */
    public boolean isApplicationLeft() {
        return mApplication == APPLICATION_LEFT;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_RIGHT}, {@code false}:not {@link #APPLICATION_RIGHT}
     */
    public boolean isApplicationRight() {
        return mApplication == APPLICATION_RIGHT;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_INTERNAL}, {@code false}:not {@link #APPLICATION_INTERNAL}
     */
    public boolean isApplicationInternal() {
        return mApplication == APPLICATION_INTERNAL;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_EXTERNAL}, {@code false}:not {@link #APPLICATION_EXTERNAL}
     */
    public boolean isApplicationExternal() {
        return mApplication == APPLICATION_EXTERNAL;
    }

    /**
     * @return {@code true}:application is {@link #APPLICATION_SOLAR}, {@code false}:not {@link #APPLICATION_SOLAR}
     */
    public boolean isApplicationSolar() {
        return mApplication == APPLICATION_SOLAR;
    }

    /**
     * @return Measurement Uncertainty
     */
    public int getMeasurementUncertainty() {
        return mMeasurementUncertainty;
    }

    /**
     * @return {@code true}:measurement uncertainty is {@link #MEASUREMENT_UNCERTAINTY_INFORMATION_NOT_AVAILABLE}, {@code false}:not {@link #MEASUREMENT_UNCERTAINTY_INFORMATION_NOT_AVAILABLE}
     */
    public boolean isMeasurementUncertaintyInformationNotAvailable() {
        return mMeasurementUncertainty == MEASUREMENT_UNCERTAINTY_INFORMATION_NOT_AVAILABLE;
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
