package org.im97mori.ble.characteristic.ftms;

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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FITNESS_MACHINE_FEATURE_CHARACTERISTIC;

/**
 * Fitness Machine Feature (Characteristics UUID: 0x2ACC)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FitnessMachineFeature implements ByteArrayInterface, Parcelable {

    /**
     * @see #FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000001;

    /**
     * 0: Average Speed Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Average Speed Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000001;

    /**
     * @see #FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000010;

    /**
     * 0: Cadence Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Cadence Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000010;

    /**
     * @see #FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000100;

    /**
     * 0: Total Distance Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE = 0b00000000_00000000_00000000_0000000;

    /**
     * 1: Total Distance Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000100;

    /**
     * @see #FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_MASK = 0b00000000_00000000_00000000_00001000;

    /**
     * 0: Inclination Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Inclination Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00001000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_MASK = 0b00000000_00000000_00000000_00010000;

    /**
     * 0: Elevation Gain Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Elevation Gain Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00010000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_MASK = 0b00000000_00000000_00000000_00100000;

    /**
     * 0: Pace Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Pace Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00100000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_MASK = 0b00000000_00000000_00000000_01000000;

    /**
     * 0: Step Count Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Step Count Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_TRUE = 0b00000000_00000000_00000000_01000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_MASK = 0b00000000_00000000_00000000_10000000;

    /**
     * 0: Resistance Level Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Resistance Level Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_TRUE = 0b00000000_00000000_00000000_10000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_MASK = 0b00000000_00000000_00000001_00000000;

    /**
     * 0: Stride Count Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Stride Count Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_TRUE = 0b00000000_00000000_00000001_00000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_MASK = 0b00000000_00000000_00000010_00000000;

    /**
     * 0: Expended Energy Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Expended Energy Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_TRUE = 0b00000000_00000000_00000010_00000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_MASK = 0b00000000_00000000_00000100_00000000;

    /**
     * 0: Heart Rate Measurement Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Heart Rate Measurement Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_TRUE = 0b00000000_00000000_00000100_00000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_MASK = 0b00000000_00000000_00001000_00000000;

    /**
     * 0: Metabolic Equivalent Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Metabolic Equivalent Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_TRUE = 0b00000000_00000000_00001000_00000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_MASK = 0b00000000_00000000_00010000_00000000;

    /**
     * 0: Elapsed Time Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Elapsed Time Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_TRUE = 0b00000000_00000000_00010000_00000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_MASK = 0b00000000_00000000_00100000_00000000;

    /**
     * 0: Remaining Time Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Remaining Time Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_TRUE = 0b00000000_00000000_00100000_00000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_MASK = 0b00000000_00000000_01000000_00000000;

    /**
     * 0: Power Measurement Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Power Measurement Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_TRUE = 0b00000000_00000000_01000000_00000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_MASK = 0b00000000_00000000_10000000_00000000;

    /**
     * 0: Force on Belt and Power Output Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Force on Belt and Power Output Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_TRUE = 0b00000000_00000000_10000000_00000000;

    /**
     * @see #FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE
     * @see #FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE
     */
    public static final int FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_MASK = 0b00000000_00000001_00000000_00000000;

    /**
     * 0: User Data Retention Supported False
     */
    public static final int FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: User Data Retention Supported True
     */
    public static final int FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE = 0b00000000_00000001_00000000_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000001;

    /**
     * 0: Speed Target Setting Supported False
     */
    public static final int TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Speed Target Setting Supported True
     */
    public static final int TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000001;

    /**
     * @see #TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000010;

    /**
     * 0: Inclination Target Setting Supported False
     */
    public static final int TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Inclination Target Setting Supported True
     */
    public static final int TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000010;

    /**
     * @see #TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_MASK = 0b00000000_00000000_00000000_00000100;

    /**
     * 0: Resistance Target Setting Supported False
     */
    public static final int TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Resistance Target Setting Supported True
     */
    public static final int TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00000100;

    /**
     * @see #TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_MASK = 0b00000000_00000000_00000000_00001000;

    /**
     * 0: Power Target Setting Supported False
     */
    public static final int TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Power Target Setting Supported True
     */
    public static final int TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00001000;

    /**
     * @see #TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_MASK = 0b00000000_00000000_00000000_00010000;

    /**
     * 0: Heart Rate Target Setting Supported False
     */
    public static final int TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Heart Rate Target Setting Supported True
     */
    public static final int TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00010000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000000_00000000_00100000;

    /**
     * 0: Targeted Expended Energy Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Expended Energy Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000000_00000000_00100000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_MASK = 0b00000000_00000000_00000000_01000000;

    /**
     * 0: Targeted Step Number Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Step Number Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_TRUE = 0b00000000_00000000_00000000_01000000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000000_00000000_10000000;

    /**
     * 0: Targeted Stride Number Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Stride Number Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000000_00000000_10000000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000000_00000001_00000000;

    /**
     * 0: Targeted Distance Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Distance Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000000_00000001_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000000_00000010_00000000;

    /**
     * 0: Targeted Training Time Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Training Time Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000000_00000010_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000000_00000100_00000000;

    /**
     * 0: Targeted Time in Two Heart Rate Zones Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Time in Two Heart Rate Zones Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000000_00000100_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000000_00001000_00000000;

    /**
     * 0: Targeted Time in Three Heart Rate Zones Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Time in Three Heart Rate Zones Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000000_00001000_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000000_00010000_00000000;

    /**
     * 0: Targeted Time in Five Heart Rate Zones Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Time in Five Heart Rate Zones Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000000_00010000_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_MASK = 0b00000000_00000000_00100000_00000000;

    /**
     * 0: Indoor Bike Simulation Parameters Supported False
     */
    public static final int TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Indoor Bike Simulation Parameters Supported True
     */
    public static final int TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_TRUE = 0b00000000_00000000_00100000_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000000_01000000_00000000;

    /**
     * 0: Wheel Circumference Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Wheel Circumference Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000000_01000000_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_MASK = 0b00000000_00000000_10000000_00000000;

    /**
     * 0: Spin Down Control Supported False
     */
    public static final int TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Spin Down Control Supported True
     */
    public static final int TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_TRUE = 0b00000000_00000000_10000000_00000000;

    /**
     * @see #TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE
     * @see #TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_TRUE
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_MASK = 0b00000000_00000001_00000000_00000000;

    /**
     * 0: Targeted Cadence Configuration Supported False
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE = 0b00000000_00000000_00000000_00000000;

    /**
     * 1: Targeted Cadence Configuration Supported True
     */
    public static final int TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_TRUE = 0b00000000_00000001_00000000_00000000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FitnessMachineFeature> CREATOR = new ByteArrayCreater<FitnessMachineFeature>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineFeature createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineFeature(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineFeature[] newArray(int size) {
            return new FitnessMachineFeature[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FitnessMachineFeature createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FitnessMachineFeature(bluetoothGattCharacteristic);
        }

    };

    /**
     * Fitness Machine Features
     */
    public final byte[] mFitnessMachineFeatures;

    /**
     * Target Setting Features
     */
    public final byte[] mTargetSettingFeatures;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACC
     */
    public FitnessMachineFeature(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFitnessMachineFeatures = Arrays.copyOfRange(values, 0, 4);
        mTargetSettingFeatures = Arrays.copyOfRange(values, 4, 8);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FitnessMachineFeature(@NonNull Parcel in) {
        mFitnessMachineFeatures = in.createByteArray();
        mTargetSettingFeatures = in.createByteArray();
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
        dest.writeByteArray(mFitnessMachineFeatures);
        dest.writeByteArray(mTargetSettingFeatures);
    }

    /**
     * @return Fitness Machine Features
     */
    public byte[] getFitnessMachineFeatures() {
        return mFitnessMachineFeatures;
    }

    /**
     * @return {@code true}:Average Speed not Supported, {@code false}:Average Speed Supported
     */
    public boolean isFitnessMachineFeaturesAverageSpeedNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Average Speed Supported, {@code false}:Average Speed not Supported
     */
    public boolean isFitnessMachineFeaturesAverageSpeedSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Cadence not Supported, {@code false}:Cadence Supported
     */
    public boolean isFitnessMachineFeaturesCadenceNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Cadence Supported, {@code false}:Cadence not Supported
     */
    public boolean isFitnessMachineFeaturesCadenceSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Total Distance not Supported, {@code false}:Total Distance Supported
     */
    public boolean isFitnessMachineFeaturesTotalDistanceNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Total Distance Supported, {@code false}:Total Distance not Supported
     */
    public boolean isFitnessMachineFeaturesTotalDistanceSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Inclination not Supported, {@code false}:Inclination Supported
     */
    public boolean isFitnessMachineFeaturesInclinationNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Inclination Supported, {@code false}:Inclination not Supported
     */
    public boolean isFitnessMachineFeaturesInclinationSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Elevation Gain not Supported, {@code false}:Elevation Gain Supported
     */
    public boolean isFitnessMachineFeaturesElevationGainNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Elevation Gain Supported, {@code false}:Elevation Gain not Supported
     */
    public boolean isFitnessMachineFeaturesElevationGainSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Pace not Supported, {@code false}:Pace Supported
     */
    public boolean isFitnessMachineFeaturesPaceNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Pace Supported, {@code false}:Pace not Supported
     */
    public boolean isFitnessMachineFeaturesPaceSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Step Count not Supported, {@code false}:Step Count Supported
     */
    public boolean isFitnessMachineFeaturesStepCountNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Step Count Supported, {@code false}:Step Count not Supported
     */
    public boolean isFitnessMachineFeaturesStepCountSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Resistance Level not Supported, {@code false}:Resistance Level Supported
     */
    public boolean isFitnessMachineFeaturesResistanceLevelNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Resistance Level Supported, {@code false}:Resistance Level not Supported
     */
    public boolean isFitnessMachineFeaturesResistanceLevelSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Stride Count not Supported, {@code false}:Stride Count Supported
     */
    public boolean isFitnessMachineFeaturesStrideCountNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Stride Count Supported, {@code false}:Stride Count not Supported
     */
    public boolean isFitnessMachineFeaturesStrideCountSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Expended Energy not Supported, {@code false}:Expended Energy Supported
     */
    public boolean isFitnessMachineFeaturesExpendedEnergyNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Expended Energy Supported, {@code false}:Expended Energy not Supported
     */
    public boolean isFitnessMachineFeaturesExpendedEnergySupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Heart Rate Measurement not Supported, {@code false}:Heart Rate Measurement Supported
     */
    public boolean isFitnessMachineFeaturesHeartRateMeasurementNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Heart Rate Measurement Supported, {@code false}:Heart Rate Measurement not Supported
     */
    public boolean isFitnessMachineFeaturesHeartRateMeasurementSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Metabolic Equivalent not Supported, {@code false}:Metabolic Equivalent Supported
     */
    public boolean isFitnessMachineFeaturesMetabolicEquivalentNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Metabolic Equivalent Supported, {@code false}:Metabolic Equivalent not Supported
     */
    public boolean isFitnessMachineFeaturesMetabolicEquivalentSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Elapsed Time not Supported, {@code false}:Elapsed Time Supported
     */
    public boolean isFitnessMachineFeaturesElapsedTimeNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Elapsed Time Supported, {@code false}:Elapsed Time not Supported
     */
    public boolean isFitnessMachineFeaturesElapsedTimeSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Remaining Time not Supported, {@code false}:Remaining Time Supported
     */
    public boolean isFitnessMachineFeaturesRemainingTimeNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Remaining Time Supported, {@code false}:Remaining Time not Supported
     */
    public boolean isFitnessMachineFeaturesRemainingTimeSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Power Measurement not Supported, {@code false}:Power Measurement Supported
     */
    public boolean isFitnessMachineFeaturesPowerMeasurementNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Power Measurement Supported, {@code false}:Power Measurement not Supported
     */
    public boolean isFitnessMachineFeaturesPowerMeasurementSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Force on Belt and Power Output not Supported, {@code false}:Force on Belt and Power Output Supported
     */
    public boolean isFitnessMachineFeaturesForceOnBeltAndPowerOutputNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Force on Belt and Power Output Supported, {@code false}:Force on Belt and Power Output not Supported
     */
    public boolean isFitnessMachineFeaturesForceOnBeltAndPowerOutputSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:User Data Retention not Supported, {@code false}:User Data Retention Supported
     */
    public boolean isFitnessMachineFeaturesUserDataRetentionNotSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:User Data Retention Supported, {@code false}:User Data Retention not Supported
     */
    public boolean isFitnessMachineFeaturesUserDataRetentionSupported() {
        return isFitnessMachineFeaturesMatched(FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_MASK, FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE);
    }


    /**
     * @return Target Setting Features
     */
    public byte[] getTargetSettingFeatures() {
        return mTargetSettingFeatures;
    }

    /**
     * @return {@code true}:Speed Target Setting not Supported, {@code false}:Speed Target Setting Supported
     */
    public boolean isTargetSettingFeaturesSpeedTargetSettingNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Speed Target Setting Supported, {@code false}:Speed Target Setting not Supported
     */
    public boolean isTargetSettingFeaturesSpeedTargetSettingSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Inclination Target Setting not Supported, {@code false}:Inclination Target Setting Supported
     */
    public boolean isTargetSettingFeaturesInclinationTargetSettinNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Inclination Target Setting Supported, {@code false}:Inclination Target Setting not Supported
     */
    public boolean isTargetSettingFeaturesInclinationTargetSettingSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Resistance Target Setting not Supported, {@code false}:Resistance Target Setting Supported
     */
    public boolean isTargetSettingFeaturesResistanceTargetSettingNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Resistance Target Setting Supported, {@code false}:Resistance Target Setting not Supported
     */
    public boolean isTargetSettingFeaturesResistanceTargetSettingSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Power Target Setting not Supported, {@code false}:Power Target Setting Supported
     */
    public boolean isTargetSettingFeaturesPowerTargetSettingNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Power Target Setting Supported, {@code false}:Power Target Setting not Supported
     */
    public boolean isTargetSettingFeaturesPowerTargetSettingSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Heart Rate Target Setting not Supported, {@code false}:Heart Rate Target Setting Supported
     */
    public boolean isTargetSettingFeaturesHeartRateTargetSettingNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Heart Rate Target Setting Supported, {@code false}:Heart Rate Target Setting not Supported
     */
    public boolean isTargetSettingFeaturesHeartRateTargetSettingSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_MASK, TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Expended Energy Configuration not Supported, {@code false}:Targeted Expended Energy Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedExpendedEnergyConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Expended Energy Configuration Supported, {@code false}:Targeted Expended Energy Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedExpendedEnergyConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Step Number Configuration not Supported, {@code false}:Targeted Step Number Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedStepNumberConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Step Number Configuration Supported, {@code false}:Targeted Step Number Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedStepNumberConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Stride Number Configuration not Supported, {@code false}:Targeted Stride Number Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedStrideNumberConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Stride Number Configuration Supported, {@code false}:Targeted Stride Number Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedStrideNumberConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Distance Configuration not Supported, {@code false}:Targeted Distance Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedDistanceConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Distance Configuration Supported, {@code false}:Targeted Distance Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedDistanceConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Training Time Configuration not Supported, {@code false}:Targeted Training Time Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedTrainingTimeConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Training Time Configuration Supported, {@code false}:Targeted Training Time Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedTrainingTimeConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Time in Two Heart Rate Zones Configuration not Supported, {@code false}:Targeted Time in Two Heart Rate Zones Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedTimeInTwoHeartRateZonesConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Time in Two Heart Rate Zones Configuration Supported, {@code false}:Targeted Time in Two Heart Rate Zones Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedTimeInTwoHeartRateZonesConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Time in Three Heart Rate Zones Configuration not Supported, {@code false}:Targeted Time in Three Heart Rate Zones Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedTimeInThreeHeartRateZonesConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Time in Three Heart Rate Zones Configuration Supported, {@code false}:Targeted Time in Three Heart Rate Zones Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedTimeInThreeHeartRateZonesConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Time in Five Heart Rate Zones Configuration not Supported, {@code false}:Targeted Time in Five Heart Rate Zones Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedTimeInFiveHeartRateZonesConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Time in Five Heart Rate Zones Configuration Supported, {@code false}:Targeted Time in Five Heart Rate Zones Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedTimeInFiveHeartRateZonesConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Indoor Bike Simulation Parameters not Supported, {@code false}:Indoor Bike Simulation Parameters Supported
     */
    public boolean isTargetSettingFeaturesIndoorBikeSimulationParametersNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_MASK, TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Indoor Bike Simulation Parameters Supported, {@code false}:Indoor Bike Simulation Parameters not Supported
     */
    public boolean isTargetSettingFeaturesIndoorBikeSimulationParametersSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_MASK, TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Wheel Circumference Configuration not Supported, {@code false}:Wheel Circumference Configuration Supported
     */
    public boolean isTargetSettingFeaturesWheelCircumferenceConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Wheel Circumference Configuration Supported, {@code false}:Wheel Circumference Configuration not Supported
     */
    public boolean isTargetSettingFeaturesWheelCircumferenceConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Spin Down Control not Supported, {@code false}:Spin Down Control Supported
     */
    public boolean isTargetSettingFeaturesSpinDownControlNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_MASK, TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Spin Down Control Supported, {@code false}:Spin Down Control not Supported
     */
    public boolean isTargetSettingFeaturesSpinDownControlSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_MASK, TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Targeted Cadence Configuration not Supported, {@code false}:Targeted Cadence Configuration Supported
     */
    public boolean isTargetSettingFeaturesTargetedCadenceConfigurationNotSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Targeted Cadence Configuration Supported, {@code false}:Targeted Cadence Configuration not Supported
     */
    public boolean isTargetSettingFeaturesTargetedCadenceConfigurationSupported() {
        return isTargetSettingFeaturesMatched(TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_MASK, TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_TRUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[8];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mFitnessMachineFeatures);
        byteBuffer.put(mTargetSettingFeatures);
        return data;
    }

    /**
     * check Fitness Machine Features
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_TRUE}
     *               , {@link #FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE}
     *               , {@link #FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFitnessMachineFeaturesMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt32(mFitnessMachineFeatures, 0)) == expect;
    }

    /**
     * check Fitness Machine Features
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_TRUE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE}
     *               , {@link #TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isTargetSettingFeaturesMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt32(mTargetSettingFeatures, 0)) == expect;
    }

}
