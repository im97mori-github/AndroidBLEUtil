package org.im97mori.ble.characteristic.ftms;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;

@SuppressWarnings("WeakerAccess")
public class CrossTrainerDataUtils {

    /**
     * @see #FLAGS_MORE_DATA_FALSE
     * @see #FLAGS_MORE_DATA_TRUE
     */
    public static final int FLAGS_MORE_DATA_MASK = 0b00000000_00000000_00000001;

    /**
     * 0: More Data False
     */
    public static final int FLAGS_MORE_DATA_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: More Data True
     */
    public static final int FLAGS_MORE_DATA_TRUE = 0b00000000_00000000_00000001;

    /**
     * @see #FLAGS_AVERAGE_SPEED_PRESENT_FALSE
     * @see #FLAGS_AVERAGE_SPEED_PRESENT_TRUE
     */
    public static final int FLAGS_AVERAGE_SPEED_PRESENT_MASK = 0b00000000_00000000_00000010;

    /**
     * 0: Average Speed present False
     */
    public static final int FLAGS_AVERAGE_SPEED_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Average Speed present True
     */
    public static final int FLAGS_AVERAGE_SPEED_PRESENT_TRUE = 0b00000000_00000000_00000010;

    /**
     * @see #FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
     * @see #FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_MASK = 0b00000000_00000000_00000100;

    /**
     * 0: Total Distance Present False
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Total Distance Present True
     */
    public static final int FLAGS_TOTAL_DISTANCE_PRESENT_TRUE = 0b00000000_00000000_00000100;

    /**
     * @see #FLAGS_STEP_COUNT_PRESENT_FALSE
     * @see #FLAGS_STEP_COUNT_PRESENT_TRUE
     */
    public static final int FLAGS_STEP_COUNT_PRESENT_MASK = 0b00000000_00000000_00001000;

    /**
     * 0: Step Count present False
     */
    public static final int FLAGS_STEP_COUNT_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Step Count present True
     */
    public static final int FLAGS_STEP_COUNT_PRESENT_TRUE = 0b00000000_00000000_00001000;

    /**
     * @see #FLAGS_STRIDE_COUNT_PRESENT_FALSE
     * @see #FLAGS_STRIDE_COUNT_PRESENT_TRUE
     */
    public static final int FLAGS_STRIDE_COUNT_PRESENT_MASK = 0b00000000_00000000_00010000;

    /**
     * 0: Stride Count present False
     */
    public static final int FLAGS_STRIDE_COUNT_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Stride Count present True
     */
    public static final int FLAGS_STRIDE_COUNT_PRESENT_TRUE = 0b00000000_00000000_00010000;

    /**
     * @see #FLAGS_ELEVATION_GAIN_PRESENT_FALSE
     * @see #FLAGS_ELEVATION_GAIN_PRESENT_TRUE
     */
    public static final int FLAGS_ELEVATION_GAIN_PRESENT_MASK = 0b00000000_00000000_00100000;

    /**
     * 0: Elevation Gain present False
     */
    public static final int FLAGS_ELEVATION_GAIN_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Elevation Gain present True
     */
    public static final int FLAGS_ELEVATION_GAIN_PRESENT_TRUE = 0b00000000_00000000_00100000;

    /**
     * @see #FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE
     * @see #FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
     */
    public static final int FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_MASK = 0b00000000_00000000_01000000;

    /**
     * 0: Inclination and Ramp Angle Setting present False
     */
    public static final int FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Inclination and Ramp Angle Setting present True
     */
    public static final int FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE = 0b00000000_00000000_01000000;

    /**
     * @see #FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE
     * @see #FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE
     */
    public static final int FLAGS_REGISTANCE_LEVEL_PRESENT_MASK = 0b00000000_00000000_10000000;

    /**
     * 0: Resistance Level Present False
     */
    public static final int FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Resistance Level Present True
     */
    public static final int FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE = 0b00000000_00000000_10000000;

    /**
     * @see #FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE
     * @see #FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
     */
    public static final int FLAGS_INSTANTANEOUS_POWER_PRESENT_MASK = 0b00000000_00000001_00000000;

    /**
     * 0: Instantaneous Power present False
     */
    public static final int FLAGS_INSTANTANEOUS_POWER_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Instantaneous Power present True
     */
    public static final int FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE = 0b00000000_00000001_00000000;

    /**
     * @see #FLAGS_AVERAGE_POWER_PRESENT_FALSE
     * @see #FLAGS_AVERAGE_POWER_PRESENT_TRUE
     */
    public static final int FLAGS_AVERAGE_POWER_PRESENT_MASK = 0b00000000_00000010_00000000;

