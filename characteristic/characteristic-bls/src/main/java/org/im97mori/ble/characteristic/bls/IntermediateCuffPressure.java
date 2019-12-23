package org.im97mori.ble.characteristic.bls;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.IEEE_11073_20601_SFLOAT;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_PULSE_RATE_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_TIME_STAMP_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_USER_ID_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.FLAG_USER_ID_PRESENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_MASK;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT;
import static org.im97mori.ble.characteristic.bls.BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE;

/**
 * Intermediate Cuff Pressure (Characteristics UUID: 0x2A36)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IntermediateCuffPressure implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IntermediateCuffPressure> CREATOR = new ByteArrayCreater<IntermediateCuffPressure>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateCuffPressure createFromParcel(@NonNull Parcel in) {
            return new IntermediateCuffPressure(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateCuffPressure[] newArray(int size) {
            return new IntermediateCuffPressure[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IntermediateCuffPressure createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IntermediateCuffPressure(bluetoothGattCharacteristic);
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
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A36
     */
    public IntermediateCuffPressure(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFlags = values[0];
        mBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(values, 1);
        mBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(values, 3);
        mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(values, 5);
        mBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(values, 7);
        mBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(values, 9);
        mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(values, 11);
        mYear = BLEUtils.createUInt16(values, 13);
        mMonth = (values[15] & 0xff);
        mDay = (values[16] & 0xff);
        mHours = (values[17] & 0xff);
        mMinutes = (values[18] & 0xff);
        mSeconds = (values[19] & 0xff);
        mPulseRate = new IEEE_11073_20601_SFLOAT(values, 20);
        mUserId = (values[22] & 0xff);
        mMeasurementStatus = Arrays.copyOfRange(values, 23, 25);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IntermediateCuffPressure(@NonNull Parcel in) {
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
    public boolean isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimitt() {
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
        byte[] data = new byte[25];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFlags);
        byteBuffer.put(mBloodPressureMeasurementCompoundValueSystolicMmhg.getData());
        byteBuffer.put(mBloodPressureMeasurementCompoundValueDiastolicMmhg.getData());
        byteBuffer.put(mBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg.getData());
        byteBuffer.put(mBloodPressureMeasurementCompoundValueSystolicKpa.getData());
        byteBuffer.put(mBloodPressureMeasurementCompoundValueDiastolicKpa.getData());
        byteBuffer.put(mBloodPressureMeasurementCompoundValueMeanArterialPressureKpa.getData());
        byteBuffer.putShort((short) mYear);
        byteBuffer.put((byte) mMonth);
        byteBuffer.put((byte) mDay);
        byteBuffer.put((byte) mHours);
        byteBuffer.put((byte) mMinutes);
        byteBuffer.put((byte) mSeconds);
        byteBuffer.put(mPulseRate.getData());
        byteBuffer.put((byte) mUserId);
        byteBuffer.put(mMeasurementStatus);
        return data;
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link BloodPressureMeasurement#FLAG_BLOOD_PRESSURE_UNITS_MMHG}
     *               , {@link BloodPressureMeasurement#FLAG_BLOOD_PRESSURE_UNITS_KPA}
     *               , {@link BloodPressureMeasurement#FLAG_TIME_STAMP_NOT_PRESENT}
     *               , {@link BloodPressureMeasurement#FLAG_TIME_STAMP_PRESENT}
     *               , {@link BloodPressureMeasurement#FLAG_PULSE_RATE_NOT_PRESENT}
     *               , {@link BloodPressureMeasurement#FLAG_PULSE_RATE_PRESENT}
     *               , {@link BloodPressureMeasurement#FLAG_USER_ID_NOT_PRESENT}
     *               , {@link BloodPressureMeasurement#FLAG_USER_ID_PRESENT}
     *               , {@link BloodPressureMeasurement#FLAG_MEASUREMENT_STATUS_NOT_PRESENT}
     *               , {@link BloodPressureMeasurement#FLAG_MEASUREMENT_STATUS_PRESENT}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & mFlags) == expect;
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link BloodPressureMeasurement#MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION}
     *               , {@link BloodPressureMeasurement#MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isMeasurementStatusMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mMeasurementStatus, 0)) == expect;
    }

}
