package org.im97mori.ble.characteristic.ftms;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;

@SuppressWarnings("WeakerAccess")
public class IndoorBikeDataUtils {

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
     * @see #FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE
     * @see #FLAGS_INSTANTANEOUS_CADENCE_PRESENT_TRUE
     */
    public static final int FLAGS_INSTANTANEOUS_CADENCE_PRESENT_MASK = 0b00000000_00000100;

    /**
     * 0: Instantaneous Cadence present False
     */
    public static final int FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Instantaneous Cadence present True
     */
    public static final int FLAGS_INSTANTANEOUS_CADENCE_PRESENT_TRUE = 0b00000000_00000100;

    /**
     * @see #FLAGS_AVERAGE_CADENCE_PRESENT_FALSE
     * @see #FLAGS_AVERAGE_CADENCE_PRESENT_TRUE
     */
    public static final int FLAGS_AVERAGE_CADENCE_PRESENT_MASK = 0b00000000_00001000;

    /**
     * 0: Average Candence present False
     */
    public static final int FLAGS_AVERAGE_CADENCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Average Candence present True
     */
    public static final int FLAGS_AVERAGE_CADENCE_PRESENT_TRUE = 0b00000000_00001000;

    /**
     * @see #FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
     * @see #FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_MASK = 0b00000000_00010000;

    /**
     * 0: Total Distance Present False
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Total Distance Present True
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_TRUE = 0b00000000_00010000;

    /**
     * @see #FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE
     * @see #FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE
     */
    public static final int FLAGS_RESISTANCE_LEVEL_PRESENT_MASK = 0b00000000_00100000;

    /**
     * 0: Resistance Level present False
     */
    public static final int FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Resistance Level present True
     */
    public static final int FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE = 0b00000000_00100000;

    /**
     * @see #FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
     * @see #FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
     */
    public static final int FLAGS_INSTANTANEOUS_POWER_PRESENT_MASK = 0b00000000_01000000;

    /**
     * 0: Instantaneous Power present False
     */
    public static final int FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Instantaneous Power present True
     */
    public static final int FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE = 0b00000000_01000000;

    /**
     * @see #FLAGS_AVERAGE_POWER_PRESENT_FALSE
     * @see #FLAGS_AVERAGE_POWER_PRESENT_TRUE
     */
    public static final int FLAGS_AVERAGE_POWER_PRESENT_MASK = 0b00000000_10000000;

    /**
     * 0: Average Power present False
     */
    public static final int FLAGS_AVERAGE_POWER_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Average Power present True
     */
    public static final int FLAGS_AVERAGE_POWER_PRESENT_TRUE = 0b00000000_10000000;

    /**
     * @see #FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
     * @see #FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_MASK = 0b00000001_00000000;

    /**
     * 0: Expended Energy present False
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Expended Energy present True
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_TRUE = 0b00000001_00000000;

    /**
     * @see #FLAGS_HEART_RATE_PRESENT_FALSE
     * @see #FLAGS_HEART_RATE_PRESENT_TRUE
     */
    public static final int FLAGS_HEART_RATE_PRESENT_MASK = 0b00000010_00000000;

    /**
     * 0: Heart Rate present False
     */
    public static final int FLAGS_HEART_RATE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Heart Rate present True
     */
    public static final int FLAGS_HEART_RATE_PRESENT_TRUE = 0b00000010_00000000;

    /**
     * @see #FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
     * @see #FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_MASK = 0b00000100_00000000;

    /**
     * 0: Metabolic Equivalent present False
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Metabolic Equivalent present True
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE = 0b00000100_00000000;

    /**
     * @see #FLAGS_ELAPSED_TIME_PRESENT_FALSE
     * @see #FLAGS_ELAPSED_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_MASK = 0b00001000_00000000;

    /**
     * 0: Elapsed Time present False
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Elapsed Time present True
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_TRUE = 0b00001000_00000000;

    /**
     * @see #FLAGS_REMAINING_TIME_PRESENT_FALSE
     * @see #FLAGS_REMAINING_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_MASK = 0b00010000_00000000;

    /**
     * 0: Remaining Time present False
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Remaining Time present True
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_TRUE = 0b00010000_00000000;

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
     * Instantaneous Speed Unit 0.01 Kilometer per hour
     */
    public static final double INSTANTANEOUS_SPEED_RESOLUTION = 0.01d;

    /**
     * Average Speed Unit 0.01 Kilometer per hour
     */
    public static final double AVERAGE_SPEED_RESOLUTION = 0.01d;

    /**
     * Instantaneous Cadence Unit 1/minute
     */
    public static final double INSTANTANEOUS_CADENCE_RESOLUTION = 0.5d;

    /**
     * Average Cadence Unit 1/minute
     */
    public static final double AVERAGE_CADENCE_RESOLUTION = 0.5d;

