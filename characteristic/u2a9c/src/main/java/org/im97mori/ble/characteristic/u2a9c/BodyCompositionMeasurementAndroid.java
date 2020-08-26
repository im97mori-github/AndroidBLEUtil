package org.im97mori.ble.characteristic.u2a9c;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Body Composition Measurement (Characteristics UUID: 0x2A9C)
 */
@SuppressWarnings({"WeakerAccess"})
public class BodyCompositionMeasurementAndroid extends BodyCompositionMeasurement implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<BodyCompositionMeasurementAndroid, BodyCompositionMeasurementPacketAndroid> CREATOR = new MultiplePacketCreater<BodyCompositionMeasurementAndroid, BodyCompositionMeasurementPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new BodyCompositionMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementAndroid[] newArray(int size) {
            return new BodyCompositionMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BodyCompositionMeasurementAndroid createFromMultiplePacketArray(@NonNull BodyCompositionMeasurementPacketAndroid[] multiplePacketArray) {
            return new BodyCompositionMeasurementAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link BodyCompositionMeasurementPacket} array
     *
     * @param bodyCompositionMeasurementPackets 1 or 2 Body Composition Measurement packet array
     */
    public BodyCompositionMeasurementAndroid(@NonNull BodyCompositionMeasurementPacketAndroid[] bodyCompositionMeasurementPackets) {
        super(bodyCompositionMeasurementPackets);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                Flags
     * @param bodyFatPercentage    Body Fat Percentage
     * @param year                 Year
     * @param month                Month
     * @param day                  Day
     * @param hours                Hours
     * @param minutes              Minutes
     * @param seconds              Seconds
     * @param userId               User ID
     * @param basalMetabolism      Basal Metabolism
     * @param musclePercentage     Muscle Percentage
     * @param muscleMassSi         Muscle Mass - SI(Muscle Mass - Kilograms in xml)
     * @param muscleMassImperial   Muscle Mass - SI(Muscle Mass - Kilograms in xml)
     * @param fatFreeMassSi        Fat Free Mass - SI(Fat Free Mass - Kilograms in xml)
     * @param fatFreeMassImperial  Fat Free Mass - Imperial(Fat Free Mass - Pounds in xml)
     * @param softLeanMassSi       Soft Lean Mass - SI(Soft Lean Mass - Kilograms in xml)
     * @param softLeanMassImperial Soft Lean Mass - Imperial(Soft Lean Mass - Pounds in xml)
     * @param bodyWaterSi          Body Water Mass - SI(Body Water Mass - Kilograms in xml)
     * @param bodyWaterImperial    Body Water Mass - Imperial(Body Water Mass - Pounds in xml)
     * @param impedance            Impedance
     * @param weightSi             Weight - SI(Weight - Kilograms in xml)
     * @param weightImperial       Weight - Imperial(Weight - Pounds in xml)
     * @param heightSi             Height - SI(Height - Meters in xml)
     * @param heightImperial       Height - Imperial(Height - Inches in xml)
     */
    public BodyCompositionMeasurementAndroid(@NonNull byte[] flags, int bodyFatPercentage, int year, int month, int day, int hours, int minutes, int seconds, int userId, int basalMetabolism, int musclePercentage, int muscleMassSi, int muscleMassImperial, int fatFreeMassSi, int fatFreeMassImperial, int softLeanMassSi, int softLeanMassImperial, int bodyWaterSi, int bodyWaterImperial, int impedance, int weightSi, int weightImperial, int heightSi, int heightImperial) {
        super(flags, bodyFatPercentage, year, month, day, hours, minutes, seconds, userId, basalMetabolism, musclePercentage, muscleMassSi, muscleMassImperial, fatFreeMassSi, fatFreeMassImperial, softLeanMassSi, softLeanMassImperial, bodyWaterSi, bodyWaterImperial, impedance, weightSi, weightImperial, heightSi, heightImperial);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private BodyCompositionMeasurementAndroid(@NonNull Parcel in) {
        super(new BodyCompositionMeasurementPacketAndroid[]{BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
