package org.im97mori.ble.characteristic.bcs;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.MultiplePacketCreater;

import java.util.Arrays;

/**
 * Body Composition Measurement (Characteristics UUID: 0x2A9C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BodyCompositionMeasurement implements Parcelable {

    /**
     * 0xffff: Measurement Unsuccessful
     */
    public static final int MEASUREMENT_UNSUCCESSFUL = 0xffff;

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
     * @see #FLAG_BASAL_METABOLISM_PRESENT_FALSE
     * @see #FLAG_BASAL_METABOLISM_PRESENT_TRUE
     */
    public static final int FLAG_BASAL_METABOLISM_PRESENT_MASK = 0b00001000;

    /**
     * 0: Basal Metabolism present False
     */
    public static final int FLAG_BASAL_METABOLISM_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Basal Metabolism present True
     */
    public static final int FLAG_BASAL_METABOLISM_PRESENT_TRUE = 0b00001000;

    /**
     * @see #FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
     * @see #FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
     */
    public static final int FLAG_MUSCLE_PERCENTAGE_PRESENT_MASK = 0b00010000;

    /**
     * 0: Muscle Percentage present False
     */
    public static final int FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Muscle Percentage present True
     */
    public static final int FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE = 0b00010000;

    /**
     * @see #FLAG_MUSCLE_MASS_PRESENT_FALSE
     * @see #FLAG_MUSCLE_MASS_PRESENT_TRUE
     */
    public static final int FLAG_MUSCLE_MASS_PRESENT_MASK = 0b00100000;

    /**
     * 0: Muscle Mass present False
     */
    public static final int FLAG_MUSCLE_MASS_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Muscle Mass present True
     */
    public static final int FLAG_MUSCLE_MASS_PRESENT_TRUE = 0b00100000;

    /**
     * @see #FLAG_FAT_FREE_MASS_PRESENT_FALSE
     * @see #FLAG_FAT_FREE_MASS_PRESENT_TRUE
     */
    public static final int FLAG_FAT_FREE_MASS_PRESENT_MASK = 0b01000000;

    /**
     * 0: Fat Free Mass present False
     */
    public static final int FLAG_FAT_FREE_MASS_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Fat Free Mass present True
     */
    public static final int FLAG_FAT_FREE_MASS_PRESENT_TRUE = 0b01000000;

    /**
     * @see #FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
     * @see #FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
     */
    public static final int FLAG_SOFT_LEAN_MASS_PRESENT_MASK = 0b10000000;

    /**
     * 0: Soft Lean Mass present False
     */
    public static final int FLAG_SOFT_LEAN_MASS_PRESENT_FALSE = 0b00000000;

    /**
     * 1: Soft Lean Mass present True
     */
    public static final int FLAG_SOFT_LEAN_MASS_PRESENT_TRUE = 0b10000000;

    /**
     * @see #FLAG_BODY_WATER_MASS_PRESENT_FALSE
     * @see #FLAG_BODY_WATER_MASS_PRESENT_TRUE
     */
    public static final int FLAG_BODY_WATER_MASS_PRESENT_MASK = 0b00000001_00000000;

    /**
     * 0: Body Water Mass present False
     */
    public static final int FLAG_BODY_WATER_MASS_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Body Water Mass present True
     */
    public static final int FLAG_BODY_WATER_MASS_PRESENT_TRUE = 0b00000001_00000000;

    /**
     * @see #FLAG_IMPEDANCE_PRESENT_FALSE
     * @see #FLAG_IMPEDANCE_PRESENT_TRUE
     */
    public static final int FLAG_IMPEDANCE_PRESENT_MASK = 0b00000010_00000000;

    /**
     * 0: Impedance present False
     */
    public static final int FLAG_IMPEDANCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Impedance present True
     */
    public static final int FLAG_IMPEDANCE_PRESENT_TRUE = 0b00000010_00000000;

    /**
     * @see #FLAG_WEIGHT_PRESENT_FALSE
     * @see #FLAG_WEIGHT_PRESENT_TRUE
     */
    public static final int FLAG_WEIGHT_PRESENT_MASK = 0b00000100_00000000;

    /**
     * 0: Weight present False
     */
    public static final int FLAG_WEIGHT_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Weight present True
     */
    public static final int FLAG_WEIGHT_PRESENT_TRUE = 0b00000100_00000000;

    /**
     * @see #FLAG_HEIGHT_PRESENT_FALSE
     * @see #FLAG_HEIGHT_PRESENT_TRUE
     */
    public static final int FLAG_HEIGHT_PRESENT_MASK = 0b00001000_00000000;

    /**
     * 0: Height present False
     */
    public static final int FLAG_HEIGHT_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Height present True
     */
    public static final int FLAG_HEIGHT_PRESENT_TRUE = 0b00001000_00000000;

    /**
     * @see #FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE
     * @see #FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE
     */
    public static final int FLAG_MULTIPLE_PACKET_MEASUREMENT_MASK = 0b00010000_00000000;

    /**
     * 0: Multiple Packet Measurement False
     */
    public static final int FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Multiple Packet Measurement True
     */
    public static final int FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE = 0b00010000_00000000;

    /**
     * Body Fat Percentage Resolution Unit
     */
    public static final double BODY_FAT_PERCENTAGE_RESOLUTION = 0.1d;

    /**
     * Basal Metabolism Resolution Unit
     */
    public static final double BASAL_METABOLISM_RESOLUTION = 1000d;

    /**
     * Muscle Percentage Resolution Unit
     */
    public static final double MUSCLE_PERCENTAGE_RESOLUTION = 0.1d;

    /**
     * Muscle Mass - SI Resolution Unit
     */
    public static final double MUSCLE_MASS_SI_RESOLUTION = 0.005d;

    /**
     * Muscle Mass - Imperial Resolution Unit
     */
    public static final double MUSCLE_MASS_IMPERIAL_RESOLUTION = 0.01d;

    /**
     * Fat Free Mass - SI Resolution Unit
     */
    public static final double FAT_FREE_MASS_SI_RESOLUTION = 0.005d;

    /**
     * Fat Free Mass - Imperial Resolution Unit
     */
    public static final double FAT_FREE_MASS_IMPERIAL_RESOLUTION = 0.01d;

    /**
     * Soft Lean Mass - SI Resolution Unit
     */
    public static final double SOFT_LEAN_MASS_SI_RESOLUTION = 0.005d;

    /**
     * Soft Lean Mass - Imperial Resolution Unit
     */
    public static final double SOFT_LEAN_MASS_IMPERIAL_RESOLUTION = 0.01d;

    /**
     * Body Water Mass - SI Resolution Unit
     */
    public static final double BODY_WATER_MASS_SI_RESOLUTION = 0.005d;

    /**
     * Body Water Mass - Imperial Resolution Unit
     */
    public static final double BODY_WATER_MASS_IMPERIAL_RESOLUTION = 0.01d;

    /**
     * Impedance Resolution Unit
     */
    public static final double IMPEDANCE_RESOLUTION = 0.1d;

    /**
     * Weight - SI Resolution Unit
     */
    public static final double WEIGHT_SI_RESOLUTION = 0.005d;

    /**
     * Weight - Imperial Resolution Unit
     */
    public static final double WEIGHT_IMPERIAL_RESOLUTION = 0.01d;

    /**
     * Height - SI Resolution Unit
     */
    public static final double HEIGHT_SI_RESOLUTION = 0.001d;

    /**
     * Height - Imperial Resolution Unit
     */
    public static final double HEIGHT_IMPERIAL_RESOLUTION = 0.1d;

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<BodyCompositionMeasurement, BodyCompositionMeasurementPacket> CREATOR = new MultiplePacketCreater<BodyCompositionMeasurement, BodyCompositionMeasurementPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurement createFromParcel(@NonNull Parcel in) {
            return new BodyCompositionMeasurement(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurement[] newArray(int size) {
            return new BodyCompositionMeasurement[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BodyCompositionMeasurement createFromMultiplePacketArray(@NonNull BodyCompositionMeasurementPacket[] multiplePacketArray) {
            return new BodyCompositionMeasurement(multiplePacketArray);
        }

    };

    /**
     * Flags
     */
    private final byte[] mFlags;

    /**
     * Body Fat Percentage
     */
    private final int mBodyFatPercentage;

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
     * Basal Metabolism
     */
    private final int mBasalMetabolism;

    /**
     * Muscle Percentage
     */
    private final int mMusclePercentage;

    /**
     * Muscle Mass - SI(Muscle Mass - Kilograms in xml)
     */
    private final int mMuscleMassSi;

    /**
     * Muscle Mass - Imperial(Muscle Mass - Pounds in xml)
     */
    private final int mMuscleMassImperial;

    /**
     * Fat Free Mass - SI(Fat Free Mass - Kilograms in xml)
     */
    private final int mFatFreeMassSi;

    /**
     * Fat Free Mass - Imperial(Fat Free Mass - Pounds in xml)
     */
    private final int mFatFreeMassImperial;

    /**
     * Soft Lean Mass - SI(Soft Lean Mass - Kilograms in xml)
     */
    private final int mSoftLeanMassSi;

    /**
     * Soft Lean Mass - Imperial(Soft Lean Mass - Pounds in xml)
     */
    private final int mSoftLeanMassImperial;

    /**
     * Body Water Mass - SI(Body Water Mass - Kilograms in xml)
     */
    private final int mBodyWaterMassSi;

    /**
     * Body Water Mass - Imperial(Body Water Mass - Pounds in xml)
     */
    private final int mBodyWaterMassImperial;

    /**
     * Impedance
     */
    private final int mImpedance;

    /**
     * Weight - SI(Weight - Kilograms in xml)
     */
    private final int mWeightSi;

    /**
     * Weight - Imperial(Weight - Pounds in xml)
     */
    private final int mWeightImperial;

    /**
     * Height - SI(Height - Meters in xml)
     */
    private final int mHeightSi;

    /**
     * Height - Imperial(Height - Inches in xml)
     */
    private final int mHeightImperial;

    /**
     * Constructor from {@link BodyCompositionMeasurementPacket} array
     *
     * @param bodyCompositionMeasurementPackets 1 or 2 Body Composition Measurement packet array
     */
    public BodyCompositionMeasurement(@NonNull BodyCompositionMeasurementPacket[] bodyCompositionMeasurementPackets) {
        byte[] flags = new byte[2];
        int bodyFatPercentage = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        int userId = 0;
        int basalMetabolism = 0;
        int musclePercentage = 0;
        int muscleMassSi = 0;
        int muscleMassImperial = 0;
        int fatFreeMassSi = 0;
        int fatFreeMassImperial = 0;
        int softLeanMassSi = 0;
        int softLeanMassImperial = 0;
        int bodyWaterSi = 0;
        int bodyWaterImperial = 0;
        int impedance = 0;
        int weightSi = 0;
        int weightImperial = 0;
        int heightSi = 0;
        int heightImperial = 0;

        // give priority to 2nd packet
        for (BodyCompositionMeasurementPacket bodyCompositionMeasurementPacket : bodyCompositionMeasurementPackets) {
            byte[] values = bodyCompositionMeasurementPacket.getBytes();
            int index = 4;
            flags = Arrays.copyOfRange(values, 0, 2);
            bodyFatPercentage = BLEUtils.createUInt16(values, 2);

            if (isFlagsTimeStampPresent(flags)) {
                year = BLEUtils.createUInt16(values, index);
                index += 2;
                month = (values[index++] & 0xff);
                day = (values[index++] & 0xff);
                hours = (values[index++] & 0xff);
                minutes = (values[index++] & 0xff);
                seconds = (values[index++] & 0xff);
            }

            if (isFlagsUserIdPresent(flags)) {
                userId = (values[index++] & 0xff);
            }

            if (isMeasurementSuccessful(bodyFatPercentage)) {
                if (isFlagsBasalMetabolismPresent(flags)) {
                    basalMetabolism = BLEUtils.createUInt16(values, index);
                    index += 2;
                }
                if (isFlagsMusclePercentagePresent(flags)) {
                    musclePercentage = BLEUtils.createUInt16(values, index);
                    index += 2;
                }
                if (isFlagsMuscleMassPresent(flags)) {
                    if (isFlagsMeasurementUnitSI(flags)) {
                        muscleMassSi = BLEUtils.createUInt16(values, index);
                    } else {
                        muscleMassImperial = BLEUtils.createUInt16(values, index);
                    }
                    index += 2;
                }
                if (isFlagsFatFreeMassPresent(flags)) {
                    if (isFlagsMeasurementUnitSI(flags)) {
                        fatFreeMassSi = BLEUtils.createUInt16(values, index);
                    } else {
                        fatFreeMassImperial = BLEUtils.createUInt16(values, index);
                    }
                    index += 2;
                }
                if (isFlagsSoftLeanMassPresent(flags)) {
                    if (isFlagsMeasurementUnitSI(flags)) {
                        softLeanMassSi = BLEUtils.createUInt16(values, index);
                    } else {
                        softLeanMassImperial = BLEUtils.createUInt16(values, index);
                    }
                    index += 2;
                }
                if (isFlagsBodyWaterMassPresent(flags)) {
                    if (isFlagsMeasurementUnitSI(flags)) {
                        bodyWaterSi = BLEUtils.createUInt16(values, index);
                    } else {
                        bodyWaterImperial = BLEUtils.createUInt16(values, index);
                    }
                    index += 2;
                }
                if (isFlagsImpedancePresent(flags)) {
                    impedance = BLEUtils.createUInt16(values, index);
                    index += 2;
                }
                if (isFlagsWeightPresent(flags)) {
                    if (isFlagsMeasurementUnitSI(flags)) {
                        weightSi = BLEUtils.createUInt16(values, index);
                    } else {
                        weightImperial = BLEUtils.createUInt16(values, index);
                    }
                    index += 2;
                }
                if (isFlagsHeightPresent(flags)) {
                    if (isFlagsMeasurementUnitSI(flags)) {
                        heightSi = BLEUtils.createUInt16(values, index);
                    } else {
                        heightImperial = BLEUtils.createUInt16(values, index);
                    }
                }
            }
        }

        mFlags = flags;
        mBodyFatPercentage = bodyFatPercentage;
        mYear = year;
        mMonth = month;
        mDay = day;
        mHours = hours;
        mMinutes = minutes;
        mSeconds = seconds;
        mUserId = userId;
        mBasalMetabolism = basalMetabolism;
        mMusclePercentage = musclePercentage;
        mMuscleMassSi = muscleMassSi;
        mMuscleMassImperial = muscleMassImperial;
        mFatFreeMassSi = fatFreeMassSi;
        mFatFreeMassImperial = fatFreeMassImperial;
        mSoftLeanMassSi = softLeanMassSi;
        mSoftLeanMassImperial = softLeanMassImperial;
        mBodyWaterMassSi = bodyWaterSi;
        mBodyWaterMassImperial = bodyWaterImperial;
        mImpedance = impedance;
        mWeightSi = weightSi;
        mWeightImperial = weightImperial;
        mHeightSi = heightSi;
        mHeightImperial = heightImperial;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BodyCompositionMeasurement(@NonNull Parcel in) {
        mFlags = in.createByteArray();
        mBodyFatPercentage = in.readInt();
        mYear = in.readInt();
        mMonth = in.readInt();
        mDay = in.readInt();
        mHours = in.readInt();
        mMinutes = in.readInt();
        mSeconds = in.readInt();
        mUserId = in.readInt();
        mBasalMetabolism = in.readInt();
        mMusclePercentage = in.readInt();
        mMuscleMassSi = in.readInt();
        mMuscleMassImperial = in.readInt();
        mFatFreeMassSi = in.readInt();
        mFatFreeMassImperial = in.readInt();
        mSoftLeanMassSi = in.readInt();
        mSoftLeanMassImperial = in.readInt();
        mBodyWaterMassSi = in.readInt();
        mBodyWaterMassImperial = in.readInt();
        mImpedance = in.readInt();
        mWeightSi = in.readInt();
        mWeightImperial = in.readInt();
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
        dest.writeByteArray(mFlags);
        dest.writeInt(mBodyFatPercentage);
        dest.writeInt(mYear);
        dest.writeInt(mMonth);
        dest.writeInt(mDay);
        dest.writeInt(mHours);
        dest.writeInt(mMinutes);
        dest.writeInt(mSeconds);
        dest.writeInt(mUserId);
        dest.writeInt(mBasalMetabolism);
        dest.writeInt(mMusclePercentage);
        dest.writeInt(mMuscleMassSi);
        dest.writeInt(mMuscleMassImperial);
        dest.writeInt(mFatFreeMassSi);
        dest.writeInt(mFatFreeMassImperial);
        dest.writeInt(mSoftLeanMassSi);
        dest.writeInt(mSoftLeanMassImperial);
        dest.writeInt(mBodyWaterMassSi);
        dest.writeInt(mBodyWaterMassImperial);
        dest.writeInt(mImpedance);
        dest.writeInt(mWeightSi);
        dest.writeInt(mWeightImperial);
        dest.writeInt(mHeightSi);
        dest.writeInt(mHeightImperial);
    }

    /**
     * @return Flags
     */
    public byte[] getFlags() {
        return mFlags;
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Weight Measurement Unit is SI, {@code false}:Weight Measurement Unit is not SI
     */
    public boolean isFlagsMeasurementUnitSI(byte[] flags) {
        return isFlagsMatched(FLAG_MEASUREMENT_UNITS_MASK, FLAG_MEASUREMENT_UNITS_SI, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Weight Measurement Unit is Imperial, {@code false}:Weight Measurement Unit is not Imperial
     */
    public boolean isFlagsMeasurementUnitImperial(byte[] flags) {
        return isFlagsMatched(FLAG_MEASUREMENT_UNITS_MASK, FLAG_MEASUREMENT_UNITS_IMPERIAL, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Time stamp not present, {@code false}:Time stamp present
     */
    public boolean isFlagsTimeStampNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_TIME_STAMP_PRESENT_MASK, FLAG_TIME_STAMP_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Time stamp present, {@code false}:Time stamp not present
     */
    public boolean isFlagsTimeStampPresent(byte[] flags) {
        return isFlagsMatched(FLAG_TIME_STAMP_PRESENT_MASK, FLAG_TIME_STAMP_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:User ID not present, {@code false}:User ID present
     */
    public boolean isFlagsUserIdNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_USER_ID_PRESENT_MASK, FLAG_USER_ID_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:User ID present, {@code false}:User ID not present
     */
    public boolean isFlagsUserIdPresent(byte[] flags) {
        return isFlagsMatched(FLAG_USER_ID_PRESENT_MASK, FLAG_USER_ID_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Basal Metabolism not present, {@code false}:Basal Metabolism present
     */
    public boolean isFlagsBasalMetabolismNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_BASAL_METABOLISM_PRESENT_MASK, FLAG_BASAL_METABOLISM_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Basal Metabolism present, {@code false}:Basal Metabolism not present
     */
    public boolean isFlagsBasalMetabolismPresent(byte[] flags) {
        return isFlagsMatched(FLAG_BASAL_METABOLISM_PRESENT_MASK, FLAG_BASAL_METABOLISM_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Muscle Percentage not present, {@code false}:Muscle Percentage present
     */
    public boolean isFlagsMusclePercentageNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_MUSCLE_PERCENTAGE_PRESENT_MASK, FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Muscle Percentage present, {@code false}:Muscle Percentage not present
     */
    public boolean isFlagsMusclePercentagePresent(byte[] flags) {
        return isFlagsMatched(FLAG_MUSCLE_PERCENTAGE_PRESENT_MASK, FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Muscle Mass not present, {@code false}:Muscle Mass present
     */
    public boolean isFlagsMuscleMassNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_MUSCLE_MASS_PRESENT_MASK, FLAG_MUSCLE_MASS_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Muscle Mass present, {@code false}:Muscle Mass not present
     */
    public boolean isFlagsMuscleMassPresent(byte[] flags) {
        return isFlagsMatched(FLAG_MUSCLE_MASS_PRESENT_MASK, FLAG_MUSCLE_MASS_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Fat Free Mass not present, {@code false}:Fat Free Mass present
     */
    public boolean isFlagsFatFreeMassNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_FAT_FREE_MASS_PRESENT_MASK, FLAG_FAT_FREE_MASS_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Fat Free Mass present, {@code false}:Fat Free Mass not present
     */
    public boolean isFlagsFatFreeMassPresent(byte[] flags) {
        return isFlagsMatched(FLAG_FAT_FREE_MASS_PRESENT_MASK, FLAG_FAT_FREE_MASS_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Soft Lean Mass not present, {@code false}Soft Lean Mass present
     */
    public boolean isFlagsSoftLeanMassNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_SOFT_LEAN_MASS_PRESENT_MASK, FLAG_SOFT_LEAN_MASS_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Soft Lean Mass present, {@code false}:Soft Lean Mass not present
     */
    public boolean isFlagsSoftLeanMassPresent(byte[] flags) {
        return isFlagsMatched(FLAG_SOFT_LEAN_MASS_PRESENT_MASK, FLAG_SOFT_LEAN_MASS_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Body Water Mass not present, {@code false}:Body Water Mass present
     */
    public boolean isFlagsBodyWaterMassNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_BODY_WATER_MASS_PRESENT_MASK, FLAG_BODY_WATER_MASS_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Body Water Mass present, {@code false}:Body Water Mass not present
     */
    public boolean isFlagsBodyWaterMassPresent(byte[] flags) {
        return isFlagsMatched(FLAG_BODY_WATER_MASS_PRESENT_MASK, FLAG_BODY_WATER_MASS_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Impedance not present, {@code false}:Impedance present
     */
    public boolean isFlagsImpedanceNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_IMPEDANCE_PRESENT_MASK, FLAG_IMPEDANCE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Impedance present, {@code false}:Impedance not present
     */
    public boolean isFlagsImpedancePresent(byte[] flags) {
        return isFlagsMatched(FLAG_IMPEDANCE_PRESENT_MASK, FLAG_IMPEDANCE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Weight not present, {@code false}:Weight present
     */
    public boolean isFlagsWeightNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_WEIGHT_PRESENT_MASK, FLAG_WEIGHT_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Weight present, {@code false}:Weight not present
     */
    public boolean isFlagsWeightPresent(byte[] flags) {
        return isFlagsMatched(FLAG_WEIGHT_PRESENT_MASK, FLAG_WEIGHT_PRESENT_TRUE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Height not present, {@code false}:Height present
     */
    public boolean isFlagsHeightNotPresent(byte[] flags) {
        return isFlagsMatched(FLAG_HEIGHT_PRESENT_MASK, FLAG_HEIGHT_PRESENT_FALSE, flags);
    }

    /**
     * @param flags current packet's flags
     * @return {@code true}:Height present, {@code false}:Height not present
     */
    public boolean isFlagsHeightPresent(byte[] flags) {
        return isFlagsMatched(FLAG_HEIGHT_PRESENT_MASK, FLAG_HEIGHT_PRESENT_TRUE, flags);
    }

    /**
     * @return Body Fat Percentage
     */
    public int getBodyFatPercentage() {
        return mBodyFatPercentage;
    }

    /**
     * @param bodyFatPercentage current packet's Body Fat Percentage
     * @return {@code true}:Measurement Successful, {@code false}: Measurement Unsuccessful
     */
    public boolean isMeasurementSuccessful(int bodyFatPercentage) {
        return MEASUREMENT_UNSUCCESSFUL != bodyFatPercentage;
    }

    /**
     * @param bodyFatPercentage current packet's Body Fat Percentage
     * @return {@code true}:Measurement Unsuccessful, {@code false}: Measurement Successful
     */
    public boolean isMeasurementUnsuccessful(int bodyFatPercentage) {
        return MEASUREMENT_UNSUCCESSFUL == bodyFatPercentage;
    }

    /**
     * @return Body Fat Percentage(unit 0.1)
     */
    public double getBodyFatPercentageWithUnit() {
        return BODY_FAT_PERCENTAGE_RESOLUTION * mBodyFatPercentage;
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
     * @return User ID
     */
    public int getUserId() {
        return mUserId;
    }

    /**
     * @return Basal Metabolism
     */
    public int getBasalMetabolism() {
        return mBasalMetabolism;
    }

    /**
     * @return Basal Metabolism(kilo Joules)
     */
    public double getBasalMetabolismKj() {
        return BASAL_METABOLISM_RESOLUTION * mBasalMetabolism;
    }

    /**
     * @return Muscle Percentage
     */
    public int getMusclePercentage() {
        return mMusclePercentage;
    }

    /**
     * @return Muscle Percentage(unit 0.1)
     */
    public double getMusclePercentageWithUnit() {
        return MUSCLE_PERCENTAGE_RESOLUTION * mMusclePercentage;
    }

    /**
     * @return Muscle Mass - SI(Muscle Mass - Kilograms in xml)
     */
    public int getMuscleMassSi() {
        return mMuscleMassSi;
    }

    /**
     * @return Muscle Mass(kg)
     */
    public double getMuscleMassSiKg() {
        return MUSCLE_MASS_SI_RESOLUTION * mMuscleMassSi;
    }

    /**
     * @return Muscle Mass - Imperial(Muscle Mass - Pounds in xml)
     */
    public int getMuscleMassImperial() {
        return mMuscleMassImperial;
    }

    /**
     * @return Muscle Mass(pounds)
     */
    public double getMuscleMassImperialLb() {
        return MUSCLE_MASS_IMPERIAL_RESOLUTION * mMuscleMassImperial;
    }

    /**
     * @return Fat Free Mass - SI(Fat Free Mass - Kilograms in xml)
     */
    public int getFatFreeMassSi() {
        return mFatFreeMassSi;
    }

    /**
     * @return Fat Free Mass(kg)
     */
    public double getFatFreeMassSiKg() {
        return FAT_FREE_MASS_SI_RESOLUTION * mFatFreeMassSi;
    }

    /**
     * @return Fat Free Mass - Imperial(Fat Free Mass - Pounds in xml)
     */
    public int getFatFreeMassImperial() {
        return mFatFreeMassImperial;
    }

    /**
     * @return Fat Free Mass(pounds)
     */
    public double getFatFreeMassImperialLb() {
        return FAT_FREE_MASS_IMPERIAL_RESOLUTION * mFatFreeMassImperial;
    }

    /**
     * @return Soft Lean Mass - SI(Soft Lean Mass - Kilograms in xml)
     */
    public int getSoftLeanMassSi() {
        return mSoftLeanMassSi;
    }

    /**
     * @return Soft Lean Mass(kg)
     */
    public double getSoftLeanMassSiKg() {
        return SOFT_LEAN_MASS_SI_RESOLUTION * mSoftLeanMassSi;
    }

    /**
     * @return Soft Lean Mass - Imperial(Soft Lean Mass - Pounds in xml)
     */
    public int getSoftLeanMassImperial() {
        return mSoftLeanMassImperial;
    }

    /**
     * @return Soft Lean Mass(pounds)
     */
    public double getSoftLeanMassImperialLb() {
        return SOFT_LEAN_MASS_IMPERIAL_RESOLUTION * mSoftLeanMassImperial;
    }

    /**
     * @return Body Water Mass - SI(Body Water Mass - Kilograms in xml)
     */
    public int getBodyWaterMassSi() {
        return mBodyWaterMassSi;
    }

    /**
     * @return Body Water Mass(kg)
     */
    public double getBodyWaterMassSiKg() {
        return BODY_WATER_MASS_SI_RESOLUTION * mBodyWaterMassSi;
    }

    /**
     * @return Body Water Mass - Imperial(Body Water Mass - Pounds in xml)
     */
    public int getBodyWaterMassImperial() {
        return mBodyWaterMassImperial;
    }

    /**
     * @return Body Water Mass(pounds)
     */
    public double getBodyWaterMassImperialLb() {
        return BODY_WATER_MASS_IMPERIAL_RESOLUTION * mBodyWaterMassImperial;
    }

    /**
     * @return Impedance
     */
    public int getImpedance() {
        return mImpedance;
    }

    /**
     * @return Weight - SI(Weight - Kilograms in xml)
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
     * @return Weight - Imperial(Weight - Pounds in xml)
     */
    public int getWeightImperial() {
        return mWeightImperial;
    }

    /**
     * @return Weight Mass(pounds)
     */
    public double getWeightImperialLb() {
        return WEIGHT_IMPERIAL_RESOLUTION * mWeightImperial;
    }

    /**
     * @return Height - SI(Height - Meters in xml)
     */
    public int getHeightSi() {
        return mHeightSi;
    }

    /**
     * @return Height(meters)
     */
    public double getWeightSiMeters() {
        return HEIGHT_SI_RESOLUTION * mHeightSi;
    }

    /**
     * @return Height - Imperial(Height - Inches in xml)
     */
    public int getHeightImperial() {
        return mHeightImperial;
    }

    /**
     * @return Height(Inches)
     */
    public double getHeightImperialInches() {
        return HEIGHT_IMPERIAL_RESOLUTION * mHeightImperial;
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
     *               , {@link #FLAG_BASAL_METABOLISM_PRESENT_FALSE}
     *               , {@link #FLAG_BASAL_METABOLISM_PRESENT_TRUE}
     *               , {@link #FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE}
     *               , {@link #FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE}
     *               , {@link #FLAG_MUSCLE_MASS_PRESENT_FALSE}
     *               , {@link #FLAG_MUSCLE_MASS_PRESENT_TRUE}
     *               , {@link #FLAG_FAT_FREE_MASS_PRESENT_FALSE}
     *               , {@link #FLAG_FAT_FREE_MASS_PRESENT_TRUE}
     *               , {@link #FLAG_SOFT_LEAN_MASS_PRESENT_FALSE}
     *               , {@link #FLAG_SOFT_LEAN_MASS_PRESENT_TRUE}
     *               , {@link #FLAG_BODY_WATER_MASS_PRESENT_FALSE}
     *               , {@link #FLAG_BODY_WATER_MASS_PRESENT_TRUE}
     *               , {@link #FLAG_IMPEDANCE_PRESENT_FALSE}
     *               , {@link #FLAG_IMPEDANCE_PRESENT_TRUE}
     *               , {@link #FLAG_WEIGHT_PRESENT_FALSE}
     *               , {@link #FLAG_WEIGHT_PRESENT_TRUE}
     *               , {@link #FLAG_HEIGHT_PRESENT_FALSE}
     *               , {@link #FLAG_HEIGHT_PRESENT_TRUE}
     *               , {@link #FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE}
     *               , {@link #FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE}
     * @param flags  current packet's flags
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect, byte[] flags) {
        return (mask & BLEUtils.createSInt16(flags, 0)) == expect;
    }

}