    /**
     * Metabolic Equivalent Unit 0.1
     */
    public static final double METABOLIC_EQUIVALENT_RESOLUTION = 0.1d;

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
     * @return {@code true}:Instantaneous Cadence not present, {@code false}:Instantaneous Cadence present
     */
    public static boolean isFlagsInstantaneousCadenceNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_CADENCE_PRESENT_MASK, FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Instantaneous Cadence present, {@code false}:Instantaneous Cadence not present
     */
    public static boolean isFlagsInstantaneousCadencePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_CADENCE_PRESENT_MASK, FLAGS_INSTANTANEOUS_CADENCE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Candence not present, {@code false}:Average Candence present
     */
    public static boolean isFlagsAverageCandenceNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_CADENCE_PRESENT_MASK, FLAGS_AVERAGE_CADENCE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Candence present, {@code false}:Average Candence not present
     */
    public static boolean isFlagsAverageCandencePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_CADENCE_PRESENT_MASK, FLAGS_AVERAGE_CADENCE_PRESENT_TRUE, flags);
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
     * @return {@code true}:Total Distance Present {@code false}:Total Distance not Present
     */
    public static boolean isFlagsTotalDistancePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_TOTAL_DISTANCE_PRESENT_MASK, FLAGS_TOTAL_DISTANCE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Resistance Level not present, {@code false}:Resistance Level present
     */
    public static boolean isFlagsResistanceLevelNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_RESISTANCE_LEVEL_PRESENT_MASK, FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Resistance Level present, {@code false}:Resistance Level not present
     */
    public static boolean isFlagsResistanceLevelPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_RESISTANCE_LEVEL_PRESENT_MASK, FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Instantaneous Power not present, {@code false}:Instantaneous Power present
     */
    public static boolean isFlagsInstantaneousPowerNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_POWER_PRESENT_MASK, FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Instantaneous Power present, {@code false}:Instantaneous Power not present
     */
    public static boolean isFlagsInstantaneousPowerPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_INSTANTANEOUS_POWER_PRESENT_MASK, FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Power not present, {@code false}:Average Power present
     */
    public static boolean isFlagsAveragePowerNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_POWER_PRESENT_MASK, FLAGS_AVERAGE_POWER_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Power present, {@code false}:Average Power not present
     */
    public static boolean isFlagsAveragePowerPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_POWER_PRESENT_MASK, FLAGS_AVERAGE_POWER_PRESENT_TRUE, flags);
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
     * @param instantaneousCadence Instantaneous Cadence
     * @return Instantaneous Cadence(1/minute)
     */
    public static double getInstantaneousCadenceRpm(int instantaneousCadence) {
        return INSTANTANEOUS_CADENCE_RESOLUTION * instantaneousCadence;
    }

    /**
     * @param averageCadence Average Cadence
     * @return Average Cadence(1/minute)
     */
    public static double getAverageCadenceRpm(int averageCadence) {
        return AVERAGE_CADENCE_RESOLUTION * averageCadence;
    }

    /**
     * @param metabolicEquivalent Metabolic Equivalent
     * @return Metabolic Equivalent with Unit
     */
    public static double getMetabolicEquivalentWithUnit(int metabolicEquivalent) {
        return METABOLIC_EQUIVALENT_RESOLUTION * metabolicEquivalent;
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAGS_MORE_DATA_FALSE}
     *               , {@link #FLAGS_MORE_DATA_TRUE}
     *               , {@link #FLAGS_AVERAGE_SPEED_PRESENT_FALSE}
     *               , {@link #FLAGS_AVERAGE_SPEED_PRESENT_TRUE}
     *               , {@link #FLAGS_INSTANTANEOUS_CADENCE_PRESENT_FALSE}
     *               , {@link #FLAGS_INSTANTANEOUS_CADENCE_PRESENT_TRUE}
     *               , {@link #FLAGS_AVERAGE_CADENCE_PRESENT_FALSE}
     *               , {@link #FLAGS_AVERAGE_CADENCE_PRESENT_TRUE}
     *               , {@link #FLAGS_TOTAL_DISTANCE_PRESENT_FALSE}
     *               , {@link #FLAGS_TOTAL_DISTANCE_PRESENT_TRUE}
     *               , {@link #FLAGS_RESISTANCE_LEVEL_PRESENT_FALSE}
     *               , {@link #FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE}
     *               , {@link #FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE}
     *               , {@link #FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE}
     *               , {@link #FLAGS_AVERAGE_POWER_PRESENT_FALSE}
     *               , {@link #FLAGS_AVERAGE_POWER_PRESENT_TRUE}
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
     * @param flags  current packet's flags
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private static boolean isFlagsMatched(int mask, int expect, byte[] flags) {
        return (mask & BLEUtils.createSInt16(flags, 0)) == expect;
    }

}
