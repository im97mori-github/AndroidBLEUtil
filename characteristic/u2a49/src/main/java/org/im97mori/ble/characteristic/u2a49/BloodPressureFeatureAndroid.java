package org.im97mori.ble.characteristic.u2a49;

import static org.im97mori.ble.constants.CharacteristicUUID.BLOOD_PRESSURE_FEATURE_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

/**
 * Blood Pressure Feature (Characteristics UUID: 0x2A49)
 */
@SuppressWarnings({"WeakerAccess"})
public class BloodPressureFeatureAndroid extends BloodPressureFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BloodPressureFeatureAndroid> CREATOR = new ByteArrayCreator<BloodPressureFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new BloodPressureFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureFeatureAndroid[] newArray(int size) {
            return new BloodPressureFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BloodPressureFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A49
     */
    public BloodPressureFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from flags
     *
     * @param isBodyMovementDetectionFeatureSupported {@code true}:{@link #BODY_MOVEMENT_DETECTION_SUPPORT_TRUE},
     *                                                {@code false}:{@link #BODY_MOVEMENT_DETECTION_SUPPORT_FALSE}
     * @param isCuffFitDetectionSupported             {@code true}:{@link #CUFF_FIT_DETECTION_SUPPORT_TRUE},
     *                                                {@code false}:{@link #CUFF_FIT_DETECTION_SUPPORT_FALSE}
     * @param isIrregularPulseDetectionSupported      {@code true}:{@link #IRREGULAR_PULSE_DETECTION_SUPPORT_TRUE},
     *                                                {@code false}:{@link #IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE}
     * @param isPulseRateRangeDetectionSupported      {@code true}:{@link #PULSE_RATE_RANGE_DETECTION_SUPPORT_TRUE},
     *                                                {@code false}:{@link #PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE}
     * @param isMeasurementPositionDetectionSupported {@code true}:{@link #MEASUREMENT_POSITION_DETECTION_SUPPORT_TRUE},
     *                                                {@code false}:{@link #MEASUREMENT_POSITION_DETECTION_SUPPORT_TRUE}
     * @param isMultipleBondSupported                 {@code true}:{@link #MULTIPLE_BOND_SUPPORT_TRUE},
     *                                                {@code false}:{@link #MULTIPLE_BOND_SUPPORT_FALSE}
     * @param isE2eCrcSupported                       {@code true}:{@link #E2E_CRC_SUPPORT_TRUE},
     *                                                {@code false}:{@link #E2E_CRC_SUPPORT_FALSE}
     * @param isUserDataServiceSupported              {@code true}:{@link #USER_DATA_SERVICE_SUPPORT_TRUE},
     *                                                {@code false}:{@link #USER_DATA_SERVICE_SUPPORT_FALSE}
     * @param isUserFacingTimeSupported               {@code true}:{@link #USER_FACING_TIME_SUPPORT_TRUE},
     *                                                {@code false}:{@link #USER_FACING_TIME_SUPPORT_FALSE}
     */
    public BloodPressureFeatureAndroid(boolean isBodyMovementDetectionFeatureSupported
            , boolean isCuffFitDetectionSupported
            , boolean isIrregularPulseDetectionSupported
            , boolean isPulseRateRangeDetectionSupported
            , boolean isMeasurementPositionDetectionSupported
            , boolean isMultipleBondSupported
            , boolean isE2eCrcSupported
            , boolean isUserDataServiceSupported
            , boolean isUserFacingTimeSupported) {
        super(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BloodPressureFeatureAndroid(@NonNull Parcel in) {
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
