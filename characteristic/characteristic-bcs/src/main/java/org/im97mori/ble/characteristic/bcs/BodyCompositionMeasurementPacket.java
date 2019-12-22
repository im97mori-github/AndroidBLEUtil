package org.im97mori.ble.characteristic.bcs;

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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.BASAL_METABOLISM_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.BODY_FAT_PERCENTAGE_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.BODY_WATER_MASS_IMPERIAL_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.BODY_WATER_MASS_SI_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FAT_FREE_MASS_IMPERIAL_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FAT_FREE_MASS_SI_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_MASK;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.HEIGHT_IMPERIAL_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.HEIGHT_SI_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.IMPEDANCE_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.MUSCLE_MASS_IMPERIAL_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.MUSCLE_MASS_SI_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.MUSCLE_PERCENTAGE_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.SOFT_LEAN_MASS_IMPERIAL_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.SOFT_LEAN_MASS_SI_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.WEIGHT_IMPERIAL_RESOLUTION;
import static org.im97mori.ble.characteristic.bcs.BodyCompositionMeasurement.WEIGHT_SI_RESOLUTION;

/**
 * Body Composition Measurement packet (Characteristics UUID: 0x2A9C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BodyCompositionMeasurementPacket implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BodyCompositionMeasurementPacket> CREATOR = new ByteArrayCreater<BodyCompositionMeasurementPacket>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementPacket createFromParcel(@NonNull Parcel in) {
            return new BodyCompositionMeasurementPacket(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementPacket[] newArray(int size) {
            return new BodyCompositionMeasurementPacket[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BodyCompositionMeasurementPacket createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
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
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9C
     */
    public BodyCompositionMeasurementPacket(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 4;
        mFlags = Arrays.copyOfRange(values, 0, 2);
        mBodyFatPercentage = BLEUtils.createUInt16(values, 2);

        if (isFlagsTimeStampPresent()) {
            mYear = BLEUtils.createUInt16(values, 4);
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

        if (isFlagsUserIdPresent()) {
            mUserId = (values[index++] & 0xff);
        } else {
            mUserId = 0;
        }

        if (isMeasurementUnsuccessful()) {
            mBasalMetabolism = 0;
            mMusclePercentage = 0;
            mMuscleMassSi = 0;
            mMuscleMassImperial = 0;
            mFatFreeMassSi = 0;
            mFatFreeMassImperial = 0;
            mSoftLeanMassSi = 0;
            mSoftLeanMassImperial = 0;
            mBodyWaterMassSi = 0;
            mBodyWaterMassImperial = 0;
            mImpedance = 0;
            mWeightSi = 0;
            mWeightImperial = 0;
            mHeightSi = 0;
            mHeightImperial = 0;
        } else {
            if (isFlagsBasalMetabolismPresent()) {
                mBasalMetabolism = BLEUtils.createUInt16(values, index);
                index += 2;
            } else {
                mBasalMetabolism = 0;
            }
            if (isFlagsMusclePercentagePresent()) {
                mMusclePercentage = BLEUtils.createUInt16(values, index);
                index += 2;
            } else {
                mMusclePercentage = 0;
            }
            if (isFlagsMuscleMassPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    mMuscleMassSi = BLEUtils.createUInt16(values, index);
                    mMuscleMassImperial = 0;
                } else {
                    mMuscleMassSi = 0;
                    mMuscleMassImperial = BLEUtils.createUInt16(values, index);
                }
                index += 2;
            } else {
                mMuscleMassSi = 0;
                mMuscleMassImperial = 0;
            }
            if (isFlagsFatFreeMassPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    mFatFreeMassSi = BLEUtils.createUInt16(values, index);
                    mFatFreeMassImperial = 0;
                } else {
                    mFatFreeMassSi = 0;
                    mFatFreeMassImperial = BLEUtils.createUInt16(values, index);
                }
                index += 2;
            } else {
                mFatFreeMassSi = 0;
                mFatFreeMassImperial = 0;
            }
            if (isFlagsSoftLeanMassPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    mSoftLeanMassSi = BLEUtils.createUInt16(values, index);
                    mSoftLeanMassImperial = 0;
                } else {
                    mSoftLeanMassSi = 0;
                    mSoftLeanMassImperial = BLEUtils.createUInt16(values, index);
                }
                index += 2;
            } else {
                mSoftLeanMassSi = 0;
                mSoftLeanMassImperial = 0;
            }
            if (isFlagsBodyWaterMassPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    mBodyWaterMassSi = BLEUtils.createUInt16(values, index);
                    mBodyWaterMassImperial = 0;
                } else {
                    mBodyWaterMassSi = 0;
                    mBodyWaterMassImperial = BLEUtils.createUInt16(values, index);
                }
                index += 2;
            } else {
                mBodyWaterMassSi = 0;
                mBodyWaterMassImperial = 0;
            }
            if (isFlagsImpedancePresent()) {
                mImpedance = BLEUtils.createUInt16(values, index);
                index += 2;
            } else {
                mImpedance = 0;
            }
            if (isFlagsWeightPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    mWeightSi = BLEUtils.createUInt16(values, index);
                    mWeightImperial = 0;
                } else {
                    mWeightSi = 0;
                    mWeightImperial = BLEUtils.createUInt16(values, index);
                }
                index += 2;
            } else {
                mWeightSi = 0;
                mWeightImperial = 0;
            }
            if (isFlagsHeightPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    mHeightSi = BLEUtils.createUInt16(values, index);
                    mHeightImperial = 0;
                } else {
                    mHeightSi = 0;
                    mHeightImperial = BLEUtils.createUInt16(values, index);
                }
            } else {
                mHeightSi = 0;
                mHeightImperial = 0;
            }
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BodyCompositionMeasurementPacket(@NonNull Parcel in) {
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
     * @return {@code true}:Basal Metabolism not present, {@code false}:Basal Metabolism present
     */
    public boolean isFlagsBasalMetabolismNotPresent() {
        return isFlagsMatched(FLAG_BASAL_METABOLISM_PRESENT_MASK, FLAG_BASAL_METABOLISM_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Basal Metabolism present, {@code false}:Basal Metabolism not present
     */
    public boolean isFlagsBasalMetabolismPresent() {
        return isFlagsMatched(FLAG_BASAL_METABOLISM_PRESENT_MASK, FLAG_BASAL_METABOLISM_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Muscle Percentage not present, {@code false}:Muscle Percentage present
     */
    public boolean isFlagsMusclePercentageNotPresent() {
        return isFlagsMatched(FLAG_MUSCLE_PERCENTAGE_PRESENT_MASK, FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Muscle Percentage present, {@code false}:Muscle Percentage not present
     */
    public boolean isFlagsMusclePercentagePresent() {
        return isFlagsMatched(FLAG_MUSCLE_PERCENTAGE_PRESENT_MASK, FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Muscle Mass not present, {@code false}:Muscle Mass present
     */
    public boolean isFlagsMuscleMassNotPresent() {
        return isFlagsMatched(FLAG_MUSCLE_MASS_PRESENT_MASK, FLAG_MUSCLE_MASS_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Muscle Mass present, {@code false}:Muscle Mass not present
     */
    public boolean isFlagsMuscleMassPresent() {
        return isFlagsMatched(FLAG_MUSCLE_MASS_PRESENT_MASK, FLAG_MUSCLE_MASS_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Fat Free Mass not present, {@code false}:Fat Free Mass present
     */
    public boolean isFlagsFatFreeMassNotPresent() {
        return isFlagsMatched(FLAG_FAT_FREE_MASS_PRESENT_MASK, FLAG_FAT_FREE_MASS_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Fat Free Mass present, {@code false}:Fat Free Mass not present
     */
    public boolean isFlagsFatFreeMassPresent() {
        return isFlagsMatched(FLAG_FAT_FREE_MASS_PRESENT_MASK, FLAG_FAT_FREE_MASS_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Soft Lean Mass not present, {@code false}Soft Lean Mass present
     */
    public boolean isFlagsSoftLeanMassNotPresent() {
        return isFlagsMatched(FLAG_SOFT_LEAN_MASS_PRESENT_MASK, FLAG_SOFT_LEAN_MASS_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Soft Lean Mass present, {@code false}:Soft Lean Mass not present
     */
    public boolean isFlagsSoftLeanMassPresent() {
        return isFlagsMatched(FLAG_SOFT_LEAN_MASS_PRESENT_MASK, FLAG_SOFT_LEAN_MASS_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Body Water Mass not present, {@code false}:Body Water Mass present
     */
    public boolean isFlagsBodyWaterMassNotPresent() {
        return isFlagsMatched(FLAG_BODY_WATER_MASS_PRESENT_MASK, FLAG_BODY_WATER_MASS_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Body Water Mass present, {@code false}:Body Water Mass not present
     */
    public boolean isFlagsBodyWaterMassPresent() {
        return isFlagsMatched(FLAG_BODY_WATER_MASS_PRESENT_MASK, FLAG_BODY_WATER_MASS_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Impedance not present, {@code false}:Impedance present
     */
    public boolean isFlagsImpedanceNotPresent() {
        return isFlagsMatched(FLAG_IMPEDANCE_PRESENT_MASK, FLAG_IMPEDANCE_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Impedance present, {@code false}:Impedance not present
     */
    public boolean isFlagsImpedancePresent() {
        return isFlagsMatched(FLAG_IMPEDANCE_PRESENT_MASK, FLAG_IMPEDANCE_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Weight not present, {@code false}:Weight present
     */
    public boolean isFlagsWeightNotPresent() {
        return isFlagsMatched(FLAG_WEIGHT_PRESENT_MASK, FLAG_WEIGHT_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Weight present, {@code false}:Weight not present
     */
    public boolean isFlagsWeightPresent() {
        return isFlagsMatched(FLAG_WEIGHT_PRESENT_MASK, FLAG_WEIGHT_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:Height not present, {@code false}:Height present
     */
    public boolean isFlagsHeightNotPresent() {
        return isFlagsMatched(FLAG_HEIGHT_PRESENT_MASK, FLAG_HEIGHT_PRESENT_FALSE);
    }

    /**
     * @return {@code true}:Height present, {@code false}:Height not present
     */
    public boolean isFlagsHeightPresent() {
        return isFlagsMatched(FLAG_HEIGHT_PRESENT_MASK, FLAG_HEIGHT_PRESENT_TRUE);
    }

    /**
     * @return {@code true}:not Multiple Packet Measurement, {@code false}:Multiple Packet Measurement
     */
    public boolean isFlagsNotMultiplePacketMeasurement() {
        return isFlagsMatched(FLAG_MULTIPLE_PACKET_MEASUREMENT_MASK, FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE);
    }

    /**
     * @return {@code true}:Multiple Packet Measurement, {@code false}:not Multiple Packet Measurement
     */
    public boolean isFlagsMultiplePacketMeasurement() {
        return isFlagsMatched(FLAG_MULTIPLE_PACKET_MEASUREMENT_MASK, FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE);
    }

    /**
     * @return Body Fat Percentage
     */
    public int getBodyFatPercentage() {
        return mBodyFatPercentage;
    }

    /**
     * @return {@code true}:Measurement Successful, {@code false}: Measurement Unsuccessful
     */
    public boolean isMeasurementSuccessful() {
        return MEASUREMENT_UNSUCCESSFUL != mBodyFatPercentage;
    }

    /**
     * @return {@code true}:Measurement Unsuccessful, {@code false}: Measurement Successful
     */
    public boolean isMeasurementUnsuccessful() {
        return MEASUREMENT_UNSUCCESSFUL == mBodyFatPercentage;
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
     * @return Impedance(Ohms)
     */
    public double getImpedanceOhms() {
        return IMPEDANCE_RESOLUTION * mImpedance;
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
    public double getHeightSiMeters() {
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
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 0;
        byte[] data = new byte[30];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFlags);
        length += 2;
        byteBuffer.putShort((short) mBodyFatPercentage);
        length += 2;
        if (isFlagsTimeStampPresent()) {
            byteBuffer.putShort((short) mYear);
            byteBuffer.put((byte) mMonth);
            byteBuffer.put((byte) mDay);
            byteBuffer.put((byte) mHours);
            byteBuffer.put((byte) mMinutes);
            byteBuffer.put((byte) mSeconds);
            length += 7;
        }
        if (isFlagsUserIdPresent()) {
            byteBuffer.put((byte) mUserId);
            length++;
        }
        if (!isMeasurementUnsuccessful()) {
            if (isFlagsBasalMetabolismPresent()) {
                byteBuffer.putShort((short) mBasalMetabolism);
                length += 2;
            }
            if (isFlagsMusclePercentagePresent()) {
                byteBuffer.putShort((short) mMusclePercentage);
                length += 2;
            }
            if (isFlagsMuscleMassPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    byteBuffer.putShort((short) mMuscleMassSi);
                } else {
                    byteBuffer.putShort((short) mMuscleMassImperial);
                }
                length += 2;
            }
            if (isFlagsFatFreeMassPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    byteBuffer.putShort((short) mFatFreeMassSi);
                } else {
                    byteBuffer.putShort((short) mFatFreeMassImperial);
                }
                length += 2;
            }
            if (isFlagsSoftLeanMassPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    byteBuffer.putShort((short) mSoftLeanMassSi);
                } else {
                    byteBuffer.putShort((short) mSoftLeanMassImperial);
                }
                length += 2;
            }
            if (isFlagsBodyWaterMassPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    byteBuffer.putShort((short) mBodyWaterMassSi);
                } else {
                    byteBuffer.putShort((short) mBodyWaterMassImperial);
                }
                length += 2;
            }
            if (isFlagsImpedancePresent()) {
                byteBuffer.putShort((short) mImpedance);
                length += 2;
            }
            if (isFlagsWeightPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    byteBuffer.putShort((short) mWeightSi);
                } else {
                    byteBuffer.putShort((short) mWeightImperial);
                }
                length += 2;
            }
            if (isFlagsHeightPresent()) {
                if (isFlagsMeasurementUnitSI()) {
                    byteBuffer.putShort((short) mHeightSi);
                } else {
                    byteBuffer.putShort((short) mHeightImperial);
                }
                length += 2;
            }
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link BodyCompositionMeasurement#FLAG_MEASUREMENT_UNITS_SI}
     *               , {@link BodyCompositionMeasurement#FLAG_MEASUREMENT_UNITS_IMPERIAL}
     *               , {@link BodyCompositionMeasurement#FLAG_TIME_STAMP_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_TIME_STAMP_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_USER_ID_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_USER_ID_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_BASAL_METABOLISM_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_BASAL_METABOLISM_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_MUSCLE_MASS_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_MUSCLE_MASS_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_FAT_FREE_MASS_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_FAT_FREE_MASS_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_SOFT_LEAN_MASS_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_SOFT_LEAN_MASS_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_BODY_WATER_MASS_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_BODY_WATER_MASS_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_IMPEDANCE_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_IMPEDANCE_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_WEIGHT_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_WEIGHT_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_HEIGHT_PRESENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_HEIGHT_PRESENT_TRUE}
     *               , {@link BodyCompositionMeasurement#FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE}
     *               , {@link BodyCompositionMeasurement#FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt16(mFlags, 0)) == expect;
    }

}
