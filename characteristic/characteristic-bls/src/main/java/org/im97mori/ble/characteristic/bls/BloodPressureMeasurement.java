package org.im97mori.ble.characteristic.bls;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;

/**
 * Blood Pressure Measurement (Characteristics UUID: 0x2A35)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BloodPressureMeasurement implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAG_BLOOD_PRESSURE_UNITS_MMHG
     * @see #FLAG_BLOOD_PRESSURE_UNITS_KPA
     */
    public static final int FLAG_BLOOD_PRESSURE_UNITS_MASK = 0b00000001;

    /**
     * 0: Blood pressure for Systolic, Diastolic and MAP in units of mmHg
     */
    public static final int FLAG_BLOOD_PRESSURE_UNITS_MMHG = 0b00000000;

    /**
     * 1: Blood pressure for Systolic, Diastolic and MAP in units of kPa
     */
    public static final int FLAG_BLOOD_PRESSURE_UNITS_KPA = 0b00000001;

    /**
     * @see #FLAG_TIME_STAMP_NOT_PRESENT
     * @see #FLAG_TIME_STAMP_PRESENT
     */
    public static final int FLAG_TIME_STAMP_MASK = 0b00000010;

    /**
     * 0: Time Stamp not present
     */
    public static final int FLAG_TIME_STAMP_NOT_PRESENT = 0b00000000;

    /**
     * 1: Time Stamp present
     */
    public static final int FLAG_TIME_STAMP_PRESENT = 0b00000010;

    /**
     * @see #FLAG_PULSE_RATE_NOT_PRESENT
     * @see #FLAG_PULSE_RATE_PRESENT
     */
    public static final int FLAG_PULSE_RATE_MASK = 0b00000100;

    /**
     * 0: Pulse Rate not present
     */
    public static final int FLAG_PULSE_RATE_NOT_PRESENT = 0b00000000;

    /**
     * 1: Pulse Rate present
     */
    public static final int FLAG_PULSE_RATE_PRESENT = 0b00000100;

    /**
     * @see #FLAG_USER_ID_NOT_PRESENT
     * @see #FLAG_USER_ID_PRESENT
     */
    public static final int FLAG_USER_ID_MASK = 0b00001000;

    /**
     * 0: User ID not present
     */
    public static final int FLAG_USER_ID_NOT_PRESENT = 0b00000000;

    /**
     * 1: User ID present
     */
    public static final int FLAG_USER_ID_PRESENT = 0b00001000;

    /**
     * @see #FLAG_MEASUREMENT_STATUS_NOT_PRESENT
     * @see #FLAG_MEASUREMENT_STATUS_PRESENT
     */
    public static final int FLAG_MEASUREMENT_STATUS_MASK = 0b00010000;

    /**
     * 0: Measurement Status not present
     */
    public static final int FLAG_MEASUREMENT_STATUS_NOT_PRESENT = 0b00000000;

    /**
     * 1: Measurement Status present
     */
    public static final int FLAG_MEASUREMENT_STATUS_PRESENT = 0b00010000;

    /**
     * @see #MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
     * @see #MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
     */
    public static final int MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_MASK = 0b00000001;

    /**
     * 0: No body movement
     */
    public static final int MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT = 0b00000000;

    /**
     * 1: Body movement during measurement
     */
    public static final int MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT = 0b00000001;

    /**
     * @see #MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
     * @see #MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE
     */
    public static final int MEASUREMENT_STATUS_CUFF_FIT_DETECTION_MASK = 0b00000010;

    /**
     * 0: Cuff fits properly
     */
    public static final int MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY = 0b00000000;

    /**
     * 1: Cuff too loose
     */
    public static final int MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE = 0b00000010;

    /**
     * @see #MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
     * @see #MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
     */
    public static final int MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_MASK = 0b00000100;

    /**
     * 0: No irregular pulse detected
     */
    public static final int MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED = 0b00000000;

    /**
     * 1: Irregular pulse detected
     */
    public static final int MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED = 0b00000100;

    /**
     * @see #MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
     * @see #MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT
     * @see #MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT
     */
    public static final int MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_MASK = 0b00011000;

    /**
     * 0: Pulse rate is within the range
     */
    public static final int MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE = 0b00000000;

    /**
     * 1: Pulse rate exceeds upper limit
     */
    public static final int MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT = 0b00001000;

    /**
     * 2: Pulse rate is less than lower limit
     */
    public static final int MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT = 0b00010000;

    /**
     * @see #MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION
     * @see #MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION
     */
    public static final int MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_MASK = 0b00100000;

    /**
     * 0: Proper measurement position
     */
    public static final int MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION = 0b00000000;

    /**
     * 1: Improper measurement position
     */
    public static final int MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION = 0b00100000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BloodPressureMeasurement> CREATOR = new ByteArrayCreater<BloodPressureMeasurement>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureMeasurement createFromParcel(@NonNull Parcel in) {
            return new BloodPressureMeasurement(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureMeasurement[] newArray(int size) {
            return new BloodPressureMeasurement[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BloodPressureMeasurement createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BloodPressureMeasurement(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final int mFlags;

    /**
     * Blood Pressure Measurement Compound Value - Systolic (mmHg)
     */
    private final IEEE_11073_20601_SFLOAT mBloodPressureMeasurementCompoundValueSystolicMmhg;

    /**
     * Blood Pressure Measurement Compound Value - Diastolic (mmHg)
     */
    private final IEEE_11073_20601_SFLOAT mBloodPressureMeasurementCompoundValueDiastolicMmhg;

    /**
     * Blood Pressure Measurement Compound Value - Mean Arterial Pressure (mmHg)
     */
    private final IEEE_11073_20601_SFLOAT mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg;

    /**
     * Blood Pressure Measurement Compound Value - Systolic (kPa)
     */
    private final IEEE_11073_20601_SFLOAT mBloodPressureMeasurementCompoundValueSystolicKpa;

    /**
     * Blood Pressure Measurement Compound Value - Diastolic (kPa)
     */
    private final IEEE_11073_20601_SFLOAT mBloodPressureMeasurementCompoundValueDiastolicKpa;

    /**
     * Blood Pressure Measurement Compound Value - Mean Arterial Pressure (kPa)
     */
    private final IEEE_11073_20601_SFLOAT mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa;

    /**
     * Year
     */
    private final int mYear;

    /**
     * Month
     */
    private final int mMonth;

    /**
     * Day
     */
    private final int mDay;

    /**
     * Hours
     */
    private final int mHours;

    /**
     * Minutes
     */
    private final int mMinutes;

    /**
     * Seconds
     */
    private final int mSeconds;

    /**
     * Pulse Rate
     */
    private final IEEE_11073_20601_SFLOAT mPulseRate;

    /**
     * User ID
     */
    private final int mUserId;

    /**
     * Measurement Status
     */
    private final byte[] mMeasurementStatus;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A35
     */
    public BloodPressureMeasurement(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 0;
        mFlags = values[index++];
        if (isFlagsBloodPressureUnitsMmhg()) {
            mBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(values, index);
            index += 2;
            mBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(values, index);
            index += 2;
            mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(values, index);

            mBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[2], 0);
            mBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[2], 0);
            mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[2], 0);
        } else {
            mBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[2], 0);
            mBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[2], 0);
            mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[2], 0);

            mBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(values, index);
            index += 2;
            mBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(values, index);
            index += 2;
            mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(values, index);
        }
        index += 2;
        if (isFlagsTimeStampPresent()) {
            mYear = BLEUtils.createUInt16(values, index);
            index += 2;
            mMonth = (values[index++] & 0xff);
            mDay = (values[index++] & 0xff);
            mHours = (values[index++] & 0xff);
            mMinutes = (values[index++] & 0xff);
            mSeconds = (values[index++] & 0xff);
        } else {
            mYear = 0;
            mMonth = 0;
            mDay = 0;
            mHours = 0;
            mMinutes = 0;
            mSeconds = 0;
        }
        if (isFlagsPulseRatePresent()) {
            mPulseRate = new IEEE_11073_20601_SFLOAT(values, index);
            index += 2;
        } else {
            mPulseRate = new IEEE_11073_20601_SFLOAT(new byte[2], 0);
        }
        if (isFlagsUserIdPresent()) {
            mUserId = (values[index++] & 0xff);
        } else {
            mUserId = 0;
        }
        if (isFlagsMeasurementStatusPresent()) {
            mMeasurementStatus = Arrays.copyOfRange(values, index, index + 2);
        } else {
            mMeasurementStatus = new byte[0];
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private BloodPressureMeasurement(@NonNull Parcel in) {
        mFlags = in.readInt();
        mBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(in.createByteArray(), 0);
        mBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(in.createByteArray(), 0);
        mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(in.createByteArray(), 0);
        mBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(in.createByteArray(), 0);
        mBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(in.createByteArray(), 0);
        mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(in.createByteArray(), 0);
        mYear = in.readInt();
        mMonth = in.readInt();
        mDay = in.readInt();
        mHours = in.readInt();
        mMinutes = in.readInt();
        mSeconds = in.readInt();
        mPulseRate = new IEEE_11073_20601_SFLOAT(in.createByteArray(), 0);
        mUserId = in.readInt();
        mMeasurementStatus = in.createByteArray();
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
        dest.writeInt(mFlags);
        dest.writeByteArray(mBloodPressureMeasurementCompoundValueSystolicMmhg.getData());
        dest.writeByteArray(mBloodPressureMeasurementCompoundValueDiastolicMmhg.getData());
        dest.writeByteArray(mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg.getData());
        dest.writeByteArray(mBloodPressureMeasurementCompoundValueSystolicKpa.getData());
        dest.writeByteArray(mBloodPressureMeasurementCompoundValueDiastolicKpa.getData());
        dest.writeByteArray(mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa.getData());
        dest.writeInt(mYear);
        dest.writeInt(mMonth);
        dest.writeInt(mDay);
        dest.writeInt(mHours);
        dest.writeInt(mMinutes);
        dest.writeInt(mSeconds);
        dest.writeByteArray(mPulseRate.getData());
        dest.writeInt(mUserId);
        dest.writeByteArray(mMeasurementStatus);
    }

    /**
     * @return Flags
     */
    public int getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:Blood pressure for Systolic, Diastolic and MAP in units of mmHg, {@code false}:Blood pressure for Systolic, Diastolic and MAP in units of kPa
     */
    public boolean isFlagsBloodPressureUnitsMmhg() {
        return isFlagsMatched(FLAG_BLOOD_PRESSURE_UNITS_MASK, FLAG_BLOOD_PRESSURE_UNITS_MMHG);
    }

    /**
     * @return {@code true}:Blood pressure for Systolic, Diastolic and MAP in units of kPa, {@code false}:Blood pressure for Systolic, Diastolic and MAP in units of mmHg
     */
    public boolean isFlagsBloodPressureUnitsKpa() {
        return isFlagsMatched(FLAG_BLOOD_PRESSURE_UNITS_MASK, FLAG_BLOOD_PRESSURE_UNITS_KPA);
    }

    /**
     * @return {@code true}:Time Stamp not present, {@code false}:Time Stamp present
     */
    public boolean isFlagsTimeStampNotPresent() {
        return isFlagsMatched(FLAG_TIME_STAMP_MASK, FLAG_TIME_STAMP_NOT_PRESENT);
    }

    /**
     * @return {@code true}:Time Stamp present, {@code false}:Time Stamp not present
     */
    public boolean isFlagsTimeStampPresent() {
        return isFlagsMatched(FLAG_TIME_STAMP_MASK, FLAG_TIME_STAMP_PRESENT);
    }

    /**
     * @return {@code true}:Pulse Rate not present, {@code false}:Pulse Rate present
     */
    public boolean isFlagsPulseRateNotPresent() {
        return isFlagsMatched(FLAG_PULSE_RATE_MASK, FLAG_PULSE_RATE_NOT_PRESENT);
    }

    /**
     * @return {@code true}:Pulse Rate present, {@code false}:Pulse Rate not present
     */
    public boolean isFlagsPulseRatePresent() {
        return isFlagsMatched(FLAG_PULSE_RATE_MASK, FLAG_PULSE_RATE_PRESENT);
    }


    /**
     * @return {@code true}:User ID not present, {@code false}:User ID present
     */
    public boolean isFlagsUserIdNotPresent() {
        return isFlagsMatched(FLAG_USER_ID_MASK, FLAG_USER_ID_NOT_PRESENT);
    }

    /**
     * @return {@code true}:User ID present, {@code false}:User ID not present
     */
    public boolean isFlagsUserIdPresent() {
        return isFlagsMatched(FLAG_USER_ID_MASK, FLAG_USER_ID_PRESENT);
    }

    /**
     * @return {@code true}:Measurement Status not present, {@code false}:Measurement Status present
     */
    public boolean isFlagsMeasurementStatusNotPresent() {
        return isFlagsMatched(FLAG_MEASUREMENT_STATUS_MASK, FLAG_MEASUREMENT_STATUS_NOT_PRESENT);
    }

    /**
     * @return {@code true}:Measurement Status present, {@code false}:Measurement Status not present
     */
    public boolean isFlagsMeasurementStatusPresent() {
        return isFlagsMatched(FLAG_MEASUREMENT_STATUS_MASK, FLAG_MEASUREMENT_STATUS_PRESENT);
    }

    /**
     * @return Blood Pressure Measurement Compound Value - Systolic (mmHg)
     */
    public IEEE_11073_20601_SFLOAT getBloodPressureMeasurementCompoundValueSystolicMmhg() {
        return mBloodPressureMeasurementCompoundValueSystolicMmhg;
    }

    /**
     * @return Blood Pressure Measurement Compound Value - Diastolic (mmHg)
     */
    public IEEE_11073_20601_SFLOAT getBloodPressureMeasurementCompoundValueDiastolicMmhg() {
        return mBloodPressureMeasurementCompoundValueDiastolicMmhg;
    }

    /**
     * @return Blood Pressure Measurement Compound Value - Mean Arterial Pressure (mmHg)
     */
    public IEEE_11073_20601_SFLOAT getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg() {
        return mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg;
    }

    /**
     * @return Blood Pressure Measurement Compound Value - Systolic (kPa)
     */
    public IEEE_11073_20601_SFLOAT getBloodPressureMeasurementCompoundValueSystolicKpa() {
        return mBloodPressureMeasurementCompoundValueSystolicKpa;
    }

    /**
     * @return Blood Pressure Measurement Compound Value - Diastolic (kPa)
     */
    public IEEE_11073_20601_SFLOAT getBloodPressureMeasurementCompoundValueDiastolicKpa() {
        return mBloodPressureMeasurementCompoundValueDiastolicKpa;
    }

    /**
     * @return Blood Pressure Measurement Compound Value - Mean Arterial Pressure (kPa)
     */
    public IEEE_11073_20601_SFLOAT getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa() {
        return mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa;
    }

    /**
     * @return Year
     */
    public int getYear() {
        return mYear;
    }

    /**
     * @return Month
     */
    public int getMonth() {
        return mMonth;
    }

    /**
     * @return Day
     */
    public int getDay() {
        return mDay;
    }

    /**
     * @return Hours
     */
    public int getHours() {
        return mHours;
    }

    /**
     * @return Minutes
     */
    public int getMinutes() {
        return mMinutes;
    }

    /**
     * @return Seconds
     */
    public int getSeconds() {
        return mSeconds;
    }

    /**
     * @return Pulse Rate
     */
    public IEEE_11073_20601_SFLOAT getPulseRate() {
        return mPulseRate;
    }

    /**
     * @return User ID
     */
    public int getUserId() {
        return mUserId;
    }

    /**
     * @return Measurement Status
     */
    public byte[] getMeasurementStatus() {
        return mMeasurementStatus;
    }

    /**
     * @return {@code true}:No body movement, {@code false}:Body movement during measurement
     */
    public boolean isMeasurementStatusBodyMoveDetectionNoBodyMovement() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_MASK, MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT);
    }

    /**
     * @return {@code true}:Body movement during measurement, {@code false}:No body movement
     */
    public boolean isMeasurementStatusBodyMoveDetectionBodyMovementDuringMeasurement() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_MASK, MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT);
    }

    /**
     * @return {@code true}:Cuff fits properly, {@code false}:Cuff too loose
     */
    public boolean isMeasurementStatusCuffFitDetectionCuffFitsProperly() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_CUFF_FIT_DETECTION_MASK, MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY);
    }

    /**
     * @return {@code true}:Cuff too loose, {@code false}:Cuff fits properly
     */
    public boolean isMeasurementStatusCuffFitDetectionCuffTooLoose() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_CUFF_FIT_DETECTION_MASK, MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE);
    }

    /**
     * @return {@code true}:No irregular pulse detected, {@code false}:Irregular pulse detected
     */
    public boolean isMeasurementStatusIrregularPulseDetectionNoIrregularPulseDetected() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_MASK, MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED);
    }

    /**
     * @return {@code true}:Irregular pulse detected, {@code false}:No irregular pulse detected
     */
    public boolean isMeasurementStatusIrregularPulseDetectionIrregularPulseDetected() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_MASK, MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED);
    }

    /**
     * @return {@code true}:Pulse rate is within the range, {@code false}:not Pulse rate is within the range
     */
    public boolean isMeasurementStatusPulseRateRangeDetectionPulseRateIsWithinTheRange() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_MASK, MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE);
    }

    /**
     * @return {@code true}:Pulse rate exceeds upper limit, {@code false}:not Pulse rate exceeds upper limit
     */
    public boolean isMeasurementStatusPulseRateRangeDetectionPulseRateExceedssUpperLimit() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_MASK, MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT);
    }

    /**
     * @return {@code true}:Pulse rate is less than lower limit, {@code false}:not Pulse rate is less than lower limit
     */
    public boolean isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimit() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_MASK, MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT);
    }

    /**
     * @return {@code true}:Proper measurement position, {@code false}:Improper measurement position
     */
    public boolean isMeasurementStatusMeasurementPositionDetectionProperMeasurementPosition() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_MASK, MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION);
    }

    /**
     * @return {@code true}:Improper measurement position, {@code false}:Proper measurement position
     */
    public boolean isMeasurementStatusMeasurementPositionDetectionImproperMeasurementPosition() {
        return isMeasurementStatusMatched(MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_MASK, MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[19];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFlags);
        length++;
        if (isFlagsBloodPressureUnitsMmhg()) {
            byteBuffer.put(mBloodPressureMeasurementCompoundValueSystolicMmhg.getData());
            byteBuffer.put(mBloodPressureMeasurementCompoundValueDiastolicMmhg.getData());
            byteBuffer.put(mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg.getData());
        } else {
            byteBuffer.put(mBloodPressureMeasurementCompoundValueSystolicKpa.getData());
            byteBuffer.put(mBloodPressureMeasurementCompoundValueDiastolicKpa.getData());
            byteBuffer.put(mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa.getData());
        }
        length += 6;
        if (isFlagsTimeStampPresent()) {
            byteBuffer.putShort((short) mYear);
            byteBuffer.put((byte) mMonth);
            byteBuffer.put((byte) mDay);
            byteBuffer.put((byte) mHours);
            byteBuffer.put((byte) mMinutes);
            byteBuffer.put((byte) mSeconds);
            length += 7;
        }
        if (isFlagsPulseRatePresent()) {
            byteBuffer.put(mPulseRate.getData());
            length += 2;
        }
        if (isFlagsUserIdPresent()) {
            byteBuffer.put((byte) mUserId);
            length++;
        }
        if (isFlagsMeasurementStatusPresent()) {
            byteBuffer.put(mMeasurementStatus);
            length += 2;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAG_BLOOD_PRESSURE_UNITS_MMHG}
     *               , {@link #FLAG_BLOOD_PRESSURE_UNITS_KPA}
     *               , {@link #FLAG_TIME_STAMP_NOT_PRESENT}
     *               , {@link #FLAG_TIME_STAMP_PRESENT}
     *               , {@link #FLAG_PULSE_RATE_NOT_PRESENT}
     *               , {@link #FLAG_PULSE_RATE_PRESENT}
     *               , {@link #FLAG_USER_ID_NOT_PRESENT}
     *               , {@link #FLAG_USER_ID_PRESENT}
     *               , {@link #FLAG_MEASUREMENT_STATUS_NOT_PRESENT}
     *               , {@link #FLAG_MEASUREMENT_STATUS_PRESENT}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & mFlags) == expect;
    }

    /**
     * check Measurement Status
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT}
     *               , {@link #MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT}
     *               , {@link #MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY}
     *               , {@link #MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE}
     *               , {@link #MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED}
     *               , {@link #MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED}
     *               , {@link #MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE}
     *               , {@link #MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT}
     *               , {@link #MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT}
     *               , {@link #MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION}
     *               , {@link #MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isMeasurementStatusMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mMeasurementStatus, 0)) == expect;
    }

}
