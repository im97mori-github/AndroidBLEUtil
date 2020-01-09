package org.im97mori.ble.characteristic.ftms;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;

@SuppressWarnings("WeakerAccess")
public class TreadmillDataUtils {

    /**
     * @see #FLAGS_MORE_DATA_FALSE
     * @see #FLAGS_MORE_DATA_TRUE
     */
    public static final int FLAGS_MORE_DATA_MASK = 0b00000000_00000001;

    /**
     * 0: More Data False
     */
    public static final int FLAGS_MORE_DATA_FALSE = 0b00000000_00000000;

    /**
     * 1: More Data True
     */
    public static final int FLAGS_MORE_DATA_TRUE = 0b00000000_00000001;

    /**
     * @see #FLAGS_AVERAGE_SPEED_PRESENT_FALSE
     * @see #FLAGS_AVERAGE_SPEED_PRESENT_TRUE
     */
    public static final int FLAGS_AVERAGE_SPEED_PRESENT_MASK = 0b00000000_00000010;

    /**
     * 0: Average Speed present False
     */
    public static final int FLAGS_AVERAGE_SPEED_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Average Speed present True
     */
    public static final int FLAGS_AVERAGE_SPEED_PRESENT_TRUE = 0b00000000_00000010;

    /**
     * @see #FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
     * @see #FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_MASK = 0b00000000_00000100;

    /**
     * 0: Total Distance Present False
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Total Distance Present True
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_TRUE = 0b00000000_00000100;

    /**
     * @see #FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
     * @see #FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
     */
    public static final int FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_MASK = 0b00000000_00001000;

    /**
     * 0: Inclination and Ramp Angle Setting present False
     */
    public static final int FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Inclination and Ramp Angle Setting present True
     */
    public static final int FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE = 0b00000000_00001000;

    /**
     * @see #FLAGS_ELEVATION_GAIN_PRESENT_FALSE
     * @see #FLAGS_ELEVATION_GAIN_PRESENT_TRUE
     */
    public static final int FLAGS_ELEVATION_GAIN_PRESENT_MASK = 0b00000000_00010000;

    /**
     * 0: Elevation Gain present False
     */
    public static final int FLAGS_ELEVATION_GAIN_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Elevation Gain present True
     */
    public static final int FLAGS_ELEVATION_GAIN_PRESENT_TRUE = 0b00000000_00010000;

    /**
     * @see #FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE
     * @see #FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
     */
    public static final int FLAGS_INSTANTANEOUS_PACE_PRESENT_MASK = 0b00000000_00100000;

    /**
     * 0: Instantaneous Pace present False
     */
    public static final int FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Instantaneous Pace present True
     */
    public static final int FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE = 0b00000000_00100000;

    /**
     * @see #FLAGS_AVERAGE_PACE_PRESENT_FALSE
     * @see #FLAGS_AVERAGE_PACE_PRESENT_TRUE
     */
    public static final int FLAGS_AVERAGE_PACE_PRESENT_MASK = 0b00000000_01000000;

    /**
     * 0: Average Pace present False
     */
    public static final int FLAGS_AVERAGE_PACE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Average Pace present True
     */
    public static final int FLAGS_AVERAGE_PACE_PRESENT_TRUE = 0b00000000_01000000;

    /**
     * @see #FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
     * @see #FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_MASK = 0b00000000_10000000;

    /**
     * 0: Expended Energy present False
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Expended Energy present True
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_TRUE = 0b00000000_10000000;

    /**
     * @see #FLAGS_HEART_RATE_PRESENT_FALSE
     * @see #FLAGS_HEART_RATE_PRESENT_TRUE
     */
    public static final int FLAGS_HEART_RATE_PRESENT_MASK = 0b00000001_00000000;

    /**
     * 0: Heart Rate present False
     */
    public static final int FLAGS_HEART_RATE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Heart Rate present True
     */
    public static final int FLAGS_HEART_RATE_PRESENT_TRUE = 0b00000001_00000000;

