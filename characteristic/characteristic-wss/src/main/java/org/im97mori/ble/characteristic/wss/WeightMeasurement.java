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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_MEASUREMENT_CHARACTERISTIC;

/**
 * Weight Measurement (Characteristics UUID: 0x2A9D)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class WeightMeasurement implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAG_MEASUREMENT_UNITS_SI
     * @see #FLAG_MEASUREMENT_UNITS_IMPERIAL
     */
    public static final int FLAG_MEASUREMENT_UNITS_MASK = 0b00000001;

    /**
     * 0: SI (Weight and Mass in units of kilogram (kg) and Height in units of meter)
     */
    public static final int FLAG_MEASUREMENT_UNITS_SI = 0b00000000;

    /**
     * 1: Imperial (Weight and Mass in units of pound (lb) and Height in units of inch (in))
     */
    public static final int FLAG_MEASUREMENT_UNITS_IMPERIAL = 0b00000001;

    /**
     * @see #FLAG_TIME_STAMP_PRESENT_FALSE
     * @see #FLAG_TIME_STAMP_PRESENT_TRUE
     */
    public static final int FLAG_TIME_STAMP_PRESENT_MASK = 0b00000010;

    /**
     * 0: Time stamp present False
     */
    public static final int FLAG_TIME_STAMP_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Time stamp present True
     */
    public static final int FLAG_TIME_STAMP_PRESENT_TRUE = 0b00000010;

    /**
     * @see #FLAG_USER_ID_PRESENT_FALSE
     * @see #FLAG_USER_ID_PRESENT_TRUE
     */
    public static final int FLAG_USER_ID_PRESENT_MASK = 0b00000100;

    /**
     * 0: User ID present False
     */
    public static final int FLAG_USER_ID_PRESENT_FALSE = 0b00000000;

    /**
     * 1: User ID present True
     */
    public static final int FLAG_USER_ID_PRESENT_TRUE = 0b00000100;

    /**
     * @see #FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
     * @see #FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
     */
    public static final int FLAG_BMI_AND_HEIGHT_PRESENT_MASK = 0b00001000;

    /**
     * 0: BMI and Height present False
     */
    public static final int FLAG_BMI_AND_HEIGHT_PRESENT_FALSE = 0b00000000;

    /**
     * 1: BMI and Height present True
     */
    public static final int FLAG_BMI_AND_HEIGHT_PRESENT_TRUE = 0b00001000;

    /**
     * Weight - SI Unit 0.005 kilogram
     */
    public static final double WEIGHT_SI_RESOLUTION = 0.005d;

    /**
     * Weight - Imperial Unit 0.01 pounds
     */
    public static final double WEIGHT_IMPERIAL_RESOLUTION = 0.01d;

    /**
     * 255(0xff): The special value of 0xFF (255 Decimal) for User ID represents “unknown user”.
     */
    public static final int USER_ID_UNKNOWN_USER = 0xff;

    /**
     * BMI Resolution Unit
     */
    public static final double BMI_RESOLUTION = 0.1d;

    /**
     * Height - SI Unit 0.001 meters
     */
    public static final double HEIGHT_SI = 0.001d;

    /**
     * Height - Imerial Unit 0.1 inches
     */
    public static final double HEIGHT_IMPERIAL = 0.1d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<WeightMeasurement> CREATOR = new ByteArrayCreater<WeightMeasurement>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightMeasurement createFromParcel(@NonNull Parcel in) {
            return new WeightMeasurement(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightMeasurement[] newArray(int size) {
            return new WeightMeasurement[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WeightMeasurement createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WEIGHT_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WeightMeasurement(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final int mFlags;

    /**
     * Weight - SI
     */
    private final int mWeightSi;

    /**
     * Weight - Imperial
     */
    private final int mWeightImperial;

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
     * User ID
     */
    private final int mUserId;

    /**
     * BMI
     */
    private final int mBmi;

    /**
     * Height - SI
     */
    private final int mHeightSi;

    /**
     * Height - Imperial
     */
    private final int mHeightImperial;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9D
     */
    public WeightMeasurement(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFlags = values[0];
        mWeightSi = BLEUtils.createUInt16(values, 1);
        mWeightImperial = BLEUtils.createUInt16(values, 3);
        mYear = BLEUtils.createUInt16(values, 5);
        mMonth = (values[7] & 0xff);
        mDay = (values[8] & 0xff);
        mHours = (values[9] & 0xff);
        mMinutes = (values[10] & 0xff);
        mSeconds = (values[11] & 0xff);
        mUserId = (values[12] & 0xff);
        mBmi = BLEUtils.createUInt16(values, 13);
        mHeightSi = BLEUtils.createUInt16(values, 15);
        mHeightImperial = BLEUtils.createUInt16(values, 17);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WeightMeasurement(@NonNull Parcel in) {
        mFlags = in.readInt();
        mWeightSi = in.readInt();
        mWeightImperial = in.readInt();
        mYear = in.readInt();
        mMonth = in.readInt();
        mDay = in.readInt();
        mHours = in.readInt();
        mMinutes = in.readInt();
        mSeconds = in.readInt();
        mUserId = in.readInt();
        mBmi = in.readInt();
        mHeightSi = in.readInt();
        mHeightImperial = in.readInt();
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
        dest.writeInt(mWeightSi);
        dest.writeInt(mWeightImperial);
        dest.writeInt(mYear);
        dest.writeInt(mMonth);
        dest.writeInt(mDay);
        dest.writeInt(mHours);
        dest.writeInt(mMinutes);
        dest.writeInt(mSeconds);
        dest.writeInt(mUserId);
        dest.writeInt(mBmi);
        dest.writeInt(mHeightSi);
        dest.writeInt(mHeightImperial);
    }

    /**
     * @return Flags
     */
    public int getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:Weight Measurement Unit is SI, {@code false}:Weight Measurement Unit is not SI
     */
    public boolean isFlagsMeasurementUnitSI() {
        return isFlagsMatched(FLAG_MEASUREMENT_UNITS_MASK, FLAG_MEASUREMENT_UNITS_SI);
    }

    /**
     * @return {@code true}:Weight Measurement Unit is Imperial, {@code false}:Weight Measurement Unit is not Imperial
     */
    public boolean isFlagsMeasurementUnitImperial() {
        return isFlagsMatched(FLAG_MEASUREMENT_UNITS_MASK, FLAG_MEASUREMENT_UNITS_IMPERIAL);
    }

    /**
     * @return {@code true}:Time stamp not present, {@code false}:Time stamp present
     */
    public boolean isFlagsTimeStampNotPresent() {
        return isFlagsMatched(FLAG_TIME_STAMP_PRESENT_MASK, FLAG_TIME_STAMP_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Time stamp present, {@code false}:Time stamp not present
     */
    public boolean isFlagsTimeStampPresent() {
        return isFlagsMatched(FLAG_TIME_STAMP_PRESENT_MASK, FLAG_TIME_STAMP_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:User ID not present, {@code false}:User ID present
     */
    public boolean isFlagsUserIdNotPresent() {
        return isFlagsMatched(FLAG_USER_ID_PRESENT_MASK, FLAG_USER_ID_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:User ID present, {@code false}:User ID not present
     */
    public boolean isFlagsUserIdPresent() {
        return isFlagsMatched(FLAG_USER_ID_PRESENT_MASK, FLAG_USER_ID_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:BMI and Height not present, {@code false}:BMI and Height present
     */
    public boolean isFlagsBmiAndHeightNotPresent() {
        return isFlagsMatched(FLAG_BMI_AND_HEIGHT_PRESENT_MASK, FLAG_BMI_AND_HEIGHT_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:BMI and Height present, {@code false}:BMI and Height not present
     */
    public boolean isFlagsBmiAndHeightPresent() {
        return isFlagsMatched(FLAG_BMI_AND_HEIGHT_PRESENT_MASK, FLAG_BMI_AND_HEIGHT_PRESENT_TRUE);
    }

    /**
     * @return Weight - SI
     */
    public int getWeightSi() {
        return mWeightSi;
    }

    /**
     * @return Weight(kg)
     */
    public double getWeightSiKg() {
        return WEIGHT_SI_RESOLUTION * mWeightSi;
    }

    /**
     * @return Weight - Imperial
     */
    public int getWeightImperial() {
        return mWeightImperial;
    }

    /**
     * @return Weight(pounds)
     */
    public double getWeightImperialLb() {
        return WEIGHT_IMPERIAL_RESOLUTION * mWeightSi;
    }

    /**
     * @return Year
     * @see org.im97mori.ble.characteristic.DateTimeUtils
     */
    public int getYear() {
        return mYear;
    }

    /**
     * @return Month
     * @see org.im97mori.ble.characteristic.DateTimeUtils
     */
    public int getMonth() {
        return mMonth;
    }

    /**
     * @return Day
     * @see org.im97mori.ble.characteristic.DateTimeUtils
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
     * @return User ID
     */
    public int getUserId() {
        return mUserId;
    }

    /**
     * @return {@code true}:unknown user, {@code false}:not unknown user
     */
    public boolean isUserIdUnknownUser() {
        return USER_ID_UNKNOWN_USER == mUserId;
    }

    /**
     * @return BMI
     */
    public int getBmi() {
        return mBmi;
    }

    /**
     * @return BMI(with unit)
     */
    public double getBmiWithUnit() {
        return BMI_RESOLUTION * mBmi;
    }

    /**
     * @return Height - SI
     */
    public int getHeightSi() {
        return mHeightSi;
    }

    /**
     * @return Height(meters)
     */
    public double getHeightSiMeters() {
        return HEIGHT_SI * mHeightSi;
    }

    /**
     * @return Height - Imperial
     */
    public int getHeightImperial() {
        return mHeightImperial;
    }

    /**
     * @return Height(inches)
     */
    public double getHeightImperialInch() {
        return HEIGHT_IMPERIAL * mHeightImperial;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[19];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFlags);
        byteBuffer.putShort((short) mWeightSi);
        byteBuffer.putShort((short) mWeightImperial);
        byteBuffer.putShort((short) mYear);
        byteBuffer.put((byte) mMonth);
        byteBuffer.put((byte) mDay);
        byteBuffer.put((byte) mHours);
        byteBuffer.put((byte) mMinutes);
        byteBuffer.put((byte) mSeconds);
        byteBuffer.put((byte) mUserId);
        byteBuffer.putShort((short) mBmi);
        byteBuffer.putShort((short) mHeightSi);
        byteBuffer.putShort((short) mHeightImperial);
        return data;
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAG_MEASUREMENT_UNITS_SI}
     *               , {@link #FLAG_MEASUREMENT_UNITS_IMPERIAL}
     *               , {@link #FLAG_TIME_STAMP_PRESENT_FALSE}
     *               , {@link #FLAG_TIME_STAMP_PRESENT_TRUE}
     *               , {@link #FLAG_USER_ID_PRESENT_FALSE}
     *               , {@link #FLAG_USER_ID_PRESENT_TRUE}
     *               , {@link #FLAG_BMI_AND_HEIGHT_PRESENT_FALSE}
     *               , {@link #FLAG_BMI_AND_HEIGHT_PRESENT_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & mFlags) == expect;
    }

}
