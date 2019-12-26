package org.im97mori.ble.characteristic.wss;

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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_SCALE_FEATURE_CHARACTERISTIC;

/**
 * Weight Scale Feature (Characteristics UUID: 0x2A9E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class WeightScaleFeature implements ByteArrayInterface, Parcelable {

    /**
     * @see #WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_FALSE
     * @see #WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_TRUE
     */
    public static final int WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_MASK = 0b00000001;

    /**
     * 0: Time Stamp Supported False
     */
    public static final int WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_FALSE = 0b00000000;

    /**
     * 1: Time Stamp Supported True
     */
    public static final int WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_TRUE = 0b00000001;

    /**
     * @see #WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_FALSE
     * @see #WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_TRUE
     */
    public static final int WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_MASK = 0b00000010;

    /**
     * 0: Multiple Users Supported False
     */
    public static final int WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_FALSE = 0b00000000;

    /**
     * 1: Multiple Users Supported True
     */
    public static final int WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_TRUE = 0b00000010;

    /**
     * @see #WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_FALSE
     * @see #WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_TRUE
     */
    public static final int WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_MASK = 0b00000100;

    /**
     * 0: BMI Supported False
     */
    public static final int WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_FALSE = 0b00000000;

    /**
     * 1: BMI Supported True
     */
    public static final int WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_TRUE = 0b00000100;

    /**
     * @see #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
     * @see #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_5KG_OR_1LB
     * @see #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_2KG_OR_0_5LB
     * @see #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_1KG_OR_0_2LB
     * @see #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_05KG_OR_0_1B
     * @see #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_02KG_OR_0_05B
     * @see #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01KG_OR_0_02B
     * @see #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005KG_OR_0_01B
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK = 0b01111000;

    /**
     * 0: Not Specified
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED = 0b00000000;

    /**
     * 1: Resolution of 0.5 kg or 1 lb
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_5KG_OR_1LB = 0b00001000;

    /**
     * 2: Resolution of 0.2 kg or 0.5 lb
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_2KG_OR_0_5LB = 0b00010000;

    /**
     * 3: Resolution of 0.1 kg or 0.2 lb
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_1KG_OR_0_2LB = 0b00011000;

    /**
     * 4: Resolution of 0.05 kg or 0.1 lb
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_05KG_OR_0_1B = 0b00100000;

    /**
     * 5: Resolution of 0.02 kg or 0.05 lb
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_02KG_OR_0_05B = 0b00101000;

    /**
     * 6: Resolution of 0.01 kg or 0.02 lb
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01KG_OR_0_02B = 0b00110000;

    /**
     * 7: Resolution of 0.005 kg or 0.01 lb
     */
    public static final int WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005KG_OR_0_01B = 0b00111000;

    /**
     * @see #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
     * @see #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01_METER_OR_1INCH
     * @see #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005METER_OR_0_5INCH
     * @see #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_001METER_OR_0_1INCH
     */
    public static final int WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_MASK = 0b00000011_10000000;

    /**
     * 0: Not Specified
     */
    public static final int WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED = 0b00000000_00000000;

    /**
     * 1: Resolution of 0.01 meter or 1 inch
     */
    public static final int WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01_METER_OR_1INCH = 0b00000000_10000000;

    /**
     * 2: Resolution of 0.005 meter or 0.5 inch
     */
    public static final int WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005METER_OR_0_5INCH = 0b0000001_00000000;

    /**
     * 3: Resolution of 0.001 meter or 0.1 inch
     */
    public static final int WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_001METER_OR_0_1INCH = 0b0000001_10000000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<WeightScaleFeature> CREATOR = new ByteArrayCreater<WeightScaleFeature>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightScaleFeature createFromParcel(@NonNull Parcel in) {
            return new WeightScaleFeature(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightScaleFeature[] newArray(int size) {
            return new WeightScaleFeature[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WeightScaleFeature createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WEIGHT_SCALE_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WeightScaleFeature(bluetoothGattCharacteristic);
        }

    };

    /**
     * Weight Scale Feature
     */
    private final byte[] mWeightScaleFeature;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9E
     */
    public WeightScaleFeature(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mWeightScaleFeature = Arrays.copyOfRange(values, 0, 4);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WeightScaleFeature(@NonNull Parcel in) {
        mWeightScaleFeature = in.createByteArray();
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
        dest.writeByteArray(mWeightScaleFeature);
    }

    /**
     * @return Weight Scale Feature
     */
    @NonNull
    public byte[] getWeightScaleFeature() {
        return mWeightScaleFeature;
    }

    /**
     * @return {@code true}:Time Stamp Supported, {@code false}:Time Stamp not Supported
     */
    public boolean isWeightScaleFeatureTimeStampSupported() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_MASK, WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Time Stamp not Supported, {@code false}:Time Stamp Supported
     */
    public boolean isWeightScaleFeatureTimeStampNotSupported() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_MASK, WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Multiple Users Supported, {@code false}:Multiple Users not Supported
     */
    public boolean isWeightScaleFeatureMultipleUsersSupported() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_MASK, WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Multiple Users not Supported, {@code false}:Multiple Users Supported
     */
    public boolean isWeightScaleFeatureMultipleUsersNotSupported() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_MASK, WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:BMI Supported, {@code false}:BMI not Supported
     */
    public boolean isWeightScaleFeatureBmiSupported() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_MASK, WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:BMI not Supported, {@code false}:BMI Supported
     */
    public boolean isWeightScaleFeatureBmiNotSupported() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_MASK, WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Weight Measurement Resolution Not Specified, {@code false}:Weight Measurement Resolution Specified
     */
    public boolean isWeightScaleFeatureWeightScaleMeasurementResolutionNotSpecified() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);
    }

    /**
     * @return {@code true}:Weight Measurement Resolution is 0.5 kg or 1 lb, {@code false}:Weight Measurement Resolution is not 0.5 kg or 1 lb
     */
    public boolean isWeightScaleFeatureWeightScaleMeasurementResolution1() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_5KG_OR_1LB);
    }

    /**
     * @return {@code true}:Weight Measurement Resolution is 0.2 kg or 0.5 lb, {@code false}:Weight Measurement Resolution is not 0.2 kg or 0.5 lb
     */
    public boolean isWeightScaleFeatureWeightScaleMeasurementResolution2() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_2KG_OR_0_5LB);
    }

    /**
     * @return {@code true}:Weight Measurement Resolution is 0.1 kg or 0.2 lb, {@code false}:Weight Measurement Resolution is not 0.1 kg or 0.2 lb
     */
    public boolean isWeightScaleFeatureWeightScaleMeasurementResolution3() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_1KG_OR_0_2LB);
    }

    /**
     * @return {@code true}:Weight Measurement Resolution is 0.05 kg or 0.1 lb, {@code false}:Weight Measurement Resolution is not 0.05 kg or 0.1 lb
     */
    public boolean isWeightScaleFeatureWeightScaleMeasurementResolution4() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_05KG_OR_0_1B);
    }

    /**
     * @return {@code true}:Weight Measurement Resolution is 0.02 kg or 0.05 lb, {@code false}:Weight Measurement Resolution is not 0.02 kg or 0.05 lb
     */
    public boolean isWeightScaleFeatureWeightScaleMeasurementResolution5() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_02KG_OR_0_05B);
    }

    /**
     * @return {@code true}:Weight Measurement Resolution is 0.01 kg or 0.02 lb, {@code false}:Weight Measurement Resolution is not 0.01 kg or 0.02 lb
     */
    public boolean isWeightScaleFeatureWeightScaleMeasurementResolution6() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01KG_OR_0_02B);
    }

    /**
     * @return {@code true}:Weight Measurement Resolution is 0.005 kg or 0.01 lb, {@code false}:Weight Measurement Resolution is not 0.005 kg or 0.01 lb
     */
    public boolean isWeightScaleFeatureWeightScaleMeasurementResolution7() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005KG_OR_0_01B);
    }

    /**
     * @return {@code true}:Height Resolution Not Specified, {@code false}:Height Resolution Specified
     */
    public boolean isWeightScaleFeatureHeightMeasurementResolutionNotSpecified() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);
    }

    /**
     * @return {@code true}:Height Resolution is 0.01 meter or 1 inch, {@code false}:Height Resolution is not 0.01 meter or 1 inch
     */
    public boolean isWeightScaleFeatureHeightMeasurementResolution1() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01_METER_OR_1INCH);
    }

    /**
     * @return {@code true}:Height Resolution is 0.005 meter or 0.5 inch, {@code false}:Height Resolution is not 0.005 meter or 0.5 inch
     */
    public boolean isWeightScaleFeatureHeightMeasurementResolution2() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005METER_OR_0_5INCH);
    }

    /**
     * @return {@code true}:Height Resolution is 0.001 meter or 0.1 inch, {@code false}:Height Resolution is not 0.001 meter or 0.1 inch
     */
    public boolean isWeightScaleFeatureHeightMeasurementResolution3() {
        return isFeatureMatched(WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_MASK, WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_001METER_OR_0_1INCH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mWeightScaleFeature);
        return data;
    }

    /**
     * check Weight Scale Feature
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_FALSE}
     *               , {@link #WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_TRUE}
     *               , {@link #WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_FALSE}
     *               , {@link #WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_TRUE}
     *               , {@link #WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_FALSE}
     *               , {@link #WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_TRUE}
     *               , {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED}
     *               , {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_5KG_OR_1LB}
     *               , {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_2KG_OR_0_5LB}
     *               , {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_1KG_OR_0_2LB}
     *               , {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_05KG_OR_0_1B}
     *               , {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_02KG_OR_0_05B}
     *               , {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01KG_OR_0_02B}
     *               , {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005KG_OR_0_01B}
     *               , {@link #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED}
     *               , {@link #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01_METER_OR_1INCH}
     *               , {@link #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005METER_OR_0_5INCH}
     *               , {@link #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_001METER_OR_0_1INCH}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFeatureMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt32(mWeightScaleFeature, 0)) == expect;
    }

}