    /**
     * 0: Average Power present False
     */
    public static final int FLAGS_AVERAGE_POWER_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Average Power present True
     */
    public static final int FLAGS_AVERAGE_POWER_PRESENT_TRUE = 0b00000000_00000010_00000000;

    /**
     * @see #FLAGS_EXPANDED_ENERGY_PRESENT_FALSE
     * @see #FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_MASK = 0b00000000_00000100_00000000;

    /**
     * 0: Expended Energy present False
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Expended Energy present True
     */
    public static final int FLAGS_EXPANDED_ENERGY_PRESENT_TRUE = 0b00000000_00000100_00000000;

    /**
     * @see #FLAGS_HEART_RATE_PRESENT_FALSE
     * @see #FLAGS_HEART_RATE_PRESENT_TRUE
     */
    public static final int FLAGS_HEART_RATE_PRESENT_MASK = 0b00000000_00001000_00000000;

    /**
     * 0: Heart Rate present False
     */
    public static final int FLAGS_HEART_RATE_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Heart Rate present True
     */
    public static final int FLAGS_HEART_RATE_PRESENT_TRUE = 0b00000000_00001000_00000000;

    /**
     * @see #FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
     * @see #FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_MASK = 0b00000000_00010000_00000000;

    /**
     * 0: Metabolic Equivalent present False
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Metabolic Equivalent present True
     */
    public static final int FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE = 0b00000000_00010000_00000000;

    /**
     * @see #FLAGS_ELAPSED_TIME_PRESENT_FALSE
     * @see #FLAGS_ELAPSED_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_MASK = 0b00000000_00100000_00000000;

    /**
     * 0: Elapsed Time present False
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Elapsed Time present True
     */
    public static final int FLAGS_ELAPSED_TIME_PRESENT_TRUE = 0b00000000_00100000_00000000;

    /**
     * @see #FLAGS_REMAINING_TIME_PRESENT_FALSE
     * @see #FLAGS_REMAINING_TIME_PRESENT_TRUE
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_MASK = 0b00000000_01000000_00000000;

    /**
     * 0: Remaining Time present False
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Remaining Time present True
     */
    public static final int FLAGS_REMAINING_TIME_PRESENT_TRUE = 0b00000000_01000000_00000000;

    /**
     * @see #FLAGS_MOVEMENT_DIRECTION_FALSE
     * @see #FLAGS_MOVEMENT_DIRECTION_TRUE
     */
    public static final int FLAGS_MOVEMENT_DIRECTION_MASK = 0b00000000_10000000_00000000;

    /**
     * 0: Movement Direction Forward
     */
    public static final int FLAGS_MOVEMENT_DIRECTION_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Movement Direction Backward
     */
    public static final int FLAGS_MOVEMENT_DIRECTION_TRUE = 0b00000000_10000000_00000000;

    /**
     * Step per Minute Data Not Available
     */
    public static final int STEP_PER_MINUTE_DATA_NOT_AVAILABLE = 0xFFFF;

    /**
     * Average Step Rate Data Not Available
     */
    public static final int AVERAGE_STEP_RATE_DATA_NOT_AVAILABLE = 0xFFFF;

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
     * Instantaneous Speed Unit 0.01 Kilometer per hour
     */
    public static final double INSTANTANEOUS_SPEED_RESOLUTION = 0.01d;

    /**
     * Average Speed Unit 0.01 Kilometer per hour
     */
    public static final double AVERAGE_SPEED_RESOLUTION = 0.01d;

    /**
     * Stride Count Unit 0.1
     */
    public static final double STRIDE_COUNT_RESOLUTION = 0.1d;

    /**
     * Inclination Unit 0.1 Percent
     */
    public static final double INCLINATION_RESOLUTION = 0.1d;

    /**
     * Ramp Angle Setting Unit 0.1 Degree
     */
    public static final double RAMP_ANGLE_SETTING_RESOLUTION = 0.1d;

