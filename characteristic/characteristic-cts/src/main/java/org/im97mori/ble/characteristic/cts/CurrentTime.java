package org.im97mori.ble.characteristic.cts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;

/**
 * Current Time (Characteristics UUID: 0x2A2B)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CurrentTime implements ByteArrayInterface, Parcelable {

    /**
     * 0: Day of week is not known
     */
    public static final int DAY_OF_WEEK_IS_NOT_KNOWN = 0;

    /**
     * 1: Monday
     */
    public static final int DAY_OF_WEEK_MONDAY = 1;

    /**
     * 2: Tuesday
     */
    public static final int DAY_OF_WEEK_TUESDAY = 2;

    /**
     * 3: Wednesday
     */
    public static final int DAY_OF_WEEK_WEDNESDAY = 3;

    /**
     * 4: Thursday
     */
    public static final int DAY_OF_WEEK_THURSDAY = 4;

    /**
     * 5: Friday
     */
    public static final int DAY_OF_WEEK_FRIDAY = 5;

    /**
     * 6: Saturday
     */
    public static final int DAY_OF_WEEK_SATURDAY = 6;

    /**
     * 7: Sunday
     */
    public static final int DAY_OF_WEEK_SUNDAY = 7;

    /**
     * 0: device does not support the 1/256th of seconds
     */
    public static final int FRACTIONS_256_NOT_SUPPORTED = 0;

    /**
     * 1/256th of a second
     */
    public static final double FRACTIONS_256_UNIT = 1 / 256d;

    /**
     * @see #ADJUST_REASON_NO_MANUAL_TIME_UPDATE
     * @see #ADJUST_REASON_MANUAL_TIME_UPDATE
     */
    public static final int ADJUST_REASON_MANUTAL_TIME_UPDATE_MASK = 0b00000001;

    /**
     * <p>
     * 0: No manual time update
     * index 0
     * </p>
     */
    public static final int ADJUST_REASON_NO_MANUAL_TIME_UPDATE = 0b00000000;

    /**
     * <p>
     * 1: Manual time update
     * index 0
     * </p>
     */
    public static final int ADJUST_REASON_MANUAL_TIME_UPDATE = 0b00000001;

    /**
     * @see #ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
     * @see #ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
     */
    public static final int ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE_MASK = 0b00000010;

    /**
     * <p>
     * 0: No external reference time update
     * index 1
     * </p>
     */
    public static final int ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE = 0b00000000;

    /**
     * <p>
     * 1: External reference time update
     * index 1
     * </p>
     */
    public static final int ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE = 0b00000010;

    /**
     * @see #ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
     * @see #ADJUST_REASON_CHANGE_OF_TIME_ZONE
     */
    public static final int ADJUST_REASON_CHANGE_OF_TIME_ZONE_MASK = 0b00000100;

    /**
     * <p>
     * 0: No change of time zone
     * index 2
     * </p>
     */
    public static final int ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE = 0b00000000;

    /**
     * <p>
     * 1: Change of time zone
     * index 2
     * </p>
     */
    public static final int ADJUST_REASON_CHANGE_OF_TIME_ZONE = 0b00000100;

    /**
     * @see #ADJUST_REASON_NO_CHANGE_OF_DST
     * @see #ADJUST_REASON_CHANGE_OF_DST
     */
    public static final int ADJUST_REASON_CHANGE_OF_DST_MASK = 0b00001000;

    /**
     * <p>
     * 0: No change of DST (daylight savings time)
     * index 3
     * </p>
     */
    public static final int ADJUST_REASON_NO_CHANGE_OF_DST = 0b00000000;

    /**
     * <p>
     * 1: Change of DST (daylight savings time)
     * index 3
     * </p>
     */
    public static final int ADJUST_REASON_CHANGE_OF_DST = 0b00001000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CurrentTime> CREATOR = new ByteArrayCreater<CurrentTime>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTime createFromParcel(@NonNull Parcel in) {
            return new CurrentTime(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTime[] newArray(int size) {
            return new CurrentTime[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CurrentTime createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CurrentTime(bluetoothGattCharacteristic);
        }

    };

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
     * Day of Week
     */
    private final int mDayOfWeek;

    /**
     * Fractions256
     */
    private final int mFractions256;

    /**
     * Adjust Reason
     */
    private final int mAdjustReason;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A2B
     */
    public CurrentTime(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mYear = BLEUtils.createUInt16(values, 0);
        mMonth = (values[2] & 0xff);
        mDay = (values[3] & 0xff);
        mHours = (values[4] & 0xff);
        mMinutes = (values[5] & 0xff);
        mSeconds = (values[6] & 0xff);
        mDayOfWeek = (values[7] & 0xff);
        mFractions256 = (values[8] & 0xff);
        mAdjustReason = values[9];
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CurrentTime(@NonNull Parcel in) {
        mYear = in.readInt();
        mMonth = in.readInt();
        mDay = in.readInt();
        mHours = in.readInt();
        mMinutes = in.readInt();
        mSeconds = in.readInt();
        mDayOfWeek = in.readInt();
        mFractions256 = in.readInt();
        mAdjustReason = in.readInt();
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
        dest.writeInt(mYear);
        dest.writeInt(mMonth);
        dest.writeInt(mDay);
        dest.writeInt(mHours);
        dest.writeInt(mMinutes);
        dest.writeInt(mSeconds);
        dest.writeInt(mDayOfWeek);
        dest.writeInt(mFractions256);
        dest.writeInt(mAdjustReason);
    }

    /**
     * @return Year
     * @see org.im97mori.ble.characteristic.core.DateTimeUtils
     */
    public int getYear() {
        return mYear;
    }

    /**
     * @return Month
     * @see org.im97mori.ble.characteristic.core.DateTimeUtils
     */
    public int getMonth() {
        return mMonth;
    }

    /**
     * @return Day
     * @see org.im97mori.ble.characteristic.core.DateTimeUtils
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
     * @return Day of Week
     */
    public int getDayOfWeek() {
        return mDayOfWeek;
    }

    /**
     * @return {@code true}:Day of week is not known, {@code false}:has day of week information
     * @see #DAY_OF_WEEK_IS_NOT_KNOWN
     */
    public boolean isDayOfWeekNotKnown() {
        return DAY_OF_WEEK_IS_NOT_KNOWN == mDayOfWeek;
    }

    /**
     * @return {@code true}:Monday, {@code false}:not Monday
     * @see #DAY_OF_WEEK_MONDAY
     */
    public boolean isDayOfWeekMonday() {
        return DAY_OF_WEEK_MONDAY == mDayOfWeek;
    }

    /**
     * @return {@code true}:Tuesday, {@code false}:not Tuesday
     * @see #DAY_OF_WEEK_TUESDAY
     */
    public boolean isDayOfWeekTuesday() {
        return DAY_OF_WEEK_TUESDAY == mDayOfWeek;
    }

    /**
     * @return {@code true}:Wednesday, {@code false}:not Wednesday
     * @see #DAY_OF_WEEK_WEDNESDAY
     */
    public boolean isDayOfWeekWednesday() {
        return DAY_OF_WEEK_WEDNESDAY == mDayOfWeek;
    }

    /**
     * @return {@code true}:Thursday, {@code false}:not Thursday
     * @see #DAY_OF_WEEK_THURSDAY
     */
    public boolean isDayOfWeekThursday() {
        return DAY_OF_WEEK_THURSDAY == mDayOfWeek;
    }

    /**
     * @return {@code true}:Friday, {@code false}:not Friday
     * @see #DAY_OF_WEEK_FRIDAY
     */
    public boolean isDayOfWeekFriday() {
        return DAY_OF_WEEK_FRIDAY == mDayOfWeek;
    }

    /**
     * @return {@code true}:Saturday, {@code false}:not Saturday
     * @see #DAY_OF_WEEK_SATURDAY
     */
    public boolean isDayOfWeekSaturday() {
        return DAY_OF_WEEK_SATURDAY == mDayOfWeek;
    }

    /**
     * @return {@code true}:Sunday, {@code false}:not Sunday
     * @see #DAY_OF_WEEK_SUNDAY
     */
    public boolean isDayOfWeekSunday() {
        return DAY_OF_WEEK_SUNDAY == mDayOfWeek;
    }

    /**
     * @return Fractions256
     */
    public int getFractions256() {
        return mFractions256;
    }

    /**
     * @return {@code true}:device does not support the 1/256th of seconds, {@code false}:device supports the 1/256th of seconds
     * @see #FRACTIONS_256_NOT_SUPPORTED
     */
    public boolean isFractions256Supported() {
        return FRACTIONS_256_NOT_SUPPORTED == mFractions256;
    }

    /**
     * @return Fractions256 with Unit
     * @see #FRACTIONS_256_UNIT
     */
    public double getFractions256WithUnit() {
        return FRACTIONS_256_UNIT * mFractions256;
    }

    /**
     * @return Fraction256(millis)
     */
    public long getFractions256Millis() {
        return (long) (getFractions256WithUnit() * 1000L);
    }

    /**
     * @return Adjust Reason
     */
    public int getAdjustReason() {
        return mAdjustReason;
    }

    /**
     * @return {@code true}:No manual time update, {@code false}:Not no manual time update
     * @see #ADJUST_REASON_NO_MANUAL_TIME_UPDATE
     */
    public boolean isAdjustReasonNoManualTimeUpdate() {
        return isAdjustReasonMatched(ADJUST_REASON_MANUTAL_TIME_UPDATE_MASK, ADJUST_REASON_NO_MANUAL_TIME_UPDATE);
    }

    /**
     * @return {@code true}:Manual time update, {@code false}:Not manual time update
     * @see #ADJUST_REASON_MANUAL_TIME_UPDATE
     */
    public boolean isAdjustReasonManualTimeUpdate() {
        return isAdjustReasonMatched(ADJUST_REASON_MANUTAL_TIME_UPDATE_MASK, ADJUST_REASON_MANUAL_TIME_UPDATE);
    }

    /**
     * @return {@code true}:No external reference time update, {@code false}:Not no external reference time update
     * @see #ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE
     */
    public boolean isAdjustReasonNoExternalReferenceTimeUpdate() {
        return isAdjustReasonMatched(ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE_MASK, ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE);
    }

    /**
     * @return {@code true}:External reference time update, {@code false}:Not external reference time update
     * @see #ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE
     */
    public boolean isAdjustReasonExternalReferenceTimeUpdate() {
        return isAdjustReasonMatched(ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE_MASK, ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE);
    }

    /**
     * @return {@code true}:No change of time zone, {@code false}:Not no change of time zone
     * @see #ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE
     */
    public boolean isAdjustReasonNoChangeOfTimeZone() {
        return isAdjustReasonMatched(ADJUST_REASON_CHANGE_OF_TIME_ZONE_MASK, ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE);
    }

    /**
     * @return {@code true}:Change of time zone, {@code false}:Not change of time zone
     * @see #ADJUST_REASON_CHANGE_OF_TIME_ZONE
     */
    public boolean isAdjustReasonChangeOfTimeZone() {
        return isAdjustReasonMatched(ADJUST_REASON_CHANGE_OF_TIME_ZONE_MASK, ADJUST_REASON_CHANGE_OF_TIME_ZONE);
    }

    /**
     * @return {@code true}:No change of DST (daylight savings time), {@code false}:Not no change of DST (daylight savings time)
     * @see #ADJUST_REASON_NO_CHANGE_OF_DST
     */
    public boolean isAdjustReasonNoChangeOfDst() {
        return isAdjustReasonMatched(ADJUST_REASON_CHANGE_OF_DST_MASK, ADJUST_REASON_NO_CHANGE_OF_DST);
    }

    /**
     * @return {@code true}:Change of DST (daylight savings time), {@code false}:Not change of DST (daylight savings time)
     * @see #ADJUST_REASON_CHANGE_OF_DST
     */
    public boolean isAdjustReasonChangeOfDst() {
        return isAdjustReasonMatched(ADJUST_REASON_CHANGE_OF_DST_MASK, ADJUST_REASON_CHANGE_OF_DST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[10];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mYear);
        byteBuffer.put((byte) mMonth);
        byteBuffer.put((byte) mDay);
        byteBuffer.put((byte) mHours);
        byteBuffer.put((byte) mMinutes);
        byteBuffer.put((byte) mSeconds);
        byteBuffer.put((byte) mDayOfWeek);
        byteBuffer.put((byte) mFractions256);
        byteBuffer.put((byte) mAdjustReason);
        return data;
    }

    /**
     * check Adjust Reason
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #ADJUST_REASON_NO_MANUAL_TIME_UPDATE}
     *               , {@link #ADJUST_REASON_MANUAL_TIME_UPDATE}
     *               , {@link #ADJUST_REASON_NO_EXTERNAL_REFEREMCE_TIME_UPDATE}
     *               , {@link #ADJUST_REASON_EXTERNAL_REFERENCE_TIME_UPDATE}
     *               , {@link #ADJUST_REASON_NO_CHANGE_OF_TIME_ZONE}
     *               , {@link #ADJUST_REASON_CHANGE_OF_TIME_ZONE}
     *               , {@link #ADJUST_REASON_NO_CHANGE_OF_DST}
     *               , {@link #ADJUST_REASON_CHANGE_OF_DST}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isAdjustReasonMatched(int mask, int expect) {
        return (mask & mAdjustReason) == expect;
    }

}