    /**
     * @see #FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
     * @see #FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_MASK = 0b00000010_00000000;

    /**
     * 0: Metabolic Equivalent present False
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Metabolic Equivalent present True
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE = 0b00000010_00000000;

    /**
     * @see #FLAGS_ELAPSED_TIME_PRESENT_FALSE
     * @see #FLAGS_ELAPSED_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_MASK = 0b00000100_00000000;

    /**
     * 0: Elapsed Time present False
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Elapsed Time present True
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_TRUE = 0b00000100_00000000;

    /**
     * @see #FLAGS_REMAINING_TIME_PRESENT_FALSE
     * @see #FLAGS_REMAINING_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_MASK = 0b00001000_00000000;

    /**
     * 0: Remaining Time present False
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Remaining Time present True
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_TRUE = 0b00001000_00000000;

    /**
     * @see #FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE
     * @see #FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE
     */
    public static final int FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_MASK = 0b00010000_00000000;

    /**
     * 0: Force on Belt and Power Output present False
     */
    public static final int FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Force on Belt and Power Output present True
     */
    public static final int FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE = 0b00010000_00000000;

    /**
     * Inclination Data Not Available
     */
    public static final int INCLINATION_DATA_NOT_AVAILABLE = 0x7FFF;

    /**
     * Ramp Angle Setting Data Not Available
     */
    public static final int RAMP_ANGLE_SETTING_DATA_NOT_AVAILABLE = 0x7FFF;

    /**
     * Total Energy Data Not Available
     */
    public static final int TOTAL_ENERGY_DATA_NOT_AVAILABLE = 0xFFFF;

    /**
     * Energy per Hour Data Not Available
     */
    public static final int ENERGY_PER_HOUR_DATA_NOT_AVAILABLE = 0xFFFF;

    /**
     * Energy per Minute Data Not Available
     */
    public static final int ENERGY_PER_MINUTE_DATA_NOT_AVAILABLE = 0xFF;

    /**
     * Force on Belt Data Not Available
     */
    public static final int FORCE_ON_BELT_DATA_NOT_AVAILABLE = 0x7FFF;

    /**
     * Power Output Data Not Available
     */
    public static final int POWER_OUTPUT_DATA_NOT_AVAILABLE = 0x7FFF;

    /**
     * Instantaneous Speed Unit 0.01 Kilometer per hour
     */
    public static final double INSTANTANEOUS_SPEED_RESOLUTION = 0.01d;

    /**
     * Average Speed Unit 0.01 Kilometer per hour
     */
    public static final double AVERAGE_SPEED_RESOLUTION = 0.01d;

    /**
     * Inclination Unit 0.1 Percent
     */
    public static final double INCLINATION_RESOLUTION = 0.1d;

    /**
     * Ramp Angle Setting Unit 0.1 Degree
     */
    public static final double RAMP_ANGLE_SETTING_RESOLUTION = 0.1d;

    /**
     * Positive Elevation Gain Unit 0.1 Meters
     */
    public static final double POSITIVE_ELEVATION_GAIN_RESOLUTION = 0.1d;

    /**
     * Negative Elevation Gain Unit 0.1 Meters
     */
    public static final double NEGATIVE_ELEVATION_GAIN_RESOLUTION = 0.1d;

    /**
     * Instantaneous Pace Unit 0.1 Kilometer per minute
     */
    public static final double INSTANTANEOUS_PACE_RESOLUTION = 0.1d;

    /**
     * Average Pace Unit 0.1 Kilometer per minute
     */
    public static final double AVERAGE_PACE_RESOLUTION = 0.1d;

