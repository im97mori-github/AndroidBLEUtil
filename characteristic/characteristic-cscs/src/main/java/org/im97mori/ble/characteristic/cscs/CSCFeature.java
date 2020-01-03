package org.im97mori.ble.characteristic.cscs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CSC_FEATURE_CHARACTERISTIC;

/**
 * CSC Feature (Characteristics UUID: 0x2A5C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CSCFeature implements ByteArrayInterface, Parcelable {

    /**
     * @see #CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
     * @see #CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
     */
    public static final int CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_MASK = 0b00000000_00000001;

    /**
     * 0: Wheel Revolution Data Supported False
     */
    public static final int CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE = 0b00000000_00000000;

    /**
     * 1: Wheel Revolution Data Supported True
     */
    public static final int CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE = 0b00000000_00000001;

    /**
     * @see #CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
     * @see #CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE
     */
    public static final int CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_MASK = 0b00000000_00000010;

    /**
     * 0: Crank Revolution Data Supported False
     */
    public static final int CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE = 0b00000000_00000000;

    /**
     * 1: Crank Revolution Data Supported True
     */
    public static final int CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE = 0b00000000_00000010;

    /**
     * @see #CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE
     * @see #CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
     */
    public static final int CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_MASK = 0b00000000_00000100;

    /**
     * 0: Multiple Sensor Locations Supported False
     */
    public static final int CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE = 0b00000000_00000000;

    /**
     * 1: Multiple Sensor Locations Supported True
     */
    public static final int CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE = 0b00000000_00000100;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CSCFeature> CREATOR = new ByteArrayCreater<CSCFeature>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CSCFeature createFromParcel(@NonNull Parcel in) {
            return new CSCFeature(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CSCFeature[] newArray(int size) {
            return new CSCFeature[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CSCFeature createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CSC_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CSCFeature(bluetoothGattCharacteristic);
        }

    };

    /**
     * CSC Feature
     */
    private final byte[] mCscFeature;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5C
     */
    public CSCFeature(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCscFeature = Arrays.copyOfRange(values, 0, 2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CSCFeature(@NonNull Parcel in) {
        mCscFeature = in.createByteArray();
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
        dest.writeByteArray(mCscFeature);
    }

    /**
     * @return CSC Feature
     */
    public byte[] getCscFeature() {
        return mCscFeature;
    }

    /**
     * @return {@code true}:Wheel Revolution Data not Supported, {@code false}:Wheel Revolution Data Supported
     */
    public boolean isCscFeatureWheelRevolutionDataNotSupported() {
        return isFeatureMatched(CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_MASK, CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Wheel Revolution Data Supported, {@code false}:Wheel Revolution Data not Supported
     */
    public boolean isCscFeatureWheelRevolutionDataSupported() {
        return isFeatureMatched(CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_MASK, CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Crank Revolution Data not Supported, {@code false}:Crank Revolution Data Supported
     */
    public boolean isCscFeatureCrankRevolutionDataSupportedNotSupported() {
        return isFeatureMatched(CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_MASK, CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Crank Revolution Data Supported, {@code false}:Crank Revolution Data not Supported
     */
    public boolean isCscFeatureCrankRevolutionDataSupportedSupported() {
        return isFeatureMatched(CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_MASK, CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Multiple Sensor Locations not Supported, {@code false}:Multiple Sensor Locations Supported
     */
    public boolean isCscFeatureMultipleSensorLocationsSupportedNotSupported() {
        return isFeatureMatched(CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_MASK, CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Multiple Sensor Locations Supported, {@code false}:Multiple Sensor Locations not Supported
     */
    public boolean isCscFeatureMultipleSensorLocationsSupportedSupported() {
        return isFeatureMatched(CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_MASK, CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mCscFeature);
        return data;
    }

    /**
     * check CSC Feature
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE}
     *               , {@link #CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE}
     *               , {@link #CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE}
     *               , {@link #CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE}
     *               , {@link #CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE}
     *               , {@link #CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFeatureMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mCscFeature, 0)) == expect;
    }

}