    /**
     * Resistance Level Unit 0.1
     */
    public static final double RESISTANCE_LEVEL_RESOLUTION = 0.1d;

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
     * @return {@code true}:Step Count not present, {@code false}:Step Count present
     */
    public static boolean isFlagsStepCountNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_STEP_COUNT_PRESENT_MASK, FLAGS_STEP_COUNT_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Step Count present, {@code false}:Step Count not present
     */
    public static boolean isFlagsStepCountPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_STEP_COUNT_PRESENT_MASK, FLAGS_STEP_COUNT_PRESENT_TRUE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Stride Count not present, {@code false}:Stride Count present
     */
    public static boolean isFlagsStrideCountNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_STRIDE_COUNT_PRESENT_MASK, FLAGS_STRIDE_COUNT_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Stride Count present, {@code false}:Stride Count not present
     */
    public static boolean isFlagsStrideCountPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_STRIDE_COUNT_PRESENT_MASK, FLAGS_STRIDE_COUNT_PRESENT_TRUE, flags);
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
     * @return {@code true}:Resistance Level not Present, {@code false}:Resistance Level Present
     */
    public static boolean isFlagsResistanceLevelNotPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_REGISTANCE_LEVEL_PRESENT_MASK, FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Resistance Level Present, {@code false}:Resistance Level not Present
     */
    public static boolean isFlagsResistanceLevelPresent(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_REGISTANCE_LEVEL_PRESENT_MASK, FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE, flags);
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
     * @param flags flags
     * @return {@code true}:Movement Direction Forward, {@code false}:Movement Direction Backward
     */
    public static boolean isFlagsMovementDirectionForward(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_MOVEMENT_DIRECTION_MASK, FLAGS_MOVEMENT_DIRECTION_FALSE, flags);
    }

    /**
     * @param flags flags
     * @return {@code true}:Movement Direction Backward, {@code false}:Movement Direction Forward
     */
    public static boolean isFlagsMovementDirectionBackward(@NonNull byte[] flags) {
        return isFlagsMatched(FLAGS_MOVEMENT_DIRECTION_MASK, FLAGS_MOVEMENT_DIRECTION_TRUE, flags);
    }

    /**
     * @param stepPerMinute Step per Minute
     * @return {@code true}:Step per Minute Data Not Available, {@code false}:Step per Minute Data Available
     */
    public static boolean isStepPerMinuteDataNotAvailable(int stepPerMinute) {
        return STEP_PER_MINUTE_DATA_NOT_AVAILABLE == stepPerMinute;
    }

    /**
     * @param averageStepRate Average Step Rate
     * @return {@code true}:Average Step Rate Data Not Available, {@code false}:Average Step Rate Data Available
     */
    public static boolean isAverageStepRateDataNotAvailable(int averageStepRate) {
        return AVERAGE_STEP_RATE_DATA_NOT_AVAILABLE == averageStepRate;
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
     * @return {@code true}:Energy per Hour Data Not Available, {@code false}:Energy per Hour Data Available
     */
    public static boolean isEnergyPerHouryDataNotAvailable(int energyPerHour) {
        return ENERGY_PER_HOUR_DATA_NOT_AVAILABLE == energyPerHour;
    }

    /**
     * @param energyPerMinute Energy per Minute
     * @return {@code true}:Energy per Minute Data Not Available, {@code false}:Energy per Minute Data Available
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
     * @param strideCount Stride Count
     * @return Stride Count with Unit
     */
    public static double getStrideCountWithUnit(int strideCount) {
        return STRIDE_COUNT_RESOLUTION * strideCount;
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
     * @param resistanceLevel Resistance Level
     * @return Resistance Level with Unit
     */
    public static double getResistanceLevelWithUnit(int resistanceLevel) {
        return RESISTANCE_LEVEL_RESOLUTION * resistanceLevel;
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
     *               , {@link #FLAGS_TOTAL_DISTANCE_PRESENT_FALSE}
     *               , {@link #FLAGS_TOTAL_DISTANCE_PRESENT_TRUE}
     *               , {@link #FLAGS_STEP_COUNT_PRESENT_FALSE}
     *               , {@link #FLAGS_STEP_COUNT_PRESENT_TRUE}
     *               , {@link #FLAGS_STRIDE_COUNT_PRESENT_FALSE}
     *               , {@link #FLAGS_STRIDE_COUNT_PRESENT_TRUE}
     *               , {@link #FLAGS_ELEVATION_GAIN_PRESENT_FALSE}
     *               , {@link #FLAGS_ELEVATION_GAIN_PRESENT_TRUE}
     *               , {@link #FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_FALSE}
     *               , {@link #FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE}
     *               , {@link #FLAGS_REGISTANCE_LEVEL_PRESENT_FALSE}
     *               , {@link #FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE}
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
     *               , {@link #FLAGS_MOVEMENT_DIRECTION_FALSE}
     *               , {@link #FLAGS_MOVEMENT_DIRECTION_TRUE}
     * @param flags  current packet's flags
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private static boolean isFlagsMatched(int mask, int expect, byte[] flags) {
        return (mask & BLEUtils.createSInt24(flags, 0)) == expect;
    }

}