    /**
     * @param flags flags
     * @return {@code true}:More Data is False, {@code false}:More Data is True
     */
    public static boolean isFlagsMoreDataFalse(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_MORE_DATA_MASK, FLAGS_MORE_DATA_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:More Data is True, {@code false}:More Data is False
     */
    public static boolean isFlagsMoreDataTrue(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_MORE_DATA_MASK, FLAGS_MORE_DATA_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Speed not present, {@code false}:Average Speed present
     */
    public static boolean isFlagsAverageSpeedNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_SPEED_PRESENT_MASK, FLAGS_AVERAGE_SPEED_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Speed present, {@code false}:Average Speed not present
     */
    public static boolean isFlagsAverageSpeedPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_SPEED_PRESENT_MASK, FLAGS_AVERAGE_SPEED_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Total Distance not Present, {@code false}:Total Distance Present
     */
    public static boolean isFlagsTotalDistanceNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_TOTAL_DISTANCE_PRESENT_MASK, FLAGS_TOTAL_DISTANCE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Total Distance Present, {@code false}:Total Distance not Present
     */
    public static boolean isFlagsTotalDistancePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_TOTAL_DISTANCE_PRESENT_MASK, FLAGS_TOTAL_DISTANCE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Inclination and Ramp Angle Setting not present, {@code false}:Inclination and Ramp Angle Setting present
     */
    public static boolean isFlagsInclinationAndRampAngleSettingNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_MASK, FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Inclination and Ramp Angle Setting present, {@code false}:Inclination and Ramp Angle Setting not present
     */
    public static boolean isFlagsInclinationAndRampAngleSettingPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_MASK, FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Elevation Gain not present, {@code false}:Elevation Gain present
     */
    public static boolean isFlagsElevationGainNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_ELEVATION_GAIN_PRESENT_MASK, FLAGS_ELEVATION_GAIN_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Elevation Gain present, {@code false}:Elevation Gain not present
     */
    public static boolean isFlagsElevationGainPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_ELEVATION_GAIN_PRESENT_MASK, FLAGS_ELEVATION_GAIN_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Instantaneous Pace not present, {@code false}:Instantaneous Pace present
     */
    public static boolean isFlagsInstantaneousPaceNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_PACE_PRESENT_MASK, FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Instantaneous Pace present, {@code false}:Instantaneous Pace not present
     */
    public static boolean isFlagsInstantaneousPacePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_PACE_PRESENT_MASK, FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Pace not present, {@code false}:Average Pace present
     */
    public static boolean isFlagsAveragePaceNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_PACE_PRESENT_MASK, FLAGS_AVERAGE_PACE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Pace present, {@code false}:Average Pace not present
     */
    public static boolean isFlagsAveragePacePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_PACE_PRESENT_MASK, FLAGS_AVERAGE_PACE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Expended Energy not present, {@code false}:Expended Energy present
     */
    public static boolean isFlagsExpendedEnergyNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_EXPANDED_ENERGY_PRESENT_MASK, FLAGS_EXPANDED_ENERGY_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Expended Energy present, {@code false}:Expended Energy not present
     */
    public static boolean isFlagsExpendedEnergyPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_EXPANDED_ENERGY_PRESENT_MASK, FLAGS_EXPANDED_ENERGY_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Heart Rate not present, {@code false}:Heart Rate present
     */
    public static boolean isFlagsHeartRateNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_HEART_RATE_PRESENT_MASK, FLAGS_HEART_RATE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Heart Rate present, {@code false}:Heart Rate not present
     */
    public static boolean isFlagsHeartRatePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_HEART_RATE_PRESENT_MASK, FLAGS_HEART_RATE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Metabolic Equivalent not present, {@code false}:Metabolic Equivalent present
     */
    public static boolean isFlagsMetabolicEquivalentNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_METABOLIC_EQUIVALENT_PRESENT_MASK, FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Metabolic Equivalent present, {@code false}:Metabolic Equivalent not present
     */
    public static boolean isFlagsMetabolicEquivalentPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_METABOLIC_EQUIVALENT_PRESENT_MASK, FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Elapsed Time not present, {@code false}:Elapsed Time present
     */
    public static boolean isFlagsElapsedTimeNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_ELAPSED_TIME_PRESENT_MASK, FLAGS_ELAPSED_TIME_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Elapsed Time present, {@code false}:Elapsed Time not present
     */
    public static boolean isFlagsElapsedTimePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_ELAPSED_TIME_PRESENT_MASK, FLAGS_ELAPSED_TIME_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Remaining Time not present, {@code false}:Remaining Time present
     */
    public static boolean isFlagsRemainingTimeNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_REMAINING_TIME_PRESENT_MASK, FLAGS_REMAINING_TIME_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Remaining Time present, {@code false}:Remaining Time not present
     */
    public static boolean isFlagsRemainingTimePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_REMAINING_TIME_PRESENT_MASK, FLAGS_REMAINING_TIME_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Force on Belt and Power Output not present {@code false}:Force on Belt and Power Output present
     */
    public static boolean isFlagsForceOnBeltAndPowerOutputNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_MASK, FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Force on Belt and Power Output present, {@code false}:Force on Belt and Power Output not present
     */
    public static boolean isFlagsForceOnBeltAndPowerOutputPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_MASK, FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE, flags);
    }

