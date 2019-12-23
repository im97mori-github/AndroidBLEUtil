package org.im97mori.ble.characteristic.bls;

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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BLOOD_PRESSURE_FEATURE_CHARACTERISTIC;

/**
 * Blood Pressure Feature (Characteristics UUID: 0x2A49)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BloodPressureFeature implements ByteArrayInterface, Parcelable {

    /**
     * @see #BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
     * @see #BODY_MOVEMENT_DETECTION_SUPPORT_TRUE
     */
    public static final int BODY_MOVEMENT_DETECTION_SUPPORT_MASK = 0b00000000_00000001;

    /**
     * 0: Body Movement Detection feature not supported
     */
    public static final int BODY_MOVEMENT_DETECTION_SUPPORT_FALSE = 0b00000000_00000000;

    /**
     * 1: Body Movement Detection feature supported
     */
    public static final int BODY_MOVEMENT_DETECTION_SUPPORT_TRUE = 0b00000000_00000001;

    /**
     * @see #CUFF_FIT_DETECTION_SUPPORT_FALSE
     * @see #CUFF_FIT_DETECTION_SUPPORT_TRUE
     */
    public static final int CUFF_FIT_DETECTION_SUPPORT_MASK = 0b00000000_00000010;

    /**
     * 0: Cuff Fit Detection feature not supported
     */
    public static final int CUFF_FIT_DETECTION_SUPPORT_FALSE = 0b00000000_00000000;

    /**
     * 1: Cuff Fit Detection feature supported
     */
    public static final int CUFF_FIT_DETECTION_SUPPORT_TRUE = 0b00000000_00000010;

    /**
     * @see #IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
     * @see #IRREGULAR_PULSE_DETECTION_SUPPORT_TRUE
     */
    public static final int IRREGULAR_PULSE_DETECTION_SUPPORT_MASK = 0b00000000_00000100;

    /**
     * 0: Irregular Pulse Detection feature not supported
     */
    public static final int IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE = 0b00000000_00000000;

    /**
     * 1: Irregular Pulse Detection feature supported
     */
    public static final int IRREGULAR_PULSE_DETECTION_SUPPORT_TRUE = 0b00000000_00000100;

    /**
     * @see #PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
     * @see #PULSE_RATE_RANGE_DETECTION_SUPPORT_TRUE
     */
    public static final int PULSE_RATE_RANGE_DETECTION_SUPPORT_MASK = 0b00000000_00001000;

    /**
     * 0: Pulse Rate Range Detection feature not supported
     */
    public static final int PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE = 0b00000000_00000000;

    /**
     * 1: Pulse Rate Range Detection feature supported
     */
    public static final int PULSE_RATE_RANGE_DETECTION_SUPPORT_TRUE = 0b00000000_00001000;

    /**
     * @see #MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
     * @see #MEASUREMENT_POSITION_DETECTION_SUPPORT_TRUE
     */
    public static final int MEASUREMENT_POSITION_DETECTION_SUPPORT_MASK = 0b00000000_00010000;

    /**
     * 0: Measurement Position Detection feature not supported
     */
    public static final int MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE = 0b00000000_00000000;

    /**
     * 1: Measurement Position Detection feature supported
     */
    public static final int MEASUREMENT_POSITION_DETECTION_SUPPORT_TRUE = 0b00000000_00010000;

    /**
     * @see #MULTIPLE_BOND_SUPPORT_FALSE
     * @see #MULTIPLE_BOND_SUPPORT_TRUE
     */
    public static final int MULTIPLE_BOND_SUPPORT_MASK = 0b00000000_00100000;

    /**
     * 0: Multiple Bonds not supported
     */
    public static final int MULTIPLE_BOND_SUPPORT_FALSE = 0b00000000_00000000;

    /**
     * 1: Multiple Bonds supported
     */
    public static final int MULTIPLE_BOND_SUPPORT_TRUE = 0b00000000_00100000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BloodPressureFeature> CREATOR = new ByteArrayCreater<BloodPressureFeature>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureFeature createFromParcel(@NonNull Parcel in) {
            return new BloodPressureFeature(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureFeature[] newArray(int size) {
            return new BloodPressureFeature[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BloodPressureFeature createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BloodPressureFeature(bluetoothGattCharacteristic);
        }

    };

    /**
     * Blood Pressure Feature
     */
    private final byte[] mBloodPressureFeature;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A49
     */
    public BloodPressureFeature(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mBloodPressureFeature = Arrays.copyOfRange(values, 0, 2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BloodPressureFeature(@NonNull Parcel in) {
        mBloodPressureFeature = in.createByteArray();
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
        dest.writeByteArray(mBloodPressureFeature);
    }

    /**
     * @return Blood Pressure Feature
     */
    public byte[] getBloodPressureFeature() {
        return mBloodPressureFeature;
    }

    /**
     * @return {@code true}:Body Movement Detection feature not supported, {@code false}:Body Movement Detection feature supported
     */
    public boolean isBodyMovementDetectionNotSupported() {
        return isFeatureMatched(BODY_MOVEMENT_DETECTION_SUPPORT_MASK, BODY_MOVEMENT_DETECTION_SUPPORT_FALSE);
    }

    /**
     * @return {@code true}:Body Movement Detection feature supported, {@code false}:Body Movement Detection feature not supported
     */
    public boolean isBodyMovementDetectionSupported() {
        return isFeatureMatched(BODY_MOVEMENT_DETECTION_SUPPORT_MASK, BODY_MOVEMENT_DETECTION_SUPPORT_TRUE);
    }

    /**
     * @return {@code true}:Cuff Fit Detection feature not supported, {@code false}:Cuff Fit Detection feature supported
     */
    public boolean isCuffFitDetectionNotSupported() {
        return isFeatureMatched(CUFF_FIT_DETECTION_SUPPORT_MASK, CUFF_FIT_DETECTION_SUPPORT_FALSE);
    }

    /**
     * @return {@code true}:Cuff Fit Detection feature supported, {@code false}:Cuff Fit Detection feature not supported
     */
    public boolean isCuffFitDetectionSupported() {
        return isFeatureMatched(CUFF_FIT_DETECTION_SUPPORT_MASK, CUFF_FIT_DETECTION_SUPPORT_TRUE);
    }

    /**
     * @return {@code true}:Irregular Pulse Detection feature not supported, {@code false}:Irregular Pulse Detection feature supported
     */
    public boolean isIrregularPulsetDetectionNotSupported() {
        return isFeatureMatched(IRREGULAR_PULSE_DETECTION_SUPPORT_MASK, IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE);
    }

    /**
     * @return {@code true}:Irregular Pulse Detection feature supported, {@code false}:Irregular Pulse Detection feature not supported
     */
    public boolean isIrregularPulseDetectionSupported() {
        return isFeatureMatched(IRREGULAR_PULSE_DETECTION_SUPPORT_MASK, IRREGULAR_PULSE_DETECTION_SUPPORT_TRUE);
    }

    /**
     * @return {@code true}:Pulse Rate Range Detection feature not supported, {@code false}:Pulse Rate Range Detection feature supported
     */
    public boolean isPulseRateRangeDetectionNotSupported() {
        return isFeatureMatched(PULSE_RATE_RANGE_DETECTION_SUPPORT_MASK, PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE);
    }

    /**
     * @return {@code true}:Pulse Rate Range Detection feature supported, {@code false}:Pulse Rate Range Detection feature not supported
     */
    public boolean isPulseRateRangeDetectionSupported() {
        return isFeatureMatched(PULSE_RATE_RANGE_DETECTION_SUPPORT_MASK, PULSE_RATE_RANGE_DETECTION_SUPPORT_TRUE);
    }

    /**
     * @return {@code true}:Measurement Position Detection feature not supported, {@code false}:Measurement Position Detection feature supported
     */
    public boolean isMeasurementPositionDetectionNotSupported() {
        return isFeatureMatched(MEASUREMENT_POSITION_DETECTION_SUPPORT_MASK, MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE);
    }

    /**
     * @return {@code true}:Measurement Position Detection feature supported, {@code false}:Measurement Position Detection feature not supported
     */
    public boolean isMeasurementPositionDetectionSupported() {
        return isFeatureMatched(MEASUREMENT_POSITION_DETECTION_SUPPORT_MASK, MEASUREMENT_POSITION_DETECTION_SUPPORT_TRUE);
    }

    /**
     * @return {@code true}:Multiple Bonds not supported, {@code false}:Multiple Bonds supported
     */
    public boolean isMultipleBondDetectionNotSupported() {
        return isFeatureMatched(MULTIPLE_BOND_SUPPORT_MASK, MULTIPLE_BOND_SUPPORT_FALSE);
    }

    /**
     * @return {@code true}:Multiple Bonds supported, {@code false}:Multiple Bonds not supported
     */
    public boolean isMultipleBondDetectionSupported() {
        return isFeatureMatched(MULTIPLE_BOND_SUPPORT_MASK, MULTIPLE_BOND_SUPPORT_TRUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mBloodPressureFeature);
        return data;
    }

    /**
     * check Blood Pressure Feature
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #BODY_MOVEMENT_DETECTION_SUPPORT_FALSE}
     *               , {@link #BODY_MOVEMENT_DETECTION_SUPPORT_TRUE}
     *               , {@link #CUFF_FIT_DETECTION_SUPPORT_FALSE}
     *               , {@link #CUFF_FIT_DETECTION_SUPPORT_TRUE}
     *               , {@link #IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE}
     *               , {@link #IRREGULAR_PULSE_DETECTION_SUPPORT_TRUE}
     *               , {@link #PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE}
     *               , {@link #PULSE_RATE_RANGE_DETECTION_SUPPORT_TRUE}
     *               , {@link #MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE}
     *               , {@link #MEASUREMENT_POSITION_DETECTION_SUPPORT_TRUE}
     *               , {@link #MULTIPLE_BOND_SUPPORT_FALSE}
     *               , {@link #MULTIPLE_BOND_SUPPORT_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFeatureMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mBloodPressureFeature, 0)) == expect;
    }
}
