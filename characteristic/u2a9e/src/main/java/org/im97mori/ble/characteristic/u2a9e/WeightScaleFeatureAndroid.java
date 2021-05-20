package org.im97mori.ble.characteristic.u2a9e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_SCALE_FEATURE_CHARACTERISTIC;

/**
 * Weight Scale Feature (Characteristics UUID: 0x2A9E)
 */
@SuppressWarnings({"WeakerAccess"})
public class WeightScaleFeatureAndroid extends WeightScaleFeature implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<WeightScaleFeatureAndroid> CREATOR = new ByteArrayCreater<WeightScaleFeatureAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WEIGHT_SCALE_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WeightScaleFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9E
     */
    public WeightScaleFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from flags
     *
     * @param isTimeStampSupported                              {@code true}:{@link #WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_TRUE}, {@code false}:{@link #WEIGHT_SCALE_FEATURE_TIME_STAMP_SUPPORTED_FALSE}
     * @param isMultipleUsersSupported                          {@code true}:{@link #WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_TRUE}, {@code false}:{@link #WEIGHT_SCALE_FEATURE_MULTIPLE_USERS_SUPPORTED_FALSE}
     * @param isBmiSupported                                    {@code true}:{@link #WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_TRUE}, {@code false}:{@link #WEIGHT_SCALE_FEATURE_BMI_SUPPORTED_FALSE}
     * @param weightScaleFeatureWeightMeasurmentResolutionFlag  one of {@link #WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED}
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
    public WeightScaleFeatureAndroid(boolean isTimeStampSupported, boolean isMultipleUsersSupported, boolean isBmiSupported, int weightScaleFeatureWeightMeasurmentResolutionFlag, int weightScaleFeatureHeightMeasurementResolutionFlag) {
        super(isTimeStampSupported, isMultipleUsersSupported, isBmiSupported, weightScaleFeatureWeightMeasurmentResolutionFlag, weightScaleFeatureHeightMeasurementResolutionFlag);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WeightScaleFeatureAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