    /**
     * @param inclination Inclination
     * @return {@code true}:Inclination Data Not Available, {@code false}:Inclination Data Available
     */
    public static boolean isInclinationDataNotAvailable(int inclination) {
        return INCLINATION_DATA_NOT_AVAILABLE == inclination;
    }

    /**
     * @param rampAngleSetting Ramp Angle Setting
     * @return {@code true}:Ramp Angle Setting Data Not Available, {@code false}:Ramp Angle Setting Data Available
     */
    public static boolean isRampAngleSettingDataNotAvailable(int rampAngleSetting) {
        return RAMP_ANGLE_SETTING_DATA_NOT_AVAILABLE == rampAngleSetting;
    }

    /**
     * @param totalEnergy Total Energy
     * @return {@code true}:Total Energy Data Not Available, {@code false}:Total Energy Data Available
     */
    public static boolean isTotalEnergyDataNotAvailable(int totalEnergy) {
        return TOTAL_ENERGY_DATA_NOT_AVAILABLE == totalEnergy;
    }

    /**
     * @param energyPerHour Energy per Hour
     * @return {@code true}:Energy per Hour Data Not Available, {@code false}:Energy per Hour Data Data Available
     */
    public static boolean isEnergyPerHourDataNotAvailable(int energyPerHour) {
        return ENERGY_PER_HOUR_DATA_NOT_AVAILABLE == energyPerHour;
    }

    /**
     * @param energyPerMinute Energy per Minute
     * @return {@code true}:Energy per Minute Data Not Available, {@code false}:Energy per Minute Data Data Available
     */
    public static boolean isEnergyPerMinuteDataNotAvailable(int energyPerMinute) {
        return ENERGY_PER_MINUTE_DATA_NOT_AVAILABLE == energyPerMinute;
    }

    /**
     * @param forceOnBelt Force on Belt
     * @return {@code true}:Force on Belt Data Not Available, {@code false}:Force on Belt Data Data Available
     */
    public static boolean isForceOnBeltDataNotAvailable(int forceOnBelt) {
        return FORCE_ON_BELT_DATA_NOT_AVAILABLE == forceOnBelt;
    }

    /**
     * @param powerOutput Power Output
     * @return {@code true}:Power Output Data Not Available, {@code false}:Power Output Data Data Available
     */
    public static boolean isPowerOutputDataNotAvailable(int powerOutput) {
        return POWER_OUTPUT_DATA_NOT_AVAILABLE == powerOutput;
    }

    /**
     * @param instantaneousSpeed Instantaneous Speed
     * @return Instantaneous Speed(Kilometer per hour)
     */
    public static double getInstantaneousSpeedKilometerPerHour(int instantaneousSpeed) {
        return INSTANTANEOUS_SPEED_RESOLUTION * instantaneousSpeed;
    }

    /**
     * @param averageSpeed Average Speed
     * @return Average Speed(Kilometer per hour)
     */
    public static double getAverageSpeedKilometerPerHour(int averageSpeed) {
        return AVERAGE_SPEED_RESOLUTION * averageSpeed;
    }

