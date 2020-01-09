package org.im97mori.ble.characteristic.ftms;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;

@SuppressWarnings("WeakerAccess")
public class StairClimberDataUtils {

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

    /* @see #FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
     * @see #FLAGS_STEP_PER_MINUTE_PRESENT_TRUE
     */
    public static final int FLAGS_STEP_PER_MINUTE_PRESENT_MASK = 0b00000000_00000010;

    /**
     * 0: Step per Minute present False
     */
    public static final int FLAGS_STEP_PER_MINUTE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Step per Minute present True
     */
    public static final int FLAGS_STEP_PER_MINUTE_PRESENT_TRUE = 0b00000000_00000010;

    /**
     * @see #FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
     * @see #FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE
     */
    public static final int FLAGS_AVERAGE_STEP_RATE_PRESENT_MASK = 0b00000000_00000100;

    /**
     * 0: Average Step Rate Present False
     */
    public static final int FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Average Step Rate Present True
     */
    public static final int FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE = 0b00000000_00000100;

    /**
     * @see #FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
     * @see #FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE
     */
    public static final int FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_MASK = 0b00000000_00001000;

    /**
     * 0: Positive Elevation Gain present False
     */
    public static final int FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Positive Elevation Gain present True
     */
    public static final int FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE = 0b00000000_00001000;

    /**
     * @see #FLAGS_STRIDE_COUNT_PRESENT_FALSE
     * @see #FLAGS_STRIDE_COUNT_PRESENT_TRUE
     */
    public static final int FLAGS_STRIDE_COUNT_PRESENT_MASK = 0b00000000_00010000;

    /**
     * 0: Stride Count Present False
     */
    public static final int FLAGS_STRIDE_COUNT_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Stride Count Present True
     */
    public static final int FLAGS_STRIDE_COUNT_PRESENT_TRUE = 0b00000000_00010000;

    /**
     * @see #FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
     * @see #FLAGS_EXPENDED_ENERGY_PRESENT_TRUE
     */
    public static final int FLAGS_EXPENDED_ENERGY_PRESENT_MASK = 0b00000000_00100000;

    /**
     * 0: Expended Energy present False
     */
    public static final int FLAGS_EXPENDED_ENERGY_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Expended Energy present True
     */
    public static final int FLAGS_EXPENDED_ENERGY_PRESENT_TRUE = 0b00000000_00100000;

    /**
     * @see #FLAGS_HEART_RATE_PRESENT_FALSE
     * @see #FLAGS_HEART_RATE_PRESENT_TRUE
     */
    public static final int FLAGS_HEART_RATE_PRESENT_MASK = 0b00000000_01000000;

    /**
     * 0: Heart Rate present False
     */
    public static final int FLAGS_HEART_RATE_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Heart Rate present True
     */
    public static final int FLAGS_HEART_RATE_PRESENT_TRUE = 0b00000000_01000000;

    /**
     * @see #FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
     * @see #FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_MASK = 0b00000000_10000000;

    /**
     * 0: Metabolic Equivalent present False
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Metabolic Equivalent present True
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE = 0b00000000_10000000;

    /**
     * @see #FLAGS_ELAPSED_TIME_PRESENT_FALSE
     * @see #FLAGS_ELAPSED_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_MASK = 0b00000001_00000000;

    /**
     * 0: Elapsed Time present False
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Elapsed Time present True
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_TRUE = 0b00000001_00000000;

    /**
     * @see #FLAGS_REMAINING_TIME_PRESENT_FALSE
     * @see #FLAGS_REMAINING_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_MASK = 0b00000010_00000000;

    /**
     * 0: Remaining Time present False
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_FALSE = 0b00000000_00000000;

    /**
     * 1: Remaining Time present True
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_TRUE = 0b00000010_00000000;

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
     * @return {@code true}:Step per Minute not present, {@code false}:Step per Minute present
     */
    public static boolean isFlagsStepPerMinuteNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_STEP_PER_MINUTE_PRESENT_MASK, FLAGS_STEP_PER_MINUTE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Step per Minute present, {@code false}:Step per Minute mpt present
     */
    public static boolean isFlagsStepPerMinutePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_STEP_PER_MINUTE_PRESENT_MASK, FLAGS_STEP_PER_MINUTE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Step Rate not Present, {@code false}:Average Step Rate Present
     */
    public static boolean isFlagsAverageStepRateNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_STEP_RATE_PRESENT_MASK, FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Average Step Rate Present, {@code false}:Average Step Rate not Present
     */
    public static boolean isFlagsAverageStepRatePresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_AVERAGE_STEP_RATE_PRESENT_MASK, FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Positive Elevation Gain not present, {@code false}:Positive Elevation Gain present
     */
    public static boolean isFlagsPositiveElevationGainNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_MASK, FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Positive Elevation Gain present, {@code false}:Positive Elevation Gain not present
     */
    public static boolean isFlagsPositiveElevationGainPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_MASK, FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Stride Count not Present, {@code false}:Stride Count Present
     */
    public static boolean isFlagsStrideCountNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_STRIDE_COUNT_PRESENT_MASK, FLAGS_STRIDE_COUNT_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Stride Count Present, {@code false}:Stride Count not Present
     */
    public static boolean isFlagsStrideCountPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_STRIDE_COUNT_PRESENT_MASK, FLAGS_STRIDE_COUNT_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Expended Energy not present, {@code false}:Expended Energy present
     */
    public static boolean isFlagsExpendedEnergyNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_EXPENDED_ENERGY_PRESENT_MASK, FLAGS_EXPENDED_ENERGY_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Expended Energy present, {@code false}:Expended Energy not present
     */
    public static boolean isFlagsExpendedEnergyPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_EXPENDED_ENERGY_PRESENT_MASK, FLAGS_EXPENDED_ENERGY_PRESENT_TRUE, flags);
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
     * @return {@code true}:Remaining Time not present {@code false}:Remaining Time present
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
     *               , {@link #FLAGS_STEP_PER_MINUTE_PRESENT_FALSE}
     *               , {@link #FLAGS_STEP_PER_MINUTE_PRESENT_TRUE}
     *               , {@link #FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE}
     *               , {@link #FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE}
     *               , {@link #FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE}
     *               , {@link #FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE}
     *               , {@link #FLAGS_STRIDE_COUNT_PRESENT_FALSE}
     *               , {@link #FLAGS_STRIDE_COUNT_PRESENT_TRUE}
     *               , {@link #FLAGS_EXPENDED_ENERGY_PRESENT_FALSE}
     *               , {@link #FLAGS_EXPENDED_ENERGY_PRESENT_TRUE}
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
