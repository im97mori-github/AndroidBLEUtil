package org.im97mori.ble.characteristic.u2a9e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Weight Scale Feature (Characteristics UUID: 0x2A9E)
 */
@SuppressWarnings({"WeakerAccess"})
public class WeightScaleFeatureAndroid extends WeightScaleFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<WeightScaleFeatureAndroid> CREATOR = new ByteArrayCreator<WeightScaleFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightScaleFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new WeightScaleFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightScaleFeatureAndroid[] newArray(int size) {
            return new WeightScaleFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WeightScaleFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            return new WeightScaleFeatureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9E
     */
    @Deprecated
    public WeightScaleFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public WeightScaleFeatureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from flags
     *
     * @param isTimeStampSupported                              {@code true}:{@link #WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_TRUE}, {@code false}:{@link #WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_FALSE}
     * @param isMultipleUsersSupported                          {@code true}:{@link #WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_TRUE}, {@code false}:{@link #WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_FALSE}
     * @param isBmiSupported                                    {@code true}:{@link #WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_TRUE}, {@code false}:{@link #WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_FALSE}
     * @param weightScaleFeatureWeightMeasurementResolutionFlag  one of {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_5KG_OR_1LB}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_2KG_OR_0_5LB}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_1KG_OR_0_2LB}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_05KG_OR_0_1B}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_02KG_OR_0_05B}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01KG_OR_0_02B}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005KG_OR_0_01B}
     * @param weightScaleFeatureHeightMeasurementResolutionFlag one of {@link #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01_METER_OR_1INCH}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005METER_OR_0_5INCH}
     *                                                          {@link #WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_001METER_OR_0_1INCH}
     */
    public WeightScaleFeatureAndroid(boolean isTimeStampSupported, boolean isMultipleUsersSupported, boolean isBmiSupported, int weightScaleFeatureWeightMeasurementResolutionFlag, int weightScaleFeatureHeightMeasurementResolutionFlag) {
        super(isTimeStampSupported, isMultipleUsersSupported, isBmiSupported, weightScaleFeatureWeightMeasurementResolutionFlag, weightScaleFeatureHeightMeasurementResolutionFlag);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WeightScaleFeatureAndroid(@NonNull Parcel in) {
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