    /**
     * @param inclination Inclination
     * @return Inclination(Percent)
     */
    public static double getInclinationPercent(int inclination) {
        return INCLINATION_RESOLUTION * inclination;
    }

    /**
     * @param rampAngleSetting Ramp Angle Setting
     * @return Ramp Angle Setting(Degree)
     */
    public static double getRampAngleSettingDegree(int rampAngleSetting) {
        return RAMP_ANGLE_SETTING_RESOLUTION * rampAngleSetting;
    }

    /**
     * @param positiveElevationGain Positive Elevation Gain
     * @return Positive Elevation Gain(Meters)
     */
    public static double getPositiveElevationGainMeters(int positiveElevationGain) {
        return POSITIVE_ELEVATION_GAIN_RESOLUTION * positiveElevationGain;
    }

    /**
     * @param negativeElevationGain Negative Elevation Gain
     * @return Negative Elevation Gain(Meters)
     */
    public static double getNegativeElevationGainMeters(int negativeElevationGain) {
        return NEGATIVE_ELEVATION_GAIN_RESOLUTION * negativeElevationGain;
    }

    /**
     * @param instantaneousPace Instantaneous Pace
     * @return Instantaneous Pace(Kilometer per minute)
     */
    public static double getInstantaneousPaceKilometerPerMinute(int instantaneousPace) {
        return INSTANTANEOUS_PACE_RESOLUTION * instantaneousPace;
    }

    /**
     * @param averagePace Average Pace
     * @return Average Pace(Kilometer per minute)
     */
    public static double getAveragePaceKilometerPerMinute(int averagePace) {
        return AVERAGE_PACE_RESOLUTION * averagePace;
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAGS_MORE_DATA_FALSE}
     *               , {@link #FLAGS_MORE_DATA_TRUE}
     *               , {@link #FLAGS_AVERAGE_SPEED_PRESENT_FALSE}
     *               , {@link #FLAGS_AVERAGE_SPEED_PRESENT_TRUE}
     *               , {@link #FLAGS_TOTAL_DISTANCE_PRESENT_FALSE}
     *               , {@link #FLAGS_TOTAL_DISTANCE_PRESENT_TRUE}
     *               , {@link #FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE}
     *               , {@link #FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE}
     *               , {@link #FLAGS_ELEVATION_GAIN_PRESENT_FALSE}
     *               , {@link #FLAGS_ELEVATION_GAIN_PRESENT_TRUE}
     *               , {@link #FLAGS_INSTANTANEOUS_PACE_PRESENT_FALSE}
     *               , {@link #FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE}
     *               , {@link #FLAGS_AVERAGE_PACE_PRESENT_FALSE}
     *               , {@link #FLAGS_AVERAGE_PACE_PRESENT_TRUE}
     *               , {@link #FLAGS_EXPANDED_ENERGY_PRESENT_FALSE}
     *               , {@link #FLAGS_EXPANDED_ENERGY_PRESENT_TRUE}
     *               , {@link #FLAGS_HEART_RATE_PRESENT_FALSE}
     *               , {@link #FLAGS_HEART_RATE_PRESENT_TRUE}
     *               , {@link #FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE}
     *               , {@link #FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE}
     *               , {@link #FLAGS_ELAPSED_TIME_PRESENT_FALSE}
     *               , {@link #FLAGS_ELAPSED_TIME_PRESENT_TRUE}
     *               , {@link #FLAGS_REMAINING_TIME_PRESENT_FALSE}
     *               , {@link #FLAGS_REMAINING_TIME_PRESENT_TRUE}
     *               , {@link #FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_FALSE}
     *               , {@link #FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE}
     * @param flags  current packet's flags
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private static boolean isFlagsMatched(int mask, int expect, byte[] flags) {
        return (mask & BLEUtils.createSInt16(flags, 0)) == expect;
    }

}
